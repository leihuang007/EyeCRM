/**
 * 
 */
package cn.live.shinobi_hl.common.ui.pagebean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.bo.intf.AreaInfoBo;
import cn.live.shinobi_hl.common.po.AreaInfo;

/**
 * @author Huanglei
 * 
 */
public class AreaInfoBean {

	private static boolean reload = true;

	private static List<AreaInfo> list;

	private AreaInfoBo bo;

	private String parentAreaCode;
	/**
	 * 管理员的管理属地，格式为属地1,属地2,....属地n
	 */
	private String adminAreaCodes;

	private void reload() {
		if (reload || list == null || list.size() == 0) {
			list = bo.getAll();
		}
		reload = false;
	}

	public List<AreaInfo> getAll() {
		this.reload();
		return list;
	}

	public List<AreaInfo> getAllValidAreaInfo() {
		if (StringUtils.isBlank(adminAreaCodes)) {
			return null;
		} else {
			String[] codeArray = adminAreaCodes.split(",");
			this.reload();
			if (null != list && codeArray.length > 0) {
				List<AreaInfo> vl = new ArrayList<AreaInfo>(list.size());
				for (String tmpCode : codeArray) {
					for (AreaInfo ai : list) {
						if (ai.getAreaCode().startsWith(tmpCode)) {
							if (!vl.contains(ai)) {
								vl.add(ai);
							}
						}
					}
				}
				return vl;
			}
			return null;
		}
	}

	/**
	 * @return the reload
	 */
	public boolean isReload() {
		return reload;
	}

	/**
	 * @return the bo
	 */
	public AreaInfoBo getBo() {
		return bo;
	}

	/**
	 * @param bo
	 *            the bo to set
	 */
	public void setBo(AreaInfoBo bo) {
		this.bo = bo;
	}

	/**
	 * @return the parentAreaCode
	 */
	public String getParentAreaCode() {
		return parentAreaCode;
	}

	/**
	 * @param parentAreaCode
	 *            the parentAreaCode to set
	 */
	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}

	/**
	 * @return the adminAreaCodes
	 */
	public String getAdminAreaCodes() {
		return adminAreaCodes;
	}

	/**
	 * @param adminAreaCodes
	 *            the adminAreaCodes to set
	 */
	public void setAdminAreaCodes(String adminAreaCodes) {
		this.adminAreaCodes = adminAreaCodes;
	}

}
