package com.ganshar.job.web.vo;

import java.util.Date;

public class JobVO  {

	// Fields

	private Long jobId;
	private String jobName;
	private String jobNameNew;
	private String level;
	private Integer funcRankId;
	private Integer industryId;
	private Double ratioFunction;
	private Double ratioAbility;
	private Double ratioIndustry;
	private String jobnameTag;
	private String abilityTag;
	private Date addTime;
	private Date updateTime;
	private String skill_1;
	private String skill_2;
	private String skill_3;
	private String skill_4;
	private String skill_5;
	private Double skillratio_1;
	private Double skillratio_2;
	private Double skillratio_3;
	private Double skillratio_4;
	private Double skillratio_5;	
	private String jobName_widget;
	private String skill_1_widget;
	private String skill_2_widget;
	private String skill_3_widget;
	private String skill_4_widget;
	private String skill_5_widget;
	private String companyName;
	private String companyName_widget;
	private Integer servicelen;

	// Constructors

	/** default constructor */
	public JobVO() {
	}

	/** minimal constructor */
	public JobVO(String jobName, String level, Integer funcRankId,
			Integer industryId, Double ratioFunction, Double ratioAbility,
			Double ratioIndustry, Date addTime, Date updateTime) {
		this.jobName = jobName;
		this.level = level;
		this.funcRankId = funcRankId;
		this.industryId = industryId;
		this.ratioFunction = ratioFunction;
		this.ratioAbility = ratioAbility;
		this.ratioIndustry = ratioIndustry;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public JobVO(String jobName, String level, Integer funcRankId,
			Integer industryId, Double ratioFunction, Double ratioAbility,
			Double ratioIndustry, String jobnameTag, String abilityTag,
			Date addTime, Date updateTime) {
		this.jobName = jobName;
		this.level = level;
		this.funcRankId = funcRankId;
		this.industryId = industryId;
		this.ratioFunction = ratioFunction;
		this.ratioAbility = ratioAbility;
		this.ratioIndustry = ratioIndustry;
		this.jobnameTag = jobnameTag;
		this.abilityTag = abilityTag;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Long getJobId() {
		return this.jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getFuncRankId() {
		return this.funcRankId;
	}

	public void setFuncRankId(Integer funcRankId) {
		this.funcRankId = funcRankId;
	}

	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Double getRatioFunction() {
		return this.ratioFunction;
	}

	public void setRatioFunction(Double ratioFunction) {
		this.ratioFunction = ratioFunction;
	}

	public Double getRatioAbility() {
		return this.ratioAbility;
	}

	public void setRatioAbility(Double ratioAbility) {
		this.ratioAbility = ratioAbility;
	}

	public Double getRatioIndustry() {
		return this.ratioIndustry;
	}

	public void setRatioIndustry(Double ratioIndustry) {
		this.ratioIndustry = ratioIndustry;
	}

	public String getJobnameTag() {
		return this.jobnameTag;
	}

	public void setJobnameTag(String jobnameTag) {
		this.jobnameTag = jobnameTag;
	}

	public String getAbilityTag() {
		return this.abilityTag;
	}

	public void setAbilityTag(String abilityTag) {
		this.abilityTag = abilityTag;
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


	public String getSkill_1() {
		return skill_1;
	}

	public void setSkill_1(String skill_1) {
		this.skill_1 = skill_1;
	}

	public String getSkill_2() {
		return skill_2;
	}

	public void setSkill_2(String skill_2) {
		this.skill_2 = skill_2;
	}

	public String getSkill_3() {
		return skill_3;
	}

	public void setSkill_3(String skill_3) {
		this.skill_3 = skill_3;
	}

	public String getSkill_4() {
		return skill_4;
	}

	public void setSkill_4(String skill_4) {
		this.skill_4 = skill_4;
	}

	public String getSkill_5() {
		return skill_5;
	}

	public void setSkill_5(String skill_5) {
		this.skill_5 = skill_5;
	}

	public String getSkill_2_widget() {
		return skill_2_widget;
	}

	public void setSkill_2_widget(String skill_2_widget) {
		this.skill_2_widget = skill_2_widget;
	}

	public String getSkill_3_widget() {
		return skill_3_widget;
	}

	public void setSkill_3_widget(String skill_3_widget) {
		this.skill_3_widget = skill_3_widget;
	}

	public String getSkill_4_widget() {
		return skill_4_widget;
	}

	public void setSkill_4_widget(String skill_4_widget) {
		this.skill_4_widget = skill_4_widget;
	}

	public String getSkill_5_widget() {
		return skill_5_widget;
	}

	public void setSkill_5_widget(String skill_5_widget) {
		this.skill_5_widget = skill_5_widget;
	}


	public Double getSkillratio_2() {
		return skillratio_2;
	}

	public void setSkillratio_2(Double skillratio_2) {
		this.skillratio_2 = skillratio_2;
	}

	public Double getSkillratio_3() {
		return skillratio_3;
	}

	public void setSkillratio_3(Double skillratio_3) {
		this.skillratio_3 = skillratio_3;
	}

	public Double getSkillratio_4() {
		return skillratio_4;
	}

	public void setSkillratio_4(Double skillratio_4) {
		this.skillratio_4 = skillratio_4;
	}

	public Double getSkillratio_5() {
		return skillratio_5;
	}

	public void setSkillratio_5(Double skillratio_5) {
		this.skillratio_5 = skillratio_5;
	}

	public String getJobName_widget() {
		return jobName_widget;
	}

	public void setJobName_widget(String jobName_widget) {
		this.jobName_widget = jobName_widget;
	}

	public String getSkill_1_widget() {
		return skill_1_widget;
	}

	public void setSkill_1_widget(String skill_1_widget) {
		this.skill_1_widget = skill_1_widget;
	}

	public Double getSkillratio_1() {
		return skillratio_1;
	}

	public void setSkillratio_1(Double skillratio_1) {
		this.skillratio_1 = skillratio_1;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName_widget() {
		return companyName_widget;
	}

	public void setCompanyName_widget(String companyName_widget) {
		this.companyName_widget = companyName_widget;
	}

	public Integer getServicelen() {
		return servicelen;
	}

	public void setServicelen(Integer servicelen) {
		this.servicelen = servicelen;
	}

	public String getJobNameNew() {
		return jobNameNew;
	}

	public void setJobNameNew(String jobNameNew) {
		this.jobNameNew = jobNameNew;
	}

}