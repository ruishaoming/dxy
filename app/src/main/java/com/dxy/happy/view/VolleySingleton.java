package com.dxy.happy.view;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by 乔智锋
 * on 2016/12/28 19:40.
 */

public class VolleySingleton {
    private static volatile VolleySingleton singleton;

    private VolleySingleton() {

    }

    public static VolleySingleton getInStance() {

        if (singleton == null) {

            synchronized (VolleySingleton.class) {

                if (singleton == null) {
                    singleton = new VolleySingleton();
                }
            }
        }
        return singleton;
    }

    public void getUrl(String url, Context context, final ResuleCallBack resuleCallBack) {
        //声明一个队列
        RequestQueue Queue = Volley.newRequestQueue(context);
        //接口回调
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                resuleCallBack.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                resuleCallBack.onErrorResponse(volleyError);
            }
        });
        Queue.add(stringRequest);
    }

    public static abstract class ResuleCallBack {
        //成功时回调的方法
        public abstract void onResponse(String reresponse);

        //失败时回调的方法
        public abstract void onErrorResponse(VolleyError error);

    }
}