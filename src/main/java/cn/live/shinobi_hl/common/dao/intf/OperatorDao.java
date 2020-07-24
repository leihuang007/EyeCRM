/**
 * 
 */
package cn.live.shinobi_hl.common.dao.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.Operator;

/**
 * @author Huanglei
 * 
 */
public interface OperatorDao {

	/**
	 * ��Ӳ���Ա
	 * 
	 * @param operator
	 */
	void save(Operator operator);

	/**
	 * ��ȡ���в���Ա
	 * 
	 * @return
	 */
	List<Operator> getAll();

	/**
	 * �����û����������ȡ����Ա��
	 * 
	 * @param userName
	 * @param pass
	 * @return
	 */
	Operator getOperatorByNameAndPass(String userName, String pass);
}
