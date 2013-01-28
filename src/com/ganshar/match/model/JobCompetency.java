package com.ganshar.match.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * TbJobCompetency entity. @author MyEclipse Persistence Tools
 */

public class JobCompetency implements java.io.Serializable {

	// Fields

	private Long id;
	private Long opportunityId;
	private Integer dimensionId;
	private Long measureId;
	private Integer measureValue;
	private Double ratio;


	// Constructors

	/** default constructor */
	public JobCompetency() {
	}

	/** minimal constructor */
	public JobCompetency(Long opportunityId, Integer dimensionId,
			Long measureId, Integer measureValue) {
		this.opportunityId = opportunityId;
		this.dimensionId = dimensionId;
		this.measureId = measureId;
		this.measureValue = measureValue;

	}

	/** full constructor */
	public JobCompetency(Long opportunityId, Integer dimensionId,
			Long measureId, Integer measureValue, Double ratio) {
		this.opportunityId = opportunityId;
		this.dimensionId = dimensionId;
		this.measureId = measureId;
		this.measureValue = measureValue;
		this.ratio = ratio;

	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOpportunityId() {
		return this.opportunityId;
	}

	public void setOpportunityId(Long opportunityId) {
		this.opportunityId = opportunityId;
	}

	public Integer getDimensionId() {
		return this.dimensionId;
	}

	public void setDimensionId(Integer dimensionId) {
		this.dimensionId = dimensionId;
	}

	public Long getMeasureId() {
		return this.measureId;
	}

	public void setMeasureId(Long measureId) {
		this.measureId = measureId;
	}

	public Integer getMeasureValue() {
		return this.measureValue;
	}

	public void setMeasureValue(Integer measureValue) {
		this.measureValue = measureValue;
	}

	public Double getRatio() {
		return this.ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}


}