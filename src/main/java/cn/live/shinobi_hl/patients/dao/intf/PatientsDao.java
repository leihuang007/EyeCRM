/**
 * 
 */
package cn.live.shinobi_hl.patients.dao.intf;

import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public interface PatientsDao {

	/**
	 * ����Patient����
	 * 
	 * @param patient
	 */
	void save(Patient patient);

	/**
	 * ��ȡ��ҳ�����
	 * 
	 * @param pageInfo
	 */
	void getPage(PageInfo<Patient> pageInfo);

	/**
	 * ���ݲ��˵�idɾ�����ˡ�<br>
	 * ��������ɾ�������ǽ�������Ϣ��status�ֶ�����Ϊ1.
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * ͨ�� ��Ż�ȡ������Ϣ��
	 * 
	 * @param id
	 * @return
	 */
	Patient getById(int id);

	/**
	 * ���²�����Ϣ
	 * 
	 * @param p
	 */
	void update(Patient p);
}
