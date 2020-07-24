/**
 * 
 */
package cn.live.shinobi_hl.common.bo.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.AssuranceType;

/**
 * @author Huanglei
 * 
 */
public interface AssuranceTypeBo {

	/**
	 * 获取所有的医保类型
	 * 
	 * @return
	 */
	List<AssuranceType> getAll();
}
