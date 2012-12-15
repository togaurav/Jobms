/**
 * 
 */
package com.framework.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author zengyunfeng
 * @version 1.0.0
 *
 */
public class NewCollectionUtils extends
		org.apache.commons.collections.CollectionUtils {

	public static <E> List listProjection(List<E> list, String propertyName) throws Exception{
		if(list == null){
			return null;
		}
		List result = new ArrayList(list.size()); 
		if(list.size()==0){
			return result;
		}
		
		E  obj = list.get(0);
		BeanInfo info = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] property = info.getPropertyDescriptors();
		Method access = null;
		for(PropertyDescriptor pro : property){
			if(pro.getName().equals(propertyName)){
				access = pro.getReadMethod();
				break;
			}
		}
		
		
		for(E element : list){
			result.add(access.invoke(element));
		}
		return result;
	}
	
//	public static void main(String[] args) {
//		List<User> users = new ArrayList<User>(3);
//		User u = new User();
//		u.setId(1);
//		users.add(u);
//		u = new User();
//		u.setId(null);
//		users.add(u);
//		try {
//			List<Integer> a = listProjection(users, "id");
//			for(Integer obj :a){
//				System.out.println(obj);
//			}
//			System.out.println(Arrays.toString(a.toArray()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
