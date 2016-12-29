package com.dxy.happy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dxy.happy.adapter.LaunchAdapter;
import com.xnl.happy.R;

import java.util.ArrayList;

/**
 * autour: 吕卓钊
 * date: 2016/12/28 21:01
 * update: 2016/12/28
 */

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private ArrayList<ImageView> list=new ArrayList<>();
    private LinearLayout linearLayout;
    private boolean isFirstIn;
    ImageView imageView;
    private ImageView btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        SharedPreferences pref = this.getSharedPreferences("myActivityName", MODE_PRIVATE);
        //取得相应的值，如果没有该值， 说明还未写入，用true作为默认值
        isFirstIn = pref.getBoolean("isFirstIn", true);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isFirstIn", false);
        editor.commit();
        initview();
        if(isFirstIn == true){
            initdata();
            addPoints();
            setPagerListener();
        }else {
            jump();
        }





    }
/**
 * autour: 吕卓钊
 * date: 2016/12/29 11:17
 * update: 2016/12/29
 * 数据源
 */

    private void initdata() {
        ImageView img1=new ImageView(LaunchActivity.this);
        img1.setImageResource(R.mipmap.introductory1_xhdpi);
        img1.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView img2=new ImageView(LaunchActivity.this);
        img2.setImageResource(R.mipmap.introductory2_xhdpi);
        img2.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView img3=new ImageView(LaunchActivity.this);
        img3.setImageResource(R.mipmap.introductory3_xhdpi);
        img3.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView img4=new ImageView(LaunchActivity.this);
        img4.setImageResource(R.mipmap.introductory4_xhdpi_meitu_1);
        img4.setScaleType(ImageView.ScaleType.FIT_XY);
        list.add(img1); list.add(img2); list.add(img3); list.add(img4);
        viewPager.setAdapter(new LaunchAdapter(LaunchActivity.this,list,btn));
    }

    //注册监听，当pager变化，切换圆点颜色
    private void setPagerListener() {
        switchPoint(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switchPoint(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //遍历圆点，如果id为选中位置就切换颜色
    private void switchPoint(int position) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            imageView = (ImageView) linearLayout.getChildAt(i);
            if (i == position) {
                imageView.setImageResource(R.mipmap.abc_btn_radio_to_on_mtrl_015);
            } else {
                imageView.setImageResource(R.mipmap.abc_btn_radio_to_on_mtrl_000);
            }
        }

    }


    //添加圆点
    private void addPoints() {

        for (int i = 0; i < list.size(); i++) {
            ImageView imgPoint = new ImageView(this);
            imgPoint.setImageResource(R.mipmap.abc_btn_radio_to_on_mtrl_000);
            //设置布局属性
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(5, 5, 5, 5);
            imgPoint.setLayoutParams(lp);
            //将添加的小圆点，加到布局中
            linearLayout.addView(imgPoint);
        }
    }


    private void initview() {
        viewPager = (ViewPager) findViewById(R.id.launch_vp);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout_points);
        btn = (ImageView) findViewById(R.id.launch_btn);
        btn.setOnClickListener(this);


    }


    private void jump() {
        Intent intent=new Intent(LaunchActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        Intent intent1=new Intent(LaunchActivity.this,LoginActivity.class);
        startActivity(intent1);
    }
}
