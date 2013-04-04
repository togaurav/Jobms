<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>职能参数管理</title>
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
			
			function loadFuncRankGrowth(){
				if($('#funcRankId').attr("value")==-1){
					alert("请选择一个职能阶层!");	
					return;
				} 
				if($('#yearnum').attr("value")==-1){
					alert("请选择一个经验年数!");	
					return;
				} 
				
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/job/loadGrowthValue.action?funcRankId="+$('#funcRankId').attr('value')+"&yearnum="+$('#yearnum').attr('value'),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 if(result>0){
	                         $("#growthValue").attr("value",result);      
                          }else{
                           	$("#growthValue").attr("value",'');      
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
			
			function loadFuncRankConvert(){
				if($('#curFuncRankId').attr("value")==-1){
					alert("请选择一个当前职能阶层!");	
					return;
				} 
				if($('#tarFuncRankId').attr("value")==-1){
					alert("请选择一个目标职能阶层!");	
					return;
				} 
				
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/job/loadConvertValue.action?curFuncRankId="+$('#curFuncRankId').attr('value')+"&tarFuncRankId="+$('#tarFuncRankId').attr('value'),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	 if(result>0){
	                         $("#convertValue").attr("value",result);
                          }else{
                           	$("#convertValue").attr("value",'');      
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
			
			function saveFuncRankGrowth(){
				if($('#funcRankId').attr("value")==-1){
					alert("请选择一个职能阶层!");	
					return;
				} 
				if($('#yearnum').attr("value")==-1){
					alert("请选择一个经验年数!");	
					return;
				} 
				if($('#growthValue').attr("value").length<1){
					alert("请输入经验值!");	
					return;
				} 
				
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/job/updategrowth.action?funcRankId="+$('#funcRankId').attr('value')+"&yearnum="+$('#yearnum').attr('value')+"&growthValue="+$('#growthValue').attr('value'),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	alert(result);
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载数据出现异常!</font></strong>");
                    }
                });
			}
			
			function saveFuncRankConvert(){
				if($('#curFuncRankId').attr("value")==-1){
					alert("请选择一个当前职能阶层!");	
					return;
				} 
				if($('#tarFuncRankId').attr("value")==-1){
					alert("请选择一个目标职能阶层!");	
					return;
				} 
				if($('#convertValue').attr("value").length<1){
					alert("请输入转换系数!");	
					return;
				} 
				
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/job/updateconvert.action?curFuncRankId="+$('#curFuncRankId').attr('value')+"&tarFuncRankId="+$('#tarFuncRankId').attr('value')+"&convertValue="+$('#convertValue').attr('value'),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	alert(result);
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
	<sj:tab id="tab1" target="tone" label="职能参数管理" /> 
	<div id="tone" >
		 <s:form id="majorForm" method="post" action="savemajor" namespace="/major">
		 	<s:hidden id="majorVO_majorId" name="majorVO.majorId" />
		 	<table width="100%" height="250" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td align="right">职能经验：<font color="red">*</font></td>
                <td>&nbsp;
					<s:select  id="funcRankId" name="funcRankId" cssStyle="width:150"  list="funcRankList" headerKey="-1" headerValue="
--请选择--"  listKey="id" listValue="name" >
					</s:select> 
					<s:select id="yearnum" name="yearnum"    list="#{-1:'--请选择--', 0:'0年', 1 :'1年', 2 :'2年', 3 :'3年', 4 :'4年', 5 :'5年', 6:'6年', 7 :'7年', 8 :'8年', 9 :'9年', 10 :'10年'}"  onChange="loadFuncRankGrowth()">
					 </s:select> 
					 <input type="text" id="growthValue" name="growthValue"  style="width:50"/>
				</td>
				<td>
					<input type="button" onClick="saveFuncRankGrowth()"  value="保存"  id="saveBt"/>
				</td> 
              </tr>
                <tr>
                <td align="right">职能转换：<font color="red">*</font></td>
                <td>&nbsp;
					<s:select  id="curFuncRankId" name="curFuncRankId" cssStyle="width:150"  list="funcRankList" headerKey="-1" headerValue="
--请选择--"  listKey="id" listValue="name" >
					</s:select> 
					<s:select  id="tarFuncRankId" name="tarFuncRankId" cssStyle="width:150"  list="funcRankList" headerKey="-1" headerValue="
--请选择--"  listKey="id" listValue="name" onChange="loadFuncRankConvert()">
					</s:select> 
					 <input type="text" id="convertValue" name="convertValue"  style="width:50"/>
				</td>
				<td>
<input type="button" onClick="saveFuncRankConvert()"  value="保存"  id="saveBt2"/>
				</td> 
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
