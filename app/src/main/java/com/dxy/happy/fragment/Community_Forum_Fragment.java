package com.dxy.happy.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.view.ShowingPage;
import com.xnl.happy.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;

/**
 * Created by 张天成
 * on 2016/12/28 19:53.
 */
public class Community_Forum_Fragment extends BaseFragment {

    private ListView listView_forum;
    int[] image_Forum=new int[]{R.mipmap.forum_section_first_logo,R.mipmap.forum_section_second_logo,R.mipmap.forum_section_third_logo,R.mipmap.forum_section_four_logo,R.mipmap.forum_section_five_logo};
    private ArrayList<String> list_text_tetile;


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
    }

    private void initData() {
        CommonAdapter<String> commonAdapter = new CommonAdapter<String>(getActivity(), R.layout.community_forum_list_item, list_text_tetile) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                View view = viewHolder.getConvertView();
                ImageView iv = (ImageView) viewHolder.getView(R.id.image_title);
                iv.setImageResource(image_Forum[position]);
                TextView text_title = viewHolder.getView(R.id.text_title);
                text_title.setText(list_text_tetile.get(position));
            }
        };
        listView_forum.setAdapter(commonAdapter);
        }

}
