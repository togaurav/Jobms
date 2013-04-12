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
	<link href="${pageContext.request.contextPath}/css/alink.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
			function nextStep(){
				window.location.href="${pageContext.request.contextPath}/resume/eduexp.htm";
			}
	</script>  
</head>  
<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp" %> 
<div   style=" width:101%; margin-left:-5; margin-right:-15; height:540;background-color:#EFEFEF" align="center">
<br/>
<div class="STYLE9"  align="left" style=" width:80%">  <img src="${pageContext.request.contextPath}/image/img_00012.jpg" height="20"   align="bottom"><span >&nbsp;基本信息</span></div>
<p/>

<s:form id="userinfoForm" method="post" autocomplete="false" action="saveuserinfo" namespace="/resume">
<div style=" width:80%" align="center">
<%@ include file="userinfo_form.jsp" %>  
</div>
</s:form>
 		<table width="100%" border="0" cellspacing="1" cellpadding="0">
 			  <tr>
                <td><div align="right"></div></td>
                <td><div align="center"><input type="button" value="保&nbsp;存" name="saveUserInfoBt" id="saveUserInfoBt" onClick="submitForm()"  style="  
					height:30;width:70;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;<input type="button"  value="下一步" name="nextBt" onClick="nextStep()" style="  
					height:30;width:80;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/></div></td>
              </tr>
        </table>
</div>	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
