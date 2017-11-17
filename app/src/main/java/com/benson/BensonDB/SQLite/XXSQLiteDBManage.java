package com.benson.BensonDB.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * com.benson.BensonDB.SQLite
 * Created by Benson on 2017/11/13-上午9:16.
 */

public class XXSQLiteDBManage {

    private static final String Tag ="XXSQLiteDBManage";

    private SQLiteDatabase XXdb;
    private Context mcontext;
    private static String  FindAllXXDbTable= "select * from " + XXSQLiteConfig.getName();


    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static XXSQLiteDBManage instance = null;

    /* 私有构造方法，防止被实例化 */
    private XXSQLiteDBManage() {
    }

    /**
     * 懒汉式变种，解决线程安全问题
     * @return
     */
    public static synchronized XXSQLiteDBManage getInstance() {
        if (instance == null) {
            instance = new XXSQLiteDBManage();
        }
        return instance;
    }

    /**
     *  初始化
     * @param context
     */
    public void Init(Context context){
        mcontext = context;

    }

    public SQLiteDatabase getReadableDatabase(){
        if (mcontext != null){
            XXdb = XXSQLiteHelper.getInstance(mcontext).getReadableDatabase();
            return XXdb;
        }
        return null;
    }

    public SQLiteDatabase getWritableDatabase(){
        if (mcontext != null){
            XXdb = XXSQLiteHelper.getInstance(mcontext).getWritableDatabase();
            return XXdb;
        }
        return null;
    }

    /**
     * 查询数据库数据，
     * @param XXDbTable
     * @return
     */
    public Cursor findAllWithDBTable(String  XXDbTable) {
        Cursor cursor = XXdb.rawQuery(FindAllXXDbTable, null);
        return cursor;
    }

    /**
     * 添加数据
     */
    public boolean XXinsert() {
        Log.i(Tag,"XX insert ...");
        return false;
    }

    /**
     * 删除数据
     */
    public boolean XXdel() {
        Log.i(Tag,"XX del ...");
        return false;
    }

    /**
     * 根据id查询数据
     * @return Cursor
     */
    public Cursor XXfindById() {
        Log.i(Tag,"XX find Data ...");
        return null;
    }

    /**
     * 修改数据
     */
    public boolean XXupdate() {
        Log.i(Tag,"XX update ...");
        return false;
    }
}
