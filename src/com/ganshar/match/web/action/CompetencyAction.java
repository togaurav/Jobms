package com.ganshar.match.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.OpportunityService;
import com.ganshar.match.service.JobCompetencyService;
import com.ganshar.match.service.MatchService;
import com.ganshar.match.service.UserCompetencyService;
import com.ganshar.match.web.vo.CompetencyChartVO;
import com.ganshar.resume.model.Resume;
import com.ganshar.user.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CompetencyAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(CompetencyAction.class);
	
	protected UserCompetencyService userCompetencyService;
	protected JobCompetencyService jobCompetencyService;
	protected OpportunityService opportunityService;
	protected MatchService matchService;
	
	private List<CompetencyChartVO> chartData;
	private List<Opportunity> opportunityList=new ArrayList<Opportunity>();
	private String companyName;
	private String jobName;
	private String matchresult;

	public String generateUserCompetencyChart() throws Exception {
		try {
			chartData=this.userCompetencyService.findUserCompetencyChartVOList(this.getSessionUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String generateUserJobCompetencyChart() throws Exception {
		try {
			Opportunity opp=this.opportunityService.getOpportunityById( Long.valueOf(jobName));
			if(opp!=null){
				chartData=this.jobCompetencyService.findCompetencyChartVOList( opp.getId());
				/*List<CompetencyChartVO> userChartData=this.userCompetencyService.findUserCompetencyChartVOList(this.getSessionUserId());
				List<CompetencyChartVO> jobChartData=this.jobCompetencyService.findCompetencyChartVOList( opp.getId());
				chartData=new ArrayList<CompetencyChartVO>();
				if(userChartData!=null&&jobChartData!=null){
						userChartData.addAll(jobChartData);
						Map<String,CompetencyChartVO> tmpmap=new HashMap<String,CompetencyChartVO>();
						for(CompetencyChartVO vo:userChartData){
							if(tmpmap.containsKey(vo.getName())){
								CompetencyChartVO tmpvo=tmpmap.get(vo.getName());
								vo.setValue(new Double[]{vo.getValue()[0],tmpvo.getValue()[0]});
								tmpmap.put(vo.getName(), vo);
							}else{
								tmpmap.put(vo.getName(), vo);
							}
						}
						for(String key:tmpmap.keySet()){
							CompetencyChartVO tmpvo=tmpmap.get(key);
							chartData.add(tmpvo);
						}
				}
				*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String match() throws Exception {
		try {
				Resume resume=new Resume();
				resume.setUserId(this.getSessionUserId());
				Opportunity opp=this.opportunityService.getOpportunityById( Long.valueOf(jobName));
				Double match=this.matchService.match(resume, opp);
				Map<String,Double> matchdetail=this.matchService.matchmap(resume, opp);
				matchresult="<font color='white'><strong>匹配结果="+match+"</strong><br/>";
				for(String key:matchdetail.keySet()){
					matchresult+=key+"="+matchdetail.get(key)+"<br/>";
				}
				matchresult+="</font>";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String findJobsByCompany() throws Exception {
		try {
				String keyword = new String(this.companyName.getBytes("ISO-8859-1"),"utf-8"); 
				this.opportunityList=this.opportunityService.findOpportunityListByCompany(keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String showCompetencyChart() throws Exception {
		return SUCCESS;
	}	

	public Long getSessionUserId(){
		ActionContext ctx=ActionContext.getContext();
		Object obj=ctx.getSession().get("user");
		return obj==null?0L:((User)obj).getId();
	}	
	
	public List<CompetencyChartVO> getChartData() {
		return chartData;
	}
	public void setChartData(List<CompetencyChartVO> chartData) {
		this.chartData = chartData;
	}
	public UserCompetencyService getUserCompetencyService() {
		return userCompetencyService;
	}
	public void setUserCompetencyService(UserCompetencyService userCompetencyService) {
		this.userCompetencyService = userCompetencyService;
	}

	public OpportunityService getOpportunityService() {
		return opportunityService;
	}

	public void setOpportunityService(OpportunityService opportunityService) {
		this.opportunityService = opportunityService;
	}

	public List<Opportunity> getOpportunityList() {
		return opportunityList;
	}

	public void setOpportunityList(List<Opportunity> opportunityList) {
		this.opportunityList = opportunityList;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public JobCompetencyService getJobCompetencyService() {
		return jobCompetencyService;
	}

	public void setJobCompetencyService(JobCompetencyService jobCompetencyService) {
		this.jobCompetencyService = jobCompetencyService;
	}

	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	public String getMatchresult() {
		return matchresult;
	}

	public void setMatchresult(String matchresult) {
		this.matchresult = matchresult;
	}

}
