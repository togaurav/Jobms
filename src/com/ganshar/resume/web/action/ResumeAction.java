package com.ganshar.resume.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framework.util.DateUtils;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.model.Job;
import com.ganshar.job.service.JobService;
import com.ganshar.resume.model.UserInfo;
import com.ganshar.resume.service.ResumeService;
import com.ganshar.resume.web.vo.UserEducateExpVO;
import com.ganshar.resume.web.vo.UserInfoVO;
import com.ganshar.resume.web.vo.UserWorkExpVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResumeAction extends ActionSupport {
	private final static Logger log = LogManager
			.getLogger(ResumeAction.class);
	
	protected ResumeService resumeService;
	protected JobService jobService;
	protected DictionaryService dicService;
	
	private UserInfoVO userInfoVO;
	private UserWorkExpVO userWorkExpVO;
	private List<UserWorkExpVO> userWorkExpVOList=new ArrayList<UserWorkExpVO>();
	private UserEducateExpVO userEducateExpVO;
	private List<UserEducateExpVO> userEducateExpVOList=new ArrayList<UserEducateExpVO>();
	private List<String>companyNames;
	private List<String>jobNames;
	
	private Integer tabIndex=0;
	private String result;
	private String term;

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	/**
	 * 
	 */
	public String showresume() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userid=(Long)ctx.getSession().get("userid");
			
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 提取简历数据，进入完善简历页面
	 */
	public String resumeManage() throws Exception {
		try {
			this.prepareResumeData();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	private void prepareResumeData(){
		ActionContext ctx=ActionContext.getContext();
		Long userId=(Long)ctx.getSession().get("userid");
		if(this.tabIndex==null){
			this.tabIndex=0;
		}
		UserInfo userInfo=this.resumeService.getUserInfoByUserId(userId);	
		if(userInfo!= null){
			userInfoVO=new UserInfoVO();
			BeanUtils.copyProperties(userInfo, userInfoVO);
		}
		
		this.userWorkExpVOList=this.resumeService.findUserWorkExpVOListByUserId(userId);
		this.userEducateExpVOList=this.resumeService.findUserEducateExpVOListByUserId(userId);
		
	}
	
	/**
	 * 
	 */
	public String saveUserInfo() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userId=(Long)ctx.getSession().get("userid");
			
			UserInfo userinfo=this.resumeService.getUserInfoByUserId(userId);	
			if(userinfo!= null){
				userInfoVO.setUpdateTime(new Date());
				this.resumeService.updateUserInfo(userInfoVO);
			}else{
				userInfoVO.setUserId(userId);
				userInfoVO.setAddTime(new Date());
				userInfoVO.setUpdateTime(new Date());
				this.resumeService.addUserInfo(userInfoVO);
			}
			this.result="<strong>用户信息已保存成功！</strong>";
		} catch (Exception e) {
			this.result="<strong>出现系统错误！</strong>";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 */
	public String saveUserAbility() throws Exception {
		try {
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 
	 */
	public String saveUserWorkExp() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userId=(Long)ctx.getSession().get("userid");
			String ondutyDate=this.userWorkExpVO.getOndutyYear()+"-"+this.userWorkExpVO.getOndutyMonth();
			String leaveDate=this.userWorkExpVO.getLeaveYear()+"-"+this.userWorkExpVO.getLeaveMonth();
			
			this.userWorkExpVO.setUserId(userId);
			this.userWorkExpVO.setAddTime(new Date());
			this.userWorkExpVO.setUpdateTime(new Date());
			this.userWorkExpVO.setOndutyDate(DateUtils.strToDate(ondutyDate,"yy-MM"));
			if(this.userWorkExpVO.getNowdate()!=null&&this.userWorkExpVO.getNowdate()){
				this.userWorkExpVO.setLeaveDate(new Date());
			}else{
				this.userWorkExpVO.setLeaveDate(DateUtils.strToDate(leaveDate,"yy-MM"));
			}
			
			if(this.userWorkExpVO.getLastJob()!=null&&this.userWorkExpVO.getLastJob()){
				this.userWorkExpVO.setIsLastJob(1);
			}else{
				this.userWorkExpVO.setIsLastJob(0);
			}
			
			if(this.userWorkExpVO.getCompanyName()!=null){
				Company company=this.dicService.findCompanyByName(this.userWorkExpVO.getCompanyName());
				if(company!=null){
					this.userWorkExpVO.setCompanyId(company.getId());
				}
			}
			
			if(this.userWorkExpVO.getJobName()!=null){
				Job job=this.jobService.findJobByName(this.userWorkExpVO.getJobName());
				if(job!=null){
					this.userWorkExpVO.setJobId(job.getJobId());
				}
			}
			
			if(this.userWorkExpVO.getId()!=null&&this.userWorkExpVO.getId()>0){
				this.resumeService.updateUserWorkExp(userWorkExpVO);
			}else{
				this.resumeService.addUserWorkExp(userWorkExpVO);
			}
			
			this.result="工作经历已保存成功！";
			this.tabIndex=2;
			this.prepareResumeData();
			this.userWorkExpVO=null;
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 
	 */
	public String editUserWorkExp() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userId=(Long)ctx.getSession().get("userid");
			
			if(userWorkExpVO!=null&&userWorkExpVO.getId()!=null){
				userWorkExpVO=this.resumeService.getUserWorkExpVOById(userWorkExpVO.getId());
			}
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 
	 */
	public String delUserWorkExp() throws Exception {
		try {
			if(userWorkExpVO!=null&&userWorkExpVO.getId()!=null){
				this.resumeService.deleteUserWorkExp(userWorkExpVO.getId());
			}
			
			this.result="工作经历成功删除！";
			this.tabIndex=2;
			this.prepareResumeData();
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 
	 */
	public String saveUserEducateExp() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userId=(Long)ctx.getSession().get("userid");
			String beginDate=this.userEducateExpVO.getBeginYear()+"-"+this.userEducateExpVO.getBeginMonth();
			String endDate=this.userEducateExpVO.getEndYear()+"-"+this.userEducateExpVO.getEndMonth();
			
			this.userEducateExpVO.setUserId(userId);
			this.userEducateExpVO.setAddTime(new Date());
			this.userEducateExpVO.setUpdateTime(new Date());
			this.userEducateExpVO.setBeginDate(DateUtils.strToDate(beginDate,"yy-MM"));
			this.userEducateExpVO.setEndDate(DateUtils.strToDate(endDate,"yy-MM"));
			
			if(this.userEducateExpVO.getId()!=null&&this.userEducateExpVO.getId()>0){
				this.resumeService.updateUserEducateExp(userEducateExpVO);
			}else{
				this.resumeService.addUserEducateExp(userEducateExpVO);
			}
			
			this.result="教育经历已保存成功！";
			this.tabIndex=3;
			this.prepareResumeData();
			this.userEducateExpVO=null;
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 
	 */
	public String editUserEducateExp() throws Exception {
		try {
			ActionContext ctx=ActionContext.getContext();
			Long userId=(Long)ctx.getSession().get("userid");
			
			if(userEducateExpVO!=null&&userEducateExpVO.getId()!=null){
				userEducateExpVO=this.resumeService.getUserEducateExpVOById(userEducateExpVO.getId());
			}
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 
	 */
	public String delUserEducateExp() throws Exception {
		try {
			if(userEducateExpVO!=null&&userEducateExpVO.getId()!=null){
				this.resumeService.deleteUserEducateExp(userEducateExpVO.getId());
			}
			
			this.result="教育经历成功删除！";
			this.tabIndex=3;
			this.prepareResumeData();
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}	
	
	public String findCompanyListByTip() throws Exception {
		try {
			if(this.term!=null&&this.term.length()>0){
				String keyword = new String(this.term.getBytes("ISO-8859-1"),"utf-8"); 
				this.companyNames=this.resumeService.findCompanyListByTip(keyword);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String findJobListByTip() throws Exception {
		try {
			if(this.term!=null&&this.term.length()>0){
				String keyword = new String(this.term.getBytes("ISO-8859-1"),"utf-8"); 
				this.jobNames=this.resumeService.findJobListByTip(keyword);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
	}

	public UserInfoVO getUserInfoVO() {
		return userInfoVO;
	}

	public void setUserInfoVO(UserInfoVO userInfoVO) {
		this.userInfoVO = userInfoVO;
	}

	public UserWorkExpVO getUserWorkExpVO() {
		return userWorkExpVO;
	}

	public void setUserWorkExpVO(UserWorkExpVO userWorkExpVO) {
		this.userWorkExpVO = userWorkExpVO;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<UserWorkExpVO> getUserWorkExpVOList() {
		return userWorkExpVOList;
	}

	public void setUserWorkExpVOList(List<UserWorkExpVO> userWorkExpVOList) {
		this.userWorkExpVOList = userWorkExpVOList;
	}

	public UserEducateExpVO getUserEducateExpVO() {
		return userEducateExpVO;
	}

	public void setUserEducateExpVO(UserEducateExpVO userEducateExpVO) {
		this.userEducateExpVO = userEducateExpVO;
	}

	public List<UserEducateExpVO> getUserEducateExpVOList() {
		return userEducateExpVOList;
	}

	public void setUserEducateExpVOList(List<UserEducateExpVO> userEducateExpVOList) {
		this.userEducateExpVOList = userEducateExpVOList;
	}

	public List<String> getCompanyNames() {
		return companyNames;
	}

	public void setCompanyNames(List<String> companyNames) {
		this.companyNames = companyNames;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
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

	public List<String> getJobNames() {
		return jobNames;
	}

	public void setJobNames(List<String> jobNames) {
		this.jobNames = jobNames;
	}

}
