package com.benson.virus;

import android.app.Application;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * com.benson.virus
 * Created by Benson on 2017/2/13-下午8:36.
 */

public class virusApplication extends Application {

    private static final String TAG = "virusApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        InitSDK();

    }

    private boolean InitSDK(){

        Log.i(TAG, "onCreate: startup JPush SDK init");
        JPushInterface.setDebugMode(false); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush

        return true;
    }



}
