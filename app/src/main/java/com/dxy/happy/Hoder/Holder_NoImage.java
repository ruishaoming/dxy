package com.dxy.happy.Hoder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.bean.ForumTop_Bean;
import com.zhy.autolayout.AutoLinearLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 张天成
 * on 2017/1/2 18:42.
 */
public class Holder_NoImage extends BaseHolder {

    public ImageView image;
    public ImageView image2;
    public ImageView image3;
    public TextView text_time;
    public TextView text_name;
    public TextView text_content;
    public TextView text_title;
    public TextView text_count;
    public AutoLinearLayout lin_all;
    private final LinearLayout line_image;

    public Holder_NoImage(View itemView) {
        super(itemView);

        text_title = (TextView) itemView.findViewById(R.id.community_title);
        text_content = (TextView) itemView.findViewById(R.id.community_content);
        text_name = (TextView) itemView.findViewById(R.id.community_name);
        text_time = (TextView) itemView.findViewById(R.id.community_time);
        text_count = (TextView) itemView.findViewById(R.id.community_number);
        line_image = (LinearLayout) itemView.findViewById(R.id.all_ll);
        lin_all = (AutoLinearLayout) itemView.findViewById(R.id.lin_all);
    }

    @Override
    public void getHolder(Context context, Object o) {

        ForumTop_Bean.DataBean data = (ForumTop_Bean.DataBean) o;
        text_name.setText(data.getUserName());
        text_title.setText(data.getTitle());
        if (data.getContent().length()>20){
            text_content.setText(data.getContent().substring(0,20)+"....");
        }
        Date d = new Date(data.getTopTime());//"yyyy-MM-dd hh:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm");
        text_count.setText(data.getReplyTimes()+"");
        text_time.setText(sdf.format(d));
        line_image.removeAllViews();
        if (data.getImgs() != null && data.getImgs().size() > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
            layoutParams.setMargins(10,0,0,0);
            for (int i = 0; i < data.getImgs().size(); i++) {
                ImageView imageView = new ImageView(context);
                Glide.with(context).load(data.getImgs().get(i).getMiniImg()).into(imageView);
                line_image.addView(imageView, layoutParams);
            }
        }
    }

}
