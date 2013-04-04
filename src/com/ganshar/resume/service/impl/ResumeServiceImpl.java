package com.ganshar.resume.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.framework.util.DateUtils;
import com.ganshar.dictionary.dao.DictionaryDao;
import com.ganshar.dictionary.model.Company;
import com.ganshar.dictionary.model.Major;
import com.ganshar.dictionary.model.School;
import com.ganshar.job.dao.JobDao;
import com.ganshar.job.model.Job;
import com.ganshar.resume.dao.UserAbilityDao;
import com.ganshar.resume.dao.UserEducateExpDao;
import com.ganshar.resume.dao.UserInfoDao;
import com.ganshar.resume.dao.UserJobIntentDao;
import com.ganshar.resume.dao.UserProjectExpDao;
import com.ganshar.resume.dao.UserWorkExpDao;
import com.ganshar.resume.model.UserEducateExp;
import com.ganshar.resume.model.UserInfo;
import com.ganshar.resume.model.UserWorkExp;
import com.ganshar.resume.service.ResumeService;
import com.ganshar.resume.web.vo.UserEducateExpVO;
import com.ganshar.resume.web.vo.UserInfoVO;
import com.ganshar.resume.web.vo.UserWorkExpVO;

public class ResumeServiceImpl implements ResumeService {

	private UserInfoDao userInfoDao;
	private UserWorkExpDao userWorkExpDao;
	private UserEducateExpDao userEducateExpDao;
	private UserProjectExpDao userProjectExpDao;
	private UserAbilityDao userAbilityDao;
	private UserJobIntentDao userJobIntentDao;
	private DictionaryDao dicDao;
	private JobDao jobDao;
	
	
	@Override
	public void addUserInfo(UserInfoVO userInfoVO) {
		if(userInfoVO!=null){
			UserInfo userInfo=new UserInfo();
			BeanUtils.copyProperties(userInfoVO, userInfo);
			Integer userAge=Math.round( (new Date().getTime() - userInfoVO.getUserBirthday().getTime())/(1000*60*60*24)/365L); 
			userInfo.setUserAge(userAge);
			this.userInfoDao.add(userInfo);
		}
	}
	@Override
	public void updateUserInfo(UserInfoVO userInfoVO) {
		if(userInfoVO!=null){
			UserInfo userInfo=this.userInfoDao.findUserInfoByUserId(userInfoVO.getUserId());
			if(userInfo!=null){
				userInfoVO.setAddTime(userInfo.getAddTime());
				BeanUtils.copyProperties(userInfoVO, userInfo);
				Integer userAge=Math.round( (new Date().getTime() - userInfoVO.getUserBirthday().getTime())/(1000*60*60*24)/365L); 
				userInfo.setUserAge(userAge);
				this.userInfoDao.update(userInfo);
			}
		}
	}
	@Override
	public UserInfo getUserInfoByUserId(Long userId) {
		return this.userInfoDao.findUserInfoByUserId(userId);
	}
	@Override
	public void addUserWorkExp(UserWorkExpVO userWorkExpVO) {
		if(userWorkExpVO!=null){
			userWorkExpVO.setServiceLen((userWorkExpVO.getLeaveDate().getTime()-userWorkExpVO.getOndutyDate().getTime())/(1000.0*60.0*60.0*24.0)/365.0);
			UserWorkExp userWorkExp=new UserWorkExp();
			BeanUtils.copyProperties(userWorkExpVO, userWorkExp);
			this.userWorkExpDao.add(userWorkExp);
		}
	}
	@Override
	public void updateUserWorkExp(UserWorkExpVO userWorkExpVO) {
		if(userWorkExpVO!=null){
			UserWorkExp userWorkExp=this.userWorkExpDao.getUserWorkExpById(userWorkExpVO.getId());
			if(userWorkExp!=null){
				userWorkExpVO.setAddTime(userWorkExp.getAddTime());
				userWorkExpVO.setServiceLen((userWorkExpVO.getLeaveDate().getTime()-userWorkExpVO.getOndutyDate().getTime())/(1000.0*60.0*60.0*24.0)/365.0);
				BeanUtils.copyProperties(userWorkExpVO, userWorkExp);
			}
			
			this.userWorkExpDao.update(userWorkExp);
		}
	}
	@Override
	public void deleteUserWorkExp(Long id) {
		this.userWorkExpDao.delete(id);
	}
	@Override
	public List<UserWorkExpVO> findUserWorkExpVOListByUserId(Long userId) {
		 List<UserWorkExp> list=this.userWorkExpDao.findUserWorkExpListByUserId(userId);
		 List<UserWorkExpVO> volist=new ArrayList<UserWorkExpVO>();
		 if(list!=null&&list.size()>0){
			 for(UserWorkExp wexp:list){
				 UserWorkExpVO vo=new UserWorkExpVO();
				 BeanUtils.copyProperties(wexp, vo);
				 volist.add(vo);
			 }
		 }
		 return volist;
	}
	@Override
	public List<UserWorkExp> findUserWorkExpListByUserId(Long userId) {
		 List<UserWorkExp> list=this.userWorkExpDao.findUserWorkExpListByUserId(userId);
		 return list;
	}
	
