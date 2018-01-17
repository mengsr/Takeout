package com.example.base.model.db.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.base.MyApplication;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by mengshirui on 2017/12/25 0025.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASENAME = "ontim.db";
    private static final int DATABASEVERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    public DBHelper dbHelper;

    public DBHelper getDbHelper() {
        if(dbHelper == null){
            synchronized (DBHelper.class){
                if(dbHelper ==null)
                dbHelper = new DBHelper(MyApplication.getContext());
            }
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
