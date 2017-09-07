package com.benson.mall.redbaby.vo;

/**
 * 推荐品牌
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午7:58.
 */

public class Brand {
    private int id;
    private String name;
    private String pic;

    public Brand() {
    }

    public Brand(int id, String name, String pic) {
        super();
        this.id = id;
        this.name = name;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
