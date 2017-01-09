package com.dxy.happy.Hoder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.activity.LoveGasActivity;
import com.dxy.happy.bean.LoveGasMoreBean;

/**
 * Created by 韩永光
 * on 2017/1/5 21:27.
 */
public class Holder_LoveGasMore extends BaseHolder {

    public ImageView img_loveGas;
    private final TextView tv_title;
    private final TextView  tv_des;

    public Holder_LoveGasMore(View itemView) {
        super(itemView);
        img_loveGas = (ImageView) itemView.findViewById(R.id.img_loveGas);
        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        tv_des = (TextView) itemView.findViewById(R.id.tv_des);
    }

    @Override
    public void getHolder(final Context context, Object o) {
        final LoveGasMoreBean.DataBean o1 = (LoveGasMoreBean.DataBean) o;
        Glide.with(context).load(o1.getImg()).into(img_loveGas);
        tv_title.setText(o1.getTitle());
        tv_des.setText(o1.getClick()+"阅读    "+o1.getReplyTimes()+"评论      "+o1.getStar()+"点赞");

        img_loveGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, LoveGasActivity.class);
                intent.putExtra("url",o1.getUrl());
                context.startActivity(intent);
            }
        });

    }


}
