/**
 * 
 */
package com.framework.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengyunfeng
 * @version 1.0.0
 */
public class Constants {

	public static final Integer ZERO = Integer.valueOf(0);

	public static final List ZERO_LIST = new ArrayList(0);

	public final static String FILE_PATH_PREF = "/WEB-INF/classes/";

	/**
	 * result type --json
	 */
	public static final String JSON = "json";

	public static final int JSON_OPERATE_SUCCESS = 0;

	public static final int JSON_OPERATE_FAILED = 1;

	/**
	 * 日志类中发送报警邮件的From
	 */
	public static String LOG_MAILFROM = "beidou-error@baidu.com";
	/**
	 * 日志类中发送报警邮件的to列表
	 */

	public static String LOG_MAILTO = "zhangpeng@baidu.com";

	public static String BUSINESS_MAILFROM = "nrhelp@baidu.com";

	/**
	 * 日志类中发送报警邮件的title
	 */
	public static final String LOGUTILS_MAILTITLE = "fatal message mail ";
	/**
	 * 组装多接受人时的email分隔符
	 */
	public static final String MAILLIST_DILIM = ",";

	public static final double GC_MEMORY_PERCENT = 0.5;

	/**
	 * @return the lOG_MAILFROM
	 */
	public static String getLOG_MAILFROM() {
		return LOG_MAILFROM;
	}

	/**
	 * @param log_mailfrom
	 *            the lOG_MAILFROM to set
	 */
	public static void setLOG_MAILFROM(String log_mailfrom) {
		LOG_MAILFROM = log_mailfrom;
	}

	/**
	 * @return the lOG_MAILTO
	 */
	public static String getLOG_MAILTO() {
		return LOG_MAILTO;
	}

	/**
	 * @param log_mailto
	 *            the lOG_MAILTO to set
	 */
	public static void setLOG_MAILTO(String log_mailto) {
		LOG_MAILTO = log_mailto;
	}

	/**
	 * 页面的时间查询范围：昨日
	 */
	public static final String PAGE_DATE_RANGE_YESTERDAY = "yesterday";
	/**
	 * 页面的时间查询范围：前7天
	 */
	public static final String PAGE_DATE_RANGE_LAST7DAYS = "last7Days";
	/**
	 * 页面的时间查询范围：上周
	 */
	public static final String PAGE_DATE_RANGE_LASTWEEK = "lastWeek";
	/**
	 * 页面的时间查询范围：上月
	 */
	public static final String PAGE_DATE_RANGE_LASTMONTH = "lastMonth";

	/**
	 * 页面的时间查询范围：所有时间
	 */
	public static final String PAGE_DATE_RANGE_ALLDATE = "allDate";

	/**
	 * 页面的时间查询范围为所有时间时的起始时间
	 */
	public static final String PAGE_DATE_ALLDATE_START = "20081113";

	/**
	 * 页面的时间查询范围：本月
	 */
	public static final String PAGE_DATE_RANGE_THISMONTH = "thisMonth";

	/**
	 * 当前请求是否为json请求，存入context的名称
	 */
	public static final String INTERCEPTOR_JSON_NAME = "INTERCEPTOR_JSON_ENABLE";

	/**
	 * 帮助中心域名
	 */
	public static String HELP_DOMAIN = "";

	/**
	 * 帮助邮件接收人
	 */
	public static String HELP_MAIL = "";

	/**
	 * 判断是否为内容网络首页标签
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAccount(String request) {
		if (isCproPlan(request) || isMyaccount(request) || isReport(request)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否为内容网络管理标签
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isCproPlan(String request) {
		if (request.startsWith("/cprounit/")) {
			return true;
		} else if (request.startsWith("/cprogroup/")) {
			return true;
		} else if (request.startsWith("/cproplan/")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为我的帐户标签
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isMyaccount(String request) {
		if (request.startsWith("/bulletin/")) {
			return true;
		} else if (request.startsWith("/account/")) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为我的帐户标签
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isReport(String request) {
		if (request.startsWith("/stat/")) {
			return true;
		}
		return false;
	}

	/**
	 * 默认每页显示数据行数<br>
	 * add by Mazhy
	 */
	public static final Long PAGESIZE_DEFAULT = 10L;
	/**
	 * 首页页码<br>
	 * add by Mazhy
	 */
	public static final Long FIRST_PAGE_NUMBER = 1L;
}
