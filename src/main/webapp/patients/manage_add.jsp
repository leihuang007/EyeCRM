<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="patientForm" name="patientForm" method="post">
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
                <input type="text" name="street" id="street" value="" class="text-a  ui-widget-content ui-corner-all"/>
            </td>
            <th><label for="neighbourhood">社区：<span style="color: red">*</span></label></th>
            <td >
                <input type="text" name="neighbourhood" id="neighbourhood" value="" class="text-a  ui-widget-content ui-corner-all"/>
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
                    <td >
                        <input type="text" name="patientName" id="patientName" value="" class="text-a  ui-widget-content ui-corner-all restable"/>
                    </td>
                    <th><label for="phone">联系方式：<span style="color: red">*</span></label></th>
                    <td >
                        <input type="text" name="phone" id="phone" value="" class="text-a  ui-widget-content ui-corner-all restable"/>
                    </td>
                    <th><label for="gender">性别：<span style="color: red">*</span></label></th>
                    <td >
                    	<div id="genderContainer">
                            <input type="radio" id="male" name="gender" value="0" checked/>
                                <label for="male">男</label>
                            <input type="radio" id="female" name="gender" value="1"/>
                                <label for="female">女</label>
                        </div>
                    </td>
            	</tr>
                <tr>
                    <th><label for="age">年龄：<span style="color: red">*</span></label></th>
                    <td >
                        <input type="text" name="age" id="age" value="" class="text-a  ui-widget-content ui-corner-all restable"/>
                    </td>
                    <th><label for="idNumber">证件号：</label></th>
                    <td>
                        <input type="text" name="idNumber" id="idNumber" value="" class="text-a ui-widget-content ui-corner-all  restable"/>
                    </td>
                    <th><label for="checkDate">检查日期：<span style="color: red">*</span></label></th>
                    <td >
                        <input type="text" name="checkDate" id="checkDate" value="" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
            	</tr>
                <tr>
                	<th><label for="assuranceType">医保类型：<span style="color: red">*</span></label></th>
                    <td colspan="5" style="text-align: left;">
                    	<div id="assuranceTypeContainer">
                    	<s:bean name="assuranceTypeBean" var="assurance"></s:bean>
                    	<s:iterator value="#assurance.all" var="as">
                    		<input type="radio" name="assuranceTypeId" id='assuranceTypeId<s:property value="id"/>' value='<s:property value="id"/>' />
                    		<label for='assuranceTypeId<s:property value="id"/>'><s:property value="assuranceName"/></label>
                    	</s:iterator>
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
                    <td style="text-align: left;" width="22%">
                        <div id="illnessContainer">
                            <input type="checkbox" id="hypertension" name="illness" value="1" />
                                <label for="hypertension">高血压</label>
                            <input type="checkbox" id="diabetes" name="illness" value="2"/>
                                <label for="diabetes">糖尿病</label>
                            <input type="checkbox" id="cardiopathy" name="illness" value="3"/>
                                <label for="cardiopathy">心脏病</label>
                        </div>
                    </td>
                    <th width="15%"><label for="od">OD：</label></th>
                    <td >
                        <input type="text" name="od" id="od" value="" class="text-a  ui-widget-content ui-corner-all  restable"/>
                    </td>
                    <th width="10%"><label for="os">OS：</label></th>
                    <td>
                        <input type="text" name="os" id="os" value="" class="text-a  ui-widget-content ui-corner-all  restable"/>
                    </td>
            	</tr>
                <tr>
                    <th><label for="firstAdvice">初步情况诊疗建议：</label></th>
                    <td colspan="5" style="text-align: left;">
                    	<div id="firstAdviceContainer">
                    	<s:bean name="firstAdviceBean" var="firstAdvice"></s:bean>
                    	<s:iterator value="#firstAdvice.all" var="faAll">
                    		<input type="radio" name="firstAdviceId" id='firstAdviceId<s:property value="id"/>' value='<s:property value="id"/>' />
                    		<label for='firstAdviceId<s:property value="id"/>'><s:property value="firstAdvice"/></label>
                    	</s:iterator>
                    	</div>
                    </td>
            	</tr>
            	<tr>
            		<th><label for="diseaseType">眼病类型：</label></th>
                    <td colspan="5" style="text-align: left;">
                    	<div id="diseaseTypeContainer">
                    	<s:bean name="diseaseTypeBean" var="diseaseType"></s:bean>
                    	<s:iterator value="#diseaseType.all" var="dtAll">
                    		<input type="radio" name="diseaseTypeId" id='diseaseTypeId<s:property value="id"/>' value='<s:property value="id"/>' />
                    		<label for='diseaseTypeId<s:property value="id"/>'><s:property value="diseaseTypeName"/></label>
                    	</s:iterator>
                    	</div>
                    </td>
            	</tr>
            	<tr>
            		<th><label for="comeDate">来院日期：</label></th>
                    <td >
                        <input type="text" name="comeDate" id="comeDate" value="2010-01-01" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
                    <th><label for="formalAdvice">来院日期治疗建议：</label></th>
                    <td >
                        <textarea name="formalAdvice" id="formalAdvice" rows="2" cols="25" style="overflow:auto" class="ui-widget-content ui-corner-all restable"></textarea>
                    </td>
                    <th><label for="marketDoctor">开证医生：</label></th>
                    <td >
                        <input type="text" name="marketDoctor" id="marketDoctor" value="" class="text-a  ui-widget-content ui-corner-all"/>
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
                    	<input  type="text" name="checkInDate" id="checkInDate" value="2010-01-01" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
                    <th><label for="checkOutDate">出院时间：</label></th>
                    <td >
                    	<input  type="text" name="checkOutDate" id="checkOutDate" value="2010-01-01" class="text-a  ui-widget-content ui-corner-all"/>
                    </td>
                    <th><label for="doctor">手术医师：</label></th>
                    <td >
                        <input type="text" name="doctor" id="doctor" value="" class="text-a  ui-widget-content ui-corner-all restable"/>
                    </td>
            	</tr>
                <tr>
                    <th><label for="sight">术后视力：</label></th>
                    <td>
                        <input type="text" name="sight" id="sight" value="" class="text-a ui-widget-content ui-corner-all restable" />
                    </td>
                    <th><label for="lens">晶体类别：</label></th>
                    <td>
                        <input type="text" name="lens" id="lens" value="" class="text-a ui-widget-content ui-corner-all restable" />
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
                        <textarea name="oneWeek" id="oneWeek" rows="2" cols="25" style="overflow:auto" class="ui-widget-content ui-corner-all restable"></textarea>
                    </td>
                    <th><label for="halfMonth">半个月：</label></th>
                    <td >
                        <textarea name="halfMonth" id="halfMonth" rows="2" cols="25" style="overflow:auto" class="ui-widget-content ui-corner-all restable"></textarea>
                    </td>
                    <th><label for="twoMonth">两个月：</label></th>
                    <td >
                        <textarea name="twoMonth" id="twoMonth" rows="2" cols="25" style="overflow:auto" class="ui-widget-content ui-corner-all restable"></textarea>
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
		$("#patientForm *[class*='restable']").val("");
		//此处因为用了buttonset，所以在取消选择时只能以出发click事件的形式。
		$("input[name='illness']:checked").trigger('click');
	}
	$(document).ready(function(e) {
        $('button').button();
		$('#illnessContainer,#genderContainer,#assuranceTypeContainer,#firstAdviceContainer,#diseaseTypeContainer').buttonset();
		$('#checkInDate,#checkOutDate,#checkDate,#comeDate').datepicker(dataPickerOptions);//生成时间框。
		$('#btnSubmit').bind("click",function(){
			formSubmit("#patientForm","/patients/addPatient.action");
		});
	});
</script>
