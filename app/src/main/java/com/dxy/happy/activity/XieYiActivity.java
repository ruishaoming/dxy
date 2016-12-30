package com.dxy.happy.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

/**
 * autour: 吕卓钊
 * date: 2016/12/30 16:30
 * update: 2016/12/30
 */

public class XieYiActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xie_yi);
        initview();
        initdata();
    }

    private void initdata() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.yulin520.com/a2a/h/i/yulin/agreement");
    }

    private void initview() {
        webView = (WebView) findViewById(R.id.xie_web);


    }
}
