package com.ganshar.dictionary.model;

import java.util.Date;

/**
 * TdCitySalary entity. @author MyEclipse Persistence Tools
 */

public class CitySalary implements java.io.Serializable {

	// Fields

	private Integer id;
	private String cityName;
	private Integer salaryStd;
	private Double salaryRatio;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public CitySalary() {
	}

	/** minimal constructor */
	public CitySalary(String cityName, Double salaryRatio, Date addTime,
			Date updateTime) {
		this.cityName = cityName;
		this.salaryRatio = salaryRatio;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public CitySalary(String cityName, Integer salaryStd, Double salaryRatio,
			Date addTime, Date updateTime) {
		this.cityName = cityName;
		this.salaryStd = salaryStd;
		this.salaryRatio = salaryRatio;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getSalaryStd() {
		return this.salaryStd;
	}

	public void setSalaryStd(Integer salaryStd) {
		this.salaryStd = salaryStd;
	}

	public Double getSalaryRatio() {
		return this.salaryRatio;
	}

	public void setSalaryRatio(Double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}