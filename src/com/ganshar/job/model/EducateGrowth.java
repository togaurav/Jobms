package com.ganshar.job.model;

/**
 * TbEducateGrowth entity. @author MyEclipse Persistence Tools
 */

public class EducateGrowth implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer type;
	private Integer growthValue;
	private Double growthRatio;

	// Constructors

	/** default constructor */
	public EducateGrowth() {
	}

	/** full constructor */
	public EducateGrowth(String name, Integer type, Integer growthValue,
			Double growthRatio) {
		this.name = name;
		this.type = type;
		this.growthValue = growthValue;
		this.growthRatio = growthRatio;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getGrowthValue() {
		return this.growthValue;
	}

	public void setGrowthValue(Integer growthValue) {
		this.growthValue = growthValue;
	}

	public Double getGrowthRatio() {
		return this.growthRatio;
	}

	public void setGrowthRatio(Double growthRatio) {
		this.growthRatio = growthRatio;
	}

}