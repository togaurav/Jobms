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
	<link href="${pageContext.request.contextPath}/css/alink.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
-->
    </style>
	 <script  type="text/javascript">
			function showEdu(){
				window.location.href="${pageContext.request.contextPath}/user/showeduexp.htm";
			}
			function showUser(){
				window.location.href="${pageContext.request.contextPath}/user/showuserinfo.htm";
			}
			function showWorkexp(){
				window.location.href="${pageContext.request.contextPath}/user/showworkexp.htm";
			}
			function showUserSkill(){
				window.location.href="${pageContext.request.contextPath}/user/showuserskill.htm";
			}
			function showJobintent(){
				window.location.href="${pageContext.request.contextPath}/user/showjobintent.htm";
			}
			function showRecommend(){
				window.location.href="${pageContext.request.contextPath}/user/home.htm";
			}
	</script>  
</head>
<body bottommargin="0" topmargin="0">
<%@ include file="../top.jsp"%> 
<div align="center"  style=" width:101%; margin-left:-5; margin-right:-15; background-color:#FFFFFF">
<table width="1024" border="0" cellpadding="5">
  <tr>
    <td width="204" valign="top"><table width="200" height="323" border="0" cellpadding="5" cellspacing="2">
      <tr>
        <td height="46" colspan="2" class="dh_title">&nbsp;${session.user.name}</td>
        </tr>
      <tr>
        <td colspan="2"><div align="center"><img src="${pageContext.request.contextPath}/image/signin_u.png" width="164" height="137" /></div></td>
        </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td class="dh_nonselected ">&nbsp;</td>
      </tr>
      <tr>
        <td width="60" align="right"><img src="${pageContext.request.contextPath}/image/arrow_right.jpg" width="16" height="16" /></td>
        <td width="114" class="dh_selected"><div onClick="showRecommend()" style="cursor:hand"><strong>查看推荐</strong></div></td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h.png" width="16" height="16" /></td>
        <td class="dh_nonselected "><div onClick="showUser()" style="cursor:hand">我的简历</div></td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected ">职业路径</td>
      </tr>
      <tr>
        <td align="right"><img src="${pageContext.request.contextPath}/image/tag_h_dan.png" width="16" height="16" /></td>
        <td class="dh_nonselected">职业命格</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td class="dh_nonselected">&nbsp;</td>
      </tr>	  
    </table></td>
    <td width="794" rowspan="3" align="center" valign="top"><table width="100%" height="320" border="0" cellpadding="5" cellspacing="2">
      <tr>
        <td height="288" valign="top" class="dh_title">
			<table width="100%" height="336" border="0" cellpadding="0" cellspacing="1">
      <tr>
        <td height="26" bgcolor="#999999" class="toplink"><table width="100%" border="0" cellspacing="1" cellpadding="2">
            <tr>
              <td width="51%"><span class="STYLE1">按相关度排序▼ | 按职位更新时间排序 </span></td>
              <td width="49%" align="right">&nbsp;</td>
            </tr>
          </table></td>
      </tr>
      <tr>
        <td height="288" valign="top">
		<table width="100%" border="0" cellspacing="1" cellpadding="5">
          <tr>
            <td>
			<s:if test="opplist.size>0">
	   <s:iterator id="opportunity" value="%{opplist}" status="st">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
              <tr>
                <td width="10%" rowspan="3" align="center" valign="middle"><div align="center"  title="匹配度为${opportunity.matchScore}%" style="background-image:url(${pageContext.request.contextPath}/image/job_match_score.png);width:56; height:56;cursor:hand"><br/><font color="#FFFFFF"><strong><s:property value="#opportunity.matchScore"/>%</strong> </font></div></td>
                <td width="70%"><a href=".."><span class="jobtitle">
                  <s:property value="#opportunity.jobName" /></span></a></td>
                <td width="20%" align="right" valign="bottom"><img src="${pageContext.request.contextPath}/image/like.png" width="20" height="21" />&nbsp;<img src="${pageContext.request.contextPath}/image/dislike.png" width="20" height="21" />&nbsp;<a href=".."><span class="tabfonts">推荐理由</span></a></td>
              </tr>
              <tr>
                <td colspan="2"><span class="jobcompany"><s:property value="#opportunity.companyName" /></span> <span class="tabfonts">| <s:property value="#opportunity.jobCity" /> | <s:property value="#opportunity.jobStartDate" /> </span></td>
                </tr>
              <tr>
                <td height="37" colspan="2" class="jobcontent">职位描述：
                  <s:property value="#opportunity.jobDesc" /></td>
                </tr>
            </table>
			</s:iterator>
         </s:if>
			</td>
          </tr>
		  
		 <s:if test="allopplist.size>5">
          <tr>
            <td><table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#666666">
              <tr>
                <td align="center"><div style="cursor:hand" onClick="window.location.href='${pageContext.request.contextPath}/user/recommendmore.htm'"><span class="toplink STYLE1">加载更多的职位▼</span></div></td>
              </tr>
            </table></td>
          </tr>
		  </s:if>
        </table></td>
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
        <td height="27" colspan="2" class="tabfont">职位搜索</td>
        </tr>
      <tr>
        <td width="69%" height="31">
          <label>
          <input name="textfield" type="text" size="16" />
            </label>
       </td>
        <td width="31%" >
          <input name="Submit" type="button" class="tabfont" value="搜索" />
       </td>
      </tr>
    </table></td>
  </tr>
</table>

</div>
<%@ include file="../bottom.jsp"%> 
</body>
</html>