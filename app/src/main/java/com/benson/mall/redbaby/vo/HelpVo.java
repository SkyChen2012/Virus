package com.benson.mall.redbaby.vo;

import java.io.Serializable;

/**
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:05.
 */

public class HelpVo implements Serializable {

    private static final long serialVersionUID = 1802089513775943789L;
    private String id;
    private String title;
    private String detail_url;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDetail_url() {
        return detail_url;
    }
    public void setDetail_url(String detail_url) {
        this.detail_url = detail_url;
    }

}