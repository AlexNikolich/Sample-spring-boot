package com.senecasoap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Time {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TIME_ID")
	private Long timeId;
	
	@OneToMany(mappedBy = "time")
	private List<Sale> sale;
	
	@Column(name="YEAR", length=4)
	private Integer year;
	
	@Column(name="QUARTER", length=1)
	private Integer quarter;
	
	@Column(name="MONTH", length=2)
	private Integer month;
	
	@Column(name="WEEK", length=1)
	private Integer week;
	
	

	public Time() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Time(Long timeId, List<Sale> sale, Integer year, Integer quarter, Integer month, Integer week) {
		super();
		this.timeId = timeId;
		this.sale = sale;
		this.year = year;
		this.quarter = quarter;
		this.month = month;
		this.week = week;
	}

	public Long getTimeId() {
		return timeId;
	}

	public void setTimeId(Long timeId) {
		this.timeId = timeId;
	}

	public List<Sale> getSale() {
		return sale;
	}

	public void setSale(List<Sale> sale) {
		this.sale = sale;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}
	
	
}
