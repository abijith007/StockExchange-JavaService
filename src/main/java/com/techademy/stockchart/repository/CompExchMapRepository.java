package com.techademy.stockchart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techademy.stockchart.entity.CompExchMap;

@Repository
public interface CompExchMapRepository extends JpaRepository<CompExchMap, Long> {
	@Query(value = "select c from CompExchMap c where c.company.compId = ?1 and c.stockExchange.exchId = ?2"

	)
	CompExchMap getCompanyExchangeMap(Long compId, Long exchId);
}
