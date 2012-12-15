package com.framework.core.querybuilder.hql.model.query.support;

import org.apache.commons.lang.StringUtils;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:20:28 PM
 */
public class QueryHelper {
	
    private QueryHelper() {}
	
	public static boolean isValidHql(String hqlString) {
		boolean isBlank = StringUtils.isBlank(hqlString);
		if (isBlank) {
			return false;
		}
		// TODO (  )
		if (hqlString.equals("()")) {
			return false; 
		}
		return true;
	}
	
	// Hibernate3.0.x's default ANTLR parser has bug with doted named parameter
	public static String qualifyHql(String str) {
		return str.replace('.', '_');
	}
	
}
