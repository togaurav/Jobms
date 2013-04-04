<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%> 

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
<title>匹配算法实验室</title>
<sj:head jqueryui="true"/>
<style type="text/css">
<!--
.STYLE6 {color: #FF0000}
.STYLE7 {
	font-size: x-small;
	font-weight: bold;
}
.STYLE10 {font-size: x-small}
.STYLE11 {
	font-size: xx-small;
	font-weight: bold;
}
.STYLE12 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>

<script type="text/javascript">
jQuery(function($){   
 var obj=$("#jobForm.jobCompanyId");   
 if(typeof obj != 'undefined' && obj !=''){  
     onchangeShow(0);     //初始化的时候，也执行一次，不然没有数据下来
 }  
}); 
function onchangeShow(id){ 
jQuery.ajax({   
url : "${pageContext.request.contextPath}/match/findCompanyJobs.action",    //这个要全路径，有着血淋淋的教训
data : {jobCompanyId : id},  // 传递参数   
type : "post",   
cache : false,   
dataType : "json",   
success:onchangecallback     //开始一直觉得调用的时候怎么没有参数，后来发现确实不需要
});
} 
function onchangecallback(data){
    var jqueryObj=$(data);          //从action获取数据
	document.all['job_jobId'].options.length = 0;   
    var str="<option value='-1'>----请选择----</option>";   
    for(var i=0;i<jqueryObj.length;i++){   
        str+="<option value='"+jqueryObj[i].jobId+"'>"+jqueryObj[i].jobName+"</option>"  
    }   
    $("#job_jobId").html(str);   
} 
</script>


</head>

<body bottommargin="0" topmargin="0">
<%@ include file="../top.jsp"%> 	
<s:form id="matchForm" method="post" action="domatch" naamespace="/match">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="33%">
		<table align="center" width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="26" valign="bottom" bgcolor="#3399CC"><p class="STYLE12">简历信息</p></td>
          </tr>
          <tr>
            <td><table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0">
                <tr>
                  <td><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td colspan="3" bgcolor="#CCCCCC"><span class="STYLE7">教育情况</span></td>
                      </tr>
                      <tr>
                        <td width="11%"><div align="right" class="STYLE6"></div></td>
                        <td width="22%"><div align="right" class="STYLE11">毕业学校：</div></td>
                        <td width="67%"><label>
                          <s:select list="schooList" name="resume.schoolId"  listKey="id" listValue="name" ></s:select>
                          </label>
                        </td>
                      </tr>
                      <tr>
                        <td><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">所学专业：</div></td>
                        <td><label>
                          <s:select list="majorList" name="resume.topMajorId"  listKey="id" listValue="name" ></s:select>
                          </label>
                        </td>
                      </tr>
                      <tr>
                        <td><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">最高学历：</div></td>
                        <td><label>
                          <s:select list="educationList" name="resume.topEducationId"  listKey="id" listValue="name" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td colspan="3" bgcolor="#CCCCCC"><span class="STYLE10"><strong>工作经历</strong></span></td>
                      </tr>
                      <tr>
                        <td colspan="3"><span class="STYLE11">(1) 最近一份工作</span></td>
                      </tr>
                      <tr>
                        <td height="25"><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">公司名称：</div></td>
                        <td><label>
                          <s:select list="companyList" name="exp1.companyId"  listKey="id" listValue="name"  headerKey="-1" headerValue="----请选择一个公司----" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td height="24"><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">职位名称：</div></td>
                        <td><label>
                          <s:select list="jobList" name="exp1.jobId"  listKey="jobId" listValue="jobName"  headerKey="-1" headerValue="----请选择一个职位----" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">工作年限：</div></td>
                        <td><select style="height:20;width:200" name="exp1.serviceLen">
                            <option value='-1'>----请选择工作年限----</option>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='8'>8</option>
                            <option value='10'>10</option>
                        </select></td>
                      </tr>
                      <tr>
                        <td colspan="3"><span class="STYLE10"><span class="STYLE11">(2) 前一份工作</span></span></td>
                      </tr>
                      <tr>
                        <td height="23"><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">公司名称：</div></td>
                        <td><label>
                          <s:select list="companyList" name="exp2.companyId"  listKey="id" listValue="name" headerKey="-1" headerValue="----请选择一个公司----" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td height="24"><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">职位名称：</div></td>
                        <td><label>
                          <s:select list="jobList" name="exp2.jobId"  listKey="jobId" listValue="jobName" headerKey="-1" headerValue="----请选择一个职位----" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">工作年限：</div></td>
                        <td><select style="height:20;width:200" name="exp2.serviceLen">
                            <option value='-1'>----请选择工作年限----</option>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='8'>8</option>
                            <option value='10'>10</option>
                        </select></td>
                      </tr>
                      <tr>
                        <td colspan="3"><span class="STYLE11">(3) 其他工作经历</span></td>
                      </tr>
                      <tr>
                        <td height="22"><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">公司名称：</div></td>
                        <td><label>
                          <s:select list="companyList" name="exp3.companyId"  listKey="id" listValue="name"  headerKey="-1" headerValue="----请选择一个公司----" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td height="25"><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">职位名称：</div></td>
                        <td><label>
                          <s:select list="jobList" name="exp3.jobId"  listKey="jobId" listValue="jobName" headerKey="-1" headerValue="----请选择一个职位----" ></s:select>
                        </label></td>
                      </tr>
                      <tr>
                        <td><div align="right" class="STYLE6"></div></td>
                        <td><div align="right" class="STYLE11">工作年限：</div></td>
                        <td><select style="height:20;width:200" name="exp3,serviceLen">
                            <option value='-1'>----请选择工作年限----</option>
                            <option value='1'>1</option>
                            <option value='2'>2</option>
                            <option value='3'>3</option>
                            <option value='4'>4</option>
                            <option value='5'>5</option>
                            <option value='6'>6</option>
                            <option value='8'>8</option>
                            <option value='10'>10</option>
                        </select></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="3"><div align="center">
                            <input type="hidden" style=" height:40;width:160;color:#FFFFFF;background-color:#000000;font-size:24px" name="Submit" value="计算个人价值">
                        </div></td>
                      </tr>
                  </table></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td height="19">&nbsp;</td>
          </tr>
        </table></td>
        <td width="34%"><div id="resultdiv" align="center"><img src="${pageContext.request.contextPath}/image/wenhao.jpg" width="200" height="253"></div></td>
        <td width="33%">
			<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          
          <tr>
            <td height="26" valign="bottom" bgcolor="#3399CC"><p class="STYLE12">职位信息</p></td>
          </tr>
          <tr>
            <td><table width="100%" height="100%" border="1" cellspacing="0" cellpadding="0">
                <tr>
                  <td>
                      <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td colspan="3" bgcolor="#CCCCCC">基本要求</td>
                        </tr>
                        <tr>
                          <td width="11%" height="25"><div align="right" class="STYLE6"></div></td>
                          <td width="22%"><div align="right" class="STYLE11">所属公司：</div></td>
                          <td width="67%"><label>
                            <s:select list="companyList" name="job.companyId"  id="jobCompanyId" listKey="id" listValue="name"
								onchange="onchangeShow(this.value)"
								cssStyle="width:50%"
								headerKey="-1" headerValue="----请选择----" ></s:select>
                          </label></td>
                        </tr>
                        <tr>
                          <td height="24"><div align="right" class="STYLE6"></div></td>
                          <td><div align="right" class="STYLE11">职位列表：</div></td>
                          <td><label>
                            <select name="job.jobId"  style="width:50%"  id="job_jobId"  >
								<option value='-1'>----请选择----</option>
							</select>
                          </label></td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="left" class="STYLE11">
                            <div align="right">职业领域：</div>
                          </div></td>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="left" class="STYLE11">
                            <div align="right">标准职位：</div>
                          </div></td>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="right" class="STYLE11">工资范围：</div></td>
                          <td><s:textfield   name="job.jobSalary"/>&nbsp;</td>
                        </tr>
                        <tr>
                          <td><div align="right" class="STYLE6"></div></td>
                          <td><div align="right" class="STYLE11">工龄要求：</div></td>
                          <td><s:textfield   name="job.jobServiceLen"/>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="right" class="STYLE11">所在地：</div></td>
                          <td><s:textfield   name="job.cityId"/>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="right" class="STYLE11">技能要求：</div></td>
                          <td><s:textfield   name="cityId"/>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="right" class="STYLE11">行业要求：</div></td>
                          <td><s:textfield   name="cityId"/>&nbsp;</td>
                        </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td><div align="right" class="STYLE11">学历要求：</div></td>
                          <td><s:textfield   name="cityId"/>&nbsp;</td>
                        </tr>
                        <tr>
                          <td colspan="3" bgcolor="#CCCCCC"><strong>详细描述</strong></td>
                          </tr>
                        <tr>
                          <td>&nbsp;</td>
                          <td></td>
                          <td>&nbsp;</td>
                        </tr>
                        
                        
                        
                        <tr>
                          <td colspan="3">&nbsp;&nbsp;&nbsp;
                            <div align="center">
  <input type="hidden" style=" height:40;width:160;color:#FFFFFF;background-color:#000000;font-size:24px" name="Submit3" value="计算职位价值">
   </div></td>
                          </tr>
                      </table>                 	</td>
                </tr>
            </table></td>
          </tr>
        </table>		</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><div align="center">
		<sj:submit formId="matchForm" 
				targets="resultdiv" 
				oadingText ="计算中........."
				errorText="计算出现错误！"
				cssStyle="height:40;width:160;color:#FFFFFF;background-color:#000000;font-size:24px" value="计算匹配度" /> 
        </div></td>
        <td>&nbsp;</td>
      </tr>
      
    </table></td>
  </tr>
</table>
</s:form>
<%@ include file="../bottom.jsp"%> 
</body>
</html>
