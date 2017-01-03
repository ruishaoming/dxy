package com.dxy.happy.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dxy.happy.R;
import com.dxy.happy.adapter.Home_RecycleViewAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.URLUtils;
import com.dxy.happy.view.ShowingPage;

import java.util.ArrayList;

/**
 * 首页
 * Created by 芮靖林
 * on 2016/12/28 11:58.
 */

public class Home_Fragment extends BaseFragment {
    private MyBaseData myBaseData;
    private RecyclerView home_fragment_recycleview;
    private SwipeRefreshLayout swipe_ly;
    private Home_RecycleViewAdapter adapter;
    ArrayList<String> urlList = new ArrayList<>();
    String url[] = {URLUtils.url_viewPager, URLUtils.url_festival, URLUtils.url_loveCommunity_alone
            , URLUtils.url_know, URLUtils.url_loveGas};


    @Override
    protected View createSuccessView() {
        View view = CommonUtils.inflate(R.layout.home_fragment);
        //初始化控件
        initView(view);
        return view;
    }

    @Override
    protected void onLoad() {
        Home_Fragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
        //SwipeRefreshLayout刷新加载
        initSwipeRefreshLayout();


    }

    private void initSwipeRefreshLayout() {
        swipe_ly.setColorSchemeResources(R.color.yellow, R.color.colorRed, R.color.yellow, R.color.colorRed);
        swipe_ly.setSize(SwipeRefreshLayout.LARGE);
        swipe_ly.setProgressBackgroundColor(R.color.colorRed);
        swipe_ly.setPadding(20, 20, 20, 20);

        swipe_ly.post(new Runnable() {
            @Override
            public void run() {
                refreshData();
            }
        });

        //设置下拉刷新的监听
        swipe_ly.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                urlList.clear();
                refreshData();
            }
        });
    }

    //刷新数据
    private void refreshData() {
        swipe_ly.setRefreshing(true);
        myBaseData = new MyBaseData();
        //请求数据
        for (int i = 0; i < url.length; i++) {
            myBaseData.getData(url[i], BaseData.NORMALTIME);
        }
        swipe_ly.setRefreshing(false);
    }

    private void initView(View view) {
        home_fragment_recycleview = (RecyclerView) view.findViewById(R.id.home_fragment_recycleview);
        swipe_ly = (SwipeRefreshLayout) view.findViewById(R.id.swipe_ly);
    }


    class MyBaseData extends BaseData {

        @Override
        public void setResultData(String reresponse) {
            urlList.add(reresponse);
            CommonUtils.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    if (urlList.size() == url.length) {
                        //设置适配器
                        home_fragment_recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new Home_RecycleViewAdapter(getContext(), urlList);
                        home_fragment_recycleview.setAdapter(adapter);
                    }
                }
            });
        }
    }
}
