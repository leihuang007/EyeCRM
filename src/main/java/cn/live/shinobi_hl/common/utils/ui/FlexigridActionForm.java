/**
 * 
 */
package cn.live.shinobi_hl.common.utils.ui;

import java.util.List;

import cn.live.shinobi_hl.common.utils.po.PageRow;

/**
 * @author Huanglei
 * 
 */
public class FlexigridActionForm extends AbsBaseActionForm {

	/**
	 * ��¼������
	 */
	private long total;
	/**
	 * ��ǰҳ
	 */
	private int page;
	/**
	 * ÿҳ��¼��
	 */
	private int rp;
	/**
	 * �����ֶ�ֵ
	 */
	private String query;
	/**
	 * �����ֶ�
	 */
	private String qtype;
	/**
	 * �����ֶ�
	 */
	private String sortname;
	/**
	 * ����ʽ��desc����asc
	 */
	private String sortorder;
	/**
	 * ��������
	 */
	private String qop;
	/**
	 * ��ѯ���ƣ������˴β�ѯ�ǲ鲡�˻��ǲ���ϵ�ˣ����������
	 */
	private String queryName;
	/**
	 * ���е��С�
	 */
	private List<PageRow> rows;

	/**
	 * @return the rows
	 */
	public List<PageRow> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<PageRow> rows) {
		this.rows = rows;
	}

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the rp
	 */
	public int getRp() {
		return rp;
	}

	/**
	 * @param rp
	 *            the rp to set
	 */
	public void setRp(int rp) {
		this.rp = rp;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the qtype
	 */
	public String getQtype() {
		return qtype;
	}

	/**
	 * @param qtype
	 *            the qtype to set
	 */
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	/**
	 * @return the sortname
	 */
	public String getSortname() {
		return sortname;
	}

	/**
	 * @param sortname
	 *            the sortname to set
	 */
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	/**
	 * @return the sortorder
	 */
	public String getSortorder() {
		return sortorder;
	}

	/**
	 * @param sortorder
	 *            the sortorder to set
	 */
	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	/**
	 * @return the qop
	 */
	public String getQop() {
		return qop;
	}

	/**
	 * @param qop
	 *            the qop to set
	 */
	public void setQop(String qop) {
		this.qop = qop;
	}

	/**
	 * @return the queryName
	 */
	public String getQueryName() {
		return queryName;
	}

	/**
	 * @param queryName
	 *            the queryName to set
	 */
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

}
