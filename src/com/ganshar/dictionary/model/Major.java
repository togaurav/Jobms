package com.ganshar.dictionary.model;

import java.util.Date;

/**
 * TdMajor entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** full constructor */
	public Major(String name, Date addTime, Date updateTime) {
		this.name = name;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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