package com.benson.mall.redbaby.parser;

import org.json.JSONException;
import org.json.JSONObject;


import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.vo.Addup;
import com.benson.mall.redbaby.vo.Cart;
import com.benson.mall.redbaby.vo.CartProduct;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class ShoppingCarParser extends BaseParser<Cart> {

	@Override
	public Cart parseJSON(String paramString) throws JSONException {
		if(checkResponse(paramString)!=null){
			Cart cart= new Cart();
			
		
			JSONObject jsonObject = new JSONObject(paramString);

			String cartstr = jsonObject.getString("cart");
			cart =JSON.parseObject(cartstr, Cart.class);
			
			return cart;
		}
		return null;
	}
	
}
