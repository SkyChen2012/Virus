package com.benson.game.NumberGame.NumberActivity;

import android.annotation.SuppressLint;
import android.app.Activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.benson.BensonDB.SharedPreferences.XXSharedPreferences;
import com.benson.game.NumberGame.Views.SudokuView;
import com.benson.virus.R;


/**
 * com.benson.game.Sudoku
 * Created by Benson on 2017/11/10-上午10:57.
 */

public class SudokuActivity extends Activity  implements  View.OnClickListener {

    private  final static String Tag = "SudokuActivity";

    private Button No1;
    private Button No2;
    private Button No3;

    private SudokuView mSudokuView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_sudoku_main);

        initView();
    }

    @SuppressLint("CutPasteId")
    private  void  initView(){
        mSudokuView = (SudokuView)findViewById(R.id.Sudoku_View);

//       测试
        XXSharedPreferences xxSharedPreferences = XXSharedPreferences.getInstance();
        SharedPreferences xSharedPreferences = xxSharedPreferences.getSharedPreferencesWithName(this,"config");
        String value = xSharedPreferences.getString("fuck1","");
        Log.i(Tag, value);

//      测试结束
        No1 = (Button)findViewById(R.id.BtnNo1);
        No2 = (Button)findViewById(R.id.BtnNo2);
        No3 = (Button)findViewById(R.id.BtnNo2);

        No1.setOnClickListener(this);
        No2.setOnClickListener(this);
        No3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.BtnNo1:
                break;
            case R.id.BtnNo2:
                break;
            case R.id.BtnNo3:
                break;
            default:
                break;
        }
    }
}
