/**
 * 
 */
package cn.live.shinobi_hl.common.ui.pagebean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.live.shinobi_hl.common.bo.intf.DiseaseTypeBo;
import cn.live.shinobi_hl.common.po.DiseaseType;

/**
 * @author Huanglei
 * 
 */
public class DiseaseTypeBean {

	private boolean reload = true;

	private List<DiseaseType> list;

	private Map<Integer, DiseaseType> map;

	private DiseaseTypeBo bo;

	private void reload() {
		if (reload) {
			list = bo.getAll();
			map = new HashMap<Integer, DiseaseType>();
			for (DiseaseType type : list) {
				map.put(type.getId(), type);
			}
		}
	}

	public List<DiseaseType> getAll() {
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
	public DiseaseTypeBo getBo() {
		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(DiseaseTypeBo bo) {
		this.bo = bo;
	}

}
