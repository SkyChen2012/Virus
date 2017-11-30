package com.benson.Map;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * com.benson.Map
 * Created by Benson on 2017/11/30-上午8:39.
 */

public class MapAssistService extends Service {

        private static final String TAG = "MapAssistService";

        public class LocalBinder extends Binder {
            public MapAssistService getService() {
                return MapAssistService.this;
            }
        }

        @Override
        public IBinder onBind(Intent intent) {
            Log.d(TAG, "AssistService: onBind()");
            return new LocalBinder();
        }

        @Override
        public void onDestroy() {
            // TODO Auto-generated method stub
            super.onDestroy();
            Log.d(TAG, "AssistService: onDestroy()");
        }

    }
