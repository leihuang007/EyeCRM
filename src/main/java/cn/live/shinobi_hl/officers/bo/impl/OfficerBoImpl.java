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
						"联系人【" + officer.getChiefOfficerName() + "】信息添加成功。");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(
					"联系人【" + officer.getChiefOfficerName()
							+ "】信息处理时发生异常，请联系管理员。");
		}
	}

	/**
	 * 校验officer对象是否可以存入数据库中。
	 * 
	 * @param officer
	 * @return
	 */
	private boolean saveValid(Officer officer) {
		this.getResult().setOk(false);
		this.getResult().setCodeNo(FunctionResult.TIP);
		if (null == officer) {
			this.getResult().setMessage("联系人信息没有填写。");
			return false;
		}
		if (StringUtils.isBlank(officer.getChiefOfficerName())) {
			this.getResult().setMessage("负责人姓名没有填写。");
			return false;
		}

		if (StringUtils.isBlank(officer.getAreaNo())) {
			this.getResult().setMessage("联系人区域没有填写。");
			return false;
		}
		if (StringUtils.isBlank(officer.getStreet())) {
			this.getResult().setMessage("联系人街道没有填写。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage(
				"联系人【" + officer.getChiefOfficerName() + "】信息校验成功。");
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
			this.getResult().setMessage("没有选择要删除的联系人信息。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("删除联系人信息校验成功。");
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
			this.getResult().setMessage("获取联系人信息的编号错误。");
			return false;
		}
		Officer o = null;
		try {
			o = this.dao.getById(id);
		} catch (Exception e) {
			this.getResult().setMessage("数据库操作异常，请联系管理员。");
			return false;
		}
		if (null == o) {
			this.getResult().setMessage("待修改联系人信息不存在。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("获取联系人信息校验通过。");
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
						"联系人【" + o.getChiefOfficerName() + "】信息修改成功。");
			}
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(
					"联系人【" + o.getChiefOfficerName() + "】信息修改失败。");
		}

	}

	private boolean updateValid(Officer o) {
		if (this.saveValid(o)) {
			int id = o.getId();
			if (id <= 0) {
				this.getResult().setMessage("待修改联系人的编号错误。");
				return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
