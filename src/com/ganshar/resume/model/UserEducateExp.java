package com.ganshar.resume.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * UserEducateExp entity. @author MyEclipse Persistence Tools
 */

public class UserEducateExp implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private String schoolName;
	private Integer schoolId;
	private String majorName;
	private Integer majorId;
	private Integer education;
	private String degree;
	private Integer isLast;
	private Date beginDate;
	private Date endDate;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public UserEducateExp() {
	}

	/** minimal constructor */
	public UserEducateExp(Long id, Long userId, String schoolName,
			Integer schoolId, String majorName, Integer majorId, Integer education,
			Integer isLast, Date beginDate, Date endDate, Date addTime, Date updateTime) {
		this.id = id;
		this.userId = userId;
		this.schoolName = schoolName;
		this.schoolId = schoolId;
		this.majorName = majorName;
		this.majorId = majorId;
		this.isLast = isLast;
		this.beginDate=beginDate;
		this.endDate=endDate;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserEducateExp(Long id, Long userId, String schoolName,
			Integer schoolId, String majorName, Integer majorId,  Integer education,String degree,
			Integer isLast, Date beginDate, Date endDate, Date addTime, Date updateTime) {
		this.id = id;
		this.userId = userId;
		this.schoolName = schoolName;
		this.schoolId = schoolId;
		this.majorName = majorName;
		this.majorId = majorId;
		this.degree = degree;
		this.isLast = isLast;
		this.beginDate=beginDate;
		this.endDate=endDate;
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

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Integer getIsLast() {
		return this.isLast;
	}

	public void setIsLast(Integer isLast) {
		this.isLast = isLast;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}