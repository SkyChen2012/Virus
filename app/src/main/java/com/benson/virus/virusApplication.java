package com.benson.virus;

import android.app.Application;
import android.util.Log;
import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

import com.benson.Tools.CrashHandler;
import com.benson.Tools.Utils;
import com.benson.Tools.XXUtils.XXFileUtils;
import com.mob.MobApplication;
import com.mob.MobSDK;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;


/**
 * com.benson.virus
 * Created by Benson on 2017/2/13-下午8:36.
 */

public class virusApplication extends MobApplication {

    private static final String TAG = "virusApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        SendErrorLog();

        InitJPushSDK();

//        MobSDK.init(this, "1f35afb98e***","0fe8807a4bed3f15d4dd00e4e8e1****");
        InitNetWork();

    }

    private void InitNetWork() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

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
            String path = CrashHandler.getError_log_path() + CrashHandler.getError_log_name();
            Log.i(TAG,path);
            File file = new File(path);
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
