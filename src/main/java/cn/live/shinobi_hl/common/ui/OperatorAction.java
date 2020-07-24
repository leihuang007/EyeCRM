/**
 * 
 */
package cn.live.shinobi_hl.common.ui;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.live.shinobi_hl.common.bo.intf.OperatorBo;
import cn.live.shinobi_hl.common.po.Operator;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.ui.AbsBaseAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Huanglei
 * 
 */
public class OperatorAction extends AbsBaseAction<OperatorActionForm> {

	private final OperatorActionForm model = new OperatorActionForm();

	private OperatorBo operatorBo;

	/**
	 * @return the operatorBo
	 */
	public OperatorBo getOperatorBo() {
		return operatorBo;
	}

	/**
	 * @param operatorBo
	 *            the operatorBo to set
	 */
	public void setOperatorBo(OperatorBo operatorBo) {
		this.operatorBo = operatorBo;
	}

	@Override
	public OperatorActionForm getModel() {
		return model;
	}

	/**
	 * �����½�¼���
	 * 
	 * @return
	 */
	public String login() {
		if (null != model) {
			Operator op = new Operator();
			try {
				BeanUtils.copyProperties(op, model);
			} catch (Exception e) {
				FunctionResult fr = new FunctionResult();
				fr.setMessage("��½����ģ����ϣ�����ϵ����Ա��");
				fr.setOk(false);
				fr.setCodeNo(FunctionResult.TIP);
				model.setFuncResult(fr);
				return SUCCESS;
			}
			Operator admin = operatorBo.getOperatorByNameAndPass(op);
			if (null == admin) {
				operatorBo.getResult().setOk(false);
				operatorBo.getResult().setMessage("�û���/�������");
				operatorBo.getResult().setCodeNo(FunctionResult.TIP);
				model.setFuncResult(operatorBo.getResult());
			} else {
				operatorBo.getResult().setOk(true);
				operatorBo.getResult().setMessage("/main.jsp");
				operatorBo.getResult().setCodeNo(FunctionResult.REDIRECT);
				model.setFuncResult(operatorBo.getResult());
				// ����session
				ActionContext context = ActionContext.getContext();
				Map<String, Object> session = context.getSession();
				session.put("admin", admin);
			}
		}
		return SUCCESS;
	}

	/**
	 * ����ǳ��¼�
	 * 
	 * @return
	 */
	public String logout() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		session.remove("admin");
		FunctionResult result = new FunctionResult();
		model.setFuncResult(result);
		if (null != result) {
			result.setCodeNo(FunctionResult.REDIRECT);
			result.setMessage("/index.jsp");
			result.setOk(true);
		}
		return SUCCESS;
	}

}
