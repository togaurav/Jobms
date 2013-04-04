package com.ganshar.dictionary.model;

import java.sql.Timestamp;

/**
 * TbIndustryConvert entity. @author MyEclipse Persistence Tools
 */

public class IndustryConvert implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer curIndustryId;
	private Integer tarIndustryId;
	private Double convertRatio;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public IndustryConvert() {
	}

	/** full constructor */
	public IndustryConvert(Integer curIndustryId, Integer tarIndustryId,
			Double convertRatio, Timestamp addTime) {
		this.curIndustryId = curIndustryId;
		this.tarIndustryId = tarIndustryId;
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

	public Integer getCurIndustryId() {
		return this.curIndustryId;
	}

	public void setCurIndustryId(Integer curIndustryId) {
		this.curIndustryId = curIndustryId;
	}

	public Integer getTarIndustryId() {
		return this.tarIndustryId;
	}

	public void setTarIndustryId(Integer tarIndustryId) {
		this.tarIndustryId = tarIndustryId;
	}

	public Double getConvertRatio() {
		return this.convertRatio;
	}

	public void setConvertRatio(Double convertRatio) {
		this.convertRatio = convertRatio;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}