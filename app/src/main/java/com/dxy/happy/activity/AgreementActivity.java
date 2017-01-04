package com.dxy.happy.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class AgreementActivity extends BaseActivity implements View.OnClickListener {

    private WebView webView;
    private ImageView mine_return_back;
    private TextView mine_title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        mine_return_back = (ImageView) findViewById(R.id.mine_return_back);
        mine_return_back.setOnClickListener(this);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("协议内容");
        webView = (WebView) findViewById(R.id.webView);
        String webUrl = getIntent().getStringExtra("webUrl");
        webView.loadUrl(webUrl);
    }

    @Override
    public void onClick(View v) {
        CommonUtils.finishActivity(AgreementActivity.this);
    }
}
