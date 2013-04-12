package com.ganshar.match.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.framework.util.MathFormatUtil;
import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.ability.service.AbilityService;
import com.ganshar.dictionary.dao.DictionaryDao;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;
import com.ganshar.job.model.EducateGrowth;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankGrowth;
import com.ganshar.job.model.Job;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.FuncRankService;
import com.ganshar.job.service.GrowthService;
import com.ganshar.job.service.JobService;
import com.ganshar.job.web.vo.JobVO;
import com.ganshar.match.model.JobCompetency;
import com.ganshar.match.model.UserCompetency;
import com.ganshar.match.service.JobCompetencyService;
import com.ganshar.match.service.MatchService;
import com.ganshar.match.service.UserCompetencyService;
import com.ganshar.resume.model.Resume;
import com.ganshar.resume.web.vo.UserEducateExpVO;
import com.ganshar.resume.web.vo.UserWorkExpVO;

public class MatchServiceImpl implements MatchService {
	
	private UserCompetencyService userCompetencyService;
	private JobCompetencyService jobCompetencyService;
	private FuncRankService  funcRankService;
	private AbilityService abilityService;
	private GrowthService growthService;
	private AbilityDao abilityDao;
	private JobService jobService;
	private DictionaryDao dicDao;

	@Override
	public Double match(Resume resume, Opportunity opp) {
		Double result=0.0;
		List<UserCompetency> userCpList=new ArrayList<UserCompetency>();
		List<JobCompetency>  jobCpList=new ArrayList<JobCompetency>();
		
		if(resume!=null){
			userCpList=this.loadUserCompetencys(resume.getUserId());
		}
		if(opp!=null){
			jobCpList=this.loadJobCompetencys(opp.getId());
		}
		
		Double funcRankMatch=this.matchFuncRank(userCpList, jobCpList);
		Double abilityMatch=this.matchAbility(userCpList, jobCpList);
		Double industryMatch=this.matchIndustry(userCpList, jobCpList);
		
		FuncRank funcRank=this.funcRankService.getFuncRankById(opp.getFuncRankId());
		if(funcRank!=null){
			result=funcRank.getRatioFunction()*funcRankMatch+funcRank.getRatioAbility()*abilityMatch+funcRank.getRatioIndustry()*industryMatch;
		}
		
		return MathFormatUtil.round(result);
	}
	
	@Override
	public Map<String, Double> matchmap(Resume resume, Opportunity opp) {
		List<UserCompetency> userCpList=new ArrayList<UserCompetency>();
		List<JobCompetency>  jobCpList=new ArrayList<JobCompetency>();
		
		if(resume!=null){
			userCpList=this.loadUserCompetencys(resume.getUserId());
		}
		if(opp!=null){
			jobCpList=this.loadJobCompetencys(opp.getId());
		}
		
		Double funcRankMatch=this.matchFuncRank(userCpList, jobCpList);
		Double abilityMatch=this.matchAbility(userCpList, jobCpList);
		Double industryMatch=this.matchIndustry(userCpList, jobCpList);
		
		Map<String, Double> result=new HashMap<String, Double>();
		result.put("职能阶层", MathFormatUtil.round(funcRankMatch));
		result.put("知识技能", MathFormatUtil.round(abilityMatch));
		result.put("行业经验", MathFormatUtil.round(industryMatch));
		return result;
	}

	@Override
	public Map<Long, Double> matchAll(Resume resume, List<Opportunity> opps) {
		Map<Long, Double> result=new HashMap<Long, Double>();
		for(Opportunity opp:opps){
			Double match=this.match(resume, opp);
			result.put(opp.getId(), match);
		}
		return result;
	}

	public Double matchFuncRank( List<UserCompetency> userCpList,List<JobCompetency> jobCpList){
		Double result=0.0;
		Integer userGrowthValue=0;
		Integer jobGrowthValue=0;
		for(UserCompetency ucp:userCpList){
				if(ucp.getDimensionId()==UserCompetency.DIMENSION_EDUCATION||ucp.getDimensionId()==UserCompetency.DIMENSION_FUNC_RANK){
					userGrowthValue+=ucp.getMeasureValue();
				}
		}
		for(JobCompetency jcp:jobCpList){
				if(jcp.getDimensionId()==JobCompetency.DIMENSION_EDUCATION||jcp.getDimensionId()==JobCompetency.DIMENSION_FUNC_RANK){
					jobGrowthValue+=jcp.getMeasureValue();
				}
		}
		result=(userGrowthValue.doubleValue()/jobGrowthValue.doubleValue());
		if(result>1){
			result=1-(result-1)*0.4;
		}
		
		return result;
	}
	
