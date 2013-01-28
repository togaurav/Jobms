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
							$("#canvasDiv").html("<strong><font color='white' size='3'>没有数据！</font></strong>");
						}else{
						   iChart(function() {
							new iChart.Bar2D({
								render : 'canvasDiv',
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
									end_scale : 2000,
									scale_space : 200
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
	</script>
	<br/><br/>
	<div class="STYLE1" align="center" id="loadingdiv"></div>
	<div align="center" id="canvasDiv">
	</div>
</body>
</html>
