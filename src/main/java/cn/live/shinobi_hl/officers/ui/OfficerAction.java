/**
 * 
 */
package cn.live.shinobi_hl.officers.ui;

import org.apache.commons.beanutils.BeanUtils;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.ui.AbsBaseAction;
import cn.live.shinobi_hl.officers.bo.intf.OfficerBo;
import cn.live.shinobi_hl.officers.po.Officer;

/**
 * @author Huanglei
 * 
 */
public class OfficerAction extends AbsBaseAction<OfficerActionForm> {

	private final OfficerActionForm model = new OfficerActionForm();

	private OfficerBo officerBo;

	/**
	 * @return the officerBo
	 */
	public OfficerBo getOfficerBo() {
		return officerBo;
	}

	/**
	 * @param officerBo
	 *            the officerBo to set
	 */
	public void setOfficerBo(OfficerBo officerBo) {
		this.officerBo = officerBo;
	}

	@Override
	public OfficerActionForm getModel() {
		return model;
	}

	/**
	 * ���������ϵ��������
	 * 
	 * @return
	 */
	public String add() {
		Officer officer = new Officer();
		try {
			BeanUtils.copyProperties(officer, model);
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			fr.setMessage("OFFICER���Ƶ�Ԫ�����쳣������ϵ����Ա��");
			model.setFuncResult(fr);
			return SUCCESS;
		}
		officerBo.save(officer);
		model.setFuncResult(officerBo.getResult());
		return SUCCESS;
	}

	/**
	 * ɾ����ϵ����Ϣ
	 * 
	 * @return
	 */
	public String del() {
		try {
			String strIds = model.getIds();
			String[] ids = strIds.split(",");
			this.officerBo.batchDelete(ids);
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			fr.setMessage("ɾ��OFFICER���Ƶ�Ԫ�����쳣������ϵ����Ա��");
			model.setFuncResult(fr);
			return SUCCESS;
		}
		model.setFuncResult(this.officerBo.getResult());
		return SUCCESS;
	}

	public String preUpdate() {
		int id = model.getId();
		Officer o = this.officerBo.getById(id);
		if (this.officerBo.getResult().isOk()) {
			try {
				BeanUtils.copyProperties(model, o);
			} catch (Exception e) {
				FunctionResult fr = new FunctionResult();
				fr.setOk(false);
				fr.setCodeNo(FunctionResult.TIP);
				fr.setMessage("�޸�OFFICER���Ƶ�Ԫ�����쳣������ϵ����Ա��");
				model.setFuncResult(fr);
				return ERROR;
			}
			return SUCCESS;
		} else {
			model.setFuncResult(this.officerBo.getResult());
			return ERROR;
		}
	}

	public String update() {
		Officer o = new Officer();
		try {
			BeanUtils.copyProperties(o, model);
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			fr.setMessage("�޸�OFFICER���Ƶ�Ԫ�����쳣������ϵ����Ա��");
			model.setFuncResult(fr);
			return SUCCESS;
		}
		officerBo.update(o);
		model.setFuncResult(officerBo.getResult());
		return SUCCESS;
	}
}
