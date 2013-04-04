<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册_干啥儿网</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
	<script type='text/javascript'>
	var isEmailCheckOk=false;
	function submitForm(){
				if($('#useremail').attr("value").length<1){
					alert("邮箱不能为空！");
					return;
				}
				if($('#userpassword').attr("value").length<1){
					alert("密码不能为空！");
					return;
				}
				if($('#userpassword').attr("value").length<6){
					alert("密码至少6位数！");
					return;
				}
				if($('#userpassword2').attr("value")!=$('#userpassword').attr("value")){
					alert("两次密码输入不一致！");
					return;
				}
				if(isEmailCheckOk)
{
					document. all.registerForm.submit();
				}else{
					alert("邮箱已经存在！");
				}
		}
		
		function checkEmail(){
			if($('#useremail').attr("value").trim().length<4)
 { 
				return;	
			} 

			$.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/logincheck/checkEmail.action?email="+$('#useremail').attr("value"),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                         $("#emailcheckdiv").html(result);
                          if(result.indexOf('green')>0){
                           	isEmailCheckOk =true;
                          }
                    },
                    error: function (result) {
                        $("#emailcheckdiv").html('<font color="red">出现异常！</font>');
                    }
                });
			
		}
		
		function login(){
			window.location.href="${pageContext.request.contextPath}/";
		}
</script>
    <style type="text/css">
<!--
.STYLE8 {
	color: #FF0000;
	font-weight: bold;
}
.STYLE9 {
	font-size: 22;
	font-weight: bold;
}
.STYLE10 {color: #FFFFFF}
#Layer1 {
	position:absolute;
	width:177px;
	height:81px;
	z-index:1;
	left: 868px;
	top: 260px;
}
-->
    </style>
</head>

<body bottommargin="0" topmargin="0" >
<%@ include file="top.jsp" %> 
<div  style=" width:101%; margin-left:-5; margin-right:-15; height:620;background-color:#EFEFEF">
<br/>
<div class="STYLE9"   style=" width:80%"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src="${pageContext.request.contextPath}/image/img_00012.jpg" height="20"   align="bottom"><span >&nbsp;新用户注册</span></div>
<p/>
<s:form id="registerForm" method="post"	 action="doregister" namespace="/">
<table align="center" width="80%" height="450" border="0" cellspacing="0" cellpadding="0"  bgcolor="#FFFFFF">
  <tr>
    <td  align="center">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td width="16%">&nbsp;</td>
                <td width="30%">&nbsp;</td>
                <td width="18%">&nbsp;</td>
                <td width="36%" rowspan="7">&nbsp;                  <img src="${pageContext.request.contextPath}/image/middle_line.jpg" width="15" height="233">
                  <div id="Layer1">
                    <p align="center">已经有干啥儿账号？</p>
                    <p align="center"><input type="button"  onClick="login()"  style="height:30;width:70;color:#000000; background-color:#FFFF99;font-size:17px" name="Submit" value="登&nbsp;陆">&nbsp;</p>
                  </div>                </td>
              </tr>
              <tr>
                <td height="50"></td>
                <td><nobr><span ><font color="#FF0000">*</font>&nbsp;<font size="4">邮箱：</font></span>&nbsp;
                  <input id="useremail" onBlur="checkEmail()" name="email" type="text" maxlength="30" style="line-height:30px;font-size:20px; height:30;width:200;" autofocus="autofocus"/></nobr>				 </td>
                <td width="18%"><div id="emailcheckdiv" ></div></td>
              </tr>
              <tr>
                <td height="47"></td>
                <td><nobr><span ><font color="#FF0000">*</font>&nbsp;<font size="4">密码：</font></span>&nbsp;
				<input  id="userpassword" name="password" type="password" maxlength="20" style="line-height:30px;font-size:20px; height:30;width:200;"/></nobr></td>
                <td width="18%">&nbsp;</td>
              </tr>
              <tr>
                <td height="40"></td>
                <td><nobr><span ><font color="#FF0000">*</font>&nbsp;<font size="4">确认：</font></span>&nbsp;
				<input  id="userpassword2"  name="password2" type="password" maxlength="20" style="line-height:30px;font-size:20px; height:30;width:200;">
				</nobr></td>
                <td width="18%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td width="18%">&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><div align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="button"  onclick="submitForm();"  style="height:30;width:95;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px" name="Submit" value="立即注册">
                </div></td>
                <td width="18%">&nbsp;</td>
              </tr>
              <tr>
                <td height="50">&nbsp;</td>
                <td><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="checkbox" type="checkbox" value="checkbox" checked>
                已阅读并同意干啥儿服务条款</label></td>
                <td width="18%">&nbsp;</td>
              </tr>
        </table>
	</td>
  </tr>
</table>
</s:form>
</div>
<%@ include file="bottom.jsp"%> 
</body>
</html>
