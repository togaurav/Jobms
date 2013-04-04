<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人简历</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
</head>
	
<body bottommargin="0" topmargin="0" bgcolor="#000000" >
<%@ include file="../top.jsp"%> 
<iframe id="userinfoFrame" frameborder="0" height="530"  width="100%" style=" background-color:#000000"
 hspace="0" scrolling="no" vspace="0"  src="${pageContext.request.contextPath}/resume/showUserInfo.action">
</iframe> 
<iframe id="userinfoFrame" frameborder="0" height="900"  width="100%" style=" background-color:#000000"
 hspace="0" scrolling="no" vspace="0"  src="${pageContext.request.contextPath}/resume/showUserWorkExp.action">
</iframe> 
<iframe id="userinfoFrame" frameborder="0" height="520"  width="100%" style=" background-color:#000000"
 hspace="0" scrolling="no" vspace="0"  src="${pageContext.request.contextPath}/resume/showUserEducateExp.action">
</iframe> 
<%@ include file="../bottom.jsp"%> 
</body>
</html>
