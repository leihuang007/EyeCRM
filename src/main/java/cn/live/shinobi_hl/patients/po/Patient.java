/**
 * 
 */
package cn.live.shinobi_hl.patients.po;

import java.sql.Date;

import cn.live.shinobi_hl.common.utils.DateFormater;

/**
 * @author Huanglei
 * 
 */
public class Patient {

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 区县
	 */
	private String areaName;
	private String areaNo;
	/**
	 * 街道
	 */
	private String street;
	/**
	 * 社区
	 */
	private String neighbourhood;
	/**
	 * 姓名
	 */
	private String patientName;
	/**
	 * 证件号
	 */
	private String idNumber;
	/**
	 * 性别
	 */
	private int gender;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 医保类型编号
	 */
	private int assuranceTypeId;
	/**
	 * 医保类型
	 */
	private String assuranceType;
	/**
	 * 联系方式
	 */
	private String phone;
	/**
	 * 检查日期
	 */
	private Date checkDate;
	/**
	 * 高血压
	 */
	private int hypertension;
	/**
	 * 糖尿病
	 */
	private int diabetes;
	/**
	 * 心脏病
	 */
	private int cardiopathy;
	/**
	 * OD
	 */
	private String od;
	/**
	 * OS
	 */
	private String os;
	/**
	 * 初步诊疗建议编号
	 */
	private int firstAdviceId;
	/**
	 * 初步情况诊疗建议
	 */
	private String firstAdvice;
	/**
	 * 眼病类型编号
	 */
	private int diseaseTypeId;
	/**
	 * 眼病类型
	 */
	private String diseaseType;
	/**
	 * 来院日期
	 */
	private Date comeDate;
	/**
	 * 来院日期治疗建议
	 */
	private String formalAdvice;
	/**
	 * 开证医生
	 */
	private String marketDoctor;
	/**
	 * 一星期
	 */
	private String oneWeek;
	/**
	 * 半个月
	 */
	private String halfMonth;
	/**
	 * 两个月
	 */
	private String twoMonth;
	/**
	 * 入院日期
	 */
	private Date checkInDate;
	/**
	 * 出院日期
	 */
	private Date checkOutDate;
	/**
	 * 操作员
	 */
	private int operatorId;
	private String operatorName;
	/**
	 * 手术医生
	 */
	private String doctor;
	/**
	 * 术后视力
	 */
	private float sight;
	/**
	 * 晶体类别
	 */
	private String lens;

	/**
	 * 病人信息的状态字段。<br>
	 * 0为正常。1为删除。
	 */
	private int status;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append(id).append("|&|");
		sb.append(areaName).append("|&|");
		sb.append(street).append("|&|");
		sb.append(neighbourhood).append("|&|");
		sb.append(patientName).append("|&|");
		sb.append(idNumber).append("|&|");
		sb.append(gender).append("|&|");
		sb.append(age).append("|&|");
		sb.append(assuranceType).append("|&|");
		sb.append(phone).append("|&|");
		sb.append(DateFormater.dateToString(checkDate)).append("|&|");
		sb.append(hypertension).append("|&|");
		sb.append(diabetes).append("|&|");
		sb.append(cardiopathy).append("|&|");
		sb.append(od).append("|&|");
		sb.append(os).append("|&|");
		sb.append(firstAdvice).append("|&|");
		sb.append(diseaseType).append("|&|");
		sb.append(DateFormater.dateToString(comeDate)).append("|&|");
		sb.append(formalAdvice).append("|&|");
		sb.append(marketDoctor).append("|&|");
		sb.append(oneWeek).append("|&|");
		sb.append(halfMonth).append("|&|");
		sb.append(twoMonth).append("|&|");
		sb.append(DateFormater.dateToString(checkInDate)).append("|&|");
		sb.append(DateFormater.dateToString(checkOutDate)).append("|&|");
		sb.append(doctor).append("|&|");
		sb.append(sight).append("|&|");
		sb.append(lens);
		return sb.toString();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName
	 *            the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the areaNo
	 */
	public String getAreaNo() {
		return areaNo;
	}

	/**
	 * @param areaNo
	 *            the areaNo to set
	 */
	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the neighbourhood
	 */
	public String getNeighbourhood() {
		return neighbourhood;
	}

	/**
	 * @param neighbourhood
	 *            the neighbourhood to set
	 */
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName
	 *            the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber
	 *            the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * @return the gender
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the assuranceType
	 */
	public String getAssuranceType() {
		return assuranceType;
	}

	/**
	 * @param assuranceType
	 *            the assuranceType to set
	 */
	public void setAssuranceType(String assuranceType) {
		this.assuranceType = assuranceType;
	}

	/**
	 * @return the assuranceTypeId
	 */
	public int getAssuranceTypeId() {
		return assuranceTypeId;
	}

