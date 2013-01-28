package com.ganshar.resume.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * UserWorkExp entity. @author MyEclipse Persistence Tools
 */

public class UserWorkExp implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private Long jobId;
	private String jobName;
	private Integer jobType;
	private Long companyId;
	private String companyName;
	private Double serviceLen;
	private Integer jobSalary;
	private Integer jobCity;
	private Date ondutyDate;
	private Date leaveDate;
	private String jobDesc;
	private String jobSkill;
	private Integer isLastJob;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public UserWorkExp() {
	}

	/** minimal constructor */
	public UserWorkExp(Long userId, Long jobId, String jobName,
			Integer jobType, Long companyId, String companyName,
			Double serviceLen, Integer jobCity, Date ondutyDate,
			Date leaveDate, Integer isLastJob, Date addTime,
			Date updateTime) {
		this.userId = userId;
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobType = jobType;
		this.companyId = companyId;
		this.companyName = companyName;
		this.serviceLen = serviceLen;
		this.jobCity = jobCity;
		this.ondutyDate = ondutyDate;
		this.leaveDate = leaveDate;
		this.isLastJob = isLastJob;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserWorkExp(Long userId, Long jobId, String jobName,
			Integer jobType, Long companyId, String companyName,
			Double serviceLen, Integer jobSalary, Integer jobCity,
			Date ondutyDate, Date leaveDate, String jobDesc, String jobSkill,
			Integer isLastJob, Date addTime, Date updateTime) {
		this.userId = userId;
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobType = jobType;
		this.companyId = companyId;
		this.companyName = companyName;
		this.serviceLen = serviceLen;
		this.jobSalary = jobSalary;
		this.jobCity = jobCity;
		this.ondutyDate = ondutyDate;
		this.leaveDate = leaveDate;
		this.jobDesc = jobDesc;
		this.jobSkill = jobSkill;
		this.isLastJob = isLastJob;
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

	public Integer getJobType() {
		return this.jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getServiceLen() {
		return this.serviceLen;
	}

	public void setServiceLen(Double serviceLen) {
		this.serviceLen = serviceLen;
	}

	public Integer getJobSalary() {
		return this.jobSalary;
	}

	public void setJobSalary(Integer jobSalary) {
		this.jobSalary = jobSalary;
	}

	public Integer getJobCity() {
		return this.jobCity;
	}

	public void setJobCity(Integer jobCity) {
		this.jobCity = jobCity;
	}

	public Date getOndutyDate() {
		return this.ondutyDate;
	}

	public void setOndutyDate(Date ondutyDate) {
		this.ondutyDate = ondutyDate;
	}

	public Date getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobSkill() {
		return this.jobSkill;
	}

	public void setJobSkill(String jobSkill) {
		this.jobSkill = jobSkill;
	}

	public Integer getIsLastJob() {
		return this.isLastJob;
	}

	public void setIsLastJob(Integer isLastJob) {
		this.isLastJob = isLastJob;
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