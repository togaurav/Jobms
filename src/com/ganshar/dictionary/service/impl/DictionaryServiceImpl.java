package com.ganshar.dictionary.service.impl;

import java.util.List;
import java.util.Map;

import com.ganshar.dictionary.dao.DictionaryDao;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.service.DictionaryService;

public class DictionaryServiceImpl implements DictionaryService {

	private DictionaryDao dicDao;

	public DictionaryDao getDicDao() {
		return dicDao;
	}

	public void setDicDao(DictionaryDao dicDao) {
		this.dicDao = dicDao;
	}

	@Override
	public List<Map<Integer, String>> findAllEducations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyById(Long companyId) {
		return this.dicDao.getCompany(companyId);
	}

	@Override
	public Company findCompanyByName(String companyName) {
		return this.dicDao.findCompanyByName(companyName);
	}

	@Override
	public Industry getIndustryById(Integer industryId) {
		return this.dicDao.getIndustryById(industryId);
	}

}
