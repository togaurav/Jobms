package com.ganshar.dictionary.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.dictionary.dao.DictionaryDao;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Industry;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;
import com.ganshar.dictionary.service.DictionaryService;
import com.ganshar.job.model.MajorAbility;
import com.ganshar.job.web.vo.MajorVO;

public class DictionaryServiceImpl implements DictionaryService {

	private DictionaryDao dicDao;
	private AbilityDao abilityDao;

	public DictionaryDao getDicDao() {
		return dicDao;
	}

	public void setDicDao(DictionaryDao dicDao) {
		this.dicDao = dicDao;
	}

	public AbilityDao getAbilityDao() {
		return abilityDao;
	}

	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
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

	@Override
	public List<Industry> loadIndustryList() {
		return this.dicDao.loadIndustryList();
	}

	@Override
	public School getSchool(Integer id) {
		return this.dicDao.getSchool(id);
	}

	@Override
	public MajorVO findMajorVOByName(String majorName) {
		Major major=this.dicDao.findMajorByName(majorName);
		MajorVO majorVO=new MajorVO();
		if(major!=null){
			List<MajorAbility> majorAbilitys=this.dicDao.findMajorAbilitys(major.getId());
			majorVO.setMajorId(major.getId());
			majorVO.setMajorName(major.getName());
			if(majorAbilitys!=null&&majorAbilitys.size()>0){
				MajorAbility majorability=majorAbilitys.get(0);
				Ability ability=this.abilityDao.getAbilityById(majorability.getAbilityId());
				if(ability!=null){
					majorVO.setSkill_1(ability.getName());
					majorVO.setSkillratio_1(majorability.getAbilityRatio());
				}
				if(majorAbilitys.size()>1){
					majorability=majorAbilitys.get(1);
					ability=this.abilityDao.getAbilityById(majorability.getAbilityId());
					if(ability!=null){
						majorVO.setSkill_2(ability.getName());
						majorVO.setSkillratio_2(majorability.getAbilityRatio());
					}
				}
				if(majorAbilitys.size()>2){
					majorability=majorAbilitys.get(2);
					ability=this.abilityDao.getAbilityById(majorability.getAbilityId());
					if(ability!=null){
						majorVO.setSkill_3(ability.getName());
						majorVO.setSkillratio_3(majorability.getAbilityRatio());
					}
				}
				if(majorAbilitys.size()>3){
					majorability=majorAbilitys.get(3);
					ability=this.abilityDao.getAbilityById(majorability.getAbilityId());
					if(ability!=null){
						majorVO.setSkill_4(ability.getName());
						majorVO.setSkillratio_4(majorability.getAbilityRatio());
					}
				}
				if(majorAbilitys.size()>4){
					majorability=majorAbilitys.get(4);
					ability=this.abilityDao.getAbilityById(majorability.getAbilityId());
					if(ability!=null){
						majorVO.setSkill_5(ability.getName());
						majorVO.setSkillratio_5(majorability.getAbilityRatio());
					}
				}
			}
		}
		return majorVO;
	}

	@Override
	public void updateMajorAbilitys(MajorVO majorVO) {
		Major major=this.dicDao.findMajorByName(majorVO.getMajorName());
		if(major!=null){
			majorVO.setMajorId(major.getId());
		}else{
			return;
		}
			List<MajorAbility> majorAbilityList=new ArrayList<MajorAbility>();
			if(majorVO.getSkill_1_widget()!=null&&majorVO.getSkill_1_widget().trim().length()>0){
				MajorAbility ja=new MajorAbility();
				Ability ability=this.abilityDao.getAbilityByName(majorVO.getSkill_1_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setMajorId(majorVO.getMajorId());
					ja.setAbilityRatio(majorVO.getSkillratio_1()>0?majorVO.getSkillratio_1():0.2);
					majorAbilityList.add(ja);
				}
			}
			if(majorVO.getSkill_2_widget()!=null&&majorVO.getSkill_2_widget().trim().length()>0){
				MajorAbility ja=new MajorAbility();
				Ability ability=this.abilityDao.getAbilityByName(majorVO.getSkill_2_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setMajorId(majorVO.getMajorId());
					ja.setAbilityRatio(majorVO.getSkillratio_2()>0?majorVO.getSkillratio_2():0.2);
					majorAbilityList.add(ja);
				}
			}
			if(majorVO.getSkill_3_widget()!=null&&majorVO.getSkill_3_widget().trim().length()>0){
				MajorAbility ja=new MajorAbility();
				Ability ability=this.abilityDao.getAbilityByName(majorVO.getSkill_3_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setMajorId(majorVO.getMajorId());
					ja.setAbilityRatio(majorVO.getSkillratio_3()>0?majorVO.getSkillratio_3():0.2);
					majorAbilityList.add(ja);
				}
			}
			if(majorVO.getSkill_4_widget()!=null&&majorVO.getSkill_4_widget().trim().length()>0){
				MajorAbility ja=new MajorAbility();
				Ability ability=this.abilityDao.getAbilityByName(majorVO.getSkill_4_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setMajorId(majorVO.getMajorId());
					ja.setAbilityRatio(majorVO.getSkillratio_4()>0?majorVO.getSkillratio_4():0.2);
					majorAbilityList.add(ja);
				}
			}
			if(majorVO.getSkill_5_widget()!=null&&majorVO.getSkill_5_widget().trim().length()>0){
				MajorAbility ja=new MajorAbility();
				Ability ability=this.abilityDao.getAbilityByName(majorVO.getSkill_5_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setMajorId(majorVO.getMajorId());
					ja.setAbilityRatio(majorVO.getSkillratio_5()>0?majorVO.getSkillratio_5():0.2);
					majorAbilityList.add(ja);
				}
			}
			this.addMajorAbilitys(majorAbilityList, majorVO.getMajorId());
	}

	public void addMajorAbilitys(List<MajorAbility> majorAbilityList,Integer majorId) {
		if(majorAbilityList!=null&&majorAbilityList.size()>0){
			this.dicDao.deleteMajorAbilitys(majorId);
			for(MajorAbility majorAbility:majorAbilityList){
				this.dicDao.addMajorAbility(majorAbility);
			}
		}
	}
	
}
