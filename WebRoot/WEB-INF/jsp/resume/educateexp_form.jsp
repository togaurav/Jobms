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
	</script>  
</head>
<body bottommargin="0" topmargin="0" >
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr> <td>&nbsp;</td></tr>
  <tr>
  	<td align="center" >
			<s:hidden name="userEducateExpVO.id"  value="%{userEducateExpVO.id}"/>
		 	<table width="100%" height="300" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td height="31" colspan="2" align="right"><s:if test="userEducateExpVOList.size>0"><hr></s:if></td>
              </tr>
              <tr>
                <td width="36%" align="right"><font color="#FF0000">*</font>&nbsp;学校名称：</td>
                <td width="64%">&nbsp;
					<s:url id="schoolname_remoteurl" action="findSchoolListByTip"  namespace="/resume"/>
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
					<s:url id="majorname_remoteurl" action="findMajorListByTip"  namespace="/resume"/>
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
            </table>			 
	</td>
  </tr>
</table> 	
</body>
</html>
