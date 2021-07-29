package com.techademy.stockchart.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techademy.stockchart.entity.Company;

import com.techademy.stockchart.entity.Sector;
import com.techademy.stockchart.repository.CompanyRepository;
import com.techademy.stockchart.repository.IpoDetailsRepository;
import com.techademy.stockchart.repository.SectorRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private IpoDetailsRepository ipoDetailsRepository;

	@Autowired
	private SectorRepository sectorRepository;

	@Override
	public Company saveCompany(Company company) {

		return companyRepository.save(company);
	}

	@Override
	public List<Company> getCompanyList() {

		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyByName(String name) {

		return companyRepository.findByCompNameIgnoreCase(name);
	}

	@Override
	public Company updateCompany(Long id, Company company) {

		Company comp = companyRepository.findById(id).get();

		if (Objects.nonNull(company.getCompName()) && !"".equalsIgnoreCase(company.getCompName()))
			comp.setCompName(company.getCompName());
		if (Objects.nonNull(company.getTurnover()))
			comp.setTurnover(company.getTurnover());
		if (Objects.nonNull(company.getCeo()) && !"".equalsIgnoreCase(company.getCeo()))
			comp.setCeo(company.getCeo());
		if (Objects.nonNull(company.getBoardOfDirectors()) && !"".equalsIgnoreCase(company.getBoardOfDirectors()))
			comp.setBoardOfDirectors(company.getBoardOfDirectors());
		if (Objects.nonNull(company.getCompBrief()) && !"".equalsIgnoreCase(company.getCompBrief()))
			comp.setCompBrief(company.getCompBrief());

		if (Objects.isNull(comp.getIpo())) {

			comp.setIpo(ipoDetailsRepository.save(company.getIpo()));
		} else {
			if (Objects.nonNull(company.getIpo().getPricePerShare()))
				comp.getIpo().setPricePerShare(company.getIpo().getPricePerShare());
			if (Objects.nonNull(company.getIpo().getNoOfShares()))
				comp.getIpo().setNoOfShares(company.getIpo().getNoOfShares());
			if (Objects.nonNull(company.getIpo().getOpenDateTime()))
				comp.getIpo().setOpenDateTime(company.getIpo().getOpenDateTime());
		}
		if (Objects.isNull(comp.getSector())) {
			Sector existingSector = sectorRepository.findBySectName(company.getSector().getSectName());
			if (Objects.isNull(existingSector)) {
				Sector newSector = sectorRepository.save(company.getSector());
				comp.setSector(newSector);
			} else {
				comp.setSector(existingSector);
			}

		} else {
			if (Objects.nonNull(company.getSector().getSectName()))
				comp.getSector().setSectName(company.getSector().getSectName());
			if (Objects.nonNull(company.getSector().getSectBrief()))
				comp.getSector().setSectBrief(company.getSector().getSectBrief());
		}

		return companyRepository.save(comp);
	}

	@Override
	public void deactivateCompany(Long id) {

	}

}
