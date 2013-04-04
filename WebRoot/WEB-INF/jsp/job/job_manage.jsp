<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>职位库管理</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划"> 
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
    <script  type="text/javascript">
			function submitForm(){
				if($('#jobNames_widget').attr("value").length<1){
					alert("职位名称不能为空！");
					return;
				}
				if($('#jobVO_funcRankId').attr("value")==-1){
					alert("请选择一个职能阶层！");
					return;
				} 
				if($('#jobVO_ratioFunction').attr("value")==-1){
					alert("请选择职能阶层占比！");
					return;
				}  
				if($('#jobVO_ratioAbility').attr("value")==-1){
					alert("请选择专业技能占比！");
					return;
				}  
				if($('#jobVO_ratioIndustry').attr("value")==-1){
					alert("请选择行业经验占比！");
					return;
				} 
				if($('#jobVO_skill_1_widget').attr("value").length==0&&$('#jobVO_skill_2_widget').attr("value").length==0&&$('#jobVO_skill_3_widget').attr("value").length==0&&$('#jobVO_skill_4_widget').attr("value").length==0&&$('#jobVO_skill_5_widget').attr("value").length==0){
					alert("请至少选择一项专业技能！");
					return;
				} 
				if($('#jobVO_skillratio_1').attr("value")<0&&$('#jobVO_skillratio_2').attr("value")<0&&$('#jobVO_skillratio_3').attr("value")<0&&$('#jobVO_skillratio_4').attr("value")<0&&$('#jobVO_skillratio_5').attr("value")<0){
					alert("请至少选择一项专业技能占比！");
					return;
				} 
				if($('#jobVO_skill_1_widget').attr("value").length>0&&$('#jobVO_skillratio_1').attr("value")<0||$('#jobVO_skill_2_widget').attr("value").length>0&&$('#jobVO_skillratio_2').attr("value")<0||$('#jobVO_skill_3_widget').attr("value").length>0&&$('#jobVO_skillratio_3').attr("value")<0||$('#jobVO_skill_4_widget').attr("value").length>0&&$('#jobVO_skillratio_4').attr("value")<0||$('#jobVO_skill_5_widget').attr("value").length>0&&$('#jobVO_skillratio_5').attr("value")<0){
					alert("请选择专业技能占比！");
					return;
				} 
				document.all.jobForm.submit();
			}
			
			function loadJobInfo(){
				if($('#jobNames_widget').attr("value").length<2){
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/job/loadJobInfo.action?jobVO.jobName="+$('#jobNames_widget').attr("value"),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 if(result.jobId>0){
                    	 
	                         $("#jobVO_jobId").attr("value",result.jobId);
	                         $("#jobVO_funcRankId").attr("value",result.funcRankId);
	                          $("#jobVO_jobNameNew").attr("value",result.jobNameNew);
	                         $("#jobVO_industryId").attr("value",result.industryId);
	                         $("#jobVO_ratioFunction").attr("value",result.ratioFunction);
	                         $("#jobVO_ratioAbility").attr("value",result.ratioAbility);
	                         $("#jobVO_ratioIndustry").attr("value",result.ratioIndustry); 
	                         $("#jobVO_jobnameTag").attr("value",result.jobnameTag); 
	                         $("#jobVO_skill_1_widget").attr("value",result.skill_1); 
	                         $("#jobVO_skillratio_1").attr("value",result.skillratio_1); 
	                         $("#jobVO_skill_2_widget").attr("value",result.skill_2); 
	                         $("#jobVO_skillratio_2").attr("value",result.skillratio_2); 
	                          $("#jobVO_skill_3_widget").attr("value",result.skill_3); 
	                         $("#jobVO_skillratio_3").attr("value",result.skillratio_3); 
	                          $("#jobVO_skill_4_widget").attr("value",result.skill_4); 
	                         $("#jobVO_skillratio_4").attr("value",result.skillratio_4); 
	                          $("#jobVO_skill_5_widget").attr("value",result.skill_5); 
	                         $("#jobVO_skillratio_5").attr("value",result.skillratio_5); 
 
                          }
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			
			function loadFuncRankRatio(){
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/job/loadFuncRankRatio.action?jobVO.funcRankId="+$('#jobVO_funcRankId').attr("value"),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 if(result.funcRankId>0){
	                         $("#jobVO_ratioFunction").attr("value",result.ratioFunction);
	                         $("#jobVO_ratioAbility").attr("value",result.ratioAbility);
	                         $("#jobVO_ratioIndustry").attr("value",result.ratioIndustry); 
 
                          }
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
	</script>  
</head>  
<body bottommargin="0" topmargin="0" bgcolor="#000000" >
<%@ include file="../top.jsp"%> 
<br/>
<script type="text/javascript">
		$(document).ready(function()
		{ 
			  $("#loadingdiv").html("<img class='throbber' src='${pageContext.request.contextPath}/image/black_loading.gif' alt='Loading...'/>");
    		  setTimeout(' $("#loadingdiv").html("")', 100 ); 
		});
</script>
<div class="STYLE1" align="center" id="loadingdiv"></div>
<div id="resultdiv" style="display:none">
</div>
<table  width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" >
  <tr>
  	<td align="center" >
		<div id="resume_managetab_div" style=" width:100%; height:100%; ">
		<sj:tabbedpanel id="localtabs" selectedTab="0" cssClass="list" cssStyle=" width:50%;font-size:13"> 
	<sj:tab id="tab1" target="tone" label="职位库管理" /> 
	<div id="tone" >
		 <s:form id="jobForm" method="post" action="savejob" namespace="/job">
		 	<s:hidden id="jobVO_jobId" name="jobVO.jobId" />
		 	<table width="100%" height="450" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right"><div>
                 职位名称：<font color="red">*</font></td>
                <td>&nbsp;
                 	<s:url id="jobName_remoteurl" action="findJobListByTip" namespace="/resume"/>
          			<sj:autocompleter id="jobNames" 
           			 name="jobVO.jobName"
					 href="%{jobName_remoteurl}"
           			 delay="50"	
					 maxlength="50"
					 forceValidOption="true" 
					 cssStyle="width:250"
					  onBlur="loadJobInfo();"
           			 loadMinimumCount="2"  />
				</td>
              </tr>
              <tr>
                <td  align="right"><div>
                 职位别名：</td>
                <td>&nbsp;
                 	<input type"text" id="jobVO_jobNameNew" name="jobVO.jobNameNew" maxlength="20" />
				</td>
              </tr>
              <tr>
                <td align="right">职能阶层：<font color="red">*</font></td>
                <td>&nbsp;
					<s:select  id="jobVO_funcRankId" name="jobVO.funcRankId" cssStyle="width:250"  list="funcRankList" headerKey="-1" headerValue="
--请选择--"  listKey="id" listValue="name" onChange="loadFuncRankRatio()"> 
					</s:select>
				</td>
              </tr>
                <tr>
                <td align="right">所在行业：</td>
                <td>&nbsp;
					<s:select  id="jobVO_industryId" name="jobVO.industryId" cssStyle="width:250"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name">
 
					</s:select>
				</td>
              </tr>
              <tr>
                <td align="right" >职能阶层占比：<font color="red">*</font></td>
                <td >&nbsp;
					 <s:select id="jobVO_ratioFunction" name="jobVO.ratioFunction"   list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" > 
					 </s:select>
				</td>
              </tr>
              <tr>
                <td align="right">专业技能占比：<font color="red">*</font></td>
                <td>&nbsp;
                   <s:select id="jobVO_ratioAbility" name="jobVO.ratioAbility"   list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1:'100%'}" > 
                   </s:select>
				 </td>
              </tr>
              <tr>
                <td align="right">行业经验占比：<font color="red">*</font></td>
                <td>&nbsp;
					 <s:select id="jobVO_ratioIndustry" name="jobVO.ratioIndustry"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" > 
					 </s:select>
				</td>
              </tr>
              <tr>
                <td align="right">职位专业技能：<font color="red">*</font></td>
                <td>&nbsp;
                 <s:url id="abilityName_remoteurl" action="findAbilityListByTip" namespace="/ability"/>
          			<sj:autocompleter id="jobVO_skill_1" 
           			 name="jobVO.skill_1"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />
					
					<s:select id="jobVO_skillratio_1" name="jobVO.skillratio_1"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" >
					 </s:select> 
					  
				</td>
              </tr>
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
                 <sj:autocompleter id="jobVO_skill_2" 
           			 name="jobVO.skill_2"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="jobVO_skillratio_2" name="jobVO.skillratio_2"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>      
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
					<sj:autocompleter id="jobVO_skill_3" 
           			 name="jobVO.skill_3"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="jobVO_skillratio_3" name="jobVO.skillratio_3"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>        
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
					<sj:autocompleter id="jobVO_skill_4" 
           			 name="jobVO.skill_4"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="jobVO_skillratio_4" name="jobVO.skillratio_4"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>           
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
					<sj:autocompleter id="jobVO_skill_5" 
           			 name="jobVO.skill_5"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="jobVO_skillratio_5" name="jobVO.skillratio_5"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9 :'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>                                            
              <tr>
                <td align="right">职位标签：</td>
                <td>&nbsp;
					 <s:textfield id="jobVO_jobnameTag" name="jobVO.jobnameTag" maxlength="100" cssStyle="width:300"/>
				</td>
              </tr>
			   <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><input type="button" onclick="submitForm();"  value="保存" name="saveJobBt" id="saveJobBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/>
					<input type="reset"  value="重置" name="resetJobBt" id="resetJobBt" cssStyle="  
					height:30;width:60;color:#000000; background-color:#FF9900;font-size:18px"/></div></td>
              </tr>
            </table>
			</s:form>
			</div>
			</sj:tabbedpanel> 
</div>	</td>
  </tr>
</table> 	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
