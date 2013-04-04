<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
	<sj:head jqueryui="true"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
    <style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
.STYLE2 {
	font-size: x-large;
	font-weight: bold;
}
-->
    </style>
</head>
<body bottommargin="0" topmargin="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#000000">
  <tr>
    <td width="50%" height="416">
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr height="30">
        <td colspan="3" class="STYLE4">&nbsp;</td>
      </tr>
      <tr height="30">
        <td colspan="3" class="STYLE4">&nbsp;</td>
      </tr>
      <tr height="30">
        <td height="191" colspan="3" class="STYLE4"><p align="center" class="STYLE6 STYLE1 STYLE2">&nbsp;</p>
          <p align="center" class="STYLE6 STYLE1 STYLE2">&nbsp;</p></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td width="133">&nbsp;</td>
        <td width="272" height="25"><span class="STYLE1"><strong>职位名称 / 公司</strong></span></td>
        <td width="200">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="40"><label>
          <s:url id="remoteurl" action=""/>
          <sj:autocompleter id="result" 
           			 name="jobName"
					 href="%{remoteurl}"
           			 delay="50"	 
           			 cssStyle="line-height:35px;font-size:20px; border-color:#000000;height:40;width:250;"
           			 loadMinimumCount="2"  />
        </label></td>
        <td><label>
          <input type="button" style="height:40;width:80;color:#000000; background-color:#FF9900;font-size:24px" name="seachbt" value="搜索">
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="26"><span class="STYLE1"><strong>工作地点</strong></span></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="45"><label>
          <input name="textfield2" type="text" style="line-height:35px;font-size:20px; border-color:#000000;height:40;width:250;" value="北京">
          <font face="微软雅黑"></font> </label></td>
        <td></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td><strong>
          <div id="matchResultdiv"  style=" color:#FF0000;font-size:18px;width:200px;height:40px;"
 				align="left"></div>
        </strong> </td>
      </tr>
    </table></td>
    <td width="50%">&nbsp;</td>
  </tr>
</table>
</body>
</html>