/**
 * 
 */
package cn.live.shinobi_hl.common.po;

/**
 * @author Huanglei
 * 
 */
public class FirstAdvice {

	/**
	 * ���
	 */
	private int id;
	/**
	 * �������ƽ�������
	 */
	private String firstAdvice;
	/**
	 * ״̬��0������1ɾ����
	 */
	private int status;

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
	 * @return the firstAdvice
	 */
	public String getFirstAdvice() {
		return firstAdvice;
	}

	/**
	 * @param firstAdvice
	 *            the firstAdvice to set
	 */
	public void setFirstAdvice(String firstAdvice) {
		this.firstAdvice = firstAdvice;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}
