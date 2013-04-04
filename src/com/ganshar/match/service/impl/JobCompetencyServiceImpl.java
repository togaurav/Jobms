package com.ganshar.match.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.dao.OpportunityDao;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankGrowth;
import com.ganshar.job.model.Job;
import com.ganshar.job.model.JobAbility;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.FuncRankService;
import com.ganshar.job.service.GrowthService;
import com.ganshar.job.service.JobService;
import com.ganshar.match.dao.JobCompetencyDao;
import com.ganshar.match.model.JobCompetency;
import com.ganshar.match.model.UserCompetency;
import com.ganshar.match.service.JobCompetencyService;
import com.ganshar.match.web.vo.CompetencyChartVO;

public class JobCompetencyServiceImpl implements JobCompetencyService {

	private JobCompetencyDao jobCompetencyDao;
	private AbilityDao abilityDao;
	private DictionaryService dicService;
	private FuncRankService  funcRankService;
	private OpportunityDao opportunityDao;
	private JobService jobService;
	private GrowthService growthService;
	
	@Override
	public List<JobCompetency> findJobCompetencyList(Long opportunityId) {
		List<JobCompetency> result=new ArrayList<JobCompetency>();
		Opportunity opp=this.opportunityDao.getOpportunityById(opportunityId);
		if(opp!=null){
			String companyName=opp.getCompanyName();
			String jobName=opp.getJobName();
			Integer funcRankId=opp.getFuncRankId();
			Company company=this.dicService.findCompanyByName(companyName);
			Job job=this.jobService.findJobByName(jobName);
			Double servicelenEnd=0.0;
			if(jobName.indexOf("高级")>0){
				servicelenEnd=6.0;
			}else if(jobName.indexOf("中级")>0){
				servicelenEnd=3.0;
			}else if(jobName.indexOf("资深")>0){
				servicelenEnd=6.0;
			}else if(jobName.indexOf("架构师")>0){
				servicelenEnd=8.0;
			}else if(jobName.indexOf("经理")>0){
				servicelenEnd=6.0;
			}else{
				servicelenEnd=2.0;
			}
			if(job!=null){
				Double companyRatio=1.0;
				Double funcRankGrowValue=0.0;
				 List<FuncRankGrowth> funcRankGrowthList=this.growthService.getFuncRankGrowthList(job.getFuncRankId());
				
				if(funcRankGrowthList!=null&&funcRankGrowthList.size()>0){
					for(FuncRankGrowth funcgrowth:funcRankGrowthList){
						if(funcgrowth.getServicelen()>0&&funcgrowth.getServicelen()<=servicelenEnd.intValue()){
							funcRankGrowValue+=funcgrowth.getGrowthValue();
						}
					}
				}
				
				if(company!=null){
					companyRatio=company.getRatio();
				}
				Double measureValue=companyRatio*funcRankGrowValue;
				
				JobCompetency jc=new JobCompetency();
				jc.setDimensionId(JobCompetency.DIMENSION_FUNC_RANK);
				jc.setMeasureId(Long.valueOf(job.getFuncRankId()));
				jc.setMeasureValue(measureValue.intValue());
				result.add(jc);
				
				List<JobAbility> jobAbilityList=this.jobService.findJobAbilityList(job.getJobId());
				if(jobAbilityList!=null&&jobAbilityList.size()>0){
					for(JobAbility jobility:jobAbilityList){
					    Double abilityMeasureValue=funcRankGrowValue*jobility.getAbilityRatio();
					    JobCompetency uca=new JobCompetency();
					    uca.setDimensionId(JobCompetency.DIMENSION_ABILITY);
					    uca.setMeasureId(jobility.getAbilityId());
					    uca.setMeasureValue(abilityMeasureValue.intValue());
					    uca.setRatio(jobility.getAbilityRatio());
						result.add(uca);
					}
				}
				
				JobCompetency uc=new JobCompetency();
				Double industryMeasureValue=funcRankGrowValue;
				uc.setDimensionId(JobCompetency.DIMENSION_INDUSTRY);
				uc.setMeasureId(Long.valueOf(company.getIndustryId()));
				uc.setMeasureValue(industryMeasureValue.intValue());
				result.add(uc);
			}
			
		}
		return result;
	}

	@Override
	public void addJobCompetencyList(List<JobCompetency> jobCompetencyList) {
		this.jobCompetencyDao.addJobCompetencyList(jobCompetencyList);
	}

	@Override
	public List<CompetencyChartVO> findCompetencyChartVOList(Long opportunityId) {
		List<CompetencyChartVO> result=new ArrayList<CompetencyChartVO>();
		 List<JobCompetency> list=this.jobCompetencyDao.findJobCompetencyList(opportunityId);
		 if(list==null||(list!=null&&list.size()==0)){
			 list=this.findJobCompetencyList(opportunityId);
		 }
		if(list!=null&&list.size()>0){
			for(JobCompetency uc:list){
				String name="【未识别】"+uc.getMeasureId();
				String color="#aa4643";
				if(uc.getDimensionId()==UserCompetency.DIMENSION_ABILITY){
					Ability ability=this.abilityDao.getAbilityById(uc.getMeasureId());
					if(ability!=null){
						name="【知识技能】"+ability.getName();
					}
				}else if(uc.getDimensionId()==UserCompetency.DIMENSION_INDUSTRY){
					Industry industry=this.dicService.getIndustryById(uc.getMeasureId().intValue());
					if(industry!=null){
						name="【行业经验】"+industry.getName();
					}
				}else  if(uc.getDimensionId()==UserCompetency.DIMENSION_FUNC_RANK){
					FuncRank funcRank=this.funcRankService.getFuncRankById(uc.getMeasureId().intValue());
					if(funcRank!=null){
						name="【职能阶层】"+funcRank.getName();
					}
				}
				CompetencyChartVO chartvo=new CompetencyChartVO();
				chartvo.setName(name);
				chartvo.setValue(new Double[]{uc.getMeasureValue().doubleValue()});
				chartvo.setColor(color);
				result.add(chartvo);
			}
		}
		return result;
	}

	public JobCompetencyDao getJobCompetencyDao() {
		return jobCompetencyDao;
	}

	public void setJobCompetencyDao(JobCompetencyDao jobCompetencyDao) {
		this.jobCompetencyDao = jobCompetencyDao;
	}

	public AbilityDao getAbilityDao() {
		return abilityDao;
	}

	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

	public DictionaryService getDicService() {
		return dicService;
	}

	public void setDicService(DictionaryService dicService) {
		this.dicService = dicService;
	}

	public FuncRankService getFuncRankService() {
		return funcRankService;
	}

	public void setFuncRankService(FuncRankService funcRankService) {
		this.funcRankService = funcRankService;
	}

	public OpportunityDao getOpportunityDao() {
		return opportunityDao;
	}

	public void setOpportunityDao(OpportunityDao opportunityDao) {
		this.opportunityDao = opportunityDao;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public GrowthService getGrowthService() {
		return growthService;
	}

	public void setGrowthService(GrowthService growthService) {
		this.growthService = growthService;
	}

}
