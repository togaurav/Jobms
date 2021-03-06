/**
 * 
 */
package com.framework.core.vo;

import java.util.List;

/**
 * @author Mazhy.Keng
 * 
 */
public class ResultStatus {

	/**
	 * 状态编码：0-正常，1-异常
	 */
	private int status;

	/**
	 * 返回消息
	 */
	private List<String> messages;

	public static final int ERROR_STATUS = 1;
	public static final int SUCCESS_STATUS = 0;

	public ResultStatus() {
		super();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
