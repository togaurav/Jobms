package com.ganshar.resume.service;

import java.util.List;
import java.util.Map;

import com.ganshar.resume.model.UserEducateExp;
import com.ganshar.resume.model.UserInfo;
import com.ganshar.resume.model.UserWorkExp;
import com.ganshar.resume.web.vo.UserEducateExpVO;
import com.ganshar.resume.web.vo.UserInfoVO;
import com.ganshar.resume.web.vo.UserWorkExpVO;

public interface ResumeService {

	public void addUserInfo(UserInfoVO userInfoVO);
	
	public void updateUserInfo(UserInfoVO userInfoVO);
	
	public UserInfo getUserInfoByUserId(Long userId);
	
	public void addUserWorkExp(UserWorkExpVO userWorkExpVO); 
	
	public void updateUserWorkExp(UserWorkExpVO userWorkExpVO);
	
	public void deleteUserWorkExp(Long id);
	
	public UserWorkExpVO getUserWorkExpVOById(Long id);
	
	public List<UserWorkExpVO> findUserWorkExpVOListByUserId(Long userId);
	
	public List<UserWorkExp> findUserWorkExpListByUserId(Long userId);
	
	public void addUserEducateExp(UserEducateExpVO userEducateExpVO); 
	
	public void updateUserEducateExp(UserEducateExpVO userEducateExpVO);
	
	public void deleteUserEducateExp(Long id);
	
	public UserEducateExpVO getUserEducateExpVOById(Long id);
	
	public List<UserEducateExpVO> findUserEducateExpVOListByUserId(Long userId);
		
	public List<UserEducateExp> findUserEducateExpListByUserId(Long userId);
	
	public UserEducateExp findUserTopEducateExpByUserId(Long userId);
	
	public List<String> findCompanyListByTip(String tipCompanyName);
	
	public List<String> findJobListByTip(String tipJobName);
}
