package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dxy.happy.R;
import com.dxy.happy.adapter.Home_LoveGasAdapter;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.LoveGasMoreBean;
import com.dxy.happy.utils.URLUtils;
import com.google.gson.Gson;

public class HomeMoreActivity extends BaseActivity {

    private RecyclerView lovegas_recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_more);
        initView();
        initRecycleView();
    }

    private void initRecycleView() {

        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                LoveGasMoreBean loveGasMoreBean = new Gson().fromJson(reresponse, LoveGasMoreBean.class);
                lovegas_recycleView.setLayoutManager(new LinearLayoutManager(HomeMoreActivity.this));
                Home_LoveGasAdapter adapter=new Home_LoveGasAdapter(HomeMoreActivity.this,loveGasMoreBean);
                lovegas_recycleView.setAdapter( adapter);
            }
        }.getData(URLUtils.url_more,BaseData.NORMALTIME);
    }

    private void initView() {
        lovegas_recycleView = (RecyclerView) findViewById(R.id.lovegas_recycleView);
    }
}
