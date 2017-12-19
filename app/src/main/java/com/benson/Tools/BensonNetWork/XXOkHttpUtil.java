package com.benson.Tools.BensonNetWork;

import android.util.Log;
import java.io.IOException;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * com.benson.BensonNetWork
 * Created by Benson on 2017/11/14-上午11:05.
 */


public class XXOkHttpUtil {

    private static final String TAG ="OkHttpUtil";
    private OkHttpClient mOkHttpClient;
    private static final String CHARSET_NAME = "UTF-8";

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static XXOkHttpUtil instance = null;

    /* 私有构造方法，防止被实例化 */
    private XXOkHttpUtil() {
        Init();
    }
    /**
     * 懒汉式变种，解决线程安全问题
     * @return
     */
    public static synchronized XXOkHttpUtil getInstance() {
        if (instance == null) {
            instance = new XXOkHttpUtil();
        }
        return instance;
    }

    /**
     * Init XXSharedPreferences
     * @return
     */
    private boolean Init(){
        mOkHttpClient = new OkHttpClient();
        return true;
    }


    /**
     * 非异步方式，会阻塞线程，等待返回结果。
     * 注意，android本身是不允许在UI线程做网络请求操作
     * @param request
     * @return
     * @throws IOException
     */
    private  Response execute(Request request) throws IOException{
        return mOkHttpClient.newCall(request).execute();
    }
    /**
     * 开启异步线程访问网络
     * @param request
     * @param responseCallback
     */
    private  void enqueue(Request request, Callback responseCallback){
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }
    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     * @param request
     */
    private  void enqueue(Request request){
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG,call.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String htmlStr =  response.body().string();
                Log.i(TAG,"[response:" + response.toString() + "][call:"+ call.toString() +"][htmlStr:]"+ htmlStr);

            }
        });
    }

    /**
     * 异步
     * @param url
     * @param responseCallback
     * @return
     * @throws IOException
     */
    public  void getStringFromServerEnqueue(String url, Callback responseCallback) {
        Request request = new Request.Builder().url(url).build();
        enqueue(request, responseCallback);
    }
    /**
     *  同步
     * @param url
     * @return
     * @throws IOException
     */
    public  String getStringFromServerExecute(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 这里使用了HttpClinet的API。只是为了方便
     * @param params
     * @return
     */
    public String formatParams(List<BasicNameValuePair> params){
        return URLEncodedUtils.format(params, CHARSET_NAME);
    }
    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     * @param url
     * @param params
     * @return
     */
    public String attachHttpGetParams(String url, List<BasicNameValuePair> params){
        return url + "?" + formatParams(params);
    }
    /**
     * 为HttpGet 的 url 方便的添加1个name value 参数。
     * @param url
     * @param name
     * @param value
     * @return
     */
    public String attachHttpGetParam(String url, String name, String value){
        return url + "?" + name + "=" + value;
    }

}
