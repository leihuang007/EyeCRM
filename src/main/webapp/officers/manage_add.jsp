<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="officerForm" name="form" method="post">
    <div class="ui-widget-content form_pad">
        <table class="table-a">
            <tr>
            <th class="text-a  ui-widget-content ui-corner-all" colspan="6">
                区域信息
            </th>
            </tr>
            <tr>
            <th><label for="name">区县：</label></th>
            <td >
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
            <th><label for="street">街道：</label></th>
            <td >
                <input type="text" name="street" id="street" class="text-a  ui-widget-content ui-corner-all"/>
            </td>
            <th><label for="chiefOfficerName">负责人：</label></th>
            <td >
                <input type="text" name="chiefOfficerName" id="chiefOfficerName" class="text-a  ui-widget-content ui-corner-all"/>
            </td>
        </tr>
        </table>
        <table class="table-a">
        	<tr>
            <th class="text-a  ui-widget-content ui-corner-all" colspan="6">
                联系人资料
            </th>
            </tr>
        </table>    	
        <fieldset>
            <legend>基本资料</legend>
            <table class="table-a">
            	<tr>
                    <th><label for="neighbourhood">社区：</label></th>
                    <td >
                        <input type="text" name="neighbourhood" id="neighbourhood" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
                    <th><label for="address">地址：</label></th>
                    <td colspan="3">
                        <input type="text" name="address" id="address" class="text-a  ui-widget-content ui-corner-all" style="width:80%;"/>
                    </td>
            	</tr>
                <tr>
                 	<th><label for="scale">规模：</label></th>
                    <td >
                        <input type="text" name="scale" id="scale" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
                    <th><label for="assitOfficerName">负责人：</label></th>
                    <td >
                        <input type="text" name="assitOfficerName" id="assitOfficerName" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
                    <th><label for="phone">联系方式：</label></th>
                    <td >
                        <input type="text" name="phone" id="phone" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
            	</tr>
            	<tr>
            		<th><label for="comment">备注：</label></th>
                    <td colspan="5" class="textLeft">
                        <textarea rows="2" cols="25" name="comment" id="comment" class="text-a  ui-widget-content ui-corner-all" style="width:90%;"></textarea>
                    </td>
            	</tr>
            </table>
        </fieldset>	
    </div>
    <div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad textRight"> 
        <button type="button" id="btnSubmit">新增</button>
    </div>
</form>
<script type="text/javascript">
	function restForm(){
		$("#divDialog").dialog('destroy');
	}
	$(document).ready(function(e) {
        $('button').button();
		$('#btnSubmit').bind("click",function(){
			formSubmit("#officerForm","/officers/addOfficer.action");
		});
	});
</script>
