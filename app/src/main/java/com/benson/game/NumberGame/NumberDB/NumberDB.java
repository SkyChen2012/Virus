package com.benson.game.NumberGame.NumberDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.benson.BensonDB.SQLite.XXSQLiteDBManage;

import java.util.HashMap;
import java.util.Map;

/**
 * com.benson.game.NumberGame.NumberDB
 * Created by Benson on 2017/11/16-上午10:09.
 */

public class NumberDB {

    private static final String Tag = "NumberDB";

    private XXSQLiteDBManage mXXSqLiteDBManage;

    private final static String DatabaseName = "NumberGame";
    private final static int DatabaseVersion = 1;
    /* 表名 */
    private final static String TableName = "NuberGame";
    /* 游戏名字的列名 */
    private final static String GameName = "GameName";
    /* 存数据的地方。数组等 */
    private final static String GameContent = "GameContent";
    /* 存游戏的难度 */
    private final static String Level = "level";
    /* 存游戏所花的时间 */
    private final static String Time = "Time";

    public NumberDB(Context context){
        mXXSqLiteDBManage = XXSQLiteDBManage.getInstance();
        mXXSqLiteDBManage.Init(context);
    }

    /**
     * 创建游戏数据表
     */
    public void onCreate() {
        SQLiteDatabase db = mXXSqLiteDBManage.getReadableDatabase();
        String sql = "create table if not exists " + TableName + " ( " + GameName + " text, "
                + GameContent + " text, " + Level + " integer, " + Time
                + " integer " + " ) ";
        Log.i(Tag,"onCreate ---> " + sql);
        db.execSQL(sql);
    }


    /**
     * 插入数据
     * @param gameName
     * @param content
     * @param level
     * @param time
     */
    public void insert(String gameName, String content, int level, int time) {
        SQLiteDatabase db = mXXSqLiteDBManage.getWritableDatabase();
        String sql = "insert into " + TableName + " ( " + GameName + " , "
                + GameContent + " , " + Level + " , " + Time +" ) "+ "  values ( '"
                + gameName + "' , '" + content + "' , " + level + " , " + time
                + ")";
        Log.i(Tag,"insert ---> " + sql);
        db.execSQL(sql);
    }


    /**
     * 查询这个难度和这个游戏是否有存档 并且返回时间和内容的map
     * @param gameName
     * @param level
     * @return
     */
    public Map select(String gameName, int level) {
        SQLiteDatabase db = mXXSqLiteDBManage.getReadableDatabase();
        String sql = "select " + GameContent+" , "+Time  + " from "
                + TableName +" where "+GameName+" = '"+gameName+"' and "+Level+" = "+level;

        Log.i(Tag,"查询这个难度和这个游戏是否有存档 并且返回时间和内容的map ---> " + sql);
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor!=null&&cursor.moveToFirst()){

            do{
                Log.i(Tag, (cursor.getString(0)
                        + '\t'
                        + cursor.getString(1)));
            }while(cursor.moveToNext());

        }


        if(cursor.moveToFirst()){
            Map<Integer,String> map = new HashMap();
            map.put(Integer.parseInt(cursor.getString(1)), cursor.getString(0));
            return map;
        }

        return null;
    }

    /**
     * 根据游戏难度和游戏名字更新
     * @param gameName
     * @param level
     * @param content
     * @param time
     */
    public void update(String gameName, int level, String content, int time) {
        SQLiteDatabase db = mXXSqLiteDBManage.getWritableDatabase();
        String sql = "update " + TableName + " set " + GameContent + " = '"
                + content + "'  ," + Time + " = " + time + " where " + GameName
                + " = '" + gameName + "' and " + Level + " = " + level;
        Log.i(Tag,"根据游戏难度和游戏名字更新 ---> " + sql);
        db.execSQL(sql);
    }

    /**
     * 先查询数据库中是否有了如果没有那么直接插入。如果有了就更新
     * @param gameName
     * @param content
     * @param level
     * @param time
     */
    public void operation(String gameName, String content, int level, int time) {
        if (select(gameName, level) == null) {
			/* 没有存档 */
            insert(gameName, content, level, time);
        } else {
			/* 已有存档直接更新 */
            update(gameName, level, content, time);
        }
    }
}
