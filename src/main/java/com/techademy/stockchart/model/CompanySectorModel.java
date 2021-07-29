package com.techademy.stockchart.model;

import com.techademy.stockchart.entity.Company;
import com.techademy.stockchart.entity.Sector;

public class CompanySectorModel
{
	private Company company;
	private Sector sector;
	public CompanySectorModel(Company company, Sector sector) {
		super();
		this.company = company;
		this.sector = sector;
	}
	public CompanySectorModel() {
		
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
	
}
