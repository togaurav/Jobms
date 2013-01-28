package com.ganshar.job.model;

import java.util.Date;

/**
 * TbFuncRankConvert entity. @author MyEclipse Persistence Tools
 */

public class FuncRankConvert implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer curFuncRankId;
	private Integer tarFuncRankId;
	private Double convertRatio;
	private Date addTime;

	// Constructors

	/** default constructor */
	public FuncRankConvert() {
	}

	/** full constructor */
	public FuncRankConvert(Integer curFuncRankId, Integer tarFuncRankId,
			Double convertRatio, Date addTime) {
		this.curFuncRankId = curFuncRankId;
		this.tarFuncRankId = tarFuncRankId;
		this.convertRatio = convertRatio;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCurFuncRankId() {
		return this.curFuncRankId;
	}

	public void setCurFuncRankId(Integer curFuncRankId) {
		this.curFuncRankId = curFuncRankId;
	}

	public Integer getTarFuncRankId() {
		return this.tarFuncRankId;
	}

	public void setTarFuncRankId(Integer tarFuncRankId) {
		this.tarFuncRankId = tarFuncRankId;
	}

	public Double getConvertRatio() {
		return this.convertRatio;
	}

	public void setConvertRatio(Double convertRatio) {
		this.convertRatio = convertRatio;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}