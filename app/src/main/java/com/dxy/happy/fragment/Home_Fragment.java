package com.dxy.happy.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dxy.happy.Hoder.BaseHolder;
import com.dxy.happy.Hoder.Holder_Know;
import com.dxy.happy.Hoder.Holder_Love_Community;
import com.dxy.happy.Hoder.Holder_Love_Gas;
import com.dxy.happy.Hoder.Holder_ViewPager;
import com.dxy.happy.Hoder.Holder_festival;
import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.view.ShowingPage;
import com.xnl.happy.R;

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

    }

    @Override
    protected View createSuccessView() {
        View view = CommonUtils.inflate(R.layout.home_fragment);
        //初始化控件
        initView(view);
        initRecycleView();
        return view;
    }

    private void initRecycleView() {
        final int Type0 = 0;
        final int Type1 = 1;
        final int Type2 = 2;
        final int Type3 = 3;
        final int Type4 = 4;
        home_fragment_recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        home_fragment_recycleview.setAdapter(new RecyclerView.Adapter<BaseHolder>() {
            @Override
            public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                //判断外层recycleview条目类型
                BaseHolder holder = null;
                if (viewType == Type0) {
                    View view = CommonUtils.inflate(R.layout.holder_viewpager);
                    holder = new Holder_ViewPager(view);
                } else if (viewType == Type1) {
                    View view = CommonUtils.inflate(R.layout.holder_festival);
                    holder = new Holder_festival(view);
                } else if (viewType == Type2) {
                    View view = CommonUtils.inflate(R.layout.holder_love_community);
                    holder = new Holder_Love_Community(view);
                } else if (viewType == Type3)

                {
                    View view = CommonUtils.inflate(R.layout.holder_know);
                    holder = new Holder_Know(view);
                } else if (viewType == Type4)

                {
                    View view = CommonUtils.inflate(R.layout.holder_love_gas);
                    holder = new Holder_Love_Gas(view);
                }
                return holder;
            }


            @Override
            public void onBindViewHolder(BaseHolder holder, int position) {
                //调用抽象类里的抽象方法 直接传条目
                holder.getHolder(getContext(),null);

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });
    }

    private void initView(View view) {
        home_fragment_recycleview = (RecyclerView) view.findViewById(R.id.home_fragment_recycleview);
    }
}
