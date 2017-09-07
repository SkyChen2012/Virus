package com.benson.mall.redbaby.parser;

import org.json.JSONException;

import android.text.TextUtils;

/**
 * 请求是否成功，成功为true 
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class SuccessParser extends BaseParser<Boolean> {

	@Override
	public Boolean parseJSON(String paramString) throws JSONException {
		if (!TextUtils.isEmpty(checkResponse(paramString))) {
			return true;
		}
		return false;
	}
}
