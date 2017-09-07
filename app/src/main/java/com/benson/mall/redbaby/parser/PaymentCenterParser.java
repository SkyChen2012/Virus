package com.benson.mall.redbaby.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.benson.mall.redbaby.util.Logger;
import com.benson.mall.redbaby.vo.Address;
import com.benson.mall.redbaby.vo.CartProduct;
import com.benson.mall.redbaby.vo.CheckoutAddup;
import com.benson.mall.redbaby.vo.Delivery;
import com.benson.mall.redbaby.vo.InvoiceInfo;
import com.benson.mall.redbaby.vo.OrderInfo;
import com.benson.mall.redbaby.vo.Payment;

/**
 * com.benson.mall.redbaby.parser
 * Created by Benson on 2017/9/6-下午8:26.
 */

public class PaymentCenterParser extends BaseParser<Map<String,Object>> {

	private static final String TAG = "PaymentCenterParser";

	@Override
	public Map<String,Object> parseJSON(String paramString) throws JSONException {
		Logger.d(TAG, "解析PaymentCenterParser订单详细信息");
		Map<String,Object> map = new HashMap<String, Object>();
				
		JSONObject json = new JSONObject(paramString);
		
		String address = json.getString("address_info");
		Address addressInfo = JSON.parseObject(address, Address.class);
		map.put("addressInfo", addressInfo);
		Logger.d(TAG, "解析addreInfo 成功");
		
		String payment = json.getString("payment_info");
		Payment paymentInfo = JSON.parseObject(payment, Payment.class);
		map.put("paymentInfo", paymentInfo);
		Logger.d(TAG, "解析paymentInfo 成功");
		
		String delivery = json.getString("delivery_info");
		Delivery deliveryInfo = JSON.parseObject(delivery, Delivery.class);
		map.put("deliveryInfo", deliveryInfo);
		Logger.d(TAG, "解析deliveryInfo 成功");
		
		String invoice = json.getString("invoice_info");
		InvoiceInfo invoiceInfo = JSON.parseObject(invoice, InvoiceInfo.class);
		map.put("invoiceInfo", invoiceInfo);
		Logger.d(TAG, "解析invoiceInfo 成功");
		
		String productlist = json.getString("productlist");
		List<CartProduct> productlistInfo = JSON.parseArray(productlist, CartProduct.class);
		map.put("productlistInfo", productlistInfo);
		Logger.d(TAG, "解析productlistInfo 成功");
		
		String checkout_prom = json.getString("checkout_prom");
		List<String> checkoutList = JSON.parseArray(checkout_prom, String.class);
		map.put("checkout", checkoutList);
		Logger.d(TAG, "解析checkout 成功");
		
		String checkout_addup = json.getString("checkout _addup");
		CheckoutAddup checkoutAdd = JSON.parseObject(checkout_addup,CheckoutAddup.class);
		map.put("checkoutAdd", checkoutAdd);
		Logger.d(TAG, "解析checkoutAdd 成功");
		
		return map;
	}
}
