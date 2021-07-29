package com.techademy.stockchart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.techademy.stockchart.entity.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
	public Sector findBySectName(String sectName);

}
