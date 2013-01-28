package com.ganshar.job.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TbJobAbility entity. @author MyEclipse Persistence Tools
 */

public class JobAbility implements java.io.Serializable {

	// Fields

	private Long id;
	private Long jobId;
	private Long abilityId;
	private Integer abilityType;
	private Integer masterDegree;
	private Integer masterYears;
	private Double abilityRatio;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public JobAbility() {
	}

	/** minimal constructor */
	public JobAbility(Long jobId, Long abilityId, Integer abilityType,
			Integer masterDegree, Double abilityRatio, Date addTime,
			Date updateTime) {
		this.jobId = jobId;
		this.abilityId = abilityId;
		this.abilityType = abilityType;
		this.masterDegree = masterDegree;
		this.abilityRatio = abilityRatio;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public JobAbility(Long jobId, Long abilityId, Integer abilityType,
			Integer masterDegree, Integer masterYears, Double abilityRatio,
			Date addTime, Date updateTime) {
		this.jobId = jobId;
		this.abilityId = abilityId;
		this.abilityType = abilityType;
		this.masterDegree = masterDegree;
		this.masterYears = masterYears;
		this.abilityRatio = abilityRatio;
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

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getAbilityId() {
		return this.abilityId;
	}

	public void setAbilityId(Long abilityId) {
		this.abilityId = abilityId;
	}

	public Integer getAbilityType() {
		return this.abilityType;
	}

	public void setAbilityType(Integer abilityType) {
		this.abilityType = abilityType;
	}

	public Integer getMasterDegree() {
		return this.masterDegree;
	}

	public void setMasterDegree(Integer masterDegree) {
		this.masterDegree = masterDegree;
	}

	public Integer getMasterYears() {
		return this.masterYears;
	}

	public void setMasterYears(Integer masterYears) {
		this.masterYears = masterYears;
	}

	public Double getAbilityRatio() {
		return this.abilityRatio;
	}

	public void setAbilityRatio(Double abilityRatio) {
		this.abilityRatio = abilityRatio;
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