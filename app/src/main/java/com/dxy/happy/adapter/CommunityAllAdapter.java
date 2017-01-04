package com.dxy.happy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.bean.CommunityAllBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 乔智锋
 * on 2016/12/30 17:05.
 */
public class CommunityAllAdapter extends RecyclerView.Adapter<CommunityAllAdapter.CommunityAllHolder> {
    List<CommunityAllBean.DataEntity> list;
    Context context;
    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_NOEIMG = 1;
    private static final int TYPE_TWOIMG = 2;
    private static final int TYPE_MORIMG = 3;
    private static final int TYPE_MASTIMG = 4;
    int lastPosition = -1;

    //定义条目动画
    public void startAnimation(View view, int position) {
        if (position > lastPosition) {
            //设置动画
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.item_move);
            //开启动画
            view.startAnimation(animation);
            lastPosition = position;
        }
    }

    public CommunityAllAdapter(List<CommunityAllBean.DataEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CommunityAllHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommunityAllHolder communityAllHolder = null;
        View view = null;
        switch (viewType) {
            case TYPE_NOEIMG:
                view = View.inflate(context, R.layout.community_all_moreimg, null);
                communityAllHolder = new CommunityAllHolder(view);
                communityAllHolder.two_img2.setVisibility(View.GONE);
                communityAllHolder.two_img3.setVisibility(View.GONE);
                break;
            case TYPE_TWOIMG:
                view = View.inflate(context, R.layout.community_all_moreimg, null);
                communityAllHolder = new CommunityAllHolder(view);
                communityAllHolder.two_img3.setVisibility(View.GONE);
                break;
            case TYPE_MORIMG:
                view = View.inflate(context, R.layout.community_all_moreimg, null);
                communityAllHolder = new CommunityAllHolder(view);
                break;
            case TYPE_MASTIMG:
                view = View.inflate(context, R.layout.community_all_moreimg, null);
                communityAllHolder = new CommunityAllHolder(view);
                break;
            default:
                view = View.inflate(context, R.layout.community_all_adapter_narmal, null);
                communityAllHolder = new CommunityAllHolder(view);
                break;
        }
        return communityAllHolder;
    }

    @Override
    public int getItemViewType(int position) {
        //通过对其图片多少的判断来进行多条目的判断
        //正常条目
        if (list.get(position).getImgs().size() == 1) {
            return TYPE_NOEIMG;
        } else if (list.get(position).getImgs().size() == 2) {
            return TYPE_TWOIMG;
        } else if (list.get(position).getImgs().size() == 3) {
            return TYPE_MORIMG;
        } else if (list.get(position).getImgs().size() > 3) {
            return TYPE_MASTIMG;
        }
        return TYPE_NORMAL;
    }


    @Override
    public void onBindViewHolder(CommunityAllHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (list.get(position).getUserName() != null) {
            holder.community_name.setText(list.get(position).getUserName());
        }
        if (!TextUtils.isEmpty(list.get(position).getCreateTime() + "")) {
            Date d = new Date(list.get(position).getCreateTime());//"yyyy-MM-dd hh:mm:ss"
            SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm");
            holder.community_time.setText(sdf.format(d));
        }
        if (!TextUtils.isEmpty(list.get(position).getReplyTimes() + "")) {
            holder.community_number.setText("0");
        }
        if (list.get(position).getTitle() != null) {
            holder.community_title.setText(list.get(position).getTitle());
        }

        switch (itemViewType) {
            case TYPE_NORMAL:
                if (list.get(position).getContent() != null) {
                    if (list.get(position).getContent().length() > 35) {
                        holder.community_content.setText(list.get(position).getContent().substring(0, 30) + "...");
                    }
                } else {
                    holder.community_content.setText("");
                }
                break;
            case TYPE_NOEIMG:
                Glide.with(context).
                        load(list.get(position).getImgs().get(0).getMiniImg())
                        .into(holder.two_img1);
                break;
            case TYPE_TWOIMG:
                Glide.with(context).
                        load(list.get(position).getImgs().get(0).getMiniImg())
                        .into(holder.two_img1);
                Glide.with(context).
                        load(list.get(position).getImgs().get(1).getMiniImg())
                        .into(holder.two_img2);
                break;
            case TYPE_MORIMG:
                Glide.with(context).
                        load(list.get(position).getImgs().get(0).getMiniImg())
                        .into(holder.two_img1);
                Glide.with(context).
                        load(list.get(position).getImgs().get(1).getMiniImg())
                        .into(holder.two_img2);
                Glide.with(context).
                        load(list.get(position).getImgs().get(2).getMiniImg())
                        .into(holder.two_img3);
                break;
            case TYPE_MASTIMG:
                Glide.with(context).
                        load(list.get(position).getImgs().get(0).getMiniImg())
                        .into(holder.two_img1);
                Glide.with(context).
                        load(list.get(position).getImgs().get(1).getMiniImg())
                        .into(holder.two_img2);
                Glide.with(context).
                        load(list.get(position).getImgs().get(2).getMiniImg())
                        .into(holder.two_img3);
                holder.all_mroimg.setText("共" + list.get(position).getImgs().size() + "张");
                break;
        }
        //开启动画
        startAnimation(holder.all_autoll, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class CommunityAllHolder extends RecyclerView.ViewHolder {

        public final TextView community_title;
        public final TextView community_content;
        public final TextView community_name;
        public final TextView community_time;
        public final TextView community_number;
        public final ImageView two_img1;
        public final ImageView two_img2;
        public final ImageView two_img3;
        public final TextView all_mroimg;
        public final LinearLayout all_autoll;

        public CommunityAllHolder(View itemView) {
            super(itemView);
            community_title = (TextView) itemView.findViewById(R.id.community_title);
            community_content = (TextView) itemView.findViewById(R.id.community_content);
            community_name = (TextView) itemView.findViewById(R.id.community_name);
            community_time = (TextView) itemView.findViewById(R.id.community_time);
            community_number = (TextView) itemView.findViewById(R.id.community_number);
            all_mroimg = (TextView) itemView.findViewById(R.id.all_mroimg);
            all_autoll = (LinearLayout) itemView.findViewById(R.id.all_autoll);
            two_img1 = (ImageView) itemView.findViewById(R.id.two_img1);
            two_img2 = (ImageView) itemView.findViewById(R.id.two_img2);
            two_img3 = (ImageView) itemView.findViewById(R.id.two_img3);
        }
    }
}
