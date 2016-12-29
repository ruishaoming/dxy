package com.dxy.happy.base;

import android.os.Bundle;

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
}