	public Double matchAbility( List<UserCompetency> userCpList,List<JobCompetency> jobCpList){
		Double result=0.0;
		Map<String,Integer> userAbilityMap=new HashMap<String,Integer>();
		Map<String,JobCompetency> jobAbilityMap=new HashMap<String,JobCompetency>();
		for(UserCompetency ucp:userCpList){
				if(ucp.getDimensionId()==UserCompetency.DIMENSION_ABILITY){
					Ability ability=this.abilityService.getAbilityById(ucp.getMeasureId());
					userAbilityMap.put(ability.getPath(),ucp.getMeasureValue());
				}
		}
		for(JobCompetency jcp:jobCpList){
				if(jcp.getDimensionId()==JobCompetency.DIMENSION_ABILITY){
					Ability ability=this.abilityService.getAbilityById(jcp.getMeasureId());
					jobAbilityMap.put(ability.getPath(),jcp);
				}
		}
		for(String job:jobAbilityMap.keySet()){
			Double value1=0.0;
			for(String user:userAbilityMap.keySet()){
				if(job.equals(user)){
					value1+=userAbilityMap.get(user);
				}else{
					if(user.substring(0,6).equals(job.substring(0,6))){
						value1+=0.7*0.3*userAbilityMap.get(user);
					}else if(user.substring(0,4).equals(job.substring(0,4))){
						if(user.substring(4,8).equals("0000")&&job.substring(4,8).equals("0000")){
							value1+=0;
						}else if(user.substring(4,8).equals("0000")&&!job.substring(4,8).equals("0000")){
							if(job.substring(6,8).equals("00")){
								value1+=0.3*userAbilityMap.get(user);
							}else{
								value1+=0.3*0.3*userAbilityMap.get(user);
							}
						}else if(!user.substring(4,8).equals("0000")&&job.substring(4,8).equals("0000")){
							if(user.substring(6,8).equals("00")){
								value1+=0.7*userAbilityMap.get(user);
							}else{
								value1+=0.7*0.7*userAbilityMap.get(user);
							}
						}else if(!user.substring(4,8).equals("0000")&&!job.substring(4,8).equals("0000")){
							if(user.substring(6,8).equals("00")){
								if(job.substring(6,8).equals("00")){
									value1+=0.7*0.3*userAbilityMap.get(user);
								}else{
									value1+=0.7*0.3*0.3*userAbilityMap.get(user);
								}
							}else{
								if(job.substring(6,8).equals("00")){
									value1+=0.7*0.7*0.3*userAbilityMap.get(user);
								}else{
									value1+=0.7*0.7*0.3*0.3*userAbilityMap.get(user);
								}
							}
						}
					}
				}
			}
			Double tmpvalue=value1/jobAbilityMap.get(job).getMeasureValue();
			if(tmpvalue>1){
				tmpvalue=1-(tmpvalue-1)*0.4;
			}
			result+=tmpvalue*jobAbilityMap.get(job).getRatio();
		}
		
		return result;
	}
	
	public Double matchIndustry( List<UserCompetency> userCpList,List<JobCompetency> jobCpList){
		Double result=0.0;
		Integer userGrowthValue=0;
		Integer jobGrowthValue=0;
		for(UserCompetency ucp:userCpList){
				if(ucp.getDimensionId()==UserCompetency.DIMENSION_INDUSTRY){
					userGrowthValue+=ucp.getMeasureValue();
				}
		}
		for(JobCompetency jcp:jobCpList){
				if(jcp.getDimensionId()==JobCompetency.DIMENSION_INDUSTRY){
					jobGrowthValue+=jcp.getMeasureValue();
				}
		}
		result=(userGrowthValue.doubleValue()/jobGrowthValue.doubleValue());
		if(result>1){
			result=1-(result-1)*0.4;
		}
		return result;
	}
	
