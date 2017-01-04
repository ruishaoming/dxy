package com.dxy.happy.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.bean.Fragment_LoveGasBean;
import com.dxy.happy.utils.CommonUtils;

/**
 * Created by 韩永光
 * on 2017/1/3 12:19.
 */
public class Home_lg_ListViewAdapter extends BaseAdapter {
    final int type1 = 0;
    final int type2 = 1;
    private final Context context;
    private final Fragment_LoveGasBean fragment_loveGasBean;
    private View view;

    public Home_lg_ListViewAdapter(Context context, Fragment_LoveGasBean fragment_loveGasBean) {
        this.context = context;
        this.fragment_loveGasBean = fragment_loveGasBean;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {

            case type1:
                view = CommonUtils.inflate(R.layout.lg_type1);
                TextView lg_date = (TextView) view.findViewById(R.id.lg_date);

                if (position == 0) {

                    String startTime = fragment_loveGasBean.getData().get(0).getStartTime();
                    if (startTime != null) {
                        String substring = startTime.substring(5, 11);
                        lg_date.setText("---" + substring + "---");
                    }

                } else if (position == 4) {
                    String startTime = fragment_loveGasBean.getData().get(4).getStartTime();
                    if (startTime != null) {

                        String substring = startTime.substring(5, 11);
                        lg_date.setText("---" + substring + "---");
                    }
                }
                break;
            case type2:
                if (position < 4) {
                    position -= 1;
                } else
                    position -= 2;

                Log.i("kkkkkk", "getView: ......" + position);
                view = CommonUtils.inflate(R.layout.lg_type2);
                TextView lg_title = (TextView) view.findViewById(R.id.lg_title);
                TextView contentIntr = (TextView) view.findViewById(R.id.lg_contentIntr);
                TextView lg_author = (TextView) view.findViewById(R.id.lg_author);
                ImageView lg_img = (ImageView) view.findViewById(R.id.lg_img);
                lg_title.setText(fragment_loveGasBean.getData().get(position).getTitle());

                contentIntr.setText(fragment_loveGasBean.getData().get(position).getContentIntr().substring(0, 30));
                Glide.with(context).load(fragment_loveGasBean.getData().get(position).getImg()).into(lg_img);
                lg_author.setText(fragment_loveGasBean.getData().get(position).getReporterName());
                break;
        }
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 4) {
            return type1;
        } else {
            return type2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
