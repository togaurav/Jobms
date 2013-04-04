package com.ganshar.job.model;

/**
 * TbMajorAbility entity. @author MyEclipse Persistence Tools
 */

public class MajorAbility implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer majorId;
	private Long abilityId;
	private Double abilityRatio;

	// Constructors

	/** default constructor */
	public MajorAbility() {
	}

	/** full constructor */
	public MajorAbility(Integer majorId, Long abilityId,
			Double abilityRatio) {
		this.majorId = majorId;
		this.abilityId = abilityId;
		this.abilityRatio = abilityRatio;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public Long getAbilityId() {
		return this.abilityId;
	}

	public void setAbilityId(Long abilityId) {
		this.abilityId = abilityId;
	}

	public Double getAbilityRatio() {
		return this.abilityRatio;
	}

	public void setAbilityRatio(Double abilityRatio) {
		this.abilityRatio = abilityRatio;
	}

}