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
			patient.setAreaName("��¥");
			patient.setAssuranceType("����ҽ��" + ran);
			patient.setCardiopathy(1);
			patient.setCheckDate(new Date(System.currentTimeMillis() - 86400 * 1000 * (ran + 10)));
			patient.setCheckInDate(new Date(System.currentTimeMillis() - 86400 * 1000 * (ran + 8)));
			patient.setCheckOutDate(new Date(System.currentTimeMillis() - 86400 * 1000 * (ran + 3)));
			patient.setDiabetes(1);
			patient.setDiseaseType("������");
			patient.setFirstAdvice("סԺ����");
			patient.setFormalAdvice("��Ҫ����");
			patient.setGender(0);
			patient.setHalfMonth("֢״����");
			patient.setHypertension(1);
			patient.setIdNumber("" + ran * 3);
			patient.setLens("�߼�����");
			patient.setNeighbourhood("���԰" + (ran - 3) + "��");
			patient.setOd("os");
			patient.setOneWeek("֢״��������");
			patient.setDoctor("����" + 7 * ran);
			patient.setOperatorId(1);
			patient.setOs("od");
			patient.setPatientName("����ˮ��" + 6 * ran);
			patient.setPhone("" + 5 * ran + "1234567");
			patient.setSight(5.0f);
			patient.setStreet("�����Ŵ��" + ran + "��");
			patient.setTwoMonth("Ȭ��");
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
			o.setStreet("��ɽ��");
			o.setChiefOfficerName("����" + ran);
			o.setNeighbourhood("���԰" + ran);
			o.setAddress("������" + ran + "��");
			o.setScale(ran + "�˿�");
			o.setAssitOfficerName("��ܭ" + ran);
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
