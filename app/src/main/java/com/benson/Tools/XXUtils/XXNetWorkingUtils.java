package com.benson.Tools.XXUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.benson.Tools.XXUtils
 * Created by Benson on 2017/11/16-上午9:14.
 */

public class XXNetWorkingUtils {

    /**
     *  判断是否有网络
     * @param context
     * @return
     */
    public static boolean isNetWorkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager mgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mgr != null) {
            NetworkInfo info = mgr.getActiveNetworkInfo();
            if (info != null && info.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /**
     *  判断邮箱格式
     * @param email
     * @param context
     * @return
     */
    public static boolean isEmail(String email, Context context) {
        Pattern pattern = Pattern
                .compile("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = pattern.matcher(email);
        Log.v("email", "-----------email:"+email);
        if (!matcher.matches() || TextUtils.isEmpty(email)) {
            Toast.makeText(context, "邮箱格式错误", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
