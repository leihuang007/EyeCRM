<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错界面</title>
<%@include file="/global_content.jsp" %>
</head>
<body>
	<img alt="出错了！！！" src="/images/error.jpg">
	<div id="divTipDialog"></div>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#divTipDialog').dialog({
					title: "出错了。。。。",
					open:$(this).html("貌似出错了，而且是我没预料到的那种……")
			});
		});
	</script>
</body>
</html>