package com.dxy.happy.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.dxy.happy.R;
import com.dxy.happy.adapter.CommunityAllAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.bean.CommunityAllBean;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.URLUtils;
import com.dxy.happy.view.ShowingPage;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张天成
 * on 2016/12/28 19:53.
 */
public class Community_Choiceness_Fragment extends BaseFragment {

    private MaterialRefreshLayout choiceness_materialRefreshLayout;
    private RecyclerView choiceness_recyclerView;
    private boolean isRefrshLoadMore = false;
    private int numbre = 0;
    private CommunityAllAdapter communityAllAdapter;
    private ArrayList<CommunityAllBean.DataEntity> listAll = new ArrayList<>();
    Handler handler = new Handler() {

        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                List<CommunityAllBean.DataEntity> dataList = (List<CommunityAllBean.DataEntity>) msg.obj;
                if (communityAllAdapter == null) {
                    communityAllAdapter = new CommunityAllAdapter(dataList, getActivity());
                    //设置适配器
                    choiceness_recyclerView.setAdapter(communityAllAdapter);
                } else {
                    communityAllAdapter.notifyDataSetChanged();
                }
            }
        }
    };

    @Override
    protected void onLoad() {
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
        //请求数据方法
        numbre = 1;
        initData(BaseData.NORMALTIME, numbre);
        //设置materialRefreshLayout的侵入模式  false为非侵入式刷新
        choiceness_materialRefreshLayout.setIsOverLay(false);
        choiceness_materialRefreshLayout.setWaveShow(false);
        //materialRefreshLayout设置刷新监听
        choiceness_materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
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
                            sleep(2000);
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
                            sleep(2000);
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

        choiceness_materialRefreshLayout.setLoadMore(true);
    }

    @Override
    protected View createSuccessView() {
        View view = CommonUtils.inflate(R.layout.community_choiceness_fragment);
        choiceness_materialRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.choiceness_materialRefreshLayout);
        choiceness_recyclerView = (RecyclerView) view.findViewById(R.id.choiceness_recyclerView);
        choiceness_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }


    private void initData(int time, int page) {
        new BaseData() {
            private List<CommunityAllBean.DataEntity> data;

            @Override
            public void setResultData(String reresponse) {
                Gson gson = new Gson();
                CommunityAllBean communityAllBean = gson.fromJson(reresponse, CommunityAllBean.class);
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
        }.getData(URLUtils.url_choiceness + page, time);
    }

    @Override
    public void onPause() {
        super.onPause();
        communityAllAdapter = null;
    }
}
