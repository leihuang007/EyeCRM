/**
 * 
 */
package cn.live.shinobi_hl.common.utils.po;

import java.util.List;
import java.util.Map;

/**
 * @author Huanglei
 * 
 */
public class PageInfo<T extends Object> {

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
	 * ��ʼλ��
	 */
	private int startPos;
	/**
	 * ��ѯ����
	 */
	private Map<String, String> conditions;
	/**
	 * �����ֶ�
	 */
	private String sortname;
	/**
	 * ����ʽ��desc����asc
	 */
	private String sortorder;
	/**
	 * ��ѯ���������ݡ�
	 */
	private List<T> resultList;
	/**
	 * ��ѯ��䡣
	 */
	private String hqlSearch;

	/**
	 * ��ѯ�������
	 */
	private String hqlTotal;

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
	 * @return the conditions
	 */
	public Map<String, String> getConditions() {
		return conditions;
	}

	/**
	 * @param conditions
	 *            the conditions to set
	 */
	public void setConditions(Map<String, String> conditions) {
		this.conditions = conditions;
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
	 * @return the resultList
	 */
	public List<T> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            the resultList to set
	 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the hqlSearch
	 */
	public String getHqlSearch() {
		return hqlSearch;
	}

	/**
	 * @param hqlSearch
	 *            the hqlSearch to set
	 */
	public void setHqlSearch(String hqlSearch) {
		this.hqlSearch = hqlSearch;
	}

	/**
	 * @return the hqlTotal
	 */
	public String getHqlTotal() {
		return hqlTotal;
	}

	/**
	 * @param hqlTotal
	 *            the hqlTotal to set
	 */
	public void setHqlTotal(String hqlTotal) {
		this.hqlTotal = hqlTotal;
	}

	/**
	 * @return the startPos
	 */
	public int getStartPos() {
		return startPos;
	}

	/**
	 * @param startPos
	 *            the startPos to set
	 */
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
}
