package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xnl.happy.R;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private TextView mine_feedback_commit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("修改密码");
        mine_feedback_commit = (TextView) findViewById(R.id.mine_feedback_commit);
        mine_feedback_commit.setText("完成");
       findViewById(R.id.mine_return_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
