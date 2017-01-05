package com.dxy.happy.Hoder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.dxy.happy.R;
import com.dxy.happy.view.MyListView;

/**
 * Created by 张天成
 * on 2016/12/30 16:58.
 */
public class ForumTop_Holder extends BaseHolder {

    public MyListView listView;
    public LinearLayout lin_all;

    public ForumTop_Holder(View itemView) {
        super(itemView);
        listView = (MyListView) itemView.findViewById(R.id.listView_tiaomuyi);
        lin_all = (LinearLayout) itemView.findViewById(R.id.lin_all);
    }

    @Override
    public void getHolder(Context context, Object o) {

    }
}
