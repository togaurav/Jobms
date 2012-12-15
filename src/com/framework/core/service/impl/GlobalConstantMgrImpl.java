package com.framework.core.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.framework.core.service.GlobalConstantMgr;
import com.framework.util.Constants;

/**
 * beidou全局配置加载类
 * @author zhangpeng
 *  @version 1.0.0
 *
 */
public class GlobalConstantMgrImpl implements GlobalConstantMgr 
{
   private static Logger log = Logger.getLogger(GlobalConstantMgrImpl.class);
   
   /**
    * 配置项加载统一出口
    */
   public void loadGlobalConf(){
	   this.loadConfFile();
   }
   /**
    * 从文件中加载配置项
    *
    */
   private void loadConfFile(){
	   
	   Properties properties = new Properties();
	   
	   InputStream is = null;
	   
		try {			
	        is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/com/baidu/beidou/util/beidou_constant.properties");
	        properties.load(is);
	        
//		      加载cpmis ip限制报警邮件发送地址
	        String configTerm = properties.getProperty("LOG_MAILFROM");
	        
	        if(configTerm == null){
	        	log.error("BeidouConstant : LOG_MAILFROM is null");
	        }else{
	        	Constants.setLOG_MAILFROM(configTerm.trim());
	        	log.info("BeidouConstant : LOG_MAILFROM == " + Constants.getLOG_MAILFROM());
	        }
	        
//		      加载cpmis ip限制报警邮件发送地址
	        configTerm = properties.getProperty("LOG_MAILTO");
	        
	        if(configTerm == null){
	        	log.error("BeidouConstant : LOG_MAILTO is null");
	        }else{
	        	Constants.setLOG_MAILTO(configTerm.trim());
	        	log.info("BeidouConstant : LOG_MAILTO == " + Constants.getLOG_MAILTO());
	        }
	        
//		      加载帮助系统域名
	        configTerm = properties.getProperty("HELP_DOMAIN");
	    System.out.println("test HELP_DOMAIN:"+configTerm);    
	        if(configTerm == null ||configTerm.trim().equals("")){
	        	log.error("BeidouConstant : HELP_DOMAIN is empty");
	        }else{
	        	Constants.HELP_DOMAIN= configTerm.trim();
	        	log.info("BeidouConstant : HELP_DOMAIN == " + Constants.HELP_DOMAIN);
	        }
	        
//		      加载帮助系统域名
	        configTerm = properties.getProperty("HELP_MAIL");
	        
	        if(configTerm == null ||configTerm.trim().equals("")){
	        	log.error("BeidouConstant : HELP_MAIL is empty");
	        }else{
	        	Constants.HELP_MAIL= configTerm.trim();
	        	log.info("BeidouConstant : HELP_MAIL == " + Constants.HELP_MAIL);
	        }
	        
	    } catch (IOException e) {
	    	 e.printStackTrace();
	    	 log.error("load config file error:GlobalConstantMgrImpl");
	    }finally{
	    	
	    	if(is != null){
	    		try {
	    	        is.close();	    	        
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }	    		
	    	}
	    }    
   }     
}