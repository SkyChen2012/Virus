package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.Limitbuy;
import com.benson.mall.redbaby.vo.ProductListVo;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class LimitbuyParser extends BaseParser<List<Limitbuy>> {

	@Override
	public List<Limitbuy> parseJSON(String paramString) throws JSONException {
		if(super.checkResponse(paramString)!=null){
			JSONObject jsonObject = new JSONObject(paramString);
			String productlist = jsonObject.getString("productlist");
			return JSON.parseArray(productlist, Limitbuy.class);
		}else{
		return null;
		}
	}

}