	@Override
	public UserWorkExpVO getUserWorkExpVOById(Long id) {
		UserWorkExpVO vo=new UserWorkExpVO();
		UserWorkExp workexp=this.userWorkExpDao.getUserWorkExpById(id);
		if(workexp!=null){
			BeanUtils.copyProperties(workexp, vo);
			vo.setOndutyYear(DateUtils.formatDate(workexp.getOndutyDate(), "yyyy"));
			vo.setOndutyMonth(DateUtils.formatDate(workexp.getOndutyDate(), "M"));
			vo.setLeaveYear(DateUtils.formatDate(workexp.getLeaveDate(), "yyyy"));
			vo.setLeaveMonth(DateUtils.formatDate(workexp.getLeaveDate(), "M"));
			if(workexp.getIsLastJob()==1){
				vo.setLastJob(true);
				vo.setNowdate(true);
			}else{
				vo.setLastJob(false);
				vo.setNowdate(false);
			}
		}
		return vo;
	}
	
	@Override
	public void addUserEducateExp(UserEducateExpVO userEducateExpVO) {
		if(userEducateExpVO!=null){
			UserEducateExp userEducateExp=new UserEducateExp();
			School school=this.dicDao.findSchoolByName(userEducateExpVO.getSchoolName());
			if(school!=null){
				userEducateExpVO.setSchoolId(school.getId());
			}
			Major major=this.dicDao.findMajorByName(userEducateExpVO.getMajorName());
			if(major!=null){
				userEducateExpVO.setMajorId(major.getId());
			}
			BeanUtils.copyProperties(userEducateExpVO, userEducateExp);
			this.userEducateExpDao.add(userEducateExp);
		}
	}
	@Override
	public void updateUserEducateExp(UserEducateExpVO userEducateExpVO) {
		if(userEducateExpVO!=null){
			UserEducateExp userEducateExp=this.userEducateExpDao.getUserEducateExpById(userEducateExpVO.getId());
			if(userEducateExp!=null){
				userEducateExpVO.setAddTime(userEducateExp.getAddTime());
				School school=this.dicDao.findSchoolByName(userEducateExpVO.getSchoolName());
				if(school!=null){
					userEducateExpVO.setSchoolId(school.getId());
				}
				Major major=this.dicDao.findMajorByName(userEducateExpVO.getMajorName());
				if(major!=null){
					userEducateExpVO.setMajorId(major.getId());
				}
				BeanUtils.copyProperties(userEducateExpVO, userEducateExp);
			}
			
			this.userEducateExpDao.update(userEducateExp);
		}
	}
	@Override
	public void deleteUserEducateExp(Long id) {
		this.userEducateExpDao.delete(id);
	}
	@Override
	public List<UserEducateExpVO> findUserEducateExpVOListByUserId(Long userId) {
		 List<UserEducateExp> list=this.userEducateExpDao.findUserEducateExpListByUserId(userId);
		 List<UserEducateExpVO> volist=new ArrayList<UserEducateExpVO>();
		 if(list!=null&&list.size()>0){
			 for(UserEducateExp wexp:list){
				 UserEducateExpVO vo=new UserEducateExpVO();
				 BeanUtils.copyProperties(wexp, vo);
				 volist.add(vo);
			 }
		 }
		 return volist;
	}
	@Override
	public List<UserEducateExp> findUserEducateExpListByUserId(Long userId) {
		 List<UserEducateExp> list=this.userEducateExpDao.findUserEducateExpListByUserId(userId);
		 return list;
	}
	
