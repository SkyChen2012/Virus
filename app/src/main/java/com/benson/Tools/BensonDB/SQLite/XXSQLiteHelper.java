package com.benson.Tools.BensonDB.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * com.benson.BensonDB.SQLite
 * Created by Benson on 2017/11/13-上午8:49.
 */

public class XXSQLiteHelper extends SQLiteOpenHelper {

    private static final String Tag = "XXSQLiteHelper";


    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static XXSQLiteHelper instance = null;

    /* 私有构造方法，防止被实例化 */
    private XXSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                           int version) {
        super(context, name, factory, version);
    }

    /**
     * 懒汉式变种，解决线程安全问题
     * @param context
     * @return
     */
    public static synchronized XXSQLiteHelper getInstance(Context context) {
        if (instance == null) {
            instance = new XXSQLiteHelper(context, XXSQLiteConfig.getName(), null,XXSQLiteConfig.getVERSION());
        }
        return instance;
    }

    /**
     * 懒汉式变种，解决线程安全问题
     * @param context
     * @param name  数据库名字
     * @param factory
     * @param version   版本号
     * @return
     */
    public static synchronized XXSQLiteHelper getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory,
                                                          int version) {
        if (instance == null) {
            instance = new XXSQLiteHelper(context, name, factory, version);
        }
        return instance;
    }

    private boolean Init(){
        return true;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql = "create table stu_table(id int,sname varchar(20),sage int,ssex varchar(10))";
        //输出创建数据库的日志信息
        Log.i(Tag, "create Database------------->");
        //execSQL函数用于执行SQL语句
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //输出更新数据库的日志信息
        Log.i(Tag, "Upgrade Database------------->");
    }

}
