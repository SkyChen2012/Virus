package com.benson.mall.redbaby.vo;

/**
 * 首页baner图片
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:05.
 */

public class HomeBanner {
    private int id;
    private String title;
    private String pic;

    public HomeBanner() {
    }

    public HomeBanner(int id, String title, String pic) {
        super();
        this.id = id;
        this.title = title;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
