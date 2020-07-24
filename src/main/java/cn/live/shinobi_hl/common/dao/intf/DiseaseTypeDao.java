/**
 * 
 */
package cn.live.shinobi_hl.common.dao.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.DiseaseType;

/**
 * @author Huanglei
 * 
 */
public interface DiseaseTypeDao {
	/**
	 * 获取所有的眼病类型
	 * 
	 * @return
	 */
	List<DiseaseType> getAll();
}
