// JavaScript Document

//以下参数需要在页面载入后重新计算，此处只提供全局变量，用于在各页面中共享值。
//页面宽度
var WINDOW_WIDTH = 0;
//页面高度
var WINDOW_HEIGHT = 0;
//内容区宽度
var CONTENT_WIDTH = 0;
//flexigrid宽度
var FLEXIGRID_WIDTH = 0;
//时间选择器的通用参数。
var dataPickerOptions = {
	changeMonth : true, // 通过下拉列表选择月份。
	changeYear : true,// 通过下拉列表选择年。
	monthNamesShort : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",
			"十月", "十一月", "十二月" ],
	dayNamesMin : [ "日", "一", "二", "三", "四", "五", "六" ],
	dateFormat : "yy-mm-dd"
};
//显示与隐藏时的特效
var SHOW_EFFECT = "drop";
var HIDE_EFFECT = "drop";
var TIME_OUT = 300*1000;
// 提交表单的通用处理方式
function formSubmit(formId, url) {
	var data = $(formId).serialize(); // 自动将form表单封装成键值对的形式
	$.ajax({
		type : 'POST',
		url : url,
		data : data,
		beforeSend : showSubmitProcessBar,
		success : showResultMessage,
		error : showResultMessage,
		timeout : TIME_OUT,
		dataType : "json"
	});
}
//处理不需要提交表单的情况，如退出系统,下载时提交查询参数等。
function commonInteract(url,data) {
	$.ajax({
		type : 'POST',
		url : url,
		data: data,
		beforeSend : showSubmitProcessBar,
		success : showResultMessage,
		error : showResultMessage,
		timeout : TIME_OUT,
		dataType : "json"
	});
}
// 显示提交时的提示信息。
function showSubmitProcessBar() {
	$("#divSubmitProgressbarDialog").dialog({
		title : "请求发送中。。。。",
		modal : true,
		resizable : false,
		height : -10,
		width : 500,
		close : function() {
			if ($("#divDialog").dialog('isOpen')) {
				$("#divDialog").dialog('destroy');
			}
		}
	}).prev().find(".ui-dialog-titlebar-close").hide();
	;
}
//通用的回调处理方法，各页面根据需要重写。
function restForm(){}
// 提交结束之后显示处理结果。
// 已知调用：新增病人；新增联系人
function showResultMessage(data, textStatus, jqXHR) {
	$("#divSubmitProgressbarDialog").dialog("destroy");
	var message = data["message"] == null ? '请求超时。' : data["message"];
	var codeNo = data["codeNo"];
	var title = "提示信息";
	if(data["ok"]){
		title='成功提示';
	}else{
		title='错误信息';
	}
	if ("redirect" == codeNo) {
		window.location = message;
		return;
	}
	if("tip" == codeNo){
		$("#divTipDialog").dialog({
			title : title,
			modal : true,
			open : $("#divTipDialog").html(message),
			close : function() {
				if(data["ok"]){
					restForm();
					//$("#divDialog").dialog('destroy');
					flexiReload();
				}
			},
			show : SHOW_EFFECT,
			hide : HIDE_EFFECT
		});
	}
}
// 将0和1转换为中文。
function transBoolean(celDiv, pid) {
	if ("1" == $(celDiv).html()) {
		$(celDiv).html("有") ;
	} else {
		$(celDiv).html("无") ;
	}
}
//转译性别
function transGender(celDiv,pid){
	if ("1" == $(celDiv).html()) {
		$(celDiv).html("女") ;
	} else {
		$(celDiv).html("男") ;
	}
}
//转译空值
function transNull(celDiv,pid){
	if ("null" == $(celDiv).html() || 'undefined'==$(celDiv).html() || $(celDiv).html()=='') {
//		$(celDiv).html("<span style='color:blue;'>【未填写】</span>") ;
		$(celDiv).html("") ;
	} 
}
//用来显示确认框
function showConfirm(message,url,data){
	$("#divConfirmDialog").dialog({
		tilte : "确认信息",
		modal : true,
		open : $("#divConfirmDialog").html(message),
		close : $("#divConfirmDialog").dialog('destroy'),
		show : SHOW_EFFECT,
		hide : HIDE_EFFECT,
		buttons : {
			"是" : function(){
				commonInteract(url,data);
				$("#divConfirmDialog").dialog('close');
			},
			"否" : function(){
				$("#divConfirmDialog").dialog('close');
			}
		}
	}).prev().find(".ui-dialog-titlebar-close").hide();
}
//显示警告框
function showAlert(message){
	$("#divConfirmDialog").dialog({
		tilte : "提示信息",
		modal : true,
		open : $("#divConfirmDialog").html(message),
		close : $("#divConfirmDialog").dialog('destroy'),
		show : SHOW_EFFECT,
		hide : HIDE_EFFECT,
		buttons : {
			"了解" : function(){
				$("#divConfirmDialog").dialog('close');
			}
		}
	}).prev().find(".ui-dialog-titlebar-close").hide();
}
