package com.ganshar.match.web.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.service.JobService;
import com.ganshar.match.service.UserCompetencyService;
import com.opensymphony.xwork2.ActionSupport;

public class MatchAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(MatchAction.class);
	
	protected JobService jobService;
	protected DictionaryService dicService;
	protected UserCompetencyService userCompetencyService;
	
	private String result;

	public String formatch() throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}	

	public String findCompanyJobs() throws Exception {
		try {
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}	
	
	/**
	 * 
	 */
	public String domatch() throws Exception {
		try {
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
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

	
}
