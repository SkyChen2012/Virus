package com.benson.mall.redbaby.parser;


import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.util.Logger;
import com.benson.mall.redbaby.vo.User;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class UserinfoParser extends BaseParser<User> {

	private static final String TAG = "UserinfoParser";

	@Override
	public User parseJSON(String paramString) throws JSONException {
		if(super.checkResponse(paramString)!=null){
			Logger.d(TAG, "解析Userinfo数据");
			JSONObject json = new JSONObject(paramString);
			String useinfoObj = json.getString("userinfo");
			User userInfoList = JSON.parseObject(useinfoObj, User.class);
			return userInfoList;
		}
		return null;
	}

}
