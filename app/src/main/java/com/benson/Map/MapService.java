package com.benson.Map;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.benson.virus.MainActivity;


/**
 * com.benson.Map
 * Created by Benson on 2017/11/30-上午8:05.
 */

public class MapService extends Service {

    private final static String TAG = "MapService";

    private final int PID = android.os.Process.myPid();
    private AssistServiceConnection mConnection;


    //当启动Service的时候会调用这个方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "MyService: onCreate()");
        setForeground();
    }

    //当系统被销毁的时候会调用这个方法
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    //当启动Service的时候会调用这个方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


    public void setForeground() {
        // sdk < 18 , 直接调用startForeground即可,不会在通知栏创建通知
        if (Build.VERSION.SDK_INT < 18) {
            this.startForeground(PID, getNotification());
            return;
        }

        if (null == mConnection) {
            mConnection = new AssistServiceConnection();
        }

        this.bindService(new Intent(this, MapAssistService.class), mConnection,
                Service.BIND_AUTO_CREATE);
    }

    /**
     *
     */
    private class AssistServiceConnection implements ServiceConnection {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "MyService: onServiceDisconnected");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.d(TAG, "MyService: onServiceConnected");

            // sdk >=18的，会在通知栏显示service正在运行，这里不要让用户感知，所以这里的实现方式是利用2个同进程的service，利用相同的notificationID，
            // 2个service分别startForeground，然后只在1个service里stopForeground，这样即可去掉通知栏的显示
            Service assistService = ((MapAssistService.LocalBinder) binder)
                    .getService();
            MapService.this.startForeground(PID, getNotification());
            assistService.startForeground(PID, getNotification());
            assistService.stopForeground(true);

            MapService.this.unbindService(mConnection);
            mConnection = null;
        }
    }

    private Notification getNotification() {
        // 定义一个notification
        Notification notification = new Notification();
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        return notification;

    }


}
