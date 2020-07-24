/**
 * 
 */
package cn.live.shinobi_hl.common.bo.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.AreaInfo;

/**
 * @author Huanglei
 * 
 */
public interface AreaInfoBo {
	/**
	 * 获取全部属地信息
	 * 
	 * @return
	 */
	List<AreaInfo> getAll();

	/**
	 * 根据父属地编号获取子属地（包括父属地）
	 * 
	 * @param parentAreaCode
	 * @return
	 */
	@Deprecated
	List<AreaInfo> getAll(String parentAreaCode);
}
