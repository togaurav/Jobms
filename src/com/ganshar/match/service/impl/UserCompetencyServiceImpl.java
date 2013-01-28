package com.ganshar.match.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.Job;
import com.ganshar.job.model.JobAbility;
import com.ganshar.job.service.FuncRankGrowthService;
import com.ganshar.job.service.FuncRankService;
import com.ganshar.job.service.JobService;
import com.ganshar.match.dao.UserCompetencyDao;
import com.ganshar.match.model.UserCompetency;
import com.ganshar.match.service.UserCompetencyService;
import com.ganshar.match.web.vo.CompetencyChartVO;
import com.ganshar.resume.model.UserEducateExp;
import com.ganshar.resume.model.UserWorkExp;
import com.ganshar.resume.service.ResumeService;

public class UserCompetencyServiceImpl implements UserCompetencyService {

	private ResumeService resumeService;
	private FuncRankGrowthService funcRankGrowthService;
	private JobService jobService;
	private DictionaryService dicService;
	private FuncRankService  funcRankService;
	private UserCompetencyDao userCompetencyDao;
	private AbilityDao abilityDao;
	
	@Override
	public List<UserCompetency> findUserCompetencyListByUserId(Long userId) {
		List<UserCompetency> result=new ArrayList<UserCompetency>();
		
		UserEducateExp eduexp=this.resumeService.findUserTopEducateExpByUserId(userId);
		if( eduexp!=null){
			Double educationGrowValue=this.funcRankGrowthService.getGrowthValueByEducation(eduexp.getEducation());
			UserCompetency uc=new UserCompetency();
			uc.setDimensionId(UserCompetency.DIMENSION_EDUCATION);
			uc.setMeasureId(Long.valueOf(eduexp.getEducation()));
			uc.setMeasureValue(educationGrowValue.intValue());
			result.add(uc);
		}
		
		List<UserWorkExp>  workexpList=this.resumeService.findUserWorkExpListByUserId(userId);
		if(workexpList!=null&&workexpList.size()>0){
			for(UserWorkExp wexp:workexpList){
				Job job=this.jobService.getJobById(wexp.getJobId());
				if(job==null){
					job=this.jobService.findJobByName(wexp.getJobName());
				}
				if(job!=null){
					FuncRank funcRank=this.funcRankService.getFuncRankById(job.getFuncRankId());
					
					Double companyGrowValue=0.0;
					Double funcRankGrowValue=this.funcRankGrowthService.getGrowthValueByJob(job.getFuncRankId(), wexp.getServiceLen());
					
					Company company=this.dicService.getCompanyById(wexp.getCompanyId());
					if(company==null){
						company=this.dicService.findCompanyByName(wexp.getCompanyName());
					}
					if(company!=null){
						companyGrowValue=this.funcRankGrowthService.getGrowthValueByCompanyType(job.getFuncRankId(), company.getType());
					}
					
					Double measureValue=companyGrowValue>0?companyGrowValue*funcRankGrowValue:funcRankGrowValue;
					
					UserCompetency uc=new UserCompetency();
					uc.setDimensionId(UserCompetency.DIMENSION_FUNC_RANK);
					uc.setMeasureId(Long.valueOf(job.getFuncRankId()));
					uc.setMeasureValue(measureValue.intValue());
					result.add(uc);
					
					List<JobAbility> jobAbilityList=this.jobService.findJobAbilityList(job.getJobId());
					if(jobAbilityList!=null&&jobAbilityList.size()>0){
						for(JobAbility jobility:jobAbilityList){
						    Double abilityMeasureValue=funcRankGrowValue*jobility.getAbilityRatio();
							uc=new UserCompetency();
							uc.setDimensionId(UserCompetency.DIMENSION_ABILITY);
							uc.setMeasureId(jobility.getId());
							uc.setMeasureValue(abilityMeasureValue.intValue());
							result.add(uc);
						}
					}
					
					uc=new UserCompetency();
					Double industryMeasureValue=funcRankGrowValue;
					uc.setDimensionId(UserCompetency.DIMENSION_INDUSTRY);
					uc.setMeasureId(Long.valueOf(job.getIndustryId()));
					uc.setMeasureValue(industryMeasureValue.intValue());
					result.add(uc);
				}
				
			}
		}
		
		return result;
	}

