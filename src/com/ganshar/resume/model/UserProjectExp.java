package com.ganshar.resume.model;

import java.util.Date;

/**
 * UserProjectExp entity. @author MyEclipse Persistence Tools
 */

public class UserProjectExp implements java.io.Serializable {

	// Fields

	private Long id;
	private Long userId;
	private String projectName;
	private String projectDesc;
	private Integer projectNumber;
	private String projectRole;
	private String projectSkill;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public UserProjectExp() {
	}

	/** minimal constructor */
	public UserProjectExp(Long userId, String projectName,
			String projectDesc, Integer projectNumber, String projectRole,
			Date addTime, Date updateTime) {
		this.userId = userId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.projectNumber = projectNumber;
		this.projectRole = projectRole;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public UserProjectExp(Long userId, String projectName,
			String projectDesc, Integer projectNumber, String projectRole,
			String projectSkill, Date addTime, Date updateTime) {
		this.userId = userId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.projectNumber = projectNumber;
		this.projectRole = projectRole;
		this.projectSkill = projectSkill;
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

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public Integer getProjectNumber() {
		return this.projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectRole() {
		return this.projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getProjectSkill() {
		return this.projectSkill;
	}

	public void setProjectSkill(String projectSkill) {
		this.projectSkill = projectSkill;
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