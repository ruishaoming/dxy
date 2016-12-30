package com.dxy.happy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dxy.happy.R;
import com.dxy.happy.activity.HeaderPhotoActivity;
import com.dxy.happy.activity.SettingActivity;
import com.dxy.happy.utils.CommonUtils;
import com.zhy.autolayout.AutoLinearLayout;


/**
 * 我的
 * Created by 芮靖林
 * on 2016/12/28 12:00.
 */

public class Mine_Fragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private AutoLinearLayout mine_info;
    private LinearLayout mine_line_name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mine_fragment, null);
        //找控件
        initView();
        return rootView;
    }

    private void initView() {
        rootView.findViewById(R.id.mine_header_photo).setOnClickListener(this);
        rootView.findViewById(R.id.mine_line_attention).setOnClickListener(this);
        rootView.findViewById(R.id.mine_rela_basedata).setOnClickListener(this);
        rootView.findViewById(R.id.mine_rela_mypost).setOnClickListener(this);
        rootView.findViewById(R.id.mine_rela_feedback).setOnClickListener(this);
        rootView.findViewById(R.id.mine_rela_setting).setOnClickListener(this);
        mine_info = (AutoLinearLayout) rootView.findViewById(R.id.mine_info);
        mine_line_name = (LinearLayout) rootView.findViewById(R.id.mine_line_name);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //头像
            case R.id.mine_header_photo:
                startActivity(new Intent(getActivity(), HeaderPhotoActivity.class));
                break;
            //关注
            case R.id.mine_line_attention:
                break;
            //基本资料
            case R.id.mine_rela_basedata:
                break;
            //我的帖子
            case R.id.mine_rela_mypost:
                break;
            //意见反馈
            case R.id.mine_rela_feedback:
                break;
            //设置
            case R.id.mine_rela_setting:
                CommonUtils.startActivity(getActivity(), SettingActivity.class);
                break;


        }
    }
}
