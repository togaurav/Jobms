<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  

<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
</head>
<body bottommargin="0" topmargin="0">
	<s:form id="userWorkExpForm" method="post"  action="saveUserWorkExp" namespace="/resume">
			<s:hidden name="userWorkExpVO.id"  value="%{userWorkExpVO.id}"/>
		 	<table width="100%" height="450" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right"><div>
                 工作类型：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:radio name="userWorkExpVO.jobType"   value="%{userWorkExpVO.jobType}" list="#{1 :'全职', 0 :'实习'}" />				</td>
              </tr>
              <tr>
                <td align="right">公司：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.companyName" value="%{userWorkExpVO.companyName}"   maxlength="40" />
					<s:hidden name="userWorkExpVO.companyId" value="%{userWorkExpVO.companyId}" />				</td>
              </tr>
			  <tr>
                <td align="right">职位名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobName" value="%{userWorkExpVO.jobName}"  maxlength="30" />
					<s:hidden name="userWorkExpVO.jobId" value="%{userWorkExpVO.jobId}"/>				</td>
              </tr>
			  <tr>
                <td align="right">工作地点：<span class="STYLE1">*</span></td>
                <td>&nbsp;
                  <s:select name="userWorkExpVO.jobCity"  cssStyle="width:20%"  value="%{userWorkExpVO.jobCity}" list="#{-1:'--请选择--',1:'北京',2:'上海'}" >				  
				  </s:select>				 
				 </td>
              </tr>
              <tr>
                <td align="right" >在职时间：<span class="STYLE1">*</span></td>
                <td >&nbsp;
					 <s:select name="userWorkExpVO.ondutyYear" value="%{userWorkExpVO.ondutyYear}" list="{'1990','1991','1992','1993','1994','1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.ondutyMonth" value="%{userWorkExpVO.ondutyMonth}" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userWorkExpVO.leaveYear" value="%{userWorkExpVO.leaveYear}" list="{'1990','1991','1992','1993','1994','1995','1996','1997','1998','1999','2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.leaveMonth" value="%{userWorkExpVO.leaveMonth}" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月
				  <input type='checkbox' name="userWorkExpVO.nowdate" value="true" /> 至今				
				 </td>
              </tr>
              
              <tr>
                <td align="right">薪水（税前）：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobSalary" value="%{userWorkExpVO.leaveMonth}"  maxlength="10"/>				</td>
              </tr>
              <tr>
                <td align="right">相关技能：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobSkill" value="%{userWorkExpVO.jobSkill}" maxlength="80" />				
				</td>
              </tr>
			   <tr>
                <td align="right"></td>
                <td>&nbsp;
					<input type='checkbox' name="userWorkExpVO.lastJob" value="true"/>是否是最近一份工作				
				</td>
              </tr>
              <tr>
                <td align="right">工作描述：</td>
                <td>&nbsp;
					<s:textarea name="userWorkExpVO.jobDesc" cols="45" rows="5" value="%{userWorkExpVO.jobDesc}"/>				
				 </td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="保存" name="saveUserWorkExpBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
</body>
</html>