	@Override
	public void addUserCompetencyList(List<UserCompetency> userCompetencyList) {
		this.userCompetencyDao.addUserCompetencyList(userCompetencyList);
	}
	
	public List<UserCompetency> aggregateUserCompetencyList(List<UserCompetency> userCompetencyList){
		 List<UserCompetency> result=new ArrayList<UserCompetency>();
		 
		 Map<String,UserCompetency>  competencyMap=new TreeMap<String,UserCompetency>();
		 if(userCompetencyList!=null&&userCompetencyList.size()>0){
			 for(UserCompetency uc:userCompetencyList){
				String key=uc.getDimensionId()+"-"+uc.getMeasureId();
				 if(!competencyMap.containsKey(key)){
					 competencyMap.put(key, uc);
				 }else{
					 UserCompetency ucom=competencyMap.get(key);
					 ucom.setMeasureValue(ucom.getMeasureValue()+uc.getMeasureValue());
					 competencyMap.put(key, ucom);
				 }
				 
			 }
		 }
		 
		 for(String key: competencyMap.keySet()){
			 if(key.split("-")[0].equals(""+UserCompetency.DIMENSION_EDUCATION)){
				 result.add( competencyMap.get(key));
			 }
		 }
		 for(String key: competencyMap.keySet()){
			 if(key.split("-")[0].equals(""+UserCompetency.DIMENSION_FUNC_RANK)){
				 result.add( competencyMap.get(key));
			 }
		 }
		 for(String key: competencyMap.keySet()){
			 if(key.split("-")[0].equals(""+UserCompetency.DIMENSION_ABILITY)){
				 result.add( competencyMap.get(key));
			 }
		 }
		 for(String key: competencyMap.keySet()){
			 if(key.split("-")[0].equals(""+UserCompetency.DIMENSION_INDUSTRY)){
				 result.add( competencyMap.get(key));
			 }
		 }
		 
		return result;
	}
	
	

	@Override
	public List<CompetencyChartVO> findUserCompetencyChartVOList(Long userId) {
		List<CompetencyChartVO> result=new ArrayList<CompetencyChartVO>();
		 List<UserCompetency> list=this.userCompetencyDao.findUserCompetencyListByUserId(userId);
		 if(list==null||(list!=null&&list.size()==0)){
				list=this.aggregateUserCompetencyList(this.findUserCompetencyListByUserId(userId));
		}
		if(list!=null&&list.size()>0){
			for(UserCompetency uc:list){
				String name="【未识别】"+uc.getMeasureId();
				String color="#4572a7";
				if(uc.getDimensionId()==UserCompetency.DIMENSION_ABILITY){
					Ability ability=this.abilityDao.getAbilityById(uc.getMeasureId());
					if(ability!=null){
						name="【知识技能】"+ability.getName();
						color="#aa4643";
					}
				}else if(uc.getDimensionId()==UserCompetency.DIMENSION_INDUSTRY){
					Industry industry=this.dicService.getIndustryById(uc.getMeasureId().intValue());
					if(industry!=null){
						name="【行业经验】"+industry.getName();
						color="#89a54e";
					}
				}else{
					FuncRank funcRank=this.funcRankService.getFuncRankById(uc.getMeasureId().intValue());
					if(funcRank!=null){
						name="【职能阶层】"+funcRank.getName();
					}
				}
				CompetencyChartVO chartvo=new CompetencyChartVO();
				chartvo.setName(name);
				chartvo.setValue(Double.valueOf(uc.getMeasureValue()));
				chartvo.setColor(color);
				result.add(chartvo);
			}
		}
		 
		return result;
	}

	public ResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public FuncRankGrowthService getFuncRankGrowthService() {
		return funcRankGrowthService;
	}

	public void setFuncRankGrowthService(FuncRankGrowthService funcRankGrowthService) {
		this.funcRankGrowthService = funcRankGrowthService;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
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

	public UserCompetencyDao getUserCompetencyDao() {
		return userCompetencyDao;
	}

	public void setUserCompetencyDao(UserCompetencyDao userCompetencyDao) {
		this.userCompetencyDao = userCompetencyDao;
	}

	public AbilityDao getAbilityDao() {
		return abilityDao;
	}

	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

	
}
