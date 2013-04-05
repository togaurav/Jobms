package com.ganshar.manage.web.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ganshar.user.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManageAction extends ActionSupport  {
	private final static Logger log = LogManager
			.getLogger(ManageAction.class);

	public String manage() throws Exception {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public Long getSessionUserId(){
		ActionContext ctx=ActionContext.getContext();
		Object obj=ctx.getSession().get("user");
		return obj==null?0L:((User)obj).getId();
	}
}
