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
	 * ��ȡȫ��������Ϣ
	 * 
	 * @return
	 */
	List<AreaInfo> getAll();

	/**
	 * ���ݸ����ر�Ż�ȡ�����أ����������أ�
	 * 
	 * @param parentAreaCode
	 * @return
	 */
	@Deprecated
	List<AreaInfo> getAll(String parentAreaCode);
}
