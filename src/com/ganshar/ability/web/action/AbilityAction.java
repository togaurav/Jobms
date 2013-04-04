package com.ganshar.ability.web.action;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.ability.model.Ability;
import com.ganshar.ability.service.AbilityService;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.service.FuncRankService;
import com.ganshar.job.service.JobService;
import com.ganshar.job.web.vo.JobVO;
import com.opensymphony.xwork2.ActionSupport;

public class AbilityAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(AbilityAction.class);
	
	protected AbilityService abilityService;

	private List<String> result;
	private List<Ability> abilityList;
	private List<String> abilityNames;
	private String term;
	private String path;
	private String abilityname1;
	private String abilityname2;
	private String abilityname3;
	private String abilityname4;

	public String findAbilityListByTip() throws Exception {
		try {
			if(this.term!=null&&this.term.length()>0){
				String keyword = new String(this.term.getBytes("ISO-8859-1"),"utf-8"); 
				this.abilityNames=this.abilityService.findAbilityListByName(keyword.trim().toLowerCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String list() throws Exception {
		try {
			this.abilityList=this.abilityService.findFirstLevelAbilitys();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String listAbility2() throws Exception {
		try {
			this.abilityList=this.abilityService.findSecondLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listAbility3() throws Exception {
		try {
			this.abilityList=this.abilityService.findThirdLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String listAbility4() throws Exception {
		try {
			this.abilityList=this.abilityService.findForthLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String add1() throws Exception {
		try {
			String s=new String(this.abilityname1.getBytes("ISO-8859-1"),"utf-8"); 
			Ability ability=this.abilityService.getAbilityByName(s);
			if(ability==null){
				this.abilityService.addAbility(s, null, 1);
			}
			this.abilityList=this.abilityService.findFirstLevelAbilitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String delete1() throws Exception {
		try {
			this.abilityService.deleteAbility(path);
			this.abilityList=this.abilityService.findFirstLevelAbilitys();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String add2() throws Exception {
		try {
			String s=new String(this.abilityname2.getBytes("ISO-8859-1"),"utf-8"); 
			Ability ability=this.abilityService.getAbilityByName(s);
			if(ability==null){
				this.abilityService.addAbility(s, path, 2);
			}
			this.abilityList=this.abilityService.findSecondLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String delete2() throws Exception {
		try {
			this.abilityService.deleteAbility(path);
			this.abilityList=this.abilityService.findSecondLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String add3() throws Exception {
		try {
			String s=new String(this.abilityname3.getBytes("ISO-8859-1"),"utf-8"); 
			Ability ability=this.abilityService.getAbilityByName(s);
			if(ability==null){
				this.abilityService.addAbility(s, path, 3);
			}
			this.abilityList=this.abilityService.findThirdLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String delete3() throws Exception {
		try {
			this.abilityService.deleteAbility(path);
			this.abilityList=this.abilityService.findThirdLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}	

	public String add4() throws Exception {
		try {
			String s=new String(this.abilityname4.getBytes("ISO-8859-1"),"utf-8"); 
			Ability ability=this.abilityService.getAbilityByName(s);
			if(ability==null){
				this.abilityService.addAbility(s, path, 4);
			}
			this.abilityList=this.abilityService.findForthLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String delete4() throws Exception {
		try {
			this.abilityService.deleteAbility(path);
			this.abilityList=this.abilityService.findForthLevelAbilitys(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}	
	
	public AbilityService getAbilityService() {
		return abilityService;
	}


	public void setAbilityService(AbilityService abilityService) {
		this.abilityService = abilityService;
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


	public List<String> getAbilityNames() {
		return abilityNames;
	}


	public void setAbilityNames(List<String> abilityNames) {
		this.abilityNames = abilityNames;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getAbilityname1() {
		return abilityname1;
	}


	public void setAbilityname1(String abilityname1) {
		this.abilityname1 = abilityname1;
	}


	public String getAbilityname2() {
		return abilityname2;
	}


	public void setAbilityname2(String abilityname2) {
		this.abilityname2 = abilityname2;
	}


	public String getAbilityname3() {
		return abilityname3;
	}


	public void setAbilityname3(String abilityname3) {
		this.abilityname3 = abilityname3;
	}


	public String getAbilityname4() {
		return abilityname4;
	}


	public void setAbilityname4(String abilityname4) {
		this.abilityname4 = abilityname4;
	}

}
