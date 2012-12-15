package com.framework.core.querybuilder.hql.model.query;

import java.util.Map;

import org.apache.commons.lang.ClassUtils;

import com.framework.core.querybuilder.hql.model.query.QueryCriterion;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:20:44 PM
 */
public abstract class AbstractQueryCriterion implements QueryCriterion {
	/**
	 * HQL namedParam query parameters
	 * key: name of hql's parameter
	 * value: the value of the parameter
	 */
	protected Map namedQueryParams;
	
	protected Map queryParas;
	
	/**
	 * the String representation of validQueryParams
	 * sytax: name1=value1&name2=value2
	 */
	protected String queryParamsString;
	
	public Map getQueryParams() {
		return namedQueryParams;
	}
	
	public String getQueryParamsAsString() {
		return queryParamsString;
	}
	
	/**
	 * Default return null
	 */
	public String getCountString() {
		return null;
	}
	
	public String toString() {
		return new StringBuffer(70)
			.append(ClassUtils.getShortClassName(this.getClass()))
			.append("[QueryString=").append(getQueryString()).append(", ")
			.append("CountString=").append(getCountString()).append("]")
			.toString(); 
	}

	public Map getQueryParas() {
		return queryParas;
	}
	
}
