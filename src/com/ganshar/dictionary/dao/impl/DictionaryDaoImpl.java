package com.ganshar.dictionary.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.dictionary.dao.DictionaryDao;
import com.ganshar.dictionary.model.CitySalary;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;

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
		return this.findByHql(hql, new String[]{tipCompanyName+"%"});
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

}
