package com.dxy.clove.fragment;

import android.view.View;

import com.dxy.clove.R;
import com.dxy.clove.base.BaseFragment;
import com.dxy.clove.utils.CommonUtils;

/**
 * 论坛
 * Created by 芮靖林
 * on 2016/12/28 11:59.
 */

public class Forum_Fragment extends BaseFragment {
    @Override
    protected void onLoad() {

    }

    @Override
    protected View createSuccessView() {
        View rootView = CommonUtils.inflate(R.layout.forum_fragment);
        return rootView;
    }
}
