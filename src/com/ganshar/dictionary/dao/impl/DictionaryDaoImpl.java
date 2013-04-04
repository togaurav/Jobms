package com.ganshar.dictionary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.dictionary.dao.DictionaryDao;
import com.ganshar.dictionary.model.CitySalary;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.IndustryConvert;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;
import com.ganshar.job.model.MajorAbility;

public class DictionaryDaoImpl extends GenericDaoImpl<Object,Integer> implements DictionaryDao {

	@Override
	public School getSchool(Integer id) {
		School result=null;
		String hql="from School where id=? ";
		List<School> list=this.findByHql(hql, new Integer[]{id});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public Major getMajor(Integer id) {
		Major result=null;
		String hql="from Major where id=? ";
		List<Major> list=this.findByHql(hql, new Integer[]{id});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public Company getCompany(Long id) {
		Company result=null;
		String hql="from Company where id=? ";
		List<Company> list=this.findByHql(hql, new Long[]{id});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public CitySalary getCitySalary(Integer id) {
		CitySalary result=null;
		String hql="from CitySalary where id=? ";
		List<CitySalary> list=this.findByHql(hql, new Integer[]{id});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public Industry getIndustryById(Integer industryId) {
		Industry result=null;
		String hql="from Industry where id=?";
		List<Industry> list=this.findByHql(hql, new Integer[]{industryId});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public List<Company> findCompanyListByTip(String tipCompanyName) {
		String hql="from Company where name like ?";
		return this.findByHql(hql, new String[]{"%"+tipCompanyName+"%"});
	}
	
	@Override
	public List<School> findSchoolListByTip(String tipSchoolName) {
		String hql="from School where name like ?";
		return this.findByHql(hql, new String[]{"%"+tipSchoolName+"%"});
	}
	
	@Override
	public List<Major> findMajorListByTip(String tipMajorName) {
		String hql="from Major where name like ?";
		return this.findByHql(hql, new String[]{"%"+tipMajorName+"%"});
	}	

	@Override
	public Company findCompanyByName(String companyName) {
		Company result=null;
		String hql="from Company where name like ?";
		List<Company> list=this.findByHql(hql, new String[]{companyName+"%"});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public Major findMajorByName(String majorName) {
		Major result=null;
		String hql="from Major where name = ?";
		List<Major> list=this.findByHql(hql, new String[]{majorName});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public School findSchoolByName(String schoolName) {
		School result=null;
		String hql="from School where name= ?";
		List<School> list=this.findByHql(hql, new String[]{schoolName});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public List<Industry> loadIndustryList() {
		String hql="from Industry";
		return this.findByHql(hql, new Object[]{});
	}

	@Override
	public Double findIndustryConvert(Integer curId, Integer tarId) {
		Double result=null;
		String hql="from IndustryConvert where curIndustryId=? and tarIndustryId=?";
		List<IndustryConvert> list=this.findByHql(hql, new Integer[]{curId,tarId});
		if(list!=null&&list.size()>0){
			IndustryConvert ic=list.get(0);
			result=ic.getConvertRatio();
		}
		return result;
	}

	@Override
	public void addMajorAbility(MajorAbility majorAbility) {
		this.saveEntity(majorAbility);
	}

	@Override
	public void deleteMajorAbilitys(Integer majorId) {
		String hql="delete from MajorAbility where majorId=?";
		this.execute(hql, new Integer[]{majorId});
	}

	@Override
	public List<MajorAbility> findMajorAbilitys(Integer majorId) {
		List<MajorAbility> result=new ArrayList<MajorAbility>();
		String hql="from MajorAbility where majorId=?";
		result=this.findByHql(hql, new Integer[]{majorId});
		return result;
	}

}
