package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;

import com.dxy.happy.R;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    //广播的设置
    public static final String action = "aaa";
    private CheckBox home_cb1;
    private CheckBox home_cb2;
    private Button home_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        home_cb1 = (CheckBox) findViewById(R.id.home_cb1);
        home_cb2 = (CheckBox) findViewById(R.id.home_cb2);
        home_bt = (Button) findViewById(R.id.home_bt);
        //判断当前状态 赋值状态
        String s = getIntent().getStringExtra("aaa");
        if (s.equals("单身期")) {
            home_cb2.setChecked(true);
        } else if (s.equals("热恋期")) {
            home_cb1.setChecked(true);
        }

        home_bt.setOnClickListener(this);
        home_cb1.setOnClickListener(this);
        home_cb2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_cb1:
                if (home_cb1.isChecked()) {
                    home_cb2.setChecked(false);
                } else {
                    home_cb1.setChecked(true);
                }
                //广播的设置
                Intent intent1 = new Intent(action);
                intent1.putExtra("tag", "恋爱期");
                sendBroadcast(intent1);

                break;
            case R.id.home_cb2:
                if (home_cb2.isChecked()) {
                    home_cb1.setChecked(false);
                } else {
                    home_cb2.setChecked(true);
                }
                //广播的设置
                Intent intent2 = new Intent(action);
                intent2.putExtra("tag", "单身期");
                sendBroadcast(intent2);

                break;
            case R.id.home_bt:
                finish();
                break;
        }


    }


}
