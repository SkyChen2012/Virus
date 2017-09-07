package com.benson.mall.redbaby.vo;

/**
 * 首页栏目
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:06.
 */

public class HomeCategory {
    private int imgresid;
    private String title;

    public HomeCategory() {
    }

    public HomeCategory(int imgresid, String title) {
        super();
        this.imgresid = imgresid;
        this.title = title;
    }

    public int getImgresid() {
        return imgresid;
    }

    public void setImgresid(int imgresid) {
        this.imgresid = imgresid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}