package com.dxy.happy.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

public class HomeFestivalActivity extends BaseActivity {

    private WebView home_festival_webview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_festival);
        home_festival_webview2 = (WebView) findViewById(R.id.home_festival_webview2);
        String url = getIntent().getStringExtra("url");
        home_festival_webview2.loadUrl(url);


    }
}
