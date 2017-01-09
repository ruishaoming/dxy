package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dxy.happy.Hoder.BaseHolder;
import com.dxy.happy.Hoder.Holder_LoveGasMore;
import com.dxy.happy.R;
import com.dxy.happy.bean.LoveGasMoreBean;
import com.dxy.happy.utils.CommonUtils;

import java.util.ArrayList;

/**
 * Created by 韩永光
 * on 2017/1/5 21:33.
 */
public class Home_LoveGasAdapter extends RecyclerView.Adapter<BaseHolder> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    private final Context context;
    private final ArrayList<LoveGasMoreBean.DataBean> listAll;

    public Home_LoveGasAdapter(Context context, ArrayList<LoveGasMoreBean.DataBean> listAll) {
        this.context = context;
        this.listAll = listAll;

    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        BaseHolder  holder=null;
        if (viewType == TYPE_ITEM) {
             view = CommonUtils.inflate(R.layout.lovegas_item);
             holder = new Holder_LoveGasMore(view);
            return holder;
        }
        // type == TYPE_FOOTER 返回footerView
        else if (viewType == TYPE_FOOTER) {
             view = CommonUtils.inflate(R.layout.zhengzaijiazai_item);
           holder = new FooterViewHolder(view);
           return holder;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        if(position<listAll.size()){
            holder.getHolder(context,listAll.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return listAll.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    class FooterViewHolder extends BaseHolder {


        public FooterViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void getHolder(Context context, Object o) {

        }
    }
}

