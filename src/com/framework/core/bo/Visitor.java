/**
 * 
 */
package com.framework.core.bo;

import java.io.Serializable;

/**
 * @author YanBing
 * 
 */
public class Visitor implements Serializable {

	private Long ucid;
	private String ip;

	/**
	 * @return the userid
	 */
	public Long getUcid() {
		return ucid;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUcid(Long ucid) {
		this.ucid = ucid;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer().append(" [").append("ucid")
				.append("=").append(getUcid()).append(" ").append("ip")
				.append("=").append(getIp()).append(" ").append("]");

		return sb.toString();
	}

}
