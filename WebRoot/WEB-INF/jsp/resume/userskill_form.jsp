<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>知识技能_干啥儿网</title>
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
				if($('#skillVO_skill_widget').attr("value").length<1){
					alert("技能名称不能为空！");
					return;
				}
				if($('#skillVO_masterDegree').attr("value")==-1){
					alert("请选择掌握程度！");
					return;
				}
				if($('#skillVO_masterYears').attr("value")==-1){
					alert("请选择使用时长！");
					return;
				}
				document.all.userSkillForm.submit();
			}
	</script>  
</head>
<body bottommargin="0" topmargin="0" >
<table align="center" width="100%" border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr> <td>&nbsp;</td></tr>
  <tr>
  	<td align="center" >
			<s:hidden name="skillVO.id"  value="%{skillVO.id}"/>
		 	<table width="100%" height="150" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td height="31" colspan="6" align="right"><s:if test="skillVOList.size>0"><hr></s:if></td>
              </tr>
              <tr>
                <td width="15%" align="right"><div align="right"><font color="#FF0000">*</font>&nbsp;技能名称：</div></td>  
                <td width="21%">&nbsp;
					<s:url id="abilityName_remoteurl" action="findAbilityListByTip" namespace="/ability"/>
       			<sj:autocompleter id="skillVO_skill" 
           			 name="skillVO.skill"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />				</td>
					 <td width="12%"><div align="right"><font color="#FF0000">*</font>&nbsp;掌握程度：</div></td>
					 <td width="15%">&nbsp;
			    <s:select id="skillVO_masterDegree" name="skillVO.masterDegree"  cssStyle="width:80"  list="#{-1:'--请选择--',1:'了解',2:'掌握',3:'熟练',4:'精通'}" >	</s:select></td>
					 <td width="12%" align="right"><div align="right"><font color="#FF0000">*</font>&nbsp;使用时长：</div></td>
                <td width="15%">&nbsp;
                <s:select id="skillVO_masterYears" name="skillVO.masterYears"  cssStyle="width:80"  list="#{-1:'--请选择--',1:'1年',2:'2年',3:'3年',4:'4年',5:'5年',6:'6年',7:'7年',8:'8年',9:'9年',10:'10年以上'}" >				  </s:select>	</td>
              </tr>
			   <tr>
                <td height="19">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
				<td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>             
            </table>			 
	</td>
  </tr>
</table> 	
</body>
</html>
