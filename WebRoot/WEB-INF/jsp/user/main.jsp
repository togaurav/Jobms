<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>个人中心_干啥儿网—你的职场方向标</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
    <style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
.STYLE2 {font-size: small}
-->
    </style>
	 <script  type="text/javascript">
			function showEdu(){
				window.location.href="${pageContext.request.contextPath}/user/showedu.a";
			}
			function showUser(){
				window.location.href="${pageContext.request.contextPath}/user/showuser.a";
			}
	</script>  
</head>
<body bottommargin="0" topmargin="0">
<%@ include file="../top.jsp"%> 
<div align="center"  style=" width:101%; margin-left:-5; margin-right:-15; height:620;background-color:#FFFFFF">
<table width="1024" border="0" cellpadding="5">
  <tr>
    <td width="204" valign="top"><table width="200" height="323" border="0" cellpadding="5" cellspacing="2">
      <tr>
        <td height="46" colspan="2" class="dh_title">&nbsp;${userInfoVO.userName}</td>
        </tr>
      <tr>
        <td colspan="2"><div align="center"><img src="${pageContext.request.contextPath}/image/signin_u.png" width="164" height="137" /></div></td>
        </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td class="dh_nonselected ">&nbsp;</td>
      </tr>
      <tr>
        <td width="60" align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td width="114" class="dh_nonselected ">查看推荐</td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected ">职业图谱</td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h.png" width="16" height="16" /></td>
        <td class="dh_selected"><strong><div onClick="showUser()" style="cursor:onhand">我的简历</div></strong></td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected">投递历史</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td class="dh_nonselected">&nbsp;</td>
      </tr>	  
    </table></td>
    <td width="794" rowspan="3" align="center" valign="top"><table width="100%" height="320" border="0" cellpadding="5" cellspacing="2">
      <tr>
        <td height="26" class="toplink"><table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#333333">
          <tr>
            <td align="center" bgcolor="#FFFFFF" class="dh_selected"><strong>基本信息</strong></td>
            <td align="center" bgcolor="#666666"><span class="STYLE1" onClick="showEdu();">教育经历</span></td>
            <td align="center" bgcolor="#666666"><span class="STYLE1">工作经历</span></td>
            <td align="center" bgcolor="#666666"><span class="STYLE1">知识技能</span></td>
            <td align="center" bgcolor="#666666"><span class="STYLE1">工作期望</span></td>
          </tr>
        </table>          </td>
      </tr>
      <tr>
        <td height="288" valign="top" class="dh_title"><table width="100%" border="0" cellpadding="1" cellspacing="1"  bgcolor="#CCCCCC">
          <tr>
            <td width="346">
				<%@ include file="../resume/userinfo_form.jsp" %> 
			</td>
          </tr>
 			<tr>
                <td><div align="center"><input type="button" value="保&nbsp;存" name="saveUserInfoBt" id="saveUserInfoBt" onClick="submitForm()"  style="  
					height:30;width:70;color:#000000; background-color:#FFCC66;font-weight:bold;font-size:17px"/></div></td>
              </tr>
        </table>
		</td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td width="204" valign="top"><table width="200" height="45" border="0" cellpadding="4" cellspacing="2" bgcolor="#CCCCCC">
      <tr>
        <td width="23%" height="41"><img src="../img/tag_email.png" width="36" height="26" /></td>
        <td width="77%" class="tabfont">邀请朋友</td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td valign="top"><table width="200" height="62" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
        <td height="27" colspan="2" class="tabfont">邮件订阅</td>
        </tr>
      <tr>
        <td width="69%" height="31">
          <label>
          <input name="textfield" type="text" size="16" />
            </label>
       </td>
        <td width="31%" >
          <input name="Submit" type="button" class="tabfont" value="订阅" />
       </td>
      </tr>
    </table></td>
  </tr>
</table>

</div>
<%@ include file="../bottom.jsp"%> 
</body>
</html>