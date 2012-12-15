package com.framework.core.service.datasource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.util.PatternMatchUtils;

/**
 * 设置数据源KEY的拦截器
 * 
 * @author 陆庆润 创建时间：2009-3-20
 */
public class DynamicDataSourceInterceptor implements MethodInterceptor {
	private static final Logger log = Logger
			.getLogger(DynamicDataSourceInterceptor.class);
	/**
	 * 方法和使用数据源key的对应关系
	 */
	private Map<String, String> attributeSource = new HashMap<String, String>();
	/**
	 * 数据源key的存储控制器
	 */
	private DynamicDataSourceKey dataSourceKey;

	private List<String> writeKeyList = new ArrayList<String>();

	public Object invoke(MethodInvocation invocation) throws Throwable {
		final String methodName = invocation.getMethod().getName();
		String bestNameMatch = null;
		for (Iterator<String> it = this.attributeSource.keySet().iterator(); it
				.hasNext();) {
			String mappedName = it.next();
			if (isMatch(methodName, mappedName)
					&& (bestNameMatch == null || bestNameMatch.length() <= mappedName
							.length())) {
				bestNameMatch = mappedName;
			}
		}
		try {
			if (bestNameMatch.equalsIgnoreCase("*")) {
				boolean flag = false;
				for (int i = 0; i < getWriteKeyList().size(); i++) {
					if (isMatch(methodName, getWriteKeyList().get(i))) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					log.info("data source wrong, please check! className is "
							+ invocation.getMethod().getDeclaringClass()
							+ " methodName is " + methodName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String key = attributeSource.get(bestNameMatch);
		if ("READ".equalsIgnoreCase(key)) {
			dataSourceKey.setReadKey();
		} else if ("WRITE".equalsIgnoreCase(key)) {
			dataSourceKey.setWriteKey();
		} else {
			dataSourceKey.setKey(key);
		}
		return invocation.proceed();
	}

	public void setAttributes(Map<String, String> attributeSource) {
		this.attributeSource = attributeSource;
	}

	private boolean isMatch(String methodName, String mappedName) {
		return PatternMatchUtils.simpleMatch(mappedName, methodName);
	}

	public DynamicDataSourceKey getDataSourceKey() {
		return dataSourceKey;
	}

	public void setDataSourceKey(DynamicDataSourceKey dataSourceKey) {
		this.dataSourceKey = dataSourceKey;
	}

	public List<String> getWriteKeyList() {
		if (writeKeyList == null) {
			writeKeyList = new ArrayList<String>();
		}
		if (writeKeyList.size() == 0) {
			writeKeyList.add("save*");
			writeKeyList.add("update*");
			writeKeyList.add("upd*");
			writeKeyList.add("delete*");
			writeKeyList.add("merge*");
			writeKeyList.add("set*");
			writeKeyList.add("add*");
			writeKeyList.add("aband*");
			writeKeyList.add("delegate*");
			writeKeyList.add("confirm*");
			writeKeyList.add("fill*");
			writeKeyList.add("assign*");
			writeKeyList.add("change*");
			writeKeyList.add("del*");
			writeKeyList.add("mod*");
			writeKeyList.add("create*");
			writeKeyList.add("call*");
			writeKeyList.add("reduce*");
			writeKeyList.add("send*");
			writeKeyList.add("exec*");
			writeKeyList.add("make*");
			writeKeyList.add("convert*");
			writeKeyList.add("adjust*");
			writeKeyList.add("commit*");
			writeKeyList.add("submit*");
			writeKeyList.add("manage*");
			writeKeyList.add("remove*");
		}
		return writeKeyList;
	}

	public void setWriteKeyList(List<String> writeKeyList) {
		this.writeKeyList = writeKeyList;
	}

}
