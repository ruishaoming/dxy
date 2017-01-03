package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class FeedBackActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private TextView mine_feedback_commit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("意见反馈");
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        mine_feedback_commit = (TextView) findViewById(R.id.mine_feedback_commit);
        mine_feedback_commit.setVisibility(View.VISIBLE);
        mine_feedback_commit.setText("提交");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(FeedBackActivity.this);
                break;
            case R.id.mine_feedback_commit:
                break;
        }

    }
}
