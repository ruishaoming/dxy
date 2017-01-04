package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by 吕卓钊
 * on 2016/12/28 20:44.
 */
public class LaunchAdapter extends PagerAdapter {


    private final Button button;
    private Context context;
    private ArrayList<ImageView> list=new ArrayList<>();

    public LaunchAdapter(Context context, ArrayList<ImageView> list, Button button) {
        this.context = context;
        this.list = list;
        this.button=button;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (position==3){
            button.setVisibility(View.VISIBLE);
        }else {
            button.setVisibility(View.GONE);
        }
             container.addView(list.get(position));
          return list.get(position);
    }

}
