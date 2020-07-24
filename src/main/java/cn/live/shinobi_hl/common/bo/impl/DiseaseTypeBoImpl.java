/**
 * 
 */
package cn.live.shinobi_hl.common.bo.impl;

import java.util.ArrayList;
import java.util.List;

import cn.live.shinobi_hl.common.bo.intf.DiseaseTypeBo;
import cn.live.shinobi_hl.common.dao.intf.DiseaseTypeDao;
import cn.live.shinobi_hl.common.po.DiseaseType;
import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;

/**
 * @author Huanglei
 * 
 */
public class DiseaseTypeBoImpl extends AbsBaseBusinessObject implements
		DiseaseTypeBo {

	private DiseaseTypeDao dao;

	/**
	 * @return the dao
	 */
	public DiseaseTypeDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(DiseaseTypeDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.bo.intf.DiseaseTypeBo#getAll()
	 */
	@Override
	public List<DiseaseType> getAll() {
		List<DiseaseType> list = null;
		try {
			list = dao.getAll();
		} catch (Exception e) {
			list = new ArrayList<DiseaseType>(0);
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(e.getMessage());
		}
		return list;
	}

}
