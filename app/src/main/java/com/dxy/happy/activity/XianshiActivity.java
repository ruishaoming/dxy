package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dxy.happy.R;

public class XianshiActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xianshi);
        textView = (TextView) findViewById(R.id.tete);
        Intent intent=getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);


    }
}
