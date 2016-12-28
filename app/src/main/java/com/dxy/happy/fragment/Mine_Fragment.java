package com.dxy.happy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xnl.happy.R;


/**
 * 我的
 * Created by 芮靖林
 * on 2016/12/28 12:00.
 */

public class Mine_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mine_fragment, null);
        return rootView;
    }
}
