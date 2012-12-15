package com.framework.util.property;

import java.util.HashSet;
import java.util.Set;

public class SysProperty {
	/** 销售人员角色名称 */
	public static String SALE_ROLE_TAG = "SALE_ROLE_TAG";
	/** 清洗审核人员角色名称 */
	public static String AUDIT_ROLE_TAG = "AUDIT_ROLE_TAG";
	/** 呼出模块树名称 */
	public static String CALLOUT_ROOT_TAG = "CALLOUT_ROOT_TAG";
	/** 呼入模块树名称*/
	public static String CALLIN_ROOT_TAG = "csctree";
	/** fe同学静态资源服务器 */
	public static String STATIC_SOURCE_SERVER = "";
	/** session的只启用memcache */
	public static String isMemCacheOnly = "false";
	/** session的只启用tomcat session */
	public static String isLocalSessionOnly = "true";

	/** 个人称谓过滤 **/
	public static String PERSONAL_NAMES = "经理,行长,副科长,老板,秘书,某特助,主任," +
			"文书,将军,总经理,分析师,财务,总裁,大师,网管,老师,技师,司长,小姐,研究员,某工," +
			"校长,教练,技术员,组长,店长,会计师,先生,培训师,代理,副总,总监,教授,部长,培训师," +
			"副总裁,司长,助理,会长,总裁助理,科长,团长,同学,协会长,司仪,医生,社长,大夫,馆长," +
			"书记,局长,政委,律师,指导员,师傅,工程师";
	public static final Set<String> personalName = new HashSet<String>();
	
	/** tinyse查询重复率阀值 **/
	public static double QUERY_THRESHOLD = 1.0;
	
	public static int HTTP_APP_MAX_CONNECTION = 26;
	public static int HTTP_TOTAL_MAX_CONNECTION = 30;
	public static int CONNECTION_ESTABLISH_TIMEOUT = 10000;
	public static int SOCKET_TIMEOUT = 10000;
	
	/*技能组配置 begin*/
	//随机技能组
	public static String SKILL_DESC_RANDOM;
	//其他技能组
	public static String SKILL_DESC_OTHER;
	/*技能组配置 end*/

	// 错误日志发件人和收件人
	public static String LOG_MAILTO;
	public static String LOG_MAILFROM;

	public String getSALE_ROLE_TAG() {
		return SALE_ROLE_TAG;
	}

	public void setSALE_ROLE_TAG(String sale_role_tag) {
		SALE_ROLE_TAG = sale_role_tag;
	}

	public String getAUDIT_ROLE_TAG() {
		return AUDIT_ROLE_TAG;
	}

	public void setAUDIT_ROLE_TAG(String audit_role_tag) {
		AUDIT_ROLE_TAG = audit_role_tag;
	}

	public String getCALLOUT_ROOT_TAG() {
		return CALLOUT_ROOT_TAG;
	}

	public void setCALLOUT_ROOT_TAG(String callout_root_tag) {
		CALLOUT_ROOT_TAG = callout_root_tag;
	}

	public String getSTATIC_SOURCE_SERVER() {
		return STATIC_SOURCE_SERVER;
	}

	public void setSTATIC_SOURCE_SERVER(String static_source_server) {
		STATIC_SOURCE_SERVER = static_source_server;
	}

	public String getIsMemCacheOnly() {
		return isMemCacheOnly;
	}

	public void setIsMemCacheOnly(String isMemCacheOnly) {
		SysProperty.isMemCacheOnly = isMemCacheOnly;
	}

	public String getIsLocalSessionOnly() {
		return isLocalSessionOnly;
	}

	public void setIsLocalSessionOnly(String isLocalSessionOnly) {
		SysProperty.isLocalSessionOnly = isLocalSessionOnly;
	}

	public int getHttp_app_max_connection() {
		return HTTP_APP_MAX_CONNECTION;
	}

	public void setHttp_app_max_connection(int http_app_max_connection) {
		SysProperty.HTTP_APP_MAX_CONNECTION = http_app_max_connection;
	}

	public int getHttp_total_max_connection() {
		return HTTP_TOTAL_MAX_CONNECTION;
	}

	public void setHttp_total_max_connection(int http_total_max_connection) {
		SysProperty.HTTP_TOTAL_MAX_CONNECTION = http_total_max_connection;
	}

	public int getConnection_establish_timeout() {
		return CONNECTION_ESTABLISH_TIMEOUT;
	}

	public void setConnection_establish_timeout(int connection_establish_timeout) {
		SysProperty.CONNECTION_ESTABLISH_TIMEOUT = connection_establish_timeout;
	}

	public int getSocket_timeout() {
		return SysProperty.SOCKET_TIMEOUT;
	}

	public void setSocket_timeout(int socket_timeout) {
		SysProperty.SOCKET_TIMEOUT = socket_timeout;
	}
	
	public String getSKILL_DESC_RANDOM() {
		return SKILL_DESC_RANDOM;
	}

	public void setSKILL_DESC_RANDOM(String skill_desc_random) {
		SKILL_DESC_RANDOM = skill_desc_random;
	}

	public String getSKILL_DESC_OTHER() {
		return SKILL_DESC_OTHER;
	}

	public void setSKILL_DESC_OTHER(String skill_desc_other) {
		SKILL_DESC_OTHER = skill_desc_other;
	}

	public String getCALLIN_ROOT_TAG() {
		return CALLIN_ROOT_TAG;
	}

	public void setCALLIN_ROOT_TAG(String callin_root_tag) {
		CALLIN_ROOT_TAG = callin_root_tag;
	}

	/**
	 * @return the pERSONAL_NAMES
	 */
	public String getPERSONAL_NAMES() {
		return PERSONAL_NAMES;
	}

	/**
	 * @param personal_names the pERSONAL_NAMES to set
	 */
	public void setPERSONAL_NAMES(String personal_names) {
		PERSONAL_NAMES = personal_names;
		
		if(personal_names!= null && personal_names.length() >0) {
			String[] names = personal_names.split(",");
			for(String name : names) {
				if(name != null && name.length() > 0) {
					name = name.trim();
					if(name.length() > 0) {
						personalName.add(name);
					}
				}
			}
		}
		
	}

	/**
	 * @return the lOG_MAILTO
	 */
	public String getLOG_MAILTO() {
		return LOG_MAILTO;
	}

	/**
	 * @param log_mailto the lOG_MAILTO to set
	 */
	public void setLOG_MAILTO(String log_mailto) {
		LOG_MAILTO = log_mailto;
	}

	/**
	 * @return the lOG_MAILFROM
	 */
	public String getLOG_MAILFROM() {
		return LOG_MAILFROM;
	}

	/**
	 * @param log_mailfrom the lOG_MAILFROM to set
	 */
	public void setLOG_MAILFROM(String log_mailfrom) {
		LOG_MAILFROM = log_mailfrom;
	}

	/**
	 * @return the qUERY_THRESHOLD
	 */
	public double getQUERY_THRESHOLD() {
		return QUERY_THRESHOLD;
	}

	/**
	 * @param query_threshold the qUERY_THRESHOLD to set
	 */
	public void setQUERY_THRESHOLD(double query_threshold) {
		QUERY_THRESHOLD = query_threshold;
	}
	
}