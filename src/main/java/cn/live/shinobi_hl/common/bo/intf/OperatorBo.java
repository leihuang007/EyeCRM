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
	 * ��ȡִ�н����Ϣ
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * �½�
	 * 
	 * @param op
	 */
	void save(Operator op);

	/**
	 * �����û����������ȡ����Ա��
	 * 
	 * @param pass
	 * @return
	 */
	Operator getOperatorByNameAndPass(Operator op);
}
