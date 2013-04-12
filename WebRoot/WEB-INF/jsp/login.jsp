<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录_干啥儿网</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
</head>

<body bottommargin="0" topmargin="0" >
<%@ include file="top.jsp" %> 
<div align="center"   style=" width:101%; margin-left:-5; margin-right:-15;height:540;background-color:#FFFFFF">
<br/><br/><br/><br/><br/>
<%@ include file="login_form.jsp"%> 
</div>
<%@ include file="bottom.jsp"%> 
</body>
</html>
