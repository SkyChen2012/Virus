package com.benson.mall.redbaby.vo;

/**
 * 支付方式
 *
 *  支付类型，1=>货到付款 2=>货到POS机    3=>支付宝(待定)
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:09.
 */

public class Paymentvo {
    private int type;

    public Paymentvo() {
    }

    public Paymentvo(int type) {
        super();
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}