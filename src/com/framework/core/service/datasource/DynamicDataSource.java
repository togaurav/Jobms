package com.framework.core.service.datasource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.framework.util.StringUtils;


/**
 * 取得数据源的KEY
 * 
 * @author 陆庆润 创建时间：2009-3-20
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	private final Logger log = Logger.getLogger(DynamicDataSource.class);
	/**
	 * 数据源key的存储控制器
	 */
	private DynamicDataSourceKey dataSourceKey;

	/**
	 * 获得数据源的key
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		String key = "";
		try {
			key = dataSourceKey.getKey();
		} catch (Throwable e) {
			log.error("get data source key fail,will use default data source");
		}
		if(StringUtils.isNull(key)){
			log.error("get data source key fail,use default data source");
		}
		return key;
	}

	public DynamicDataSourceKey getDataSourceKey() {
		return dataSourceKey;
	}

	public void setDataSourceKey(DynamicDataSourceKey dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}
}
