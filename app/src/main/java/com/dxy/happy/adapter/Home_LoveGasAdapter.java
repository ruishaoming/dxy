package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dxy.happy.Hoder.Holder_LoveGasMore;
import com.dxy.happy.R;
import com.dxy.happy.bean.LoveGasMoreBean;
import com.dxy.happy.utils.CommonUtils;

/**
 * Created by 韩永光
 * on 2017/1/5 21:33.
 */
public class Home_LoveGasAdapter extends RecyclerView.Adapter<Holder_LoveGasMore> {

    private final Context context;
    private final LoveGasMoreBean loveGasMoreBean;

    public Home_LoveGasAdapter(Context context, LoveGasMoreBean loveGasMoreBean) {
        this.context =context;
        this.loveGasMoreBean =loveGasMoreBean;

    }

    @Override
    public Holder_LoveGasMore onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = CommonUtils.inflate(R.layout.lovegas_item);
        Holder_LoveGasMore holder_loveGasMore = new Holder_LoveGasMore(view);
        return holder_loveGasMore;
    }

    @Override
    public void onBindViewHolder(Holder_LoveGasMore holder, int position) {
        Glide.with(context).load(loveGasMoreBean.getData().get(position).getImg()).into(holder.img_loveGas);

    }

    @Override
    public int getItemCount() {
        return loveGasMoreBean.getData().size();
    }
}
