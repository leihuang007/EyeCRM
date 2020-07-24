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
	 * 编号
	 */
	private int id;
	/**
	 * 初步治疗建议内容
	 */
	private String firstAdvice;
	/**
	 * 状态。0正常，1删除。
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
