<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>  
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>干啥儿</title>
	<sj:head jqueryui="true"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="job,jobsearch,search">
	<link href="${pageContext.request.contextPath}/css/skins/black.css" rel="stylesheet" type="text/css" /> 
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.hoverIntent.minified.js'></script>
	<script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery.dcmegamenu.1.3.3.js'></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.qtip-1.0.0-rc3.min.js"></script>
<script type='text/javascript'>
	
	$(document).ready(function($) {     
		$('#mega-menu').dcMegaMenu({        
		 rowItems: '1',         
		 speed: 'fast'    
		}); 
		$( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );   
		$( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
		
		$('<div/>').qtip({
							content: {
								text:'aaaaaaaaaaaaaaaaaaaaaaa',
								title: {
									text: 'craigsworks :: Login',
									button: false
								}
							},
							position: {
								at: 'center',
								my: 'center',
								viewport: $(window)
							},
							show: {
								event: 'click',
								ready: true, // Show it immediately on page load.. force them to login!
								modal: {
									on: true,
								}
							}
						});		
		
		//下面使用的是插件默认的样式显示,content是指要显示的内容（包括文字和图片）  
        $("#huangbiao").qtip({  
            content: 'Stems are great for indicating the context of the tooltip.',  
            style: {   
                tip: 'bottomLeft' // Notice the corner value is identical to the previously mentioned positioning corners  
            }  
        });  
          
        //style json是对提示样式的设置即外面的div样式设置，但是没有设置具体的位置  
        $("#huangbiao1").qtip({  
            content: '设置显示文字样式',  
            style: {   
                width: 200,  
                padding: 5,  
                background: '#A2D959',  
                color: 'black',  
                textAlign: 'center',  
                border: {  
                    width: 7,  
                    radius: 5,  
                    color: '#A2D959'  
                },  
                tip: 'bottomLeft',  
                name: 'dark' // Inherit the rest of the attributes from the preset dark style  
            }  
        });  
          
        //name:'green' 是继承了默认的提示样式，还有其他的name可以参考帮助文档  
        $("#huangbiao2").qtip({  
            content: '使用插件自定义的样式',  
            style: {   
                name: 'green' // Notice the corner value is identical to the previously mentioned positioning corners  
            }  
        });  
          
        //target:表示提示信息显示在控件的什么位置  
        //tooltip:  
        $("#huangbiao3").qtip({  
            content: 'Stems are great for indicating the context of the tooltip.',  
            position: {  
                corner: {  
                    target: 'topLeft',  
                    tooltip: 'bottomLeft'  
                }  
            }  
        });  
          
        $("#huangbiao4").qtip({  
            content: '<img src="img/2.jpg">',  
        });  
          
        //show 是指显示的情况，when是指什么事件触发让它显示出来，hide与show对应  
        //solo:  
        $("#huangbiao5").qtip({  
            content: '<img src="img/2.jpg">',  
            show:{  
                when:'click',  
                solo:false  
            },  
            hide:{  
                when:'click',  
                solo:false  
            }  
        });  
          
        //显示类似于“窗口”模式的样式，含有title和内容的提示信息  
        $("#huangbiao6").qtip({  
            content: {    
                title: {    
                    text: 'content-title-text',    
                    button: 'button'    
                },    
                text: 'content-text'    
            },  
            fixed:true  
        });  
          
        //api:是回调函数，beforeShow是在显示提示之前的提示信息，beforeHide则恰好相反；onRender是指内容呈现后调用  
        $("#huangbiao7").qtip({  
            content: 'use callback function',  
            api:{  
                beforeShow:function(){  
                    alert("beforeShow api function");  
                },    
                beforeHide:function(){  
                    alert("beforeHide api function");  
                }  
            }  
        });  
          
        $("#huangbiao9").qtip({  
            content: '',  
            style:{  
                width:"1024px",  
                height:"1024px",  
                background:"black"  
            }  
        });  
		
		$(".testajax").live("click", function(e) {
			e.preventDefault();
			$(this).qtip({
				id: 'login',
				content: {
					text: $('#loginform'),
					title: {
						text: 'craigsworks :: Login',
						button: false
					}
				},
				position: {
					at: 'center', // Position the tooltip above the link
					my: 'center',
					viewport: $(window) // Keep the tooltip on-screen at all times
				},
				show: {
					event: 'click',
					ready: true, // Show it immediately on page load.. force them to login!
					modal: {
						on: true,
		 
						// Don't let users exit the modal in any way
						blur: false, escape: false
					}
				},
				hide: false,
				style: {
					classes: 'qtip-light qtip-rounded',
					tip: false
				},
				events: {
					render: function(event, api) {
						// Capture the form submission
						$('form', this).bind('submit', function(event) {
							// Grab and store input elements
							var inputs = $(':input', this);
		 
							// Common ajax error handler
							function errorHandler(jqXHR, message) {
								// Set the error and show/hide it
								$('.error', api.elements.tooltip).html(message || '').toggle(!!message);
							}
		 
							// Setup AJAX request
							$.ajax({
								url: 'login/',
								data: $(this).serialize(),
								type: 'post',
								dataType: 'json',
								success: function(data, status, jqXHR) {
									// On success, show message and refresh after 2 seconds
									if(data.status === 'success'){
										api.set('content.text', data.message + ' Redirecting...');
										setTimeout(function(){ window.location.reload() }, 2000);
									}
		 
									// Call error handler on error status too.
									else { errorHandler(jqXHR, data.message); }
								},
								error: errorHandler,
		 
								// Disable/Enable input elements
								beforeSend: function() { inputs.attr('disabled', 'disabled'); },
								complete: function() { inputs.removeAttr('disabled'); inputs[0].focus(); }
							});
		 
							// Prevent normal form submission
							event.preventDefault();
						});
					}
				}
			});
		});
		
		$(".testtip").live("click", function(e) {
			e.preventDefault();
			$(this).qtip({
				overwrite: true,
				suppress: true,
				content: {
					text: '<div style="background:#fff;padding:40px;">Loading...</div>',
					ajax: {
						url: $(this).attr('href'),
						type: 'GET',
						data: {},
						loading: true,
						once: false,
						success: function(data, status) {
							this.set('content.text', data);
							//$("select").chosen({disable_search_threshold: 10000});
						}
					}
				},
				position: {
					my: 'left top',
					at: 'right center',
					effect: false
				},
				style: {
					classes: 'ui-tooltip-dark',
					tip: {
						corner: true,
						height: 18,
						width: 10,
						offset: 40,
						mimic: "left center"
					}
				},
				show: {
					effect: 'fade',
					event: 'click',
					solo: true
				},
				hide: false
			});

			$(this).data('qtip').show();
		});
		
		$(".tooltip-close").live("click", function(e) {
			e.preventDefault();
			$(".btn-muted-edit").qtip('hide');
		});
	}); 

</script>
<style>  .ui-tabs-vertical { width: 55em; }  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}  
  </style>

