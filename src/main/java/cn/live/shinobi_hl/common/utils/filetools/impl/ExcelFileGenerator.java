/**
 * 
 */
package cn.live.shinobi_hl.common.utils.filetools.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cn.live.shinobi_hl.common.utils.DateFormater;
import cn.live.shinobi_hl.common.utils.SysconfigUtils;
import cn.live.shinobi_hl.common.utils.filetools.intf.FileGenerator;
import cn.live.shinobi_hl.officers.po.Officer;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public class ExcelFileGenerator<T> implements FileGenerator<T> {

	@Override
	public String generateFile(int type, List<T> contents) throws Exception {
		switch (type) {
		case FileGenerator.PATIENT_LIST:
			return generatePatientFile(contents);
		case FileGenerator.OFFICER_LIST:
			return generateOfficerFile(contents);
		default:
			return "";
		}

	}

	private String generatePatientFile(List<T> contents) throws Exception {
		InputStream inp = null;
		try {
			inp = new FileInputStream(
					SysconfigUtils.getPatientTemplateFileLocation());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("������Ϣģ���ļ���ʧ����֪ͨ����Ա��");
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inp);
		} catch (Exception e) {
			throw new Exception("Excel�ļ��쳣��");
		}
		CreationHelper createHelper = wb.getCreationHelper();
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				"yyyy-mm-dd"));
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;
		int rowIndex = 2;// �ӵ����п�ʼ��Խ��ǰ�������
		int columnIndex = 0;
		Patient p = null;
		if (null != contents) {
			for (T temp : contents) {
				p = (Patient) temp;
				row = sheet.createRow(rowIndex);
				// ���
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getId());
				// �������
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getCheckDate());
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAreaName());
				// �ֵ�
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getStreet());
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getNeighbourhood());
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getPatientName());
				// �Ա�
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getGender() == 0 ? "��" : "Ů");
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAge());
				// ҽ������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAssuranceType());
				// ��ϵ��ʽ
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getPhone());
				// ��Ѫѹ
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getHypertension() == 0 ? "��" : "��");
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getDiabetes() == 0 ? "��" : "��");
				// ���ಡ
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getCardiopathy() == 0 ? "��" : "��");
				// OD
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getOd());
				// os
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getOs());
				// ��������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getFirstAdvice());
				// �۲�����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getDiseaseType());
				// ��Ժ����
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getComeDate());
				// ��Ժ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getFormalAdvice());
				// ��֤ҽ��
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getMarketDoctor());
				// һ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getOneWeek());
				// �����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getHalfMonth());
				// ������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getTwoMonth());
				// ��Ժʱ��
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getCheckInDate());
				// ��Ժʱ��
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getCheckOutDate());
				// ����ҽ��
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getDoctor());
				// ��������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getSight());
				// ��������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getLens());
				// �س�
				columnIndex = 0;
				// ����
				rowIndex++;
			}
		}
		String fileName = "patient_list_"
				+ DateFormater.dateToString(new Date(),
						DateFormater.NARROW_LONG_FORMAT) + ".xlsx";
		FileOutputStream fileOut = null;
		String outLoc = SysconfigUtils.getTempDirLocation() + fileName;
		try {
			fileOut = new FileOutputStream(outLoc);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("��ʱ�޷������ļ������Ժ����ԡ�");
		}
		try {
			wb.write(fileOut);
			fileOut.close();
			inp.close();
		} catch (IOException e) {
			System.out.println("�ļ��ر�ʧ�ܡ�");
		}
		System.out.println("==========patient file list : " + outLoc);
		return fileName;
	}

	private String generateOfficerFile(List<T> contents) throws Exception {
		InputStream inp = null;
		try {
			inp = new FileInputStream(
					SysconfigUtils.getOfficerTemplateFileLocation());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("��ϵ����Ϣģ���ļ���ʧ����֪ͨ����Ա��");
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inp);
		} catch (Exception e) {
			throw new Exception("Excel�ļ��쳣��");
		}
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;
		int rowIndex = 2;// �ӵ����п�ʼ��Խ��ǰ�������
		int columnIndex = 0;
		Officer p = null;
		if (null != contents) {
			for (T temp : contents) {
				p = (Officer) temp;
				row = sheet.createRow(rowIndex);
				// ���
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getId());
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAreaName());
				// �ֵ�
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getStreet());
				// ��������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getChiefOfficerName());
				// ����
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getNeighbourhood());
				// ��ַ
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAddress());
				// ��ģ
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getScale());
				// ������
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAssitOfficerName());
				// ��ϵ��ʽ
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getPhone());
				// ��ע
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getComment());
				// �س�
				columnIndex = 0;
				// ����
				rowIndex++;
			}
		}
		String fileName = "officer_list_"
				+ DateFormater.dateToString(new Date(),
						DateFormater.NARROW_LONG_FORMAT) + ".xlsx";
		String outLoc = SysconfigUtils.getTempDirLocation() + fileName;
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(outLoc);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("��ʱ�޷������ļ������Ժ����ԡ�");
		}
		try {
			wb.write(fileOut);
			fileOut.close();
			inp.close();
		} catch (IOException e) {
			System.out.println("�ļ��ر�ʧ�ܡ�");
		}
		System.out.println("==========officer file list : " + outLoc);
		return fileName;
	}
}
