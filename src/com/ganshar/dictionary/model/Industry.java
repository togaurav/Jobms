package com.ganshar.dictionary.model;

import java.util.Date;

/**
 * TdIndustry entity. @author MyEclipse Persistence Tools
 */

public class Industry implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer parentId;
	private String industryDesc;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Industry() {
	}

	/** minimal constructor */
	public Industry(String name, Integer parentId, Date addTime,
			Date updateTime) {
		this.name = name;
		this.parentId = parentId;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Industry(String name, Integer parentId, String industryDesc,
			Date addTime, Date updateTime) {
		this.name = name;
		this.parentId = parentId;
		this.industryDesc = industryDesc;
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

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getIndustryDesc() {
		return this.industryDesc;
	}

	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
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