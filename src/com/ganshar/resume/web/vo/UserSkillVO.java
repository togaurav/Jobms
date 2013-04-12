package com.ganshar.resume.web.vo;

import java.sql.Timestamp;
import java.util.Date;

public class UserSkillVO {

	// Fields

	private Long id;
	private Long userId;
	private Long abilityId;
	private Integer abilityType;
	private Integer masterDegree;
	private Integer masterYears;
	private Integer abilityScore;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public UserSkillVO() {
	}

	/** minimal constructor */
	public UserSkillVO(Long userId, Long abilityId,
			Integer abilityType, Integer masterDegree, Integer masterYears,
			Timestamp addTime, Timestamp updateTime) {
		this.userId = userId;
		this.abilityId = abilityId;
		this.abilityType = abilityType;
		this.masterDegree = masterDegree;
		this.masterYears = masterYears;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserSkillVO(Long userId, Long abilityId,
			Integer abilityType, Integer masterDegree, Integer masterYears,
			Integer abilityScore, Timestamp addTime, Timestamp updateTime) {
		this.userId = userId;
		this.abilityId = abilityId;
		this.abilityType = abilityType;
		this.masterDegree = masterDegree;
		this.masterYears = masterYears;
		this.abilityScore = abilityScore;
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

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer getAbilityScore() {
		return this.abilityScore;
	}

	public void setAbilityScore(Integer abilityScore) {
		this.abilityScore = abilityScore;
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