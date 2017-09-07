package com.benson.mall.redbaby.service;

import java.util.List;

import com.benson.mall.redbaby.vo.ProdcutHistory;

public interface IECManager {
	 void addProductToHistory(ProdcutHistory history);
	 void clearProductHistory();
	 List<ProdcutHistory> getAllProductHistory();
}