	@Override
	public List<Map<String, String>> analyseResume(
			UserEducateExpVO eduvo, List<UserWorkExpVO> workvos) {
		List<Map<String, String>> result=new LinkedList<Map<String, String>>();
		Map<String,String> funcRankMap=new TreeMap<String,String>();
		Map<String,String> abilityMap=new TreeMap<String,String>();
		Map<String,String> industryMap=new TreeMap<String,String>();
		Map<String,Double> funcRankAggMap=new HashMap<String,Double>();
		Map<String,Double> abilityAggMap=new HashMap<String,Double>();
		Map<String,Double> industryAggMap=new HashMap<String,Double>();
		
		//教育背景分析
		Double edugrowth=0.0;
		Double schoolratio=0.0;
		EducateGrowth educateGrowth=this.growthService.getEducateGrowthByEducation(eduvo.getEducation());
		if(educateGrowth!=null){
				edugrowth=educateGrowth.getGrowthValue().doubleValue();
				School school=this.dicDao.findSchoolByName(eduvo.getSchoolName().trim());
				if(school!=null)
					schoolratio=school.getRatio();
				
				funcRankMap.put(educateGrowth.getName()+"：",  edugrowth+"*"+schoolratio+"="+edugrowth*schoolratio);
				edugrowth=edugrowth*schoolratio;
				
				Major major=this.dicDao.findMajorByName(eduvo.getMajorName().trim());
				
				List abilitylist=this.jobService.findMajorAbilityMapList(major.getId());
				if(abilitylist!=null&&abilitylist.size()>0){
					for(Object tmp:abilitylist){
						Object[] objs=(Object[])tmp;
						String abilityname=(String)objs[0];
						Double abilityratio=(Double)objs[1];
						Double abilityMeasureValue=edugrowth*abilityratio;
						abilityMap.put(major.getName()+"-"+abilityname+"：", edugrowth+"*"+abilityratio+"="+abilityMeasureValue);
						abilityAggMap.put(abilityname, abilityMeasureValue);
					}
				}
		}
		
		//工作经历分析
		if(workvos!=null&&workvos.size()>0){
			UserWorkExpVO tmpvo=workvos.get(0);
			Date minDutyDate=tmpvo.getOndutyDate();
			for(UserWorkExpVO workvo:workvos){
				if(minDutyDate.after(workvo.getOndutyDate())){
					minDutyDate=workvo.getOndutyDate();
				}
			}
			
			for(UserWorkExpVO workvo:workvos){
				Job job=this.jobService.findJobByName(workvo.getJobName().trim());
				Double servicelenStart=MathFormatUtil.round((workvo.getOndutyDate().getTime()-minDutyDate.getTime())/(1000.0*60.0*60.0*24.0)/365.0);
				Double servicelenEnd=MathFormatUtil.round((workvo.getLeaveDate().getTime()-minDutyDate.getTime())/(1000.0*60.0*60.0*24.0)/365.0);
				
				if(job!=null){
					Double companyRatio=1.0;
					Double funcRankGrowValue=0.0;
					 List<FuncRankGrowth> funcRankGrowthList=this.growthService.getFuncRankGrowthList(job.getFuncRankId());
					
					if(funcRankGrowthList!=null&&funcRankGrowthList.size()>0){
						for(FuncRankGrowth funcgrowth:funcRankGrowthList){
							if(funcgrowth.getServicelen()>0&&funcgrowth.getServicelen()>=servicelenStart.intValue()&&funcgrowth.getServicelen()<=servicelenEnd.intValue()){
								funcRankGrowValue+=funcgrowth.getGrowthValue();
							}
						}
					}
					
					Company company=this.dicDao.findCompanyByName(workvo.getCompanyName().trim());
					if(company!=null){
						companyRatio=company.getRatio();
					}
					
					Double measureValue=companyRatio*funcRankGrowValue;					
					FuncRank funcRank=this.funcRankService.getFuncRankById(job.getFuncRankId());
					if(funcRank==null) return result;
					funcRankMap.put(company.getName()+"-"+funcRank.getName()+"：", "从第"+servicelenStart+"年到"+servicelenEnd+"年累计"+funcRankGrowValue+"*"+companyRatio+"="+measureValue);
					
					if(funcRankAggMap.containsKey(funcRank.getName())){
						Double value=funcRankAggMap.get(funcRank.getName());
						funcRankAggMap.put(funcRank.getName(), value+measureValue);
					}else{
						funcRankAggMap.put(funcRank.getName(), measureValue);
					}
					
					List  jobAbilityList=this.jobService.findJobAbilityMapList(job.getJobId());
					if(jobAbilityList!=null&&jobAbilityList.size()>0){
						for(Object tmp:jobAbilityList){
							Object[] objs=(Object[])tmp;
							String abilityname=(String)objs[0];
							Double abilityratio=(Double)objs[1];
						    Double abilityMeasureValue=funcRankGrowValue*abilityratio;
						    abilityMap.put(company.getName()+"-"+job.getJobName()+"-"+abilityname+"：", funcRankGrowValue+"*"+abilityratio+"="+abilityMeasureValue);
						    
						    if(abilityAggMap.containsKey(abilityname)){
								Double value=abilityAggMap.get(abilityname);
								abilityAggMap.put(abilityname, value+abilityMeasureValue);
							}else{
								abilityAggMap.put(abilityname, abilityMeasureValue);
							}
						    
						}
					}
					
					Double industryMeasureValue=funcRankGrowValue;
					Industry industry=this.dicDao.getIndustryById(workvo.getIndustryId()[0]);
					if(industry!=null){
						industryMap.put(company.getName()+"-"+industry.getName()+"：", industryMeasureValue+"");
						 if(industryAggMap.containsKey(industry.getName())){
								Double value=industryAggMap.get(industry.getName());
								industryAggMap.put(industry.getName(), value+industryMeasureValue);
							}else{
								industryAggMap.put(industry.getName(), industryMeasureValue);
							}
					}
				}
			}
		}
		
		result.add(funcRankMap);
		result.add(this.convertMap(funcRankAggMap));
		result.add(abilityMap);
		result.add(this.convertMap(abilityAggMap));
		result.add(industryMap);
		result.add(this.convertMap(industryAggMap));
		
		return result;
	}
	
