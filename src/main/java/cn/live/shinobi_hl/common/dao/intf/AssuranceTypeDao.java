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
	 * ��ȡ���е�ҽ������
	 * 
	 * @return
	 */
	List<AssuranceType> getAll();
}
