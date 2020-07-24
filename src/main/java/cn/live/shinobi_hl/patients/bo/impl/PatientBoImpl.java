/**
 * 
 */
package cn.live.shinobi_hl.patients.bo.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.patients.bo.intf.PatientBo;
import cn.live.shinobi_hl.patients.dao.intf.PatientsDao;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public class PatientBoImpl extends AbsBaseBusinessObject implements PatientBo {

	/**
	 * patient dao
	 */
	private PatientsDao dao;

	/**
	 * @return the dao
	 */
	public PatientsDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(PatientsDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.patients.bo.intf.PatientBo#save(cn.live.shinobi_hl
	 * .patients.po.Patient)
	 */
	@Override
	public void save(Patient patient) {
		try {
			if (this.saveValid(patient)) {
				dao.save(patient);
				this.getResult().setOk(true);
				this.getResult().setCodeNo(FunctionResult.TIP);
				this.getResult().setMessage(
						"���ˡ�" + patient.getPatientName() + "����Ϣ��ӳɹ���");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(
					"���ˡ�" + patient.getPatientName()
							+ "����Ϣ���ʱ�����쳣������ò����Ƿ��Ѿ���ӹ���");
		}
	}

	/**
	 * У��Patient�����Ƿ���Դ������ݿ��С�
	 * 
	 * @param patient
	 * @return
	 */
	private boolean saveValid(Patient patient) {
		this.getResult().setOk(false);
		this.getResult().setCodeNo(FunctionResult.TIP);
		if (null == patient) {
			this.getResult().setMessage("������Ϣû����д��");
			return false;
		}
		if (null == patient.getStreet()) {
			this.getResult().setMessage("�ֵ���Ϣû����д��");
			return false;
		}
		if (null == patient.getNeighbourhood()) {
			this.getResult().setMessage("������Ϣû����д��");
			return false;
		}
		if (null == patient.getCheckDate()) {
			this.getResult().setMessage("�������û����д��");
			return false;
		}
		if (StringUtils.isBlank(patient.getPatientName())) {
			this.getResult().setMessage("��������û����д��");
			return false;
		}
		if (patient.getAge() <= 0) {
			this.getResult().setMessage("��������û����д��");
			return false;
		}
		if (StringUtils.isBlank(patient.getPhone())) {
			this.getResult().setMessage("������ϵ��ʽû����д��");
			return false;
		}
		if (0 == patient.getAssuranceTypeId()) {
			this.getResult().setMessage("����ҽ������û����д��");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage(
				"���ˡ�" + patient.getPatientName() + "����ϢУ��ɹ���");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.patients.bo.intf.PatientBo#batchDelete(java.lang
	 * .String[])
	 */
	@Override
	public void batchDelete(String[] ids) {
		if (this.batchDeleteValid(ids)) {
			int counter = 0;
			int id = 0;
			for (String strId : ids) {
				try {
					id = Integer.parseInt(strId);
				} catch (NumberFormatException e) {
					continue;
				}
				try {
					this.dao.delete(id);
				} catch (Exception e) {
					this.getResult().setOk(false);
					this.getResult().setMessage("ɾ����¼����");
					this.getResult().setCodeNo(FunctionResult.TIP);
					return;
				}
				counter++;
			}
			this.getResult().setOk(true);
			this.getResult().setMessage("��ɾ��" + counter + "����¼��");
			this.getResult().setCodeNo(FunctionResult.TIP);
		}
	}

	public boolean batchDeleteValid(String[] ids) {
		this.getResult().setCodeNo(FunctionResult.TIP);
		this.getResult().setOk(false);
		if (ArrayUtils.isEmpty(ids)) {
			this.getResult().setMessage("û��ѡ��Ҫɾ���Ĳ�����Ϣ��");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("ɾ��������ϢУ��ɹ���");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.patients.bo.intf.PatientBo#getById(int)
	 */
	@Override
	public Patient getById(int id) {
		if (this.getByIdValid(id)) {
			return dao.getById(id);
		} else {
			return null;
		}
	}

	private boolean getByIdValid(int id) {
		this.getResult().setOk(false);
		this.getResult().setCodeNo(FunctionResult.TIP);
		if (id <= 0) {
			this.getResult().setMessage("��ȡ������Ϣ�ı�Ŵ���");
			return false;
		}
		Patient p = null;
		try {
			p = this.dao.getById(id);
		} catch (Exception e) {
			this.getResult().setMessage("���ݿ�����쳣������ϵ����Ա��");
			return false;
		}
		if (null == p) {
			this.getResult().setMessage("���޸Ĳ�����Ϣ�����ڡ�");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("��ȡ������ϢУ��ͨ����");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.patients.bo.intf.PatientBo#update(cn.live.shinobi_hl
	 * .patients.po.Patient)
	 */
	@Override
	public void update(Patient p) {
		try {
			if (this.updateValid(p)) {
				this.dao.update(p);
				this.getResult().setOk(true);
				this.getResult().setCodeNo(FunctionResult.TIP);
				this.getResult().setMessage(
						"���ˡ�" + p.getPatientName() + "����Ϣ�޸ĳɹ���");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult()
					.setMessage("���ˡ�" + p.getPatientName() + "����Ϣ�޸�ʧ�ܡ�");
		}
	}

	private boolean updateValid(Patient p) {
		if (this.saveValid(p)) {
			int id = p.getId();
			if (id <= 0) {
				this.getResult().setMessage("���޸Ĳ��˵ı�Ŵ���");
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
