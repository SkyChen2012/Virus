package com.benson.BensonDB.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * com.benson.BensonDB.SQLite
 * Created by Benson on 2017/11/13-上午9:16.
 */

public class XXSQLiteDB {

    public SQLiteDatabase XXdb;

    private static String  FindAllXXDbTable= "select * from " + XXSQLiteConfig.getName();

    public XXSQLiteDB(Context context) {

        XXdb =XXSQLiteHelper.getInstance(context).getReadableDatabase();
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
    public void XXinsert() {

    }

    /**
     * 删除数据
     */
    public void XXdel() {

    }

    /**
     * 根据id查询数据
     * @return Cursor
     */
    public Cursor XXfindById() {
        return null;
    }

    /**
     * 修改数据
     */
    public void XXupdate() {

    }
}
