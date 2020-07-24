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
	 * 操作员用户名
	 */
	private String userName;
	/**
	 * 操作员密码
	 */
	private String password;
	/**
	 * 操作员类型。0为普通操作员；1为管理员
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
