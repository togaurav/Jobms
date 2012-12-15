/**
 * 
 */
package com.framework.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import com.baidu.rigel.cprounit.vo.NavigateInfo;
import com.googlecode.jsonplugin.JSONUtil;
import com.googlecode.jsonplugin.annotations.JSON;

/**
 * @author zengyunfeng
 * @version 1.0.0
 * 
 */
public class URLParamUtils {

	private static final Log log = LogFactory.getLog(URLParamUtils.class);

	public static String serializeParam(final String prix, final Object object, final String excludeProperties,
			final String includeProperties) {
		String paramPrix = "";
		if(prix!=null){
			paramPrix = prix;
		}
		Class clazz = object.getClass();

		BeanInfo info = null;
		try {
			info = Introspector.getBeanInfo(clazz, clazz.getSuperclass());

			PropertyDescriptor[] props = info.getPropertyDescriptors();

			boolean hasData = false;

			List<Pattern> excludePattern = PatterListUtils
					.asPatternList(excludeProperties);
			List<Pattern> includePattern = PatterListUtils
					.asPatternList(includeProperties);

			StringBuilder buf = new StringBuilder();
			for (int i = 0; i < props.length; ++i) {
				PropertyDescriptor prop = props[i];
				String name = prop.getName();
				Method accessor = prop.getReadMethod();
				Method baseAccessor = null;
				baseAccessor = accessor;

				if (baseAccessor != null) {

					if (shouldExcludeProperty(clazz, prop)) {
						continue;
					}
					String expr = name;
					if (shouldExcludeProperty(expr, excludePattern,
							includePattern)) {
						continue;
					}

					if (hasData) {
						buf.append("&");
					}
					hasData = true;

					Object value = accessor.invoke(object, new Object[0]);
					buf.append(paramPrix);
					buf.append(name);
					buf.append("=");
					if (value != null) {
						buf.append(value.toString());
					}

				}
			}
			String result = buf.toString();
			return result;
//			return URLEncoder.encode(result, "utf-8");	//js中进行urlencode
		} catch (Exception e) {
			LogUtils.fatal(log, "url parameterlize", e);
			return "";
		}
	}

	/**
	 * Ignore "class" field
	 */
	private static boolean shouldExcludeProperty(Class clazz,
			PropertyDescriptor prop) throws SecurityException,
			NoSuchFieldException {
		String name = prop.getName();

		if (name.equals("class") || name.equals("declaringClass")) {
			return true;
		}

		return false;
	}

	private static boolean shouldExcludeProperty(String expr,
			List<Pattern> excludeProperties, List<Pattern> includeProperties) {
		if (excludeProperties != null) {
			for (Pattern pattern : excludeProperties) {
				if (pattern.matcher(expr).matches()) {
					return true;
				}
			}
		}

		if (includeProperties != null) {
			for (Pattern pattern : includeProperties) {
				if (pattern.matcher(expr).matches()) {
					return false;
				}
			}

			return true;
		}

		return false;
	}
	

}
