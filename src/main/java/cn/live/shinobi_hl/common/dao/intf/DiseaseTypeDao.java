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
	 * ��ȡ���е��۲�����
	 * 
	 * @return
	 */
	List<DiseaseType> getAll();
}
