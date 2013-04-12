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
	<script type="text/javascript">
			function nextStep(){
				window.location.href="${pageContext.request.contextPath}/user/home.htm";
			}
	</script>  
</head>  
<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp" %> 
<div   style=" width:101%; margin-left:-5; margin-right:-15; height:540;background-color:#EFEFEF" align="center">
<br/>
<div class="STYLE9"  align="left" style=" width:80%">  <img src="${pageContext.request.contextPath}/image/img_00012.jpg" height="20"   align="bottom"><span >&nbsp;工作期望</span></div>
<p/>

<s:form id="jobintentForm" method="post" autocomplete="false" action="savejobintent" namespace="/resume">
<div style=" width:80%" align="center">
<%@ include file="jobintent_form.jsp" %>  
</div>
</s:form>
 		<table width="100%" border="0" cellspacing="1" cellpadding="0">
 			  <tr>
                <td><div align="right"></div></td>
                <td><div align="center"><input type="button" value="保&nbsp;存" name="savejobintentBt" id="savejobintentBt" onClick="submitForm()"  style="  
					height:30;width:70;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;<input type="button"  value="进入个人中心" name="nextBt" onClick="nextStep()" style="  
					height:30;width:120;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/></div></td>
              </tr>
        </table>
</div>	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
