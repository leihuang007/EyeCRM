<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱尔眼科CRM系统主页</title>
<%@include file="/global_content.jsp" %>
</head>

<body>
	<div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad">
    	<div class="head textRight">
    		<div style="font-size: 1em;position: relative;top:50px;" id="adminInfo">
    			<a>欢迎：<s:property value='#session.admin.realName'/></a>
    			<a id='logout'>退出系统</a> 
    		</div>
    	</div>
    </div>
	<div id="menu">
        <div id="accordion">
            <h1>患者管理</h1>
            <div>
            	<a href="#" id="patientInfo">患者信息</a>
            </div>
            <h1>组织关系管理</h1>
            <div>
            	<a href="#" id="govInfo">街道办信息</a>
            </div>
            <h1>系统管理</h1>
            <div>
            	<a href="#" id="adminInfo">管理员信息</a>
            </div>
        </div>
    </div>
    <div id="content">
    	<div class="ui-widget-content form_pad">页面正在加载中，如长时间没有结果，请联系管理员。</div>
	</div>
	<!-- 这个层用于异步加载页面时使用 -->
    <div id="divDialog"></div>
    <!-- 这个层用于显示一些提示信息，譬如提交表单后提示你有东西没填 -->
    <div id="divTipDialog"></div>
    <!-- 这个层用于当confirm用，譬如选择删除后问你是不是确认 -->
    <div id="divConfirmDialog"></div>
    <!-- 这个层用来当进度条。 -->
    <div id="divSubmitProgressbarDialog"></div>
    <script type="text/javascript">
		function menuEvent(){
			$("#patientInfo").bind("click",function(){
				$("#content").load("/patients/manage_list.jsp");
			});
			$("#govInfo").bind("click",function(){
				$("#content").load("/officers/manage_list.jsp");
			});
		}
		$(document).ready(function(e) {
			menuEvent();
            $("#accordion").accordion({
				collapsible : true, //再次点击时关闭该菜单
				fillSpace : false,   //填充所有空间。
				create : function(event,menu){
					$("#patientInfo").trigger("click");
				}
			});
            //显示当前登陆用户名，以及退出按钮。
            $('#adminInfo').buttonset();
            //为退出按钮绑定事件。
            $("#logout").bind('click',function(){
            	commonInteract("/logout.action");
            });
            //初始化页面各元素的大小
            WINDOW_WIDTH = $(window).width();
            CONTENT_WIDTH = WINDOW_WIDTH-300;
            FLEXIGRID_WIDTH = CONTENT_WIDTH - 20;
        });
	</script>
</body>
</html>