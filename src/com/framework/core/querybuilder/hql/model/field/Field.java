package com.framework.core.querybuilder.hql.model.field;

/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20092:39:54 PM
 */
public interface Field {

	/**
	 * The model field key e.g user.email of User(have email attribute)
	 * This id must be consistent with the HQL element when used with PaginationSupport
	 * 
	 * @return
	 */
	public String getId();

	/**
	 * descrition, usually in chinese 
	 * @return
	 */
	public String getName();
	
	/**
	 * 是否可排序
	 * @return
	 */
	public boolean isSortable();
}
