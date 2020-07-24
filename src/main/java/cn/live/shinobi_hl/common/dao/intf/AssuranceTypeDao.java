/**
 * 
 */
package cn.live.shinobi_hl.common.dao.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.AssuranceType;

/**
 * @author Huanglei
 * 
 */
public interface AssuranceTypeDao {
	/**
	 * 获取所有的医保类型
	 * 
	 * @return
	 */
	List<AssuranceType> getAll();
}
