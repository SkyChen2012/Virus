package com.benson.mall.redbaby.vo;

/**
 * 浏览记录
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:10.
 */

public class ProdcutHistory extends ProductListVo implements Comparable<ProdcutHistory>{
    /** 浏览时间 */
    private long time;

    public ProdcutHistory() {
    }

    public ProdcutHistory(int id, String name, String pic, double marketprice, double price, int comment_count,
                          long time) {
        super(id, name, pic, marketprice, price, comment_count);
        this.time = time;
    }

    public ProdcutHistory(ProductListVo productListVo) {
        super(productListVo.getId(), productListVo.getName(), productListVo.getPic(), productListVo.getMarketprice(),
                productListVo.getPrice(), productListVo.getComment_count());
        this.time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public int compareTo(ProdcutHistory another) {
        return time > another.time ? 1 : -1;
    }




}