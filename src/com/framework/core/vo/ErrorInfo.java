/**
 * 
 */
package com.framework.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author wangl 20090401
 * @version 1.0.0
 *
 */
public class ErrorInfo implements Serializable {

	/**
	 * 返回标识 flag=0 相当与history.back()   flag=1,跳转到errorURL指向的路径
	 */
	Integer flag;
	/**
	 * 信息
	 */
	String errorMessage;
	/**
	 * 跳转URL
	 */
	String errorURL;
	/**
	 * 链接名字
	 */
	String linkName;

	public  ErrorInfo(String errorMessage,Integer flag,String errorURL,String linkName){
		this.errorMessage=errorMessage;
		this.flag=flag;
		this.errorURL=errorURL;		
		this.linkName=linkName!=null?linkName:new String ("返回");
	}	
	
	public  ErrorInfo(String errorMessage){
		this.errorMessage=errorMessage;
		this.flag=Integer.valueOf(0);
		this.errorURL=null;
		this.linkName=new String("返回");
	}
	
	
	public  ErrorInfo(String errorMessage,String errorURL){
		this.errorMessage=errorMessage;
		this.flag=Integer.valueOf(1);
		this.errorURL=errorURL;
		this.linkName=new String("返回");
	}
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorURL() {
		return errorURL;
	}

	public void setErrorURL(String errorURL) {
		this.errorURL = errorURL;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}


}
