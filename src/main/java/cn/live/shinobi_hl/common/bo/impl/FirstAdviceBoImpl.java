/**
 * 
 */
package cn.live.shinobi_hl.common.bo.impl;

import java.util.ArrayList;
import java.util.List;

import cn.live.shinobi_hl.common.bo.intf.FirstAdviceBo;
import cn.live.shinobi_hl.common.dao.intf.FirstAdviceDao;
import cn.live.shinobi_hl.common.po.FirstAdvice;
import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;

/**
 * @author Huanglei
 * 
 */
public class FirstAdviceBoImpl extends AbsBaseBusinessObject implements
		FirstAdviceBo {

	private FirstAdviceDao dao;

	/**
	 * @return the dao
	 */
	public FirstAdviceDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(FirstAdviceDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.bo.intf.FirstAdviceBo#getAll()
	 */
	@Override
	public List<FirstAdvice> getAll() {
		List<FirstAdvice> list = null;
		try {
			list = dao.getAll();
		} catch (Exception e) {
			list = new ArrayList<FirstAdvice>(0);
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(e.getMessage());
		}
		return list;
	}

}
