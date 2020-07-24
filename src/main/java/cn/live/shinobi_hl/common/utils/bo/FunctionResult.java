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
	 * 静态变量，用于表明codeNo的作用。
	 */
	public static final String REDIRECT = "redirect";// 跳转到message指明的页面。
	public static final String CALLBACK = "callback";// 调用message指明的方法。
	public static final String TIP = "tip";// 提示信息，信息内容为message

	/**
	 * 是否通过
	 */
	private boolean isOk;
	/**
	 * 代码
	 */
	private String codeNo;

	/**
	 * 执行结果的调试信息。
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
