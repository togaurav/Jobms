package com.ganshar.dictionary.model;

import java.util.Date;

/**
 * TbCompany entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String staffnum;
	private Integer type;
	private String typeName;
	private String url;
	private String contact;
	private String phone;
	private String industry;
	private Integer industryId;
	private String cityName;
	private Integer cityId;
	private String companyDesc;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(String name, Date addTime, Date updateTime) {
		this.name = name;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public Company(String name, String staffnum, Integer type,  String typeName,String url,
			String contact, String phone, String industry, Integer industryId,
			String cityName, Integer cityId, String companyDesc,
			Date addTime, Date updateTime) {
		this.name = name;
		this.staffnum = staffnum;
		this.type = type;
		this.typeName=typeName;
		this.url = url;
		this.contact = contact;
		this.phone = phone;
		this.industry = industry;
		this.industryId = industryId;
		this.cityName = cityName;
		this.cityId = cityId;
		this.companyDesc = companyDesc;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setStaffnum(String staffnum) {
		this.staffnum = staffnum;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCompanyDesc() {
		return this.companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
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

	public String getStaffnum() {
		return staffnum;
	}

}