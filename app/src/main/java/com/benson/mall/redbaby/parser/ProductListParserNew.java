package com.benson.mall.redbaby.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.FilterCategory;
import com.benson.mall.redbaby.vo.ProductListVo;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class ProductListParserNew extends BaseParser<Map<String,Object>> {

	@Override
	public Map<String, Object> parseJSON(String paramString)
			throws JSONException {
		
			Map<String,Object> map = new HashMap<String, Object>();
			if(super.checkResponse(paramString)!=null){
				JSONObject jsonObject = new JSONObject(paramString);
				String productlist = jsonObject.getString("productlist");
				List<ProductListVo> productList = JSON.parseArray(productlist, ProductListVo.class);
				map.put("productlist", productList);
				
				String count = jsonObject.getString("list_count");
				map.put("list_count", count);
				
				String list_filter = jsonObject.getString("list_filter");
				map.put("list_filter", JSON.parseObject(list_filter, FilterCategory.class));
				
				return map;
			}else{
			return null;
			}
	}
	
}
