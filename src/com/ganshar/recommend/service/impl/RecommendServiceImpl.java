package com.ganshar.recommend.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ganshar.job.dao.JobDao;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.JobService;
import com.ganshar.match.model.JobCompetency;
import com.ganshar.match.model.UserCompetency;
import com.ganshar.match.service.JobCompetencyService;
import com.ganshar.match.service.MatchService;
import com.ganshar.match.service.UserCompetencyService;
import com.ganshar.recommend.comparator.OpportunityComparator;
import com.ganshar.recommend.service.RecommendService;
import com.ganshar.resume.model.UserJobIntent;
import com.ganshar.resume.service.ResumeService;

public class RecommendServiceImpl implements RecommendService {

	private MatchService matchService;
	private JobService jobService;
	private UserCompetencyService userCompetencyService;
	private JobCompetencyService jobCompetencyService;
	private  ResumeService resumeService;
	private JobDao jobDao;
	
	@Override
	public List<Opportunity> recommend(Long userId, List<Opportunity> opps) {
		return this.recommend(userId, opps, 50);
	}
	
	public List<Opportunity> recommend(Long userId, List<Opportunity> opps, Integer topcount) {
		List<Opportunity> result=new ArrayList<Opportunity>();
		List<UserCompetency> uclist=this.userCompetencyService.findUserCompetencyListByUserId(userId);
		
		if(opps!=null&&opps.size()>0){
			for(Opportunity opp:opps){
				List<JobCompetency> jclist=this.jobCompetencyService.findJobCompetencyList(opp.getId());
				Double matchScore=this.matchService.match(uclist, jclist);
				if(matchScore>0.2){
					opp.setMatchScore(new Double(100*matchScore).intValue());
					result.add(opp);
				}
			}
		}
		Collections.sort(result, new OpportunityComparator());
		if(result.size()>topcount){
			return result.subList(0, topcount);
		}else{
			return result;
		}
	}

	@Override
	public List<Opportunity> recommend(Long userId) {
		return this.recommend(userId, this.filterOpportunitys(userId));
	}

	@Override
	public List<Opportunity> recommend(Long userId, Integer topcount) {
		return this.recommend(userId, this.filterOpportunitys(userId),topcount);
	}

	@Override
	public List<Opportunity> filterOpportunitys(Long userId) {
		List<Opportunity> result=new ArrayList<Opportunity>();
		Set<Opportunity> tmp=new HashSet<Opportunity>();
		List<String> targetJobNames=new ArrayList<String>();
		
		UserJobIntent jobIntent=this.resumeService.findUserJobIntent(userId);
		if(jobIntent!=null){
			String jobkeys=jobIntent.getJobKeyword();
			if(jobkeys!=null&&jobkeys.length()>0){
				if(jobkeys.indexOf(",")>0){
					String[] keys=jobkeys.split(",");
					for(String key:keys){
						targetJobNames.add(key.trim().toLowerCase());
					}
				}else{
					targetJobNames.add(jobkeys.trim().toLowerCase());
				}
			}
		}
		
		String currentJob=this.resumeService.findCurrJobnameByUserId(userId);
		if(currentJob!=null&&currentJob.length()>0){
			targetJobNames.add(currentJob);
		}
		
		for(String jobname:targetJobNames){
			tmp.addAll(this.jobDao.findRecommendOpps(jobname));
		}
		result.addAll(tmp);
		
		return result;
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
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

	public ResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public JobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

}
