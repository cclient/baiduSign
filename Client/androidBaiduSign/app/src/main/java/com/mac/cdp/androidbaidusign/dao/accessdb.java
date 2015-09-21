package com.mac.cdp.androidbaidusign.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mac.cdp.androidbaidusign.AppStart;
import com.mac.cdp.androidbaidusign.bean.BaiduUser;

import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by cdpmac on 15/9/18.
 */
public class accessdb {
    public void access(){
        Context c= new AppStart();
        Master.DevOpenHelper dbhelp=new Master.DevOpenHelper(c,"dbname",null);


        SQLiteDatabase db=dbhelp.getWritableDatabase();
        Master master=new Master(db,200);
        master.newSession();
        Session session=master.newSession();
//        session.in
        DaoConfig dc=new DaoConfig(db,BaiduUserDao.class);
        BaiduUserDao dao=new BaiduUserDao(dc);

        dao.queryBuilder().where(BaiduUserDao.Properties.UserName.eq("")).list();

        BaiduUser baiduUser=new BaiduUser(null,"tel","name","pwd","mail");
        dao.insert(baiduUser);
        ;
        Log.w("baidu user id ",dao.getKey(baiduUser)+"");

    }
}
