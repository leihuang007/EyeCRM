/**
 * 
 */
package cn.live.shinobi_hl.officers.po;

/**
 * @author Huanglei
 * 
 */
public class Officer {

	private int id;
	private String areaNo;
	private String areaName;
	private String street;
	private String chiefOfficerName;
	private String neighbourhood;
	private String address;
	private String scale;
	private String assitOfficerName;
	private String phone;
	private int status;
	/**
	 * ±¸×¢
	 */
	private String comment;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(200);
		sb.append(id).append("|&|");
		sb.append(areaName).append("|&|");
		sb.append(street).append("|&|");
		sb.append(chiefOfficerName).append("|&|");
		sb.append(neighbourhood).append("|&|");
		sb.append(address).append("|&|");
		sb.append(scale).append("|&|");
		sb.append(assitOfficerName).append("|&|");
		sb.append(phone).append("|&|");
		sb.append(comment);

		return sb.toString();
	}

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
	 * @return the areaName
	 */
	public String getAreaNo() {
		return areaNo;
	}

	/**
	 * @param areaName
	 *            the areaName to set
	 */
	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName
	 *            the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the chiefOfficerName
	 */
	public String getChiefOfficerName() {
		return chiefOfficerName;
	}

	/**
	 * @param chiefOfficerName
	 *            the chiefOfficerName to set
	 */
	public void setChiefOfficerName(String chiefOfficerName) {
		this.chiefOfficerName = chiefOfficerName;
	}

	/**
	 * @return the neighbourhood
	 */
	public String getNeighbourhood() {
		return neighbourhood;
	}

	/**
	 * @param neighbourhood
	 *            the neighbourhood to set
	 */
	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the scale
	 */
	public String getScale() {
		return scale;
	}

	/**
	 * @param scale
	 *            the scale to set
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}

	/**
	 * @return the assitOfficerName
	 */
	public String getAssitOfficerName() {
		return assitOfficerName;
	}

	/**
	 * @param assitOfficerName
	 *            the assitOfficerName to set
	 */
	public void setAssitOfficerName(String assitOfficerName) {
		this.assitOfficerName = assitOfficerName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
