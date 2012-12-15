package com.jobms.match.test;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.framework.util.ServiceLocator;
import com.jobms.match.service.UserJobMatchService;

public class UserJobMatchTest extends TestCase {
	private final static Log log = LogFactory.getLog(UserJobMatchTest.class);

	private UserJobMatchService userJobMatchService;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.userJobMatchService=(UserJobMatchService)ServiceLocator.getInstance().getBean("userJobMatchService");
	}

	public void testMatch() {
		Integer userId=1;
		String jobName="销售经理";
		BigDecimal matchDegree=this.userJobMatchService.match(userId, jobName);
		this.log.info("人职匹配度="+matchDegree.toString());
	}

}
