package com.framework.core.querybuilder.hql.struts2.interceptor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.core.querybuilder.hql.model.query.QueryContext;
import com.framework.core.querybuilder.hql.model.query.QueryCriterion;
import com.framework.core.querybuilder.hql.model.query.QueryFilter;
import com.framework.core.querybuilder.hql.model.query.support.SimpleQueryFilter;
import com.framework.core.querybuilder.hql.struts2.util.WebUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * 功能:查询参数拦截器
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:36:06 PM
 */
public class QueryParameterInterceptor implements Interceptor {
private static final Log log = LogFactory.getLog(QueryParameterInterceptor.class);
	
	// result type name of webwork
	private static final String QUERYREQUIRED = "queryrequired";
	
	public void init() {
	}

	public void destroy() {
	}
	
	/**
	 * if the action implements QueryParameterAware
	 * then
	 *    if encodedQueryParams is not null in ServletRequest
	 *        get the value from encodedQueryParams form hidden property
	 *    else
	 *        if has queryRequired request parameter and the value is ture
	 *            return to the queryRequired page
	 *        else
	 *        	  get the values in ServletRequest
	 * set the values to the action 
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		Action action = (Action)invocation.getAction();
		if (action instanceof QueryParameterAware) {
			return doIntercept(invocation, (QueryParameterAware) action);
		}
		return invocation.invoke();
	}
	
	protected String doIntercept(ActionInvocation invocation, QueryParameterAware action) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Beging interceptor QueryParameterAware for " + action.getClass());
		}
		
		Map requestParams = ActionContext.getContext().getParameters();
		Map queryParams = new HashMap();
		
		String encodedQueryParams = WebUtils.getRequestParameter(requestParams, QueryCriterion.QUERY_PARAMS_KEY);
		if (log.isDebugEnabled()) {
			log.debug("encodedQueryParams=" + encodedQueryParams);
		}
		
		if (StringUtils.isNotBlank(encodedQueryParams)) {
			// 表单中有 查询参数 hidden 属性 （查询翻页，查询参数状态保存）
			// convert String to Map
			if (log.isDebugEnabled()) log.debug("Set QueryParameterAware's queryParams with encodedQueryParams");
			
			String[] nameValuePairs = StringUtils.split(encodedQueryParams, '&');
			if (nameValuePairs != null) {
				for (int i = 0; i < nameValuePairs.length; i++) {
					addParam(queryParams, nameValuePairs[i]);
					if (log.isDebugEnabled()) log.debug("Set queryParams with encodedQueryParams:[" + nameValuePairs[i] + "]");
				}
			}
		} else {
			// query requied
			// 使用 HttpRequest 的参数，（用户查询提交页面） 
			if (log.isDebugEnabled()) log.debug("Set QueryParameterAware's queryParams with ServletRequest's parameters");
			
			String key, value;
			for (Iterator it = requestParams.keySet().iterator(); it.hasNext();) {
				key = (String) it.next();
				value = WebUtils.getRequestParameter(requestParams, key);
				queryParams.put(key, value);
				if (log.isDebugEnabled()) log.debug("Set queryParams with HttpRequest parameter:[" + key + "=" + value + "]");
			}
		}
		
		action.setQueryParameters(queryParams);
		if (log.isDebugEnabled()) log.debug("Set QueryParameterAware's queryParams with value: " + queryParams);
		
		// dispatch queryRequired page
		QueryContext queryContext = new QueryContext(action, requestParams);
		QueryFilter queryFilter = new SimpleQueryFilter();
		if (StringUtils.isBlank(encodedQueryParams)	&& queryFilter.isQueryRequired(queryContext)) {
			if (log.isDebugEnabled()) {
				log.debug("Query required for this request, dispatche to queryrequired page");
				log.debug("End interceptor QueryParameterAware for " + action.getClass());
			}
			return QUERYREQUIRED;
		}
		
		if (log.isDebugEnabled()) log.debug("End interceptor QueryParameterAware for " + action.getClass());
		return invocation.invoke();
	}
	
	private void addParam(Map queryParams, String nameValuePair) {
		String[] nameValue = StringUtils.split(nameValuePair, '=');
		if (nameValue != null && nameValue.length == 2 && !nameValue.equals("hasQueried")) {
			queryParams.put(nameValue[0], nameValue[1]);
		}
	}


}
