package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

public class LoveGasActivity extends BaseActivity {

    private WebView home_lovegas_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_gas);
        home_lovegas_webview = (WebView) findViewById(R.id.home_lovegas_webview);
        String url = getIntent().getStringExtra("url");
        home_lovegas_webview.loadUrl(url);
    }
}
