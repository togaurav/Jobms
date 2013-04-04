<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>工作经历_干啥儿网</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
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
     <script type="text/javascript">
			function submitForm(){
				if($('#companyNames_widget').attr("value").length<1){
					alert("公司名称不能为空！");
					return;
				}
				if($('#jobNames_widget').attr("value").length<1){
					alert("职位名称不能为空！");
					return;
				}
				if($('#userJobCity').attr("value")==-1){
					alert("请选择工作地点！");
					return;
				}
				document. all.userWorkExpForm.submit();
			}
			function cancel(){
				window.location.href='${pageContext.request.contextPath}/resume/workexp.a';
			}
			function nextStep(){
				window.location.href="${pageContext.request.contextPath}/user/home.a";
			}
	</script>  
</head>  
<body bottommargin="0" topmargin="0">
<%@ include file="../top.jsp" %> 
<div  style=" width:101%; margin-left:-5; margin-right:-15; height:620;background-color:#EFEFEF">
<br/>
<div class="STYLE9"   style=" width:80%"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src="${pageContext.request.contextPath}/image/img_00012.jpg" height="20"   align="bottom"><span >&nbsp;工作经历</span></div>
<p/>
<table align="center" width="80%" border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr> <td>&nbsp;</td></tr>
  <tr>
  	<td align="center" >
		<div id="resume_managetab_div" style=" width:100%; height:100%; ">
	<s:if test="userWorkExpVOList.size>0">
	<%int count=0;%>
		 <s:iterator id="workexp" value="%{userWorkExpVOList}" status="st">
		  <%count++;%>
		 <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> <td>
		 	<table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td width="40%" align="center">(<%=count%>)&nbsp;
					<strong><s:property value="#workexp.companyName" /></strong>&nbsp;&nbsp;&nbsp;
					<strong><s:property value="#workexp.jobName" /></strong>
				</td>
				<td width="25%">		
					<s:if test="#workexp.isLastJob">
						<s:date name="#workexp.ondutyDate" format="yyyy-MM"/> 至今
					</s:if>
					<s:else>
						<s:date name="#workexp.ondutyDate" format="yyyy-MM"/> 至 <s:date name="#workexp.leaveDate" format="yyyy-MM"/>
					</s:else>
					
				</td>
				<td width="25%">&nbsp;
				</td>
				<td width="10%">
					<a href='${pageContext.request.contextPath}/resume/editworkexp.a?userWorkExpVO.id=<s:property value="#workexp.id" /> '>修改</a>	 |<a href='${pageContext.request.contextPath}/resume/delworkexp.a?userWorkExpVO.id=<s:property value="#workexp.id" />'>删除</a>								
				</td>
              </tr>
            </table>
		 </td>
		 </tr>
        </table>
		</s:iterator>
	</s:if>
		 	<s:form id="userWorkExpForm" method="post"  action="saveworkexp" namespace="/resume">
			<s:hidden name="userWorkExpVO.id"  value="%{userWorkExpVO.id}"/>
		 	<table width="100%" height="450" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td width="34%"  align="right">&nbsp;</td>
                <td width="66%">&nbsp;</td>
              </tr>
              <tr>
                <td  align="right">
                 <font color="#FF0000">*</font>&nbsp;工作类型：</td>
                <td>&nbsp;
					<s:radio name="userWorkExpVO.jobType"  value="1" list="#{1 :'全职', 0 :'实习'}" />				</td>
              </tr>
              <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;公司名称：</td>
                <td>&nbsp;
					<s:url id="companyname_remoteurl" action="resume/findCompanyListByTip.action"/>
          			<sj:autocompleter id="companyNames" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
					 autofocus="autofocus"
					 cssStyle="width:30%" 
           			 loadMinimumCount="2"  />
					<s:hidden name="userWorkExpVO.companyId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;职位名称：</td>
                <td>&nbsp;
					<s:url id="jobname_remoteurl" action="resume/findJobListByTip.action"/>
          			<sj:autocompleter id="jobNames" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
					 cssStyle="width:30%" 
           			 loadMinimumCount="2"  />
					<s:hidden name="userWorkExpVO.jobId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;工作地点：</td>
                <td>&nbsp;
                  <s:select id="userJobCity" name="userWorkExpVO.jobCity"  cssStyle="width:30%"  list="#{1:'北京',2:'上海'}" >				  </s:select>				 </td>
              </tr>
              <tr>
                <td align="right" ><font color="#FF0000">*</font>&nbsp;在职时间：</td>
                <td >&nbsp;
					 <s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月
				  <input type='checkbox' name="userWorkExpVO.nowdate" value="true" /> 至今				 </td>
              </tr>
              
              <tr>
                <td align="right">薪水（税前）：</td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobSalary" cssStyle="width:30%"  maxlength="8"/>				</td>
              </tr>
			   <tr>
                <td align="right"></td>
                <td>&nbsp;
					<input type='checkbox' name="userWorkExpVO.lastJob" value="true"/>是否是最近一份工作				</td>
              </tr>
              <tr>
                <td align="right">工作描述：</td>
                <td>&nbsp;
					<s:textarea name="userWorkExpVO.jobDesc" maxlength="1000" cols="60" rows="5"/>				</td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="left">
                <input type='button'  value="保&nbsp;存" name="saveUserWorkExpBt"  onclick="submitForm();" style="  
					height:30;width:70;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;
				<s:if test="isEdit">
				<input type='button' value="取&nbsp;消" name="cancelUserWorkExpBt" onClick="cancel();" style="  
					height:30;width:70;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/>&nbsp;&nbsp;
				</s:if>
				<input type='button' value="进入个人中心" name="nextBt" onClick="nextStep()"  style="  
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
