package com.mac.cdp.androidbaidusign.dao;

import android.database.sqlite.SQLiteDatabase;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;

/**
 * Created by cdpmac on 15/9/18.
 */
public class Session extends AbstractDaoSession {
    public Session(SQLiteDatabase db) {
        super(db);
//        this.insert(null);
    }
    public <T> void registerDao(Class<T> entityClass, AbstractDao<T, ?> dao) {
        super.registerDao(entityClass, dao);
    }
}
