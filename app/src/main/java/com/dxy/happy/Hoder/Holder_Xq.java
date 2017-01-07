package com.dxy.happy.Hoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.dxy.happy.R;
import com.dxy.happy.bean.HomeCommunityBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 张天成
 * on 2017/1/6 20:57.
 */
public class Holder_Xq extends BaseHolder {

    private final ImageView imageView;
    private final TextView textView1;
    private final TextView textView2;
    private final TextView textView3;
    private final TextView text_context;


    public Holder_Xq(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image_tou_xq3);
        textView1 = (TextView) itemView.findViewById(R.id.year_xq3);
        textView2 = (TextView) itemView.findViewById(R.id.time_xq3);
        textView3 = (TextView) itemView.findViewById(R.id.text_View3);
        text_context = (TextView) itemView.findViewById(R.id.content_xq);

    }

    @Override
    public void getHolder(final Context context, Object o) {
        HomeCommunityBean.DataBean data = (HomeCommunityBean.DataBean) o;
        if (data!=null) {
            Glide.with(context).load(data.getHeadImg()).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    imageView.setImageDrawable(circularBitmapDrawable);
                }
            });
            textView1.setText(data.getUserName());
            Date d = new Date(data.getCreateTime());//"yyyy-MM-dd hh:mm:ss"
            SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm");
            textView2.setText(sdf.format(d));
            textView2.setText(data.getCreateTime() + "");
            textView3.setText(data.getFloor());
            text_context.setText(data.getContent());

        }
    }
}
