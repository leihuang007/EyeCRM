<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad"
	style="padding: 10px;">
	<form id="search_form" onsubmit="return false">
		<table>
			<tr>
				<th>区县：</th>
				<td>
				<s:bean name="areaInfoBean">
					<s:param name="adminAreaCodes">
						<s:property value='#session.admin.areaNo'/>
					</s:param>
					<s:select list="allValidAreaInfo" 
							name="areaNo" 
							listKey="areaCode" 
							listValue="areaName" 
							theme="simple"/>
				</s:bean>
				</td>
				<th>姓名：</th>
				<td><input id="nameAuto" name="patientName" /></td>
			</tr>
		</table>
		<table width="100%">
			<tr>
				<td class="textRight">
					<button type="button" id="btnSearch">查询</button>
					<button type="button" id="btnAddPatient">新增患者</button>
					<button type="button" id="btnDownloadPatient">下载表格</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<p></p>
<div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad"
	style="padding: 10px;">
	<table id="patientGrid"
		style="display: none; font-size: 12px; font-weight: normal;"></table>
</div>
<script type="text/javascript">
$("#patientGrid").flexigrid({
	url: '/patients/manageList.action',
    dataType: 'json',
    colModel : [
        {display: '序号', name : 'id', width : 20, sortable : true, align: 'left', hide:true},
        {display: '区县', name : 'areaName', width : 35, sortable : true, align: 'left'},
        {display: '街道', name : 'street', width : 60, sortable : true, align: 'left'},
        {display: '社区', name : 'neighbourhood', width : 60, sortable : true, align: 'left'},
        {display: '姓名', name : 'patientName', width : 50, sortable : true, align: 'left'},
        {display: '证件号', name : 'idNumber', width : 130, sortable : true, align: 'left', hide: true},
        {display: '性别', name : 'gender', width : 20, sortable : true, align: 'right',process:transGender},
        {display: '年龄', name : 'age', width : 20, sortable : true, align: 'left'},
        {display: '医保类型', name : 'assuranceType', width : 60, sortable : true, align: 'left'},
        {display: '联系方式', name : 'phone', width : 100, sortable : true, align: 'left'},
        {display: '检查日期', name : 'checkDate', width : 65, sortable : true, align: 'left'},
        {display: '高血压', name : 'hypertension', width : 40, sortable : true, align: 'left',process: transBoolean},
        {display: '糖尿病', name : 'diabetes', width : 40, sortable : true, align: 'left',process: transBoolean},
        {display: '心脏病', name : 'cardiopathy', width : 40, sortable : true, align: 'left',process: transBoolean},
        {display: 'OD', name : 'od', width : 20, sortable : true, align: 'left'},
        {display: 'OS', name : 'os', width : 20, sortable : true, align: 'left'},
        {display: '初步情况诊疗建议', name : 'firstAdvice', width : 85, sortable : true, align: 'left'},
        {display: '眼病类型', name : 'diseaseType', width : 45, sortable : true, align: 'left'},
        {display: '来院日期', name : 'comeDate', width : 65, sortable : true, align: 'left'},
        {display: '来院日期治疗建议', name : 'formalAdvice', width : 85, sortable : true, align: 'left'},
        {display: '开证医生', name : 'marketDoctor', width : 50, sortable : true, align: 'left',process:transNull},
        {display: '一星期', name : 'oneWeek', width : 40, sortable : true, align: 'left'},
        {display: '半个月', name : 'halfMonth', width : 40, sortable : true, align: 'left'},
        {display: '两个月', name : 'twoMonth', width : 40, sortable : true, align: 'left'},
        {display: '入院日期', name : 'checkInDate', width : 65, sortable : true, align: 'left'},
        {display: '出院日期', name : 'checkOutDate', width : 65, sortable : true, align: 'left'},
        {display: '手术医生', name : 'operator', width : 50, sortable : true, align: 'left'},
        {display: '术后视力', name : 'sight', width : 30, sortable : true, align: 'left'},
        {display: '晶体类别', name : 'lens', width : 40, sortable : true, align: 'left',process:transNull}
        ],
    width : FLEXIGRID_WIDTH,
    method:'post',
    sortname: "id",
    sortorder: "asc",
    title: '患者信息',
    rp: 15,
    showTableToggleBtn: true,
    height: 350,
    queryForm:true,
    buttons : [ {
		name : 'mod',
		displayName : "修改",
		bclass : 'Edit',
		onpress : flexiButtonHandler
	}, {
		name : 'delete',
		displayName : "删除",
		bclass : 'Delete',
		onpress : flexiButtonHandler
	}, {
		separator : true
	} ]
});
//刷新表格。
function flexiReload(){
	$("#patientGrid").flexReload();
}
//处理flexigrid表格中按钮的事件
function flexiButtonHandler(com,grid){
	if("mod" == com){
		var $selectedItems = $('.trSelected', grid);
		if(0 >= $selectedItems.length){
			showAlert("请选择要修改的数据。");
			return;
		}else if($selectedItems.length > 1){
			showAlert("一次只能修改一条数据。");
			return;
		}else{
			var id = $selectedItems[0].cells[0].innerText;
			$("#divDialog").dialog({
				title:'修改患者信息',
				modal: true	,
				width: 1100,
				height: 760,
			    open: function(event,ui){
					$(this).load("/patients/preUpdatePatient.action?id="+id);
				},
				close : function(){
					$(this).dialog('destroy');
				},
				show : SHOW_EFFECT,
				hide : HIDE_EFFECT
			});
		}
	}else if("delete" == com){
		var $selectedItems = $('.trSelected', grid);
		if(0 >= $selectedItems.length){
			showAlert("请选择要删除的数据。");
			return;
		}else{
			var ids = "";
			var itemsNum = $selectedItems.length;
			$.each($selectedItems,function(index,value){
				var id = value.cells[0].innerText;
				ids = ids+id+","; 
			});
			var message = "确认删除"+itemsNum+"条记录？";
			var data = [{
				name : "ids",
				value : ids
			}];
			showConfirm(message,"/patients/delPatient.action",data);
		}
	}
}
$(document).ready(function(e) {
	//初始化查询按钮、添加病人按钮
    $('button#btnSearch,button#btnAddPatient,button#btnDownloadPatient').button();
	//为添加病人按钮添加事件。
	$('#btnAddPatient').bind('click',function(){
		$("#divDialog").dialog({
			title:'添加患者信息',
			modal: true	,
			width: 1100,
			height: 760,
		    open: function(event,ui){
				$(this).load("/patients/manage_add.jsp");
			},
			show : SHOW_EFFECT,
			hide : HIDE_EFFECT
		});
	});
	//为下载病人列表按钮添加事件。
	$('#btnDownloadPatient').bind('click',function(){
		var param = [ {
				name: 'queryInfo',
				value: $('#search_form').serialize()
			}];
		commonInteract("/patients/preDownload.action",param);
	});
});
</script>
