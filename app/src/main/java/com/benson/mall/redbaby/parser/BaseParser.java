package com.benson.mall.redbaby.parser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:27.
 */


public abstract class BaseParser<T> {

    public abstract T parseJSON(String paramString) throws JSONException;

    /**
     *
     * @param res
     * @throws JSONException
     */
    public String checkResponse(String paramString) throws JSONException {
        if (paramString == null) {
            return null;
        } else {
            JSONObject jsonObject = new JSONObject(paramString);
            String result = jsonObject.getString("response");
            if (result != null && !result.equals("error")) {
                return result;
            } else {
                return null;
            }

        }
    }
}

