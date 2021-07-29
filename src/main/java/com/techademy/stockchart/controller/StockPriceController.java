package com.techademy.stockchart.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techademy.stockchart.entity.Company;
import com.techademy.stockchart.entity.StockPrice;
import com.techademy.stockchart.model.StockPriceModel;

import com.techademy.stockchart.repository.CompanyRepository;
import com.techademy.stockchart.repository.StockPriceRepository;

@CrossOrigin(origins = "*")
@RestController
public class StockPriceController {
	@Autowired
	private StockPriceRepository stockPriceRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private EntityManager em;

	@PostMapping("/stock/{compId}")
	public StockPrice saveStock(@PathVariable("compId") Long id, @RequestBody StockPrice stockPrice) {
		stockPrice.setCompany(companyRepository.findById(id).get());
		return stockPriceRepository.save(stockPrice);
	}

	@PostMapping("/stocks/{compId}")
	public String saveAllStocks(@PathVariable("compId") Long id, @RequestBody List<StockPrice> stockPriceList) {
		Company company = companyRepository.findById(id).get();
		for (StockPrice stockPrice : stockPriceList) {
			stockPrice.setCompany(company);
		}

		stockPriceRepository.saveAll(stockPriceList);
		return "stocks saved sucessfully";
	}

	@GetMapping("/stock/{compId}")
	public List<StockPriceModel> getStocks(@PathVariable("compId") Long compId) {

		return stockPriceRepository.getStockByCompanyId(compId);
	}

	@GetMapping("/stock/sect/{sectId}")
	public List<Object[]> getStocksBySectorId(@PathVariable("sectId") Long sectId) {
		@SuppressWarnings("unchecked")
		List<Object[]> result = em.createNativeQuery(
				"select avg(share_price) as sect_price,sect_name,datee from company as c natural join sector as s natural join stock_price where s.sect_id=:id group by datee")
				.setParameter("id", sectId).getResultList();

		return result;
	}

	@GetMapping("/stock/code/{compCode}")
	public List<StockPrice> getStocks(@PathVariable("compCode") String compCode) {
		return stockPriceRepository.findByCompCode(compCode);
	}
}
