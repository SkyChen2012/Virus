package com.benson.mall.redbaby.parser;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.FilterCategory;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */


public class ProductFilterParser extends BaseParser<List<FilterCategory>> {

	@Override
	public List<FilterCategory> parseJSON(String paramString)
			throws JSONException {
		if (super.checkResponse(paramString) != null) {
			JSONObject jsonObject = new JSONObject(paramString);
			String filter = jsonObject.getString("list_filter");
			return JSON.parseArray(filter, FilterCategory.class);
		}else{

		return null;
		}
	}

	

}
