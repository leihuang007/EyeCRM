<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="officerForm" name="form" method="post">
	<s:hidden name="id"></s:hidden>
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
            	<s:textfield name="street" id="street" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
            </td>
            <th><label for="chiefOfficerName">负责人：</label></th>
            <td >
            	<s:textfield name="chiefOfficerName" id="chiefOfficerName" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
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
                    	<s:textfield name="neighbourhood" id="neighbourhood" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="address">地址：</label></th>
                    <td colspan="3">
                    	<s:textfield name="address" id="address" cssClass="text-a  ui-widget-content ui-corner-all" cssStyle="width:80%;" theme="simple"></s:textfield>
                    </td>
            	</tr>
                <tr>
                 	<th><label for="scale">规模：</label></th>
                    <td >
                    	<s:textfield name="scale" id="scale" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="assitOfficerName">负责人：</label></th>
                    <td >
                    	<s:textfield name="assitOfficerName" id="assitOfficerName" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="phone">联系方式：</label></th>
                    <td >
                    	<s:textfield name="phone" id="phone" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
            	</tr>
            	<tr>
            		<th><label for="comment">备注：</label></th>
                    <td colspan="5">
                    	<s:textarea rows="2" cols="25" name="comment" id="comment" cssClass="text-a  ui-widget-content ui-corner-all" cssStyle="width:90%;" theme="simple"></s:textarea>
                    </td>
            	</tr>
            </table>
        </fieldset>	
    </div>
    <div class="ui-widget-header ui-corner-top  ui-corner-bottom form_pad textRight"> 
        <button type="button" id="btnSubmit">修改</button>
        <button type="reset" id="btnReset">重置</button>
    </div>
</form>
<script type="text/javascript">
	function restForm(){
		$("#divDialog").dialog('destroy');
	}
	$(document).ready(function(e) {
        $('button').button();
		$('#btnSubmit').bind("click",function(){
			formSubmit("#officerForm","/officers/updateOfficer.action");
		});
	});
</script>
