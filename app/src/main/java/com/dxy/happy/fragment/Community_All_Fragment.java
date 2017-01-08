package com.dxy.happy.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.dxy.happy.R;
import com.dxy.happy.activity.Froum_Xq_Activity;
import com.dxy.happy.adapter.CommunityAllAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.bean.ForumTop_Bean;
import com.dxy.happy.interfaces.OnItemClickListener;
import com.dxy.happy.utils.URLUtils;
import com.dxy.happy.view.ShowingPage;
import com.google.gson.Gson;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张天成
 * on 2016/12/28 19:53.
 */
public class Community_All_Fragment extends BaseFragment {

    private RecyclerView recyclerView;
    private MaterialRefreshLayout materialRefreshLayout;
    private int numbre = 0;
    private FloatingActionButton floatingActionButton;
    private CommunityAllAdapter communityAllAdapter;
    private ArrayList<ForumTop_Bean.DataBean> listAll = new ArrayList<>();
    private boolean isRefrshLoadMore = false;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                List<ForumTop_Bean.DataBean> dataList = (List<ForumTop_Bean.DataBean>) msg.obj;
                if (communityAllAdapter == null) {
                    communityAllAdapter = new CommunityAllAdapter(dataList, getActivity());
                    //设置适配器
                    recyclerView.setAdapter(communityAllAdapter);

                } else {
                    communityAllAdapter.notifyDataSetChanged();
                }
            }
            communityAllAdapter.setOnClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Intent in=new Intent(getActivity(),Froum_Xq_Activity.class);
                    in.putExtra("data2",listAll.get(position));
                    startActivity(in);
                }
            });
        }
    };

    @Override
    protected void onLoad() {
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
        numbre = 1;
        //加载数据并加载第一页的数据
        initData(BaseData.NORMALTIME, numbre);
        //设置materialRefreshLayout的侵入模式  false为非侵入式刷新
        materialRefreshLayout.setIsOverLay(false);
        materialRefreshLayout.setWaveShow(false);
        //materialRefreshLayout设置刷新监听
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            //下拉刷新监听
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            //控制是刷新
                            isRefrshLoadMore = true;
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //显示页数控制为1
                        numbre = 1;
                        initData(BaseData.NOTIME, numbre);
                        //关闭materialRefreshLayout刷新框
                        materialRefreshLayout.finishRefresh();
                    }
                }.start();
            }

            //加载更多方法
            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        //控制为加载模式
                        isRefrshLoadMore = false;
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        numbre = numbre + 1;
                        initData(BaseData.NOTIME, numbre);
                        //关闭materialRefreshLayout加载框
                        materialRefreshLayout.finishRefreshLoadMore();

                    }
                }.start();
            }
        });
        ////设置recyclerView滑动监听
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //通过判断滑动的长度让floatingActionButton显示隐藏
                if (dy > 0) {
                    floatingActionButton.hide();
                }
                if (dy < 0) {
                    floatingActionButton.show();
                }
            }
        });
        //设置可以加载更多
        //materialRefreshLayout.setLoadMore(true);

    }

    //请求数据方法
    private void initData(int time, int page) {
        new BaseData() {
            private List<ForumTop_Bean.DataBean> data;

            @Override
            public void setResultData(String reresponse) {
                Gson gson = new Gson();
                //解析数据
                ForumTop_Bean communityAllBean = gson.fromJson(reresponse, ForumTop_Bean.class);
                //清楚第一次后数据清空
                if (data != null) {
                    data.clear();
                }
                data = communityAllBean.getData();
                //判断是刷新还是加载
                if (isRefrshLoadMore) {
                    //保证值刷新第一页的数据  直显示第一页的
                    listAll.clear();
                    listAll.addAll(data);
                    handler.obtainMessage(0, listAll).sendToTarget();
                } else {
                    //加载数据后
                    listAll.addAll(data);
                    handler.obtainMessage(0, listAll).sendToTarget();
                }
            }
        }.getData(URLUtils.url_all + page, time);
    }

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getActivity(), R.layout.community_all_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        materialRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.materialRefreshLayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        //为floatingActionButton和recyclerView设置关联
        floatingActionButton.attachToRecyclerView(recyclerView);
        floatingActionButton.setType(FloatingActionButton.TYPE_MINI);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        //适配器制空
        communityAllAdapter = null;
    }
}
