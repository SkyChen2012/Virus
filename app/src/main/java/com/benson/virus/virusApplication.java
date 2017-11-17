package com.benson.virus;

import android.app.Application;
import android.util.Log;
import java.io.File;

import cn.jpush.android.api.JPushInterface;

import com.benson.Tools.CrashHandler;
import com.benson.Tools.Utils;
import com.benson.Tools.XXUtils.XXFileUtils;


/**
 * com.benson.virus
 * Created by Benson on 2017/2/13-下午8:36.
 */

public class virusApplication extends Application {

    private static final String TAG = "virusApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        SendErrorLog();

        InitJPushSDK();

    }

    private boolean InitJPushSDK(){

        Log.i(TAG, "onCreate: startup JPush SDK init");
        JPushInterface.setDebugMode(false); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush

        return true;
    }

    /**
     * 发送错误日志
     *
     * @return
     */
    public boolean SendErrorLog(){

        Log.i(TAG, "发送错误日志...");
        CrashHandler ch = CrashHandler.getInstance();
        ch.init(getApplicationContext());
        try {
            XXFileUtils.MakeDir(CrashHandler.getError_log_path());
            File file = new File(CrashHandler.getError_log_path() + CrashHandler.getError_log_name());
            if (!file.exists()) {
                file.createNewFile();
            }
            ch.postReport(file);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
