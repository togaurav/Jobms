package com.framework.util;
/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class ArrayUtil {

	private ArrayUtil() {
		;
	}

	public static boolean isEmpty(Object[] arr) {
		return arr == null || arr.length <= 0;
	}

	@SuppressWarnings("unchecked")
	public static boolean isEmpty(List list) {
		return list == null || list.isEmpty();
	}

	public static String toStringForSql(Number... a) {
		if (a == null)
			return "";
		if (a.length == 0)
			return "";
		StringBuilder buf = new StringBuilder();
		buf.append('(');
		buf.append(a[0]);
		for (int i = 1; i < a.length; i++) {
			buf.append(", ");
			buf.append(a[i]);
		}
		buf.append(")");
		return buf.toString();
	}

	public static String toStringForSql(Long... a) {
		if (a == null)
			return "";
		if (a.length == 0)
			return "";
		StringBuilder buf = new StringBuilder();
		buf.append('(');
		buf.append(a[0]);
		for (int i = 1; i < a.length; i++) {
			buf.append(", ");
			buf.append(a[i]);
		}
		buf.append(")");
		return buf.toString();
	}

	@SuppressWarnings("unchecked")
	public static List fillList(List list) {
		return list == null ? new ArrayList(0) : list;
	}
}
