package com.dxy.happy.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 乔智锋
 * on 2016/12/28 20:32.
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    public MySqliteOpenHelper(Context context) {
        super(context, "xiaoningle", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table basedata(_id integer primary key autoincrement,path varchar(1000),data varchar(10000),time varchar(1000))");
        db.execSQL("create table logindata(_id integer primary key autoincrement,name varchar(20),pwd varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
