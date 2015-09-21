package com.mac.cdp.androidbaidusign.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mac.cdp.androidbaidusign.bean.BaiduUser;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;

/**
 * Created by cdpmac on 15/9/18.
 */
public class Master  extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1000;
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        BaiduUserDao.createTable(db, ifNotExists);
    }

    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        BaiduUserDao.dropTable(db, ifExists);
    }

    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }

    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }

    }
    public Master(SQLiteDatabase db, int schemaVersion) {
        super(db, schemaVersion);
    }
//    public void registerDao(Class<? extends AbstractDao<?, ?>> daoClass){
//        registerDaoClass(daoClass);
//    }
    @Override
    public Session newSession() {
        return    new Session(db);
    }

    @Override
    public Session newSession(IdentityScopeType type) {
        return  null;
    }
}
