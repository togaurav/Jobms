package com.ganshar.resume.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private Integer userAge;
	private String userGender;
	private Date userBirthday;
	private Integer userCity;
	private Double userServicelen;
	private Integer userRole;
	private String userEmail;
	private String userPhone;
	private String userDesc;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Long userId, String userName, String userGender,
			Date userBirthday, Integer userCity, Double userServicelen,
			Integer userRole, String userEmail, String userPhone,
			Date addTime, Date updateTime) {
		this.userId = userId;
		this.userName = userName;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.userCity = userCity;
		this.userServicelen = userServicelen;
		this.userRole = userRole;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserInfo(Long userId, String userName, Integer userAge,
			String userGender, Date userBirthday, Integer userCity,
			Double userServicelen, Integer userRole, String userEmail,
			String userPhone, String userDesc, Date addTime,
			Date updateTime) {
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.userCity = userCity;
		this.userServicelen = userServicelen;
		this.userRole = userRole;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userDesc = userDesc;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Integer getUserCity() {
		return this.userCity;
	}

	public void setUserCity(Integer userCity) {
		this.userCity = userCity;
	}

	public Double getUserServicelen() {
		return this.userServicelen;
	}

	public void setUserServicelen(Double userServicelen) {
		this.userServicelen = userServicelen;
	}

	public Integer getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
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