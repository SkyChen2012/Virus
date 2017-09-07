package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.ProductDetail;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */


public class ProductDetailParser extends BaseParser<ProductDetail> {
	@Override
	public ProductDetail parseJSON(String paramString) throws JSONException {
		if(super.checkResponse(paramString)!=null){
			JSONObject jsonObject = new JSONObject(paramString);
			String product = jsonObject.getString("product");
			ProductDetail productDetail = JSON.parseObject(product,ProductDetail.class);
			return productDetail;
		}
		return null;
	}

}
