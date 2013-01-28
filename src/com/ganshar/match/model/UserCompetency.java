package com.ganshar.match.model;

import java.sql.Timestamp;

/**
 * TbUserCompetency entity. @author MyEclipse Persistence Tools
 */

public class UserCompetency implements java.io.Serializable {
	
	public final static int DIMENSION_EDUCATION=1;
	public final static int DIMENSION_FUNC_RANK=2;
	public final static int DIMENSION_ABILITY=3;
	public final static int DIMENSION_INDUSTRY=4;
	
	// Fields

	private Long id;
	private Long userId;
	private Integer dimensionId;
	private Long measureId;
	private Integer measureValue;
	private Double ratio;

	// Constructors

	/** default constructor */
	public UserCompetency() {
	}

	/** minimal constructor */
	public UserCompetency(	Long userId, Integer dimensionId,
			Long measureId, Integer measureValue) {
		this.userId = userId;
		this.dimensionId = dimensionId;
		this.measureId = measureId;
		this.measureValue = measureValue;

	}

	/** full constructor */
	public UserCompetency(	Long userId, Integer dimensionId,
			Long measureId, Integer measureValue, Double ratio) {
		this.userId = userId;
		this.dimensionId = dimensionId;
		this.measureId = measureId;
		this.measureValue = measureValue;
		this.ratio = ratio;

	}

	// Property accessors

	public 	Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(	Long userId) {
		this.userId = userId;
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