package com.jobms.match.proc;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class UserJobMatchProc  extends StoredProcedure {

	//存储过程名称
	private static final String PROCEDURE_NAME="proc_user_job_match";
		
	//存储过程输入参数名称
	public  static final String IN_PARA_USERID="userid";
	public  static final String IN_PARA_JOBNAME="tar_job_name";
	//存储过程输出参数名称
	public  static final String OUT_PARA_NAME="match_degree";
		
	public 	UserJobMatchProc(JdbcTemplate	jdbcTemplate){
			super(jdbcTemplate,PROCEDURE_NAME);
			declareParameter(new SqlParameter(IN_PARA_USERID, Types.INTEGER));
			declareParameter(new SqlParameter(IN_PARA_JOBNAME, Types.VARCHAR));
			declareParameter(new SqlOutParameter(OUT_PARA_NAME, Types.DECIMAL));
			this.compile();
	}
	
	//执行存储过程调用
	public BigDecimal exec(Integer userid, String jobName){
			BigDecimal result=new BigDecimal(0);
			Map inparaMap=new HashMap();
			inparaMap.put(IN_PARA_USERID, userid);
			inparaMap.put(IN_PARA_JOBNAME, jobName);
			Map resultMap=this.execute(inparaMap);
			if(resultMap!=null){
				result=(BigDecimal)resultMap.get(OUT_PARA_NAME);
			}
			return result;
	}
		
}
