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
	 * ���
	 */
	private int id;
	/**
	 * ҽ������
	 */
	private String assuranceName;
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
