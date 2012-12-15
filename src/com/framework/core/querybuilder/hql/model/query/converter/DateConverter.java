package com.framework.core.querybuilder.hql.model.query.converter;

import org.apache.commons.lang.StringUtils;



/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20095:59:00 PM
 */
public class DateConverter implements Converter {
    
    /**
     * @param type Data type to which this value should be converted
     * @param value The input value to be converted
     *
     * @exception ConversionException if conversion cannot be performed
     *  successfully
     */
    public Object convert(Class type, String value) throws ConversionException {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        
    	int datelength = value.length();
    	String pattern = "";    	
    	/*
    	if(datelength > 10) {
            pattern = DateUtils.DATETIME_FORMAT_PATTERN;
        } else if (datelength == 10) {
            pattern = DateUtils.DATE_FORMAT_PATTERN;
        } else {
            pattern = DateUtils.COMPACT_DATE_FORMAT_PATTERN;
        }
    	
    	return DateUtils.parse(value, pattern);
    	*/
    	return null;
    }
    
}