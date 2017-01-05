package com.dxy.happy.Hoder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.view.MyListView;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyChooseCareerViewHolder extends RecyclerView.ViewHolder {

    public final TextView choose_career_title;
    public final LinearLayout choose_career_item;
    public final MyListView choose_career_lv;

    public MyChooseCareerViewHolder(View itemView) {
        super(itemView);
        choose_career_title = (TextView) itemView.findViewById(R.id.choose_career_title);
        choose_career_item = (LinearLayout) itemView.findViewById(R.id.choose_career_item);
        choose_career_lv = (MyListView) itemView.findViewById(R.id.choose_career_lv);
    }
}
