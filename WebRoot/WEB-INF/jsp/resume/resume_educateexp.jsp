<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>教育经历_干啥儿网</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
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
		.STYLE9 {
			font-size: 22;
			font-weight: bold;
		}
		-->
    </style>
	<script  type="text/javascript">	
			function cancel(){
				window.location.href="${pageContext.request.contextPath}/resume/eduexp.htm";
			}
			function nextStep(){
				window.location.href="${pageContext.request.contextPath}/resume/workexp.htm";
			}
	</script>  
</head>
<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp" %> 
<div  style=" width:101%; margin-left:-5; margin-right:-15; height:540;background-color:#EFEFEF" align="center">
<br/>
<div class="STYLE9" align="left"  style=" width:80%"> <img src="${pageContext.request.contextPath}/image/img_00012.jpg" height="20"   align="bottom"><span >&nbsp;教育经历</span></div>
<p/>
<div style=" width:80%" align="center" >
	<s:if test="userEducateExpVOList.size>0">
		<%int count=0;%>
		 <s:iterator id="educateexp" value="%{userEducateExpVOList}" status="st">
		 <%count++;%>
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" >
			  <tr> <td>
		 	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
		 	<tr> <td>&nbsp;</td></tr>
              <tr>
                <td width="25%"  align="center">(<%=count%>)&nbsp;
					<strong><s:property value="#educateexp.schoolName" /></strong>
				</td>
				<td width="22%" >
					<s:date name="#educateexp.beginDate" format="yyyy-MM"/> 至 <s:date name="#educateexp.endDate" format="yyyy-MM"/>
				</td>
                <td width="41%" >专业：&nbsp;
					<s:property value="#educateexp.majorName" />
				</td>
                <td width="12%" >
					<a href='${pageContext.request.contextPath}/resume/editeduexp.htm?userEducateExpVO.id=<s:property value="#educateexp.id" /> ' class="edit_educateexp_qtip">修改</a>	|
					<a href='${pageContext.request.contextPath}/resume/deleduexp.htm?userEducateExpVO.id=<s:property value="#educateexp.id" />'>删除</a>				</td>
              </tr>
            </table>
		 </td>
		 </tr>
        </table>
		</s:iterator>
	</s:if>
		 	<s:form id="userEducateExpForm" method="post"  action="saveeduexp" namespace="/resume">
				<%@ include file="educateexp_form.jsp" %>  
			</s:form>
		</div>				
 		<table width="100%" border="0" cellspacing="1" cellpadding="0">
			 <tr>
                <td><div align="right"></div></td>
                <td><div align="center">
                <input type='button' value="保&nbsp;存" name="saveUserEducateExpBt" onClick="submitForm();" style="  
					height:30;width:70;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;
				<s:if test="isEdit">
					<input type='button' value="取&nbsp;消" name="cancelEditUserEducateExpBt" onClick="cancel()"  style="  
					height:30;width:70;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;
				</s:if>
				<input type='button' value="下一步" name="nextBt" onClick="nextStep()"  style="  
					height:30;width:80;color:#FFFFFF; border-style:none; background-color:#000000;font-weight:bold;font-size:17px"/>				
					</div></td>
              </tr>
		</table>

</div>	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
