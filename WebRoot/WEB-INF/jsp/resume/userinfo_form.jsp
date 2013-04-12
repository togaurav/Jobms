<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>基本信息_干啥儿网</title>
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
     <script type="text/javascript">
			function submitForm(){
				if($('#userInfoVO_userName').attr("value").length<1){
					alert("姓名不能为空！");
					return;
				}
				document.all.userinfoForm.submit();
			} 
	  </script> 
</head>  
<body bottommargin="0" topmargin="0" >
<table align="center" width="100%"  border="0" cellpadding="0" cellspacing="1"  bgcolor="#FFFFFF">
  <tr>
  	<td align="center" >
		<div id="resume_managetab_div" style=" width:100%; height:100%; ">
		 	<s:hidden name="userInfoVO.userId"  value="%{userInfoVO.userId}"/>
		 	<table width="100%" height="390" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right">&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td width="38%"  align="right"><div>
                 <font color="#FF0000">*</font>&nbsp;姓名：</td>
                <td width="62%">&nbsp;
					<s:textfield id="userInfoVO_userName" name="userInfoVO.userName" value="%{userInfoVO.userName}" title="此处输入您的真实姓名" autofocus="autofocus" maxlength="20" />				</td>
              </tr>
              <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;性别：</td>
                <td>&nbsp;
					<s:radio name="userInfoVO.userGender"  value="%{userInfoVO.userGender}" list="#{1 :'男', 0 :'女'}" />				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;手机：</td>
                <td>&nbsp;
					<s:textfield name="userInfoVO.userPhone"  value="%{userInfoVO.userPhone}" title="此处输入您的手机号"  maxlength="15" />				</td>
              </tr>  
              <tr>
                <td align="right" ><font color="#FF0000">*</font>&nbsp;出生日期：</td>
                <td >&nbsp;
					 <sj:datepicker name="userInfoVO.userBirthday"  value="%{userInfoVO.userBirthday}" displayFormat="yy-mm-dd"  changeYear="true"  yearRange="-40:+0" readonly="true"/>				</td>
              </tr>
			  <tr>
                <td align="right"><font color="#FF0000">*</font>&nbsp;所在城市：</td>
                <td>&nbsp;
                  <s:select name="userInfoVO.userCity"  cssStyle="width:25%" value="%{userInfoVO.userCity}"  list="#{-1:'--请选择--',1:'北京',2:'上海'}" >				  </s:select>				 </td>
              </tr>				  
              <tr>
                <td align="right">&nbsp;工作经验：</td>
                <td>&nbsp;
					 <s:select name="userInfoVO.userServicelen" value="%{userInfoVO.userServicelen}" cssStyle="width:25%" list="#{-1:'--请选择--',0.0:'1年内',1.0:'1年',2.0:'2年',3.0:'3年',4.0:'4年',5.0:'5年',6.0:'6年',7.0:'7年',8.0:'8年',9.0:'9年',10.0:'10年',11.0:'10年以上'}" >				  </s:select>				</td>
              </tr>
              <tr>
                <td align="right">&nbsp;职业身份：</td>
                <td>&nbsp;
					<s:select name="userInfoVO.userRole"  cssStyle="width:25%"  value="%{userInfoVO.userRole}" list="#{-1:'--请选择--',1:'应届毕业生',2:'初级人员',3:'中高级人员',4:'资深专家',5:'基层管理',6:'中高层管理',7:'总监',8:'总裁/CEO'}" >				  </s:select>				</td>
              </tr>		  
              <tr>
                <td align="right">自我介绍：</td>
                <td>&nbsp;
					<s:textarea name="userInfoVO.userDesc"  value="%{userInfoVO.userDesc}" maxlength="200" cols="40" rows="5"/>				
				</td>
              </tr>       
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>        
            </table>
</div>	</td>
  </tr>
</table> 
</body>
</html>
