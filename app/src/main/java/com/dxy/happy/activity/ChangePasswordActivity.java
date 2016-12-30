package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.utils.CommonUtils;


public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private TextView mine_feedback_commit;
    private EditText et_old_pwd;
    private EditText et_new_pwd;
    private EditText et_replay_new_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("修改密码");
         mine_feedback_commit = (TextView) findViewById(R.id.mine_feedback_commit);
        et_old_pwd = (EditText) findViewById(R.id.et_old_pwd);
        et_new_pwd = (EditText) findViewById(R.id.et_new_pwd);
        et_replay_new_pwd = (EditText) findViewById(R.id.et_replay_new_pwd);
        mine_feedback_commit.setText("完成");
        mine_feedback_commit.setVisibility(View.VISIBLE);
       findViewById(R.id.mine_return_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(ChangePasswordActivity.this);
                break;
            case R.id.mine_feedback_commit:
                String old_pwd = et_old_pwd.getText().toString().trim();
                String new_pwd = et_new_pwd.getText().toString().trim();
                String replay_new_pwd = et_replay_new_pwd.getText().toString().trim();

                break;
        }
    }
}
