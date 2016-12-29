package com.dxy.happy.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dxy.happy.R;
import com.dxy.happy.adapter.Home_Fragment_Main_RecycleViewAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.bean.Fragment_ViewPagerBean;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.URLUtils;
import com.dxy.happy.view.ShowingPage;
import com.google.gson.Gson;

/**
 * 首页
 * Created by 芮靖林
 * on 2016/12/28 11:58.
 */

public class Home_Fragment extends BaseFragment {

    private RecyclerView home_fragment_recycleview;

    @Override
    protected void onLoad() {
        Home_Fragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);

        //请求数据
        initGetData();
    }

    @Override
    protected View createSuccessView() {
        View view = CommonUtils.inflate(R.layout.home_fragment);
        //初始化控件
        initView(view);
        return view;
    }


    private void initGetData() {
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                Fragment_ViewPagerBean fragment_viewPagerBean = new Gson().fromJson(reresponse, Fragment_ViewPagerBean.class);
                //展示数据
                initRecycleView(fragment_viewPagerBean);

            }
        }.getData(URLUtils.url_viewPager, BaseData.NOTIME);
    }

    private void initRecycleView(final Fragment_ViewPagerBean fragment_viewPagerBean) {
        //设置适配器
        home_fragment_recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        Home_Fragment_Main_RecycleViewAdapter adapter=new Home_Fragment_Main_RecycleViewAdapter(getContext(),fragment_viewPagerBean);
        home_fragment_recycleview.setAdapter(adapter);
    }

    private void initView(View view) {
        home_fragment_recycleview = (RecyclerView) view.findViewById(R.id.home_fragment_recycleview);
    }
}
