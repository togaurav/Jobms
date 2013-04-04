<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干啥儿网—你的职场方向标</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
	<script type='text/javascript'>
	function login(){
			var url='${pageContext.request.contextPath}/login.a';
			window.location.href=url;
	}
	function register(){
			var url='${pageContext.request.contextPath}/register.a';
			window.location.href=url;
	}
	</script>
</head>
<body bottommargin="0" topmargin="0" bgcolor="#000000">	
<table  width="100%" height="45" border="0" cellpadding="0" cellspacing="1">
  <tr>
    <td width="30%" height="45" align="right">
		<font color="#FFFFFF"><strong>想招人？从此进入</strong></font>
	</td>
	<td width="40%" height="45" >
	</td>
	<td width="15%" height="45" align="right" valign="middle">
		<a href="javascript:login()"><div  style="cursor:hand" ><font color="#FFFFFF"><strong>登录&nbsp;&nbsp;</strong></font></div></a>
	</td>
	<td width="15%" height="45" align="left"  valign="middle">
		<a href="javascript:register()"><font color="#FFFFFF"><strong>&nbsp;&nbsp;注册</strong></font></a>
	</td>
</tr>
</table>		
<div style="width:101%; margin-left:-5; margin-right:-15">
  <table width="100%" height="620"  border="0" cellspacing="0" cellpadding="1" bgcolor="#FFFFFF">
      
      <tr>
        <td width="55%" ><div align="right" ><img src="image/left.png" ></div></td>
        <td width="1%">&nbsp;</td>
        <td width="44%" >&nbsp;
		<div align="left">
			<a href="javascript:register()" target="_self"><img src="image/indreg.png" border="0" ></a> </div>
		</td>
      </tr>
    </table>
</div>
<%@ include file="WEB-INF/jsp/bottom.jsp"%> 
</body>
</html>
