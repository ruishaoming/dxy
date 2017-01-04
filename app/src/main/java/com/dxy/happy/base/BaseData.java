package com.dxy.happy.base;

import android.text.TextUtils;

import com.android.volley.VolleyError;
import com.dxy.happy.app.XnlApplication;
import com.dxy.happy.bean.DataBean;
import com.dxy.happy.dao.DataDao;
import com.dxy.happy.utils.LogUtils;
import com.dxy.happy.view.VolleySingleton;

import java.io.File;

/**
 * Created by 乔智锋
 * on 2016/12/28 19:11.
 */

public abstract class BaseData {
    //储存时间
    public static final int NOTIME = 0;
    public static final int NORMALTIME = 3 * 24 * 60 * 60 * 1000;
    DataDao dao = new DataDao(XnlApplication.getContext());

    public BaseData() {
        File cacheDir = XnlApplication.getContext().getCacheDir();
        File fileDir = new File(cacheDir, "xiaoningle");
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
    }

    public void getData(String path, int validTime) {
        //为0直接访问网络
        if (validTime == 0) {
            getDataFromNet(path, validTime);
        } else {
            DataBean dataBeen = dao.quaryBaseData(path);
            LogUtils.i("TAG","从数据库取数据");
            if (dataBeen == null || TextUtils.isEmpty(dataBeen.getData())) {
                getDataFromNet(path, validTime);
            } else {
                setResultData(dataBeen.getData());
            }
        }
    }

    public void getDataFromNet(final String path, final int validTime) {
        XnlApplication.inStance.getUrl(path, XnlApplication.getContext(), new VolleySingleton.ResuleCallBack() {
            @Override
            public void onResponse(String reresponse) {
                //抽象返回的结果
                if (validTime != 0) {
                    //写入数据库
                    writeDataToDb(reresponse, path, (int) (System.currentTimeMillis() + validTime));
                }
                setResultData(reresponse);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    public void writeDataToDb(String reresponse, String path, int validTime) {
        dao.addBaseData(new DataBean(path, reresponse + "", validTime + ""));
    }

    public abstract void setResultData(String reresponse);
}
