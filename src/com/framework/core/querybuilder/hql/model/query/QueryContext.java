package com.framework.core.querybuilder.hql.model.query;

import java.util.Map;

import com.framework.core.querybuilder.hql.struts2.interceptor.QueryParameterAware;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:21:01 PM
 */
public class QueryContext {
	private QueryParameterAware action;
	private Map requestParams;
	
	public QueryContext(QueryParameterAware action, Map requestParams) {
		this.action = action;
		this.requestParams = requestParams;
	}

	public QueryParameterAware getAction() {
		return action;
	}

	public Map getRequestParams() {
		return requestParams;
	}

	public String toString() {
		return new StringBuffer()
			.append("QueryContext[action=").append(action)
			.append(", requestParams=").append(requestParams)
			.append("]").toString();
	}
	

}
