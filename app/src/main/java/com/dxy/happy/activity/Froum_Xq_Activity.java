package com.dxy.happy.activity;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.dxy.happy.R;
import com.dxy.happy.adapter.XqAdapter;
import com.dxy.happy.base.BaseActivity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.ForumTop_Bean;
import com.dxy.happy.bean.HomeCommunityBean;
import com.dxy.happy.utils.CommonUtils;
import com.google.gson.Gson;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Froum_Xq_Activity extends BaseActivity implements View.OnClickListener {
    private ForumTop_Bean.DataBean data1;
    private String url;
    private RecyclerView xq_recyclerView;
    private ImageView imageView_xq;
    private Button button_xq;
    private AutoRelativeLayout viewrrr;

    private ImageView hear3;
    private ImageView hear4;
    private ImageView hear5;
    private ImageView hear2;
    private boolean flag=true;
    private HomeCommunityBean homeCommunityBean;
    private TextView zan;
    private int nice;
    private ImageView imageView_xq1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_froum__xq_);
        data1 = (ForumTop_Bean.DataBean) getIntent().getSerializableExtra("data2");

        initView();
        String url = "http://www.yulin520.com/a2a/forumReply/detailedShow?pageSize=10&id=" + data1.getId() + "&sign=8783406554DDD2920DC61FAC5F6A7811&sort=1&ts=1768501243&page=1";
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                homeCommunityBean = new Gson().fromJson(reresponse, HomeCommunityBean.class);
                TextView size = (TextView) findViewById(R.id._listViewsize);
                size.setText("("+homeCommunityBean.getData().size()+")");
                xq_recyclerView.setLayoutManager(new LinearLayoutManager(Froum_Xq_Activity.this));
                List<HomeCommunityBean.DataBean> data = homeCommunityBean.getData();
                if (data.size() > 0) {
                    xq_recyclerView.setAdapter(new XqAdapter(Froum_Xq_Activity.this, data));
                    int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.abc_action_bar_content_inset_material);
                    xq_recyclerView.addItemDecoration(new SpaceItemDecoration(spacingInPixels));
                    imageView_xq.setVisibility(View.GONE);
                    button_xq.setVisibility(View.VISIBLE);
                } else {
                    imageView_xq.setVisibility(View.VISIBLE);
                    button_xq.setVisibility(View.GONE);
                }

            }
        }.getData(url, BaseData.NORMALTIME);

    }

    private void initView() {
        final ImageView imageView_haed = (ImageView) findViewById(R.id.image_tou_xq2);
        Glide.with(this).load(data1.getHeadImg()).asBitmap().centerCrop().into(new BitmapImageViewTarget(imageView_haed) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(Froum_Xq_Activity.this.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView_haed.setImageDrawable(circularBitmapDrawable);
            }
        });
        AutoLinearLayout imageView_xq1 =  (AutoLinearLayout) findViewById(R.id.linear_image_xq);
        if (data1.getImgs() != null && data1.getImgs().size() > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            for (int i = 0; i < data1.getImgs().size(); i++) {
                ImageView imageView = new ImageView(Froum_Xq_Activity.this);
                Glide.with(Froum_Xq_Activity.this).load(data1.getImgs().get(i).getMiniImg()).into(imageView);
                imageView_xq1.addView(imageView, layoutParams);
            }
        }
        findViewById(R.id.forum_back_xq2).setOnClickListener(this);
        button_xq = (Button) findViewById(R.id.button_xq);
        TextView textView_year = (TextView) findViewById(R.id.year_xq2);
        TextView textView_context = (TextView) findViewById(R.id.xq_context2);
        textView_context.setText(data1.getContent());
        imageView_xq = (ImageView) findViewById(R.id.ImageView_xq);
        xq_recyclerView = (RecyclerView) findViewById(R.id.xq_RecyclerView);
        xq_recyclerView.setFocusable(false);

        TextView text_time = (TextView) findViewById(R.id.time_xq2);
        textView_year.setText(data1.getUserName());
        Date d = new Date(data1.getTopTime());//"yyyy-MM-dd hh:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm");
        text_time.setText(sdf.format(d));
        zan = (TextView) findViewById(R.id.count_zan);
        zan.setText(data1.getNice()+"");
        CheckBox checkbox = (CheckBox) findViewById(R.id.xq_checkbox);
        hear3 = (ImageView) findViewById(R.id.hear3);
        hear4 = (ImageView) findViewById(R.id.hear4);
        hear5 = (ImageView) findViewById(R.id.hear5);
        hear2 = (ImageView) findViewById(R.id.hear2);
        nice=data1.getNice();
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {

                    hear3.setVisibility(View.VISIBLE);
                    hear4.setVisibility(View.VISIBLE);
                    hear5.setVisibility(View.VISIBLE);
                    hear2.setVisibility(View.VISIBLE);
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(hear3, View.TRANSLATION_Y, 0, -50, -150, -300, -50, 20, 0);
                    objectAnimator.setDuration(3000);
                    objectAnimator.start();
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(hear4, View.ROTATION_Y, 0, -80, -200, -500, -80, 60, 0);
                    objectAnimator2.setDuration(3000);
                    objectAnimator2.start();
                    ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(hear5, View.TRANSLATION_X, 0, -40, -240, -500, -100, 0);
                    objectAnimator3.setDuration(3000);
                    objectAnimator3.start();
                    ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(hear2, View.TRANSLATION_X, 0, 80, 200, 500, 80, 60, 0);
                    objectAnimator4.setDuration(3000);
                    objectAnimator4.start();
                    nice=data1.getNice()+1;
                    zan.setText(nice+"");
                    flag=false;
                } else
                {
                    hear2.setVisibility(View.GONE);
                    hear3.setVisibility(View.GONE);
                    hear4.setVisibility(View.GONE);
                    hear5.setVisibility(View.GONE);
                    nice=data1.getNice();
                    zan.setText(nice+"");
                    flag=true;
                }
            }


        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forum_back_xq2:
                CommonUtils.finishActivity(this);
                break;
        }
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        public int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            if (parent.getChildPosition(view) != 0)
                outRect.top = space;
        }
    }


}
