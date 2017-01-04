package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class MyPostActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private ImageView mine_mypost_img;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post);
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("我的帖子");
        mine_mypost_img = (ImageView) findViewById(R.id.mine_mypost_img);
        mine_mypost_img.setOnClickListener(this);
        mine_mypost_img.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) findViewById(R.id.my_post_recyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(MyPostActivity.this);
                break;
            case R.id.mine_mypost_img:
                break;
        }
    }
}
