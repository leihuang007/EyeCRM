<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱尔眼科医院CRM系统</title>
<%@include file="/global_content.jsp" %>
</head>

<body>
<div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad">
	<div class="head"></div>
</div>
<form id="formLogin" name="form" method="post">
  <div class="ui-widget-content form_pad text_center">
    <h1>CRM系统登录</h1>
  </div>
  <div class="ui-widget-content form_pad">
  	<table id="formTable" border="0" align="center">
    	<tr>
        	<td rowspan="2" class="textRight" width="40%">
            	<img src="images/logo2.jpg" width="200px" height="200px"/>
            </td>
        	<th width="10%"><label for="name">用户名：</label></th>
      		<td class="textLeft">
            	<input type="text" name="model.userName" id="name" class="text ui-widget-content ui-corner-all" />
      		</td>
        </tr>
        <tr>
        	<th><label for="password">密&nbsp;&nbsp;&nbsp;码：</label></th>
      		<td class="textLeft" width="50%">
            	<input type="password" name="model.password" id="password" value="" class="text ui-widget-content ui-corner-all" />
            </td>
    	</tr>
    </table>
  </div>
  <div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad text_center">
    <button type="button" id="btnLogin">登陆</button>
    <button type="reset">重置</button>
  </div>
</form>
	<div id="divDialog"></div>
    <div id="divTipDialog"></div>
    <div id="divSubmitProgressbarDialog"></div>
<script type="text/javascript">
	$(document).ready(function(e) {
   		$('button').button();
   		$('#btnLogin').bind('click',function(){
   			formSubmit("#formLogin","/login.action");
   		});
   		$('#name').focus();
	});
</script>
</body>
</html>