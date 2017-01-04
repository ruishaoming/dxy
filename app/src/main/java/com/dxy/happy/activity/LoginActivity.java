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

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;


/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50
 * update: 2016/12/29
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView forget;
    private Button btn;
    private ImageView wixin;
    private TextView zhuce;
    private EditText phone;
    private String phone1;
    private EditText pwd;
    private String pwd1;
    private CheckBox img;
    private Boolean Flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initview();

    }

    private void initview() {
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
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        img.setOnClickListener(this);
        img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked) {

                    pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });


        //设置密码为不可见


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget:
                intentclass(ForgetActivity.class);
                break;
            case R.id.btn_login:
                intentclass(MainActivity.class);
                break;
            case R.id.weixin:
                break;
            case R.id.zhuce:
                intentclass(ZhuceActivity.class);
                break;


        }

    }

    //跳转页面
    public void intentclass(Class v) {
        Intent intent = new Intent(LoginActivity.this, v);
        startActivity(intent);
    }

}
