package com.ganshar.resume.model;

import java.util.Date;

/**
 * UserJobintent entity. @author MyEclipse Persistence Tools
 */

public class UserJobIntent implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private String industry;
	private String jobKeyword;
	private Integer jobSalary;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public UserJobIntent() {
	}

	/** minimal constructor */
	public UserJobIntent(Long userId, String jobKeyword,
			Integer jobSalary, Date addTime, Date updateTime) {
		this.userId = userId;
		this.jobKeyword = jobKeyword;
		this.jobSalary = jobSalary;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserJobIntent(Long userId, String industry, String jobKeyword,
			Integer jobSalary, Date addTime, Date updateTime) {
		this.userId = userId;
		this.industry = industry;
		this.jobKeyword = jobKeyword;
		this.jobSalary = jobSalary;
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

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getJobKeyword() {
		return this.jobKeyword;
	}

	public void setJobKeyword(String jobKeyword) {
		this.jobKeyword = jobKeyword;
	}

	public Integer getJobSalary() {
		return this.jobSalary;
	}

	public void setJobSalary(Integer jobSalary) {
		this.jobSalary = jobSalary;
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