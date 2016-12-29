package com.dxy.happy.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.factory.FragmentFactory;
import com.dxy.happy.fragment.Community_Fragment;
import com.dxy.happy.fragment.Home_Fragment;
import com.dxy.happy.fragment.Mine_Fragment;
import com.dxy.happy.utils.LogUtils;
import com.dxy.happy.view.NoScrollViewPager;
import com.xnl.happy.R;

import java.util.ArrayList;

/**
 * MainActivity：项目主界面
 * create:芮靖林
 * on：201612/28
 */
public class MainActivity extends BaseActivity {

    public static final String TAG = "TAG";
    private RadioGroup radioGroup;
    private NoScrollViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewPager();
    }

    //初始化ViewPager
    private void initViewPager() {
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return FragmentFactory.getFragment(position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton rb = (RadioButton) radioGroup.getChildAt(i);
                    if (rb.getId() == checkedId) {
                        rb.setTextColor(getResources().getColor(R.color.main_bottom_tv_check));
                        vp.setCurrentItem(i);
                    } else {
                        rb.setTextColor(Color.BLACK);
                    }
                }
            }
        });
    }

    //初始化布局
    private void initViews() {
        radioGroup = (RadioGroup) findViewById(R.id.main_bottom_rg);
        vp = (NoScrollViewPager) findViewById(R.id.main_vp);
    }

    private long waitTime = 1200;
    private long touchTime = 0;

    //监听程序退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                Toast.makeText(MainActivity.this, "再按一次退出...", Toast.LENGTH_SHORT).show();
                touchTime = currentTime;
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