	/**
	 * @param assuranceTypeId
	 *            the assuranceTypeId to set
	 */
	public void setAssuranceTypeId(int assuranceTypeId) {
		this.assuranceTypeId = assuranceTypeId;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the checkDate
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * @param checkDate
	 *            the checkDate to set
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * @return the hypertension
	 */
	public int getHypertension() {
		return hypertension;
	}

	/**
	 * @param hypertension
	 *            the hypertension to set
	 */
	public void setHypertension(int hypertension) {
		this.hypertension = hypertension;
	}

	/**
	 * @return the diabetes
	 */
	public int getDiabetes() {
		return diabetes;
	}

	/**
	 * @param diabetes
	 *            the diabetes to set
	 */
	public void setDiabetes(int diabetes) {
		this.diabetes = diabetes;
	}

	/**
	 * @return the cardiopathy
	 */
	public int getCardiopathy() {
		return cardiopathy;
	}

	/**
	 * @param cardiopathy
	 *            the cardiopathy to set
	 */
	public void setCardiopathy(int cardiopathy) {
		this.cardiopathy = cardiopathy;
	}

	/**
	 * @return the od
	 */
	public String getOd() {
		return od;
	}

	/**
	 * @param od
	 *            the od to set
	 */
	public void setOd(String od) {
		this.od = od;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os
	 *            the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the firstAdvice
	 */
	public String getFirstAdvice() {
		return firstAdvice;
	}

	/**
	 * @param firstAdvice
	 *            the firstAdvice to set
	 */
	public void setFirstAdvice(String firstAdvice) {
		this.firstAdvice = firstAdvice;
	}

	/**
	 * @return the diseaseType
	 */
	public String getDiseaseType() {
		return diseaseType;
	}

	/**
	 * @param diseaseType
	 *            the diseaseType to set
	 */
	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	/**
	 * @return the formalAdvice
	 */
	public String getFormalAdvice() {
		return formalAdvice;
	}

	/**
	 * @param formalAdvice
	 *            the formalAdvice to set
	 */
	public void setFormalAdvice(String formalAdvice) {
		this.formalAdvice = formalAdvice;
	}

	/**
	 * @return the oneWeek
	 */
	public String getOneWeek() {
		return oneWeek;
	}

	/**
	 * @param oneWeek
	 *            the oneWeek to set
	 */
	public void setOneWeek(String oneWeek) {
		this.oneWeek = oneWeek;
	}

	/**
	 * @return the halfMonth
	 */
	public String getHalfMonth() {
		return halfMonth;
	}

	/**
	 * @param halfMonth
	 *            the halfMonth to set
	 */
	public void setHalfMonth(String halfMonth) {
		this.halfMonth = halfMonth;
	}

	/**
	 * @return the twoMonth
	 */
	public String getTwoMonth() {
		return twoMonth;
	}

	/**
	 * @param twoMonth
	 *            the twoMonth to set
	 */
	public void setTwoMonth(String twoMonth) {
		this.twoMonth = twoMonth;
	}

	/**
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate
	 *            the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate
	 *            the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the operatorId
	 */
	public int getOperatorId() {
		return operatorId;
	}

	/**
	 * @param operatorId
	 *            the operatorId to set
	 */
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * @return the operatorName
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * @param operatorName
	 *            the operatorName to set
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * @return the doctor
	 */
	public String getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor
	 *            the doctor to set
	 */
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the sight
	 */
	public float getSight() {
		return sight;
	}

	/**
	 * @param sight
	 *            the sight to set
	 */
	public void setSight(float sight) {
		this.sight = sight;
	}

	/**
	 * @return the lens
	 */
	public String getLens() {
		return lens;
	}

	/**
	 * @param lens
	 *            the lens to set
	 */
	public void setLens(String lens) {
		this.lens = lens;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the comeDate
	 */
	public Date getComeDate() {
		return comeDate;
	}

	/**
	 * @param comeDate
	 *            the comeDate to set
	 */
	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}

	/**
	 * @return the marketDoctor
	 */
	public String getMarketDoctor() {
		return marketDoctor;
	}

	/**
	 * @param marketDoctor
	 *            the marketDoctor to set
	 */
	public void setMarketDoctor(String marketDoctor) {
		this.marketDoctor = marketDoctor;
	}

	/**
	 * @return the firstAdviceId
	 */
	public int getFirstAdviceId() {
		return firstAdviceId;
	}

	/**
	 * @param firstAdviceId
	 *            the firstAdviceId to set
	 */
	public void setFirstAdviceId(int firstAdviceId) {
		this.firstAdviceId = firstAdviceId;
	}

	/**
	 * @return the diseaseTypeId
	 */
	public int getDiseaseTypeId() {
		return diseaseTypeId;
	}

	/**
	 * @param diseaseTypeId
	 *            the diseaseTypeId to set
	 */
	public void setDiseaseTypeId(int diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

}
