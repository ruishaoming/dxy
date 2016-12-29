package com.dxy.happy.bean;

/**
 * Created by 乔智锋
 * on 2016/12/28 20:45.
 */

public class DataBean {
    private String path;
    private String data;
    private String time;

    public DataBean(String path, String data, String time) {
        this.path = path;
        this.data = data;
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
