package com.framework.core.querybuilder.hql.model.query.criterion;

import com.framework.core.querybuilder.hql.model.query.QueryBuilder;



/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:18:02 PM
 */
public class LogicalExpression implements Criterion {
	private final Criterion lhs;
	private final Criterion rhs;
	private final String operation;
	
	protected LogicalExpression(Criterion lhs, Criterion rhs, String operation) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.operation = operation;
	}
	
	public String getOperation() {
		return operation;
	}

	public String toHqlString(QueryBuilder builder) {
		return '(' + lhs.toHqlString(builder)
			+ ' ' +	getOperation() + ' '
			+ rhs.toHqlString(builder) + ')';
	}

}
