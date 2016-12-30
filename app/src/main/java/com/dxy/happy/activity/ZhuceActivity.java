package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50 
 * update: 2016/12/29
 */

public class ZhuceActivity extends BaseActivity implements View.OnClickListener {

    private TextView login;
    private CheckBox img;
    private TextView con;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initview();
    }

    private void initview() {
        login = (TextView) findViewById(R.id.denglu);
        login.setOnClickListener(this);
        pwd = (EditText) findViewById(R.id.zhuce_pwd);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        img = (CheckBox) findViewById(R.id.login_eye);
        img.setOnClickListener(this);

        img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked)
                {

                    pwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        con = (TextView) findViewById(R.id.content);
        con.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.denglu:
                intentclass(LoginActivity.class);
                break;
            case R.id.content:
                intentclass(XieYiActivity.class);
                break;
        }
    }
    //跳转
    public void intentclass(Class v)
    {
        Intent intent=new Intent(ZhuceActivity.this,v);
        startActivity(intent);
    }

}
