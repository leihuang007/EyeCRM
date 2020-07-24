/**
 * 
 */
package cn.live.shinobi_hl.common.bo.intf;

import cn.live.shinobi_hl.common.po.Operator;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;

/**
 * @author Huanglei
 * 
 */
public interface OperatorBo {

	/**
	 * 获取执行结果信息
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * 新建
	 * 
	 * @param op
	 */
	void save(Operator op);

	/**
	 * 根据用户名和密码获取操作员。
	 * 
	 * @param pass
	 * @return
	 */
	Operator getOperatorByNameAndPass(Operator op);
}
