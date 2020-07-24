<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="patientForm" name="patientForm" method="post">
	<s:hidden name="id"></s:hidden>
    <div class="ui-widget-content form_pad">
        <table class="table-a">
            <tr>
            <th class="text-a  ui-widget-content ui-corner-all" colspan="6">
                区域信息
            </th>
            </tr>
            <tr>
            <th><label for="areaNo">区县：<span style="color: red">*</span></label></th>
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
            <th><label for="street">街道：<span style="color: red">*</span></label></th>
            <td >
            	<s:textfield name="street" id="street" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
            </td>
            <th><label for="neighbourhood">社区：<span style="color: red">*</span></label></th>
            <td >
            	<s:textfield name="neighbourhood" id="neighbourhood" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
            </td>
        </tr>
        </table>
        <table class="table-a">
        	<tr>
            <th class="text-a  ui-widget-content ui-corner-all" colspan="6">
                患者资料
            </th>
            </tr>
        </table>    	
        <fieldset>
            <legend>基本资料</legend>
            <table class="table-a">
            	<tr>
                    <th><label for="patientName">姓名：<span style="color: red">*</span></label></th>
                    <td>
                    	<s:textfield name="patientName" id="patientName" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="phone">联系方式：<span style="color: red">*</span></label></th>
                    <td >
                    	<s:textfield name="phone" id="phone" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="gender">性别：<span style="color: red">*</span></label></th>
                    <td >
                    	<div id="genderContainer">
                    		<s:radio list="#{'0':'男','1':'女'}" name="gender" theme="simple"></s:radio>
                        </div>
                    </td>
            	</tr>
                <tr>
                    <th><label for="age">年龄：<span style="color: red">*</span></label></th>
                    <td >
                    	<s:textfield name="age" id="age" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="idNumber">证件号：</label></th>
                    <td>
                    	<s:textfield name="idNumber" id="idNumber" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="checkDate">检查日期：<span style="color: red">*</span></label></th>
                    <td >
                    	<s:textfield name="checkDate" id="checkDate" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple">
                    		<s:param name="value">
                    			<s:date name="checkDate" format="yyyy-MM-dd"/>
                    		</s:param>
                    	</s:textfield>
                    </td>
            	</tr>
                <tr>
                    <th><label for="assuranceType">医保类型：<span style="color: red">*</span></label></th>
                    <td colspan="5" style="text-align: left;">
                    	<div id="assuranceTypeContainer">
                    		<s:bean name="assuranceTypeBean" var="assurance"></s:bean>
                    		<s:radio list="#assurance.all" listKey="id" listValue="assuranceName" theme="simple" name="assuranceTypeId"></s:radio>
                    	</div>
                    </td>
            	</tr>
            </table>
        </fieldset>	
        <fieldset>
            <legend>检查资料</legend>
            <table class="table-a">
            	<tr>
                    <th width="12%"><label>既往病史：</label></th>
                    <td  style="text-align: left;" width="22%">
                        <div id="illnessContainer">
                        	<s:checkboxlist list="#{'1':'高血压','2':'糖尿病','3':'心脏病'}" theme="simple" name="illness" value="illnessList"></s:checkboxlist>
                        </div>
                    </td>
                    <th width="15%"><label for="od">OD：</label></th>
                    <td >
                    	<s:textfield name="od" id="od" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th width="10%"><label for="os">OS：</label></th>
                    <td >
                    	<s:textfield name="os" id="os" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
            	</tr>
                <tr>
                    <th><label for="firstAdvice">初步情况诊疗建议：</label></th>
                    <td colspan="5" style="text-align: left;">
                    	<div id="firstAdviceContainer">
                    	<s:bean name="firstAdviceBean" var="firstAdvice"></s:bean>
                    	<s:radio list="#firstAdvice.all" listKey="id" listValue="firstAdvice" theme="simple" name="firstAdviceId"></s:radio>
                    	</div>
                    </td>
            	</tr>
            	<tr>
            		<th><label for="diseaseType">眼病类型：</label></th>
                    <td colspan="5" style="text-align: left;">
                    	<div id="diseaseTypeContainer">
                    	<s:bean name="diseaseTypeBean" var="diseaseType"></s:bean>
                    	<s:radio list="#diseaseType.all" listKey="id" listValue="diseaseTypeName" theme="simple" name="diseaseTypeId"></s:radio>
                    	</div>
                    </td>
            	</tr>
            	<tr>
            		<th><label for="comeDate">来院日期：</label></th>
                    <td >
                    	<s:textfield name="comeDate" id="comeDate" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple">
                    		<s:param name="value">
                    			<s:date name="comeDate" format="yyyy-MM-dd"/>
                    		</s:param>
                    	</s:textfield>
                    </td>
                    <th><label for="formalAdvice">来院日期治疗建议：</label></th>
                    <td >
                    	<s:textarea name="formalAdvice" id="formalAdvice" rows="2" cols="25" cssStyle="overflow:auto" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textarea>
                    </td>
                    <th><label for="marketDoctor">开证医生：</label></th>
                    <td >
                        <s:textfield name="marketDoctor" id="marketDoctor" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
            	</tr>
            </table>
        </fieldset>	
        <fieldset>
            <legend>手术情况</legend>
            <table class="table-a">
            	<tr>
                    <th><label for="checkInDate">入院时间：</label></th>
                    <td >
                    	<s:textfield name="checkInDate" id="checkInDate" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple">
                    		<s:param name="value">
                    			<s:date name="checkInDate" format="yyyy-MM-dd"/>
                    		</s:param>
                    	</s:textfield>
                    </td>
                    <th><label for="checkOutDate">出院时间：</label></th>
                    <td >
                    	<s:textfield name="checkOutDate" id="checkOutDate" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple">
                    		<s:param name="value">
                    			<s:date name="checkOutDate" format="yyyy-MM-dd"/>
                    		</s:param>
                    	</s:textfield>
                    </td>
                    <th><label for="doctor">手术医师：</label></th>
                    <td >
                    	<s:textfield name="doctor" id="doctor" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
            	</tr>
                <tr>
                    <th><label for="sight">术后视力：</label></th>
                    <td>
                    	<s:textfield name="sight" id="sight" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <th><label for="lens">晶体类别：</label></th>
                    <td>
                    	<s:textfield name="lens" id="lens" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textfield>
                    </td>
                    <td colspan="4"></td>
            	</tr>
            </table>
        </fieldset>	
        <fieldset>
            <legend>回访情况</legend>
            <table class="table-a">
            	<tr>
                    <th><label for="oneWeek">一周：</label></th>
                    <td >
                    	<s:textarea name="oneWeek" id="oneWeek" rows="2" cols="25" cssStyle="overflow:auto" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textarea>
                    </td>
                    <th><label for="halfMonth">半个月：</label></th>
                    <td >
                    	<s:textarea name="halfMonth" id="halfMonth" rows="2" cols="25" cssStyle="overflow:auto" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textarea>
                    </td>
                    <th><label for="twoMonth">两个月：</label></th>
                    <td >
                    	<s:textarea name="twoMonth" id="twoMonth" rows="2" cols="25" cssStyle="overflow:auto" cssClass="text-a  ui-widget-content ui-corner-all" theme="simple"></s:textarea>
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
		$('#illnessContainer,#genderContainer,#assuranceTypeContainer,#firstAdviceContainer,#diseaseTypeContainer').buttonset();
		$('#checkInDate,#checkOutDate,#checkDate,#comeDate').datepicker(dataPickerOptions);//生成时间框。
		$('#btnSubmit').bind("click",function(){
			formSubmit("#patientForm","/patients/updatePatient.action");
		});
	});
</script>
