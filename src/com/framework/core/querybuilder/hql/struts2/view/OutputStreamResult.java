package com.framework.core.querybuilder.hql.struts2.view;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.framework.core.querybuilder.hql.struts2.action.OutputStreamAction;
import com.framework.core.querybuilder.hql.struts2.action.OutputStreamExportAction;
import com.opensymphony.xwork2.ActionInvocation;



/**
 * 功能:
 * @author yuyang
 * @version 1.0
 * @since Jun 6, 20093:38:17 PM
 */
public class OutputStreamResult extends StrutsResultSupport {
    protected String contentType = "text/plain";
    protected String contentDisposition = "inline";

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    public String getContentDisposition() {
        return contentDisposition;
    }
    
    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
        if (invocation.getAction() instanceof OutputStreamAction) {
            HttpServletResponse response = ServletActionContext.getResponse();
            response.reset();
            response.setContentType(conditionalParse(getContentType(), invocation));

            if (invocation.getAction() instanceof OutputStreamExportAction) {
                String exportName = ((OutputStreamExportAction) invocation.getAction()).getExportName();
                contentDisposition = "attachment;filename=\"" + exportName + "\"";
            }
            if (contentDisposition != null) {
                response.addHeader("Content-disposition", conditionalParse(contentDisposition, invocation));
            }
            
            ((OutputStreamAction) invocation.getAction()).render(response.getOutputStream());
            response.getOutputStream().flush();
        }
    }

}
