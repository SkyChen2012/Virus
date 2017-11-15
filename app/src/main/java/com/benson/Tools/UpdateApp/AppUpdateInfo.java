package com.benson.Tools.UpdateApp;

/**
 * com.benson.Tools.UpdateApp
 * Created by Benson on 2017/11/14-下午3:19.
 */

public class AppUpdateInfo {

    private String AppName;
    private String version;
    private String url;


    AppUpdateInfo(String AppName,String version,String url){
        this.AppName  = AppName;
        this.version = version;
        this.url = url;
    }

    public String getAppName() {
        return AppName;
    }

    public String getVersion() {
        return version;
    }

    public String getUrl() {
        return url;
    }
}

