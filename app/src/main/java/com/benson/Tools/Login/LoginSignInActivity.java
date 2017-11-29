package com.benson.Tools.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.benson.virus.MainActivity;
import com.benson.virus.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;


/**
 * com.benson.Tools.Login
 * Created by Benson on 2017/11/28-上午10:49.
 */

public class LoginSignInActivity extends Activity implements  View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    private static final String TAG = "LoginSignInActivity";
    private EditText id_login;
    private EditText password_login;
    private CheckBox rememberpassword_login;
    private CheckBox auto_login;
    private Button button_login;
    private Button button_logUp;
    private SharedPreferences sp;
    private String idvalue;
    private String passwordvalue;
    private static final int PASSWORD_MIWEN = 0x81;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        //找到相应的布局及控件
        setContentView(R.layout.login_sign_in);

        init();



        if (sp.getBoolean("ischeck",false)){
            rememberpassword_login.setChecked(true);
            id_login.setText(sp.getString("PHONEEDIT",""));
            password_login.setText(sp.getString("PASSWORD",""));
            //密文密码
            password_login.setInputType(PASSWORD_MIWEN);
            if (sp.getBoolean("auto_ischeck",false)){
                auto_login.setChecked(true);
                Intent intent = new Intent(LoginSignInActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }


    }

    private void init(){

        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText) findViewById(R.id.login_password);

        rememberpassword_login=(CheckBox) findViewById(R.id.login_rememberpassword);
        auto_login=(CheckBox) findViewById(R.id.login_autologin);
        button_login=(Button) findViewById(R.id.login_sign_in_Button);
        button_logUp=(Button) findViewById(R.id.login_sign_up_Button);

        button_logUp.setOnClickListener(this);
        button_login.setOnClickListener(this);
        rememberpassword_login.setOnCheckedChangeListener(this);
        auto_login.setOnCheckedChangeListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_sign_in_Button:{

                denglu();

//                id_login.getPaint().setFlags(0);
//                idvalue=id_login.getText().toString();
//                password_login.getPaint().setFlags(0);
//                passwordvalue=password_login.getText().toString();
//                if (idvalue.equals("13456231239")&&passwordvalue.equals("1234567890")){
//                    if (rememberpassword_login.isChecked()){
//                        SharedPreferences.Editor editor=sp.edit();
//                        editor.putString("PHONEEDIT",idvalue);
//                        editor.putString("PASSWORD",passwordvalue);
//                        editor.commit();
//                    }
//                    Intent intent = new Intent(LoginSignInActivity.this,MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else{
//                    Toast.makeText(LoginSignInActivity.this, "手机号码或密码错误，请重新登录", Toast.LENGTH_SHORT).show();
//                }
            }
                break;

            case R.id.login_sign_up_Button:{
                Intent intent = new Intent(LoginSignInActivity.this,LoginSignUpActivity.class);
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()){
            case R.id.login_autologin:{
                if (auto_login.isChecked()){
                    Log.i(TAG , "自动登录已选中");
                    sp.edit().putBoolean("auto_ischeck",true).commit();
                }else {
                    Log.i(TAG , "自动登录没有选中");
                    sp.edit().putBoolean("auto_ischeck",false).commit();
                }
            }
            break;
            case R.id.login_rememberpassword:{
                if (rememberpassword_login.isChecked()){
                    Log.i(TAG , "记住密码已选中");
                    sp.edit().putBoolean("ischeck",true).commit();
                }
                else {
                    Log.i(TAG , "记住密码没有选中");
                    sp.edit().putBoolean("ischeck",false).commit();
                }
            }
            break;
            default:
                break;
        }
    }


    private void denglu(){



        String url = "http://45.77.151.91:9090/login";
        try {
            OkHttpUtils
                    .post()
                    .url(url)
                    .addParams("uname", id_login.getText().toString())
                    .addParams("upwd", password_login.getText().toString())
                    .build()
                    .execute(new StringCallback()
                    {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.i(TAG,"onError....");
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.i(TAG,"onResponse ==> [id:" + id + "][response:" + response + "]");

                            Toast.makeText(LoginSignInActivity.this,response,Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginSignInActivity.this,MainActivity.class);
                            startActivity(intent);

                        }

                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
