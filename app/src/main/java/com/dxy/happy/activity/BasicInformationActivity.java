package com.dxy.happy.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.StartUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.umeng.socialize.Config.dialog;

public class BasicInformationActivity extends BaseActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private Calendar mCalendar;
    private TextView basic_information_birthday;
    private TextView basic_information_star;
    private TextView basic_information_profession;
    private ImageView basic_information_icon;
    private TextView basic_information_relationship_status;
    private TextView basic_information_name;
    public static final int NEW_NAME = 200;
    private String title;
    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_information);
        title = getIntent().getStringExtra("title");
        state = getIntent().getStringExtra("state");
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("基本信息");
        basic_information_profession = (TextView) findViewById(R.id.basic_information_profession);
        basic_information_icon = (ImageView) findViewById(R.id.basic_information_icon);
        basic_information_relationship_status = (TextView) findViewById(R.id.basic_information_relationship_status);
        basic_information_relationship_status.setText(state);
        basic_information_name = (TextView) findViewById(R.id.basic_information_name);
        basic_information_profession.setText(title);
        basic_information_birthday = (TextView) findViewById(R.id.basic_information_birthday);
        basic_information_star = (TextView) findViewById(R.id.basic_information_star);
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        findViewById(R.id.basic_information_rela_icon).setOnClickListener(this);
        findViewById(R.id.basic_information_rela_name).setOnClickListener(this);
        findViewById(R.id.basic_information_rela__birthday).setOnClickListener(this);
        findViewById(R.id.basic_information_rela_profession).setOnClickListener(this);
        findViewById(R.id.basic_information_rela_relationship_status).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_return_back:
                CommonUtils.finishActivity(BasicInformationActivity.this);
                break;
            //头像
            case R.id.basic_information_rela_icon:
                break;
            //昵称
            case R.id.basic_information_rela_name:
            CommonUtils.startActivity(BasicInformationActivity.this,ChangeNameActivity.class);

                break;
            //生日
            case R.id.basic_information_rela__birthday:
                showDatePickerDialog();
                break;
            //职业
            case R.id.basic_information_rela_profession:
                CommonUtils.startActivity(BasicInformationActivity.this,ChooseCareerActivity.class);
                break;
            //感情状况
            case R.id.basic_information_rela_relationship_status:
                CommonUtils.startActivity(BasicInformationActivity.this,EmotioActivity.class);
                break;

        }

    }
    private void showDatePickerDialog() {
        //获得日历的对象
        mCalendar = Calendar.getInstance();
        //创建一个DatePickerDialog的对象
        DatePickerDialog datedialog = new DatePickerDialog(BasicInformationActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                mCalendar.set(i, i1, i2);
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                basic_information_birthday.setText(i + "." + (i1 + 1) + "." + i2);
                String starSeat = StartUtils.getStarSeat(i1 + 1, i2);
                basic_information_star.setText(starSeat);
            }
        }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        Window dialogWindow = datedialog.getWindow();
        dialogWindow.setGravity( Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;

        dialogWindow.setAttributes(lp);
        datedialog.show();

    }
}
