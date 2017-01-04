package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;


public class InviteFriendsActivity extends BaseActivity implements View.OnClickListener {

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
                new ShareAction(InviteFriendsActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withText("hello")
                        .setCallback(umShareListener)
                        .share();
                break;
            case R.id.invite_rela_wechat:
                break;
            case R.id.invite_friend_circle:
                break;
            case R.id.invite_rela_weibo:
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(InviteFriendsActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(InviteFriendsActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(InviteFriendsActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

}
