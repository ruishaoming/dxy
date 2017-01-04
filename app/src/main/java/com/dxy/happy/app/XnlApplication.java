package com.dxy.happy.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import com.dxy.happy.view.VolleySingleton;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 程序入口：做初始化操作
 * Created by ${芮靖林}
 * on 2016/12/28 08:27.
 */

public class XnlApplication extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadId;
    private static ExecutorService threadPool;
    public static boolean isLogin = false;//判定是否登录
    public static VolleySingleton inStance;
    public static boolean mediaIsPalying = false;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();//创建Handle
        mainThreadId = Process.myTid();//得到主线程id
        threadPool = Executors.newFixedThreadPool(5);//创建线程池
        //使用Volley
        inStance = VolleySingleton.getInStance();
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        UMShareAPI.get(this);
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static ExecutorService getThreadPool() {
        return threadPool;
    }
}
