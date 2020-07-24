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
						"病人【" + patient.getPatientName() + "】信息添加成功。");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(
					"病人【" + patient.getPatientName()
							+ "】信息添加时发生异常，请检查该病人是否已经添加过。");
		}
	}

	/**
	 * 校验Patient对象是否可以存入数据库中。
	 * 
	 * @param patient
	 * @return
	 */
	private boolean saveValid(Patient patient) {
		this.getResult().setOk(false);
		this.getResult().setCodeNo(FunctionResult.TIP);
		if (null == patient) {
			this.getResult().setMessage("病人信息没有填写。");
			return false;
		}
		if (null == patient.getStreet()) {
			this.getResult().setMessage("街道信息没有填写。");
			return false;
		}
		if (null == patient.getNeighbourhood()) {
			this.getResult().setMessage("社区信息没有填写。");
			return false;
		}
		if (null == patient.getCheckDate()) {
			this.getResult().setMessage("检查日期没有填写。");
			return false;
		}
		if (StringUtils.isBlank(patient.getPatientName())) {
			this.getResult().setMessage("病人姓名没有填写。");
			return false;
		}
		if (patient.getAge() <= 0) {
			this.getResult().setMessage("病人年龄没有填写。");
			return false;
		}
		if (StringUtils.isBlank(patient.getPhone())) {
			this.getResult().setMessage("病人联系方式没有填写。");
			return false;
		}
		if (0 == patient.getAssuranceTypeId()) {
			this.getResult().setMessage("病人医保类型没有填写。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage(
				"病人【" + patient.getPatientName() + "】信息校验成功。");
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
					this.getResult().setMessage("删除记录出错！");
					this.getResult().setCodeNo(FunctionResult.TIP);
					return;
				}
				counter++;
			}
			this.getResult().setOk(true);
			this.getResult().setMessage("共删除" + counter + "条记录。");
			this.getResult().setCodeNo(FunctionResult.TIP);
		}
	}

	public boolean batchDeleteValid(String[] ids) {
		this.getResult().setCodeNo(FunctionResult.TIP);
		this.getResult().setOk(false);
		if (ArrayUtils.isEmpty(ids)) {
			this.getResult().setMessage("没有选择要删除的病人信息。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("删除病人信息校验成功。");
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
			this.getResult().setMessage("获取病人信息的编号错误。");
			return false;
		}
		Patient p = null;
		try {
			p = this.dao.getById(id);
		} catch (Exception e) {
			this.getResult().setMessage("数据库操作异常，请联系管理员。");
			return false;
		}
		if (null == p) {
			this.getResult().setMessage("待修改病人信息不存在。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("获取病人信息校验通过。");
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
						"病人【" + p.getPatientName() + "】信息修改成功。");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult()
					.setMessage("病人【" + p.getPatientName() + "】信息修改失败。");
		}
	}

	private boolean updateValid(Patient p) {
		if (this.saveValid(p)) {
			int id = p.getId();
			if (id <= 0) {
				this.getResult().setMessage("待修改病人的编号错误。");
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
