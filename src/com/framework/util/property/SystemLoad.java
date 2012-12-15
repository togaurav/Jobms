package com.framework.util.property;

import org.apache.commons.digester.Digester;
import org.springframework.beans.factory.InitializingBean;

public class SystemLoad implements InitializingBean {

	public void loadSystemConf() {
		Digester digester = new Digester();
		digester = setSystemConfRule(digester);
		try {
			digester.parse(getClass().getClassLoader().getResourceAsStream(
					"com-configure.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Digester setSystemConfRule(Digester digester) {
		digester.addObjectCreate("conf",
				"com.baidu.rigel.util.property.SysProperty", "className");
		digester.addBeanPropertySetter("conf/SALE_ROLE_TAG", "SALE_ROLE_TAG");
		digester.addBeanPropertySetter("conf/AUDIT_ROLE_TAG", "AUDIT_ROLE_TAG");
		digester.addBeanPropertySetter("conf/CALLOUT_ROOT_TAG",
				"CALLOUT_ROOT_TAG");
		digester.addBeanPropertySetter("conf/STATIC_SOURCE_SERVER",
				"STATIC_SOURCE_SERVER");
		digester.addBeanPropertySetter("conf/isMemCacheOnly", "isMemCacheOnly");
		digester.addBeanPropertySetter("conf/isLocalSessionOnly",
				"isLocalSessionOnly");
		// httpClient参数
		digester.addBeanPropertySetter("conf/connection_establish_timeout",
				"connection_establish_timeout");
		digester.addBeanPropertySetter("conf/socket_timeout", "socket_timeout");
		digester.addBeanPropertySetter("conf/http_app_max_connection",
				"http_app_max_connection");
		digester.addBeanPropertySetter("conf/http_total_max_connection",
				"http_total_max_connection");
		/*技能组配置 begin*/
		//随机技能组
		digester.addBeanPropertySetter("conf/SKILL_DESC_RANDOM",
		"SKILL_DESC_RANDOM");
		//其他技能组
		digester.addBeanPropertySetter("conf/SKILL_DESC_OTHER",
		"SKILL_DESC_OTHER");
		/*技能组配置 end*/
		digester.addBeanPropertySetter("conf/CALLIN_ROOT_TAG",
		"CALLIN_ROOT_TAG");
		/*技能组配置 end*/
		
		// 个人称谓过滤
		digester.addBeanPropertySetter("conf/PERSONAL_NAMES", "PERSONAL_NAMES");
		
		// 错误日志发件人和收件人
		digester.addBeanPropertySetter("conf/LOG_MAILTO", "LOG_MAILTO");
		digester.addBeanPropertySetter("conf/LOG_MAILFROM", "LOG_MAILFROM");
		
		// tinyse查询重复率阀值
		digester.addBeanPropertySetter("conf/QUERY_THRESHOLD", "QUERY_THRESHOLD");
		
		return digester;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		loadSystemConf();
	}
}
