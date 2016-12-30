package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dxy.happy.bean.Fragment_ViewPagerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 韩永光
 * on 2016/12/29 14:49.
 */
public class Home_ViewPagerAdapter extends PagerAdapter implements View.OnClickListener {

    private final Context context;
    private final List<Fragment_ViewPagerBean.DataBean> vpList;
    private final ArrayList<String> imglist=new ArrayList<>();

    public Home_ViewPagerAdapter(Context context, List<Fragment_ViewPagerBean.DataBean> vpList) {
        this.context =context;
        this.vpList =vpList;
        for (int i = 0; i <vpList.size() ; i++) {
            imglist.add(vpList.get(i).getImg());
        }

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView img=new ImageView(context);
        Glide.with(context).load(vpList.get(position%vpList.size()).getImg()).into(img);

        Glide.with(context).load(vpList.get(position%vpList.size()).getImg()).into(img);
        img.setOnClickListener(this);//图片的点击
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public void onClick(View v) {

    }
}
