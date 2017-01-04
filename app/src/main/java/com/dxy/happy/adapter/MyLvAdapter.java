package com.dxy.happy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.bean.ChooseCareerBean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyLvAdapter extends BaseAdapter {
    Context context;
    List<ChooseCareerBean.DataBean.ChildrenBean> list;
    private LinearLayout lv_item;
    int lastPosition = -1;

    public MyLvAdapter(Context context, List<ChooseCareerBean.DataBean.ChildrenBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.mylv_item, null);
        TextView mylv_tv = (TextView) view.findViewById(R.id.mylv_tv);
        lv_item = (LinearLayout) view.findViewById(R.id.lv_item);
        mylv_tv.setText(list.get(position).getTitle());
        startAnimation(lv_item,position);
        return view;
    }

    private void startAnimation(View views, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.translate);
           views.startAnimation(animation);
            lastPosition = position;
        }
    }

}
