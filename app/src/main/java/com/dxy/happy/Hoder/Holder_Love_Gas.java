package com.dxy.happy.Hoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.dxy.happy.R;
import com.dxy.happy.activity.HomeMoreActivity;
import com.dxy.happy.activity.LoveGasActivity;
import com.dxy.happy.adapter.Home_lg_ListViewAdapter;
import com.dxy.happy.bean.Fragment_LoveGasBean;
import com.dxy.happy.utils.CommonUtils;
import com.google.gson.Gson;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Love_Gas extends BaseHolder {

    private final ListView lv1_love_gas;
    private Home_lg_ListViewAdapter adapter;
    private String url;
    private final TextView tv_findmore;

    public Holder_Love_Gas(View itemView) {
        super(itemView);

        lv1_love_gas = (ListView) itemView.findViewById(R.id.lv1_love_gas);
        tv_findmore = (TextView) itemView.findViewById(R.id.tv_findmore);
    }

    @Override
    public void getHolder(final Context context, Object o) {
        String o1 = (String) o;
        final Fragment_LoveGasBean fragment_loveGasBean = new Gson().fromJson(o1, Fragment_LoveGasBean.class);
        if (adapter==null){
            adapter = new Home_lg_ListViewAdapter(context,fragment_loveGasBean);
            lv1_love_gas.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
        //listview点击事件
        initListView(context, fragment_loveGasBean);
        tv_findmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtils.startActivity((Activity) context, HomeMoreActivity.class);
            }
        });


    }

    private void initListView(final Context context, final Fragment_LoveGasBean fragment_loveGasBean) {
        lv1_love_gas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(context, LoveGasActivity.class);
                if(4>position&&position>0){
                    url = fragment_loveGasBean.getData().get(position-1).getUrl();

                }else if(position>4){
                    url = fragment_loveGasBean.getData().get(position-2).getUrl();
                }
                else{
                    url = fragment_loveGasBean.getData().get(position).getUrl();
                }
                if(position!=0&&position!=4){

                    intent.putExtra("url",url);

                    context.startActivity(intent);
                }
            }
        });
    }
}
