package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.BrandCategory;


/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:30.
 */

public class BrandParser extends BaseParser<List<BrandCategory>> {

    @Override
    public List<BrandCategory> parseJSON(String paramString) throws JSONException {
        if(super.checkResponse(paramString)!=null){
            JSONObject jsonObject = new JSONObject(paramString);
            String productlist = jsonObject.getString("brand");
            return JSON.parseArray(productlist, BrandCategory.class);
        }else{
            return null;
        }
    }

}
