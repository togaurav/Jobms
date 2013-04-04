package com.ganshar.job.web.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.ability.model.Ability;
import com.ganshar.ability.service.AbilityService;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.web.vo.MajorVO;
import com.opensymphony.xwork2.ActionSupport;

public class MajorAbilityAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(MajorAbilityAction.class);
	
	protected AbilityService abilityService;
	protected DictionaryService dicService;
	private List<String> result;
	private String term;
	private String data;
	private List<Ability> abilityList;
	private MajorVO majorVO;

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
	
	public DictionaryService getDicService() {
		return dicService;
	}

	public void setDicService(DictionaryService dicService) {
		this.dicService = dicService;
	}
	
	public MajorVO getMajorVO() {
		return majorVO;
	}

	public void setMajorVO(MajorVO majorVO) {
		this.majorVO = majorVO;
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
	
	public String majorManage() throws Exception {
		try {
			this.abilityList=this.abilityService.findAbilityList();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String loadMajorInfo() throws Exception {
		try {
			if(this.majorVO!=null&&this.majorVO.getMajorName()!=null&&this.majorVO.getMajorName().trim().length()>0){
				String majorname = new String(this.majorVO.getMajorName().getBytes("ISO-8859-1"),"utf-8"); 
				this.majorVO=this.dicService.findMajorVOByName(majorname.toLowerCase());
			}
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String savemajor() throws Exception {
		try {
			if(this.majorVO!=null){
				this.dicService.updateMajorAbilitys(majorVO);
			}
			this.majorVO=null;
			return this.majorManage();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
