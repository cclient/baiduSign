package com.mac.cdp.androidbaidusign.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.mac.cdp.androidbaidusign.bean.BaiduUser;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

/**
 * Created by cdpmac on 15/9/18.
 */
public class BaiduUserDao extends AbstractDao<BaiduUser, Long> {
//    private static String tableName="BaiduUser";
//    aused by: java.lang.NoSuchFieldException: TABLENAME

//    java.lang.ClassNotFoundException: com.mac.cdp.androidbaidusign.dao.BaiduUserDao$Properties
    public static final String TABLENAME = "BaiduUser";

    public BaiduUserDao(DaoConfig config) {
        super(config);
    }

//    public BaiduUserDao(DaoConfig config, DaoSession daoSession) {
//        super(config, daoSession);
//    }

    /**
     * Properties of entity Customer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Tel = new Property(1, String.class, "telphone", false, "Tel");
        public final static Property UserName = new Property(2, String.class, "username", false, "UserName");
        public final static Property Email = new Property(3, String.class, "password", false, "Email");
        public final static Property PassWord = new Property(4, String.class, "email", false, "PassWord");
    };


    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\""+TABLENAME+"\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"Tel\" TEXT NOT NULL ,"+ // 1: tel
                "\"UserName\" TEXT NOT NULL ,"+ // 2: username
                "\"Email\" TEXT NOT NULL ,"+ // 3: email
                "\"PassWord\" TEXT NOT NULL );"); // 4:password
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\""+TABLENAME+"\"";
        db.execSQL(sql);
    }
    @Override
    protected BaiduUser readEntity(Cursor cursor, int offset) {
        BaiduUser entity = new BaiduUser( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.getString(offset + 1), // name
                cursor.getString(offset + 2), // name
                cursor.getString(offset + 3), // name
                cursor.getString(offset + 4) // name
        );
        return entity;
    }

    @Override
    protected Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    @Override
    protected void readEntity(Cursor cursor, BaiduUser entity, int offset) {

        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTelphone(cursor.getString(offset + 1));
        entity.setUsername(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEmail(cursor.isNull(offset + 3) ? null :  cursor.getString(offset + 3));
        entity.setPassword(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
    }

    @Override
    protected void bindValues(SQLiteStatement stmt, BaiduUser entity) {
        stmt.clearBindings();
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getPassword());
        stmt.bindString(3, entity.getTelphone());
        stmt.bindString(4, entity.getUsername());
        stmt.bindString(5, entity.getEmail());
    }
    @Override
    protected Long updateKeyAfterInsert(BaiduUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    @Override
    protected Long getKey(BaiduUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected boolean isEntityUpdateable() {
        return false;
    }
}
