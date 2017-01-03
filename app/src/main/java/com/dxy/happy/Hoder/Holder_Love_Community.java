package com.dxy.happy.Hoder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.bean.Fragment_LoveCommunityBean;
import com.dxy.happy.utils.CommonUtils;
import com.google.gson.Gson;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

import com.dxy.happy.Hoder.BaseHolder;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Love_Community extends BaseHolder {

    private final ViewPager viewpager_lc;
    private ArrayList<Fragment_LoveCommunityBean.DataBean> arrayList1;
    private ArrayList<Fragment_LoveCommunityBean.DataBean> arrayList2;
    private ArrayList<Fragment_LoveCommunityBean.DataBean> arrayList3;
    private ArrayList<Fragment_LoveCommunityBean.DataBean> arrayList4;

    public Holder_Love_Community(View itemView) {
        super(itemView);
        viewpager_lc = (ViewPager) itemView.findViewById(R.id.viewpager_lc);
    }

    @Override
    public void getHolder(final Context context, final Object o) {
        String o1 = (String) o;
        final Fragment_LoveCommunityBean fragment_loveCommunityBean = new Gson().fromJson(o1, Fragment_LoveCommunityBean.class);
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
        final ArrayList<ArrayList<Fragment_LoveCommunityBean.DataBean>> listAll = new ArrayList<>();
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

                CommonAdapter<Fragment_LoveCommunityBean.DataBean> commonAdapter = new CommonAdapter<Fragment_LoveCommunityBean.DataBean>(context, R.layout.item_listview_lc, listAll.get(dataposition)) {
                    @Override
                    protected void convert(ViewHolder viewHolder, Fragment_LoveCommunityBean.DataBean item, int position) {
                        viewHolder.setText(R.id.tv_lc, item.getTitle());
                        ImageView img_lc = viewHolder.getView(R.id.img_lc);
                        Glide.with(context).load(item.getImg()).into(img_lc);
                    }
                };
                listview_lc.setAdapter(commonAdapter);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

    }
}
