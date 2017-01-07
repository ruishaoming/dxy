package com.dxy.happy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;

import com.dxy.happy.Hoder.MyChooseCareerViewHolder;
import com.dxy.happy.R;
import com.dxy.happy.activity.BasicInformationActivity;
import com.dxy.happy.bean.ChooseCareerBean;
import com.dxy.happy.interfaces.OnItemClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyChooseCareerAdapter extends RecyclerView.Adapter<MyChooseCareerViewHolder> {
    Context context;
   List<ChooseCareerBean.DataBean> dataList;
    private OnItemClickListener onItmeClickListener;

    public MyChooseCareerAdapter(Context context, List<ChooseCareerBean.DataBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItmeClickListener = onItemClickListener;

    }
    int lastPosition = -1;

    public void startAnimation(View view, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.translate);
            view.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public MyChooseCareerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = View.inflate(context, R.layout.holder_choosecareer, null);
        View view = LayoutInflater.from(context).inflate(R.layout.holder_choosecareer, parent, false);
        MyChooseCareerViewHolder holder = new MyChooseCareerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyChooseCareerViewHolder holder, final int position) {
        holder.choose_career_title.setText(dataList.get(position).getTitle());
        holder.choose_career_lv.setAdapter(new MyLvAdapter(context,dataList.get(position).getChildren()));
        holder.choose_career_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (onItmeClickListener!=null){
                onItmeClickListener.onItemClick(position);
            }
            }
        });
        holder.choose_career_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,BasicInformationActivity.class);
                intent.putExtra("title",dataList.get(position).getChildren().get(position).getTitle());
                context.startActivity(intent);
            }
        });
        startAnimation(holder.choose_career_item,position);

    }

    @Override
    public void onViewDetachedFromWindow(MyChooseCareerViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.choose_career_item.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
