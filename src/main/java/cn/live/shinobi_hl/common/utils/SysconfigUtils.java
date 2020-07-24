/**
 * 
 */
package cn.live.shinobi_hl.common.utils;

/**
 * @author Huanglei
 * 
 */
public class SysconfigUtils {

	/**
	 * 获取资源的根目录<br>
	 * 注意，其结果末尾已经带有“/”符号
	 * 
	 * @return
	 */
	public static String getResourceRootDirLocation() {
		String dir = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		return dir;
	}

	/**
	 * 获取临时文件的保存位置目录。<br>
	 * 注意，其结果末尾已经带有“/”符号
	 * 
	 * @return
	 */
	public static String getTempDirLocation() {
		return getResourceRootDirLocation() + "temp/";
	}

	/**
	 * 获取模版目录位置<br>
	 * 注意，其结果末尾已经带有“/”符号
	 * 
	 * @return
	 */
	public static String getTemplateDirLocation() {
		return getResourceRootDirLocation() + "templates/";
	}

	/**
	 * 获取患者模版文件位置<br>
	 * 注意，其结果末尾已经带有“/”符号
	 * 
	 * @return
	 */
	public static String getPatientTemplateFileLocation() {
		return getTemplateDirLocation() + "patient_template.xlsx";
	}

	/**
	 * 获取联系人模版文件位置<br>
	 * 注意，其结果末尾已经带有“/”符号
	 * 
	 * @return
	 */
	public static String getOfficerTemplateFileLocation() {
		return getTemplateDirLocation() + "officer_template.xlsx";
	}
}
