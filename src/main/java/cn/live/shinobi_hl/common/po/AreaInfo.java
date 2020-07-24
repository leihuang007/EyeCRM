/**
 * 
 */
package cn.live.shinobi_hl.common.po;


/**
 * @author Huanglei
 * 
 */
public class AreaInfo {

	/**
	 * ÊôµØ±àºÅ
	 */
	private String areaCode;
	/**
	 * ¸¸ÊôµØ±àºÅ
	 */
	private String parentAreaCode;
	/**
	 * ÊôµØÃû³Æ
	 */
	private String areaName;
	/**
	 * ×´Ì¬¡£0Õý³££¬1É¾³ý¡£
	 */
	private int status;
	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * @return the parentAreaCode
	 */
	public String getParentAreaCode() {
		return parentAreaCode;
	}
	/**
	 * @param parentAreaCode the parentAreaCode to set
	 */
	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}
	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
