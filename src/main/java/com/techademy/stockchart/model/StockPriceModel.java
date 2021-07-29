package com.techademy.stockchart.model;

import java.sql.Date;
import java.time.LocalTime;


public interface StockPriceModel 
{
	//Long getStockId();
	//String getCompCode();
	//String getExchName();
	Date getDatee();
	LocalTime getTimee();
	Float getSharePrice();
	
}

