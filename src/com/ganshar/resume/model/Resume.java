package com.ganshar.resume.model;

import java.util.List;

public class Resume {

	private Long userId;
	private UserInfo userInfo;
	private List<UserWorkExp> userWorkExpList;
	private List<UserEducateExp> userEducateExpList;
	private List<UserAbility> userAbilityList;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public List<UserWorkExp> getUserWorkExpList() {
		return userWorkExpList;
	}
	public void setUserWorkExpList(List<UserWorkExp> userWorkExpList) {
		this.userWorkExpList = userWorkExpList;
	}
	public List<UserEducateExp> getUserEducateExpList() {
		return userEducateExpList;
	}
	public void setUserEducateExpList(List<UserEducateExp> userEducateExpList) {
		this.userEducateExpList = userEducateExpList;
	}
	public List<UserAbility> getUserAbilityList() {
		return userAbilityList;
	}
	public void setUserAbilityList(List<UserAbility> userAbilityList) {
		this.userAbilityList = userAbilityList;
	}
	
	
}
