/**
 * 
 */
package cn.live.shinobi_hl.common.ui;

import cn.live.shinobi_hl.common.utils.ui.AbsBaseActionForm;

/**
 * @author Huanglei
 * 
 */
public class OperatorActionForm extends AbsBaseActionForm {
	/**
	 * ����Ա�û���
	 */
	private String userName;
	/**
	 * ����Ա����
	 */
	private String password;
	/**
	 * ����Ա���͡�0Ϊ��ͨ����Ա��1Ϊ����Ա
	 */
	private int type;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

}
