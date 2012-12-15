package com.framework.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * <p>
 * Title: 日期处理工具类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: capinfo
 * </p>
 * 
 * @author getup
 * @version 1.0
 */
public class DateUtils {

	public static Date strToDate(String time) throws ParseException {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyyMMdd");

		java.util.Date d = sdf.parse(time);

		return d;
	}

	public static Date strToDate(String time, String format)
			throws ParseException {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);

		java.util.Date d = sdf.parse(time);

		return d;
	}

	public static Date strToTime(String time) throws ParseException {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyyMMdd:HH");

		java.util.Date d = sdf.parse(time);

		return d;
	}

	/**
	 * 生成当前时间对应的包含小时的时间字符串
	 * 
	 * @return String 时间字符串
	 */
	public static String getHourStr() throws ParseException {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyyMMddHH");
		return sdf.format(new Date());
	}

	/**
	 * 生成java.util.Date类型的对象
	 * 
	 * @param year
	 *            int 年
	 * @param month
	 *            int 月
	 * @param day
	 *            int 日
	 * @return Date java.util.Date类型的对象
	 */
	public static Date getDate(int year, int month, int day) {
		GregorianCalendar d = new GregorianCalendar(year, month - 1, day);
		return d.getTime();
	}

	public static Date getDate(int yyyyMMdd) {
		int dd = yyyyMMdd % 100;
		int yyyyMM = yyyyMMdd / 100;
		int mm = yyyyMM % 100;
		int yyyy = yyyyMM / 100;
		GregorianCalendar d = new GregorianCalendar(yyyy, mm - 1, dd);
		return d.getTime();
	}

	/**
	 * 生成java.util.Date类型的对象
	 * 
	 * @param year
	 *            int 年
	 * @param month
	 *            int 月
	 * @param day
	 *            int 日
	 * @param hour
	 *            int 小时
	 * @return Date java.util.Date对象
	 */
	public static Date getDate(int year, int month, int day, int hour) {
		GregorianCalendar d = new GregorianCalendar(year, month - 1, day, hour,
				0);
		return d.getTime();
	}

	/**
	 * 生成圆整至小时的当前时间 例如：若当前时间为（2004-08-01 11:30:58），将获得（2004-08-01 11:00:00）的日期对象
	 * 
	 * @return Date java.util.Date对象
	 */
	public static Date getRoundedHourCurDate() {

		Calendar cal = GregorianCalendar.getInstance();

		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);

		return cal.getTime();

	}

	/**
	 * 生成当天零时的日期对象 例如：若当前时间为（2004-08-01 11:30:58），将获得（2004-08-01 00:00:00）的日期对象
	 * 
	 * @return Date java.util.Date对象
	 */
	public static Date getRoundedDayCurDate() {
		Calendar cal = new GregorianCalendar();

		return new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).getTime();
	}

	/**
	 * 生成圆整至小时的当前时间 例如：若给定时间为（2004-08-01 11:30:58），将获得（2004-08-01 11:00:00）的日期对象
	 * 
	 * @param dt
	 *            Date java.util.Date对象
	 * @return Date java.util.Date对象
	 */
	public static Date getRoundedHourDate(Date dt) {

		Calendar cal = new GregorianCalendar();

		cal.setTime(dt);

		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);

		return cal.getTime();
	}

	/**
	 * 获得给定时间的第二天零时的日期对象 例如：若给定时间为（2004-08-01 11:30:58），将获得（2004-08-02
	 * 00:00:00）的日期对象 若给定时间为（2004-08-31 11:30:58），将获得（2004-09-01 00:00:00）的日期对象
	 * 
	 * @param dt
	 *            Date 给定的java.util.Date对象
	 * @return Date java.util.Date对象
	 */
	public static Date getNextDay(Date dt) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		return new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1)
				.getTime();

	}

	/**
	 * @param dt
	 *            Date 给定的java.util.Date对象
	 * @param weekDay
	 *            int 就是周几的”几“，周日是7
	 * @return Date java.util.Date对象
	 */
	public static Date getWeekDay(Date dt, int weekDay) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		if (weekDay == 7)
			weekDay = 1;
		else
			weekDay++;
		cal.set(GregorianCalendar.DAY_OF_WEEK, weekDay);
		return cal.getTime();
	}

	/**
	 * 获得给定时间的第N天零时的日期对象 例如：若给定时间为（2004-08-01 11:30:58），将获得（2004-08-02
	 * 00:00:00）的日期对象 若给定时间为（2004-08-31 11:30:58），将获得（2004-09-01 00:00:00）的日期对象
	 * 
	 * @param dt
	 *            Date 给定的java.util.Date对象
	 * @return Date java.util.Date对象
	 */
	public static Date getNextDay(Date dt, Long n) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);

		return new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)
				+ n.intValue()).getTime();

	}

	public static Date getNextMonth(Date dt, Long n) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);

		Calendar firstCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH)
				+ n.intValue(), 1);
		if (firstCal.getActualMaximum(Calendar.DAY_OF_MONTH) < cal
				.get(Calendar.DAY_OF_MONTH)) {
			return new GregorianCalendar(cal.get(Calendar.YEAR), cal
					.get(Calendar.MONTH)
					+ n.intValue(), firstCal
					.getActualMaximum(Calendar.DAY_OF_MONTH)).getTime();
		} else {
			return new GregorianCalendar(cal.get(Calendar.YEAR), cal
					.get(Calendar.MONTH)
					+ n.intValue(), cal.get(Calendar.DAY_OF_MONTH)).getTime();
		}

	}

	public static long getBetweenDate(Date startDate, Date endDate) {
		long startDateTime = startDate.getTime();
		long endDateTime = endDate.getTime();
		long dayTime = 24 * 60 * 60 * 1000;
		long days = (endDateTime - startDateTime) / dayTime;
		return days;
	}

	public static long getMonthLength(String countDate) throws ParseException {
		String firstDay = countDate.substring(0, countDate.length() - 2) + "01";
		Date startDate = strToDate(firstDay);
		Date endDate = getNextMonth(startDate, new Long(1));
		long startDateTime = startDate.getTime();
		long endDateTime = endDate.getTime();
		long dayTime = 24 * 60 * 60 * 1000;
		long days = (endDateTime - startDateTime) / dayTime;
		return days;
	}

	/**
	 * 获得当前时间的第二天零时的日期对象 例如：若当前时间为（2004-08-01 11:30:58），将获得（2004-08-02
	 * 00:00:00）的日期对象 若当前时间为（2004-08-31 11:30:58），将获得（2004-09-01 00:00:00）的日期对象
	 * 
	 * @return Date java.util.Date对象
	 */
	public static Date getNextDay() {

		Calendar cal = GregorianCalendar.getInstance();
		return new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1)
				.getTime();

	}

	/**
	 * 将java.util.Date类型的对象转换为java.sql.Timestamp类型的对象
	 * 
	 * @param dt
	 *            Date
	 * @return Timestamp
	 */
	public static java.sql.Timestamp convertSqlDate(Date dt) {
		if (dt == null) {
			return new java.sql.Timestamp(0);
		}
		return new java.sql.Timestamp(dt.getTime());
	}

	/**
	 * 格式化当前时间，返回如：2004年8月1日形式的字符串
	 * 
	 * @return String
	 */
	public static String formatCurrrentDate() {
		java.util.Date pdate = new Date();
		return formatDate(pdate, "yyyyMMdd");
	}

	/**
	 * 按照给定格式返回代表日期的字符串
	 * 
	 * @param pDate
	 *            Date
	 * @param format
	 *            String 日期格式
	 * @return String 代表日期的字符串
	 */
	public static String formatDate(java.util.Date pDate, String format) {

		if (pDate == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(pDate);
	}

	/**
	 * 返回给定时间的小时数 例如：时间（2004-08-01 3:12:23）将返回 03 时间（2004-08-01 19:12:23）将返回19
	 * 
	 * @param pDate
	 *            Date 给定时间
	 * @return String 代表小时数的字符串
	 */
	public static String getHour(Date pDate) {
		return formatDate(pDate, "HH");
	}

	/**
	 * 获得上一个月的最后一天
	 * 
	 * @return
	 */
	public static Calendar getTheLastDayOfTheMonth(int year, int month) {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month, 1);
		return new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH) - 1);

	}

	/**
	 * 验证字符串是不是合法的日期；严格判断日期格式YYYYMMDD的正则表达式：包括闰年的判断、大月小月的判断
	 * 
	 * @param dateString
	 *            待验证的日期字符串
	 * @return 满足则返回true，不满足则返回false
	 * @author zhangpeng mrd3.4.0
	 */
	public static boolean validateDateString(String dateString) {

		if (dateString == null || dateString.equals("")) {
			return false;
		}

		// 日期格式YYYYMMDD的正则表达式,世纪年为闰年，如2000
		String regDate = "^(((([02468][048])|([13579][26]))[0]{2})(02)(([0][1-9])|([1-2][0-9])))"
				+
				// 世纪年不为闰年如2100
				"|(((([02468][1235679])|([13579][01345789]))[0]{2})(02)(([0][1-9])|([1][0-9])|([2][0-8])))"
				+
				// 非世纪年为闰年，如1996
				"|(([0-9]{2}(([0][48])|([2468][048])|([13579][26])))(02)(([0][1-9])|([1-2][0-9])))"
				+
				// 非世纪年不为闰年，如1997
				"|(([0-9]{2}(([02468][1235679])|([13579][01345789])))(02)(([0][1-9])|([1][0-9])|([2][0-8])))"
				+
				// 大月，有31天
				"|(([0-9]{4})(([0]{1}(1|3|5|7|8))|10|12)(([0][1-9])|([1-2][0-9])|30|31))"
				+
				// 小月，只有30天
				"|(([0-9]{4})(([0]{1}(4|6|9))|11)(([0][1-9])|([1-2][0-9])|30))$";

		return dateString.matches(regDate);
	}

	/**
	 * 验证字符串是不是合法的日期；严格判断日期格式YYYYMMDD的正则表达式：包括闰年的判断、大月小月的判断
	 * 
	 * @param dateString
	 *            待验证的日期字符串
	 * @return 满足则返回true，不满足则返回false
	 * @author wangl 20090401
	 */
	public static boolean validateDateString(String dateString, String format) {

		if (dateString == null || dateString.equals("")) {
			return false;
		}
		if (format == null || format.equals("")) {
			return false;
		}
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);// 这个的功能是不把2008-13-3 转换为2009-1-3
		try {
			date = df.parse(dateString);
		} catch (Exception e) {
			// d=new Date();
			// System.out.println("你输入的日期不合法，请重新输入");
			return false;
		}
		// String sdata=df.format(d);
		// System.out.println(sdata);
		return true;
	}

	public static void main(String[] args) {

		// Calendar cal = new GregorianCalendar();
		// cal.set(2004, 8, 6);
		// Calendar cal1 = Calendar.getInstance();
		// cal1.set(2004, 8, 9);
		// System.out.println("cal1.getTime() = " + cal1.getTime());
		// LinkedHashMap r = getNullLogDateList(cal.getTime(), cal1.getTime(),
		// 2);
		// int i = 0;
		// for (Iterator iter = r.keySet().iterator(); iter.hasNext(); ) {
		// Object item = (Object) iter.next();
		// System.out.println("i++ = " + i++);
		// System.out.println("item = " + item);
		// }
		// Date d=new Date();
		// d=DateUtils.getNextDay(d,new Long(-1));
		// String date=DateUtils.formatDate(d,"yyyyMMdd");
		// System.out.println(date);

		// int year=2004;
		// for (int month=0;month<12;month++)
		// {
		// Calendar cal=DateUtils.getTheLastDayOfTheMonth(year, month);
		// Date d=cal.getTime();
		// System.out.println(DateUtils.formatDate(d,"yyyy��MM��" ));
		// Long mo=new
		// Long(cal.get(Calendar.YEAR)*100+cal.get(Calendar.MONTH)+1);
		// System.out.println(mo);
		// }

		// Date date = getDate(2006,1,31);
		Date date = getDate(20060131);
		// System.out.println("next month date:"+formatDate(getNextMonth(date,new
		// Long(-11)),"yyyyMMdd"));
		// System.out.println(DateUtils.formatDate(new Date(), "yyyyMMdd"));
		String registerTime = DateUtils.formatDate(new Date(),
				"yyyy-MM-dd HH:mm:ss");
		System.out.println(registerTime);

		// System.out.println("first day of week: "
		// +getDate(2005,8,1,4).getTime());

	}

	/**
	 * Compare Date by precision.
	 * 
	 * @param date1
	 * @param date2
	 * @param precision
	 * @return the same meaning as result of Date.compareTo(Date other)
	 */
	public static int compareDate(final Date date1, final Date date2,
			int precision) {
		Calendar c = Calendar.getInstance();

		List<Integer> fields = new ArrayList<Integer>();
		fields.add(new Integer(Calendar.YEAR));
		fields.add(new Integer(Calendar.MONTH));
		fields.add(new Integer(Calendar.DAY_OF_MONTH));
		fields.add(new Integer(Calendar.MINUTE));
		fields.add(new Integer(Calendar.SECOND));
		fields.add(new Integer(Calendar.MILLISECOND));

		Date d1 = date1;
		Date d2 = date2;
		if (fields.contains(new Integer(precision))) {
			c.setTime(date1);
			for (int i = 0; i < fields.size(); i++) {
				int field = (fields.get(i)).intValue();
				if (field > precision)
					c.set(field, 0);
			}
			d1 = c.getTime();
			c.setTime(date2);
			for (int i = 0; i < fields.size(); i++) {
				int field = (fields.get(i)).intValue();
				if (field > precision)
					c.set(field, 0);
			}
			d2 = c.getTime();
		}
		return d1.compareTo(d2);
	}

	/**
	 * Compare Date by precision.
	 * 
	 * @param date1
	 * @param date2
	 * @param precision
	 * @return the same meaning as result of Date.compareTo(Date other)
	 */
	public static int compareDateByDay(final Date date1, final Date date2) {
		return BigDecimal.valueOf(date2.getTime() - date1.getTime()).divide(
				BigDecimal.valueOf(1000 * 60 * 60 * 24)).intValue();
	}

	/**
	 * 获得给定时间的第N天零时的日期对象 例如：若给定时间为（2008-08-02 11:30:58）,n为1，将获得（2008-08-01
	 * 00:00:00）的日期对象 若给定时间为（2008-09-01 11:30:58）,n为1，将获得（2008-08-31
	 * 00:00:00）的日期对象
	 * 
	 * @param dt
	 *            Date 给定的java.util.Date对象
	 * @return Date java.util.Date对象
	 */
	public static Date getLastNDay(Date dt, Long n) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);

		return new GregorianCalendar(cal.get(Calendar.YEAR), cal
				.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)
				- n.intValue()).getTime();

	}

	public static Date getDateFromStr(String str, String format) {
		if (StringUtils.isNull(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		if (StringUtils.isNull(str)) {
			return null;
		}
		java.text.DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(str);
		} catch (ParseException e) {
			throw new IllegalArgumentException("根式不正确");
		}
	}

	public static boolean isDate(String str, String format) {
		if (StringUtils.isNull(format)) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		if (StringUtils.isNull(str)) {
			return false;
		}
		java.text.DateFormat df = new SimpleDateFormat(format);
		try {
			df.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 将指定日期的时间改为18:00:00
	 * 
	 * @return
	 */
	public static Date getDateForEighteenHour(Date dt) {
		if (dt == null) {
			dt = new Date();
		}
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);
		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

}
