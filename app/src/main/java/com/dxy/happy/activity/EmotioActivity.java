package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

public class EmotioActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_text_title;
    private TextView mine_feedback_commit;
    private AutoLinearLayout emotio_ll;
    private AutoRelativeLayout emotio_rela_single;
    private AutoRelativeLayout emotio_rela_double;
    private ImageView iv_single;
    private ImageView iv_double;
    private boolean isChoose = false;
    private TextView tv_single;
    private TextView tv_double;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotio);
        mine_text_title = (TextView) findViewById(R.id.mine_title_text);
        mine_text_title.setText("情感状况");
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        mine_feedback_commit = (TextView) findViewById(R.id.mine_feedback_commit);
        mine_feedback_commit.setText("完成");
        mine_feedback_commit.setVisibility(View.VISIBLE);
        mine_feedback_commit.setOnClickListener(this);
        emotio_ll = (AutoLinearLayout) findViewById(R.id.emotio_ll);
        findViewById(R.id.emotio_rela_single).setOnClickListener(this);
         findViewById(R.id.emotio_rela_double).setOnClickListener(this);
        iv_single = (ImageView) findViewById(R.id.iv_single);
        iv_double = (ImageView) findViewById(R.id.iv_double);
        tv_single = (TextView) findViewById(R.id.tv_single);
        tv_double = (TextView) findViewById(R.id.tv_double);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(EmotioActivity.this);
                break;
            case R.id.mine_feedback_commit:
                if (isChoose){
                    Intent intent = new Intent(EmotioActivity.this,BasicInformationActivity.class);
                    intent.putExtra("state", tv_single.getText().toString());
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(EmotioActivity.this,BasicInformationActivity.class);
                    intent.putExtra("state", tv_double.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.emotio_rela_single:
                isChoose = true;
                iv_single.setVisibility(View.VISIBLE);
                iv_double.setVisibility(View.GONE);
                break;
            case R.id.emotio_rela_double:
                isChoose=false;
                iv_single.setVisibility(View.GONE);
                iv_double.setVisibility(View.VISIBLE);
                break;
        }

    }
}
