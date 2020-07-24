package cn.live.shinobi_hl.common.utils.po;

import java.util.Map;

public class DownloadInfo {
	/**
	 * 表示下载的类型，由action配置文件中指定
	 */
	private String downLoadType;

	/**
	 * 请求的文件名，以及 下载时自动显示的文件名
	 */
	private String fileName;

	/**
	 * 过滤条件
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
