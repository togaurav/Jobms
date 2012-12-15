package com.framework.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 功能:电话号码处理工具类
 * @author yuyang
 * @version 1.0
 * @since Jun 2, 20092:35:09 PM
 */
public class PhoneNumSpliter {
	private static Log logger = LogFactory.getLog(PhoneNumSpliter.class);
	/**
	 * 获取传入号码的区号或手机号段
	 * @param phonenum 传入固话号码或手机号
	 * @return 固话区号或手机号段
	 */
	public static String getPhoneCode(String phonenum){
		String result="";
		if(phonenum!=null){
			if(isForeignPhone(phonenum)){//国外号码
				result=phonenum.substring(0,6);
			}else if(isTelephone(phonenum)){//固话号码
				if(phonenum.startsWith("01")||phonenum.startsWith("02")){//01或02开头代表区号为3位
					result=phonenum.substring(0,3);
				}else{//非01或02开头的代表区号为4位
					result=phonenum.substring(0,4);
				}
			}else if(isMobilephone(phonenum)){//手机号码，取前7位
				result=phonenum.substring(0,7);
			}
		}
		
		return result;
	}
	
	/**
	 * 获取传入号码的去掉区号后的电话号码(如果是手机，则返回本身)
	 * @param phonenum 传入号码
	 * @return 去掉区号后的电话号码
	 */
	public static String getPhoneNumber(String phonenum){
		String result="";
		if(phonenum!=null){
			if(isForeignPhone(phonenum)){//国外号码
				result=phonenum.substring(6,phonenum.length());
			}else if(isTelephone(phonenum)){//固话号码
				if(phonenum.startsWith("01")||phonenum.startsWith("02")){//01或02开头代表区号为3位
					result=phonenum.substring(3,phonenum.length());
				}else{//非01或02开头的代表区号为4位
					result=phonenum.substring(4,phonenum.length());
				}
			}else if(isMobilephone(phonenum)){//手机号码，取前7位
				result=phonenum;
			}
		}
		
		return result;
	}
	
	/**
	 * 判断是否是固话号码
	 * @param phonenum 电话号码
	 * @return boolean
	 */
	public static boolean isTelephone(String phonenum){
		if(phonenum!=null&&!isForeignPhone(phonenum)&&phonenum.startsWith("0")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否是手机号码
	 * @param phonenum 电话号码
	 * @return boolean
	 */
	public static boolean isMobilephone(String phonenum){
		if(phonenum!=null&&phonenum.startsWith("1")&&phonenum.length()==11){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断是否是国外号码
	 * 	注：国外用户拨打进入平台，电信统一送过来的主叫号码是000190＋国家代码
	 * @param phonenum 电话号码
	 * @return boolean
	 */
	public static boolean isForeignPhone(String phonenum){
		if(phonenum!=null&&phonenum.startsWith("000190")){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		System.out.println(PhoneNumSpliter.getPhoneCode("01023122321"));
		System.out.println(PhoneNumSpliter.getPhoneNumber("01023122321"));
		System.out.println(PhoneNumSpliter.getPhoneCode("04219988321"));
		System.out.println(PhoneNumSpliter.getPhoneNumber("04219988321"));
		System.out.println(PhoneNumSpliter.getPhoneCode("13323212333"));
		System.out.println(PhoneNumSpliter.getPhoneNumber("13323212333"));
	}
}
