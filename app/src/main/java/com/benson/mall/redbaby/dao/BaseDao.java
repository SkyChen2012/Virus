package com.benson.mall.redbaby.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.benson.mall.redbaby.util.DBUtil;
import com.benson.mall.redbaby.util.Logger;

/**
 * com.benson.mall.redbaby.dao
 * Created by Benson on 2017/9/6-下午7:15.
 */

public abstract class BaseDao {
    /** 数据连接对象 */
    protected SQLConnection sqlConnection;
    protected Cursor cursor;
    protected static final int TYPE_READ = 0; // 数据库只读类型
    protected static final int TYPE_WRITE = 1;// 数据库写类型
    private static final String TAG = "BaseDao";

    public BaseDao(Context context) {
        sqlConnection = new SQLConnection(context);
    }

    /**
     * 回调业务逻辑
     *
     * @param back
     * @return
     */
    protected <T> T callBack(int type, DaoCallBack<T> back) {
        T result = null;
        SQLiteDatabase conn = null;
        try {

            switch (type) {
                case TYPE_READ:
                    conn = sqlConnection.getReadableDatabase();
                    break;
                case TYPE_WRITE:
                    conn = sqlConnection.getWritableDatabase();
                    break;
            }
            if (conn == null)
                throw new NullPointerException("SQLiteDatabase conn  is null");
            result = back.invoke(conn);
            // conn.beginTransaction();
            // conn.setTransactionSuccessful();
        } catch (Exception e) {
            // conn.endTransaction();
            Logger.e(TAG, e);
        } finally {
            DBUtil.Release(conn, cursor);
        }
        return result;
    }

    /**
     * 回调接口
     *
     * @author Administrator
     *
     * @param <T>
     */
    interface DaoCallBack<T> {
        T invoke(SQLiteDatabase conn);
    }
}
