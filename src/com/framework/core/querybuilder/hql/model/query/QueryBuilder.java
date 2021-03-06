package com.framework.core.querybuilder.hql.model.query;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.framework.core.querybuilder.hql.model.query.criterion.Criterion;
import com.framework.core.querybuilder.hql.model.query.criterion.Expression;
import com.framework.core.querybuilder.hql.model.query.criterion.MatchMode;
import com.framework.core.querybuilder.hql.model.query.support.QueryHelper;

/**
 * 功能:动态HQL语句生成器。根据用户的表单输入参数构造HQL查询语句。
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:20:52 PM
 */
public class QueryBuilder {
	private StringBuffer queryBuffer = new StringBuffer(50);
	
	/**
	 * originality query params from query input page or valid query params from list page
	 * key:	input text name of query input form
	 * value: user input value
	 */
	private Map queryParams;
	
	/**
	 *  HQL namedParam query 
	 *  key: name of hql's parameter
	 *  value: the value of the parameter(user input value)
	 */
	private Map namedQueryParams = new HashMap();

	/**
	 * Valid user imput query params
	 * key: the input field(e.g. input text)'s name
	 * value: the value of the parameter(String Type)
	 */
	private Map validQueryParams = new HashMap();
	
	/**
	 * @param queryParams 查询参数
	 */
	public QueryBuilder(Map queryParams) {
		this.queryParams = queryParams == null 
						 ? Collections.EMPTY_MAP
					     : queryParams;
	}
	
	public Map getQueryParams() {
		return queryParams;
	}
	
	public Map getValidQueryParams() {
		return validQueryParams;
	}

	/**
	 * Get HQL's named query parameters
	 * @return
	 */
	public Map getNamedQueryParams() {
		return namedQueryParams;
	}
	
	/**
	 * Add the parameter to validQueryParams.
	 * the added paramter will be included in return value of 
	 * <code>getQueryParamsAsString()</code>
	 * This method will not affect nameQueryParams.
	 * 
	 * @param key
	 * @param value
	 */
	public void addValidQueryParam(String key, String value) {
		validQueryParams.put(key, value);
	}
	
	/**
	 * Translate the valid input query parameters into a String
	 * @return the String representation of validQueryParams
	 */
	public String getQueryParamsAsString() {
		StringBuffer params = new StringBuffer(30);
		String key, value;
		for (Iterator it = validQueryParams.keySet().iterator(); it.hasNext();) {
			key = (String) it.next();
			value = (String) validQueryParams.get(key);
			params.append(key).append("=").append(value);
//			if (it.hasNext()) {
				params.append("&");
//			}
		}
		// add extral value(used in web page)
		params.append("hasQueried=true");
		return params.toString();
	}
	
	/**
	 * Add a Criterion to constrain the results to be retrieved. 
	 * @param criterion
	 * @return QueryBuilder
	 */
	public QueryBuilder add(Criterion criterion) {
		if (criterion == null) {
			return this;
		}
		
		String hql = criterion.toHqlString(this);
		
		if (QueryHelper.isValidHql(hql)) {
			buildAnd();
			buildString(hql);
		}
		
		return this;
	}
	
	/**
	 * 构造HQL between 语句.
	 * the build hql String will be like:
	 * <pre>
	 * 		hqlName between :hqlName_beginParamKey and :hqlName_endParamKey
	 * </pre>
	 * A whitespace " " will be append before and after the between query string. 
	 * 
	 * @param hqlName hql parameter name in the hql string
	 * @param beginParamKey 开始参数值在<code>queryParams</code>中的key
	 * @param endParamKey   结束参数值在<code>queryParams</code>中的key
	 * @return QueryBuilder
	 */ 
	public QueryBuilder buildBetween(String hqlName, String beginParamKey, String endParamKey) {
		return buildBetween(hqlName, beginParamKey, endParamKey, String.class);
	}
	
	public QueryBuilder buildBetween(String hqlName, String beginParamKey, String endParamKey, Class convertClass) {
		return add(Expression.between(hqlName, beginParamKey, endParamKey, convertClass));
	}
	
	public QueryBuilder buildBetweenTime(String hqlName, String beginParamKey, String endParamKey) {
		return add(Expression.betweenTime(hqlName, beginParamKey, endParamKey,String.class));
	}
	
	/**
	 * 构造HQL equal 语句.
	 * the build hql String will be like:
	 * <pre>
	 * 		hqlName = :hqlName
	 * </pre>
	 * A whitespace " " will be append before and after the equal query string. 
     * 
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数值在<code>queryParams</code>中的key,
     *        The paramValue associate with paramKey must be <code>java.lang.String</code> type
	 * @return QueryBuilder
	 */
	public QueryBuilder buildEqual(String hqlName, String paramKey) {
        return buildEqual(hqlName, paramKey, String.class);
	}
    
    /**
     * @param paramClass the paramter class type
     * @see #buildEqual
     */
    public QueryBuilder buildEqual(String hqlName, String paramKey, Class paramClass) {
        return add(Expression.equal(hqlName, paramKey, paramClass));
    }
	
