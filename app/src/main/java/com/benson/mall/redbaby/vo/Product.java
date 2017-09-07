package com.benson.mall.redbaby.vo;

/**
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:10.
 */

public class Product {
    public int id;
    public String name;
    public String pic;
    public double marketprice;
    public double price;
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
    public double getMarketprice() {
        return marketprice;
    }
    public void setMarketprice(double marketprice) {
        this.marketprice = marketprice;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}