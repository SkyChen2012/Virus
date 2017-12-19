package com.benson.Tools.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.benson.virus.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import okhttp3.Call;

/**
 * com.benson.Tools.Login
 * Created by Benson on 2017/11/28-下午3:13.
 */

public class LoginSignUpActivity extends Activity implements  OnClickListener{

    private final static String Tag = "LoginSignUpActivity";

    private EditText sign_up_id;
    private EditText sign_up_password;
    private EditText sign_up_Verification_Code;

    private Button login_Verification_Btn;
    private Button login_sign_up_btn;

    public EventHandler eventHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //找到相应的布局及控件
        setContentView(R.layout.login_sign_up);

        init();

        SMSSDK.registerEventHandler(eventHandler);

    }



    private void init() {
        sign_up_id = (EditText)findViewById(R.id.sign_up_id);
        sign_up_password = (EditText)findViewById(R.id.sign_up_password);
        sign_up_Verification_Code = (EditText)findViewById(R.id.sign_up_Verification_Code);

        login_Verification_Btn = (Button)findViewById(R.id.login_Verification_Btn);
        login_sign_up_btn = (Button)findViewById(R.id.login_sign_up_btn);

        login_Verification_Btn.setOnClickListener(this);
        login_sign_up_btn.setOnClickListener(this);

        initSMS();
    }

    private void initSMS() {

        eventHandler = new EventHandler(){

            @Override
            public void onRegister() {
                super.onRegister();
                Log.i(Tag,"onRegister...");
            }

            @Override
            public void beforeEvent(int i, Object o) {
                super.beforeEvent(i, o);
                Log.i(Tag,"beforeEvent ==> [i:" + i + "]");
            }

            @Override
            public void onUnregister() {
                super.onUnregister();
                Log.i(Tag,"onUnregister...");
            }

            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE){
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginSignUpActivity.this,"验证成功",Toast.LENGTH_SHORT).show();

                                zhuce();

                            }
                        });

                    }else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                        //获取验证码成功
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(LoginSignUpActivity.this,"验证码已发送",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else if (event ==SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES){



                    }
                }else{
                    ((Throwable)data).printStackTrace();
                    Throwable throwable = (Throwable) data;
                    try {
                        JSONObject obj = new JSONObject(throwable.getMessage());
                        final String des = obj.optString("detail");
                        if (!TextUtils.isEmpty(des)){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginSignUpActivity.this,"提交错误信息",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_Verification_Btn:{
                String number = sign_up_id.getText().toString();
                SMSSDK.getVerificationCode("86",number);
            }
            break;
            case R.id.login_sign_up_btn:{
                String nuVerification_Codember = sign_up_Verification_Code.getText().toString();
                String number = sign_up_id.getText().toString();
                SMSSDK.submitVerificationCode("86",number,nuVerification_Codember);

            }
            break;
            default:
                break;
        }

    }

    private void zhuce(){
        String url = "http://45.77.151.91:9090/register";
        try {
            OkHttpUtils
                    .post()
                    .url(url)
                    .addParams("uname", sign_up_id.getText().toString())
                    .addParams("upwd", sign_up_password.getText().toString())
                    .build()
                    .execute(new StringCallback()
                    {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.i(Tag,"onError....");
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.i(Tag,"onResponse ==> [id:" + id + "][response:" + response + "]");

                            Toast.makeText(LoginSignUpActivity.this,response,Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginSignUpActivity.this,LoginSignInActivity.class);
                            startActivity(intent);

                        }

                    });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
