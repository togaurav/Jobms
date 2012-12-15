/**
 * 
 */
package com.framework.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * ResultSet到自定义类的映射接口，加入了泛型。
 * 
 * @author zengyunfeng
 * @version 1.0.0
 */
public interface GenericRowMapping<T> extends RowMapper {
	public T mapRow(ResultSet arg0, int arg1) throws SQLException ;
}
