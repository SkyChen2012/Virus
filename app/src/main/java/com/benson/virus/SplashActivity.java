package com.benson.virus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Benson.Chen on 2016/11/28.
 * 
 * 启动界面
 */

public class SplashActivity extends AppCompatActivity {

    private final String TAG = "SplashActivity";

    private final int SPLASH_DISPLAY_LENGHT = 2000; // 两秒后进入系统

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new android.os.Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this,
                        MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }
}
