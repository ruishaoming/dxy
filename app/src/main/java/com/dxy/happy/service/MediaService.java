package com.dxy.happy.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.dxy.happy.app.XnlApplication;
import com.dxy.happy.utils.LogUtils;

import java.io.IOException;

import static com.dxy.happy.app.XnlApplication.mediaIsPalying;

public class MediaService extends Service {

    private MediaPlayer mediaPlayer;
    private String currentMediaName = "";
    private OnMediaPalyListener onMediaPalyListener;
    private int duration;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MediaBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    //播放音乐
    public void play(String path) {
        if (mediaPlayer == null) {
            return;
        }
        if (!currentMediaName.equals(path)) {
            stop();//先将之前的音频停止并重置
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentMediaName = path;
        }
        mediaPlayer.start();
        mediaIsPalying = true;
        mediaSettings();
    }

    //对进行一些设置
    private void mediaSettings() {
        duration = mediaPlayer.getDuration();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (onMediaPalyListener != null) {
                        //将当前音频的总时长、进度返回
                        onMediaPalyListener.setDurtion(duration);
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        onMediaPalyListener.setCurrentPosition(currentPosition);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //音频播放完毕
                    if (!mediaPlayer.isPlaying()) {
                        break;
                    }
                }
            }
        }).start();
    }

    //暂停播放
    public void pause() {
        if (mediaPlayer != null)
            mediaPlayer.pause();
        mediaIsPalying = false;
    }

    //停止播放
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaIsPalying = false;
        }
    }

    //定义接口
    public interface OnMediaPalyListener {
        void setDurtion(int durtion);

        void setCurrentPosition(int position);
    }

    //第三者（Activity与Service的交互）
    public class MediaBinder extends Binder {
        public void bPlay(String path) {
            play(path);
        }

        public void bPause() {
            pause();
        }

        public void bStop() {
            stop();
        }

        public void setOnMediaPalyListener(OnMediaPalyListener onMediaPalyListener) {
            MediaService.this.onMediaPalyListener = onMediaPalyListener;
        }

        //设置音乐播放到当前位置
        public void setMediaCurrent(int progress) {
            mediaPlayer.seekTo(progress);
        }

    }
}
