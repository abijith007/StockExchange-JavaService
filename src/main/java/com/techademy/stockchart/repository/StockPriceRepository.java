package com.techademy.stockchart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techademy.stockchart.entity.StockPrice;
import com.techademy.stockchart.model.StockPriceModel;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

	public List<StockPrice> findByCompCode(String compCode);

	@Query(value = "select s.datee as datee,s.timee as timee,s.sharePrice as sharePrice from StockPrice s where s.company.compId = ?1"

	)
	List<StockPriceModel> getStockByCompanyId(Long compId);

}
