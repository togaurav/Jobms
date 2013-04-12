package com.ganshar.job.web.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.ability.model.Ability;
import com.ganshar.ability.service.AbilityService;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankConvert;
import com.ganshar.job.model.FuncRankGrowth;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.FuncRankService;
import com.ganshar.job.service.JobService;
import com.ganshar.job.web.vo.JobVO;
import com.ganshar.recommend.service.RecommendService;
import com.ganshar.user.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(JobAction.class);
	
	protected JobService jobService;
	protected AbilityService abilityService;
	protected FuncRankService funcRankService;
	protected DictionaryService dicService;
	protected RecommendService recommendService;
	
	private List<String> result;
	private String term;
	private String data;
	private List<Ability> abilityList;
	private List<FuncRank> funcRankList;
	private List<Industry> industryList;
	private JobVO jobVO;
	private Integer yearnum;
	private Integer growthValue;
	private Integer funcRankId;
	private Integer curFuncRankId;
	private Integer tarFuncRankId;
	private Double convertValue;
	private List<Opportunity> opplist;
	private List<Opportunity> allopplist;

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public List<Opportunity> getOpplist() {
		return opplist;
	}

	public void setOpplist(List<Opportunity> opplist) {
		this.opplist = opplist;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<Ability> getAbilityList() {
		return abilityList;
	}

	public void setAbilityList(List<Ability> abilityList) {
		this.abilityList = abilityList;
	}

	public AbilityService getAbilityService() {
		return abilityService;
	}

	public void setAbilityService(AbilityService abilityService) {
		this.abilityService = abilityService;
	}

	public JobVO getJobVO() {
		return jobVO;
	}

	public void setJobVO(JobVO jobVO) {
		this.jobVO = jobVO;
	}

	public List<FuncRank> getFuncRankList() {
		return funcRankList;
	}

	public void setFuncRankList(List<FuncRank> funcRankList) {
		this.funcRankList = funcRankList;
	}

	public FuncRankService getFuncRankService() {
		return funcRankService;
	}

	public void setFuncRankService(FuncRankService funcRankService) {
		this.funcRankService = funcRankService;
	}

	public DictionaryService getDicService() {
		return dicService;
	}

	public void setDicService(DictionaryService dicService) {
		this.dicService = dicService;
	}

	public List<Industry> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(List<Industry> industryList) {
		this.industryList = industryList;
	}

	public Integer getYearnum() {
		return yearnum;
	}

	public void setYearnum(Integer yearnum) {
		this.yearnum = yearnum;
	}

	public Integer getGrowthValue() {
		return growthValue;
	}

	public void setGrowthValue(Integer growthValue) {
		this.growthValue = growthValue;
	}

	public Integer getFuncRankId() {
		return funcRankId;
	}

	public void setFuncRankId(Integer funcRankId) {
		this.funcRankId = funcRankId;
	}

	public Integer getCurFuncRankId() {
		return curFuncRankId;
	}

	public void setCurFuncRankId(Integer curFuncRankId) {
		this.curFuncRankId = curFuncRankId;
	}

	public Integer getTarFuncRankId() {
		return tarFuncRankId;
	}

	public void setTarFuncRankId(Integer tarFuncRankId) {
		this.tarFuncRankId = tarFuncRankId;
	}

	public Double getConvertValue() {
		return convertValue;
	}

	public void setConvertValue(Double convertValue) {
		this.convertValue = convertValue;
	}

	public JobService getJobService() {
		return jobService;
	}

	public RecommendService getRecommendService() {
		return recommendService;
	}

	public void setRecommendService(RecommendService recommendService) {
		this.recommendService = recommendService;
	}

	public List<Opportunity> getAllopplist() {
		return allopplist;
	}

	public void setAllopplist(List<Opportunity> allopplist) {
		this.allopplist = allopplist;
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
	
	public String jobManage() throws Exception {
		try {
			this.abilityList=this.abilityService.findAbilityList();
			this.funcRankList=this.funcRankService.loadFuncRankList();
			this.industryList=this.dicService.loadIndustryList();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String loadJobInfo() throws Exception {
		try {
			if(this.jobVO!=null&&this.jobVO.getJobName()!=null&&this.jobVO.getJobName().trim().length()>0){
				String jobname = new String(this.jobVO.getJobName().getBytes("ISO-8859-1"),"utf-8"); 
				this.jobVO=this.jobService.findJobVOByName(jobname.toLowerCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String savejob() throws Exception {
		try {
			if(this.jobVO!=null&&this.jobVO.getJobId()!=null){
				this.jobService.updateJob(jobVO);
			}else if(this.jobVO!=null&&this.jobVO.getJobId()==null){
				this.jobService.addJob(jobVO);
			}
			this.log.info(">>>>>>>>职位名称="+this.jobVO.getJobName()+"--"+this.jobVO.getJobName_widget());
			this.log.info(">>>>>>>>知识技能1="+this.jobVO.getSkill_1()+"--"+this.jobVO.getSkill_1_widget());
			this.jobVO=null;
			return this.jobManage();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String loadFuncRankRatio() throws Exception {
		try {
			if(this.jobVO!=null&&this.jobVO.getFuncRankId()>0){
				FuncRank funcRank=this.funcRankService.getFuncRankById(this.jobVO.getFuncRankId());
				if(funcRank!=null){
					this.jobVO.setRatioFunction(funcRank.getRatioFunction());
					this.jobVO.setRatioAbility(funcRank.getRatioAbility());
					this.jobVO.setRatioIndustry(funcRank.getRatioIndustry());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String funcRankGrowthManage() throws Exception {
		try {
			this.funcRankList=this.funcRankService.loadFuncRankList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String updateFuncRankGrowth() throws Exception {
		try {
			FuncRankGrowth funcRankGrowth=this.funcRankService.findFuncRankGrowth(this.funcRankId, this.yearnum);
			if(funcRankGrowth!=null){
				if(this.growthValue>0){
					funcRankGrowth.setGrowthValue(this.growthValue);
				}
				this.funcRankService.updateFuncRankGrowth(funcRankGrowth);
				this.data="更新成功！";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.data="更新时出现错误！";
		}
		return SUCCESS;
	}

	public String funcRankConvertManage() throws Exception {
		try {
			this.funcRankList=this.funcRankService.loadFuncRankList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String updateFuncRankConvert() throws Exception {
		try {
			FuncRankConvert funcRankConvert=this.funcRankService.findFuncRankConvert(this.curFuncRankId, this.tarFuncRankId);
			if(funcRankConvert!=null){
				if(this.convertValue>0){
					funcRankConvert.setConvertRatio(this.convertValue);
				}
				this.funcRankService.updateFuncRankConvert(funcRankConvert);
				this.data="更新成功！";
			}else{
				funcRankConvert=new FuncRankConvert();
				if(this.convertValue>0){
					funcRankConvert.setConvertRatio(this.convertValue);
				}
				funcRankConvert.setCurFuncRankId(curFuncRankId);
				funcRankConvert.setTarFuncRankId(tarFuncRankId);
				this.funcRankService.addFuncRankConvert(funcRankConvert);
				this.data="添加成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.data="更新时出现错误！";
		}
		return SUCCESS;
	}
	
	public String loadGrowthValue() throws Exception {
		try {
			FuncRankGrowth funcRankGrowth=this.funcRankService.findFuncRankGrowth(this.funcRankId, this.yearnum);
			if(funcRankGrowth!=null){
				this.growthValue=funcRankGrowth.getGrowthValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String loadConvertValue() throws Exception {
		try {
			FuncRankConvert funcRankConvert=this.funcRankService.findFuncRankConvert(this.curFuncRankId, this.tarFuncRankId);
			if(funcRankConvert!=null){
				this.convertValue=funcRankConvert.getConvertRatio();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String findRecommendOpps() throws Exception {
		try {
			allopplist=this.recommendService.recommend(this.getSessionUserId());
			if(allopplist.size()>5){
				this.opplist=allopplist.subList(0, 5);
			}else{
				this.opplist=allopplist;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String findMoreRecommendOpps() throws Exception {
		try {
			this.opplist=this.recommendService.recommend(this.getSessionUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public Long getSessionUserId(){
		ActionContext ctx=ActionContext.getContext();
		Object obj=ctx.getSession().get("user");
		return obj==null?0L:((User)obj).getId();
	}
}
