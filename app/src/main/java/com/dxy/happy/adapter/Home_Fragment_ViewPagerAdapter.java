package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dxy.happy.bean.Fragment_ViewPagerBean;

import java.util.List;

/**
 * Created by 韩永光
 * on 2016/12/29 14:49.
 */
public class Home_Fragment_ViewPagerAdapter extends PagerAdapter {

    private final Context context;
    private final List<Fragment_ViewPagerBean.DataBean> vpList;

    public Home_Fragment_ViewPagerAdapter(Context context, List<Fragment_ViewPagerBean.DataBean> vpList) {
        this.context =context;
        this.vpList =vpList;
    }

    @Override
    public int getCount() {
        return vpList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img=new ImageView(context);
        Glide.with(context).load(vpList.get(position).getImg()).into(img);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
