package com.dxy.happy.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.dxy.happy.R;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.StartUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private RippleView rippleView1;
    private RippleView rippleView2;
    private RippleView rippleView3;
    private RippleView rippleView4;
    private RippleView rippleView5;
    private RippleView rippleView6;

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
        rippleView1 = (RippleView) findViewById(R.id.rippleView1);
        rippleView2 = (RippleView) findViewById(R.id.rippleView2);
        rippleView3 = (RippleView) findViewById(R.id.rippleView3);
        rippleView4 = (RippleView) findViewById(R.id.rippleView4);
        rippleView5 = (RippleView) findViewById(R.id.rippleView5);
        rippleView6 = (RippleView) findViewById(R.id.rippleView6);
        findViewById(R.id.constellation).setOnClickListener(this);
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
                startActivity(new Intent(BasicInformationActivity.this, HeaderPhotoActivity.class));
                break;
            //昵称
            case R.id.basic_information_rela_name:
                rippleView2.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                    @Override
                    public void onComplete(RippleView rippleView) {
                        CommonUtils.startActivity(BasicInformationActivity.this, ChangeNameActivity.class);

                    }
                });

                break;
            //生日
            case R.id.basic_information_rela__birthday:
                rippleView3.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                    @Override
                    public void onComplete(RippleView rippleView) {
                        showDatePickerDialog();

                    }
                });
                break;
            //星座
            case  R.id.constellation:

                break;
            //职业
            case R.id.basic_information_rela_profession:
                rippleView5.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                    @Override
                    public void onComplete(RippleView rippleView) {
                        CommonUtils.startActivity(BasicInformationActivity.this, ChooseCareerActivity.class);

                    }
                });
                break;
            //感情状况
            case R.id.basic_information_rela_relationship_status:
                rippleView6.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                    @Override
                    public void onComplete(RippleView rippleView) {
                        CommonUtils.startActivity(BasicInformationActivity.this, EmotioActivity.class);

                    }
                });
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
                //  Toast.makeText(getActivity(), "" + format.format(mCalendar.getTime()), Toast.LENGTH_SHORT).show();
                basic_information_birthday.setText(i + "." + (i1 + 1) + "." + i2);
                String starSeat = StartUtils.getStarSeat(i1 + 1, i2);
                basic_information_star.setText(starSeat);
            }
        }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        datedialog.show();
    }
}