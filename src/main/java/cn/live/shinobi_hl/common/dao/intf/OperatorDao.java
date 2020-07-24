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
	 * 添加操作员
	 * 
	 * @param operator
	 */
	void save(Operator operator);

	/**
	 * 获取所有操作员
	 * 
	 * @return
	 */
	List<Operator> getAll();

	/**
	 * 根据用户名和密码获取操作员。
	 * 
	 * @param userName
	 * @param pass
	 * @return
	 */
	Operator getOperatorByNameAndPass(String userName, String pass);
}