</head>
<body bottommargin="0" topmargin="0">
<s:form id="userWorkExpForm" method="post"  action="saveUserWorkExp" namespace="/resume">
<s:url id="companyname_remoteurl" action="resume/findCompanyListByTip.action"/>
          			<sj:autocompleter id="companyNames" 
           			 name="companyName"
					 href="%{companyname_remoteurl}"
           			 delay="50"	
					 maxlength="50"
           			 loadMinimumCount="2"  />
</s:form>					 
					 
<a href="${pageContext.request.contextPath}/resume/test.action" class="testajax">test  ajax</a>



<div id="demo-modal">
	<form action="/login" id="loginform" style="display: none;">
		<label for="login-un">Username:</label>
		<input id="login-un" name="username" value="" type="text" />
 
 
		<label for="login-pw">Password:</label>
		<input id="login-pw" name="password" value="" type="password" />
 
		<button>Login</button>
		<span class="error">Username: qtip   Password: qtip</span>
	</div>

<s:form name="loginform" method="post" action="login" namespace="/user" >
							<input name="email" type="text" maxlength="30" style=" border-color:#000000;height:30;width:200;"/>
							<input name="password" type="password" maxlength="20" style=" border-color:#000000;height:30;width:200;"/>
							<input name="submitbt" align="right" type="submit" value="登录" style="height:30;width:50;color:#000000; background-color:#FF9900;font-size:16px" />
						</s:form>

<div  style="text-align:center;"><span id="huangbiao">显示普通文字</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao1">设置显示文字样式</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao2">使用插件自定义的样式</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao3">设置提示的显示位置</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao4">显示图片</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao5">点击事件显示以及隐藏提示</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao6">含有标题的提示信息</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao7">使用回调函数</span></div>  
    <p>  
    <div  style="text-align:center;"><span id="huangbiao9">遮盖全屏</span></div>  

<div class="black">
	<ul id="mega-menu" class="mega-menu">
		<li><a href="#">Sale</a>
	  		<ul>         
	    		<li><a href="${pageContext.request.contextPath}/resume/test.action" class="testtip">Offer 1</a></li>
	   			<li><a href="#">Offer 2</a></li>
	    		<li><a href="#">Offer 3</a></li>
      		</ul>
	  	</li> 
	  	<li><a href="#">Contact</a></li> 
  </ul> 
	</div>
	
	<div id="tabs">  <ul>    <li><a href="#tabs-1">Nunc tincidunt</a></li>    <li><a href="#tabs-2">Proin dolor</a></li>    <li><a href="#tabs-3">Aenean lacinia</a></li>  </ul>  <div id="tabs-1">    <h2>Content heading 1</h2>    <p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>  </div>  <div id="tabs-2">    <h2>Content heading 2</h2>    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>  </div>  <div id="tabs-3">    <h2>Content heading 3</h2>    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>  </div></div>
	
 <sj:tabbedpanel id="localtabs" selectedTab="2" cssClass="list"> 
                             <sj:tab id="tab1" target="tone" label="Local Tab One"/> 
                             <sj:tab id="tab2" target="ttwo" label="Local Tab Two"/> 
                             <sj:tab id="tab3" target="tthree" label="Local Tab Three"/> 
                             <sj:tab id="tab4" target="tfour" label="Local Tab Four"/> 
                             <div id="tone">Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi 
                                 metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin 
                                 viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate. 
                             </div> 
                             <div id="ttwo">Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor 
                                 at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. 
                                 In suscipit faucibus urna. 
                             </div> 
                             <div id="tthree">Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque 
                                 purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, 
                                 magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui. 
                             </div> 
                             <div id="tfour">Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis 
                                 egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia 
                                 mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti 
                                 sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. 
                             </div> 
                         </sj:tabbedpanel> 
</body>
</html>