/**
 * 
 */
package cn.live.shinobi_hl.common.utils.po;

/**
 * @author Huanglei
 * 
 */
public class PageRow {

	/**
	 * 行的主键。
	 */
	private String id;
	/**
	 * 每一行的内容。
	 */
	private String[] cell;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the cell
	 */
	public String[] getCell() {
		return cell;
	}

	/**
	 * @param cell
	 *            the cell to set
	 */
	public void setCell(String[] cell) {
		this.cell = cell;
	}
}
