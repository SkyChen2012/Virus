package com.benson.BensonDB.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * com.benson.BensonDB.SharedPreferences
 * Created by Benson on 2017/11/12-上午9:16.
 */

public class XXSharedPreferences {
    private final static String Tag = "XX_SharedPreferences";

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static XXSharedPreferences instance = null;
    private static String XXdefault = "XXconfig";

    /* 私有构造方法，防止被实例化 */
    private XXSharedPreferences() {
        Init();
    }
    /**
     * 懒汉式变种，解决线程安全问题
     * @return
     */
    public static synchronized XXSharedPreferences getInstance() {
        if (instance == null) {
            instance = new XXSharedPreferences();
        }
        return instance;
    }

    /**
     * Init XXSharedPreferences
     * @return
     */
    private boolean Init(){
        return true;
    }

    /**
     * 将数据保存在缓冲中
     * @param context
     * @param name Desired preferences file
     * @param key
     * @param obj
     */
    public  void saveWithName(Context context,String name,String key,Object obj){
        //Context.MODE_PRIVATE为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容，
        //如果想把新写入的内容追加到原文件中。可以使用Context.MODE_APPEND
        /**
         * mode为操作模式，默认的模式为0或MODE_PRIVATE，还可以使用MODE_WORLD_READABLE和MODE_WORLD_WRITEABLE
         * mode指定为MODE_PRIVATE，则该配置文件只能被自己的应用程序访问。
         * mode指定为MODE_WORLD_READABLE，则该配置文件除了自己访问外还可以被其它应该程序读取。
         * mode指定为MODE_WORLD_WRITEABLE，则该配置文件除了自己访问外还可以被其它应该程序读取和写入
         */
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        //编辑器
        SharedPreferences.Editor editor = sp.edit();
        if(obj instanceof String){
            editor.putString(key, (String) obj);
        }else if(obj instanceof Boolean){
            editor.putBoolean(key, (Boolean) obj);
        }
        editor.commit();//保存数据到缓冲
    }
    /**
     * 将数据保存在缓冲中
     * @param context
     * @param key
     * @param obj
     */
    public  void save(Context context,String key,Object obj){
        //Context.MODE_PRIVATE为默认操作模式，代表该文件是私有数据，只能被应用本身访问，在该模式下，写入的内容会覆盖原文件的内容，
        //如果想把新写入的内容追加到原文件中。可以使用Context.MODE_APPEND
        /**
         * mode为操作模式，默认的模式为0或MODE_PRIVATE，还可以使用MODE_WORLD_READABLE和MODE_WORLD_WRITEABLE
         * mode指定为MODE_PRIVATE，则该配置文件只能被自己的应用程序访问。
         * mode指定为MODE_WORLD_READABLE，则该配置文件除了自己访问外还可以被其它应该程序读取。
         * mode指定为MODE_WORLD_WRITEABLE，则该配置文件除了自己访问外还可以被其它应该程序读取和写入
         */
        SharedPreferences sp = context.getSharedPreferences(XXdefault, Context.MODE_PRIVATE);
        //编辑器
        SharedPreferences.Editor editor = sp.edit();
        if(obj instanceof String){
            editor.putString(key, (String) obj);
        }else if(obj instanceof Boolean){
            editor.putBoolean(key, (Boolean) obj);
        }
        editor.commit();//保存数据到缓冲
    }
    /**
     * 获取SharedPreferences的实例
     * @param context
     * @return
     */
    public  SharedPreferences getSharedPreferencesWithName(Context context ,String name){

        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public String getWithNameKey(Context context,String name ,String key){

        return  getSharedPreferencesWithName(context, name).getString(key,"");

    }
}
