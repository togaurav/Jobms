package com.ganshar.job.model;

import java.util.Date;

/**
 * TbFuncRank entity. @author MyEclipse Persistence Tools
 */

public class FuncRank implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Double ratioFunction;
	private Double ratioAbility;
	private Double ratioIndustry;
	private String funcDesc;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public FuncRank() {
	}

	/** minimal constructor */
	public FuncRank(String name, Double ratioFunction, Double ratioAbility,
			Double ratioIndustry, Date addTime, Date updateTime) {
		this.name = name;
		this.ratioFunction = ratioFunction;
		this.ratioAbility = ratioAbility;
		this.ratioIndustry = ratioIndustry;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public FuncRank(String name, Double ratioFunction, Double ratioAbility,
			Double ratioIndustry, String funcDesc, Date addTime,
			Date updateTime) {
		this.name = name;
		this.ratioFunction = ratioFunction;
		this.ratioAbility = ratioAbility;
		this.ratioIndustry = ratioIndustry;
		this.funcDesc = funcDesc;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRatioFunction() {
		return this.ratioFunction;
	}

	public void setRatioFunction(Double ratioFunction) {
		this.ratioFunction = ratioFunction;
	}

	public Double getRatioAbility() {
		return this.ratioAbility;
	}

	public void setRatioAbility(Double ratioAbility) {
		this.ratioAbility = ratioAbility;
	}

	public Double getRatioIndustry() {
		return this.ratioIndustry;
	}

	public void setRatioIndustry(Double ratioIndustry) {
		this.ratioIndustry = ratioIndustry;
	}

	public String getFuncDesc() {
		return this.funcDesc;
	}

	public void setFuncDesc(String funcDesc) {
		this.funcDesc = funcDesc;
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