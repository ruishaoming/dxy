package com.dxy.happy.activity;

import android.app.Activity;
import android.content.Intent;
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //RESULT_OK是个系统变量，代表操作成功，那么我们就可以进行下面的操作了。
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        switch (requestCode) {
    /* 拍照 */
            case 101:
                //保存了data就保存了图片
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
