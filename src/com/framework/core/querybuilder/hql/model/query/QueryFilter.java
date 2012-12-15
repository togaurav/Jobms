package com.framework.core.querybuilder.hql.model.query;

import com.framework.core.querybuilder.hql.model.query.QueryContext;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:21:55 PM
 */
public interface QueryFilter {
	
	public boolean isQueryRequired(QueryContext queryContext);
	
}
