package com.ganshar.job.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TbFuncRankGrowth entity. @author MyEclipse Persistence Tools
 */

public class FuncRankGrowth implements java.io.Serializable {	
	// Fields

	private Long id;
	private Integer funcRankId;
	private Integer servicelen;
	private Integer growthValue;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public FuncRankGrowth() {
	}

	/** minimal constructor */
	public FuncRankGrowth(Integer funcRankId, Integer servicelen, Integer growthValue,  Date addTime,
			Date updateTime) {
		this.funcRankId = funcRankId;
		this.servicelen = servicelen;
		this.growthValue = growthValue;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public FuncRankGrowth(Integer funcRankId, Integer servicelen, Integer growthValue,  Integer industryId,
			Date addTime, Date updateTime) {
		this.funcRankId = funcRankId;
		this.servicelen = servicelen;
		this.growthValue = growthValue;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFuncRankId() {
		return this.funcRankId;
	}

	public void setFuncRankId(Integer funcRankId) {
		this.funcRankId = funcRankId;
	}

	public Integer getServicelen() {
		return servicelen;
	}

	public void setServicelen(Integer servicelen) {
		this.servicelen = servicelen;
	}

	public Integer getGrowthValue() {
		return growthValue;
	}

	public void setGrowthValue(Integer growthValue) {
		this.growthValue = growthValue;
	}

	public Date getAddTime() {
		return addTime;
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