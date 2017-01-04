package com.dxy.happy.bean;

/**
 * Created by 吕卓钊
 * on 2016/12/29 21:46.
 */

public class Userbean {
    private String name;
    private String pwd;

    public Userbean(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
