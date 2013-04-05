<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>职能参数管理</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划"> 
	<link href="${pageContext.request.contextPath}/css/alink.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    \
		<!--
		.STYLE1 {color: #FF0000}
		.STYLE4 {color: #FFFFFF}
		.qtip-wiki{
			max-width: 600px;
		}
		.over { background-color: #EFEFEF}
		.out {filter: Gray}
		-->
    </style>
    <script  type="text/javascript">
		function matchtest(){
			window.location.href="${pageContext.request.contextPath}/match/ready.a";
		}
		function jobmanage(){
			manageFrame.window.location.href="${pageContext.request.contextPath}/job/jobManage.a";
		}
		function abilitymanage(){
			manageFrame.window.location.href="${pageContext.request.contextPath}/ability/manage.a";
		}
		function funcmanage(){
			manageFrame.window.location.href="${pageContext.request.contextPath}/job/growthmanage.a";
		}
		function majormanage(){
			manageFrame.window.location.href="${pageContext.request.contextPath}/major/majorManage.a";
		}
	</script>  
</head>  
<body bottommargin="0" topmargin="0" bgcolor="#000000" >
<%@ include file="../top.jsp"%> 
<div  style=" width:101%; margin-left:-5; margin-right:-15; height:530; background-color:#FFFFFF">
<br/>
<table  width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" >
  <tr>
  	<td width="16%" align="center" >
		<table width="174"  border="0" cellpadding="5" cellspacing="2">
      <tr>
        <td colspan="2" align="right"><hr></td>
        </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected"><div align="center"><a href="${pageContext.request.contextPath}/match/ready.a"  target="_blank" onMouseOver="this.className='over'" onMouseOut="this.className='out'" >人职匹配验证</a></div></td>
      </tr>	  
      <tr>
        <td width="27" align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td width="121" class="dh_nonselected "><div onClick="jobmanage()" onMouseOver="this.className='over'" onMouseOut="this.className='out'"  style="cursor:hand">
          <div align="center">标准职位管理</div>
        </div></td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected "><div onClick="abilitymanage()" onMouseOver="this.className='over'" onMouseOut="this.className='out'"  style="cursor:hand">
          <div align="center">知识技能管理</div>
        </div></td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h.png" width="16" height="16" /></td>
        <td class="dh_nonselected"><div onClick="funcmanage()" onMouseOver="this.className='over'" onMouseOut="this.className='out'"  style="cursor:hand">
          <div align="center">职能阶层管理</div>
        </div></td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected"><div onClick="majormanage()" onMouseOver="this.className='over'" onMouseOut="this.className='out'"  style="cursor:hand">
          <div align="center">学校专业管理</div>
        </div></td>
      </tr>
      <tr>
        <td colspan="2" align="right"><hr></td>
      </tr>
	  <tr>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>
	   <tr>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>	 
	   <tr>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>
	   <tr>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>	 
	   <tr>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>
	   <tr>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>	  
    </table>
	</td>
	<td width="83%" align="center" >
		<iframe id="manageFrame" width="100%"  height="100%" scrolling="no" frameborder="0"   src=""></iframe>
	</td>
  </tr>
</table> 	
</div>	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
