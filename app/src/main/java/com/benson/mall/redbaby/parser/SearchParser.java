package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.Product;
import com.benson.mall.redbaby.vo.ProductListVo;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class SearchParser extends BaseParser<List<ProductListVo>> {

	@Override
	public List<ProductListVo> parseJSON(String paramString) throws JSONException {
		if(super.checkResponse(paramString)!=null){
			JSONObject jsonObject = new JSONObject(paramString);
			String search_keywords = jsonObject.getString("productlist");
			List<ProductListVo> products = JSON.parseArray(search_keywords, ProductListVo.class);
			return products;
		}
		return null;
	}

}
