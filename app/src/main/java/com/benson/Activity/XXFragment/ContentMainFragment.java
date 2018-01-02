package com.benson.Activity.XXFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.benson.Tools.Bluetooth.BluetoothMainActivity;
import com.benson.Tools.Map.LocationActivity;
import com.benson.virus.MainActivity;
import com.benson.virus.R;

/**
 * com.benson.Activity.XXFragment
 * Created by Benson on 2017/12/20-下午2:55.
 */

public class ContentMainFragment extends Fragment implements View.OnClickListener{

    private final static String Tag = "Content_Main_Fragment";

    private View view;

    private Button mButtonSend;
    private Button playButtonSend;
    private Button tijiaomButtonSend;
    private EditText yanzhengma;
    private EditText shoujihaoma;
    private Button startBtn;
    private Button stopBtn;
    private EditText tvCity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.content_main, container, false);
        initView();
        return view;
    }

    private void initView() {

        if (view != null){

            view.findViewById(R.id.BtnSend).setOnClickListener(this);
            view.findViewById(R.id.play).setOnClickListener(this);
            view.findViewById(R.id.tijiao).setOnClickListener(this);
            view.findViewById(R.id.startBtn).setOnClickListener(this);
            view.findViewById(R.id.stopBtn).setOnClickListener(this);

            tvCity = (EditText)view.findViewById(R.id.tvCity);

            yanzhengma = (EditText)view.findViewById(R.id.yanzhengma);
            shoujihaoma = (EditText)view.findViewById(R.id.shoujihaoma);


        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.BtnSend:{

            }
            break;
            case R.id.play:{

            }
            break;
            case R.id.tijiao:{

                Log.i(Tag, "bluetoothActivity...... ");

            }
            break;
            case R.id.startBtn:{

                Log.i(Tag,"startBtn.setOnClickListener。。。。");

                Intent intent = new Intent(getActivity(),LocationActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.stopBtn:{

            }
            break;

            default:break;
        }

    }
}
