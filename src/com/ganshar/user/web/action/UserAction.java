package com.ganshar.user.web.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private final static Logger log = LogManager
			.getLogger(UserAction.class);
	
	protected UserService userService;

	public String home() throws Exception {
		try {
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String showedu() throws Exception {
		try {
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
