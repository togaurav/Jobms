package com.framework.core.querybuilder.hql.struts2.view;


/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:38:36 PM
 */
public class XlsStreamResult extends OutputStreamResult {
    public static final String XLS_MIME_TYPE = "application/vnd.ms-excel";
    
    public String getContentType() {
        return XLS_MIME_TYPE;
    }
    
}
