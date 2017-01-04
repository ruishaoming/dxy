package com.dxy.happy.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.activity.Forum_Activity;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.view.ShowingPage;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

/**
 * Created by 张天成
 * on 2016/12/28 19:53.
 */
public class Community_Forum_Fragment extends BaseFragment {

    private ListView listView_forum;
    int[] image_Forum=new int[]{R.mipmap.forum_section_first_logo,
            R.mipmap.forum_section_second_logo,
            R.mipmap.forum_section_third_logo,
            R.mipmap.forum_section_four_logo,
            R.mipmap.forum_section_five_logo};
    private ArrayList<String> list_text_tetile;
    private ArrayList<String> list_text_tetile2;
    private ArrayList<String> list_text_tetile3;
    private ArrayList<Integer> list_id;
    @Override
    protected void onLoad() {
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        View view= CommonUtils.inflate(R.layout.community_forum_fragment_);
        listView_forum = (ListView) view.findViewById(R.id.listView_Forum);
        initInte();
        initData();
        return view;
    }
    private void initInte() {
        list_text_tetile = new ArrayList<>();
        list_text_tetile.add("你的月亮我的心");
        list_text_tetile.add("恋爱害羞事");
        list_text_tetile.add("约会必杀技");
        list_text_tetile.add("主要看颜值");
        list_text_tetile.add("恋爱直播间");
        list_text_tetile2 = new ArrayList<>();
        list_text_tetile2.add("2775条帖子");
        list_text_tetile2.add("1242条帖子");
        list_text_tetile2.add("1132条帖子");
        list_text_tetile2.add("792条帖子");
        list_text_tetile2.add("266条帖子");
        list_text_tetile3 = new ArrayList<>();
        list_text_tetile3.add("最走心的情感答疑电台");
        list_text_tetile3.add("春风十里不如睡你");
        list_text_tetile3.add("约会套路一网打尽");
        list_text_tetile3.add("不整容,颜值照样up");
        list_text_tetile3.add("八卦?狗血?全都有");
        list_id=new ArrayList<>();
        list_id.add(10);
        list_id.add(11);
        list_id.add(12);
        list_id.add(13);
        list_id.add(14);
    }

    private void initData() {
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(getActivity(), R.layout.community_forum_list_item, list_text_tetile) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                View view = viewHolder.getConvertView();
                ImageView iv = (ImageView) viewHolder.getView(R.id.image_title);
                iv.setImageResource(image_Forum[position]);
                TextView text_title = viewHolder.getView(R.id.text_title);
                TextView text_count = viewHolder.getView(R.id.text_count);
                text_count.setText(list_text_tetile2.get(position));
                text_title.setText(list_text_tetile.get(position));

            }
        };
        listView_forum.setAdapter(commonAdapter);
        listView_forum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(getActivity(), Forum_Activity.class);
                in.putExtra("image",image_Forum[position]);
                in.putExtra("title_name",list_text_tetile.get(position));
                in.putExtra("title_name2",list_text_tetile3.get(position));
                in.putExtra("id",list_id.get(position));
                startActivity(in);
            }
        });
    }

}
