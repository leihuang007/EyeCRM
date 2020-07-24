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
	 * ��ȡ��Դ�ĸ�Ŀ¼<br>
	 * ע�⣬����ĩβ�Ѿ����С�/������
	 * 
	 * @return
	 */
	public static String getResourceRootDirLocation() {
		String dir = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		return dir;
	}

	/**
	 * ��ȡ��ʱ�ļ��ı���λ��Ŀ¼��<br>
	 * ע�⣬����ĩβ�Ѿ����С�/������
	 * 
	 * @return
	 */
	public static String getTempDirLocation() {
		return getResourceRootDirLocation() + "temp/";
	}

	/**
	 * ��ȡģ��Ŀ¼λ��<br>
	 * ע�⣬����ĩβ�Ѿ����С�/������
	 * 
	 * @return
	 */
	public static String getTemplateDirLocation() {
		return getResourceRootDirLocation() + "templates/";
	}

	/**
	 * ��ȡ����ģ���ļ�λ��<br>
	 * ע�⣬����ĩβ�Ѿ����С�/������
	 * 
	 * @return
	 */
	public static String getPatientTemplateFileLocation() {
		return getTemplateDirLocation() + "patient_template.xlsx";
	}

	/**
	 * ��ȡ��ϵ��ģ���ļ�λ��<br>
	 * ע�⣬����ĩβ�Ѿ����С�/������
	 * 
	 * @return
	 */
	public static String getOfficerTemplateFileLocation() {
		return getTemplateDirLocation() + "officer_template.xlsx";
	}
}
