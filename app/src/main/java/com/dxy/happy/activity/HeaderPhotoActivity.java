package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dxy.happy.R;


public class HeaderPhotoActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_photo);
        findViewById(R.id.mine_dialog_photo).setOnClickListener(this);
       findViewById(R.id.mine_dialog_picture).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_dialog_photo:
                break;
            case R.id.mine_dialog_picture:
                break;
        }
    }
}
