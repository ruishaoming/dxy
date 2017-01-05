package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class ChangeNameActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mine_return_back;
    private TextView mine_title_text;
    private TextView mine_feedback_commit;
    private EditText change_name_et;
    private String et_name;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        mine_return_back = (ImageView) findViewById(R.id.mine_return_back);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("修改昵称");
        mine_feedback_commit = (TextView) findViewById(R.id.mine_feedback_commit);
        mine_feedback_commit.setText("完成");
        mine_feedback_commit.setVisibility(View.VISIBLE);
        change_name_et = (EditText) findViewById(R.id.change_name_et);
        mine_return_back.setOnClickListener(this);
        mine_feedback_commit.setOnClickListener(this);
        name = getIntent().getStringExtra("name");
        if (change_name_et!=null){
            change_name_et.setText("name");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(ChangeNameActivity.this);
                break;
            case R.id.mine_feedback_commit:
                ChangeNameActivity.this.finish();
                break;
        }
    }

    private void jumpActivity(Intent intent, int resultCode) {
        intent.putExtra("name",et_name);
        setResult(resultCode,intent);
    }
}
