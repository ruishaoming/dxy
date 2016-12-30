package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.utils.CommonUtils;


public class InviteFriendsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mine_return_back;
    private TextView mine_title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
        findViewById(R.id.invite_rela_qq_space).setOnClickListener(this);
         findViewById(R.id.invite_rela_qq).setOnClickListener(this);
        findViewById(R.id.invite_rela_weibo).setOnClickListener(this);
        findViewById(R.id.invite_rela_wechat).setOnClickListener(this);
        findViewById(R.id.invite_rela_friend_circle).setOnClickListener(this);
       findViewById(R.id.mine_return_back).setOnClickListener(this);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("邀请朋友");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(InviteFriendsActivity.this);
                break;
            case R.id.invite_rela_qq_space:
                break;
            case R.id.invite_qq:
                break;
            case R.id.invite_rela_wechat:
                break;
            case R.id.invite_friend_circle:
                break;
            case R.id.invite_rela_weibo:
                break;

        }
    }
}
