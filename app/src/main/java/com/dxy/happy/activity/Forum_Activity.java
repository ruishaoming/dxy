package com.dxy.happy.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.adapter.ForumTop_Adapter;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.ForumTop_Bean;
import com.dxy.happy.interfaces.OnItemClickListener;
import com.dxy.happy.listen.OnLoadMoreListener;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.URLUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Forum_Activity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private ForumTop_Bean top_bean;
    private ForumTop_Bean bean_list;
    private List<ForumTop_Bean.DataBean> listAll = new ArrayList<>();
    private int id;
    private int index = 0;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ForumTop_Adapter adapter;
    private int page = 1;
    private boolean isLoading = true;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                //初始化请求
                case 3:
                    //展示数据
                    if (top_bean != null && top_bean.getData() != null && bean_list != null) {
                        if (adapter == null) {
                            adapter = new ForumTop_Adapter(Forum_Activity.this, top_bean.getData(), listAll);
                            recyclerView.setAdapter(adapter);
                        } else {
                            adapter.notifyDataSetChanged();
                        }
                        //对recycleView添加一个滑动的监听
                        recyclerView.addOnScrollListener(new OnLoadMoreListener(linearLayoutManager) {
                            @Override
                            public void onloadMore() {
                                if (isLoading) {
                                    isLoading = false;
                                    page++;
                                    loadMoreData();
                                }
                            }
                        });

                        adapter.setOnClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(int position) {
                                Intent in=new Intent(Forum_Activity.this,Froum_Xq_Activity.class);
                                in.putExtra("data2",listAll.get(position));
                                startActivity(in);
                            }
                        });

                    }
                    isLoading = true;
                    swipeRefreshLayout.setRefreshing(false);
                    break;
            }
            //停止刷新
        }
    };
    private ImageView imageView_back;
    private TextView backe2;

    public void loadMoreData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initData();
                //设置当前条目的索引值
                index = index + bean_list.getData().size();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_);
        //找到控件
        ImageView imageView = (ImageView) findViewById(R.id.image_title2);
        imageView_back = (ImageView) findViewById(R.id.forum_back);
        backe2 = (TextView) findViewById(R.id.forum_back2);
        TextView title2 = (TextView) findViewById(R.id.text_title2);
        TextView text_count2 = (TextView) findViewById(R.id.text_count2);
        recyclerView = (RecyclerView) findViewById(R.id.forum_RecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加监听
        backe2.setOnClickListener(this);
        imageView_back.setOnClickListener(this);
        //
        Intent intent = getIntent();
        int image = intent.getIntExtra("image", 0);
        String title_name = intent.getStringExtra("title_name");
        String title_name2 = intent.getStringExtra("title_name2");
        id = intent.getIntExtra("id", 0);
        title2.setText(title_name);
        text_count2.setText(title_name2);
        imageView.setImageResource(image);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //设置进度的颜色
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //设置是否刷新---直接一进来就刷新
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                //一上来先去做刷新的逻辑操作
                swipeRefreshLayout.setRefreshing(true);
                //请求数据
                refreshData();
            }
        });
        //设置下拉刷新的监听
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    private void initData() {
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                Gson gson = new Gson();
                top_bean = gson.fromJson(reresponse, ForumTop_Bean.class);
                handler.sendEmptyMessage(3);
            }
        }.getData(URLUtils.url_top + id, BaseData.NORMALTIME);
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                Gson gson = new Gson();
                bean_list = gson.fromJson(reresponse, ForumTop_Bean.class);
                listAll.addAll(bean_list.getData());
                handler.sendEmptyMessage(3);
            }
        }.getData(URLUtils.url_list + id + "&page=" + page, BaseData.NORMALTIME);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forum_back:
            case R.id.forum_back2:
                CommonUtils.finishActivity(this);
                break;
        }
    }

    @Override
    public void onRefresh() {
        refreshData();
    }

    public void refreshData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index = 0;
                initData();
                //把数据发送给主线程
                handler.sendEmptyMessage(0);

            }
        }.start();
    }

}
