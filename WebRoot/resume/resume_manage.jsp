<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>完善个人简历</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.qtip2.min.css" />
	<!--script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script-->
	<script src="${pageContext.request.contextPath}/js/jquery.qtip2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/alajax-1.2.js"></script>
	<script type='text/javascript'>
		 $(document).ready(function($) {    

		 }); 

	</script>

    <style type="text/css">
    \
<!--
.STYLE1 {color: #FF0000}
.STYLE4 {color: #FFFFFF}
.qtip-wiki{
	max-width: 600px;
}
-->
    </style>
<body bottommargin="0" topmargin="0" bgcolor="#000000" >
<br/>
<script type="text/javascript">
		$(document).ready(function()
		{
				$("#userinfoForm").alajax({
					type:'json',
					success: function(data, textStatus, jqXHR){
						alert(data);
						//$("#resultdiv").html(data);
					}
				});
				/*
				$("#saveUserInfoBt").qtip({
							content: {
								text:  $('#resultdiv'),
								title: {
									text: '操作结果',
									button: true
								}
							},
							position: {
								my: 'center',
								at: 'center',
								viewport: $(window)
							},
							show: {
								event: 'click', 
								solo: true, 
								modal: true 
							},
							hide: false,
							style:{ 
								width: 160,  
								padding: 8,  
								background: '#A2D959',  
								color: 'black',  
								textAlign: 'center',  
								border: {  
									width: 7,  
									radius: 5,  
									color: '#A2D959'  
								},  
								tip: 'bottomLeft',  
								name: 'dark'
							}	
						});
			*/
			<s:if test="result!=null&&result.trim().length()>0">	
			alert(${result});
			/*
			$(this).qtip({
							content: {
								text: '<s:property value="result"/>',
								title: {
									text: '操作结果',
									button: true
								}
							},
							position: {
								my: 'top center',
								at: 'top center',
								viewport: $(window)
							},
							show: {
								event:false,
								ready:true,
								solo: true, 
								modal: true 
							},
							hide: false,
							style:{ 
								width: 200,  
								padding: 8,  
								background: '#A2D959',  
								color: 'black',  
								textAlign: 'center',  
								border: {  
									width: 7,  
									radius: 5,  
									color: '#A2D959'  
								},  
								tip: 'bottomLeft',  
								name: 'dark'
							}	
						});		
						*/	
				</s:if>
		});
</script>

<script class="example" type="text/javascript">
$(document).ready(function()
{
	$('.edit_workexp_qtip').each(function()
	{
		// We make use of the .each() loop to gain access to each element via the "this" keyword...
		$(this).qtip(
		{
			content: {
				// Set the text to an image HTML string with the correct src URL to the loading image you want to use
				text: '<img class="throbber" src="${pageContext.request.contextPath}/image/throbber.gif" alt="Loading..." />',
				ajax: {
					url: $(this).attr('href'),
					type: 'GET',
					data: {},
					loading: true,
					once: false,
					dataType: 'json',
					success: function(data, status) {
						if(data.jobType==1){
							$("#edit_userWorkExpVO_jobType1").attr("checked",true);
						}else if(data.jobType==0){
							$("#edit_userWorkExpVO_jobType0").attr("checked",true);
						}
						if(data.lastJob){
							$("#edit_userWorkExpVO_lastJob").attr("checked",true);
						}else{
							$("#edit_userWorkExpVO_lastJob").attr("checked",false);
						}
						if(data.nowdate){
							$("#edit_userWorkExpVO_nowdate").attr("checked",true);
						}else{
							$("#edit_userWorkExpVO_nowdate").attr("checked",false);
						}
						
						$("#edit_userWorkExpVO_id").attr("value",data.id);
						$("#edit_userWorkExpVO_companyName").attr("value",data.companyName);
						$("#edit_userWorkExpVO_companyId").attr("value",data.companyId);
						$("#edit_userWorkExpVO_jobName").attr("value",data.jobName);
						$("#edit_userWorkExpVO_jobId").attr("value",data.jobId);
						$("#edit_userWorkExpVO_jobSalary").attr("value",data.jobSalary);
						$("#edit_userWorkExpVO_jobCity").attr("value",data.jobCity);
						$("#edit_userWorkExpVO_ondutyYear").attr("value",data.ondutyYear);
						$("#edit_userWorkExpVO_ondutyMonth").attr("value",data.ondutyMonth);
						$("#edit_userWorkExpVO_leaveYear").attr("value",data.leaveYear);
						$("#edit_userWorkExpVO_leaveMonth").attr("value",data.leaveMonth);
						$("#edit_userWorkExpVO_jobSkill").attr("value",data.jobSkill);
						$("#edit_userWorkExpVO_jobDesc").attr("value",data.jobDesc);
						this.set('content.text', $('#userWorkExpForm_edit'));
					}
				},
				title: {
					text: '修改工作经历' , // Give the tooltip a title using each elements text
					button: true
				}
			},
			position: {
				at: 'right center', // Position the tooltip above the link
				my: 'right center',
				viewport: $(window), // Keep the tooltip on-screen at all times
				effect: false // Disable positioning animation
			},
			show: {
				event: 'click',
				solo: true, 
				modal: true 
			},
			hide: false,
			style: {
				classes: 'qtip-wiki qtip-light qtip-shadow'
			}
		})
	})
	.click(function(event) { event.preventDefault(); });
	
		
	$('.edit_educateexp_qtip').each(function()
	{
		// We make use of the .each() loop to gain access to each element via the "this" keyword...
		$(this).qtip(
		{
			content: {
				// Set the text to an image HTML string with the correct src URL to the loading image you want to use
				text: '<img class="throbber" src="${pageContext.request.contextPath}/image/throbber.gif" alt="Loading..." />',
				ajax: {
					url: $(this).attr('href'),
					type: 'GET',
					data: {},
					loading: true,
					once: false,
					dataType: 'json',
					success: function(data, status) {
						$("#edit_userEducateExpVO_id").attr("value",data.id);
						$("#edit_userEducateExpVO_schoolName").attr("value",data.schoolName);
						$("#edit_userEducateExpVO_schoolId").attr("value",data.schoolId);
						$("#edit_userEducateExpVO_majorName").attr("value",data.majorName);
						$("#edit_userEducateExpVO_majorId").attr("value",data.majorId);
						$("#edit_userEducateExpVO_education").attr("value",data.education);
						$("#edit_userEducateExpVO_beginYear").attr("value",data.beginYear);
						$("#edit_userEducateExpVO_beginMonth").attr("value",data.beginMonth);
						$("#edit_userEducateExpVO_endYear").attr("value",data.endYear);
						$("#edit_userEducateExpVO_endMonth").attr("value",data.endMonth);
						this.set('content.text', $('#userEducateExpForm_edit'));
					}
				},
				title: {
					text: '修改教育经历' , // Give the tooltip a title using each elements text
					button: true
				}
			},
			position: {
				at: 'right center', // Position the tooltip above the link
				my: 'right center',
				viewport: $(window), // Keep the tooltip on-screen at all times
				effect: false // Disable positioning animation
			},
			show: {
				event: 'click',
				solo: true, 
				modal: true 
			},
			hide: false,
			style: {
				classes: 'qtip-wiki qtip-light qtip-shadow'
			}
		})
	})
	.click(function(event) { event.preventDefault(); });
	
	$("#userWorkExpForm")[0].reset();
	$("#userEducateExpForm")[0].reset();
});
</script>

<div id="resultdiv" style="display:none">
</div>
<table  width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" >
  <tr>
  	<td align="center" >
		<div id="resume_managetab_div" style=" width:100%; height:100%; ">
	<sj:tabbedpanel id="localtabs" selectedTab="%{tabIndex}" cssClass="list" cssStyle=" width:50%;font-size:13"> 
	<sj:tab id="tab1" target="tone" label="基本资料" /> 
    <sj:tab id="tab2" target="ttwo" label="知识技能"/> 
    <sj:tab id="tab3" target="tthree" label="工作经历"/> 
    <sj:tab id="tab4" target="tfour" label="教育经历"/> 
     <sj:tab id="tab5" target="tfive" label="项目经历"/> 
      <sj:tab id="tab6" target="tsix" label="求职意向"/> 
         <div id="tone" >
		 <s:form id="userinfoForm" method="post"  action="saveUserInfo" namespace="/resume">
		 	<s:hidden name="userInfoVO.userId"  value="%{userInfoVO.userId}"/>
		 	<table width="100%" height="450" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right"><div>
                 姓名：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userInfoVO.userName" value="%{userInfoVO.userName}" title="此处输入您的真实姓名"  maxlength="20" />
				</td>
              </tr>
              <tr>
                <td align="right">性别：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:radio name="userInfoVO.userGender"  value="%{userInfoVO.userGender}" list="#{1 :'男', 0 :'女'}" />								
				</td>
              </tr>
              <tr>
                <td align="right" >出生日期：<span class="STYLE1">*</span></td>
                <td >&nbsp;
					 <sj:datepicker name="userInfoVO.userBirthday"  value="%{userInfoVO.userBirthday}" displayFormat="yy-mm-dd"  changeYear="true"  yearRange="-40:+0" readonly="true"/>
				</td>
              </tr>
              <tr>
                <td align="right">当前所在地：<span class="STYLE1">*</span></td>
                <td>&nbsp;
                  <s:select name="userInfoVO.userCity"  cssStyle="width:20%" value="%{userInfoVO.userCity}"  list="#{-1:'--请选择--',1:'北京',2:'上海'}" >
				  </s:select>
				 </td>
              </tr>
              <tr>
                <td align="right">电子邮件：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userInfoVO.userEmail" value="%{userInfoVO.userEmail}"  title="此处输入您的电子邮箱"  maxlength="40"/>
				</td>
              </tr>
              <tr>
                <td align="right">手机：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userInfoVO.userPhone"  value="%{userInfoVO.userPhone}" title="此处输入您的手机号"  maxlength="15" />
				</td>
              </tr>
              <tr>
                <td align="right">工作经验：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					 <s:select name="userInfoVO.userServicelen" value="%{userInfoVO.userServicelen}" cssStyle="width:30%" list="#{-1:'--请选择--',0.0:'1年内',1.0:'1年',2.0:'2年',3.0:'3年',4.0:'4年',5.0:'5年',6.0:'6年',7.0:'7年',8.0:'8年',10.0:'10年',11.0:'10年以上'}" >
				  </s:select>
				</td>
              </tr>
              <tr>
                <td align="right">职业身份：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:select name="userInfoVO.userRole"  cssStyle="width:30%"  value="%{userInfoVO.userRole}" list="#{-1:'--请选择--',1:'应届毕业生',2:'初级人员',3:'中高级人员',4:'资深专家',5:'基层管理',6:'中高层管理',7:'总监',8:'总裁/CEO'}" >
				  </s:select>
				</td>
              </tr>
              <tr>
                <td align="right">自我介绍：</td>
                <td>&nbsp;
					<s:textarea name="userInfoVO.userDesc"  value="%{userInfoVO.userDesc}" cols="45" rows="4"/>
				</td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="保存" name="saveUserInfoBt" id="saveUserInfoBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
		 </div> 
         <div id="ttwo">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0" >
              <tr> <td colspan="2" ><div align="center">
	 	  <img src="${pageContext.request.contextPath}/image/skill.jpg" width="393" height="297">		 </div> 
		  		</td>
			</tr>
			<tr>
			 <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="保存" name="saveUserInfoBt" id="saveUserInfoBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
		</table>	
		 </div> 	
         <div id="tthree">
		
	<s:if test="userWorkExpVOList.size>0">
		<h3 align="left">>> 工作经历</h3>
		 <s:iterator id="workexp" value="%{userWorkExpVOList}" status="st">
		 <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
              <tr> <td>
		 	<table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td colspan="3" bgcolor="#CCCCCC">&nbsp;
					<strong><s:property value="#workexp.companyName" /></strong>&nbsp;&nbsp;&nbsp;
					<strong><s:property value="#workexp.jobName" /></strong>&nbsp;&nbsp;&nbsp;
					<s:if test="#workexp.isLastJob">
						<s:date name="#workexp.ondutyDate" format="yyyy-MM"/> 至今
					</s:if>
					<s:else>
						<s:date name="#workexp.ondutyDate" format="yyyy-MM"/> 至 <s:date name="#workexp.leaveDate" format="yyyy-MM"/>
					</s:else>
					
				</td>
              </tr>
              <tr>
                <td width="5%">&nbsp;</td>
                <td width="83%">所用技术：&nbsp;
					<s:property value="#workexp.jobSkill" />
				</td>
                <td width="12%">
					<a href='${pageContext.request.contextPath}/resume/delUserWorkExp.action?userWorkExpVO.id=<s:property value="#workexp.id" />'>删除</a>
					<a href='${pageContext.request.contextPath}/resume/editUserWorkExp.action?userWorkExpVO.id=<s:property value="#workexp.id" /> ' class="edit_workexp_qtip">修改</a>				</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>工作描述：&nbsp;
					<s:property value="#workexp.jobDesc" />
				</td>
                <td>&nbsp;</td>
              </tr>
            </table>
		 </td>
		 </tr>
        </table>
		</s:iterator>
	</s:if>
		<h3 align="left">>> 添加工作经历</h3>
		 	<s:form id="userWorkExpForm" method="post"  action="saveUserWorkExp" namespace="/resume">
			<s:hidden name="userWorkExpVO.id"  value="%{userWorkExpVO.id}"/>
		 	<table width="100%" height="450" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right"><div>
                 工作类型：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:radio name="userWorkExpVO.jobType"  value="1" list="#{1 :'全职', 0 :'实习'}" />				</td>
              </tr>
              <tr>
                <td align="right">公司：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:url id="companyname_remoteurl" action="resume/findCompanyListByTip.action"/>
          			<sj:autocompleter id="companyNames" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
					<s:hidden name="userWorkExpVO.companyId" value="0"/>				
				</td>
              </tr>
			  <tr>
                <td align="right">职位名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:url id="jobname_remoteurl" action="resume/findJobListByTip.action"/>
          			<sj:autocompleter id="jobNames" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
					<s:hidden name="userWorkExpVO.jobId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right">工作地点：<span class="STYLE1">*</span></td>
                <td>&nbsp;
                  <s:select name="userWorkExpVO.jobCity"  cssStyle="width:20%"  list="#{-1:'--请选择--',1:'北京',2:'上海'}" >				  
				  </s:select>				 
				 </td>
              </tr>
              <tr>
                <td align="right" >在职时间：<span class="STYLE1">*</span></td>
                <td >&nbsp;
					 <s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月
				  <input type='checkbox' name="userWorkExpVO.nowdate" value="true" /> 至今				
				 </td>
              </tr>
              
              <tr>
                <td align="right">薪水（税前）：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobSalary"  maxlength="8"/>				
				</td>
              </tr>
              <tr>
                <td align="right">相关技能：</td>
                <td>&nbsp;
					<s:textfield name="userWorkExpVO.jobSkill"  maxlength="80" />				
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
					<s:textarea name="userWorkExpVO.jobDesc" cols="45" rows="5"/>				
				</td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="添加" name="saveUserWorkExpBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
		 </div> 
         <div id="tfour">
		 
		 	
	<s:if test="userEducateExpVOList.size>0">
		<h3 align="left">>> 教育经历</h3>
		 <s:iterator id="educateexp" value="%{userEducateExpVOList}" status="st">
		 <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000">
              <tr> <td>
		 	<table width="100%" border="0" cellpadding="0" cellspacing="1" >
              <tr>
                <td colspan="3" bgcolor="#CCCCCC">&nbsp;
					<strong><s:property value="#educateexp.schoolName" /></strong>&nbsp;&nbsp;&nbsp;
					<s:date name="#educateexp.beginDate" format="yyyy-MM"/> 至 <s:date name="#educateexp.endDate" format="yyyy-MM"/>
				</td>
              </tr>
              <tr>
                <td width="5%">&nbsp;</td>
                <td width="79%">专业：&nbsp;
					<s:property value="#educateexp.majorName" />
				</td>
                <td width="16%">
					<a href='${pageContext.request.contextPath}/resume/delUserEducateExp.action?userEducateExpVO.id=<s:property value="#educateexp.id" />'>删除</a>
					<a href='${pageContext.request.contextPath}/resume/editUserEducateExp.action?userEducateExpVO.id=<s:property value="#educateexp.id" /> ' class="edit_educateexp_qtip">修改</a>				</td>
              </tr>
            </table>
		 </td>
		 </tr>
        </table>
		</s:iterator>
	</s:if>
		<h3 align="left">>> 添加教育经历</h3>
		 	<s:form id="userEducateExpForm" method="post"  action="saveUserEducateExp" namespace="/resume">
			<s:hidden name="userEducateExpVO.id"  value="%{userEducateExpVO.id}"/>
		 	<table width="100%" height="300" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td align="right">学校名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userEducateExpVO.schoolName"  maxlength="40" />
					<s:hidden name="userEducateExpVO.schoolId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right">专业名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield name="userEducateExpVO.majorName"  maxlength="30" />
					<s:hidden name="userEducateExpVO.majorId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right">学历：<span class="STYLE1">*</span></td>
                <td>&nbsp;
                  <s:select name="userEducateExpVO.education"  cssStyle="width:20%"  list="#{-1:'--请选择--',34:'博士后',35:'博士',36:'硕士',37:'本科',38:'大专',39:'其他'}" >				  </s:select>				 </td>
              </tr>
              <tr>
                <td align="right" >就读时间：<span class="STYLE1">*</span></td>
                <td >&nbsp;
					 <s:select name="userEducateExpVO.beginYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userEducateExpVO.beginMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userEducateExpVO.endYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userEducateExpVO.endMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月				 </td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="添加" name="saveUserEducateExpBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
		 
		 </div> 
		 <div id="tfive">
		 	Cras dictum.         </div>  
		 <div id="tsix">
		 	Cras dictum.         </div> 
</sj:tabbedpanel> 
</div>	</td>
  </tr>
</table> 	

<div style="display:none">
	<s:form id="userWorkExpForm_edit" method="post"  action="saveUserWorkExp" namespace="/resume">
			<s:hidden id="edit_userWorkExpVO_id" name="userWorkExpVO.id"  value="%{userWorkExpVO.id}"/>
		 	<table width="100%" height="400" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right"><div>
                 工作类型：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:radio id="edit_userWorkExpVO_jobType"  name="userWorkExpVO.jobType" value='1' list="#{1:'全职', 0:'实习'}" />				</td>
              </tr>
              <tr>
                <td align="right">公司：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield id="edit_userWorkExpVO_companyName" name="userWorkExpVO.companyName" value="%{userWorkExpVO.companyName}"   maxlength="40" />
					<s:hidden id="edit_userWorkExpVO_companyId" name="userWorkExpVO.companyId" value="%{userWorkExpVO.companyId}" />				</td>
              </tr>
			  <tr>
                <td align="right">职位名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield id="edit_userWorkExpVO_jobName" name="userWorkExpVO.jobName" value="%{userWorkExpVO.jobName}"  maxlength="30" />
					<s:hidden id="edit_userWorkExpVO_jobId" name="userWorkExpVO.jobId" value="%{userWorkExpVO.jobId}"/>				</td>
              </tr>
			  <tr>
                <td align="right">工作地点：<span class="STYLE1">*</span></td>
                <td>&nbsp;
                  <s:select id="edit_userWorkExpVO_jobCity" name="userWorkExpVO.jobCity"  cssStyle="width:20%"  value="%{userWorkExpVO.jobCity}" list="#{-1:'--请选择--',1:'北京',2:'上海'}" >				  
				  </s:select>				 
				 </td>
              </tr>
              <tr>
                <td align="right" >在职时间：<span class="STYLE1">*</span></td>
                <td >&nbsp;
					 <s:select name="userWorkExpVO.ondutyYear" id='edit_userWorkExpVO_ondutyYear'  value="%{userWorkExpVO.ondutyYear}" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.ondutyMonth"  id='edit_userWorkExpVO_ondutyMonth' value="%{userWorkExpVO.ondutyMonth}" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select name="userWorkExpVO.leaveYear"  id='edit_userWorkExpVO_leaveYear'  value="%{userWorkExpVO.leaveYear}" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select name="userWorkExpVO.leaveMonth" id='edit_userWorkExpVO_leaveMonth'  value="%{userWorkExpVO.leaveMonth}" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月
				  <input type='checkbox'  id="edit_userWorkExpVO_nowdate"  name="userWorkExpVO.nowdate" value="true" /> 至今				
				 </td>
              </tr>
              
              <tr>
                <td align="right">薪水（税前）：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield id="edit_userWorkExpVO_jobSalary" name="userWorkExpVO.jobSalary" value="%{userWorkExpVO.leaveMonth}"  maxlength="8"/>				</td>
              </tr>
              <tr>
                <td align="right">相关技能：</td>
                <td>&nbsp;
					<s:textfield id="edit_userWorkExpVO_jobSkill" name="userWorkExpVO.jobSkill" value="%{userWorkExpVO.jobSkill}" maxlength="80" />				
				</td>
              </tr>
			   <tr>
                <td align="right"></td>
                <td>&nbsp;
					<input type='checkbox' id="edit_userWorkExpVO_lastJob" name="userWorkExpVO.lastJob" value="true"/>是否是最近一份工作				
				</td>
              </tr>
              <tr>
                <td align="right">工作描述：</td>
                <td>&nbsp;
					<s:textarea id="edit_userWorkExpVO_jobDesc" name="userWorkExpVO.jobDesc" cols="45" rows="5" value="%{userWorkExpVO.jobDesc}"/>				
				 </td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="保存" name="editUserWorkExpBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
			
			<s:form id="userEducateExpForm_edit" method="post"  action="saveUserEducateExp" namespace="/resume">
			<s:hidden id="edit_userEducateExpVO_id" name="userEducateExpVO.id"  value="%{userEducateExpVO.id}"/>
		 	<table width="100%" height="300" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td align="right">学校名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield id="edit_userEducateExpVO_schoolName" name="userEducateExpVO.schoolName"  maxlength="40" />
					<s:hidden id="edit_userEducateExpVO_schoolId" name="userEducateExpVO.schoolId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right">专业名称：<span class="STYLE1">*</span></td>
                <td>&nbsp;
					<s:textfield id="edit_userEducateExpVO_majorName" name="userEducateExpVO.majorName"  maxlength="30" />
					<s:hidden id="edit_userEducateExpVO_majorId" name="userEducateExpVO.majorId" value="0"/>				</td>
              </tr>
			  <tr>
                <td align="right">学历：<span class="STYLE1">*</span></td>
                <td>&nbsp;
                  <s:select id="edit_userEducateExpVO_education" name="userEducateExpVO.education"  cssStyle="width:20%"  list="#{-1:'--请选择--',34:'博士后',35:'博士',36:'硕士',37:'本科',38:'大专',39:'其他'}" >				  </s:select>				 </td>
              </tr>
              <tr>
                <td align="right" >就读时间：<span class="STYLE1">*</span></td>
                <td >&nbsp;
					 <s:select id="edit_userEducateExpVO_beginYear" name="userEducateExpVO.beginYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select id="edit_userEducateExpVO_beginMonth" name="userEducateExpVO.beginMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月&nbsp;至&nbsp;
				   <s:select id="edit_userEducateExpVO_endYear" name="userEducateExpVO.endYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>年
				   <s:select id="edit_userEducateExpVO_endMonth" name="userEducateExpVO.endMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>月				 </td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><s:submit value="保存" name="editUserEducateExpBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
</div>

</body>
</html>
