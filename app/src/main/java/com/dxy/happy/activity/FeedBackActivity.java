package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class FeedBackActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private TextView mine_feedback_commit;
    private EditText feed_back_et_sugesst;
    private EditText feed_back_et_phone;
    private ImageView feedback_iv1;
    private ImageView feedback_iv2;
    private ImageView feedback_iv3;
    private ImageView feedback_iv4;
    private ImageView feedback_iv5;

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
        mine_feedback_commit.setOnClickListener(this);
        feed_back_et_sugesst = (EditText) findViewById(R.id.feed_back_et_sugesst);
        feed_back_et_phone = (EditText) findViewById(R.id.feed_back_et_phone);
         findViewById(R.id.feedback_rela1).setOnClickListener(this);
        findViewById(R.id.feedback_rela2).setOnClickListener(this);
         findViewById(R.id.feedback_rela3).setOnClickListener(this);
         findViewById(R.id.feedback_rela4).setOnClickListener(this);
         findViewById(R.id.feedback_rela5).setOnClickListener(this);
        feedback_iv1 = (ImageView) findViewById(R.id.feedback_iv1);
        feedback_iv2 = (ImageView) findViewById(R.id.feedback_iv2);
        feedback_iv3 = (ImageView) findViewById(R.id.feedback_iv3);
        feedback_iv4 = (ImageView) findViewById(R.id.feedback_iv4);
        feedback_iv5 = (ImageView) findViewById(R.id.feedback_iv5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(FeedBackActivity.this);
                break;
            case R.id.mine_feedback_commit:
                if (feed_back_et_sugesst.getText().toString().equals("")){
                    Toast.makeText(this, "还未填写任何意见或建议哦", Toast.LENGTH_SHORT).show();
                }
                if (feed_back_et_phone.getText().toString().equals("")){
                    Toast.makeText(this, "手机号/微信号/QQ号,不能为空", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback_rela1:
                feedback_iv1.setVisibility(View.VISIBLE);
                feedback_iv2.setVisibility(View.GONE);
                feedback_iv3.setVisibility(View.GONE);
                feedback_iv4.setVisibility(View.GONE);
                feedback_iv5.setVisibility(View.GONE);
                break;
            case R.id.feedback_rela2:
                feedback_iv1.setVisibility(View.GONE);
                feedback_iv2.setVisibility(View.VISIBLE);
                feedback_iv3.setVisibility(View.GONE);
                feedback_iv4.setVisibility(View.GONE);
                feedback_iv5.setVisibility(View.GONE);
                break;
            case R.id.feedback_rela3:
                feedback_iv1.setVisibility(View.GONE);
                feedback_iv2.setVisibility(View.GONE);
                feedback_iv3.setVisibility(View.VISIBLE);
                feedback_iv4.setVisibility(View.GONE);
                feedback_iv5.setVisibility(View.GONE);
                break;
            case R.id.feedback_rela4:
                feedback_iv1.setVisibility(View.GONE);
                feedback_iv2.setVisibility(View.GONE);
                feedback_iv3.setVisibility(View.GONE);
                feedback_iv4.setVisibility(View.VISIBLE);
                feedback_iv5.setVisibility(View.GONE);
                break;
            case R.id.feedback_rela5:
                feedback_iv1.setVisibility(View.GONE);
                feedback_iv2.setVisibility(View.GONE);
                feedback_iv3.setVisibility(View.GONE);
                feedback_iv4.setVisibility(View.GONE);
                feedback_iv5.setVisibility(View.VISIBLE);
                break;
        }

    }
}
