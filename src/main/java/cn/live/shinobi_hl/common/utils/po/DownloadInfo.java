package cn.live.shinobi_hl.common.utils.po;

import java.util.Map;

public class DownloadInfo {
	/**
	 * ��ʾ���ص����ͣ���action�����ļ���ָ��
	 */
	private String downLoadType;

	/**
	 * ������ļ������Լ� ����ʱ�Զ���ʾ���ļ���
	 */
	private String fileName;

	/**
	 * ��������
	 */
	private Map<String, String> conditions;

	/**
	 * @return the downLoadType
	 */
	public String getDownLoadType() {
		return downLoadType;
	}

	/**
	 * @param downLoadType
	 *            the downLoadType to set
	 */
	public void setDownLoadType(String downLoadType) {
		this.downLoadType = downLoadType;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the conditions
	 */
	public Map<String, String> getConditions() {
		return conditions;
	}

	/**
	 * @param conditions
	 *            the conditions to set
	 */
	public void setConditions(Map<String, String> conditions) {
		this.conditions = conditions;
	}

}
