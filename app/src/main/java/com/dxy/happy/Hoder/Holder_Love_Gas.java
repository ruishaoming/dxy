package com.dxy.happy.Hoder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dxy.happy.Hoder.BaseHolder;
import com.dxy.happy.R;
import com.dxy.happy.activity.HomeMoreActivity;
import com.dxy.happy.activity.LoveGasActivity;
import com.dxy.happy.adapter.Home_lg_ListViewAdapter;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.Fragment_LoveGasBean;
import com.dxy.happy.utils.CommonUtils;
import com.google.gson.Gson;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Love_Gas extends BaseHolder implements View.OnClickListener {

    private final ListView lv1_love_gas;
    private Home_lg_ListViewAdapter adapter;
    private String url;
    private final TextView tv_more;
    private Context context;

    public Holder_Love_Gas(View itemView) {
        super(itemView);

        lv1_love_gas = (ListView) itemView.findViewById(R.id.lv1_love_gas);
        tv_more = (TextView) itemView.findViewById(R.id.tv_findmore);
        tv_more.setOnClickListener(this);
    }

    @Override
    public void getHolder(final Context context, Object o) {
        this.context = context;
        String url = (String) o;
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                initLoveData(reresponse, context);
            }
        }.getData(url, BaseData.NORMALTIME);


    }

    private void initLoveData(String reresponse, final Context context) {
        final Fragment_LoveGasBean fragment_loveGasBean = new Gson().fromJson(reresponse, Fragment_LoveGasBean.class);
        if (adapter == null) {
            adapter = new Home_lg_ListViewAdapter(context, fragment_loveGasBean);
            lv1_love_gas.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        lv1_love_gas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, LoveGasActivity.class);
                if (4 > position && position > 0) {
                    url = fragment_loveGasBean.getData().get(position - 1).getUrl();

                } else if (position > 4) {
                    url = fragment_loveGasBean.getData().get(position - 2).getUrl();
                } else {
                    url = fragment_loveGasBean.getData().get(position).getUrl();
                }
                if (position != 0 && position != 4) {

                    intent.putExtra("url", url);

                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_findmore:
                Intent intent = new Intent(context,HomeMoreActivity.class);
                context.startActivity(intent);
                break;
        }
    }
}
