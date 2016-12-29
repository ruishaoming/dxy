package com.dxy.happy.Hoder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.dxy.happy.adapter.Home_Fragment_ViewPagerAdapter;
import com.dxy.happy.bean.Fragment_ViewPagerBean;
import com.dxy.happy.R;

import java.util.List;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_ViewPager extends BaseHolder {

    public ViewPager home_fragment_viewpager;

    public Holder_ViewPager(View itemView) {
        super(itemView);
        home_fragment_viewpager = (ViewPager) itemView.findViewById(R.id.home_fragment_viewpager);

    }

    @Override
    public void getHolder(Context context, Object o) {
        List<Fragment_ViewPagerBean.DataBean> vpList = (List<Fragment_ViewPagerBean.DataBean>) o;
        Home_Fragment_ViewPagerAdapter adapter=new Home_Fragment_ViewPagerAdapter(context,vpList);
        home_fragment_viewpager.setAdapter(adapter);
    }
}
