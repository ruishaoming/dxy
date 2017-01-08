package com.dxy.happy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.adapter.MyChooseCareerAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.ChooseCareerBean;
import com.dxy.happy.interfaces.OnItemClickListener;
import com.dxy.happy.utils.CommonUtils;
import com.google.gson.Gson;

public class ChooseCareerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mine_title_text;
    private TextView mine_feedback_commit;
    private RecyclerView recyclerView;
    String path = "http://www.yulin520.com/a2a/occupation/menu";
    private ChooseCareerBean chooseCareerBean;
    private MyChooseCareerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_career);
        mine_title_text = (TextView) findViewById(R.id.mine_title_text);
        mine_title_text.setText("选择职业");
        mine_feedback_commit = (TextView) findViewById(R.id.mine_feedback_commit);
        mine_feedback_commit.setText("取消");
        mine_feedback_commit.setVisibility(View.VISIBLE);
        findViewById(R.id.mine_return_back).setOnClickListener(this);
        mine_feedback_commit.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.choose_career_recyclerView);
        initData();


    }

    private void initData() {
        BaseData baseData = new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                Gson gson = new Gson();
                chooseCareerBean = gson.fromJson(reresponse, ChooseCareerBean.class);

                recyclerView.setLayoutManager(new LinearLayoutManager(ChooseCareerActivity.this));
                adapter = new MyChooseCareerAdapter(ChooseCareerActivity.this, chooseCareerBean.getData());
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Intent intent = new Intent(ChooseCareerActivity.this,BasicInformationActivity.class);
                        intent.putExtra("title",chooseCareerBean.getData().get(position).getTitle());
                        startActivity(intent);
                    }
                });

            }

        };
        baseData.getData(path,BaseData.NORMALTIME);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_return_back:
                CommonUtils.finishActivity(ChooseCareerActivity.this);
                break;
            case R.id.mine_feedback_commit:
                CommonUtils.finishActivity(ChooseCareerActivity.this);
                break;
        }

    }
}
