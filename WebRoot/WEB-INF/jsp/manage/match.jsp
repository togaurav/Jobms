<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>人职匹配</title>
	<sj:head jqueryui="true" jquerytheme="south-street"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="个性化工作推荐，找工作，求职，人职匹配，职业生涯规划"> 
	<script src="${pageContext.request.contextPath}/js/alajax-1.2.js"></script>
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
			function checkResumeForm(){
				if($('#schoolNames_widget').attr("value").length<1){
					alert("学校名称不能为空！");
					return;
				}
				if($('#majorNames_widget').attr("value").length<1){
					alert("专业名称不能为空！");
					return;
				}
				if($('#usereducation').attr("value")==-1){
					alert("请选择一个学历！");
					return;
				}
			}
			function checkJobForm(){
				if($('#companyNames_widget').attr("value").length<1){
					alert("公司不能为空！");
					return;
				}
				if($('#jobNames_widget').attr("value").length<1){
					alert("职位不能为空！");
					return;
				}
				if($('#jobVO_industryId').attr("value")==-1){
					alert("请选择一个行业！");
					return;
				}
				if($('#jobYearNeed').attr("value")==-1){
					alert("请选择一个经验！");
					return;
				}
			}
			function analyseResume(){
				checkResumeForm();
				var params=$("#resumeForm").serialize();
				params = decodeURIComponent(params,true); 
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/analyseresume.action?"+params,   
                    data: [],   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	$("#resumeResultDiv").html(result);
                    },
				    complete:function(XMLHttpRequest,textStatus){
				    },
                    error: function (result) {
						$("#resumeResultDiv").html("<font color='red'>计算时出现错误!</font>");
                    }
                });
			}
			
			function analyseJob(){
				checkJobForm();
				var params=$("#jobForm").serialize();
				params = decodeURIComponent(params,true); 
			    $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/analysejob.action?"+params,   
                    data: [],   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	$("#jobResultDiv").html(result);
                    },
				    complete:function(XMLHttpRequest,textStatus){
				    },
                    error: function (result) {
						$("#jobResultDiv").html("<font color='red'>计算时出现错误!</font>");
                    }
                });
			}
			
			function analyseMatch(){
				checkJobForm();
				var params1=$("#jobForm").serialize();
				var params2=$("#resumeForm").serialize();
				params1 = decodeURIComponent(params1,true); 
				params2 = decodeURIComponent(params2,true); 
			   $.ajax({
                    type: "GET", 
                    contentType: "application/json",    
                    url: "${pageContext.request.contextPath}/match/analysematch.action?"+params1+"&"+params2,   
                    data: [],   
					timeout:15000,
                    dataType: 'json', 
                    success: function (result) {
                    	$("#matchResultDiv").html(result);
                    },
				    complete:function(XMLHttpRequest,textStatus){
				    },
                    error: function (result) {
						$("#matchResultDiv").html("<font color='red'>计算时出现错误!</font>");
                    }
                });
				
			}
	</script>  
</head>
<body bottommargin="0" topmargin="0" >
<%@ include file="../top.jsp"%> 
<h2 class="STYLE4">1：输入简历</h2>
<h3 class="STYLE4">&nbsp;&nbsp;&nbsp;>>教育背景</h3>
<s:form  id="resumeForm"  name="resumeForm" method="post" autocomplete="false"  action="analyseresume" namespace="/match">
<span class="STYLE4">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学校:
    <label>
    <s:url id="schoolname_remoteurl" action="findSchoolListByTip" namespace="/resume"/>
          			<sj:autocompleter id="schoolNames" 
           			 name="userEducateExpVO.schoolName"
					 href="%{schoolname_remoteurl}"
           			 delay="50"	
					 maxlength="40"
           			 loadMinimumCount="2"  />
    </label>
    <label>
    <input type="text" name="schoolresult" readonly style="width:100"/>
    </label>
  专业:
  <label>
    <s:url id="majorname_remoteurl" action="findMajorListByTip" namespace="/resume"/>
          			<sj:autocompleter id="majorNames" 
           			 name="userEducateExpVO.majorName"
					 href="%{majorname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
  </label>
学历:
<label>
	<s:select id="usereducation" name="userEducateExpVO.education"    
		list="#{-1:'--请选择--',1:'博士后',2:'博士',3:'硕士',4:'本科',5:'大专',6:'其他'}" >  </s:select>	
</label>
<label>
    <input type="text" name="educateresult" readonly style="width:100"/>
</label>
</span>
<h3 class="STYLE4">&nbsp;&nbsp;&nbsp;>>工作经历</h3>
  <span class="STYLE4"><nobr>
  </nobr></span><nobr><table width="100%" border="0" cellspacing="0" cellpadding="1">
    <tr>
      <td class="STYLE4"><p>&nbsp;&nbsp;&nbsp;1)、公司: 
          <label>
        	<s:url id="companyname_remoteurl" action="findCompanyListByTip" namespace="/resume"/>
          			<sj:autocompleter id="companyNames1" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
			<input type="text" name="companyresult1" readonly style="width:100"/>
        </label>
