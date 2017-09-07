package com.benson.mall.redbaby.parser;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.AddressDetail;


/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class AddressManageParser extends BaseParser<List<AddressDetail>> {

    @Override
    public List<AddressDetail> parseJSON(String paramString) throws JSONException {
        if (!TextUtils.isEmpty(checkResponse(paramString))) {
            JSONObject j = new JSONObject(paramString);
            String addresslist = j.getString("addresslist");
            return JSON.parseArray(addresslist, AddressDetail.class);
        }
        return null;
    }
}
