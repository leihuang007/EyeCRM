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
	 * ��ʾ���ص����ͣ���action�����ļ���ָ��
	 */
	private String downLoadType;

	/**
	 * ������ļ������Լ� ����ʱ�Զ���ʾ���ļ���
	 */
	private String fileName;

	/**
	 * ��ǰ̨���͹����Ĳ�ѯ��������ʽΪname=value[&name=value] <br>
	 * ����Ϊ���ܸ�ʽ��
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
