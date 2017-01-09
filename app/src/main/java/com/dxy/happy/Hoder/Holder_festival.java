package com.dxy.happy.Hoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dxy.happy.R;
import com.dxy.happy.activity.HomeFestivalActivity;
import com.dxy.happy.base.BaseData;
import com.dxy.happy.bean.Fragment_FestivalBean;
import com.dxy.happy.utils.CommonUtils;
import com.dxy.happy.utils.LogUtils;
import com.google.gson.Gson;

import static com.umeng.socialize.utils.DeviceConfig.context;

/**
 * Created by 韩永光
 * on 2016/12/28 22:12.
 */
public class Holder_festival extends BaseHolder{

    private final ImageView img_festival;
    private final TextView tv_festival;
    private final TextView tv_day_festival;
    private WebView webView;
    private Activity activity;
    private PopupWindow popupWindow;

    public Holder_festival(View itemView) {
        super(itemView);
        img_festival = (ImageView) itemView.findViewById(R.id.img_festival);
        tv_festival = (TextView) itemView.findViewById(R.id.tv_festival);
        tv_day_festival = (TextView) itemView.findViewById(R.id.tv_day_festival);
    }

    @Override
    public void getHolder(final Context context, Object o) {
        this.activity = (Activity) context;
        String url = (String) o;
        new BaseData() {
            @Override
            public void setResultData(String reresponse) {
                initData(reresponse, context);
            }
        }.getData(url, BaseData.NORMALTIME);

    }

    private void initData(String reresponse, final Context context) {
        final Fragment_FestivalBean fragment_festivalBean = new Gson().fromJson(reresponse, Fragment_FestivalBean.class);
        Glide.with(context).load(fragment_festivalBean.getData().getImg()).into(img_festival);
        //popupwindow设置
        initPop(context, fragment_festivalBean);
        tv_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeFestivalActivity.class);
                intent.putExtra("url", fragment_festivalBean.getData().getRemark());
                context.startActivity(intent);

            }
        });
    }

    private void initPop(final Context context, final Fragment_FestivalBean fragment_festivalBean) {
        //popupwindow设置
        final View view = CommonUtils.inflate(R.layout.home_festival_pop);
        webView = (WebView) view.findViewById(R.id.home_festival_webview);
        img_festival.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow = new PopupWindow(context);
                popupWindow.setContentView(view);
                popupWindow.setFocusable(true);
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(750);
                webView.loadUrl(fragment_festivalBean.getData().getHolidayDetails());
                setBackgroundAlpha(0.7f);
                popupWindow.showAtLocation(view, 10, 0, 0);
                //监听PopupWindow关闭
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        setBackgroundAlpha(1f);
                    }
                });
            }
        });

    }

    //设置当前窗口背景背景
    public void setBackgroundAlpha(float getAlpha) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = getAlpha;
        activity.getWindow().setAttributes(params);
    }

}
