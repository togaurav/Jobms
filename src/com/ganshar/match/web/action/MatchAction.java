package com.ganshar.match.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.framework.util.DateUtils;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.service.JobService;
import com.ganshar.job.web.vo.JobVO;
import com.ganshar.match.service.MatchService;
import com.ganshar.match.service.UserCompetencyService;
import com.ganshar.resume.web.vo.UserEducateExpVO;
import com.ganshar.resume.web.vo.UserWorkExpVO;
import com.opensymphony.xwork2.ActionSupport;

public class MatchAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(MatchAction.class);
	
	protected JobService jobService;
	protected DictionaryService dicService;
	protected UserCompetencyService userCompetencyService;
	protected MatchService matchService;
	
	private List<String> result=new ArrayList<String>();
	private List<Industry> industryList;
	
	private UserEducateExpVO userEducateExpVO;
	private UserWorkExpVO userWorkExpVO;
	private JobVO jobVO;
	
	public String matchinput() throws Exception {
		try {
			this.industryList=this.dicService.loadIndustryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}	

	public String analyseresume() throws Exception {
		try {
			UserEducateExpVO ueduexpvo=new UserEducateExpVO();
			List<UserWorkExpVO> uworkexpvos=new ArrayList<UserWorkExpVO>();
			this.prepareData(ueduexpvo, uworkexpvos);
			
			List<Map<String,String>> resumeResult=this.matchService.analyseResume(ueduexpvo, uworkexpvos);
			if(resumeResult!=null&&resumeResult.size()>0){
				for(Map<String,String> tmp:resumeResult){
					StringBuffer sb=new StringBuffer();
					for(String key:tmp.keySet()){
						sb.append(key);
						sb.append(tmp.get(key));
						sb.append("&nbsp;&nbsp;");
					}
					sb.append("<br/>");
					result.add(sb.toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}	
	
	public String analysejob() throws Exception {
		try {
			String companyName=this.jobVO.getCompanyName();
			String jobName=this.jobVO.getJobName();
			companyName = new String(companyName.getBytes("ISO-8859-1"),"utf-8"); 
			jobName = new String(jobName.getBytes("ISO-8859-1"),"utf-8"); 		
			this.jobVO.setCompanyName(companyName);
			this.jobVO.setJobName(jobName);
			
			List<Map<String,String>> jobResult=this.matchService.analyseJob(this.jobVO);
			if(jobResult!=null&&jobResult.size()>0){
				for(Map<String,String> tmp:jobResult){
					StringBuffer sb=new StringBuffer();
					for(String key:tmp.keySet()){
						sb.append(key);
						sb.append(tmp.get(key));
						sb.append("&nbsp;&nbsp;");
					}
					sb.append("<br/>");
					result.add(sb.toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}		
	
	/**
	 * 
	 */
	public String analysematch() throws Exception {
		try {
			UserEducateExpVO ueduexpvo=new UserEducateExpVO();
			List<UserWorkExpVO> uworkexpvos=new ArrayList<UserWorkExpVO>();
			this.prepareData(ueduexpvo, uworkexpvos);
			String companyName=this.jobVO.getCompanyName();
			String jobName=this.jobVO.getJobName();
			companyName = new String(companyName.getBytes("ISO-8859-1"),"utf-8"); 
			jobName = new String(jobName.getBytes("ISO-8859-1"),"utf-8"); 		
			this.jobVO.setCompanyName(companyName);
			this.jobVO.setJobName(jobName);
			
			List<Map<String,String>> matchResult=this.matchService.analyseMatch(ueduexpvo, uworkexpvos, jobVO);
			if(matchResult!=null&&matchResult.size()>0){
				for(Map<String,String> tmp:matchResult){
					StringBuffer sb=new StringBuffer();
					for(String key:tmp.keySet()){
						sb.append(key);
						sb.append(tmp.get(key));
						sb.append("&nbsp;&nbsp;");
					}
					sb.append("<br/>");
					result.add(sb.toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	private void prepareData(UserEducateExpVO ueduexpvo,List<UserWorkExpVO> uworkexpvos){
		try{
			String school=this.userEducateExpVO.getSchoolName();
			String major=this.userEducateExpVO.getMajorName();
			String company=this.userWorkExpVO.getCompanyName();
			String job=this.userWorkExpVO.getJobName();
			school = new String(school.getBytes("ISO-8859-1"),"utf-8"); 
			major = new String(major.getBytes("ISO-8859-1"),"utf-8"); 
			company = new String(company.getBytes("ISO-8859-1"),"utf-8"); 
			job = new String(job.getBytes("ISO-8859-1"),"utf-8"); 
			
			String ondutyyear=this.userWorkExpVO.getOndutyYear();
			String ondutymonth=this.userWorkExpVO.getOndutyMonth();
			String leaveyear=this.userWorkExpVO.getLeaveYear();
			String leavemonth=this.userWorkExpVO.getLeaveMonth();
			
			ueduexpvo.setSchoolName(school);
			ueduexpvo.setMajorName(major);
			ueduexpvo.setEducation(this.userEducateExpVO.getEducation());
			
			String[] companys=company.split(",");
			String[] jobs=job.split(",");
			String[] ondutyyears=ondutyyear.split(",");
			String[] ondutymonths=ondutymonth.split(",");
			String[] leaveyears=leaveyear.split(",");
			String[] leavemonths=leavemonth.split(",");
			
			for(int i=0;i<5;i++){
				if(companys[i].trim().length()>1&&jobs[i].trim().length()>1){
					UserWorkExpVO workexpvo=new UserWorkExpVO();
					workexpvo.setCompanyName(companys[i].trim());
					workexpvo.setJobName(jobs[i]);
					workexpvo.setIndustryId(new Integer[]{this.userWorkExpVO.getIndustryId()[i]});
					workexpvo.setOndutyYear(ondutyyears[i]);
					workexpvo.setOndutyMonth(ondutymonths[i]);
					workexpvo.setLeaveYear(leaveyears[i]);
					workexpvo.setLeaveMonth(leavemonths[i]);	
					String ondutyDate=workexpvo.getOndutyYear()+"-"+workexpvo.getOndutyMonth();
					String leaveDate=workexpvo.getLeaveYear()+"-"+workexpvo.getLeaveMonth();
					workexpvo.setOndutyDate(DateUtils.strToDate(ondutyDate,"yy-MM"));
					workexpvo.setLeaveDate(DateUtils.strToDate(leaveDate,"yy-MM"));
					uworkexpvos.add(workexpvo);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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

	public UserCompetencyService getUserCompetencyService() {
		return userCompetencyService;
	}

	public void setUserCompetencyService(UserCompetencyService userCompetencyService) {
		this.userCompetencyService = userCompetencyService;
	}

	public List<Industry> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(List<Industry> industryList) {
		this.industryList = industryList;
	}

	public UserEducateExpVO getUserEducateExpVO() {
		return userEducateExpVO;
	}

	public void setUserEducateExpVO(UserEducateExpVO userEducateExpVO) {
		this.userEducateExpVO = userEducateExpVO;
	}

	public UserWorkExpVO getUserWorkExpVO() {
		return userWorkExpVO;
	}

	public void setUserWorkExpVO(UserWorkExpVO userWorkExpVO) {
		this.userWorkExpVO = userWorkExpVO;
	}


	public JobVO getJobVO() {
		return jobVO;
	}

	public void setJobVO(JobVO jobVO) {
		this.jobVO = jobVO;
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	
}
