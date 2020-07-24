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
	 * ��ȡ���е�����
	 * 
	 * @return
	 */
	List<AreaInfo> getAll();

	/**
	 * ���ݸ����ػ�ȡ�����أ����������أ�
	 * 
	 * @param parentAreaCode
	 * @return
	 */
	List<AreaInfo> getAll(String parentAreaCode);

}
