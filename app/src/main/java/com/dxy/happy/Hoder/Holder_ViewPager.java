package com.dxy.happy.Hoder;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dxy.happy.R;
import com.dxy.happy.adapter.Home_ViewPagerAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.Fragment_ViewPagerBean;
import com.google.gson.Gson;

import static com.dxy.happy.R.mipmap.navpoint_selected2x;
import static com.dxy.happy.R.mipmap.navpoint_unselected2x;


/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_ViewPager extends BaseHolder {

    private ViewPager home_fragment_viewpager;
    private LinearLayout home_fragment_ll;
    private ImageView img;


    public Holder_ViewPager(View itemView) {
        super(itemView);
        home_fragment_viewpager = (ViewPager) itemView.findViewById(R.id.home_fragment_viewpager);
        home_fragment_ll = (LinearLayout) itemView.findViewById(R.id.home_fragment_ll);
    }

    @Override
    public void getHolder(final Context context, Object o) {
        String url = (String) o;
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                initVpData(reresponse,context);
            }
        }.getData(url, BaseData.NORMALTIME);
    }

    private void initVpData(String reresponse, Context context) {
        Fragment_ViewPagerBean fragment_viewPagerBean = new Gson().fromJson(reresponse, Fragment_ViewPagerBean.class);
        Home_ViewPagerAdapter adapter = new Home_ViewPagerAdapter(context, fragment_viewPagerBean.getData());
        //设置pager间 间距
        home_fragment_viewpager.setPageMargin(10);
        //设置缓存的页面数量
        home_fragment_viewpager.setOffscreenPageLimit(3);

        home_fragment_viewpager.setAdapter(adapter);
        //设置默认显示页
        home_fragment_viewpager.setCurrentItem(1);
        //viewpager特效设置
        setViewPagerAnimtion();
        //小点设置
        home_fragment_ll.removeAllViews();
        for (int i = 0; i < 5; i++) {

            img = new ImageView(context);
            if (i == 0) {
                img.setImageResource(navpoint_selected2x);
            } else {
                img.setImageResource(navpoint_unselected2x);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(5, 10, 5, 10);
            home_fragment_ll.addView(img, layoutParams);
        }
        home_fragment_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < home_fragment_ll.getChildCount(); i++) {
                    ImageView childAt = (ImageView) home_fragment_ll.getChildAt(i);
                    if (i == position % 5) {
                        childAt.setImageResource(navpoint_selected2x);

                    } else {
                        childAt.setImageResource(navpoint_unselected2x);
                    }

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setViewPagerAnimtion() {
        home_fragment_viewpager.setPageTransformer(false, new ViewPager.PageTransformer() {
            private static final float MIN_SCALE = 0.90f;
            private static final float MIN_ALPHA = 0.5f;

            @Override
            public void transformPage(View page, float position) {
                if (position < -1 || position > 1) {
                    page.setAlpha(MIN_ALPHA);
                    page.setScaleX(MIN_SCALE);
                    page.setScaleY(MIN_SCALE);
                } else if (position <= 1) { // [-1,1]
                    float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                    if (position < 0) {
                        float scaleX = 1 + 0.3f * position;
                        page.setScaleX(scaleX);
                        page.setScaleY(scaleX);
                    } else {
                        float scaleX = 1 - 0.3f * position;
                        page.setScaleX(scaleX);
                        page.setScaleY(scaleX);
                    }
                    page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                }
            }
        });
    }


}
