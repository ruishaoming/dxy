package com.dxy.happy.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.base.BaseShowingPageActivity;
import com.dxy.happy.bean.DataBean;
import com.dxy.happy.bean.Fragment_ViewPagerBean;
import com.dxy.happy.service.MediaService;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.LogUtils;
import com.dxy.happy.view.ShowingPage;

import static com.dxy.happy.app.XnlApplication.mediaIsPalying;

/**
 * 音乐播放
 * Created by 芮靖林
 * on 2016/12/29 10:40.
 */
public class MediaActivity extends BaseShowingPageActivity implements View.OnClickListener {

    private View rootView;
    public static Fragment_ViewPagerBean.DataBean media;
    private ImageView iv_bg;
    private WebView webView;
    private MediaService.MediaBinder mediaBinder;
    //获取服务连接
    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mediaBinder = (MediaService.MediaBinder) service;
            mediaBinder.bPlay(media.getUrl());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onLoad() {
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        rootView = CommonUtils.inflate(R.layout.activity_media);
        initViews();
        return rootView;
    }

    //初始化控件
    private void initViews() {
        iv_bg = (ImageView) rootView.findViewById(R.id.media_iv);
        webView = (WebView) rootView.findViewById(R.id.media_webView);
        iv_bg.setOnClickListener(this);
        media = (Fragment_ViewPagerBean.DataBean) getIntent().getSerializableExtra("media");
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initMediaService();
                        Glide.with(MediaActivity.this).load(media.getImg()).into(iv_bg);
                        iv_bg.setScaleType(ImageView.ScaleType.FIT_XY);
                        webView.loadUrl(media.getDetailsUrl());
                        webView.setWebViewClient(new WebViewClient() {
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                view.loadUrl(url);
                                return true;
                            }
                        });
                    }
                });
            }
        }).start();
    }

    private void initMediaService() {
        Intent intent = new Intent(this, MediaService.class);
        startService(intent);
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //暂停
            case R.id.media_iv:
                if (mediaIsPalying) {
                    mediaBinder.bPause();
                } else {
                    mediaBinder.bPlay(media.getUrl());
                }
                break;
        }
    }

    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        finish();//结束退出程序
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (conn != null) {
            unbindService(conn);
            conn = null;
        }
    }
}
