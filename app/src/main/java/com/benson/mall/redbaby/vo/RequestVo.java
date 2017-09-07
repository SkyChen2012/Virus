package com.benson.mall.redbaby.vo;

import java.util.HashMap;

import android.content.Context;

import com.benson.mall.redbaby.parser.BaseParser;
/**
 * com.benson.mall.redbaby.vo
 * Created by Benson on 2017/9/6-下午8:12.
 */

public class RequestVo {
    public int requestUrl;
    public Context context;
    public HashMap<String, String> requestDataMap;
    public BaseParser<?> jsonParser;

    public RequestVo() {
    }

    public RequestVo(int requestUrl, Context context, HashMap<String, String> requestDataMap, BaseParser<?> jsonParser) {
        super();
        this.requestUrl = requestUrl;
        this.context = context;
        this.requestDataMap = requestDataMap;
        this.jsonParser = jsonParser;
    }
}