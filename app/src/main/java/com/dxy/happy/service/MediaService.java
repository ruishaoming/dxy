package com.dxy.happy.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.dxy.happy.app.XnlApplication;

import java.io.IOException;

import static com.dxy.happy.app.XnlApplication.mediaIsPalying;

public class MediaService extends Service {

    private MediaPlayer mediaPlayer;
    private String currentMediaName = "";

    public MediaService() {
    }

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
            mediaPlayer.reset();
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
    }
}
