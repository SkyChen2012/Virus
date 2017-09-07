package com.benson.mall.redbaby.vo;

/**
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:12.
 */

public class ProductFilterVo {
    private String id;
    private String name;

    public ProductFilterVo() {
    }

    public ProductFilterVo(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}