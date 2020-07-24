<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad" style="padding:10px;">
    <form id="search_form" onsubmit="return false">
        <table>
            <tr>
                <th>区县：</th>
                <td>
                    <s:bean name="areaInfoBean">
					<s:param name="parentAreaCode">
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
                <td>
                    <input id="nameAuto" name="chiefOfficerName"/>
                </td>
            </tr>
        </table>
        <table width="100%">
        	<tr>
            	<td class="textRight">
                	<button type="button" id="btnSearch">查询</button>
                	<button type="button" id="btnAddOfficer">新增联系人</button>
                	<button type="button" id="btnDownloadOfficer">下载表格</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<p></p>
<div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad" style="padding:10px;">
    <table id="patientGrid" style="display:none;font-size:12px;font-weight:normal;"></table>
</div>

<script type="text/javascript">
    $("#patientGrid").flexigrid({
        url: '/officers/manageList.action',
        dataType: 'json',
        colModel : [
            {display: '序号', name : 'id', width : 20, sortable : true, align: 'left', hide:true},
            {display: '区县', name : 'areaName', width : 50, sortable : true, align: 'left'},
            {display: '街道', name : 'street', width : 100, sortable : true, align: 'left'},
			{display: '负责人', name : 'chiefOfficerName', width : 60, sortable : true, align: 'left'},
            {display: '社区', name : 'neighbourhood', width : 140, sortable : true, align: 'left'},
			{display: '地址', name : 'address', width : 240, sortable : true, align: 'left'},
			{display: '规模', name : 'scale', width : 80, sortable : true, align: 'left'},
            {display: '负责人', name : 'assitOfficerName', width : 120, sortable : true, align: 'left'},
            {display: '联系方式', name : 'phone', width : 120, sortable : true, align: 'left'},
            {display: '备注', name : 'comment', width : 120, sortable : true, align: 'left',process:transNull}
            ],
        method:'post',
        sortname: "id",
        sortorder: "asc",
        usepager: true,
        title: '组织联系人信息',
        useRp: true,
        rp: 15,
        showTableToggleBtn: true,
        width: FLEXIGRID_WIDTH,
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
    var names = [];
    $('input#nameAuto').autocomplete({
        source : names	
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
    				width: 800,
    				height: 350,
    			    open: function(event,ui){
    					$(this).load("/officers/preUpdateOfficer.action?id="+id);
    				},
    				close : function(){
    					$("#divDialog").dialog('destroy');
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
    			showConfirm(message,"/officers/delOfficer.action",data);
    		}
    	}
    }
	$(document).ready(function(e) {
        $('button').button();
		$('#btnAddOfficer').bind('click',function(){
			$("#divDialog").dialog({
				title:'添加联系人信息',
				modal: true,
				width: 800,
				height: 350,
				open: function(event,ui){
					$("#divDialog").load("/officers/manage_add.jsp");
				},
				show : SHOW_EFFECT,
				hide : HIDE_EFFECT
			});
		});
		//为下载联系人按钮添加事件。
		$('#btnDownloadOfficer').bind('click',function(){
			var param = [ {
					name: 'queryInfo',
					value: $('#search_form').serialize()
				}];
			commonInteract("/officers/preDownload.action",param);
		});
    });
</script>

