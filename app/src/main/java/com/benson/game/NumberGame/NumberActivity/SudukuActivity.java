package com.benson.game.NumberGame.NumberActivity;

import java.util.Map;
import java.util.Set;

import com.benson.Tools.XXUtils.XXFileUtils;
import com.benson.game.NumberGame.Entity.ArrayMap;
import com.benson.game.NumberGame.Entity.NumNode;
import com.benson.game.NumberGame.Entity.SudokuArray;
import com.benson.game.NumberGame.NumberDB.NumberDB;
import com.benson.game.NumberGame.NumberTools.GameName;
import com.benson.game.NumberGame.Views.SudokuSurfaceView;
import com.benson.game.NumberGame.bean.NumberGame;
import com.benson.virus.R;
import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * com.benson.game.NumberGame.NumberActivity
 * Created by Benson on 2017/11/16-下午3:13.
 */

public class SudukuActivity extends Activity {

    private static final String Tag = "SudukuActivity";

    private SudokuSurfaceView view;
    private SudokuArray numAloneArray;
    private Thread loadData;
    private int level;
    private NumberDB dbHelper;
    private Gson gson;
    private NumberGame numberGame;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.game_sudoku_load);
        Intent intent = getIntent();
        level = Integer.parseInt(intent.getStringExtra("level"));
        Log.i(Tag, "level:" + level);
        dbHelper = new NumberDB(this);
        dbHelper.onCreate();
        gson = new Gson();
    }

    /**
     * 数据结构使用的是gson 数据库部分使用的三方xutil
     *
     * @param i
     */
    public void getArray(int i) {
        Log.i(Tag, "getArray -->");
        if (numberGame != null) {
            Log.i(Tag, "i:" + i);
            ArrayMap.time = 0;
            ArrayMap.dataBaseTime = Integer.parseInt(numberGame.getTime());
            numAloneArray = new SudokuArray(9, level);
            NumNode[][] tempNodeArray = gson.fromJson(numberGame.getGameContent(), NumNode[][].class);
            numAloneArray.setArray(tempNodeArray);
            view = new SudokuSurfaceView(this, handler, numAloneArray);
            Message msg = new Message();
            msg.arg1 = 1;
            handler.sendMessage(msg);

        } else {
            ArrayMap.time = 0;
            ArrayMap.dataBaseTime = 0;
            numAloneArray = new SudokuArray(9, level);
            Log.i(Tag,"numAloneArray:" + numAloneArray.toString());
            for (int m = 0; m < numAloneArray.getArray().length; m ++){
                for (int n = 0; n < numAloneArray.getArray()[m].length ;n++){
                    Log.i(Tag,"numAloneArray.getArray()[" + m + "][" + n + "] = "+numAloneArray.getArray()[m][n].toString());
                }
            }
            view = new SudokuSurfaceView(this, handler, numAloneArray);
            loadData = new LoadData();
            loadData.start();
        }


    }

    /**
     * 自己的写的原生的数据库方式保存数组部分的数据结构是自己写的
     * <p>
     * system,usernum,flag,1@3@#system,usernum,flag,1@3@#
     * 系统生成数system,用户数，标志，候选数#下个节点
     */
    public void getArray() {
        Map<Integer, String> map;
        int time = 0;
        if ((map = dbHelper.select(GameName.Suduku, level)) != null) {
            Set<Integer> set = map.keySet();
            for (Integer a : set) {
                time = a;
            }
            ArrayMap.time = 0;
            ArrayMap.dataBaseTime = time;
            String content = map.get(time);
            numAloneArray = new SudokuArray(9, level);
            numAloneArray.setArray(content);
            view = new SudokuSurfaceView(this, handler, numAloneArray);
            Message msg = new Message();
            msg.arg1 = 1;
            handler.sendMessage(msg);
        } else {
            ArrayMap.time = 0;
            ArrayMap.dataBaseTime = 0;
            numAloneArray = new SudokuArray(9, level);
            view = new SudokuSurfaceView(this, handler, numAloneArray);
            loadData = new LoadData();
            loadData.start();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(Tag, "onResume -->");
        getArray(1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy -->");
    }

    private void save2Db() {
        Log.i(Tag, "save2Db -->");
        try {
            if (numberGame == null) {
                numberGame = new NumberGame();
            }
            NumNode[][] node = numAloneArray.getArray();
            String str = gson.toJson(node);
            numberGame.setGameContent(str);
            numberGame.setLevel(level + "");
            numberGame.setGameName(GameName.Suduku);
            numberGame.setTime(ArrayMap.time + "");

            // MyFile.writeLog(MyFile.path,str );
        } catch (Exception e) {
            XXFileUtils.writeException(XXFileUtils.path, e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void onStop() {
        Log.i(Tag, "onStop -->");
        super.onStop();
//        save2Db();

        // NumNode[][] node = numAloneArray.getArray();
        // String str = gson.toJson(node);
        //
        // String content = "";
        // for (int i = 0; i < node.length; ++i) {
        // for (int j = 0; j < node[i].length; ++j) {
        // content += node[i][j].systemNum;
        // content += ",";
        // content += node[i][j].userNum;
        // content += ",";
        // content += node[i][j].flag;
        // content += ",";
        // for (int back = 0; back < node[i][j].getBack().size(); ++back) {
        // content += node[i][j].getBack().get(back);
        // content += "@";
        // }
        // content += "#";
        // }
        // }
        // dbHelper.operation(GameName.Suduku, content, level, ArrayMap.time);
        // finish();
    }

    class LoadData extends Thread {

        @Override
        public void run() {
            numAloneArray.begin();
            for (int m = 0; m < numAloneArray.getArray().length; m ++){
                for (int n = 0; n < numAloneArray.getArray()[m].length ;n++){
                    Log.i(Tag,"numAloneArray.getArray()[" + m + "][" + n + "] = "+numAloneArray.getArray()[m][n].toString());
                }
            }
            Message msg = new Message();
            msg.arg1 = 1;
            handler.sendMessage(msg);

        }
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Log.i(Tag, "handleMessage -->" + msg.arg1);
            if (msg.arg1 == 1) {
                setContentView(view);
            } else if (msg.arg1 == 2) {
                setContentView(R.layout.game_sudoku_load);
                new LoadData().start();

            }
        }
    };
}