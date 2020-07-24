/**
 * 
 */
package cn.live.shinobi_hl.common.ui.pagebean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.live.shinobi_hl.common.bo.intf.AssuranceTypeBo;
import cn.live.shinobi_hl.common.po.AssuranceType;

/**
 * @author Huanglei
 * 
 */
public class AssuranceTypeBean {

	private boolean reload = true;

	private List<AssuranceType> list;

	private Map<Integer, AssuranceType> map;

	private AssuranceTypeBo bo;

	private void reload() {
		if (reload) {
			list = bo.getAll();
			map = new HashMap<Integer, AssuranceType>();
			for (AssuranceType type : list) {
				map.put(type.getId(), type);
			}
		}
	}

	public List<AssuranceType> getAll() {
		this.reload();
		return list;
	}

	public String getAssuranceTypeNameById(int id) {
		this.reload();
		return map.get(Integer.valueOf(id)).getAssuranceName();
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
	public AssuranceTypeBo getBo() {
		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(AssuranceTypeBo bo) {
		this.bo = bo;
	}

}
