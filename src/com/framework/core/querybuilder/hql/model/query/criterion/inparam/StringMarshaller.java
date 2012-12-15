package com.framework.core.querybuilder.hql.model.query.criterion.inparam;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.framework.core.querybuilder.hql.model.query.converter.Converter;
import com.framework.core.querybuilder.hql.model.query.converter.ConverterManager;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:20:00 PM
 */
public class StringMarshaller implements Marshaller {
    private String value;
    
    public StringMarshaller(String value) {
        this.value = value;
    }

    public Object getNamedQueryParamValue(Class paramClass) {
        return splitString(value, ",", paramClass);
    }

    public boolean hasValues() {
      return StringUtils.isBlank(value) ? false : true;
    }

    public String stringValue() {
        return value;
    }

    public String toString() {
        return "StringMarshaller";
    }
    
    private List splitString(String str, String separator, Class paramClass) {
        Converter converter = ConverterManager.lookup(paramClass);
        List ret = new ArrayList();
        String[] values = str.split(separator);
        for (int i = 0; i < values.length; i++) {
            ret.add(converter.convert(paramClass, values[i].trim()));
        }
        return ret;
    }
    
}

