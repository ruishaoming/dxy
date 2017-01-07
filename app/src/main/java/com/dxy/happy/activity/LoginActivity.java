package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.Login;
import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;


/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50
 * update: 2016/12/29
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private TextView forget;
    private Button btn;
    private ImageView wixin;
    private TextView zhuce;
    private EditText phone;
    private EditText pwd;
    private CheckBox img;
    private Login login;
    private ImageView weixin;
    private ImageView touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
    }
    private void initview() {
        weixin = (ImageView) findViewById(R.id.weixin);
        weixin.setOnClickListener(this);
        forget = (TextView) findViewById(R.id.forget);
        forget.setOnClickListener(this);
        btn = (Button) findViewById(R.id.btn_login);
        btn.setOnClickListener(this);
        wixin = (ImageView) findViewById(R.id.weixin);
        wixin.setOnClickListener(this);
        zhuce = (TextView) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(this);
        phone = (EditText) findViewById(R.id.login_phone);
        img = (CheckBox) findViewById(R.id.login_eye);
        pwd = (EditText) findViewById(R.id.login_pwd);
        touxiang = (ImageView) findViewById(R.id.touxiang);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        img.setOnClickListener(this);
        img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    pwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.forget:
                intentclass(ForgetActivity.class);
                break;
            case R.id.btn_login:
                if(phone.length()!=11 || pwd.length()==0){
                    Toast.makeText(LoginActivity.this,"手机号或密码格式不正确",Toast.LENGTH_SHORT).show();
                }else {
                    toLogin();
                }
                break;
            case R.id.weixin:
                UMShareAPI mShareAPI = UMShareAPI.get( LoginActivity.this );
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.zhuce:
                intentclass(ZhuceActivity.class);
                break;

        }
    }
   //登陆
    private void toLogin() {
        new BaseData(){
            @Override
            public void setResultData(String reresponse) {
                Gson gson=new Gson();
                login = gson.fromJson(reresponse, Login.class);
                if (login.getStatus().equals("ok")){
                    intentclass(AnimActivity.class);
                }else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        }.getData("http://114.112.104.151:8203/LvScore_Service/visit/user_login.do?telNum="+phone.getText().toString().trim()+"&password="+pwd.getText().toString().trim()+"",BaseData.NOTIME);
    }

    //跳转页面
    public  void  intentclass(Class v)
    {
        Intent intent=new Intent(LoginActivity.this,v);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//            SharedPreferencesUtil
            String name = data.get("screen_name");
            String icon = data.get("profile_image_url");
            Glide.with(LoginActivity.this)
                    .load(icon)
                    .placeholder(R.mipmap.default_logo)
                    .error(R.mipmap.ic_launcher)
                    .into(touxiang);
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            intentclass(AnimActivity.class);

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( LoginActivity.this, "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( LoginActivity.this, "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
}
