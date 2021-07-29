package com.techademy.stockchart.entity;

import java.sql.Date;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StockPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stockId;
	private String exchName;
	private String compCode;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "comp_id", referencedColumnName = "compId")
	private Company company;
	private Date datee;
	private LocalTime timee;
	private float sharePrice;

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public String getExchName() {
		return exchName;
	}

	public void setExchName(String exchName) {
		this.exchName = exchName;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public LocalTime getTimee() {
		return timee;
	}

	public void setTimee(LocalTime timee) {
		this.timee = timee;
	}

	public float getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}

	public StockPrice(String exchName, String compCode, Company company, Date datee, LocalTime timee, float sharePrice) {
		super();
		this.exchName = exchName;
		this.compCode = compCode;
		this.company = company;
		this.datee = datee;
		this.timee = timee;
		this.sharePrice = sharePrice;
	}

	public StockPrice() {

	}
}
