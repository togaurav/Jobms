package com.framework.util;

import java.math.BigDecimal;

public class MathFormatUtil {
	
	public static Double round(int scale,Double value){
			BigDecimal result=new BigDecimal(value);
			return result.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double round(Double value){
		BigDecimal result=new BigDecimal(value);
		return result.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
