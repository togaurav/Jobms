<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
<style type="text/css">
<!--
.STYLE8 {font-size: x-small}
.STYLE10 {
	font-family: "微软雅黑";
	font-size: x-large;
	font-weight: bold;
}
-->
</style>
<script type='text/javascript'>
		function submitForm(){
				if($('#email').attr("value").length<1){
					alert("邮箱不能为空！");
					return;
				}
				if($('#password').attr("value").length<1){
					alert("密码不能为空！");
					return;
				}
				
				checkLogin();
		}
		function checkLogin(){
			$.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/logincheck/checkEmailAndPass.action?email="+$('#email').attr("value")+"&password="+$('#password').attr("value"), 
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                         if(result=='0'){
                          	 $("#checklogindiv").html('<font color="red"><strong>邮箱或密码有错！</strong></font>');
                         } else if(result=='1'){
                           	 $("#checklogindiv").html('');
                          	document.all.loginForm.submit();
                         }
                    },
                    error: function (result) {
                        $("#checklogindiv").html('<font color="red"><strong>登录出现异常！</strong></font>');
                    }
                });
		}
</script>
</head>

<body bottommargin="0" topmargin="0" >
<div align="center">
    <span class="STYLE10">规划职业路线&nbsp;&nbsp;推荐合适工作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br/>
	<img src="image/main_img1.jpg" width="49" height="49"><br/>
    <span class="STYLE10">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成就职场精英&nbsp;&nbsp;点亮人生方向</span><br/>
    <br/><br/><br/>
</div>
<s:form id="loginForm" method="post"	 action="dologin" namespace="/">
  <div align="center">
    <table width="100%" cellspacing="1" cellpadding="1" >
      <tr>
        <td  align="center">
          <table width="100%" height="40%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="59"></td>
              <td height="59"><div align="left"><img src="${pageContext.request.contextPath}/image/signin_u.png" width="34" height="37">&nbsp;求职者 &nbsp;<img src="image/signh.png" width="3" height="30">  &nbsp;<img src="image/signin_biz_dan.png" width="52" height="32">&nbsp;雇主</div></td>
              <td height="59">&nbsp;</td>
            </tr>
            <tr>
              <td width="42%" height="35"><div align="right">邮箱：</div></td>
              <td width="31%">&nbsp;<input id="email" name="email"   style="width:200;height:30; font-size:18px" unfocus="checkLogin()" type="text" maxlength="30" placeholder="请输入邮箱"  autofocus="autofocus"/></td>
              <td width="27%">&nbsp;</td>
            </tr>
            <tr>
              <td height="45"><div align="right">密码：</div></td>
              <td>&nbsp;<input  id="password" name="password" type="password" style="width:200;height:30; font-size:18px" maxlength="20" placeholder="请输入密码"  /></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="36">&nbsp;</td>
              <td><div id="checklogindiv">
                  <label>
                  <input type="checkbox" name="checkbox" value="checkbox" checked>
                  <span class="STYLE8">下次自动登录</span></label>
                  <span class="STYLE8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               忘记密码?</span></div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td height="38">&nbsp;</td>
              <td><div align="left">
                  <input type="button" onClick="submitForm();" style="  
					height:30;width:70;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px" name="Submit2" value="登&nbsp;录">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="STYLE8">&nbsp;<a href="${pageContext.request.contextPath}/register.a" target="_self">立即注册</a> </span></div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </table></td>
    </tr>
    </table>
  </div>
</s:form>

</body>
</html>
