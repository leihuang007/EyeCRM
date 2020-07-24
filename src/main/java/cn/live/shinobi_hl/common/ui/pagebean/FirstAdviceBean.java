/**
 * 
 */
package cn.live.shinobi_hl.common.ui.pagebean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.live.shinobi_hl.common.bo.intf.FirstAdviceBo;
import cn.live.shinobi_hl.common.po.FirstAdvice;

/**
 * @author Huanglei
 * 
 */
public class FirstAdviceBean {

	private boolean reload = true;

	private List<FirstAdvice> list;

	private Map<Integer, FirstAdvice> map;

	private FirstAdviceBo bo;

	private void reload() {
		if (reload) {
			list = bo.getAll();
			map = new HashMap<Integer, FirstAdvice>();
			for (FirstAdvice type : list) {
				map.put(type.getId(), type);
			}
		}
	}

	public List<FirstAdvice> getAll() {
		this.reload();
		return list;
	}

	/**
	 * @return the reload
	 */
	public boolean isReload() {
		return reload;
	}

	/**
	 * @param reload
	 *            the reload to set
	 */
	public void setReload(boolean reload) {
		this.reload = reload;
	}

	/**
	 * @return the bo
	 */
	public FirstAdviceBo getBo() {
		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(FirstAdviceBo bo) {
		this.bo = bo;
	}

}
