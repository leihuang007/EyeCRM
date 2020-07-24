package cn.live.shinobi_hl.officers.bo.intf;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.officers.po.Officer;

public interface OfficerBo {

	/**
	 * ��ȡִ�н����Ϣ
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * ����Officer����
	 * 
	 * @param officer
	 */
	void save(Officer officer);

	/**
	 * ����ɾ��������Ϣ
	 * 
	 * @param ids
	 */
	void batchDelete(String[] ids);

	/**
	 * ������ϵ�˱�Ż�ȡ��ϵ����Ϣ
	 * 
	 * @param id
	 * @return
	 */
	Officer getById(int id);

	/**
	 * ������ϵ����Ϣ
	 * 
	 * @param p
	 */
	void update(Officer o);
}
