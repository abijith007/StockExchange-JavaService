package com.techademy.stockchart.model;

import java.sql.Date;
import java.time.LocalTime;

public interface SectorPriceModel 
{
	Long getSectPrice();
	String getSectName();
	Date getDatee();
	LocalTime getTimee();
}
