package com.techademy.stockchart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long compId;

	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean active;

	private String compName;

	private Double turnover;

	private String ceo;

	@Type(type = "text")
	private String boardOfDirectors;

	@Type(type = "text")
	private String compBrief;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ipo_id", referencedColumnName = "ipoId")

	private IpoDetails ipo;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "sect_id", referencedColumnName = "sectId")
	private Sector sector;

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getCompBrief() {
		return compBrief;
	}

	public void setCompBrief(String compBrief) {
		this.compBrief = compBrief;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public IpoDetails getIpo() {
		return ipo;
	}

	public void setIpo(IpoDetails ipo) {
		this.ipo = ipo;
	}

	public Company(Long compId, String compName, Double turnover, String ceo, String boardOfDirectors, String compBrief) {
		super();
		this.compId = compId;
		this.compName = compName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.compBrief = compBrief;
	}

	public Company(Long compId, String compName, Double turnover, String ceo, String boardOfDirectors, String compBrief,
			IpoDetails ipo) {
		super();
		this.compId = compId;
		this.compName = compName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.compBrief = compBrief;
		this.ipo = ipo;

	}

	public Company() {

	}

	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compName=" + compName + ", turnover=" + turnover + ", ceo=" + ceo
				+ ", boardOfDirectors=" + boardOfDirectors + ", compBrief=" + compBrief + "]";
	}

}
