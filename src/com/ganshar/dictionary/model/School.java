package com.ganshar.dictionary.model;

import java.util.Date;

/**
 * TdSchool entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String level;
	private Double ratio;
	private Date addTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public School() {
	}

	/** full constructor */
	public School(String name, String level, Double ratio, Date addTime,
			Date updateTime) {
		this.name = name;
		this.level = level;
		this.ratio = ratio;
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

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Double getRatio() {
		return this.ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
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