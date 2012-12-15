package com.framework.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.framework.util.property.SysProperty;

public class HttpClientUtil {

	private static final Logger logger = Logger.getLogger(HttpClientUtil.class);
	private static final String CONTENT_CHARSET = "UTF-8";
	private static HttpClient hcInstance = null;

	public enum MethodType {
		GET, POST
	}

	/**
	 * 获取httpClient instance
	 * 
	 * @return
	 */
	private static HttpClient getHttpClientInstance() {
		if (hcInstance == null) {
			hcInstance = new HttpClient();
			HttpConnectionManager hcm = new MultiThreadedHttpConnectionManager();
			hcm.getParams().setConnectionTimeout(
					SysProperty.CONNECTION_ESTABLISH_TIMEOUT);
			hcm.getParams().setMaxConnectionsPerHost(
					hcInstance.getHostConfiguration(),
					SysProperty.HTTP_APP_MAX_CONNECTION);
			hcm.getParams().setMaxTotalConnections(
					SysProperty.HTTP_TOTAL_MAX_CONNECTION);
			hcInstance.setHttpConnectionManager(hcm);
			hcInstance.getParams().setContentCharset(CONTENT_CHARSET);
		}
		return hcInstance;
	}

	private static GetMethod doGet(String url, Map<String, Object> keyToValue) {
		StringBuilder sb = new StringBuilder(url);
		if (keyToValue != null) {
			for (Iterator<String> it = keyToValue.keySet().iterator(); it
					.hasNext();) {
				String key = it.next();
				Object object = keyToValue.get(key);
				String value = "";
				if (object != null) {
					value = String.valueOf(object);
				}
				if (sb.indexOf("?") < 0) {
					sb.append("?").append(key).append("=").append(value);
				} else {
					sb.append("&").append(key).append("=").append(value);
				}
			}
		}
		String getURL = sb.toString();
		logger.info("SEND GET request to URL = " + getURL);
		return new GetMethod(getURL);
	}

	private static PostMethod doPost(String url, Map<String, Object> keyToValue) {
		PostMethod postMethod = new PostMethod(url);
		if (keyToValue != null) {
			for (Iterator<String> it = keyToValue.keySet().iterator(); it
					.hasNext();) {
				String key = it.next();
				Object object = keyToValue.get(key);
				String value = "";
				if (object != null) {
					if (object instanceof Object[]) {
						Object[] temp = (Object[]) object;
						for (int i = 0; i < temp.length; i++) {
							value = String.valueOf(temp[i]);
							postMethod.addParameter(key, value);
						}
					} else {
						value = String.valueOf(object);
						postMethod.addParameter(key, value);
					}
				} else {
					postMethod.addParameter(key, value);
				}
			}
		}
		logger.info("SEND PSOT request to URL = " + url);
		return postMethod;
	}

	public static String invokeClient(MethodType type, String url,
			Map<String, Object> keyToValue) throws Exception {
		HttpClient httpClient = getHttpClientInstance();
		HttpMethodBase method = null;
		if (type.equals(MethodType.GET)) {
			method = doGet(url, keyToValue);
		} else {
			method = doPost(url, keyToValue);
		}
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,
				SysProperty.SOCKET_TIMEOUT);
		if (url.contains("/ht-") && ServletActionContext.getRequest() != null) {
			Enumeration e = ServletActionContext.getRequest().getHeaderNames();
			while (e.hasMoreElements()) {
				String headerName = (String) e.nextElement();
				String headerValue = ServletActionContext.getRequest()
						.getHeader(headerName);
				if ("cookie".equalsIgnoreCase(headerName)) {
					method.setRequestHeader(headerName, headerValue);
				}
			}
		}
		String httpResult = null;
		try {
			int statusCode = httpClient.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				logger.error("statusCode: " + statusCode + " Method failed: "
						+ method.getStatusLine());
				throw new Exception("httpclient exception:" + "statusCode["
						+ statusCode + "] Method failed: "
						+ method.getStatusLine());
			} else {
				httpResult = method.getResponseBodyAsString();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			logger
					.info("Release Stream and Return Http Connection Back to HostPool.");
			method.releaseConnection();
		}
		return httpResult;
	}
}