	@Override
	public UserEducateExp findUserTopEducateExpByUserId(Long userId) {
		return this.userEducateExpDao.findUserTopEducateExpByUserId(userId);
	}
	
	@Override
	public UserEducateExpVO getUserEducateExpVOById(Long id) {
		UserEducateExpVO vo=new UserEducateExpVO();
		UserEducateExp educateExp=this.userEducateExpDao.getUserEducateExpById(id);
		if(educateExp!=null){
			BeanUtils.copyProperties(educateExp, vo);
			vo.setBeginYear(DateUtils.formatDate(educateExp.getBeginDate(), "yyyy"));
			vo.setBeginMonth(DateUtils.formatDate(educateExp.getBeginDate(), "M"));
			vo.setEndYear(DateUtils.formatDate(educateExp.getEndDate(), "yyyy"));
			vo.setEndMonth(DateUtils.formatDate(educateExp.getEndDate(), "M"));
		}
		return vo;
	}
	
	@Override
	public List<String> findCompanyListByTip(String tipCompanyName) {
		 List<String> result=new  ArrayList<String>();
		List<Company> list=this.dicDao.findCompanyListByTip(tipCompanyName);
		if(list!=null&&list.size()>0){
			for(Company com:list){
				result.add(com.getName());
			}
		}
		return result;
	}
	
	@Override
	public List<String> findJobListByTip(String tipJobName) {
		 List<String> result=new  ArrayList<String>();
		List<Job> list=this.jobDao.findJobListByName(tipJobName);
		if(list!=null&&list.size()>0){
			for(Job job:list){
				result.add(job.getJobName());
			}
		}
		return result;
	}	
	
	@Override
	public List<String> findSchoolListByTip(String tipSchoolName) {
		 List<String> result=new  ArrayList<String>();
		List<School> list=this.dicDao.findSchoolListByTip(tipSchoolName);
		if(list!=null&&list.size()>0){
			for(School school:list){
				result.add(school.getName());
			}
		}
		return result;
	}
	
	@Override
	public List<String> findMajorListByTip(String tipMajorName) {
		 List<String> result=new  ArrayList<String>();
		List<Major> list=this.dicDao.findMajorListByTip(tipMajorName);
		if(list!=null&&list.size()>0){
			for(Major major:list){
				result.add(major.getName());
			}
		}
		return result;
	}	
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public UserWorkExpDao getUserWorkExpDao() {
		return userWorkExpDao;
	}
	public void setUserWorkExpDao(UserWorkExpDao userWorkExpDao) {
		this.userWorkExpDao = userWorkExpDao;
	}
	public UserEducateExpDao getUserEducateExpDao() {
		return userEducateExpDao;
	}
	public void setUserEducateExpDao(UserEducateExpDao userEducateExpDao) {
		this.userEducateExpDao = userEducateExpDao;
	}
	public UserProjectExpDao getUserProjectExpDao() {
		return userProjectExpDao;
	}
	public void setUserProjectExpDao(UserProjectExpDao userProjectExpDao) {
		this.userProjectExpDao = userProjectExpDao;
	}
	public UserAbilityDao getUserAbilityDao() {
		return userAbilityDao;
	}
	public void setUserAbilityDao(UserAbilityDao userAbilityDao) {
		this.userAbilityDao = userAbilityDao;
	}
	public UserJobIntentDao getUserJobIntentDao() {
		return userJobIntentDao;
	}
	public void setUserJobIntentDao(UserJobIntentDao userJobIntentDao) {
		this.userJobIntentDao = userJobIntentDao;
	}
	public DictionaryDao getDicDao() {
		return dicDao;
	}
	public void setDicDao(DictionaryDao dicDao) {
		this.dicDao = dicDao;
	}
	public JobDao getJobDao() {
		return jobDao;
	}
	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	
}
