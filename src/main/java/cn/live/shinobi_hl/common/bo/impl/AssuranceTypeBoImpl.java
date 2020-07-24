/**
 * 
 */
package cn.live.shinobi_hl.common.bo.impl;

import java.util.ArrayList;
import java.util.List;

import cn.live.shinobi_hl.common.bo.intf.AssuranceTypeBo;
import cn.live.shinobi_hl.common.dao.intf.AssuranceTypeDao;
import cn.live.shinobi_hl.common.po.AssuranceType;
import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;

/**
 * @author Huanglei
 * 
 */
public class AssuranceTypeBoImpl extends AbsBaseBusinessObject implements
		AssuranceTypeBo {

	private AssuranceTypeDao dao;

	/**
	 * @return the dao
	 */
	public AssuranceTypeDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(AssuranceTypeDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.bo.intf.AssuranceTypeBo#getAll()
	 */
	@Override
	public List<AssuranceType> getAll() {
		List<AssuranceType> list = null;
		try {
			list = dao.getAll();
		} catch (Exception e) {
			list = new ArrayList<AssuranceType>(0);
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(e.getMessage());
		}
		return list;
	}
}
