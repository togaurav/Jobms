package com.framework.web.interceptor;

import java.util.Map;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:36:57 PM
 */
public interface QueryParameterAware {

	/**
	 * 查询参数,如果请求来自查询输入页面,则值为ServletRequest的参数
	 * 否则(翻页/排序)为表单中的encodedQueryParams隐藏属性值 (Interceptor注入)
	 */
	public void setQueryParameters(Map queryParams);
	
	/**
	 * 查询参数的字符表示形式
	 * @return
	 */
	public String getEncodedQueryParams();
	
}
