package com.dxy.happy.Hoder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 韩永光
 * on 2016/12/28 21:52.
 */
//定义一个抽象Holder类供所有的holder使用
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {
    public BaseHolder(View itemView) {
        super(itemView);

    }
    //定义一个抽象方法  获取数据使用
    public abstract void getHolder(Context context, T t);
}
