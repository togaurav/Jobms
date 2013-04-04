<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>基本信息_干啥儿网</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
</head>  
<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp" %> 
<div  style=" width:101%; margin-left:-5; margin-right:-15; height:620;background-color:#EFEFEF">
<br/>
<%@ include file="userinfo_form.jsp" %>  
 		<table width="100%" border="0" cellspacing="1" cellpadding="0">
 			  <tr>
                <td><div align="right"></div></td>
                <td><div align="left"><input type="button" value="保&nbsp;存" name="saveUserInfoBt" id="saveUserInfoBt" onClick="submitForm()"  style="  
					height:30;width:70;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;<input type="button"  value="下一步" name="nextBt" onClick="nextStep()" style="  
					height:30;width:80;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/></div></td>
              </tr>
        </table>
</div>	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
