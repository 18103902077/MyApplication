package com.example.myapplication.utiles;

import com.example.myapplication.base.BaseApplication;
import com.example.myapplication.bean.LoveBean;
import com.example.myapplication.db.DaoSession;
import com.example.myapplication.db.LoveBeanDao;

import java.util.List;

public class DaoUtitles {

    public static LoveBean queryItem(LoveBean loveBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        LoveBean unique = daoSession.queryBuilder(LoveBean.class)
                .where(LoveBeanDao.Properties.MyId.eq(loveBean.getMyId()))
                .build().unique();
        return unique;
    }
    public static void insert(LoveBean loveBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        LoveBean loveBean1 = queryItem(loveBean);
        if (loveBean1==null){
            daoSession.insert(loveBean);
        }
    }
    public static void delete(LoveBean loveBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        LoveBean loveBean1 = queryItem(loveBean);
        if (loveBean1!=null){
            daoSession.delete(loveBean1);
        }
    }

    public static List<LoveBean> queryAll(){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<LoveBean> loveBeans = daoSession.loadAll(LoveBean.class);
        return loveBeans;
    }

    /* public static List<LoveBean> queryItems(LoveBean loveBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<LoveBean> list = daoSession.queryBuilder(LoveBean.class)
                .where(LoveBeanDao.Properties.MyId.eq(loveBean.getMyId()))
                .build().list();
        return list;
    }*/
/*public static void del(LoveBean loveBean){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<LoveBean> loveBeans = queryItems(loveBean);
        if (loveBeans.size()>0){
            for (int i = 0; i < loveBeans.size(); i++) {

                daoSession.delete(loveBeans.get(i));
            }
        }
    }*/
}
