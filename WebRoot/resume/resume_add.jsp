<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>完善简历信息</title>
<style type="text/css">
<!--
.STYLE6 {color: #FF0000}
.STYLE7 {
	font-size: x-small;
	font-weight: bold;
}
.STYLE10 {font-size: x-small}
.STYLE11 {
	font-size: xx-small;
	font-weight: bold;
}
-->
</style>
</head>

<body bottommargin="0" topmargin="0">
<%@ include file="../top.jsp"%> 	
<table width="100%" height="80%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table align="center" width="48%" border="0" cellspacing="0" cellpadding="0">
      
      
      <tr>
        <td height="26" valign="bottom">&nbsp;</td>
      </tr>
      <tr>
        <td height="26" valign="bottom"><p><strong>完善个人简历</strong></p>          </td>
      </tr>
      <tr>
        <td><table width="100%" border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td>
			<form name="resumeForm" method="post" action="<%=path%>/resume/addresume.action">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              
              <tr>
                <td colspan="3" bgcolor="#CCCCCC"><span class="STYLE7">1、教育情况</span></td>
                </tr>
              
              <tr>
                <td width="11%"><div align="right" class="STYLE6"></div></td>
                <td width="22%"><div align="right" class="STYLE11">毕业学校：</div></td>
                <td width="67%">
                  <label>
				  <s:select list="schooList" name="schoolid"  listKey="id" listValue="name" ></s:select>
                    </label>                </td>
              </tr>
              <tr>
                <td><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">所学专业：</div></td>
                <td><label>
				  <s:select list="majorList" name="majorid"  listKey="id" listValue="name" ></s:select>
                    </label> </td>
              </tr>
              <tr>
                <td><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">最高学历：</div></td>
                <td><label>
				  <s:select list="educationList" name="educationid"  listKey="id" listValue="name" ></s:select>
                    </label></td>
              </tr>
              
              <tr>
                <td colspan="3" bgcolor="#CCCCCC"><span class="STYLE10"><strong>2、工作经历</strong></span></td>
                </tr>
              <tr>
                <td colspan="3"><span class="STYLE11">(1) 最近一份工作</span></td>
                </tr>
              
              <tr>
                <td height="25"><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">公司名称：</div></td>
                <td><label>
				  <s:select list="companyList" name="companyid1"  listKey="id" listValue="name"  headerKey="-1" headerValue="----请选择一个公司----" ></s:select>
                    </label></td>
              </tr>
              <tr>
                <td height="24"><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">职位名称：</div></td>
                <td><label>
				  <s:select list="jobList" name="jobid1"  listKey="jobId" listValue="jobName"  headerKey="-1" headerValue="----请选择一个职位----" ></s:select>
                    </label></td>
              </tr>
              <tr>
                <td><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">工作年限：</div></td>
                <td><select style="height:20;width:200" name="servicelen1">
					<option value='-1'>----请选择工作年限----</option>
					<option value='1'>1</option>
					<option value='2'>2</option>
					<option value='3'>3</option>
					<option value='4'>4</option>
					<option value='5'>5</option>
					<option value='6'>6</option>
					<option value='8'>8</option>
					<option value='10'>10</option>
                </select></td>
              </tr>
              
              <tr>
                <td colspan="3"><span class="STYLE10"><span class="STYLE11">(2) 前一份工作</span></span></td>
                </tr>
              
              <tr>
                <td height="23"><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">公司名称：</div></td>
                <td><label>
				  <s:select list="companyList" name="companyid2"  listKey="id" listValue="name" headerKey="-1" headerValue="----请选择一个公司----" ></s:select>
                    </label></td>
              </tr>
              <tr>
                <td height="24"><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">职位名称：</div></td>
                <td><label>
				  <s:select list="jobList" name="jobid2"  listKey="jobId" listValue="jobName" headerKey="-1" headerValue="----请选择一个职位----" ></s:select>
                    </label></td>
              </tr>
              <tr>
                <td><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">工作年限：</div></td>
                <td><select style="height:20;width:200" name="servicelen2">
					<option value='-1'>----请选择工作年限----</option>
					<option value='1'>1</option>
					<option value='2'>2</option>
					<option value='3'>3</option>
					<option value='4'>4</option>
					<option value='5'>5</option>
					<option value='6'>6</option>
					<option value='8'>8</option>
					<option value='10'>10</option>
                </select></td>
              </tr>
              
              <tr>
                <td colspan="3"><span class="STYLE11">(3) 其他工作经历</span></td>
                </tr>
              
              <tr>
                <td height="22"><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">公司名称：</div></td>
                <td><label>
				  <s:select list="companyList" name="companyid3"  listKey="id" listValue="name"  headerKey="-1" headerValue="----请选择一个公司----" ></s:select>
                    </label></td>
              </tr>
              <tr>
                <td height="25"><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">职位名称：</div></td>
                <td><label>
				  <s:select list="jobList" name="jobid3"  listKey="jobId" listValue="jobName" headerKey="-1" headerValue="----请选择一个职位----" ></s:select>
                    </label></td>
              </tr>
              <tr>
                <td><div align="right" class="STYLE6"></div></td>
                <td><div align="right" class="STYLE11">工作年限：</div></td>
                <td><select style="height:20;width:200" name="servicelen3">
					<option value='-1'>----请选择工作年限----</option>
					<option value='1'>1</option>
					<option value='2'>2</option>
					<option value='3'>3</option>
					<option value='4'>4</option>
					<option value='5'>5</option>
					<option value='6'>6</option>
					<option value='8'>8</option>
					<option value='10'>10</option>
                </select></td>
              </tr>
              
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>
                  <div align="right">
                    <input type="submit" style=" height:40;width:80;color:#FFFFFF;background-color:#000000;font-size:24px" name="Submit" value="提交">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td></tr>
            </table>
			 </form>			</td>
          </tr>
        </table></td>
      </tr>
      
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>

<%@ include file="../bottom.jsp"%> 
</body>
</html>
