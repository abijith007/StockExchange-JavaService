package com.techademy.stockchart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techademy.stockchart.model.StockPriceModel;

import com.techademy.stockchart.repository.StockPriceRepository;

public class StockPriceServiceImpl implements StockPriceService {

	@Autowired
	private StockPriceRepository stockPriceRepository;

	@Override
	public List<StockPriceModel> getStockByCompanyId(Long compId) {

		return stockPriceRepository.getStockByCompanyId(compId);
	}

}
