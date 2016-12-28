package com.dxy.clove.fragment;

import android.view.View;

import com.dxy.clove.R;
import com.dxy.clove.base.BaseFragment;
import com.dxy.clove.utils.CommonUtils;

/**
 * 消息
 * Created by 芮靖林
 * on 2016/12/28 12:00.
 */

public class Mes_Fragment extends BaseFragment {
    @Override
    protected void onLoad() {

    }

    @Override
    protected View createSuccessView() {
        View rootView = CommonUtils.inflate(R.layout.mes_fragment);
        return rootView;
    }
}
