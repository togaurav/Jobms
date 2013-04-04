<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>知识技能管理</title>
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
			
			function listability2(){
				if($('#ability1').attr("value")==-1){
					alert("请选择一个一级知识技能!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/listAbility2.action?path="+$('#ability1').attr("value"),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability2'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability2").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			function listability3(){
				if($('#ability2').attr("value")==-1){
					alert("请选择一个二级知识技能!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/listAbility3.action?path="+$('#ability2').attr("value"),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability3'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability3").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			function listability4(){
				if($('#ability3').attr("value")==-1){
					alert("请选择一个三级知识技能!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/listAbility4.action?path="+$('#ability3').attr("value"),   
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability4'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability4").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			
			function addability1(){
				
				if($('#abilityname1').attr("value").length<1){
					alert("请输入一级知识技能名称!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/add1.action?path="+$('#ability1').attr('value')+"&abilityname1="+$('#abilityname1').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
						document.all.abilityname1.value="";
                    	var jqueryObj=$(result);          
						document.all['ability1'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability1").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			function delability1(){				
				if($('#ability1').attr("value")==-1){
					alert("请选择一个一级知识技能!");
					return;
				}
				if(!window.confirm('确定要删除?'))return;
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/delete1.action?path="+$('#ability1').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability1'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability1").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			
			function addability2(){
				
				if($('#abilityname2').attr("value").length<1){
					alert("请输入二级知识技能名称!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/add2.action?path="+$('#ability1').attr('value')+"&abilityname2="+$('#abilityname2').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
						document.all.abilityname2.value="";
                    	var jqueryObj=$(result);          
						document.all['ability2'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability2").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			function delability2(){				
				if($('#ability2').attr("value")==-1){
					alert("请选择一个二级知识技能!");
					return;
				}
				if(!window.confirm('确定要删除?'))return;
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/delete2.action?path="+$('#ability2').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability2'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability2").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			
			function addability3(){
				
				if($('#abilityname3').attr("value").length<1){
					alert("请输入三级知识技能名称!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/add3.action?path="+$('#ability2').attr('value')+"&abilityname3="+$('#abilityname3').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
						document.all.abilityname3.value="";
                    	var jqueryObj=$(result);          
						document.all['ability3'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability3").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			function delability3(){				
				if($('#ability3').attr("value")==-1){
					alert("请选择一个三级知识技能!");
					return;
				}
				if(!window.confirm('确定要删除?'))return;
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/delete3.action?path="+$('#ability3').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability3'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability3").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			
			function addability4(){
				
				if($('#abilityname4').attr("value").length<1){
					alert("请输入四级知识技能名称!");
					return;
				}
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/add4.action?path="+$('#ability3').attr('value')+"&abilityname4="+$('#abilityname4').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
						document.all.abilityname4.value="";
                    	var jqueryObj=$(result);          
						document.all['ability4'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability4").html(str); 
                    },
				    complete:function(XMLHttpRequest,textStatus){
					 	$("#loadingdiv").empty();
				    },
                    error: function (result) {
						$("#loadingdiv").html("<strong><font color='red'>加载职位数据出现异常!</font></strong>");
                    }
                });
			}
			function delability4(){				
				if($('#ability4').attr("value")==-1){
					alert("请选择一个四级知识技能!");
					return;
				}
				if(!window.confirm('确定要删除?'))return;
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/ability/delete4.action?path="+$('#ability4').attr('value'),
                    data: {},   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	var jqueryObj=$(result);          
						document.all['ability4'].options.length = 0;   
						var str="<option value='-1'>----请选择----</option>";   
						for(var i=0;i<jqueryObj.length;i++){   
							str+="<option value='"+jqueryObj[i].path+"'>"+jqueryObj[i].name+"</option>";
						}   
						$("#ability4").html(str); 
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
	<sj:tab id="tab1" target="tone" label="知识技能管理" /> 
	<div id="tone" >
		 	<table width="100%" height="250" border="0" cellspacing="1" cellpadding="0">
              <tr>
                <td align="right">一级知识技能：</td>
                <td>&nbsp;
					<s:select  id="ability1" name="ability1" cssStyle="width:150"  list="abilityList" headerKey="-1" headerValue="
--请选择--"  listKey="path" listValue="name" onChange="listability2()">
 
					</s:select>
					<input type="button" name="delbt1" value="删除" onClick="delability1()"/>
					<input type="text" id="abilityname1" name="abilityname1" maxlength="20" value=''/>
					<input type="button" name="addbt1" value="增加" onClick="addability1()"/>
				</td>
              </tr>
                <tr>
                <td align="right">二级知识技能：</td>
                <td>&nbsp;
					<select  id="ability2" name="ability2" style="width:150"  onChange="listability3()">
 						<option value="-1">----请选择----</option>
					</select>
					<input type="button" name="delbt2" value="删除" onClick="delability2()"/>
					<input type="text" id="abilityname2" name="abilityname2" maxlength="20" value=''/>
					<input type="button" name="addbt2" value="增加" onClick="addability2()"/>
				</td>
              </tr>
              <tr>
                <td align="right" >三级知识技能：</td>
                <td >&nbsp;
					<select  id="ability3" name="ability3" style="width:150"   onChange="listability4()">
 						<option value="-1">----请选择----</option>
					</select>
					<input type="button" name="delbt3" value="删除" onClick="delability3()"/>
					<input type="text" id="abilityname3" name="abilityname3" maxlength="20" value=''/>
					<input type="button" name="addbt3" value="增加" onClick="addability3()"/>
				</td>
              </tr>
			 <tr>
                <td align="right" >四级知识技能：</td>
                <td >&nbsp;
					 <select  id="ability4" name="ability4" style="width:150">
 						<option value="-1">----请选择----</option>
					</select>
					<input type="button" name="delbt4" value="删除" onClick="delability4()"/>
					<input type="text" id="abilityname4" name="abilityname4" maxlength="20" value=''/>
					<input type="button" name="addbt4" value="增加" onClick="addability4()"/>
				</td>
              </tr>	
            </table>
			</div>
			</sj:tabbedpanel> 
</div>	</td>
  </tr>
</table> 	
<%@ include file="../bottom.jsp"%> 
</body>
</html>
