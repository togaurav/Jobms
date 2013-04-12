<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>工作期望_干啥儿网</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
	<link href="${pageContext.request.contextPath}/css/alink.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    \
		<!--
		.STYLE1 {color: #FF0000}
		.qtip-wiki{
			max-width: 600px;
		}
		-->
    </style>
     <script type="text/javascript">
			function submitForm(){
				if($('#jobintentVO_jobKeywords').attr("value").length<1){
					alert("目标职位不能为空！");
					return;
				}
				document.all.jobintentForm.submit();
			} 
	  </script> 
</head>  
<body bottommargin="0" topmargin="0" >
<table align="center" width="100%"  border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr>
  	<td align="center" >
		 	<s:hidden name="jobintentVO.id"  value="%{jobintentVO.id}"/>
		 	<table width="100%" height="300" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="38%"  align="right"><div>目标行业：</td>
                <td width="62%">&nbsp;
					<s:textfield id="jobintentVO_industry" name="jobintentVO.industry" value="%{jobintentVO.industry}"  maxlength="40" />				</td>
              </tr>
              <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;目标职位(关键字)：</td>
                <td>&nbsp;
					<s:textfield id="jobintentVO_jobKeywords" name="jobintentVO.jobKeywords" value="%{jobintentVO.jobKeywords}"  maxlength="30" />				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;期望薪水：</td>
                <td>&nbsp;
					<s:textfield id="jobintentVO_jobSalary" name="jobintentVO.jobSalary" value="%{jobintentVO.jobSalary}"  maxlength="20" />				</td>
              </tr>  
              <tr>
                <td align="right" >工作城市：</td>
                <td >&nbsp;
					 <s:textfield id="jobintentVO_jobCity" name="jobintentVO.jobCity" value="%{jobintentVO.jobCity}"  maxlength="20" />			</td>
              </tr>   
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>        
            </table>
</div>	</td>
  </tr>
</table> 
</body>
</html>
