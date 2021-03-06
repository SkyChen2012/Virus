package com.benson.game.AgileBuddy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.benson.game.AgileBuddy.util.ConstantInfo;
import com.benson.virus.R;

/**
 * Created by Benson.Chen on 2016/11/28.
 */

public class Splash extends Activity implements OnClickListener {

    private static final String TAG = "Game - Splash";
    private SharedPreferences mBaseSettings;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game_agilebuddy_splash);

        Button startButton = (Button) findViewById(R.id.start_game);
        startButton.setOnClickListener(this);

        Button scoreBoardButton = (Button) findViewById(R.id.score_board);
        scoreBoardButton.setOnClickListener(this);

        Button goProButton = (Button) findViewById(R.id.more_app);
        goProButton.setOnClickListener(this);

        Button optionButton = (Button) findViewById(R.id.options);
        optionButton.setOnClickListener(this);

        Button exitButton = (Button) findViewById(R.id.exit);
        exitButton.setOnClickListener(this);

        Intent bindIntent = new Intent(this, ScoreUpgrateService.class);
        bindService(bindIntent, mConnection, Context.BIND_AUTO_CREATE);

        mBaseSettings = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public void onClick(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.start_game:
//                if (mBaseSettings.getBoolean(ConstantInfo.PREFERENCE_KEY_SHOWTIPS,
//                        true)) {
//                    i = new Intent(Splash.this, TipsActivity.class);
//                } else {
//                }
                i = new Intent(Splash.this, AgileBuddyActivity.class);
                break;
            case R.id.options:
                i = new Intent(this, Prefs.class);
                break;
            case R.id.score_board:
                i = new Intent(this, GlobalRankingActivity.class);
                break;
            case R.id.more_app:
                Log.e(TAG,"无法获取更多的app");
                break;
            case R.id.exit:
                finish();
                return;
        }
        if (i != null) {
            startActivity(i);
        }
    }

    @Override
    public void finish() {
        this.unbindService(mConnection);
        super.finish();
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
        }

        public void onServiceDisconnected(ComponentName className) {
        }
    };
}