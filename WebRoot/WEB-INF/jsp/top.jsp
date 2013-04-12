<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干啥儿网-你的职场方向标</title>
    <link href="${pageContext.request.contextPath}/css/skins/black.css" rel="stylesheet" type="text/css" /> 
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">	
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.hoverIntent.minified.js'></script>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.dcmegamenu.1.3.3.js'></script>
	<script type='text/javascript'>
		jQuery(document).ready(function($) {     
			$('#mega-menu').dcMegaMenu({        
				rowItems: '1',         
				speed: 'fast'
			}); 
			/*$("a").click(function(event){  
            	//event.preventDefault(); 
       	 	});*/ 
			
		}); 
		function resumemanage(){
			var url='${pageContext.request.contextPath}/resume/resumeManage.htm';
			window.location.href=url;
		}
		function showchart(){
			var url='${pageContext.request.contextPath}/match/showCompetencyChart.htm';
			window.location.href=url;
		}
		function register(){
			var url='${pageContext.request.contextPath}/register.htm';
			window.location.href=url;
		}
		function logout(){
			if(!window.confirm("确定要退出吗？"))return;
			var url='${pageContext.request.contextPath}/logout.htm';
			window.location.href=url;
		}
		function login(){
			var url='${pageContext.request.contextPath}/login.htm';
			window.location.href=url;
		} 
		
		function submitForm_top(){
				if($('#loginemail').attr("value").length<1){
					alert("邮箱不能为空！");
					return;
				}
				if($('#loginpassword').attr("value").length<1){
					alert("密码不能为空！");
					return;
				}
				checkLogin_top();
		}
		
		function checkLogin_top(){
			$.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/logincheck/checkEmailAndPass.a?email="+$('#loginemail').attr("value")+"&password="+$('#loginpassword').attr("value"), 
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                         if(result=='0')
{
                          	 $("#checklogindiv_top").html('<font color="red"><strong>邮箱或密码有错！</strong></font>');
                         } else if(result=='1'){
                          	document.all.loginform_top.submit();
                         }
                    },
                    error: function (result) {
                        $("#checklogindiv_top").html('<font color="red"><strong>登录出现异常！</strong></font>');
                    }
                });
		}

	</script>
</head>
<body bottommargin="0" topmargin="0" >	
<div  style=" width:101%; margin-left:-5; margin-right:-15;background-color:#000000">
<table  width="100%" height="45" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000" >
  <tr>
    <td width="76" valign="middle">&nbsp;</td>
    <td width="253" height="37" valign="middle">
		<a href="${pageContext.request.contextPath}/user/home.htm">
			<img src="${pageContext.request.contextPath}/image/logo.jpg"   width="208" height="45" border="0" />		</a>	</td>		
    <td width="52">&nbsp;</td>
    <td width="470">
	<s:if test="#session.user.id!=null">
		<div class="black">
		<ul id="mega-menu" class="mega-menu">
		<li><div onClick="logout()"  style="cursor:hand"><img  src="${pageContext.request.contextPath}/image/logout.png" alt="退出"  width="35" height="30" border="0" /> </div></li> 
		<li><a href="${pageContext.request.contextPath}/manage/manage.htm">后台管理</a></li> 	 	
		<li><a href="${pageContext.request.contextPath}/user/home.htm">个人中心</a></li> 
	 </ul> 
	</div>
	</s:if>
	<s:else>
		<div class="black" style="width:100%;">
		<ul id="mega-menu" class="mega-menu">
			<li><a href="javascript:register()">注册</a></li>
			<li><a href="javascript:login()"><div  style="cursor:hand" >登录</div></a>			
			</li>
		</ul>
		</div>
	</s:else>
	</td>
	 <td width="82">&nbsp;</td>
  </tr>
</table>
</div>
<div style="display:none">
				<ul>         
					<li>
						<s:form name="loginform_top" method="post" action="dologin" namespace="/" >
							<input id="loginemail" name="email" type="text" maxlength="30"    placeholder="邮箱"  style="height:30;width:170;"/><br/>&nbsp;
							<input id="loginpassword" name="password" type="password" maxlength="20"  placeholder="密码"  style="height:30;width:170;"/>
							<br/>
								<div id="checklogindiv_top"></div>
							<br/>
							<input name="submitbt" align="right" type="button" value="登录" onClick="submitForm_top();" style="height:30;width:50;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:16px" />
						</s:form>
					</li>
				</ul>
</div>
</body>
</html>