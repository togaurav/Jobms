package com.framework.core.querybuilder.hql.model.query.criterion.inparam;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:19:43 PM
 */
public class NullValueMarshaller implements Marshaller {

    public Object getNamedQueryParamValue(Class paramClass) {
        return null;
    }
    
    /**
     * @return null
     */
    public boolean hasValues() {
        return false;
    }

    public String stringValue() {
        return null;
    }
    
    public String toString() {
        return "NullValueMarshaller";
    }
}

