package com.techademy.stockchart.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.techademy.stockchart.entity.CompExchMap;
import com.techademy.stockchart.entity.Company;
import com.techademy.stockchart.entity.IpoDetails;
import com.techademy.stockchart.entity.Sector;
import com.techademy.stockchart.entity.StockExchange;

import com.techademy.stockchart.model.CompExch;
import com.techademy.stockchart.model.CompanyModel;
import com.techademy.stockchart.model.CompanySectorModel;

import com.techademy.stockchart.repository.CompExchMapRepository;
import com.techademy.stockchart.repository.CompanyRepository;
import com.techademy.stockchart.repository.IpoDetailsRepository;
import com.techademy.stockchart.repository.SectorRepository;
import com.techademy.stockchart.repository.StockExchangeRepository;

import com.techademy.stockchart.service.CompanyService;

@CrossOrigin(origins = "*")
@RestController
// @RequestMapping("/api/test")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@Autowired
	private SectorRepository sectorRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CompExchMapRepository compExchMapRepository;

	@Autowired
	private IpoDetailsRepository ipoDetailsRepository;

	@PostMapping("/company")
	public Company saveCompany(@RequestBody /* Company company */CompanySectorModel companySectorModel) {
		Company company = companySectorModel.getCompany();
		Sector sector = companySectorModel.getSector();
		Sector existingSector = sectorRepository.findBySectName(sector.getSectName());
		if (Objects.isNull(existingSector)) {
			Sector newSector = sectorRepository.save(sector);
			company.setSector(newSector);
		} else {
			company.setSector(existingSector);
		}
		Company responseCompany = companyService.saveCompany(company);
		return responseCompany;

	}

	@GetMapping("/company")
	public List<Company> getCompanyList() {
		return companyService.getCompanyList();
	}

	@GetMapping("/company/name")
	public List<CompanyModel> getCompanyNames() {
		return companyRepository.getAllCompanyNames();
	}

	@GetMapping("/company/{id}")
	public Company getCompanyByName(@PathVariable("id") Long id) {
		return companyRepository.findById(id).get();
	}

	@GetMapping("/company/name/{name}")
	public Company getCompanyByName(@PathVariable("name") String name) {
		return companyService.getCompanyByName(name);
	}

	@PutMapping("/company/{id}")
	public Company updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		return companyService.updateCompany(id, company);
	}

	@PostMapping("/company/deactivate/{id}")
	public void deactivateCompany(@PathVariable("id") Long id) {
		companyRepository.deactivateCompany(id);
	}

	@PostMapping("/company/activate/{id}")
	public void activateCompany(@PathVariable("id") Long id) {
		companyRepository.activateCompany(id);
	}

	@PostMapping("/compExch")
	public String saveCompExch(@RequestBody CompExch compExch) {
		Company company = companyRepository.findById(compExch.getCompId()).get();
		StockExchange stockExchange = stockExchangeRepository.findById(compExch.getExchId()).get();
		CompExchMap existingCompExchMap = compExchMapRepository.getCompanyExchangeMap(compExch.getCompId(),
				compExch.getExchId());
		if (Objects.isNull(existingCompExchMap)) {
			CompExchMap compExchMap = new CompExchMap();
			compExchMap.setCompany(company);
			compExchMap.setStockExchange(stockExchange);
			compExchMap.setCompCode(compExch.getCompCode());
			compExchMapRepository.save(compExchMap);
			return "sucessfully saved compExchMap";
		} else {
			return "sucessfully saved compExchMap";
		}

	}

	@GetMapping("/compExch")
	public List<CompExchMap> getCompExch() {
		return compExchMapRepository.findAll();
	}

	@GetMapping("/ipo")
	public List<IpoDetails> getAllIpo() {
		return ipoDetailsRepository.findAll();
	}

	@GetMapping("/sector")
	public List<Sector> getAllSector() {
		return sectorRepository.findAll();
	}
}
