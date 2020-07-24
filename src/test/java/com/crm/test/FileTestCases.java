/**
 * 
 */
package com.crm.test;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import cn.live.shinobi_hl.common.utils.SysconfigUtils;
import cn.live.shinobi_hl.common.utils.filetools.impl.ExcelFileGenerator;
import cn.live.shinobi_hl.officers.po.Officer;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public class FileTestCases extends TestCase {

	public void testGenerateFile() {
		ExcelFileGenerator ef = new ExcelFileGenerator();
		int ran = 1;
		Random rand = new Random();
		List<Patient> l = new ArrayList<Patient>(200);
		for (int i = 0; i < 10; i++) {
			ran = (rand.nextInt() + 1) * 100;
			Patient patient = new Patient();
			patient.setAge(18 + ran - 2);
			patient.setAreaNo("025001");
			patient.setAreaName("鼓楼");
			patient.setAssuranceType("城镇医保" + ran);
			patient.setCardiopathy(1);
			patient.setCheckDate(new Date(System.currentTimeMillis() - 86400 * 1000 * (ran + 10)));
			patient.setCheckInDate(new Date(System.currentTimeMillis() - 86400 * 1000 * (ran + 8)));
			patient.setCheckOutDate(new Date(System.currentTimeMillis() - 86400 * 1000 * (ran + 3)));
			patient.setDiabetes(1);
			patient.setDiseaseType("白内障");
			patient.setFirstAdvice("住院治疗");
			patient.setFormalAdvice("需要手术");
			patient.setGender(0);
			patient.setHalfMonth("症状减轻");
			patient.setHypertension(1);
			patient.setIdNumber("" + ran * 3);
			patient.setLens("高级晶体");
			patient.setNeighbourhood("玉带园" + (ran - 3) + "号");
			patient.setOd("os");
			patient.setOneWeek("症状有所缓解");
			patient.setDoctor("麻团" + 7 * ran);
			patient.setOperatorId(1);
			patient.setOs("od");
			patient.setPatientName("大力水手" + 6 * ran);
			patient.setPhone("" + 5 * ran + "1234567");
			patient.setSight(5.0f);
			patient.setStreet("定淮门大街" + ran + "号");
			patient.setTwoMonth("痊愈");
			l.add(patient);
		}
		// ef.generateFile(0, l);
	}

	public void testLocation() {
		String dir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String loc = dir + "templates/officer_template.xlsx";
		System.out.println(dir);

		File file = new File(loc);
		if (file.exists()) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}
	}

	public void testFileLocation() {
		System.out.println(SysconfigUtils.getResourceRootDirLocation());
		System.out.println(SysconfigUtils.getTempDirLocation());
		System.out.println(SysconfigUtils.getTemplateDirLocation());
		System.out.println(SysconfigUtils.getOfficerTemplateFileLocation());
		System.out.println(SysconfigUtils.getPatientTemplateFileLocation());
	}

	public void testGenerateOfficerFile() {
		ExcelFileGenerator<Officer> ef = new ExcelFileGenerator<Officer>();
		int ran = 1;
		Random rand = new Random();
		List<Officer> l = new ArrayList<Officer>(200);
		for (int i = 0; i < 1; i++) {
			ran = (rand.nextInt() + 1) * 100;
			Officer o = new Officer();
			o.setId(ran);
			o.setAreaNo("025");
			o.setStreet("三山街");
			o.setChiefOfficerName("张良" + ran);
			o.setNeighbourhood("玉带园" + ran);
			o.setAddress("来凤里" + ran + "号");
			o.setScale(ran + "人口");
			o.setAssitOfficerName("刘墉" + ran);
			o.setPhone("" + ran * 4);
			l.add(o);
		}
		try {
			ef.generateFile(1, l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
