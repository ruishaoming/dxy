package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

import java.util.Timer;

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
    private EditText phone;
    private Button button;
    private Button yanzheng;
    int  time=60;

    Timer timer=new Timer();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            yanzheng.setText("倒计时"+msg.arg1+"秒");
            if (msg.arg1==0 ) {
                Toast.makeText(ZhuceActivity.this, "验证码已发送，注意查收", Toast.LENGTH_SHORT).show();
                yanzheng.setText("获取验证码");


            }else {
                setTime();
            }

        }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initview();
    }

    private void initview() {
        yanzheng = (Button) findViewById(R.id.yanzhengma);
        yanzheng.setOnClickListener(this);
        button = (Button) findViewById(R.id.zhuce);
        button.setOnClickListener(this);
        login = (TextView) findViewById(R.id.denglu);
        login.setOnClickListener(this);
        pwd = (EditText) findViewById(R.id.zhuce_pwd);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        img = (CheckBox) findViewById(R.id.login_eye);
        img.setOnClickListener(this);
        phone = (EditText) findViewById(R.id.phone);
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
            case R.id.zhuce:
                if(phone.getText().toString().trim().length()<=11
                        || pwd.getText().toString().trim().length()==0)
                {
                    Toast.makeText(ZhuceActivity.this,"手机号码或密码格式不正确",Toast.LENGTH_SHORT).show();
                }else {

                }
                break;
            case R.id.yanzhengma:
                if(phone.getText().toString().trim().length()<11
                      )
                {
                    Toast.makeText(ZhuceActivity.this,"手机号码格式不正确",Toast.LENGTH_SHORT).show();
                }else {
                    setTime();
                }

                break;
        }
    }
    //跳转
    public void intentclass(Class v)
    {
        Intent intent=new Intent(ZhuceActivity.this,v);
        startActivity(intent);
    }
    private void setTime() {
        Message message=Message.obtain();
        time=time-1;
        message.arg1=time;
        handler.sendMessageDelayed(message,1000);
    }

}
