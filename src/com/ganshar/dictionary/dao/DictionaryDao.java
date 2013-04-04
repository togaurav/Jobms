package com.ganshar.dictionary.dao;

import java.util.List;

import com.ganshar.dictionary.model.CitySalary;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;
import com.ganshar.job.model.MajorAbility;

public interface DictionaryDao {
	
	public School getSchool(Integer id);
		
	public Major getMajor(Integer id);
	
	public Company getCompany(Long id);
	
	public CitySalary getCitySalary(Integer id);
	
	public Industry getIndustryById(Integer industryId);
	
	public List<Company> findCompanyListByTip(String tipCompanyName);
	
	public List<School> findSchoolListByTip(String tipSchoolName);
	
	public List<Major> findMajorListByTip(String tipMajorName);
	
	public Company findCompanyByName(String companyName);
	
	public Major findMajorByName(String majorName);
	
	public School findSchoolByName(String schoolName);
	
	public List<Industry> loadIndustryList();
	
	public Double findIndustryConvert(Integer curId,Integer tarId);
	
	public void addMajorAbility(MajorAbility majorAbility);
	
	public void deleteMajorAbilitys(Integer majorId);
	
	public List<MajorAbility> findMajorAbilitys(Integer majorId);
	
}
