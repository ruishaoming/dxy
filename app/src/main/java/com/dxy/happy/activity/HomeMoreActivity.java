package com.dxy.happy.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dxy.happy.R;
import com.dxy.happy.adapter.Home_LoveGasAdapter;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.LoveGasMoreBean;
import com.dxy.happy.listen.OnLoadMoreListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeMoreActivity extends BaseActivity {
    int page = 2;
    String url = "http://www.yulin520.com/a2a/news/sd/list?sign=4508DEDF231D4E571E987BBE7C6CAB28&ts=1145666944&pageSize=10&page=";
    private RecyclerView lovegas_recycleView;
    private SwipeRefreshLayout srlayout;
    private Home_LoveGasAdapter adapter;
    private boolean isLoading = false;

    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItemPosition;
    private LoveGasMoreBean loveGasMoreBean;
    ArrayList<LoveGasMoreBean.DataBean> listAll = new ArrayList<LoveGasMoreBean.DataBean>();
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (adapter == null) {
                adapter = new Home_LoveGasAdapter(HomeMoreActivity.this, listAll);
                lovegas_recycleView.setAdapter(adapter);
            } else {
                adapter.notifyDataSetChanged();
            }
            lovegas_recycleView.addOnScrollListener(new OnLoadMoreListener(linearLayoutManager) {
                @Override
                public void onloadMore() {
                    if (!isLoading) {
                        isLoading = true;
                        Toast.makeText(HomeMoreActivity.this, "加载中-----", Toast.LENGTH_SHORT).show();
                        page++;
                        loadMoreData();
                    }
                }
            });
            isLoading = false;
            //停止刷新
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_more);
        linearLayoutManager = new LinearLayoutManager(this);
        initView();
        lovegas_recycleView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    //请求数据
    private void initRecycleView() {
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                loveGasMoreBean = new Gson().fromJson(reresponse, LoveGasMoreBean.class);
                List<LoveGasMoreBean.DataBean> listData = loveGasMoreBean.getData();
                listAll.addAll(listData);
                handler.sendEmptyMessage(0);
            }
        }.getData(url + page, BaseData.NORMALTIME);
    }

    //初始化控件及数据
    private void initView() {
        lovegas_recycleView = (RecyclerView) findViewById(R.id.lovegas_recycleView);
        srlayout = (SwipeRefreshLayout) findViewById(R.id.srlayout);
        srlayout.post(new Runnable() {
            @Override
            public void run() {
                refreshData();
            }
        });
        srlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

    }

    private void refreshData() {
        srlayout.setRefreshing(true);
        page = 1;
        listAll.clear();
        initRecycleView();
        srlayout.setRefreshing(false);
    }

    //加载更多
    public void loadMoreData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initRecycleView();
            }
        }.start();
    }
}