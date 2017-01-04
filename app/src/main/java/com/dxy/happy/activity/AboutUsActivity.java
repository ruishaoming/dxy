package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;

public class AboutUsActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;
    String url = "http://www.yulin520.com/a2a/h/i/yulin/agreement";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("关于我们");
      findViewById(R.id.about_us_welcome).setOnClickListener(this);
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        findViewById(R.id.about_us_user_agreement).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_us_welcome:
                break;
            case R.id.mine_return_back:
                CommonUtils.finishActivity(AboutUsActivity.this);
                break;
            case R.id.about_us_user_agreement:
                Intent intent = new Intent(AboutUsActivity.this,AgreementActivity.class);
                intent.putExtra("webUrl",url);
                startActivity(intent);
                break;
        }
    }
}
