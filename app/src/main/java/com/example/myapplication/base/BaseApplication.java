package com.example.myapplication.base;

import android.app.Application;

import com.example.myapplication.db.DaoMaster;
import com.example.myapplication.db.DaoSession;

public class BaseApplication extends Application {

    private static BaseApplication context ;
    private static DaoSession daoSession;

    public static BaseApplication getInstance() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "my.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