	private Map<String,String> convertMap(Map<String,Double> map){
		Map<String,String> result=new TreeMap<String,String>();
		if(map!=null){
			for(String key:map.keySet()){
				result.put(key, ""+map.get(key));
			}
		}
		return result;
	}


	@Override
	public List<Map<String, String>> analyseJob(JobVO jobvo) {
		List<Map<String, String>> result=new LinkedList<Map<String, String>>();
		Map<String,String> funcRankMap=new TreeMap<String,String>();
		Map<String,String> abilityMap=new TreeMap<String,String>();
		Map<String,String> industryMap=new TreeMap<String,String>();
		
		Job job=this.jobService.findJobByName(jobvo.getJobName().trim());
		Double servicelenStart=0.0;
		Double servicelenEnd=jobvo.getServicelen().doubleValue();
		
		if(job!=null){
			Double companyRatio=1.0;
			Double funcRankGrowValue=0.0;
			 List<FuncRankGrowth> funcRankGrowthList=this.growthService.getFuncRankGrowthList(job.getFuncRankId());
			
			if(funcRankGrowthList!=null&&funcRankGrowthList.size()>0){
				for(FuncRankGrowth funcgrowth:funcRankGrowthList){
					if(funcgrowth.getServicelen()>0&&funcgrowth.getServicelen()>=servicelenStart.intValue()&&funcgrowth.getServicelen()<=servicelenEnd.intValue()){
						funcRankGrowValue+=funcgrowth.getGrowthValue();
					}
				}
			}
			
			Company company=this.dicDao.findCompanyByName(jobvo.getCompanyName().trim());
			if(company!=null){
				companyRatio=company.getRatio();
			}
			
			Double measureValue=companyRatio*funcRankGrowValue;					
			FuncRank funcRank=this.funcRankService.getFuncRankById(job.getFuncRankId());
			if(funcRank==null) return result;
			funcRankMap.put(company.getName()+"-"+funcRank.getName()+"：", servicelenEnd+"年累计"+funcRankGrowValue+"*"+companyRatio+"="+measureValue);
			
			List  jobAbilityList=this.jobService.findJobAbilityMapList(job.getJobId());
			if(jobAbilityList!=null&&jobAbilityList.size()>0){
				for(Object tmp:jobAbilityList){
					Object[] objs=(Object[])tmp;
					String abilityname=(String)objs[0];
					Double abilityratio=(Double)objs[1];
				    Double abilityMeasureValue=funcRankGrowValue*abilityratio;
				    abilityMap.put(company.getName()+"-"+job.getJobName()+"-"+abilityname+"：", funcRankGrowValue+"*"+abilityratio+"="+abilityMeasureValue);				    
				}
			}
			
			Double industryMeasureValue=funcRankGrowValue;
			Industry industry=this.dicDao.getIndustryById(jobvo.getIndustryId());
			if(industry!=null){
				industryMap.put(company.getName()+"-"+industry.getName()+"：", industryMeasureValue+"");
			}
		}
		result.add(funcRankMap);
		result.add(abilityMap);
		result.add(industryMap);
		return result;
	}

