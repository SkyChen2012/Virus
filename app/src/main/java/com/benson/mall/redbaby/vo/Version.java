package com.benson.mall.redbaby.vo;

/**
 * 版本
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:14.
 */

public class Version {
    private boolean isnew;
    private String version;
    private boolean force;
    private String url;

    public Version() {
    }

    public Version(boolean isnew, String version, boolean force, String url) {
        super();
        this.isnew = isnew;
        this.version = version;
        this.force = force;
        this.url = url;
    }

    public boolean isIsnew() {
        return isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
