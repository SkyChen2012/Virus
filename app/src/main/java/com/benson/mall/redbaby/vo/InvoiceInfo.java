package com.benson.mall.redbaby.vo;

/**
 * 发票信息
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:06.
 */

public class InvoiceInfo {
    /** 发票抬头 */
    private int id;

    /** 发票内容 */
    private String title;

    /** 发票内容 */
    private String content;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int id, String title, String content) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
