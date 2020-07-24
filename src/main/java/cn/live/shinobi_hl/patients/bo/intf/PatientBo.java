/**
 * 
 */
package cn.live.shinobi_hl.patients.bo.intf;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public interface PatientBo {

	/**
	 * ��ȡִ�н����Ϣ
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * ����Patient����
	 * 
	 * @param patient
	 */
	void save(Patient patient);

	/**
	 * ����ɾ��������Ϣ
	 * 
	 * @param ids
	 */
	void batchDelete(String[] ids);

	/**
	 * ���ݲ��˱�Ż�ȡ������Ϣ
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
