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
	 * ���
	 */
	private int id;
	/**
	 * ҽ������
	 */
	private String diseaseTypeName;
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
