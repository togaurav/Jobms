package com.framework.core.querybuilder.hql.model.query.criterion;

import com.framework.core.querybuilder.hql.model.query.QueryBuilder;
import com.framework.core.querybuilder.hql.model.query.support.QueryHelper;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:18:10 PM
 */
public class LikeExpression extends SimpleExpression {
	private final MatchMode matchMode;
	
	protected LikeExpression(String hqlName, String paramKey, String operation, MatchMode matchMode, Class paramClass) {
		super(hqlName, paramKey, operation, paramClass);
		this.matchMode = matchMode;
	}

	protected void setParams(QueryBuilder builder, String value, Class clazz) {
		builder.getNamedQueryParams().put(QueryHelper.qualifyHql(hqlName), matchMode.toMatchString(value));
		builder.getValidQueryParams().put(paramKey, value);
	}
	
}
