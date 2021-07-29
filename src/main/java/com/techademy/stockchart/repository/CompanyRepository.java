package com.techademy.stockchart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techademy.stockchart.entity.Company;
import com.techademy.stockchart.model.CompanyModel;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	public Company findByCompName(String compName);

	public Company findByCompNameIgnoreCase(String compName);

	@Transactional
	@Modifying
	@Query(value = "update Company c set c.active=false where c.compId = ?1")
	public void deactivateCompany(Long compId);

	@Transactional
	@Modifying
	@Query(value = "update Company c set c.active=true where c.compId = ?1")
	public void activateCompany(Long compId);

	@Query(value = "select c.compId as compId, c.compName as compName from Company c"

	)
	List<CompanyModel> getAllCompanyNames();
}
