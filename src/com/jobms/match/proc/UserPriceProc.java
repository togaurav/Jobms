package com.jobms.match.proc;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class UserPriceProc  extends StoredProcedure {

	//存储过程名称
	private static final String PROCEDURE_NAME="proc_user_price_compute";
		
	//存储过程输入参数名称
	public  static final String IN_PARA_USERID="userid";
	public  static final String IN_PARA_CAREERAREA_NAME="careerName";
	//存储过程输出参数名称
	public  static final String OUT_PARA_NAME="userPrice";
		
	public 	UserPriceProc(JdbcTemplate	jdbcTemplate){
			super(jdbcTemplate,PROCEDURE_NAME);
			declareParameter(new SqlInOutParameter(IN_PARA_USERID,Types.INTEGER));
			declareParameter(new SqlInOutParameter(IN_PARA_CAREERAREA_NAME,Types.VARCHAR));
			declareParameter(new SqlOutParameter(OUT_PARA_NAME,Types.DECIMAL));
			this.compile();
	}
	
	//执行存储过程调用
	public BigDecimal exec(Integer userid, String careerAreaName){
			BigDecimal result=new BigDecimal(0);
			Map inparaMap=new HashMap();
			inparaMap.put(IN_PARA_USERID, userid);
			inparaMap.put(IN_PARA_CAREERAREA_NAME, careerAreaName);
			Map resultMap=this.execute(inparaMap);
			if(resultMap!=null){
				result=(BigDecimal)resultMap.get(OUT_PARA_NAME);
			}
			return result;
	}
		
}