	@Override
	public List<Map<String, String>> analyseMatch(UserEducateExpVO eduvo,
			List<UserWorkExpVO> workvos, JobVO jobvo) {
		List<Map<String, String>> result=new LinkedList<Map<String, String>>();
		Map<String,String> funcRankMap=new TreeMap<String,String>();
		Map<String,String> abilityMap=new TreeMap<String,String>();
		Map<String,String> industryMap=new TreeMap<String,String>();
		Map<String,String> matchMap=new TreeMap<String,String>();
		Map<Object,Double> userFuncRankMap=new HashMap<Object,Double>();
		Map<String,Double> userAbilityMap=new HashMap<String,Double>();
		Map<Object,Double> userIndustryMap=new HashMap<Object,Double>();
		Map<Object,Double> jobFuncRankMap=new HashMap<Object,Double>();
		Map<String,Map<String,Double>> jobAbilityMap=new HashMap<String,Map<String,Double>>();
		Map<Object,Double> jobIndustryMap=new HashMap<Object,Double>();
		
				//教育背景经验计算
				Double edugrowth=0.0;
				Double schoolratio=0.0;
				EducateGrowth educateGrowth=this.growthService.getEducateGrowthByEducation(eduvo.getEducation());
				if(educateGrowth!=null){
						edugrowth=educateGrowth.getGrowthValue().doubleValue();
						School school=this.dicDao.findSchoolByName(eduvo.getSchoolName().trim());
						if(school!=null)
							schoolratio=school.getRatio();						
						edugrowth=edugrowth*schoolratio;
						userFuncRankMap.put(eduvo.getEducation(), edugrowth);
						Major major=this.dicDao.findMajorByName(eduvo.getMajorName().trim());				
						List abilitylist=this.jobService.findMajorAbilityMapList(major.getId());
						if(abilitylist!=null&&abilitylist.size()>0){
							for(Object tmp:abilitylist){
								Object[] objs=(Object[])tmp;
								String abilityname=(String)objs[0];
								Double abilityratio=(Double)objs[1];
								String abilitypath=(String)objs[2];
								Double abilityMeasureValue=edugrowth*abilityratio;
								userAbilityMap.put(abilitypath, abilityMeasureValue);
							}
						}
				}
				
				//工作经历经验计算
				if(workvos!=null&&workvos.size()>0){
					UserWorkExpVO tmpvo=workvos.get(0);
					Date minDutyDate=tmpvo.getOndutyDate();
					for(UserWorkExpVO workvo:workvos){
						if(minDutyDate.after(workvo.getOndutyDate())){
							minDutyDate=workvo.getOndutyDate();
						}
					}
					
					for(UserWorkExpVO workvo:workvos){
						Job job=this.jobService.findJobByName(workvo.getJobName().trim());
						Double servicelenStart=MathFormatUtil.round((workvo.getOndutyDate().getTime()-minDutyDate.getTime())/(1000.0*60.0*60.0*24.0)/365.0);
						Double servicelenEnd=MathFormatUtil.round((workvo.getLeaveDate().getTime()-minDutyDate.getTime())/(1000.0*60.0*60.0*24.0)/365.0);
						
						if(job!=null){
							Double companyRatio=1.0;
							Double funcRankGrowValue=0.0;
							 List<FuncRankGrowth> funcRankGrowthList=this.growthService.getFuncRankGrowthList(job.getFuncRankId());
							
							if(funcRankGrowthList!=null&&funcRankGrowthList.size()>0){
								for(FuncRankGrowth funcgrowth:funcRankGrowthList){
									if(funcgrowth.getServicelen()>0&&funcgrowth.getServicelen()>=servicelenStart.intValue()&&funcgrowth.getServicelen()<=servicelenEnd.intValue()){
										funcRankGrowValue+=funcgrowth.getGrowthValue();
									}
								}
							}
							
							Company company=this.dicDao.findCompanyByName(workvo.getCompanyName().trim());
							if(company!=null){
								companyRatio=company.getRatio();
							}
							
							Double measureValue=companyRatio*funcRankGrowValue;					
							FuncRank funcRank=this.funcRankService.getFuncRankById(job.getFuncRankId());
							if(funcRank==null) return result;
							
							if(userFuncRankMap.containsKey(funcRank.getId())){
								Double value=userFuncRankMap.get(funcRank.getId());
								userFuncRankMap.put(funcRank.getId(), value+measureValue);
							}else{
								userFuncRankMap.put(funcRank.getId(), measureValue);
							}
							
							List  jobAbilityList=this.jobService.findJobAbilityMapList(job.getJobId());
							if(jobAbilityList!=null&&jobAbilityList.size()>0){
								for(Object tmp:jobAbilityList){
									Object[] objs=(Object[])tmp;
									String abilityname=(String)objs[0];
									Double abilityratio=(Double)objs[1];
									String abilitypath=(String)objs[2];
								    Double abilityMeasureValue=funcRankGrowValue*abilityratio;
								    if(userAbilityMap.containsKey(abilitypath)){
										Double value=userAbilityMap.get(abilitypath);
										userAbilityMap.put(abilitypath, value+abilityMeasureValue);
									}else{
										userAbilityMap.put(abilitypath, abilityMeasureValue);
									}
								    
								}
							}
							
							Double industryMeasureValue=funcRankGrowValue;
							Industry industry=this.dicDao.getIndustryById(workvo.getIndustryId()[0]);
							if(industry!=null){
								if(userIndustryMap.containsKey(industry.getId())){
									Double value=userIndustryMap.get(industry.getId());
									userIndustryMap.put(industry.getId(), value+industryMeasureValue);
								}else{
									userIndustryMap.put(industry.getId(), industryMeasureValue);
								}
							}
						}
					}
				}	
			
				//工作机会经验计算
				Job job=this.jobService.findJobByName(jobvo.getJobName().trim());
				Double servicelenStart=0.0;
				Double servicelenEnd=jobvo.getServicelen().doubleValue();
				
				if(job!=null){
					Double companyRatio=1.0;
					Double funcRankGrowValue=0.0;
					 List<FuncRankGrowth> funcRankGrowthList=this.growthService.getFuncRankGrowthList(job.getFuncRankId());
					
					if(funcRankGrowthList!=null&&funcRankGrowthList.size()>0){
						for(FuncRankGrowth funcgrowth:funcRankGrowthList){
							if(funcgrowth.getServicelen()>0&&funcgrowth.getServicelen()>=servicelenStart.intValue()&&funcgrowth.getServicelen()<=servicelenEnd.intValue()){
								funcRankGrowValue+=funcgrowth.getGrowthValue();
							}
						}
					}
					
					Company company=this.dicDao.findCompanyByName(jobvo.getCompanyName().trim());
					if(company!=null){
						companyRatio=company.getRatio();
					}
					
					Double measureValue=companyRatio*funcRankGrowValue;					
					FuncRank funcRank=this.funcRankService.getFuncRankById(job.getFuncRankId());
					if(funcRank==null) return result;
					if(jobFuncRankMap.containsKey(funcRank.getId())){
						Double value=jobFuncRankMap.get(funcRank.getId());
						jobFuncRankMap.put(funcRank.getId(), value+measureValue);
					}else{
						jobFuncRankMap.put(funcRank.getId(), measureValue);
					}
					
					List  jobAbilityList=this.jobService.findJobAbilityMapList(job.getJobId());
					if(jobAbilityList!=null&&jobAbilityList.size()>0){
						for(Object tmp:jobAbilityList){
							Object[] objs=(Object[])tmp;
							String abilityname=(String)objs[0];
							Double abilityratio=(Double)objs[1];
							String abilitypath=(String)objs[2];
						    Double abilityMeasureValue=funcRankGrowValue*abilityratio;
						    Map<String,Double> tmpmap=new HashMap<String,Double>();
						    tmpmap.put("value", abilityMeasureValue	);
						    tmpmap.put("ratio", abilityratio);
							jobAbilityMap.put(abilitypath+";"+abilityname, tmpmap);
						}
					}
					
					Double industryMeasureValue=funcRankGrowValue;
					Industry industry=this.dicDao.getIndustryById(jobvo.getIndustryId());
					if(industry!=null){
						if(jobIndustryMap.containsKey(industry.getId())){
							Double value=jobIndustryMap.get(industry.getId());
							jobIndustryMap.put(industry.getId(), value+industryMeasureValue);
						}else{
							jobIndustryMap.put(industry.getId(), industryMeasureValue);
						}
					}
				}
				
		//职能经验匹配
		Double convertUserFuncMeasureValue=0.0;
		Double jobFuncMeasureValue=0.0;
		for(Object jobkey:jobFuncRankMap.keySet()){
			jobFuncMeasureValue=jobFuncRankMap.get(jobkey);
			for(Object userkey:userFuncRankMap.keySet()){
				Double convertRatio=this.funcRankService.findConvertValue((Integer)userkey, (Integer)jobkey);
				if(convertRatio==null)convertRatio=1.0;
				convertUserFuncMeasureValue+=convertRatio*userFuncRankMap.get(userkey);
			}
		}
		Double funcMatchResult=(convertUserFuncMeasureValue/jobFuncMeasureValue);
		if(funcMatchResult>1){
			funcMatchResult=1-(funcMatchResult-1)*0.4;
		}
		funcRankMap.put("职能经验匹配度合计=", convertUserFuncMeasureValue+"/"+jobFuncMeasureValue+"="+MathFormatUtil.round(funcMatchResult)*100+"%");
		
		//知识技能经验匹配
		Double abilityMatchResult=0.0;
		for(String key:jobAbilityMap.keySet()){
			Double value1=0.0;
			String jobkey=key.split(";")[0];
			String abilityname=key.split(";")[1];
			Map<String,Double> tmpmap=jobAbilityMap.get(key);
			Double jobvalue=tmpmap.get("value");
			Double abilityratio=tmpmap.get("ratio");
			for(String userkey:userAbilityMap.keySet()){
				Double uservalue=userAbilityMap.get(userkey);
				if(jobkey.equals(userkey)){
					value1+=uservalue;
				}else{
					if(userkey.substring(0,6).equals(jobkey.substring(0,6))){
						value1+=0.7*0.3*uservalue;
					}else if(userkey.substring(0,4).equals(jobkey.substring(0,4))){
						if(userkey.substring(4,8).equals("0000")&&jobkey.substring(4,8).equals("0000")){
							value1+=0;
						}else if(userkey.substring(4,8).equals("0000")&&!jobkey.substring(4,8).equals("0000")){
							if(jobkey.substring(6,8).equals("00")){
								value1+=0.3*uservalue;
							}else{
								value1+=0.3*0.3*uservalue;
							}
						}else if(!userkey.substring(4,8).equals("0000")&&jobkey.substring(4,8).equals("0000")){
							if(userkey.substring(6,8).equals("00")){
								value1+=0.7*uservalue;
							}else{
								value1+=0.7*0.7*uservalue;
							}
						}else if(!userkey.substring(4,8).equals("0000")&&!jobkey.substring(4,8).equals("0000")){
							if(userkey.substring(6,8).equals("00")){
								if(jobkey.substring(6,8).equals("00")){
									value1+=0.7*0.3*uservalue;
								}else{
									value1+=0.7*0.3*0.3*uservalue;
								}
							}else{
								if(jobkey.substring(6,8).equals("00")){
									value1+=0.7*0.7*0.3*uservalue;
								}else{
									value1+=0.7*0.7*0.3*0.3*uservalue;
								}
							}
						}
					}
				}
			}
			Double tmpvalue=value1/jobvalue;
			if(tmpvalue>1){
				tmpvalue=1-(tmpvalue-1)*0.4;
			}
			abilityMatchResult+=tmpvalue*abilityratio;
			abilityMap.put("知识技能匹配-"+abilityname+"：", value1+"/"+jobvalue+"="+MathFormatUtil.round(tmpvalue)*100+"%");
		}		
		abilityMap.put("知识技能匹配度合计=", MathFormatUtil.round(abilityMatchResult)*100+"%");
		
		//行业经验匹配
		Double convertUserIndustryMeasureValue=0.0;
		Double jobIndustryMeasureValue=0.0;
		for(Object jobkey:jobIndustryMap.keySet()){
			jobIndustryMeasureValue=jobIndustryMap.get(jobkey);
			for(Object userkey:userIndustryMap.keySet()){
				Double convertRatio=this.dicDao.findIndustryConvert((Integer)userkey, (Integer)jobkey);
				if(convertRatio==null)convertRatio=1.0;
				convertUserIndustryMeasureValue+=convertRatio*userIndustryMap.get(userkey);
			}
		}
		Double industryMatchResult=(convertUserIndustryMeasureValue/jobIndustryMeasureValue);
		if(industryMatchResult>1){
			industryMatchResult=1-(industryMatchResult-1)*0.4;
		}
		industryMap.put("行业经验匹配度合计=", convertUserIndustryMeasureValue+"/"+jobIndustryMeasureValue+"="+MathFormatUtil.round(industryMatchResult)*100+"%");
		
		//综合匹配度计算
		Double matchresult=0.0;
		FuncRank funcRank=this.funcRankService.getFuncRankById(job.getFuncRankId());
		if(funcRank==null) return result;
		matchresult=funcRank.getRatioFunction()*funcMatchResult+funcRank.getRatioAbility()*abilityMatchResult+funcRank.getRatioIndustry()*industryMatchResult;
		matchMap.put("综合匹配度=", MathFormatUtil.round(matchresult)*100+"%");
		
		result.add(funcRankMap);
		result.add(abilityMap);
		result.add(industryMap);
		result.add(matchMap);
		return result;
	}

