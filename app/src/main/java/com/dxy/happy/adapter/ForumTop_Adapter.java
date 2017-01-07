package com.dxy.happy.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dxy.happy.Hoder.BaseHolder;
import com.dxy.happy.Hoder.ForumTop_Holder;
import com.dxy.happy.Hoder.Holder_NoImage;
import com.dxy.happy.Hoder.LoadMoreHolder;
import com.dxy.happy.R;
import com.dxy.happy.bean.ForumTop_Bean;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张天成
 * on 2016/12/30 16:56.
 */
public class ForumTop_Adapter extends RecyclerView.Adapter<BaseHolder> {
    private final Context context;
    private final List<ForumTop_Bean.DataBean> list;
    private final List<String> listTitle = new ArrayList<>();
    private final int NOIMAGE = 0;
    private final int ONEIMAGE = 1;
    private final int TWOIMAGE = 2;
    private final int THREEIMAGE = 3;
    private final int LISTVIEWZS = 4;
    private static final int TYPE_LOAD_MORE = 5;
    private List<ForumTop_Bean.DataBean> bean_list;

    int lastPosition = -1;

    public ForumTop_Adapter(Context context, List<ForumTop_Bean.DataBean> list, List<ForumTop_Bean.DataBean> bean_list) {
        this.context = context;
        this.list = list;
        this.bean_list = bean_list;
        listTitle.clear();
        for (int i = 0; i < list.size(); i++) {
            listTitle.add(list.get(i).getTitle());
        }
    }


    View view = null;
    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseHolder holder = null;
        switch (viewType) {
            case NOIMAGE:
            case ONEIMAGE:
            case TWOIMAGE:
            case THREEIMAGE:
                view = LayoutInflater.from(context).inflate(R.layout.community_all_normal, parent, false);
                holder = new Holder_NoImage(view);

                break;
            case TYPE_LOAD_MORE:
                view = View.inflate(context, R.layout.layout_loadmore, null);
                holder = new LoadMoreHolder(view);
                break;
            case LISTVIEWZS:
                view = LayoutInflater.from(context).inflate(R.layout.layout_tiaomuyi, parent, false);
                holder = new ForumTop_Holder(view);
                break;
        }
        return holder;
    }



    @Override
    public void onViewDetachedFromWindow(BaseHolder holder) {
        super.onViewDetachedFromWindow(holder);
        view.clearAnimation();
        view.refreshDrawableState();
    }


    @Override
    public void onBindViewHolder(final BaseHolder holder, final int position) {
        if (position < bean_list.size() - 1) {
            switch (getItemViewType(position)) {
                case NOIMAGE:
                case ONEIMAGE:
                case TWOIMAGE:
                case THREEIMAGE:
                    holder.getHolder(context, bean_list.get(position - 1));
                    if (lastPosition < position) {
                        AutoLinearLayout lin_all = ((Holder_NoImage) holder).lin_all;
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(lin_all, View.TRANSLATION_Y, 300, 0);
                        objectAnimator.setDuration(300);
                        objectAnimator.start();
                    }
                    lastPosition = position;
//                    startAnimation(lin_all, position);
                    break;
                case LISTVIEWZS:
                    ForumTop_Holder holder4 = (ForumTop_Holder) holder;
                    holder4.listView.setAdapter(new CommonAdapter<String>(context, R.layout.layout_tiaomuyi_listitem, listTitle) {
                        @Override
                        protected void convert(ViewHolder viewHolder, String item, int itemposition) {
                            TextView textView = viewHolder.getView(R.id.tiaomuyi_listTextView);
                            textView.setText(listTitle.get(itemposition));
                        }
                    });
                    break;
            }
        }
    }


    @Override
    public int getItemCount() {
        return bean_list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < bean_list.size()) {
            if (position == 0) {
                return LISTVIEWZS;
            } else if (bean_list.get(position).getImgs().size() == 1) {
                return ONEIMAGE;
            } else if (bean_list.get(position).getImgs().size() == 2) {
                return TWOIMAGE;
            } else if (bean_list.get(position).getImgs().size() == 3) {
                return THREEIMAGE;
            }
           }else if (position == (bean_list.size() + 2)) {
                  return TYPE_LOAD_MORE;
        }
        return NOIMAGE;
    }


}
