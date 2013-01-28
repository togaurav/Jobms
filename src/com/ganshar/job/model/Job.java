package com.ganshar.job.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TbJob entity. @author MyEclipse Persistence Tools
 */

public class Job implements java.io.Serializable {

	// Fields

	private Long jobId;
	private String jobName;
	private String level;
	private Integer funcRankId;
	private Integer industryId;
	private Double ratioFunction;
	private Double ratioAbility;
	private Double ratioIndustry;
	private String jobnameTag;
	private String abilityTag;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** minimal constructor */
	public Job(String jobName, String level, Integer funcRankId,
			Integer industryId, Double ratioFunction, Double ratioAbility,
			Double ratioIndustry, Date addTime, Date updateTime) {
		this.jobName = jobName;
		this.level = level;
		this.funcRankId = funcRankId;
		this.industryId = industryId;
		this.ratioFunction = ratioFunction;
		this.ratioAbility = ratioAbility;
		this.ratioIndustry = ratioIndustry;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Job(String jobName, String level, Integer funcRankId,
			Integer industryId, Double ratioFunction, Double ratioAbility,
			Double ratioIndustry, String jobnameTag, String abilityTag,
			Date addTime, Date updateTime) {
		this.jobName = jobName;
		this.level = level;
		this.funcRankId = funcRankId;
		this.industryId = industryId;
		this.ratioFunction = ratioFunction;
		this.ratioAbility = ratioAbility;
		this.ratioIndustry = ratioIndustry;
		this.jobnameTag = jobnameTag;
		this.abilityTag = abilityTag;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getFuncRankId() {
		return this.funcRankId;
	}

	public void setFuncRankId(Integer funcRankId) {
		this.funcRankId = funcRankId;
	}

	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
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

	public String getJobnameTag() {
		return this.jobnameTag;
	}

	public void setJobnameTag(String jobnameTag) {
		this.jobnameTag = jobnameTag;
	}

	public String getAbilityTag() {
		return this.abilityTag;
	}

	public void setAbilityTag(String abilityTag) {
		this.abilityTag = abilityTag;
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