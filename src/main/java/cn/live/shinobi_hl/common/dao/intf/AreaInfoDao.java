/**
 * 
 */
package cn.live.shinobi_hl.common.dao.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.AreaInfo;

/**
 * @author Huanglei
 * 
 */
public interface AreaInfoDao {
	/**
	 * 获取所有的属地
	 * 
	 * @return
	 */
	List<AreaInfo> getAll();

	/**
	 * 根据父属地获取子属地（包括父属地）
	 * 
	 * @param parentAreaCode
	 * @return
	 */
	List<AreaInfo> getAll(String parentAreaCode);

}
