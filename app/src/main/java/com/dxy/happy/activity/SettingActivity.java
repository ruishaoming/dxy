package com.dxy.happy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.DataClearManager;

import java.io.File;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private TextView tv_cache_size;
    private File cacheDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("设置");
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        findViewById(R.id.setting_change_password).setOnClickListener(this);
        findViewById(R.id.setting_invite_friends).setOnClickListener(this);
        findViewById(R.id.setting_about_us).setOnClickListener(this);
        findViewById(R.id.setting_version_updating).setOnClickListener(this);
        findViewById(R.id.setting_clear_cache).setOnClickListener(this);
        findViewById(R.id.setting_exit).setOnClickListener(this);
        tv_cache_size = (TextView) findViewById(R.id.tv_cache_size);
        getCacheData();
    }

    private void getCacheData() {
        //获取缓存大小
        cacheDir = getCacheDir();
        try {
           String caCheSize = DataClearManager.getCacheSize(cacheDir);
            tv_cache_size.setText("已缓存"+ caCheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_return_back:
                CommonUtils.finishActivity(SettingActivity.this);
                break;
            case R.id.setting_change_password:
                CommonUtils.startActivity(SettingActivity.this, ChangePasswordActivity.class);
                break;
            case R.id.setting_invite_friends:
                CommonUtils.startActivity(SettingActivity.this, InviteFriendsActivity.class);
                break;
            case R.id.setting_about_us:
                CommonUtils.startActivity(SettingActivity.this, AboutUsActivity.class);
                break;
            case R.id.setting_version_updating:
                break;
            case R.id.setting_clear_cache:

                try {
                    DataClearManager.cleanInternalCache(SettingActivity.this);
                    String cacheSize = DataClearManager.getCacheSize(cacheDir);
                    tv_cache_size.setText(cacheSize);
                    Toast.makeText(this, "清除了", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.setting_exit:

                break;

        }
    }
}
