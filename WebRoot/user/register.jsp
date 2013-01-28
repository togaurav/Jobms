<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
<style type="text/css">
<!--
.STYLE6 {color: #FF0000}
-->
</style>
</head>

<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp"%> 
<br/><br/><br/><br/><br/><br/>
<s:form id="registerForm" method="post"	 action="register" namespace="/user">
<table width="100%" height="500" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td  align="center">
	<div  style="width:100%; height:100%; ">
	<sj:tabbedpanel id="localtabs" selectedTab="0" cssClass="list" cssStyle=" width:50%;font-size:13"> 
	<sj:tab id="tab1" target="tone" label="注册新用户" /> 
	<div id="tone" >
	<table width="100%" height="40%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="37%">&nbsp;</td>
                <td width="36%">&nbsp;</td>
                <td width="27%">&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right">邮箱：<span class="STYLE6">*</span></div></td>
                <td>&nbsp;<input name="email" type="text" maxlength="30"/></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right">密码：<span class="STYLE6">*</span></div></td>
                <td>&nbsp;<input name="password" type="password" maxlength="20"/></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right">确认密码：<span class="STYLE6">*</span></div></td>
                <td>&nbsp;<input name="password2" type="password" maxlength="20"></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><div align="right"><input type="submit" style="height:30;width:60;color:#000000; background-color:#FF9900;font-size:20px" name="Submit" value="注册"></div></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
	</div> 
</sj:tabbedpanel> 
</div> 
    ·</td>
  </tr>
</table>
</s:form>
<%@ include file="../bottom.jsp"%> 

</body>
</html>
