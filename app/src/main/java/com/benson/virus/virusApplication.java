package com.benson.virus;

import android.app.Service;
import android.os.Vibrator;
import android.util.Log;
import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

import com.benson.Map.LocationService;
import com.benson.Tools.CrashHandler;
import com.benson.Tools.XXUtils.XXFileUtils;
import com.mob.MobApplication;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;



/**
 * com.benson.virus
 * Created by Benson on 2017/2/13-下午8:36.
 */

public class virusApplication extends MobApplication {

    private static final String TAG = "virusApplication";

    public LocationService locationService;
    public Vibrator mVibrator;

    @Override
    public void onCreate() {
        super.onCreate();

        SendErrorLog();

        InitJPushSDK();

        InitNetWork();

        InitBDMap();

    }

    private void InitBDMap() {

        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
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
            ch.postReport(path);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
