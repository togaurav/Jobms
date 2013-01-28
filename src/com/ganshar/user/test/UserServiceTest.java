package com.ganshar.user.test;

import java.util.Date;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.util.ServiceLocator;
import com.ganshar.user.model.User;
import com.ganshar.user.service.UserService;

public class UserServiceTest extends TestCase {
	private final static Log log = LogFactory.getLog(UserServiceTest.class);

	private UserService userService;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.userService=(UserService)ServiceLocator.getInstance().getBean("userService");
	}

	
	public void testlogin() {
		String email="test1@163.com";
		String password="111111";
		User user=this.userService.findUserByEmailPass(email, password);
		this.log.info("userid="+user.getId());
	}
	
	public void testadd() {
		String email="test1@163.com";
		String name="test1";
		String password="111111";
		User user=new User();
		user.setEmail(email);
		user.setName(name);
		user.setAddTime(new Date());
		user.setPassword(password);
		//this.userService.addUser(user);
		this.log.info("userid="+user.getId());
	}
	
}
