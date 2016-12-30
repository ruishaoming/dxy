package com.dxy.happy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.utils.CommonUtils;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mine_title_text;

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
                break;
        }
    }
}
