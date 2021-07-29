package com.techademy.stockchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techademy.stockchart.entity.StockExchange;
import com.techademy.stockchart.repository.StockExchangeRepository;

public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@Override
	public StockExchange saveStockExchange(StockExchange stkExch) {

		return stockExchangeRepository.save(stkExch);
	}

	@Override
	public List<StockExchange> getStockExchangeList() {

		return stockExchangeRepository.findAll();
	}

}
