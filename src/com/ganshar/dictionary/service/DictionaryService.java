package com.ganshar.dictionary.service;

import java.util.List;
import java.util.Map;

import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.School;
import com.ganshar.job.web.vo.MajorVO;


public interface DictionaryService {
	
	public List<Map<Integer,String>> findAllEducations();
	
	public Company getCompanyById(Long companyId);
	
	public Company findCompanyByName(String companyName);
	
	public Industry getIndustryById(Integer industryId);
	
	public List<Industry> loadIndustryList();
	
	public School getSchool(Integer id);
	
	public MajorVO findMajorVOByName(String majorname);
	
	public void updateMajorAbilitys(MajorVO majorVO); 
}
