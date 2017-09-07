package com.benson.mall.redbaby.parser;

import java.util.List;


import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.CategoryVo;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class CategoryParser extends BaseParser<List<CategoryVo>> {

	@Override
	public List<CategoryVo> parseJSON(String paramString) throws JSONException {
		JSONObject obj = new JSONObject(paramString);
		String str = obj.getString("category");
		return JSON.parseArray(str, CategoryVo.class);
	}

	

}
