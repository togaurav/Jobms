package com.framework.core.vo;

import java.lang.reflect.Field;

/**
 * vo对象，提供toString()方法
 * 其他vo对象请继承此类
 * @author liuzb
 *
 */
public abstract class VO implements java.io.Serializable{
	public String toString() {
		
		Class cls = this.getClass();
		StringBuffer sb = new StringBuffer("{").append(cls.getName()).append(":\n");
		try {
			Field[] fiels = cls.getDeclaredFields();
			for (int i=0;i<fiels.length;i++) {
				fiels[i].setAccessible(true);
				sb.append("[").append(fiels[i].getName()).append(":").append(String.valueOf(fiels[i].get(this))).append("]");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		sb.append("\n}");
		return sb.toString();
	}
}
