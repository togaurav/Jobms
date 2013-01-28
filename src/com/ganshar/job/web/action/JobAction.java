package com.ganshar.job.web.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.job.service.JobService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(JobAction.class);
	
	protected JobService jobService;
	private List<String> result;
	private String term;
	private String data;
	private String jobName_widget;

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getJobName_widget() {
		return jobName_widget;
	}

	public void setJobName_widget(String jobName_widget) {
		this.jobName_widget = jobName_widget;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * 
	 */
	public String findJobListByTip() throws Exception {
		try {
			if(this.term!=null&&this.term.length()>0){
				String keyword = new String(this.term.getBytes("ISO-8859-1"),"utf-8"); 
				//List<String> jobnames=this.jobService.findJobNamesByIndex(keyword.trim().toLowerCase());
				//this.setResult(jobnames);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String getJobMatchForUser() throws Exception {
		try {
			if(this.jobName_widget!=null&&this.jobName_widget.length()>0){
				String keyword = new String(this.jobName_widget.getBytes("ISO-8859-1"),"utf-8"); 
				Object userobj=ActionContext.getContext().getSession().get("userid");
				if(userobj!=null){
					Long userId=(Long)userobj;
					//Double matchresult=this.userJobMatchService.match(userId, this.jobName_widget.trim());
				//	this.setData("匹配度="+matchresult.toString());
				}else{
					this.setData("用户没有登录！");
				}
			}else{
				this.setData("请输入职位！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.setData("出现系统错误！");
		}
		return SUCCESS;
	}	

}
