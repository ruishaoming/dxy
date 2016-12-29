package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dxy.happy.utils.CommonUtils;
import com.xnl.happy.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mine_title_text;

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(SettingActivity.this);
                break;
            case R.id.setting_change_password:
                break;
            case R.id.setting_invite_friends:
                CommonUtils.startActivity(SettingActivity.this,InviteFriendsActivity.class);
                break;
            case R.id.setting_about_us:
                CommonUtils.startActivity(SettingActivity.this,AboutUsActivity.class);
                break;
            case R.id.setting_version_updating:
                break;

        }
    }
}
