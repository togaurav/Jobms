package com.jobms.match.service;

import java.math.BigDecimal;

public interface JobPriceService {
	
	/**
	 * 计算职位价值层级
	 * @param jobName
	 * @return
	 */
	public   BigDecimal  compute(String jobName);
	
}
