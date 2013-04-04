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
			function submitForm(){
				if($('#schoolNames_widget').attr("value").length<1){
					alert("学校名称不能为空！");
					return;
				}
				if($('#majorNames_widget').attr("value").length<1){
					alert("专业名称不能为空！");
					return;
				}
				if($('#usereducation').attr("value")==-1){
					alert("请选择一个学历！");
					return;
				}
				document.all.userEducateExpForm.submit();
			}
			function cancel(){
				window.location.href="${pageContext.request.contextPath}/resume/eduexp.a";
			}
			function nextStep(){
				window.location.href="${pageContext.request.contextPath}/resume/workexp.a";
			}
	</script>  
</head>
<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp" %> 
<div  style=" width:101%; margin-left:-5; margin-right:-15; height:620;background-color:#EFEFEF">
<br/>
<div class="STYLE9"   style=" width:80%"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src="${pageContext.request.contextPath}/image/img_00012.jpg" height="20"   align="bottom"><span >&nbsp;教育经历</span></div>
<p/>
<table align="center" width="80%" border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr> <td>&nbsp;</td></tr>
  <tr>
  	<td align="center" >
		<div id="resume_managetab_div" style=" width:100%; height:100%; ">	
	<s:if test="userEducateExpVOList.size>0">
		<%int count=0;%>
		 <s:iterator id="educateexp" value="%{userEducateExpVOList}" status="st">
		 <%count++;%>
		 <table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#000000">
			  <tr> <td>
		 	<table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td width="25%"  align="center">(<%=count%>)&nbsp;
					<strong><s:property value="#educateexp.schoolName" /></strong>
				</td>
				<td width="22%" >
					<s:date name="#educateexp.beginDate" format="yyyy-MM"/> 至 <s:date name="#educateexp.endDate" format="yyyy-MM"/>
				</td>
                <td width="38%" >专业：&nbsp;
					<s:property value="#educateexp.majorName" />
				</td>
                <td width="15%" >
					<a href='${pageContext.request.contextPath}/resume/editeduexp.action?userEducateExpVO.id=<s:property value="#educateexp.id" /> ' class="edit_educateexp_qtip">修改</a>	|
					<a href='${pageContext.request.contextPath}/resume/deleduexp.action?userEducateExpVO.id=<s:property value="#educateexp.id" />'>删除</a>				</td>
              </tr>
            </table>
		 </td>
		 </tr>
        </table>
		</s:iterator>
	</s:if>
		 	<s:form id="userEducateExpForm" method="post"  action="saveeduexp" namespace="/resume">
			<s:hidden name="userEducateExpVO.id"  value="%{userEducateExpVO.id}"/>
		 	<table width="100%" height="269" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td width="36%" height="31" align="right">&nbsp;</td>
                <td width="64%">&nbsp;</td>
              </tr>
              <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;学校名称：</td>
                <td>&nbsp;
					<s:url id="schoolname_remoteurl" action="resume/findSchoolListByTip.action"/>
          			<sj:autocompleter id="schoolNames" 
           			 name="userEducateExpVO.schoolName"
					 href="%{schoolname_remoteurl}"
           			 delay="50"	
					 maxlength="40"
					 autofocus="autofocus"
					 cssStyle="width:30%" 
           			 loadMinimumCount="2"  />
					<s:hidden name="userEducateExpVO.schoolId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;专业名称：</td>
                <td>&nbsp;
					<s:url id="majorname_remoteurl" action="resume/findMajorListByTip.action"/>
          			<sj:autocompleter id="majorNames" 
           			 name="userEducateExpVO.majorName"
					 href="%{majorname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
					 cssStyle="width:30%" 
           			 loadMinimumCount="2"  />
					<s:hidden name="userEducateExpVO.majorId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;最高学历：</td>
                <td>&nbsp;
                  <s:select id="usereducation" name="userEducateExpVO.education"  cssStyle="width:30%"  list="#{-1:'--请选择--',1:'博士后',2:'博士',3:'硕士',4:'本科',5:'大专',6:'其他'}" >				  </s:select>				 </td>
              </tr>
              <tr>
                <td align="right" ><font color="#FF0000">*</font>&nbsp;就读时间：</td>
                <td >&nbsp;
					 <s:select name="userEducateExpVO.beginYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userEducateExpVO.beginMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userEducateExpVO.endYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userEducateExpVO.endMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月				 </td>
              </tr>
			   <tr>
                <td height="19">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="left">
                <input type='button' value="保&nbsp;存" name="saveUserEducateExpBt" onClick="submitForm();" style="  
					height:30;width:70;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;
				<s:if test="isEdit">
					<input type='button' value="取&nbsp;消" name="cancelEditUserEducateExpBt" onClick="cancel()"  style="  
					height:30;width:80;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;
				</s:if>
				<input type='button' value="下一步" name="nextBt" onClick="nextStep()"  style="  
					height:30;width:80;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/>
				
					</div></td>
              </tr>
            </table>
			</s:form>
	    </div> 
	</td>
  </tr>
</table> 	
</div>	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