职位:
<label>
	<s:url id="jobname_remoteurl" action="findJobListByTip" namespace="/resume"/>
          			<sj:autocompleter id="jobNames1" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
</label>
行业:
<label>
<s:select  name="userWorkExpVO.industryId" cssStyle="width:150"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name">					</s:select>
</label>时间：
          <label>
          	 <s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  			</s:select>
          </label>
年
	<s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>
月—
<label>
	<s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" >				  </s:select>
</label>
年
	<s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" >				  </s:select>
月</td>
    </tr>
    <tr>
      <td class="STYLE4">&nbsp;&nbsp;&nbsp;2)、公司: 
          <label>
          <sj:autocompleter id="companyNames2" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
			<input type="text" name="companyresult2" readonly style="width:100"/>
          </label>
职位:
<label>
		  <sj:autocompleter id="jobNames2" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
</label>
行业:
<label>
<s:select  name="userWorkExpVO.industryId" cssStyle="width:150"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name"> </s:select>
</label>
时间：
<label>
<s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月—
<label>
<s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月</td>
    </tr>
    <tr>
      <td class="STYLE4">&nbsp;&nbsp;&nbsp;3)、公司: 
          <label>
          <sj:autocompleter id="companyNames3" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
		<input type="text" name="companyresult3" readonly style="width:100"/>
          </label>
职位:
<label>
			<sj:autocompleter id="jobNames3" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
</label>
行业:
<label>
<s:select  name="userWorkExpVO.industryId" cssStyle="width:150"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name"> </s:select>
</label>
时间：
<label>
<s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月—
<label>
<s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月</td>
    </tr>
    <tr>
      <td class="STYLE4">&nbsp;&nbsp;&nbsp;4)、公司: 
          <label>
          <sj:autocompleter id="companyNames4" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
		<input type="text" name="companyresult4" readonly style="width:100"/>
          </label>
职位:
<label>
			<sj:autocompleter id="jobNames3" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
</label>
行业:
<label>
<s:select name="userWorkExpVO.industryId" cssStyle="width:150"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name"> </s:select>
</label>
时间：
<label>
<s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月—
<label>
<s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月</td>
    </tr>
    <tr>
      <td class="STYLE4">&nbsp;&nbsp;&nbsp;5)、公司: 
          <label>
          <sj:autocompleter id="companyNames5" 
           			 name="userWorkExpVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
		<input type="text" name="companyresult5" readonly style="width:100"/>
          </label>
职位:
<label>
			<sj:autocompleter id="jobNames3" 
           			 name="userWorkExpVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
</label>
行业:
<label>
<s:select name="userWorkExpVO.industryId" cssStyle="width:150"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name"> </s:select>
</label>
时间：
<label>
<s:select name="userWorkExpVO.ondutyYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.ondutyMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月—
<label>
<s:select name="userWorkExpVO.leaveYear" list="{'2013','2012','2011','2010','2009','2008','2007','2006','2005','2004','2003','2002','2001','2000'}" > </s:select>
</label>
年
<s:select name="userWorkExpVO.leaveMonth" list="{'1','2','3','4','5','6','7','8','9','10','11','12'}" > </s:select>
月</td>
    </tr>		
  </table>
  </nobr>

  <p class="STYLE4">
  <input type="button" name="Submit" value="简历分析" onclick="analyseResume()">
  </p>
</s:form>  
<div class="STYLE4" id="resumeResultDiv">

</div>
<h2 class="STYLE4">2：选择职位</h2>
<span class="STYLE4">
<s:form id="jobForm" name="jobForm" method="post" action="analysejob" namespace="/match" >
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司: 
          <label>
          			<sj:autocompleter id="companyNames" 
           			 name="jobVO.companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
	        <input type="text" name="companyresult" readonly style="width:100"/>
          </label>
职位:
<label>
          			<sj:autocompleter id="jobNames" 
           			 name="jobVO.jobName"
					 href="%{jobname_remoteurl}"
           			 delay="50"	
					 maxlength="30"
           			 loadMinimumCount="2"  />
</label>
行业:
<label>
<s:select id="jobVO_industryId" name="jobVO.industryId" cssStyle="width:150"  list="industryList" headerKey="0" headerValue="
--请选择--"  listKey="id" listValue="name"> </s:select>
</label>
经验要求:
<label>
  <s:select id="jobYearNeed"  name="jobVO.servicelen"    list="#{-1:'--请选择--',0 :'无要求', 1 :'1年', 2:'2年', 3:'3年', 4:'4年', 5 :'5年', 6 :'6年', 7 :'7年', 8 :'8年', 9 :'9年', 10 :'10年'}" >  </s:select>
</label>
<p>
  <input type="button" name="Submit2" value="职位分析" onclick="analyseJob()">
</p>
</s:form>
</span>
<div class="STYLE4" id="jobResultDiv"></div>
<h2 class="STYLE4">3：匹配分析</h2>
<p>
  <input type="button" name="Submit22" value="匹配分析" onClick="analyseMatch()">
</p>
<div  class="STYLE4" id="matchResultDiv"></div>
<%@ include file="../bottom.jsp"%> 
</body>
</html>
