/**
 * 
 */
package com.framework.core.vo;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 */
public class CloneableVO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String text;

	private String value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
		}
		return o;
	}
}
