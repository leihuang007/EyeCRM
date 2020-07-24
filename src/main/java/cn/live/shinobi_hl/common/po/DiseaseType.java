/**
 * 
 */
package cn.live.shinobi_hl.common.po;

/**
 * @author Huanglei
 * 
 */
public class DiseaseType {

	/**
	 * 编号
	 */
	private int id;
	/**
	 * 医保名称
	 */
	private String diseaseTypeName;
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
	 * @return the diseaseTypeName
	 */
	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	/**
	 * @param diseaseTypeName
	 *            the diseaseTypeName to set
	 */
	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
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
