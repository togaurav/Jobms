/**
 * 
 */
package com.framework.web.interceptor;

import java.util.Map;

import org.apache.log4j.Logger;

import com.ganshar.match.web.action.MatchAction;
import com.ganshar.user.web.action.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author yuyang
 * 
 */
public class UserLoginCheckInterceptor extends AbstractInterceptor {

	private static Logger log = Logger.getLogger(UserLoginCheckInterceptor.class);

	  public String intercept(ActionInvocation arg0) throws Exception {
		  if (LoginAction.class == arg0.getAction().getClass()){
			  return arg0.invoke();
		  }
		  if (MatchAction.class == arg0.getAction().getClass()){
			  return arg0.invoke();
		  }
		  
		  Map map = arg0.getInvocationContext().getSession();
		  if (null == map.get("user")){
			  return Action.LOGIN;
		  }
		  
		  return arg0.invoke();
	   }

}
