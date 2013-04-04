<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>专业管理</title>
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
				if($('#majorNames_widget').attr("value").length<1){
					alert("专业名称不能为空！");
					return;
				}
				if($('#majorVO_skill_1_widget').attr("value").length==0&&$('#majorVO_skill_2_widget').attr("value").length==0&&$('#majorVO_skill_3_widget').attr("value").length==0&&$('#majorVO_skill_4_widget').attr("value").length==0&&$('#majorVO_skill_5_widget').attr("value").length==0){
					alert("请至少选择一项知识技能！");
					return;
				} 
				if($('#majorVO_skillratio_1').attr("value")<0&&$('#majorVO_skillratio_2').attr("value")<0&&$('#majorVO_skillratio_3').attr("value")<0&&$('#majorVO_skillratio_4').attr("value")<0&&$('#majorVO_skillratio_5').attr("value")<0){
					alert("请至少选择一项知识技能占比！");
					return;
				} 
				if($('#majorVO_skill_1_widget').attr("value").length>0&&$('#majorVO_skillratio_1').attr("value")<0||$('#majorVO_skill_2_widget').attr("value").length>0&&$('#majorVO_skillratio_2').attr("value")<0||$('#majorVO_skill_3_widget').attr("value").length>0&&$('#majorVO_skillratio_3').attr("value")<0||$('#majorVO_skill_4_widget').attr("value").length>0&&$('#majorVO_skillratio_4').attr("value")<0||$('#majorVO_skill_5_widget').attr("value").length>0&&$('#majorVO_skillratio_5').attr("value")<0){
					alert("请选择知识技能占比！");
					return;
				} 
				document.all.majorForm.submit();
			}
			
			function loadMajorInfo(){
				if($('#majorNames_widget').attr("value").length<2){
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/major/loadMajorInfo.action?majorVO.majorName="+$('#majorNames_widget').attr('value'),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 if(result.majorId>0){
	                         $("#majorVO_majorId").attr("value",result.majorId);
	                           $("#majorVO_skill_1_widget").attr("value",result.skill_1); 
	                         $("#majorVO_skillratio_1").attr("value",result.skillratio_1); 
	                         $("#majorVO_skill_2_widget").attr("value",result.skill_2); 
	                         $("#majorVO_skillratio_2").attr("value",result.skillratio_2); 
	                          $("#majorVO_skill_3_widget").attr("value",result.skill_3); 
	                         $("#majorVO_skillratio_3").attr("value",result.skillratio_3); 
	                          $("#majorVO_skill_4_widget").attr("value",result.skill_4); 
	                         $("#majorVO_skillratio_4").attr("value",result.skillratio_4); 
	                          $("#majorVO_skill_5_widget").attr("value",result.skill_5); 
	                         $("#majorVO_skillratio_5").attr("value",result.skillratio_5); 
 
                          }
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载数据出现异常!</font></strong>");
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
	<sj:tab id="tab1" target="tone" label="专业管理" /> 
	<div id="tone" >
		 <s:form id="majorForm" method="post" action="savemajor" namespace="/major">
		 	<s:hidden id="majorVO_majorId" name="majorVO.majorId" />
		 	<table width="100%" height="250" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td  align="right"><div>
                 专业名称：<font color="red">*</font></td>
                <td>&nbsp;
                 	<s:url id="majorName_remoteurl" action="findMajorListByTip" namespace="/resume"/>
          			<sj:autocompleter id="majorNames" 
           			 name="majorVO.majorName"
					 href="%{majorName_remoteurl}"
           			 delay="50"	
					 maxlength="50"
					 forceValidOption="true" 
					 cssStyle="width:250"
					  onBlur="loadMajorInfo();"
           			 loadMinimumCount="2"  />
				</td>
              </tr>
              <tr>
                <td align="right">知识技能：<font color="red">*</font></td>
                <td>&nbsp;
                 <s:url id="abilityName_remoteurl" action="findAbilityListByTip" namespace="/ability"/>
          			<sj:autocompleter id="majorVO_skill_1" 
           			 name="majorVO.skill_1"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />
					
					<s:select id="majorVO_skillratio_1" name="majorVO.skillratio_1"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9:'90%', 1 :'100%'}" >
					 </s:select> 
					  
				</td>
              </tr>
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
                 <sj:autocompleter id="majorVO_skill_2" 
           			 name="majorVO.skill_2"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="majorVO_skillratio_2" name="majorVO.skillratio_2"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9:'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>      
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
					<sj:autocompleter id="majorVO_skill_3" 
           			 name="majorVO.skill_3"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="majorVO_skillratio_3" name="majorVO.skillratio_3"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9:'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>        
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
					<sj:autocompleter id="majorVO_skill_4" 
           			 name="majorVO.skill_4"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="majorVO_skillratio_4" name="majorVO.skillratio_4"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9:'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>           
			  <tr>
                <td align="right"></td>
                <td>&nbsp;
					<sj:autocompleter id="majorVO_skill_5" 
           			 name="majorVO.skill_5"
					 href="%{abilityName_remoteurl}"
           			 delay="50"	
					 maxlength="20"
					 cssStyle="width:160"
           			 loadMinimumCount="2"  />

					<s:select id="majorVO_skillratio_5" name="majorVO.skillratio_5"    list="#{-1:'--请选择--',0.1 :'10%', 0.2 :'20%', 0.3 :'30%', 0.4:'40%', 0.5 :'50%', 0.6 :'60%', 0.7 :'70%', 0.8 :'80%', 0.9:'90%', 1 :'100%'}" >
					 </s:select>
				</td>
              </tr>                                            
              <tr>
                <td><div align="right"></div></td>
                <td><div align="right"><input type="button" onClick="submitForm();"  value="保存" name="saveJobBt" id="saveJobBt" cssStyle="  
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
