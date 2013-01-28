<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干啥儿网—你的职场方向标</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
    <style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
.STYLE2 {
	font-size: x-large;
	font-weight: bold;
}
-->
    </style>
</head>
<body bottommargin="0" topmargin="0">
<%@ include file="../top.jsp"%> 
<iframe id="mainFrame" frameborder="0" height="1000" width="100%" style=" background-color:#000000"
 hspace="0" scrolling="no" vspace="0"  src="${pageContext.request.contextPath}/main_home.jsp">
</iframe> 
<%@ include file="../bottom.jsp"%> 
</body>
</html>