package com.dxy.happy.activity;

import android.app.IntentService;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
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
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.SimpleDateFormat;

import static android.R.attr.duration;
import static android.R.attr.x;
import static com.dxy.happy.app.XnlApplication.mediaIsPalying;

/**
 * 音乐播放
 * Created by 芮靖林
 * on 2016/12/29 10:40.
 */
public class MediaActivity extends BaseShowingPageActivity implements View.OnClickListener {

    private static final String TAG = "TAG";
    private View rootView;
    public static Fragment_ViewPagerBean.DataBean media;
    private ImageView iv_bg;
    private WebView webView;
    private MediaService.MediaBinder mediaBinder;
    private ImageView anim_iv;
    private AutoFrameLayout media_fram;
    private AnimationDrawable animationDrawable;
    private ImageView iv_pause;
    private ImageView seek_pause;
    private SeekBar seekBar;
    private TextView durtion_tv;
    private TextView currentTime_tv;
    //获取服务连接
    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mediaBinder = (MediaService.MediaBinder) service;
            mediaBinder.bPlay(media.getUrl());
            mediaBinder.setOnMediaPalyListener(new MediaService.OnMediaPalyListener() {
                @Override
                public void setDurtion(final int durtion) {
                    seekBar.setMax(durtion);
                    MediaActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            durtion_tv.setText(getTime(durtion));
                        }
                    });
                }

                @Override
                public void setCurrentPosition(final int position) {
                    seekBar.setProgress(position);
                    MediaActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            currentTime_tv.setText(getTime(position));
                        }
                    });
                }
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    //分秒转换
    private String getTime(int durtion) {
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        return formatter.format(durtion);
    }

    @Override
    protected void onLoad() {
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        rootView = CommonUtils.inflate(R.layout.activity_media);
        initViews();
        initData();
        return rootView;
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MediaActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initMediaService();
                        Glide.with(MediaActivity.this).load(media.getImg()).into(iv_bg);
                        iv_bg.setScaleType(ImageView.ScaleType.FIT_XY);
                        webView.loadUrl(media.getDetailsUrl());//加载WebView
                        webView.setWebViewClient(new WebViewClient() {
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                view.loadUrl(url);
                                return true;
                            }
                        });
                        setIvAnim();
                        mediaSettinds();
                    }
                });
            }
        }).start();
    }

    //初始化控件
    private void initViews() {
        iv_bg = (ImageView) rootView.findViewById(R.id.media_iv);
        webView = (WebView) rootView.findViewById(R.id.media_webView);
        media_fram = (AutoFrameLayout) rootView.findViewById(R.id.media_fram);
        anim_iv = (ImageView) rootView.findViewById(R.id.media_iv_anim);
        iv_pause = (ImageView) rootView.findViewById(R.id.media_iv_pause);
        seek_pause = (ImageView) rootView.findViewById(R.id.media_iv_seek_pause);
        seekBar = (SeekBar) rootView.findViewById(R.id.media_seekBar);
        durtion_tv = (TextView) rootView.findViewById(R.id.media_tv_time_durtion);
        currentTime_tv = (TextView) rootView.findViewById(R.id.media_tv_time_current);
        media_fram.setOnClickListener(this);
        seek_pause.setOnClickListener(this);
        iv_bg.setOnClickListener(this);
        media = (Fragment_ViewPagerBean.DataBean) getIntent().getSerializableExtra("media");
    }


    //音频的相关设置
    private void mediaSettinds() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    //置位Media当前的播放位置
                    mediaBinder.setMediaCurrent(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //设置播放音频的动画
    private void setIvAnim() {
        anim_iv.setImageResource(R.drawable.mediaplay_animation);
        animationDrawable = (AnimationDrawable) anim_iv.getDrawable();
        animationDrawable.start();
    }

    //初始化播放音频
    private void initMediaService() {
        Intent intent = new Intent(this, MediaService.class);
        startService(intent);
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //暂停
            case R.id.media_fram:
            case R.id.media_iv_seek_pause:
            case R.id.media_iv:
                if (mediaIsPalying) {
                    stopMedia();
                } else {
                    startMedia();
                }
                break;
        }
    }

    //停止播放音频
    private void stopMedia() {
        iv_bg.setAlpha(0.7f);
        iv_pause.setVisibility(View.VISIBLE);
        anim_iv.setVisibility(View.GONE);
        mediaBinder.bPause();
        animationDrawable.stop();
        seek_pause.setImageResource(R.mipmap.button_pause);
    }

    //开始播放音频
    private void startMedia() {
        iv_bg.setAlpha(1.0f);
        seek_pause.setImageResource(R.mipmap.button_play);
        anim_iv.setVisibility(View.VISIBLE);
        iv_pause.setVisibility(View.GONE);
        mediaBinder.bPlay(media.getUrl());
        animationDrawable.start();
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
            //反注册绑定的服务
            unbindService(conn);
            conn = null;
        }
    }
}
