<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  

<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干啥儿网—你的职场方向标</title>
	<sj:head jqueryui="true"  jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划">
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/ichart-1.0.min.js'></script>
    <style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
-->
    </style>
</head>
<body bottommargin="0" topmargin="0">
<script type="text/javascript">
			$(document).ready(function()
			{
				var chartData ='';
				$.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/genUserCompetencyChart.action",   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
					beforeSend:function(XMLHttpRequest){
             			$("#loadingdiv").html("<img class='throbber' src='${pageContext.request.contextPath}/image/black_loading.gif' alt='Loading...'/>");
         			},
                    success: function (result) {
                        chartData=result;
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
						if(chartData.length==0){
							$("#canvasDiv_user").html("<strong><font color='white' size='3'>没有数据！</font></strong>");
						}else{
						   iChart(function() {
							new iChart.Bar2D({
								render : 'canvasDiv_user',
								background_color : '#EEEEEE',
								data : chartData,
								title : '个人胜任力图谱',
								subtitle : '',
								footnote : '',
								width : 900,
								height : 500,
								coordinate : {
									width : 500,
									height : 350,
									axis : {
										width : [0, 0, 1, 1]
									},
									scale : [{
									position : 'bottom',
									start_scale : 0,
									end_scale : 3600,
									scale_space : 300
									}]
								},
								animation : true,
								sub_option : {
									listeners : {
										parseText : function(r, t) {
										return t + "";
										}
									}
								},
								legend : {
									enable : false
								}
							}).draw();
						});
					  }
				    },
                    error: function (result) {
                        $("#loadingdiv").empty();
						$("#loadingdiv").html("<strong><font color='red'>生成图谱出现异常!</font></strong>");
                    }
                });
				
			});
			
			function loadJobInfo(){

			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/findJobsByCompany.action?companyName="+document.all.companyName_widget.value,   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 if(result.length>0){
							    var jqueryObj=result;          //从action获取数据
								document.all['jobName'].options.length = 0;   
							    var str="<option value='-1'>----请选择----</option>";   
							    for(var i=0;i<jqueryObj.length;i++){   
							        str+="<option value='"+jqueryObj[i].id+"'>"+jqueryObj[i].jobName+"</option>"  
							    }   
							    $("#jobName").html(str); 
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
			
			function genChart(){
				var chartData2 ='';
				var labels='';
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/generateUserJobCompetencyChart.action?companyName="+document.all.companyName_widget.value+"&jobName="+document.all.jobName.value,   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 chartData2=result; 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	if(chartData2.length==0){
							$("#canvasDiv_job").html("<strong><font color='white' size='3'>没有数据！</font></strong>");
						}else{
						 $("#canvasDiv_job").empty();
						   iChart(function() {
							new iChart.Bar2D({
								render : 'canvasDiv_job',
								background_color : '#EEEEEE',
								data : chartData2,
								title : '职位胜任力图谱',
								subtitle : '',
								footnote : '',
								width : 900,
								height : 500,
								coordinate : {
									width : 500,
									height : 350,
									axis : {
										width : [0, 0, 1, 1]
									},
									scale : [{
									position : 'bottom',
									start_scale : 0,
									end_scale : 3600,
									scale_space : 300
									}]
								},
								animation : true,
								sub_option : {
									listeners : {
										parseText : function(r, t) {
										return t + "";
										}
									}
								},
								legend : {
									enable : false
								}
							}).draw();
						});
					  }
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			
			function domatch(){
				if(document.all.jobName.value<0) {	
		      		alert("请选择一个职位！");
					return;
				}	
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/match.action?jobName="+document.all.jobName.value,   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
						 $("#canvasDiv_match").empty();
						 $("#canvasDiv_match").html(result);
                    },
				    complete:function(XMLHttpRequest,textStatus){
				    },
                    error: function (result) {
						$("#canvasDiv_match").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
	</script>
<%@ include file="../top.jsp"%> 
	<br/><br/>
	<div class="STYLE1" align="center" id="loadingdiv"></div>
	<div align="center">
		<font color="white">公司 </font>
				<s:url id="companyname_remoteurl" action="findCompanyListByTip.action" namespace="/resume"/>
          			<sj:autocompleter id="companyNames" 
           			 name="companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50" 
					   onBlur="loadJobInfo();"
           			 loadMinimumCount="2"  /> 
           <font color="white">	职位 </font>
           		<s:select  id="jobName" name="jobName" cssStyle="width:250"  list="opportunityList" headerKey="-1" headerValue="
--请选择--"  listKey="id" listValue="name" onChange="genChart()">
 
					</s:select>	
	</div>
	<div align="center" id="canvasDiv_job">
	</div>
	<div align="center" id="canvasDiv_user">
	</div>
	<div align="center">
		<input type="button" name="matchbt" value="匹配" onclick="domatch()"/><br/>
		<div align="center" id="canvasDiv_match">
			
		</div>
	</div>
	<%@ include file="../bottom.jsp"%> 
</body>
</html>
