package com.techademy.stockchart.service;

import java.util.List;

import com.techademy.stockchart.entity.StockExchange;

public interface StockExchangeService 
{
	public StockExchange saveStockExchange(StockExchange stkExch);

	public List<StockExchange> getStockExchangeList();
}
