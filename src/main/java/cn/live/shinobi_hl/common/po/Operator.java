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
	 * ����Ա���
	 */
	private int id;
	/**
	 * ����Ա�û���
	 */
	private String userName;
	/**
	 * ����Ա����ʵ����
	 */
	private String realName;
	/**
	 * ����Ա����
	 */
	private String password;
	/**
	 * ����Ա���͡�0Ϊ��ͨ����Ա��1Ϊ����Ա
	 */
	private int type;
	/**
	 * ����Ա�Ĺ�������
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