	@Override
	public Double match(List<UserCompetency> userCpList, List<JobCompetency>  jobCpList) {
		Double result=0.0;		
		Integer funcRankId=0;
		
		for(JobCompetency jc:jobCpList){
			if(jc.getDimensionId()==JobCompetency.DIMENSION_FUNC_RANK){
				funcRankId=jc.getMeasureId().intValue();
			}
		}
		
		Double funcRankMatch=this.matchFuncRank(userCpList, jobCpList);
		Double abilityMatch=this.matchAbility(userCpList, jobCpList);
		Double industryMatch=this.matchIndustry(userCpList, jobCpList);
		
		FuncRank funcRank=this.funcRankService.getFuncRankById(funcRankId);
		if(funcRank!=null){
			result=funcRank.getRatioFunction()*funcRankMatch+funcRank.getRatioAbility()*abilityMatch+funcRank.getRatioIndustry()*industryMatch;
		}
		
		return MathFormatUtil.round(result);
	}

	public  List<UserCompetency> loadUserCompetencys(Long userId){	
		return this.userCompetencyService.findUserCompetencyListByUserId(userId);
	}
	
	public List<JobCompetency> loadJobCompetencys(Long opportunityId){
		return this.jobCompetencyService.findJobCompetencyList(opportunityId);
	}

	public FuncRankService getFuncRankService() {
		return funcRankService;
	}

	public void setFuncRankService(FuncRankService funcRankService) {
		this.funcRankService = funcRankService;
	}

	public UserCompetencyService getUserCompetencyService() {
		return userCompetencyService;
	}

	public void setUserCompetencyService(UserCompetencyService userCompetencyService) {
		this.userCompetencyService = userCompetencyService;
	}

	public JobCompetencyService getJobCompetencyService() {
		return jobCompetencyService;
	}

	public void setJobCompetencyService(JobCompetencyService jobCompetencyService) {
		this.jobCompetencyService = jobCompetencyService;
	}

	public AbilityService getAbilityService() {
		return abilityService;
	}

	public void setAbilityService(AbilityService abilityService) {
		this.abilityService = abilityService;
	}

	public GrowthService getGrowthService() {
		return growthService;
	}

	public void setGrowthService(GrowthService growthService) {
		this.growthService = growthService;
	}

	public AbilityDao getAbilityDao() {
		return abilityDao;
	}

	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public DictionaryDao getDicDao() {
		return dicDao;
	}

	public void setDicDao(DictionaryDao dicDao) {
		this.dicDao = dicDao;
	}

}
