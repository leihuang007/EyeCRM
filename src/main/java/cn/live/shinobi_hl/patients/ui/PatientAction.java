/**
 * 
 */
package cn.live.shinobi_hl.patients.ui;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.ui.AbsBaseAction;
import cn.live.shinobi_hl.patients.bo.intf.PatientBo;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public class PatientAction extends AbsBaseAction<PatientActionForm> {

	private final PatientActionForm model = new PatientActionForm();
	private PatientBo patientBo;

	/**
	 * @return the patientBo
	 */
	public PatientBo getPatientBo() {
		return patientBo;
	}

	/**
	 * @param patientBo
	 *            the patientBo to set
	 */
	public void setPatientBo(PatientBo patientBo) {
		this.patientBo = patientBo;
	}

	@Override
	public PatientActionForm getModel() {
		return model;
	}

	/**
	 * ������Ӳ�������
	 * 
	 * @return
	 */
	public String add() {
		Patient patient = new Patient();
		try {
			BeanUtils.copyProperties(patient, model);
			String[] illness = model.getIllness();
			if (null != illness) {
				for (String i : illness) {
					if ("1".equals(i)) {
						patient.setHypertension(1);
					} else if ("2".equals(i)) {
						patient.setDiabetes(1);
					} else if ("3".equals(i)) {
						patient.setCardiopathy(1);
					}
				}
			}
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			fr.setMessage("���PATIENT���Ƶ�Ԫ�����쳣������ϵ����Ա��");
			model.setFuncResult(fr);
			return SUCCESS;
		}
		patientBo.save(patient);
		model.setFuncResult(patientBo.getResult());
		return SUCCESS;
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @return
	 */
	public String del() {
		try {
			String strIds = model.getIds();
			String[] ids = strIds.split(",");
			this.patientBo.batchDelete(ids);
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			fr.setMessage("ɾ��PATIENT���Ƶ�Ԫ�����쳣������ϵ����Ա��");
			model.setFuncResult(fr);
			return SUCCESS;
		}
		model.setFuncResult(this.patientBo.getResult());
		return SUCCESS;
	}

	public String preUpdate() {
		int id = model.getId();
		Patient p = this.patientBo.getById(id);
		if (this.patientBo.getResult().isOk()) {
			try {
				BeanUtils.copyProperties(model, p);
				int hypertension = p.getHypertension();
				int diabetes = p.getDiabetes();
				int cardiopathy = p.getCardiopathy();
				List<String> illnessList = new ArrayList<String>(3);
				if (1 == hypertension) {
					illnessList.add("1");
				}
				if (1 == diabetes) {
					illnessList.add("2");
				}
				if (1 == cardiopathy) {
					illnessList.add("3");
				}
				model.setIllnessList(illnessList);
			} catch (Exception e) {
				FunctionResult fr = new FunctionResult();
				fr.setOk(false);
				fr.setCodeNo(FunctionResult.TIP);
				fr.setMessage("�޸�PATIENT���Ƶ�Ԫ�����쳣������ϵ����Ա��");
				model.setFuncResult(fr);
				return ERROR;
			}
			return SUCCESS;
		} else {
			model.setFuncResult(this.patientBo.getResult());
			return ERROR;
		}
	}

	public String update() {
		Patient patient = new Patient();
		try {
			BeanUtils.copyProperties(patient, model);
			String[] illness = model.getIllness();
			if (null != illness) {
				for (String i : illness) {
					if ("1".equals(i)) {
						patient.setHypertension(1);
					} else if ("2".equals(i)) {
						patient.setDiabetes(1);
					} else if ("3".equals(i)) {
						patient.setCardiopathy(1);
					}
				}
			}
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			fr.setMessage("�޸�PATIENT���Ƶ�Ԫ�����쳣������ϵ����Ա��");
			model.setFuncResult(fr);
			return SUCCESS;
		}
		patientBo.update(patient);
		model.setFuncResult(patientBo.getResult());
		return SUCCESS;
	}
}
