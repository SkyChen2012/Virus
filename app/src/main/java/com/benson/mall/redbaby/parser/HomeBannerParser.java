package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.HomeBanner;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class HomeBannerParser extends BaseParser<List<HomeBanner>>{

	@Override
	public List<HomeBanner> parseJSON(String paramString) throws JSONException {
		if (!TextUtils.isEmpty(checkResponse(paramString))) {
			JSONObject j = new JSONObject(paramString);
 			return JSON.parseArray(j.getString("home_banner"), HomeBanner.class);
		}
		return null;
	}

}