	/**
	 * Build a "greater than or equal" constraint to the named property
	 * 
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数值在<code>queryParams</code>中的key
     *        The paramValue associate with paramKey must be <code>java.lang.String</code> type
	 * @return QueryBuilder
	 */
	public QueryBuilder buildGE(String hqlName, String paramKey) {
		return buildGE(hqlName, paramKey, String.class);
	}
	
	public QueryBuilder buildGE(String hqlName, String paramKey, Class paramClass) {
	    return add(Expression.ge(hqlName, paramKey, paramClass));
	}
    
	/**
	 * Build a "less than or equal" constraint to the named property
	 * 
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数值在<code>queryParams</code>中的key
	 * @return QueryBuilder
	 */
	public QueryBuilder buildLE(String hqlName, String paramKey) {
		return buildLE(hqlName, paramKey, String.class);
	}
	
	public QueryBuilder buildLE(String hqlName, String paramKey, Class paramClass) {
	    return add(Expression.le(hqlName, paramKey, paramClass));
	}
    
	/**
	 * Build a in expression
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数值在<code>queryParams</code>中的key,
	 * 		参数值必须为以<tt>,</tt>分隔的字符串, 如"1,2,3"
	 * @return QueryBuilder
	 */
	public QueryBuilder buildIn(String hqlName, String paramKey) {
		return buildIn(hqlName, paramKey, String.class);
	}
    
    public QueryBuilder buildIn(String hqlName, String paramKey, Class paramClass) {
        return add(Expression.in(hqlName, paramKey, paramClass));
    }
	
	/**
	 * 构造HQL like 语句.
	 * the build hql String will be like:
	 * <pre>
	 * 		hqlName = :hqlName
	 * </pre>
	 * the namedParem value will be like:
	 * <pre>%paramValue%</pre>
	 * 
	 * A whitespace " " will be append before and after the like query string. 
	 * 
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数在queryParams中的键值，以String类型处理
	 * @return QueryBuilder
	 */
	public QueryBuilder buildLike(String hqlName, String paramKey) {
		return buildLike(hqlName, paramKey, String.class);
	}
    
    public QueryBuilder buildLike(String hqlName, String paramKey, Class paramClass) {
        return add(Expression.like(hqlName, paramKey, MatchMode.ANYWHERE, paramClass));
    }
	
	/**
	 * 构造HQL like 语句.
	 * the build hql String will be like:
	 * <pre>
	 * 		hqlName = :hqlName
	 * </pre>
	 * the namedParem value will be like:
	 * <pre>%paramValue</pre>
	 * 
	 * A whitespace " " will be append before and after the like query string. 
	 * 
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数在queryParams中的键值，以String类型处理
	 * @return QueryBuilder
	 */
	public QueryBuilder buildLeftPaddingLike(String hqlName, String paramKey) {
		return buildLeftPaddingLike(hqlName, paramKey, String.class);
	}
    
    public QueryBuilder buildLeftPaddingLike(String hqlName, String paramKey, Class paramClass) {
        return add(Expression.like(hqlName, paramKey, MatchMode.END, paramClass));
    }
	
	/**
	 * 构造HQL like 语句.
	 * the build hql String will be like:
	 * <pre>
	 * 		hqlName = :hqlName
	 * </pre>
	 * the namedParem value will be like:
	 * <pre>paramValue%</pre>
	 * 
	 * A whitespace " " will be append before and after the like query string. 
	 * 
	 * @param hqlName hql parameter name in the hql string
	 * @param paramKey 参数在queryParams中的键值，以String类型处理
	 * @return QueryBuilder
	 */
	public QueryBuilder buildRightPaddingLike(String hqlName, String paramKey) {
		return buildRightPaddingLike(hqlName, paramKey, String.class);
	}
	
	public QueryBuilder buildRightPaddingLike(String hqlName, String paramKey, Class paramClass) {
	    return add(Expression.like(hqlName, paramKey, MatchMode.START, paramClass));
	}
    
	/**
	 * Append the string to the query String
	 * NO whitespace " " will be appended before or after the string.
	 * 
	 * buildString 主要用于编写自定义hql语句,如：
	 * <pre>
	 * 	queryBuilder.buildString("from User user")
	 * 		.buildWhere()
	 * 		.buildString(" user.name = :name ")
	 * 		.buildString(" order by user.name ")
	 * </pre>
	 * 
	 * @param string
	 * @return QueryBuilder
	 */
	public QueryBuilder buildString(String string) {
		queryBuffer.append(string);
		return this;
	}
	
	/**
	 * 生成where条件语句，缺省增加了 <t>1=1<t> 条件
	 * A whitespace " " will be append before and after the where string.
	 * 
	 * @return QueryBuilder
	 */
	public QueryBuilder buildWhere() {
		// 同时增加 缺省条件
		queryBuffer.append(" where 1=1 ");
		return this;
	}
	
	/**
	 * 生成query String
	 * @return
	 */
	public String endBuild() {
		return queryBuffer.toString();
	}
	
	/**
	 * 在queryBuffer 中增加 " and " 字符
	 * @return QueryBuilder
	 */
	private QueryBuilder buildAnd() {
		queryBuffer.append(" and ");
		return this;
	}
	
}
