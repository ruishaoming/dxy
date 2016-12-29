package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xnl.happy.R;

/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50 
 * update: 2016/12/29
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView forget;
    private Button btn;
    private ImageView wixin;
    private TextView zhuce;
    private EditText phone;
    private String phone1;
    private EditText pwd;
    private String pwd1;
    private ImageView img;
    int[] pic={R.mipmap.signup_item_selected,R.mipmap.signup_item_unselected};
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
        img = (ImageView) findViewById(R.id.login_eye);
        img.setOnClickListener(this);
        pwd = (EditText) findViewById(R.id.login_pwd);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.forget:
                intentclass(ForgetActivity.class);
                break;
            case R.id.btn_login:
                if (phone.getText().toString().equals("") ||
                        phone.getText().toString().trim()==null ||
                                pwd.getText().toString().equals("")||
                        pwd.getText().toString().trim()==null )
                {
                    Toast.makeText(LoginActivity.this,"手机号和密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    intentclass(MainActivity.class);
                }

                break;
            case R.id.weixin:
                break;
            case R.id.zhuce:
                intentclass(ZhuceActivity.class);
                break;
            case R.id.login_eye:

                break;
        }

    }
    //跳转页面
    public  void  intentclass(Class v)
    {
        Intent intent=new Intent(LoginActivity.this,v);
        startActivity(intent);
    }

}
