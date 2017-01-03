package com.dxy.happy.Hoder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.bean.Fragment_FestivalBean;
import com.google.gson.Gson;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_festival extends BaseHolder {

    private final ImageView img_festival;
    private final TextView tv_festival;
    private final TextView tv_day_festival;

    public Holder_festival(View itemView) {
        super(itemView);
        img_festival = (ImageView) itemView.findViewById(R.id.img_festival);
        tv_festival = (TextView) itemView.findViewById(R.id.tv_festival);
        tv_day_festival = (TextView) itemView.findViewById(R.id.tv_day_festival);
    }

    @Override
    public void getHolder(Context context, Object o) {
        String o1 = (String) o;
        Fragment_FestivalBean fragment_festivalBean = new Gson().fromJson(o1, Fragment_FestivalBean.class);
//        Glide.with(context).load(fragment_festivalBean.getData().getImg()).into(img_festival);
    }
}
