<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干啥儿网-你的职场方向标</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
	<link href="${pageContext.request.contextPath}/css/skins/black.css" rel="stylesheet" type="text/css" /> 
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.hoverIntent.minified.js'></script>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.dcmegamenu.1.3.3.js'></script>
	<script type='text/javascript'>
		jQuery(document).ready(function($) {     
			$('#mega-menu').dcMegaMenu({        
				rowItems: '1',         
				speed: 'fast'    
			}); 
			$("a").click(function(event){  
            	event.preventDefault(); 
       	 	}); 
		}); 
		function resumemanage(index){
			var url='resume/resumeManage.action?tabIndex=';
			document.getElementById('mainFrame').src=url+index;
		}
		function showuserchart(){
			var url='match/showUserCompetency.action';
			document.getElementById('mainFrame').src=url;
		}
		function register(){
			var url='user/toregister.action';
			window.location.href=url;
		}
		function logout(){
			var url='user/logout.action';
			window.location.href=url;
		}
		function login(){
			var url='user/tologin.action';
			window.location.href=url;
		}
	</script>
</head>
<body bottommargin="0" topmargin="0" bgcolor="#000000">	
<table  width="100%" height="55" border="0" cellpadding="0" cellspacing="1" bgcolor="#000000" >
  <tr>
    <td width="76" valign="middle">&nbsp;</td>
    <td width="253" height="37" valign="middle">
		<a href="">
			<img src="${pageContext.request.contextPath}/image/logo.jpg" onClick="window.location.href='${pageContext.request.contextPath}/main.jsp'"  width="208" height="54" border="0" />		</a>	</td>		
    <td width="172">&nbsp;</td>
    <td width="370">
	<s:if test="#session.userid!=null">
		<div class="black">
		<ul id="mega-menu" class="mega-menu">
		<li><a href=""><img src="${pageContext.request.contextPath}/image/profile.jpg" width="15" height="15" border="0" /> </a>
	  		<ul>         
	    		<li><div onClick="" style="cursor:hand" ><a href="">账号设置</a></div></li>
	   			<li><div onClick="logout()" style="cursor:hand" ><a href="">退出</a></div></li>
      		</ul>
	  	</li> 
		<li><a href="">数据管理</a>
	  		<ul>         
	    		<li><a href="">ְ职位库管理</a></li>
	   			<li><a href="">ְ专业技能管理</a></li>
				<li><a href="">职能阶层经验值管理</a></li>
      		</ul>
	  	</li> 
		<li><a href="#"><div onClick="resumemanage(0)" style=" cursor:hand" >个人简历</div></a>
	  		<ul>         
	    		<li><div onClick="resumemanage(0)" style="cursor:hand" ><s:a href="#">基本信息</s:a></div></li>
	   			<li><div onClick="resumemanage(1)" style="cursor:hand" ><s:a href="#">专业技能</s:a></div></li>
	    		<li><div onClick="resumemanage(2)" style="cursor:hand" ><s:a href="#">工作经历</s:a></div></li>
				<li><div onClick="resumemanage(3)" style="cursor:hand" ><s:a href="#">教育经历</s:a></div></li>
				<li><div onClick="resumemanage(4)" style="cursor:hand" ><s:a href="#">项目经历</s:a></div></li>
				<li><div onClick="resumemanage(5)" style="cursor:hand" ><s:a href="#">求职意向</s:a></div></li>
      		</ul>
	  	</li> 
		<li><a href="">人职匹配</a>
	  		<ul>         
	    		<li><div onClick="showuserchart()" style="cursor:hand" ><a href="">个人胜任力图谱</a></div></li>
	   			<li><a href="">ְ职位胜任力图谱</a></li>
	    		<li><a href="">人职匹配分析</a></li>
      		</ul>
	  	</li> 
	 </ul> 
	</div>
	</s:if>
	<s:else>
		<div class="black" style="width:100%;">
		<ul id="mega-menu" class="mega-menu">
			<li><div onClick="register()" style="cursor:hand" ><a href="">注册</a></div></li>
			<li><a href=""><div onClick="login()" style="cursor:hand" >登录</div></a>
				<ul>         
					<li>
						<s:form name="loginform" method="post" action="login" namespace="/user" >
							<input name="email" type="text" maxlength="30"    placeholder="邮箱"  style="height:30;width:170;"/><br/>&nbsp;
							<input name="password" type="password" maxlength="20"  placeholder="密码"  style="height:30;width:170;"/>
							<br/><br/>
							<input name="submitbt" align="right" type="submit" value="登录" style="height:30;width:50;color:#000000; background-color:#FF9900;font-size:16px" />
						</s:form>
					</li>
				</ul>
			</li>
		</ul>
		</div>
	</s:else>
	</td>
	 <td width="32">&nbsp;</td>
  </tr>
</table>
</body>
</html>