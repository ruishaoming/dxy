package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dxy.happy.Hoder.BaseHolder;
import com.dxy.happy.Hoder.Holder_Xq;
import com.dxy.happy.R;
import com.dxy.happy.bean.HomeCommunityBean;
import com.dxy.happy.utils.CommonUtils;

import java.util.List;

/**
 * Created by 张天成
 * on 2017/1/6 20:32.
 */
public class XqAdapter extends RecyclerView.Adapter<BaseHolder> {
     Context context;
    List<HomeCommunityBean.DataBean> data;

    public XqAdapter(Context context, List<HomeCommunityBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = CommonUtils.inflate(R.layout.layout_xq);
        BaseHolder holder = null;
        holder=new Holder_Xq(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.getHolder(context, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
