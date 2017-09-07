package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.BulletinVo;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class BulletinParser extends BaseParser<List<BulletinVo>> {

	@Override
	public List<BulletinVo> parseJSON(String paramString) throws JSONException {
		if (super.checkResponse(paramString) != null) {
			JSONObject jsonObject = new JSONObject(paramString);
			String topic = jsonObject.getString("topic");
			return JSON.parseArray(topic, BulletinVo.class);
		}else{

		return null;
		}
	}

}
