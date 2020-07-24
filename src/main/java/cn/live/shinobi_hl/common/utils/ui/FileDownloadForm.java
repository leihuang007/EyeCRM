/**
 * 
 */
package cn.live.shinobi_hl.common.utils.ui;

/**
 * @author Huanglei
 * 
 */
public class FileDownloadForm extends AbsBaseActionForm {

	/**
	 * 表示下载的类型，由action配置文件中指定
	 */
	private String downLoadType;

	/**
	 * 请求的文件名，以及 下载时自动显示的文件名
	 */
	private String fileName;

	/**
	 * 由前台传送过来的查询条件，格式为name=value[&name=value] <br>
	 * 中文为加密格式。
	 */
	private String queryInfo;

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
	 * @return the queryInfo
	 */
	public String getQueryInfo() {
		return queryInfo;
	}

	/**
	 * @param queryInfo
	 *            the queryInfo to set
	 */
	public void setQueryInfo(String queryInfo) {
		this.queryInfo = queryInfo;
	}

}
