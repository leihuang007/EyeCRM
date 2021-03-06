/**
 * 
 */
package cn.live.shinobi_hl.common.bo.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.DiseaseType;

/**
 * @author Huanglei
 * 
 */
public interface DiseaseTypeBo {

	/**
	 * 获取所有的眼病类型
	 * 
	 * @return
	 */
	List<DiseaseType> getAll();

}
