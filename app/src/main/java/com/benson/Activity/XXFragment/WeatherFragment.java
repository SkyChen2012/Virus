package com.benson.Activity.XXFragment;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.benson.Bean.CityBean;
import com.benson.Tools.BensonNetWork.XXOkHttpUtil;
import com.benson.Tools.UpdateApp.AppUpdateInfo;
import com.benson.virus.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * com.benson.Activity.XXFragment
 * Created by Benson on 2017/12/20-下午2:35.
 */

public class WeatherFragment extends Fragment implements View.OnClickListener,Handler.Callback{

    private final static String TAG = "WeatherFragment";

    private final static int REFRESH_WEATHER = 0x111;
    private View view;
    private TextView textWeather;
    private Button BtnWeather1,BtnWeather2,BtnWeather3,BtnWeather4;
    private XXOkHttpUtil mOkHttpUtil;
    private CityBean mCitys;

    private Handler mHandler = new Handler(this);

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {


        view= inflater.inflate(R.layout.layout1, container, false);

        initView();


        return view;


    }

    private void initView() {
        textWeather = (TextView)view.findViewById(R.id.textWeather);

        view.findViewById(R.id.BtnWeather1).setOnClickListener(this);
        view.findViewById(R.id.BtnWeather2).setOnClickListener(this);
        view.findViewById(R.id.BtnWeather3).setOnClickListener(this);
        view.findViewById(R.id.BtnWeather4).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnWeather1: {
                mOkHttpUtil = XXOkHttpUtil.getInstance();
                mOkHttpUtil.getStringFromServerEnqueue("http://45.77.151.91:8080/XX_citys.txt", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String htmlStr =  response.body().string();
                        Gson gson = new Gson();
                        mCitys = gson.fromJson(htmlStr,CityBean.class);

                        mHandler.sendEmptyMessageDelayed(REFRESH_WEATHER, 2000);
                        Message message = Message.obtain();
                        mHandler.sendMessage(message);
                    }

                });
            }
                break;

            case R.id.BtnWeather2:


                break;

            case R.id.BtnWeather3:
                break;

            case R.id.BtnWeather4:
                break;

                default:
                    break;
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what)
        {
            case REFRESH_WEATHER:
                textWeather.setText(new Gson().toJson(mCitys));
                break;

        }
        return true;
    }
}
