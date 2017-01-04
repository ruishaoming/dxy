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
import android.widget.Toast;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

import java.util.Timer;

/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50
 * update: 2016/12/29
 */

public class ForgetActivity extends BaseActivity implements View.OnClickListener {
    private CheckBox img;
    private EditText pwd;
    private Button button;
    private EditText phone;
    private Button yan;
    int  time=60;

    Timer timer=new Timer();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            yan.setText("倒计时"+msg.arg1+"秒");
            if (msg.arg1==0 ) {
                Toast.makeText(ForgetActivity.this, "验证码已发送，注意查收", Toast.LENGTH_SHORT).show();
                yan.setText("获取验证码");


            }else {
                setTime();
            }

        }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        initvew();
    }
    private void initvew() {
        yan = (Button) findViewById(R.id.yan1);
        yan.setOnClickListener(this);
        button = (Button) findViewById(R.id.tijiao);
        button.setOnClickListener(this);
        phone = (EditText) findViewById(R.id.phone);
        pwd = (EditText) findViewById(R.id.for_pwd);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        img = (CheckBox) findViewById(R.id.login_eye);
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
    }
    @Override
    public void onClick(View v) {
      switch (v.getId())
     {
         case R.id.tijiao:
             if(phone.getText().toString().trim().length()<=11
                     || pwd.getText().toString().trim().length()==0)
             {
                 Toast.makeText(ForgetActivity.this,"手机号码或密码格式不正确",Toast.LENGTH_SHORT).show();
             }else {

             }
             break;
         case R.id.yan1:
             if(phone.getText().toString().trim().length()<11
                     )
             {
                 Toast.makeText(ForgetActivity.this,"手机号码格式不正确",Toast.LENGTH_SHORT).show();
             }else {
                 setTime();
             }

             break;
     }
    }
    //跳转
    public void intentclass(Class v)
    {
        Intent intent=new Intent(ForgetActivity.this,v);
        startActivity(intent);
    }
    private void setTime() {
        Message message=Message.obtain();
        time=time-1;
        message.arg1=time;
        handler.sendMessageDelayed(message,1000);
    }
}
