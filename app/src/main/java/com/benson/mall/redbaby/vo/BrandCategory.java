package com.benson.mall.redbaby.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐品牌栏目
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午7:59.
 */

public class BrandCategory {
    /** 分区名称 */
    private String key;

    /** 栏目下所有的 Brands*/
    private List<Brand> value = new ArrayList<Brand>();

    public BrandCategory() {

    }
    public BrandCategory(String key, List<Brand> value) {
        super();
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Brand> getValue() {
        return value;
    }

    public void setValue(List<Brand> value) {
        this.value = value;
    }
}
