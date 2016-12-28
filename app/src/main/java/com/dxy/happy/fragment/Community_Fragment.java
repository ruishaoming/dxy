package com.dxy.happy.fragment;

import android.view.View;

import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.xnl.happy.R;

/**
 * 社区
 * Created by 芮靖林
 * on 2016/12/28 12:00.
 */

public class Community_Fragment extends BaseFragment {
    @Override
    protected void onLoad() {

    }

    @Override
    protected View createSuccessView() {
        View rootView = CommonUtils.inflate(R.layout.community_fragment);
        return rootView;
    }
}
