package com.framework.core.querybuilder.hql.model.query.support;

import com.framework.core.querybuilder.hql.model.query.QueryContext;
import com.framework.core.querybuilder.hql.model.query.QueryFilter;
import com.framework.web.interceptor.QueryParameterAware;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:20:35 PM
 */
public class SimpleQueryFilter implements QueryFilter {
	private boolean requried = true;
	
	public boolean isQueryRequired(QueryContext queryContext) {
		QueryParameterAware action = queryContext.getAction();
		if (action instanceof QueryFilter) {
			requried = ((QueryFilter) action).isQueryRequired(queryContext); 
		}
		return requried && new ParameterQueryFilter().isQueryRequired(queryContext);
	}

}
