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
			throw new FileNotFoundException("患者信息模版文件丢失，请通知管理员。");
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inp);
		} catch (Exception e) {
			throw new Exception("Excel文件异常。");
		}
		CreationHelper createHelper = wb.getCreationHelper();
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				"yyyy-mm-dd"));
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;
		int rowIndex = 2;// 从第三行开始，越过前面的内容
		int columnIndex = 0;
		Patient p = null;
		if (null != contents) {
			for (T temp : contents) {
				p = (Patient) temp;
				row = sheet.createRow(rowIndex);
				// 编号
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getId());
				// 检查日期
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getCheckDate());
				// 区属
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAreaName());
				// 街道
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getStreet());
				// 社区
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getNeighbourhood());
				// 姓名
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getPatientName());
				// 性别
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getGender() == 0 ? "男" : "女");
				// 年龄
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAge());
				// 医保类型
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAssuranceType());
				// 联系方式
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getPhone());
				// 高血压
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getHypertension() == 0 ? "无" : "有");
				// 糖尿病
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getDiabetes() == 0 ? "无" : "有");
				// 心脏病
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getCardiopathy() == 0 ? "无" : "有");
				// OD
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getOd());
				// os
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getOs());
				// 初步建议
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getFirstAdvice());
				// 眼病类型
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getDiseaseType());
				// 来院日期
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getComeDate());
				// 来院建议
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getFormalAdvice());
				// 开证医生
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getMarketDoctor());
				// 一星期
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getOneWeek());
				// 半个月
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getHalfMonth());
				// 两个月
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getTwoMonth());
				// 入院时间
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getCheckInDate());
				// 出院时间
				cell = row.createCell(columnIndex++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(p.getCheckOutDate());
				// 手术医生
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getDoctor());
				// 术后视力
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getSight());
				// 晶体类型
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getLens());
				// 回车
				columnIndex = 0;
				// 换行
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
			throw new FileNotFoundException("暂时无法下载文件，请稍候重试。");
		}
		try {
			wb.write(fileOut);
			fileOut.close();
			inp.close();
		} catch (IOException e) {
			System.out.println("文件关闭失败。");
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
			throw new FileNotFoundException("联系人信息模版文件丢失，请通知管理员。");
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(inp);
		} catch (Exception e) {
			throw new Exception("Excel文件异常。");
		}
		Sheet sheet = wb.getSheetAt(0);
		Row row = null;
		Cell cell = null;
		int rowIndex = 2;// 从第三行开始，越过前面的内容
		int columnIndex = 0;
		Officer p = null;
		if (null != contents) {
			for (T temp : contents) {
				p = (Officer) temp;
				row = sheet.createRow(rowIndex);
				// 编号
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getId());
				// 区属
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAreaName());
				// 街道
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getStreet());
				// 主负责人
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getChiefOfficerName());
				// 社区
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getNeighbourhood());
				// 地址
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAddress());
				// 规模
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getScale());
				// 负责人
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getAssitOfficerName());
				// 联系方式
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getPhone());
				// 备注
				cell = row.createCell(columnIndex++);
				cell.setCellValue(p.getComment());
				// 回车
				columnIndex = 0;
				// 换行
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
			throw new FileNotFoundException("暂时无法下载文件，请稍候重试。");
		}
		try {
			wb.write(fileOut);
			fileOut.close();
			inp.close();
		} catch (IOException e) {
			System.out.println("文件关闭失败。");
		}
		System.out.println("==========officer file list : " + outLoc);
		return fileName;
	}
}
