package com.benson.mall.redbaby.vo;

/**
 * 帮助内容
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:04.
 */

public class HelpDetailvo {

    private String title;

    /** 帮助内容 */
    private String content;

    public HelpDetailvo() {
    }

    public HelpDetailvo(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
