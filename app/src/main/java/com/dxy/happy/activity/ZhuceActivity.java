package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xnl.happy.R;
/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50 
 * update: 2016/12/29
 */

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initview();
    }

    private void initview() {
        login = (TextView) findViewById(R.id.denglu);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.denglu:
                intentclass(LoginActivity.class);
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
