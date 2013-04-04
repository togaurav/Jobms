package com.ganshar.user.web.action;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.ganshar.user.model.User;
import com.ganshar.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport  implements SessionAware{
	private final static Logger log = LogManager
			.getLogger(LoginAction.class);
	
	protected UserService userService;
	
	private String email;
	private String password;
	private String name;
	private Map sessionmap;
	private String result;

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map getSessionmap() {
		return sessionmap;
	}

	public void setSessionmap(Map sessionmap) {
		this.sessionmap = sessionmap;
	}

	public void setResult(String result) {
		this.result = result;
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
				this.sessionmap.put("user", user);
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
				this.sessionmap.put("user", user);
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
			Object useridobj=this.sessionmap.get("user");
			if(useridobj!=null){
				this.sessionmap.remove("user");
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
				this.sessionmap.put("user", user);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String checkEmail() throws Exception {
		try {
			if(email==null){
				this.result="<font color='red'>邮箱不能为空！</font>";
			}
			User user=this.userService.findUserByEmail(this.email.trim().toLowerCase());
			if(user!=null){
				this.result="<font color='red'>该Email已经存在！</font>";
			}else{
				this.result="<font color='green'>邮箱可以使用</font>";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String checkEmailAndPass() throws Exception {
		try {
			if(email==null||password==null){
				this.result="0";
			}
			User user=this.userService.findUserByEmailPass(email.trim().toLowerCase(), password.trim().toLowerCase());
			if(user==null){
				this.result="0";
			}else{
				this.result="1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map arg0) {
		this.sessionmap=arg0;
	}

	public String getResult() {
		return result;
	}

	public UserService getUserService() {
		return userService;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}


}
