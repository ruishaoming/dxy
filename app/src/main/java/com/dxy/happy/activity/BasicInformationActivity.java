package com.dxy.happy.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class BasicInformationActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_information);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("基本信息");
        findViewById(R.id.mine_return_back).setOnClickListener(this);
       findViewById(R.id.basic_information_icon).setOnClickListener(this);
       findViewById(R.id.basic_information_name).setOnClickListener(this);
       findViewById(R.id.basic_information_birthday).setOnClickListener(this);
       findViewById(R.id.basic_information_profession).setOnClickListener(this);
       findViewById(R.id.basic_information_relationship_status).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(BasicInformationActivity.this);
                break;
            case R.id.basic_information_icon:
                break;
            case R.id.basic_information_name:
                break;
            case R.id.basic_information_birthday:
                break;
            case R.id.basic_information_profession:
                break;
            case R.id.basic_information_relationship_status:
                break;

        }
    }
}
