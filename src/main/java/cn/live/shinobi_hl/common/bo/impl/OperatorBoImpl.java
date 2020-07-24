/**
 * 
 */
package cn.live.shinobi_hl.common.bo.impl;

import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.bo.intf.OperatorBo;
import cn.live.shinobi_hl.common.dao.intf.OperatorDao;
import cn.live.shinobi_hl.common.po.Operator;
import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;

/**
 * @author Huanglei
 * 
 */
public class OperatorBoImpl extends AbsBaseBusinessObject implements OperatorBo {

	private OperatorDao dao;

	/**
	 * @return the dao
	 */
	public OperatorDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(OperatorDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.bo.intf.OperatorBo#save(cn.live.shinobi_hl
	 * .common.po.Operator)
	 */
	@Override
	public void save(Operator op) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.bo.intf.OperatorBo#getOperatorByNameAndPass
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public Operator getOperatorByNameAndPass(Operator op) {
		if (StringUtils.isBlank(op.getUserName())) {
			this.getResult().setOk(false);
			this.getResult().setMessage("用户名不能为空。");
			return null;
		}
		if (StringUtils.isBlank(op.getPassword())) {
			this.getResult().setOk(false);
			this.getResult().setMessage("密码不能为空。");
			return null;
		}
		Operator opTmp = null;
		try {
			opTmp = dao.getOperatorByNameAndPass(op.getUserName(),
					op.getPassword());
		} catch (Exception e) {
			this.getResult().setOk(false);
			this.getResult().setMessage("数据库异常，请联系管理员。");
			return null;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("管理员信息查询结束。");
		return opTmp;
	}
}
