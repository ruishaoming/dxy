package com.dxy.happy.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.base.BaseData;
import com.xnl.happy.R;

/**
 * MainActivity：项目主界面
 * create:芮靖林
 * on：201612/28
 */
public class MainActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SwipeRefreshLayout
        //测试用的可删除
        tv = (TextView) findViewById(R.id.tv);
        BaseData baseData = new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                tv.setText(reresponse);
            }
        };
        baseData.getData("http://www.baidu.com", baseData.NORMALTIME);
    }
}
