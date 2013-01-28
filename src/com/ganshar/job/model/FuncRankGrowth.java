package com.ganshar.job.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TbFuncRankGrowth entity. @author MyEclipse Persistence Tools
 */

public class FuncRankGrowth implements java.io.Serializable {
	
	public final static int TYPE_WORK_SERVICELEN=1;
	public final static int TYPE_COMPANY_TYPE=2;
	public final static int TYPE_EDUCATION=3;
	public final static int TYPE_EDUCATION_THRESHOLD=4;
	public final static int TYPE_WORK_SERVICELEN_THRESHOLD=5;
	
	// Fields

	private Long id;
	private Integer funcRankId;
	private Integer growthType;
	private Integer growthTypeValue;
	private Double growthValue;
	private Integer columnSeq;
	private Integer industryId;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public FuncRankGrowth() {
	}

	/** minimal constructor */
	public FuncRankGrowth(Integer funcRankId, Integer growthType, Integer growthTypeValue,
			Double growthValue, Integer columnSeq, Date addTime,
			Date updateTime) {
		this.funcRankId = funcRankId;
		this.growthType = growthType;
		this.growthTypeValue=growthTypeValue;
		this.growthValue = growthValue;
		this.columnSeq = columnSeq;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public FuncRankGrowth(Integer funcRankId, Integer growthType,Integer growthTypeValue,
			Double growthValue, Integer columnSeq, Integer industryId,
			Date addTime, Date updateTime) {
		this.funcRankId = funcRankId;
		this.growthType = growthType;
		this.growthTypeValue=growthTypeValue;
		this.growthValue = growthValue;
		this.columnSeq = columnSeq;
		this.industryId = industryId;
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

	public Integer getGrowthType() {
		return this.growthType;
	}

	public void setGrowthType(Integer growthType) {
		this.growthType = growthType;
	}

	public Integer getGrowthTypeValue() {
		return growthTypeValue;
	}

	public void setGrowthTypeValue(Integer growthTypeValue) {
		this.growthTypeValue = growthTypeValue;
	}

	public Double getGrowthValue() {
		return this.growthValue;
	}

	public void setGrowthValue(Double growthValue) {
		this.growthValue = growthValue;
	}

	public Integer getColumnSeq() {
		return this.columnSeq;
	}

	public void setColumnSeq(Integer columnSeq) {
		this.columnSeq = columnSeq;
	}

	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
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