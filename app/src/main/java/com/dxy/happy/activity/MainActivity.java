package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.fragment.Home_Fragment;
import com.xnl.happy.R;

/**
 * MainActivity：项目主界面
 * create:芮靖林
 * on：201612/28
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ViewPager main_viewpager= (ViewPager) findViewById(R.id.main_viewpager);
        main_viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Home_Fragment homeFragment = new Home_Fragment();
                return homeFragment;
            }

            @Override
            public int getCount() {
                return 1;
            }
        });
    }
}
