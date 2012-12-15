/**
 * 
 */
package com.framework.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.googlecode.jsonplugin.JSONUtil;

/**
 * @author zengyunfeng
 * @version 1.0.0
 *
 */
public class PatterListUtils {
	 public static List<Pattern> asPatternList(String properties){
	    	List<String> excludePatterns = JSONUtil.asList(properties);
			List<Pattern> exPro = null;
			Pattern pat = null;
			if(!StringUtils.isEmpty(properties)){
				 exPro = new ArrayList<Pattern>(excludePatterns.size());
				 for(String str : excludePatterns){
					 pat = Pattern.compile(str);
					 exPro.add(pat);
				 }
			}
			return exPro;
	    }
}
