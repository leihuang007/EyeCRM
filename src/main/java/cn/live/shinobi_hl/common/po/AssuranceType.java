/**
 * 
 */
package cn.live.shinobi_hl.common.po;


/**
 * @author Huanglei
 * 
 */
public class AssuranceType {

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 医保名称
	 */
	private String assuranceName;
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the assuranceName
	 */
	public String getAssuranceName() {
		return assuranceName;
	}
	/**
	 * @param assuranceName the assuranceName to set
	 */
	public void setAssuranceName(String assuranceName) {
		this.assuranceName = assuranceName;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}
