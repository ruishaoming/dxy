package com.dxy.happy.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dxy.happy.bean.DataBean;

/**
 * Created by 乔智锋
 * on 2016/12/28 20:36.
 */

public class DataDao {

    private final MySqliteOpenHelper mySqliteOpenHelper;
    private DataBean dataBean;

    public DataDao(Context context) {
        mySqliteOpenHelper = new MySqliteOpenHelper(context);
    }

    public void addBaseData(DataBean dataBean) {
        SQLiteDatabase db = mySqliteOpenHelper.getWritableDatabase();
        Cursor cursor = db.query("basedata", null, "path = ?", new String[]{dataBean.getPath()}, null, null, null);
        while (cursor.moveToNext()) {
            //过了有效时间的话修改“时间”和“数据”
            upDataOrTime(dataBean, db, cursor);
            return;
        }
        db.execSQL("insert into basedata (path,data,time) values(?,?,?)", new String[]{dataBean.getPath(), dataBean.getData(), dataBean.getTime()});
        db.close();
    }

    private void upDataOrTime(DataBean dataBean, SQLiteDatabase db, Cursor cursor) {
        String time = cursor.getString(cursor.getColumnIndex("time"));
        if (Integer.parseInt(time) - System.currentTimeMillis() < 0) {
            ContentValues values = new ContentValues();
            values.put("time", dataBean.getTime());
            values.put("data", dataBean.getData());
            db.update("basedata", values, "path = ?", new String[]{dataBean.getPath()});
            db.close();
        }
    }

    public DataBean quaryBaseData(String url) {
        SQLiteDatabase db = mySqliteOpenHelper.getReadableDatabase();
        Cursor cursor = db.query("basedata", null, "path = ?", new String[]{url}, null, null, null);

        while (cursor.moveToNext()) {
            String paht = cursor.getString(cursor.getColumnIndex("path"));
            String data = cursor.getString(cursor.getColumnIndex("data"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            dataBean = new DataBean(paht, data, time);
        }
        return dataBean;
    }


}
