package com.dxy.happy.Hoder;

import android.content.Context;
import android.view.View;
import android.widget.ListView;

import com.dxy.happy.R;
import com.dxy.happy.adapter.Home_lg_ListViewAdapter;
import com.dxy.happy.bean.Fragment_LoveGasBean;
import com.google.gson.Gson;

import com.dxy.happy.Hoder.BaseHolder;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_Love_Gas extends BaseHolder {

    private final ListView lv1_love_gas;
    private Home_lg_ListViewAdapter adapter;

    public Holder_Love_Gas(View itemView) {
        super(itemView);

        lv1_love_gas = (ListView) itemView.findViewById(R.id.lv1_love_gas);
    }

    @Override
    public void getHolder(Context context, Object o) {
        String o1 = (String) o;
        Fragment_LoveGasBean fragment_loveGasBean = new Gson().fromJson(o1, Fragment_LoveGasBean.class);
        if (adapter==null){
            adapter = new Home_lg_ListViewAdapter(context,fragment_loveGasBean);
            lv1_love_gas.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }


    }
}
