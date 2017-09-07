package com.benson.game.AgileBuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;

import com.benson.virus.R;


/**
 * Created by Benson.Chen on 2016/11/28.
 */


public class TipsActivity extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game_agilebuddy_tips);
        findViewById(R.id.touch_to_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.touch_to_start) {
            Intent i = new Intent(this, AgileBuddyActivity.class);
            startActivity(i);
            this.finish();
        }
    }
}