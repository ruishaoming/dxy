package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.Fragment_LoveCommunityBean;
import com.dxy.happy.bean.HomeCommunityBean;
import com.google.gson.Gson;

import java.util.List;

public class HomeCommunityActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_community);
        int id = getIntent().getIntExtra("id", 0);
        final List<Fragment_LoveCommunityBean.DataBean> data = (List<Fragment_LoveCommunityBean.DataBean>) getIntent().getSerializableExtra("data");
        String url = "http://www.yulin520.com/a2a/forumReply/detailedShow?pageSize=10&id=" + id + "&sign=8783406554DDD2920DC61FAC5F6A7811&sort=1&ts=1768501243&page=1";
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                HomeCommunityBean homeCommunityBean =   new Gson().fromJson(reresponse, HomeCommunityBean.class);


            }
        }.getData(url, BaseData.NORMALTIME);


    }
}
