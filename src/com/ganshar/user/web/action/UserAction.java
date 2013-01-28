package com.ganshar.user.web.action;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.ganshar.user.model.User;
import com.ganshar.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport  implements SessionAware{
	private final static Logger log = LogManager
			.getLogger(UserAction.class);
	
	protected UserService userService;
	
	private String email;
	private String password;
	private String name;
	private Map sessionmap;

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 准备登录
	 */
	public String tologin() throws Exception {
		try {
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 登录
	 */
	public String login() throws Exception {
		try {
			User user=this.userService.findUserByEmailPass(this.email, this.password);
			if(user!=null){
				this.sessionmap.put("userid", user.getId());
				return SUCCESS;
			}else{
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String checkLogin() throws Exception {
		try {
			User user=this.userService.findUserByEmailPass(this.email, this.password);
			if(user!=null){
				this.sessionmap.put("userid", user.getId());
				return SUCCESS;
			}else{
				return ERROR;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 退出
	 */
	public String logout() throws Exception {
		try {
			Object useridobj=this.sessionmap.get("userid");
			if(useridobj!=null){
				this.sessionmap.remove("userid");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 准备注册
	 */
	public String toregister() throws Exception {
		try {
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 注册
	 */
	public String register() throws Exception {
		try {
			User user=this.userService.findUserByEmailPass(this.email, this.password);
			if(user!=null&&user.getId()>0){
				return ERROR;
			}else{
				user=new User();
			}
			user.setEmail(this.email);
			user.setPassword(this.password);
			user.setAddTime(new Date());
			this.userService.addUser(user);
			if(user.getId()!=null){
				this.sessionmap.put("userid", user.getId());
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map arg0) {
		this.sessionmap=arg0;
	}


}
