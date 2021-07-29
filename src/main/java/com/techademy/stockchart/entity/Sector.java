package com.techademy.stockchart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sector 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sectId;

	@Column(nullable = false)
	private String sectName;

	private String sectBrief;

	public Long getSectId() {
		return sectId;
	}
	
	public String getSectName() {
		return sectName;
	}

	public void setSectName(String sectName) {
		this.sectName = sectName;
	}

	public String getSectBrief() {
		return sectBrief;
	}

	public void setSectBrief(String sectBrief) {
		this.sectBrief = sectBrief;
	}

	public Sector(Long sectId, String sectName, String sectBrief) {
		super();
		this.sectId = sectId;
		this.sectName = sectName;
		this.sectBrief = sectBrief;
	}

	public Sector() {
		
	}

	@Override
	public String toString() {
		return "Sector [sectId=" + sectId + ", sectName=" + sectName + ", sectBrief=" + sectBrief + "]";
	}

	

	
}
