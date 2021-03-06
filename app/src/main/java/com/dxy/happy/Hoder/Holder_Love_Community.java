package com.dxy.happy.Hoder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.activity.Froum_Xq_Activity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.ForumTop_Bean;
import com.dxy.happy.utils.CommonUtils;
import com.google.gson.Gson;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Love_Community extends BaseHolder {

    private final ViewPager viewpager_lc;
    private ArrayList<ForumTop_Bean.DataBean> arrayList1;
    private ArrayList<ForumTop_Bean.DataBean> arrayList2;
    private ArrayList<ForumTop_Bean.DataBean> arrayList3;
    private ArrayList<ForumTop_Bean.DataBean> arrayList4;

    public Holder_Love_Community(View itemView) {
        super(itemView);
        viewpager_lc = (ViewPager) itemView.findViewById(R.id.viewpager_lc);
    }

    @Override
    public void getHolder(final Context context, final Object o) {
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "!~!~!~!~!~", Toast.LENGTH_SHORT).show();
//            }
//        });
        String url = (String) o;
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                initData(reresponse, context);
            }
        }.getData(url,BaseData.NORMALTIME);

    }

    private void initData(String reresponse, final Context context) {
        final ForumTop_Bean fragment_loveCommunityBean = new Gson().fromJson(reresponse, ForumTop_Bean.class);
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList4 = new ArrayList<>();
        for (int i = 0; i < fragment_loveCommunityBean.getData().size(); i++) {
            if (i < 3) {
                arrayList1.add(fragment_loveCommunityBean.getData().get(i));
            } else if (i > 2 && i < 6) {
                arrayList2.add(fragment_loveCommunityBean.getData().get(i));
            } else if (i > 5 && i < 9) {
                arrayList3.add(fragment_loveCommunityBean.getData().get(i));
            } else if (i > 8 && i < 12) {
                arrayList4.add(fragment_loveCommunityBean.getData().get(i));
            }
        }
        final ArrayList<ArrayList<ForumTop_Bean.DataBean>> listAll = new ArrayList<>();
        listAll.add(arrayList1);
        listAll.add(arrayList2);
        listAll.add(arrayList3);
        listAll.add(arrayList4);
        viewpager_lc.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return fragment_loveCommunityBean.getData().size() / 3;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int dataposition) {
                View view = CommonUtils.inflate(R.layout.viewpager_lc);

                ListView listview_lc = (ListView) view.findViewById(R.id.listview_lc);

                CommonAdapter<ForumTop_Bean.DataBean> commonAdapter = new CommonAdapter<ForumTop_Bean.DataBean>(context, R.layout.item_listview_lc, listAll.get(dataposition)) {
                    @Override
                    protected void convert(ViewHolder viewHolder, ForumTop_Bean.DataBean item, int position) {
                        viewHolder.setText(R.id.tv_lc, item.getTitle());
                        ImageView img_lc = viewHolder.getView(R.id.img_lc);
                        Glide.with(context).load(item.getImg()).into(img_lc);
                    }
                };
                listview_lc.setAdapter(commonAdapter);
                container.addView(view);
                listview_lc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //天成接收的详情页 集合bean和ID
                        final Intent intent=new Intent(context, Froum_Xq_Activity.class);
                        int id1 = fragment_loveCommunityBean.getData().get(position).getId();
                        intent.putExtra("id",id1);
                        List<ForumTop_Bean.DataBean> data = fragment_loveCommunityBean.getData();
                        intent.putExtra("data2",  data.get(position));
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    sleep(500);
                                    context.startActivity(intent);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }.start();

                    }
                });
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }
}