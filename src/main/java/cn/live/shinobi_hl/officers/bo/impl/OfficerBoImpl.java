/**
 * 
 */
package cn.live.shinobi_hl.officers.bo.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.officers.bo.intf.OfficerBo;
import cn.live.shinobi_hl.officers.dao.intf.OfficersDao;
import cn.live.shinobi_hl.officers.po.Officer;

/**
 * @author Huanglei
 * 
 */
public class OfficerBoImpl extends AbsBaseBusinessObject implements OfficerBo {

	private OfficersDao dao;

	/**
	 * @return the dao
	 */
	public OfficersDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(OfficersDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.officers.bo.intf.OfficerBo#save(cn.live.shinobi_hl
	 * .officers.po.Officer)
	 */
	@Override
	public void save(Officer officer) {
		try {
			if (this.saveValid(officer)) {
				dao.save(officer);
				this.getResult().setOk(true);
				this.getResult().setCodeNo(FunctionResult.TIP);
				this.getResult().setMessage(
						"��ϵ�ˡ�" + officer.getChiefOfficerName() + "����Ϣ��ӳɹ���");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(
					"��ϵ�ˡ�" + officer.getChiefOfficerName()
							+ "����Ϣ����ʱ�����쳣������ϵ����Ա��");
		}
	}

	/**
	 * У��officer�����Ƿ���Դ������ݿ��С�
	 * 
	 * @param officer
	 * @return
	 */
	private boolean saveValid(Officer officer) {
		this.getResult().setOk(false);
		this.getResult().setCodeNo(FunctionResult.TIP);
		if (null == officer) {
			this.getResult().setMessage("��ϵ����Ϣû����д��");
			return false;
		}
		if (StringUtils.isBlank(officer.getChiefOfficerName())) {
			this.getResult().setMessage("����������û����д��");
			return false;
		}

		if (StringUtils.isBlank(officer.getAreaNo())) {
			this.getResult().setMessage("��ϵ������û����д��");
			return false;
		}
		if (StringUtils.isBlank(officer.getStreet())) {
			this.getResult().setMessage("��ϵ�˽ֵ�û����д��");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage(
				"��ϵ�ˡ�" + officer.getChiefOfficerName() + "����ϢУ��ɹ���");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.officers.bo.intf.OfficerBo#batchDelete(java.lang
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
			this.getResult().setMessage("û��ѡ��Ҫɾ������ϵ����Ϣ��");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("ɾ����ϵ����ϢУ��ɹ���");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.officers.bo.intf.OfficerBo#getById(int)
	 */
	@Override
	public Officer getById(int id) {
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
			this.getResult().setMessage("��ȡ��ϵ����Ϣ�ı�Ŵ���");
			return false;
		}
		Officer o = null;
		try {
			o = this.dao.getById(id);
		} catch (Exception e) {
			this.getResult().setMessage("���ݿ�����쳣������ϵ����Ա��");
			return false;
		}
		if (null == o) {
			this.getResult().setMessage("���޸���ϵ����Ϣ�����ڡ�");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("��ȡ��ϵ����ϢУ��ͨ����");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.officers.bo.intf.OfficerBo#update(cn.live.shinobi_hl
	 * .officers.po.Officer)
	 */
	@Override
	public void update(Officer o) {
		try {
			if (this.updateValid(o)) {
				this.dao.update(o);
				this.getResult().setOk(true);
				this.getResult().setCodeNo(FunctionResult.TIP);
				this.getResult().setMessage(
						"��ϵ�ˡ�" + o.getChiefOfficerName() + "����Ϣ�޸ĳɹ���");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(
					"��ϵ�ˡ�" + o.getChiefOfficerName() + "����Ϣ�޸�ʧ�ܡ�");
		}

	}

	private boolean updateValid(Officer o) {
		if (this.saveValid(o)) {
			int id = o.getId();
			if (id <= 0) {
				this.getResult().setMessage("���޸���ϵ�˵ı�Ŵ���");
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
