package com.dxy.happy.activity;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;

/**
 * autour: 吕卓钊
 * date: 2016/12/29 16:50 
 * update: 2016/12/29
 */

public class ForgetActivity extends BaseActivity {

    private CheckBox img;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        initvew();
    }

    private void initvew() {
        pwd = (EditText) findViewById(R.id.for_pwd);
        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        img = (CheckBox) findViewById(R.id.login_eye);
        img.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked)
                {

                    pwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }
}
