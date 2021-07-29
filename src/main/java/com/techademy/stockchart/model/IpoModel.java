package com.techademy.stockchart.model;

import java.time.LocalDateTime;

import com.techademy.stockchart.entity.Company;

public interface IpoModel {
	Double getPricePerShare();
	Long getNoOfShares();
	LocalDateTime getOpenDateTime();
	Company getCompany();
}
