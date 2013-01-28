package com.ganshar.dictionary.dao;

import java.util.List;

import com.ganshar.dictionary.model.CitySalary;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;

public interface DictionaryDao {
	
	public School getSchool(Integer id);
		
	public Major getMajor(Integer id);
	
	public Company getCompany(Long id);
	
	public CitySalary getCitySalary(Integer id);
	
	public Industry getIndustryById(Integer industryId);
	
	public List<Company> findCompanyListByTip(String tipCompanyName);
	
	public Company findCompanyByName(String companyName);
}
