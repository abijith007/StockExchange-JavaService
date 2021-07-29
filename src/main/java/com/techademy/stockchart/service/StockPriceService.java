package com.techademy.stockchart.service;

import java.util.List;

import com.techademy.stockchart.model.StockPriceModel;

public interface StockPriceService {
	public List<StockPriceModel> getStockByCompanyId(Long compId);
}
