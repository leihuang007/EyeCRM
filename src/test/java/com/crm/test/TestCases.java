/**
 * 
 */
package com.crm.test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.live.shinobi_hl.common.dao.intf.OperatorDao;
import cn.live.shinobi_hl.common.po.Operator;
import cn.live.shinobi_hl.common.utils.CommonUtils;
import cn.live.shinobi_hl.common.utils.DateFormater;
import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.patients.bo.impl.PatientBoImpl;
import cn.live.shinobi_hl.patients.dao.intf.PatientsDao;
import cn.live.shinobi_hl.patients.po.Patient;
import cn.live.shinobi_hl.patients.ui.PatientAction;

/**
 * @author Huanglei
 * 
 */
public class TestCases extends TestCase {

	private ApplicationContext context;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public void testInsertAdmin() {
		OperatorDao dao = (OperatorDao) context.getBean("operatorDAO");
		Operator op = new Operator();
		op.setUserName("huanglei55");
		op.setPassword("123123");
		op.setType(0);
		dao.save(op);
	}

	public void testInsertPatient() {
		Random rand = new Random();
		PatientsDao dao = (PatientsDao) context.getBean("patientsDAO");
		int ran = 1;
		for (int i = 0; i < 121; i++) {
			ran = (rand.nextInt() + 1) * 100;
			Patient patient = new Patient();
			patient.setAge(18);
			patient.setAreaNo("025001");
			patient.setAreaName("鼓楼");
			patient.setAssuranceTypeId(2);
			// patient.setAssuranceType("城镇医保" + ran);
			patient.setCardiopathy(1);
			patient.setCheckDate(new Date(System.currentTimeMillis() - 86400
					* 1000 * (ran + 10)));
			patient.setCheckInDate(new Date(System.currentTimeMillis() - 86400
					* 1000 * (ran + 8)));
			patient.setCheckOutDate(new Date(System.currentTimeMillis() - 86400
					* 1000 * (ran + 3)));
			patient.setDiabetes(1);
			patient.setDiseaseTypeId(2);
			patient.setFirstAdviceId(3);
			// patient.setDiseaseType("白内障");
			// patient.setFirstAdvice("住院治疗");
			patient.setComeDate(new Date(System.currentTimeMillis() - 86400
					* 1000 * (ran + 3)));
			patient.setFormalAdvice("需要手术");
			patient.setGender(0);
			patient.setHalfMonth("症状减轻");
			patient.setHypertension(1);
			patient.setIdNumber("" + ran * 3);
			patient.setLens("高级晶体");
			patient.setNeighbourhood("玉带园" + (ran - 3) + "号");
			patient.setOd("od");
			patient.setOneWeek("症状有所缓解");
			patient.setDoctor("麻团" + 7 * ran);
			patient.setOperatorId(1);
			patient.setOs("os");
			patient.setPatientName("大力水手" + 6 * ran);
			patient.setPhone("" + 5 * ran + "1234567");
			patient.setSight(5.0f);
			patient.setStreet("定淮门大街" + ran + "号");
			patient.setTwoMonth("痊愈");
			dao.save(patient);
		}
	}

	public void testPatientAction() {
		PatientAction action = (PatientAction) context.getBean("patientAction");
		action.add();
	}

	public void testPatientPage() {
		Map<String, String> conditions = new HashMap<String, String>();
		// conditions.put("patientName", "39");
		conditions.put("areaNo", "025006");
		PageInfo info = new PageInfo();
		info.setConditions(conditions);
		info.setPage(1);
		info.setRp(15);
		info.setSortname("neighbourhood");
		info.setSortorder("asc");
		PatientsDao dao = (PatientsDao) context.getBean("patientsDAO");
		dao.getPage(info);
		System.out.println(info.getTotal());
		List<Patient> list = info.getResultList();
		// System.out.println(list.size());
		for (Patient p : list) {
			System.out.println(p.getPatientName());
		}
	}

	public void testUrlToMap() {
		CommonUtils.urlToMap("abc");
	}

	public void testDateConverter() {
		System.out.println(DateFormater.dateToString(new java.util.Date(),
				DateFormater.NARROW_LONG_FORMAT));
	}

	public void testDeletePatient() {
		String[] strArray = { "3", "12", "a", "chalie", "6", "" };
		for (String id : strArray) {
			System.out.print(id);
			System.out.print('\t');
		}
		System.out.println();
		PatientBoImpl bo = (PatientBoImpl) context.getBean("patientsBO");
		bo.batchDeleteValid(strArray);
		for (String id : strArray) {
			System.out.print(id);
			System.out.print('\t');
		}
	}
}
