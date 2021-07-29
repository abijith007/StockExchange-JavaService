package com.techademy.stockchart.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class IpoDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ipoId;
	private Double pricePerShare;
	private Long noOfShares;
	private LocalDateTime openDateTime;

	@OneToOne(mappedBy = "ipo")
	@JsonIgnore
	private Company company;

	public Double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(Double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public Long getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(Long noOfShares) {
		this.noOfShares = noOfShares;
	}

	public LocalDateTime getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(LocalDateTime openDateTime) {
		this.openDateTime = openDateTime;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getIpoId() {
		return ipoId;
	}

	public void setIpoId(Long ipoId) {
		this.ipoId = ipoId;
	}

	public IpoDetails(Long ipoId, Double pricePerShare, Long noOfShares, LocalDateTime openDateTime, Company company) {
		super();
		this.ipoId = ipoId;
		this.pricePerShare = pricePerShare;
		this.noOfShares = noOfShares;
		this.openDateTime = openDateTime;
		this.company = company;
	}

	public IpoDetails(Double pricePerShare, Long noOfShares, LocalDateTime openDateTime, Company company) {
		super();
		this.pricePerShare = pricePerShare;
		this.noOfShares = noOfShares;
		this.openDateTime = openDateTime;
		this.company = company;
	}

	public IpoDetails() {

	}

	@Override
	public String toString() {
		return "IpoDetails [ipoId=" + ipoId + ", pricePerShare=" + pricePerShare + ", noOfShares=" + noOfShares
				+ ", openDateTime=" + openDateTime + ", company=" + company + "]";
	}

}
