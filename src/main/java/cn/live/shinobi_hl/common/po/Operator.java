/**
 * 
 */
package cn.live.shinobi_hl.common.po;

/**
 * @author Huanglei
 * 
 */
public class Operator {
	/**
	 * 操作员编号
	 */
	private int id;
	/**
	 * 操作员用户名
	 */
	private String userName;
	/**
	 * 操作员的真实姓名
	 */
	private String realName;
	/**
	 * 操作员密码
	 */
	private String password;
	/**
	 * 操作员类型。0为普通操作员；1为管理员
	 */
	private int type;
	/**
	 * 操作员的管理属地
	 */
	private String areaNo;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName
	 *            the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the areaNo
	 */
	public String getAreaNo() {
		return areaNo;
	}

	/**
	 * @param areaNo
	 *            the areaNo to set
	 */
	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

}
