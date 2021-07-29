package com.techademy.stockchart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long exchId;

	private String exchName;

	private String exchBrief;

	public long getExchId() {
		return exchId;
	}

	public String getExchName() {
		return exchName;
	}

	public void setExchName(String exchName) {
		this.exchName = exchName;
	}

	public String getExchBrief() {
		return exchBrief;
	}

	public void setExchBrief(String exchBrief) {
		this.exchBrief = exchBrief;
	}

	public StockExchange(long exchId, String exchName, String exchBrief) {
		super();
		this.exchId = exchId;
		this.exchName = exchName;
		this.exchBrief = exchBrief;
	}

	public StockExchange() {

	}

	@Override
	public String toString() {
		return "StockExchange [exchId=" + exchId + ", exchName=" + exchName + ", exchBrief=" + exchBrief + "]";
	}

}
