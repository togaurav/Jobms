package com.framework.core.querybuilder.hql.model.query;

import java.util.Map;


/**
 * 功能:查询条件
 * 		所有查询对象必须实现此接口,可继承AbstractQueryCriterion
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:21:10 PM
 */
public interface QueryCriterion {
	/**
	 * 用户查询参数值在表单中的名称
	 */
	public static final String QUERY_PARAMS_KEY = "encodedQueryParams";
	
	/**
	 * 返回hql查询语句, hql使用namedParam方式编写
	 * @return
	 */
	public String getQueryString();
	
	/**
	 * 返回统计语句,hql使用namedParam方式编写
	 * 该语句和getQueryString()的语句应一致
	 * @return
	 */
	public String getCountString();
	
	/**
	 * HQL namedParam parameters
	 * key: namedParam query name
	 * value: query value(user input value)
	 */
	public Map getQueryParams();
	
	/**
	 * 以字符的形式返回用户查询条件
	 * 
	 * syntax: param1=value1&param2=value2&param3=value3
	 * 其中:param1是查询条件输入表单该字段对应的名称, value1为用户输入的值
	 */
	public String getQueryParamsAsString();
	
	/**
	 * 获取查询参数对象
	 * @return
	 */
	public Map getQueryParas();
	
}
