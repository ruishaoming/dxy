package com.dxy.happy.fragment;

import android.view.View;

import com.dxy.happy.base.BaseFragment;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.view.ShowingPage;
import com.dxy.happy.R;

/**
 * Created by 张天成
 * on 2016/12/28 19:53.
 */
public class Community_Choiceness_Fragment extends BaseFragment {
    @Override
    protected void onLoad() {
            this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        View view= CommonUtils.inflate(R.layout.community_choiceness_fragment);
        return view;
    }
}
