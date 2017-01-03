package com.dxy.happy.Hoder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.bean.Fragment_KnowBean;
import com.google.gson.Gson;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Know extends BaseHolder {

    private final ImageView img_know;

    public Holder_Know(View itemView) {
        super(itemView);
        img_know = (ImageView) itemView.findViewById(R.id.img_know);
    }

    @Override
    public void getHolder(Context context, Object o) {
        String o1 = (String) o;
        Fragment_KnowBean fragment_knowBean = new Gson().fromJson(o1, Fragment_KnowBean.class);
        Glide.with(context).load(fragment_knowBean.getData().get(0).getImg()).into(img_know);
        img_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
