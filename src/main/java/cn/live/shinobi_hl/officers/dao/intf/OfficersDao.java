/**
 * 
 */
package cn.live.shinobi_hl.officers.dao.intf;

import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.officers.po.Officer;

/**
 * @author Huanglei
 * 
 */
public interface OfficersDao {

	/**
	 * ����Officer����
	 * 
	 * @param patient
	 */
	void save(Officer officer);

	/**
	 * ��ȡ��ҳ�����
	 * 
	 * @param pageInfo
	 */
	void getPage(PageInfo<Officer> pageInfo);

	/**
	 * ������ϵ�˵�idɾ����ϵ�ˡ�<br>
	 * ��������ɾ�������ǽ���ϵ����Ϣ��status�ֶ�����Ϊ1.
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * ͨ�� ��Ż�ȡ��ϵ����Ϣ��
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
