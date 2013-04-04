package com.ganshar.job.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TbOpportunity entity. @author MyEclipse Persistence Tools
 */

public class Opportunity implements java.io.Serializable {

	// Fields

	private Long id;
	private Long stdJobId;
	private Integer funcRankId;
	private String jobName;
	private String jobDesc;
	private String jobQualification;
	private String jobCity;
	private Integer jobCityId;
	private String jobEducation;
	private Integer jobEducationId;
	private String jobLanguage;
	private String jobComputer;
	private String jobMajor;
	private Integer jobServicelength;
	private Integer jobSalary;
	private Integer jobNeedNumber;
	private String jobGender;
	private Integer jobAgeMin;
	private Integer jobAgeMax;
	private String jobBenefit;
	private Integer isCampusJob;
	private String companyName;
	private Long companyId;
	private String jobContact;
	private String jobEmail;
	private Date jobStartDate;
	private Date jobEndDate;
	private Integer isCancel;
	private String jobFromSite;
	private String jobFromUrl;
	private Date importTime;

	// Constructors

	/** default constructor */
	public Opportunity() {
	}

	/** minimal constructor */
	public Opportunity(String jobName) {
		this.jobName = jobName;
	}

	/** full constructor */
	public Opportunity(String jobName, String jobDesc,
			String jobQualification, String jobCity, Integer jobCityId,
			String jobEducation, Integer jobEducationId, String jobLanguage,
			String jobComputer, String jobMajor, Integer jobServicelength,
			Integer jobSalary, Integer jobNeedNumber, String jobGender,
			Integer jobAgeMin, Integer jobAgeMax, String jobBenefit,
			Integer isCampusJob, String companyName, Long companyId,
			String jobContact, String jobEmail, Date jobStartDate,
			Date jobEndDate, Integer isCancel, String jobFromSite,
			String jobFromUrl, Timestamp importTime) {
		this.jobName = jobName;
		this.jobDesc = jobDesc;
		this.jobQualification = jobQualification;
		this.jobCity = jobCity;
		this.jobCityId = jobCityId;
		this.jobEducation = jobEducation;
		this.jobEducationId = jobEducationId;
		this.jobLanguage = jobLanguage;
		this.jobComputer = jobComputer;
		this.jobMajor = jobMajor;
		this.jobServicelength = jobServicelength;
		this.jobSalary = jobSalary;
		this.jobNeedNumber = jobNeedNumber;
		this.jobGender = jobGender;
		this.jobAgeMin = jobAgeMin;
		this.jobAgeMax = jobAgeMax;
		this.jobBenefit = jobBenefit;
		this.isCampusJob = isCampusJob;
		this.companyName = companyName;
		this.companyId = companyId;
		this.jobContact = jobContact;
		this.jobEmail = jobEmail;
		this.jobStartDate = jobStartDate;
		this.jobEndDate = jobEndDate;
		this.isCancel = isCancel;
		this.jobFromSite = jobFromSite;
		this.jobFromUrl = jobFromUrl;
		this.importTime = importTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStdJobId() {
		return stdJobId;
	}

	public void setStdJobId(Long stdJobId) {
		this.stdJobId = stdJobId;
	}

	public Integer getFuncRankId() {
		return funcRankId;
	}

	public void setFuncRankId(Integer funcRankId) {
		this.funcRankId = funcRankId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobQualification() {
		return this.jobQualification;
	}

	public void setJobQualification(String jobQualification) {
		this.jobQualification = jobQualification;
	}

	public String getJobCity() {
		return this.jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public Integer getJobCityId() {
		return this.jobCityId;
	}

	public void setJobCityId(Integer jobCityId) {
		this.jobCityId = jobCityId;
	}

	public String getJobEducation() {
		return this.jobEducation;
	}

	public void setJobEducation(String jobEducation) {
		this.jobEducation = jobEducation;
	}

	public Integer getJobEducationId() {
		return this.jobEducationId;
	}

	public void setJobEducationId(Integer jobEducationId) {
		this.jobEducationId = jobEducationId;
	}

	public String getJobLanguage() {
		return this.jobLanguage;
	}

	public void setJobLanguage(String jobLanguage) {
		this.jobLanguage = jobLanguage;
	}

	public String getJobComputer() {
		return this.jobComputer;
	}

	public void setJobComputer(String jobComputer) {
		this.jobComputer = jobComputer;
	}

	public String getJobMajor() {
		return this.jobMajor;
	}

	public void setJobMajor(String jobMajor) {
		this.jobMajor = jobMajor;
	}

	public Integer getJobServicelength() {
		return this.jobServicelength;
	}

	public void setJobServicelength(Integer jobServicelength) {
		this.jobServicelength = jobServicelength;
	}

	public Integer getJobSalary() {
		return this.jobSalary;
	}

	public void setJobSalary(Integer jobSalary) {
		this.jobSalary = jobSalary;
	}

	public Integer getJobNeedNumber() {
		return this.jobNeedNumber;
	}

	public void setJobNeedNumber(Integer jobNeedNumber) {
		this.jobNeedNumber = jobNeedNumber;
	}

	public String getJobGender() {
		return this.jobGender;
	}

	public void setJobGender(String jobGender) {
		this.jobGender = jobGender;
	}

	public Integer getJobAgeMin() {
		return this.jobAgeMin;
	}

	public void setJobAgeMin(Integer jobAgeMin) {
		this.jobAgeMin = jobAgeMin;
	}

	public Integer getJobAgeMax() {
		return this.jobAgeMax;
	}

	public void setJobAgeMax(Integer jobAgeMax) {
		this.jobAgeMax = jobAgeMax;
	}

	public String getJobBenefit() {
		return this.jobBenefit;
	}

	public void setJobBenefit(String jobBenefit) {
		this.jobBenefit = jobBenefit;
	}

	public Integer getIsCampusJob() {
		return this.isCampusJob;
	}

	public void setIsCampusJob(Integer isCampusJob) {
		this.isCampusJob = isCampusJob;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getJobContact() {
		return this.jobContact;
	}

	public void setJobContact(String jobContact) {
		this.jobContact = jobContact;
	}

	public String getJobEmail() {
		return this.jobEmail;
	}

	public void setJobEmail(String jobEmail) {
		this.jobEmail = jobEmail;
	}

	public Date getJobStartDate() {
		return this.jobStartDate;
	}

	public void setJobStartDate(Date jobStartDate) {
		this.jobStartDate = jobStartDate;
	}

	public Date getJobEndDate() {
		return this.jobEndDate;
	}

	public void setJobEndDate(Date jobEndDate) {
		this.jobEndDate = jobEndDate;
	}

	public Integer getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(Integer isCancel) {
		this.isCancel = isCancel;
	}

	public String getJobFromSite() {
		return this.jobFromSite;
	}

	public void setJobFromSite(String jobFromSite) {
		this.jobFromSite = jobFromSite;
	}

	public String getJobFromUrl() {
		return this.jobFromUrl;
	}

	public void setJobFromUrl(String jobFromUrl) {
		this.jobFromUrl = jobFromUrl;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

}