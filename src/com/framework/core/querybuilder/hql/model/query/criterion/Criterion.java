package com.framework.core.querybuilder.hql.model.query.criterion;

import java.io.Serializable;

import com.framework.core.querybuilder.hql.model.query.QueryBuilder;

/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:18:48 PM
 */
public interface Criterion extends Serializable {
	public String toHqlString(QueryBuilder builder);
}
