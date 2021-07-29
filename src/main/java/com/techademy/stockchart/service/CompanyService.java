package com.techademy.stockchart.service;

import java.util.List;

import com.techademy.stockchart.entity.Company;

public interface CompanyService 
{

	public Company saveCompany(Company company);

	public List<Company> getCompanyList();

	public Company getCompanyByName(String name);

	public Company updateCompany(Long id, Company company);
	
	public void deactivateCompany(Long id);
	
}
