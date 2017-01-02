package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dxy.happy.R;
import com.dxy.happy.hoder.BaseHolder;
import com.dxy.happy.hoder.Holder_Know;
import com.dxy.happy.hoder.Holder_Love_Community;
import com.dxy.happy.hoder.Holder_Love_Gas;
import com.dxy.happy.hoder.Holder_ViewPager;
import com.dxy.happy.hoder.Holder_festival;
import com.dxy.happy.bean.Fragment_ViewPagerBean;
import com.dxy.happy.utils.CommonUtils;

/**
 * Created by 韩永光
 * on 2016/12/29 16:18.
 */
public class Home_RecycleViewAdapter extends RecyclerView.Adapter<BaseHolder> {
    int Type = -1;
    int Type0 = 0;
    int Type1 = 1;
    int Type2 = 2;
    int Type3 = 3;
    int Type4 = 4;
    private final Context context;
    private final Fragment_ViewPagerBean fragment_viewPagerBean;

    public Home_RecycleViewAdapter(Context context, Fragment_ViewPagerBean fragment_viewPagerBean) {
        this.context = context;
        this.fragment_viewPagerBean = fragment_viewPagerBean;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //判断外层recycleview条目类型
        BaseHolder holder = null;
        if (Type == Type0) {
            View view = CommonUtils.inflate(R.layout.holder_viewpager);
            holder = new Holder_ViewPager(view);
        } else if (Type == Type1) {
            View view = CommonUtils.inflate(R.layout.holder_festival);
            holder = new Holder_festival(view);
        } else if (Type == Type2) {
            View view = CommonUtils.inflate(R.layout.holder_love_community);
            holder = new Holder_Love_Community(view);
        } else if (Type == Type3) {
            View view = CommonUtils.inflate(R.layout.holder_know);
            holder = new Holder_Know(view);
        } else if (Type == Type4) {
            View view = CommonUtils.inflate(R.layout.holder_love_gas);
            holder = new Holder_Love_Gas(view);
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {

        //调用抽象类里的抽象方法 直接传条目 在抽象类里面展示数据
        holder.getHolder(context, fragment_viewPagerBean.getData());
    }

    @Override
    public int getItemCount() {
        return fragment_viewPagerBean.getData().size();
    }

    //多条目展示  额外重写的一个方法
    @Override
    public int getItemViewType(int position) {
        //根据position设置具体的条目
        if (position == 0) {
            Type = Type0;
        }else if(position==1){
            Type = Type1;
        }
        else if(position==2){
            Type = Type2;
        }
        else if(position==3){
            Type = Type3;
        }
        else if(position==4){
            Type = Type4;
        }
        return Type;

    }
}
