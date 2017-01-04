package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.dxy.happy.R;

public class AnimActivity extends AppCompatActivity {
    int  time=3;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.arg1==0){
                Intent intent=new Intent(AnimActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }else {
                setTime();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.anim);
        setTime();
    }
    private void setTime() {
        Message message=Message.obtain();
        time=time-1;
        message.arg1=time;
        handler.sendMessageDelayed(message,1000);
    }
}
