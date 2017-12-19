package com.benson.Tools;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import com.benson.Tools.BensonNetWork.XXNetWorkUtil;
import com.benson.Tools.XXUtils.XXTimeUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

/**
 * com.benson.Tools
 * Created by Benson on 2017/11/16-上午8:13.
 */

public  class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String Tag = "CrashHandler";
    private static String error = "";
    /**
     * 错误日志
     */
    private static String ERROR_LOG_PATH = "/com/benson/virus/error/";
    private static String error_log_name = "virus-error.log";
    private static String error_log_path = android.os.Environment.getExternalStorageDirectory() + "" + ERROR_LOG_PATH;

    /**
     * 是否开启日志输出,在Debug状态下开启, 在Release状态下关闭以提示程序性能
     */
    public static final boolean DEBUG = true;

    /** 系统默认的UncaughtException处理类 */
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    /** CrashHandler实例 */
    public static CrashHandler INSTANCE;
    /** 程序的Context对象 */
    private Context mContext;

    private static Handler handler;

    /** 保证只有一个CrashHandler实例 */

    private CrashHandler() {
    }

    /** 获取CrashHandler实例 ,单例模式 */
    public static CrashHandler getInstance() {
        handler = new Handler();
        if (INSTANCE == null) {
            INSTANCE = new CrashHandler();
        }
        return INSTANCE;
    }

    /**
     * 初始化,注册Context对象, 获取系统默认的UncaughtException处理器,
     * 设置该CrashHandler为程序的默认处理器
     *
     * @param ctx
     */

    public void init(Context ctx) {
        mContext = ctx;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            // 如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            // 如果自己处理了异常，则不会弹出错误对话框，则需要手动退出app
        }
    }

    // TODO 使用HTTP Post 发送错误报告到服务器 这里不再做详细描述
    public void postReport(final String filePath) throws Exception {

//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            error += line;
//        }
//        br.close();
        new Thread() {
            public void run() {
                /**
                 * 发送错误log到服务器
                 */

                XXNetWorkUtil xxNetWorkUtil = new XXNetWorkUtil();
                HashMap<String,String> hashMap =new HashMap<>();
                hashMap.put("name","Benson");
                xxNetWorkUtil.upLoadFile(filePath,hashMap);
            };
        }.start();
    }




    /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     *
     * @return true代表处理该异常，不再向上抛异常，
     *         false代表不处理该异常(可以将该log信息存储起来)然后交给上层(这里就到了系统的异常处理)去处理，
     *         简单来说就是true不会弹出那个错误提示框，false就会弹出
     */
    private static boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }

        final String msg = ex.getLocalizedMessage();
        final StackTraceElement[] stack = ex.getStackTrace();
        final String message = ex.getMessage();

        new Thread() {
            public void run() {
                Looper.prepare();
                File file = new File(error_log_path + error_log_name);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(file, true);
                    fos.write(new String("=================Start:Error Info=================\n").getBytes());
                    fos.write(new String("Time:" + XXTimeUtils.getCurTime() + "\n").getBytes());
                    //当前系统
                    fos.write(new String("OS version:" + Build.VERSION.RELEASE + "_" + Build.VERSION.SDK_INT).getBytes());
                    //制造商
                    fos.write(new String("Vendor:" + Build.MANUFACTURER).getBytes());
                    //手机型号
                    fos.write(new String("Model:" + Build.MODEL).getBytes());
                    //CPU架构
                    fos.write(new String("CPU ABI:" + Build.CPU_ABI).getBytes());
                    String mtype = android.os.Build.MODEL;
                    String mbrand = android.os.Build.BRAND;
                    String versionSdk = android.os.Build.VERSION.SDK;

                    fos.write(new String("Mobile Brand:" + mbrand + "\n").getBytes());
                    fos.write(new String("Mobile Mode:" + mtype + "\n").getBytes());
                    fos.write(new String("SDK:" + versionSdk + "\n\n").getBytes());


                    fos.write(message.getBytes());
                    for (int i = 0; i < stack.length; i++) {
                        fos.write(stack[i].toString().getBytes());
                    }

                    fos.write(new String("\n=================End:Error Info=================\n").getBytes());

                    fos.write(new String("\n\n\n\n").getBytes());

                    fos.flush();
                    fos.close();
                } catch (Exception e) {
                }
                Looper.loop();
            };
        }.start();
        return false;
    }


    public static String getErrorLogPath() {
        return ERROR_LOG_PATH;
    }

    public static String getError_log_name() {
        return error_log_name;
    }

    public static String getError_log_path() {
        return error_log_path;
    }
}
