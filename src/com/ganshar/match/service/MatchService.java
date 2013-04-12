package com.ganshar.match.service;

import java.util.List;
import java.util.Map;

import com.ganshar.job.model.Opportunity;
import com.ganshar.job.web.vo.JobVO;
import com.ganshar.match.model.JobCompetency;
import com.ganshar.match.model.UserCompetency;
import com.ganshar.resume.model.Resume;
import com.ganshar.resume.web.vo.UserEducateExpVO;
import com.ganshar.resume.web.vo.UserWorkExpVO;

public interface MatchService {

	public Double match(Resume resume, Opportunity opp);
	
	public Double match(List<UserCompetency> userCpList, List<JobCompetency>  jobCpList);
	
	public Map<String,Double> matchmap(Resume resume, Opportunity opp);

	public Map<Long,Double> matchAll(Resume resume, List<Opportunity> opps);
	
	public List<Map<String,String>> analyseResume(UserEducateExpVO eduvo, List<UserWorkExpVO> workvos);	
	
	public List<Map<String,String>> analyseJob(JobVO jobvo);
	
	public List<Map<String,String>> analyseMatch(UserEducateExpVO eduvo, List<UserWorkExpVO> workvos,JobVO jobvo);
}
