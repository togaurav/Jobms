<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>工作经历_干啥儿网</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
	<link href="${pageContext.request.contextPath}/css/alink.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    \
		<!--
		.STYLE1 {color: #FF0000}
		.STYLE4 {color: #FFFFFF}
		.qtip-wiki{
			max-width: 600px;
		}
		.STYLE9 {
			font-size: 22;
			font-weight: bold;
		}		
		-->
    </style>
      <script type="text/javascript">
			function submitForm(){
				if($('#companyNames_widget').attr("value").length<1){
					alert("公司名称不能为空！");
					return;
				}
				if($('#jobNames_widget').attr("value").length<1){
					alert("职位名称不能为空！");
					return;
				}
				if($('#userJobCity').attr("value")==-1){
					alert("请选择工作地点！");
					return;
				}
				document.all.userWorkExpForm.submit();
			}
      </script>  
</head>  
<body bottommargin="0" topmargin="0">
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr> <td>&nbsp;</td></tr>
  <tr>
  	<td align="center" >
			<s:hidden name="userWorkExpVO.id"  value="%{userWorkExpVO.id}"/>
		 	<table width="100%"  height="290" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td colspan="2"  align="right"><s:if test="userWorkExpVOList.size>0"><hr></s:if></td>
              </tr>
              <tr>
                <td width="34%"  align="right">
                 <font color="#FF0000">*</font>&nbsp;工作类型：</td>
                <td width="66%">&nbsp;
					<s:radio name="userWorkExpVO.jobType"  value="1" list="#{1 :'全职', 0 :'实习'}" />				</td>
              </tr>
              <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;公司名称：</td>
                <td>&nbsp;
					<s:url id="companyname_remoteurl" action="findCompanyListByTip" namespace="/resume"/>
          			<sj:autocompleter id="companyNames" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"					
					 cssStyle="width:30%" 
           			 loadMinimumCount="2"  />
					<s:hidden name="userWorkExpVO.companyId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;职位名称：</td>
                <td>&nbsp;
					<s:url id="jobname_remoteurl" action="findJobListByTip"  namespace="/resume"/>
          			<sj:autocompleter id="jobNames" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
					 cssStyle="width:30%" 
           			 loadMinimumCount="2"  />
					<s:hidden name="userWorkExpVO.jobId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;工作地点：</td>
                <td>&nbsp;
                  <s:select id="userJobCity" name="userWorkExpVO.jobCity"  cssStyle="width:30%"  list="#{1:'北京',2:'上海'}" >				  </s:select>				 </td>
              </tr>
              <tr>
                <td align="right" ><font color="#FF0000">*</font>&nbsp;在职时间：</td>
                <td >&nbsp;
					 <s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月
				  <input type='checkbox' name="userWorkExpVO.nowdate" value="true" /> 至今				 </td>
              </tr>
              
              <tr>
                <td align="right">薪水（税前）：</td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobSalary" cssStyle="width:30%"  maxlength="8"/>				</td>
              </tr>
			   <tr>
                <td align="right"></td>
                <td>&nbsp;
					<input type='checkbox' name="userWorkExpVO.lastJob" value="true"/>是否是最近一份工作				</td>
              </tr>
              <tr>
                <td align="right">工作描述：</td>
                <td>&nbsp;
					<s:textarea name="userWorkExpVO.jobDesc" maxlength="1000" cols="60" rows="5"/>				</td>
              </tr>
            </table>	
	</td>
  </tr>
</table> 	
</body>
</html>
