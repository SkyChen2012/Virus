package com.benson.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Calendar;

/**
 * com.benson.Tools
 * Created by Benson on 2017/11/11-下午3:23.
 */

@SuppressLint("AppCompatCustomView")
public class TimeView extends TextView {
    private TextView textView;
    private String timeString;
    private  TimeHandler mTimehandler=new TimeHandler();

    //三个构造方法分别是代码构造，xml+style构造和xml构造
    public TimeView(Context context) {
        this(context,null);
    }

    public TimeView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.textView=this;
        Init(context);
    }

    //初始化方法
    private void Init(Context context) {
        try {
            //初始化textview显示时间
            updateClock();
            //更新进程开始
            new TimeThread().start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //更新子线程
    private class TimeThread extends Thread{
        @Override
        public void run() {
            mTimehandler.startScheduleUpdate();
        }
    }

    //重要的更新Handler
    private class   TimeHandler  extends Handler{
        private boolean mStopped;
        private void post(){
//            sendMessageDelayed(obtainMessage(0),1000*(60- Calendar.getInstance().get(Calendar.SECOND)));
            sendMessageDelayed(obtainMessage(0),1000);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!mStopped){
                updateClock();
                post();
            }
        }
        //开始更新
        public void startScheduleUpdate(){
            mStopped = false;
            post();
        }
        //停止更新
        public void stopScheduleUpdate(){
            mStopped = true;
            removeMessages(0);
        }
    }

    private void updateClock() {
        //更新时间
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);
        timeString=hour+":"+minute+":"+second;
        textView.setText(timeString);
    }


}
