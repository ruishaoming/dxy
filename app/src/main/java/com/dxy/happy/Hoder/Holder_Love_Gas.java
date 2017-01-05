package com.dxy.happy.Hoder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dxy.happy.R;
import com.dxy.happy.activity.LoveGasActivity;
import com.dxy.happy.adapter.Home_lg_ListViewAdapter;
import com.dxy.happy.bean.Fragment_LoveGasBean;
import com.google.gson.Gson;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Love_Gas extends BaseHolder {

    private final ListView lv1_love_gas;
    private Home_lg_ListViewAdapter adapter;
    private String url;

    public Holder_Love_Gas(View itemView) {
        super(itemView);

        lv1_love_gas = (ListView) itemView.findViewById(R.id.lv1_love_gas);
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
