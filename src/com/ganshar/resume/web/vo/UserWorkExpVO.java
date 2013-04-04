package com.ganshar.resume.web.vo;

import java.util.Date;

public class UserWorkExpVO {

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
	private String ondutyYear;
	private String ondutyMonth;
	private String leaveYear;
	private String leaveMonth;
	private Boolean nowdate;
	private Boolean lastJob;
	private String jobDesc;
	private String jobSkill;
	private Integer isLastJob;
	private Date addTime;
	private Date updateTime;
	private String companyName_widget;
	private String jobName_widget;
	private Integer[] industryId;

	// Constructors

	/** default constructor */
	public UserWorkExpVO() {
	}

	/** minimal constructor */
	public UserWorkExpVO(Long userId, Long jobId, String jobName,
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
	public UserWorkExpVO(Long userId, Long jobId, String jobName,
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
		return isLastJob;
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

	public String getOndutyYear() {
		return ondutyYear;
	}

	public void setOndutyYear(String ondutyYear) {
		this.ondutyYear = ondutyYear;
	}

	public String getOndutyMonth() {
		return ondutyMonth;
	}

	public void setOndutyMonth(String ondutyMonth) {
		this.ondutyMonth = ondutyMonth;
	}

	public String getLeaveYear() {
		return leaveYear;
	}

	public void setLeaveYear(String leaveYear) {
		this.leaveYear = leaveYear;
	}

	public String getLeaveMonth() {
		return leaveMonth;
	}

	public void setLeaveMonth(String leaveMonth) {
		this.leaveMonth = leaveMonth;
	}

	public Boolean getNowdate() {
		return nowdate;
	}

	public void setNowdate(Boolean nowdate) {
		this.nowdate = nowdate;
	}

	public Boolean getLastJob() {
		return lastJob;
	}

	public void setLastJob(Boolean lastJob) {
		this.lastJob = lastJob;
	}

	public String getCompanyName_widget() {
		return companyName_widget;
	}

	public void setCompanyName_widget(String companyName_widget) {
		this.companyName_widget = companyName_widget;
	}

	public String getJobName_widget() {
		return jobName_widget;
	}

	public void setJobName_widget(String jobName_widget) {
		this.jobName_widget = jobName_widget;
	}

	public Integer[] getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer[] industryId) {
		this.industryId = industryId;
	}

}