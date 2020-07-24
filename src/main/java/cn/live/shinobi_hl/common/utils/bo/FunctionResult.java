/**
 * 
 */
package cn.live.shinobi_hl.common.utils.bo;

/**
 * @author Huanglei
 * 
 */
public class FunctionResult {

	/**
	 * ��̬���������ڱ���codeNo�����á�
	 */
	public static final String REDIRECT = "redirect";// ��ת��messageָ����ҳ�档
	public static final String CALLBACK = "callback";// ����messageָ���ķ�����
	public static final String TIP = "tip";// ��ʾ��Ϣ����Ϣ����Ϊmessage

	/**
	 * �Ƿ�ͨ��
	 */
	private boolean isOk;
	/**
	 * ����
	 */
	private String codeNo;

	/**
	 * ִ�н���ĵ�����Ϣ��
	 */
	private String message;

	/**
	 * @return the isOk
	 */
	public boolean isOk() {
		return isOk;
	}

	/**
	 * @param isOk
	 *            the isOk to set
	 */
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	/**
	 * @return the codeNo
	 */
	public String getCodeNo() {
		return codeNo;
	}

	/**
	 * @param codeNo
	 *            the codeNo to set
	 */
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
