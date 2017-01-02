package com.dxy.happy.base;

import android.os.Bundle;
import android.view.KeyEvent;

import com.dxy.happy.R;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * BaseActivity：项目所有Activity的父类
 * create:芮靖林
 * on：201612/28
 */
public class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            overridePendingTransition(R.animator.xin_left, R.animator.xout_right);
        }
        return super.onKeyDown(keyCode, event);
    }
}
