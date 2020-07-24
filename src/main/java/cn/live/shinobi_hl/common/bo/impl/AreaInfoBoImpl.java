/**
 * 
 */
package cn.live.shinobi_hl.common.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.bo.intf.AreaInfoBo;
import cn.live.shinobi_hl.common.dao.intf.AreaInfoDao;
import cn.live.shinobi_hl.common.po.AreaInfo;
import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;

/**
 * @author Huanglei
 * 
 */
public class AreaInfoBoImpl extends AbsBaseBusinessObject implements AreaInfoBo {

	private AreaInfoDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.bo.intf.AreaInfoBo#getAll()
	 */
	@Override
	public List<AreaInfo> getAll() {
		List<AreaInfo> list = null;
		try {
			list = dao.getAll();
		} catch (Exception e) {
			list = new ArrayList<AreaInfo>(0);
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(e.getMessage());
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.bo.intf.AreaInfoBo#getAll(java.lang.String)
	 */
	@Override
	public List<AreaInfo> getAll(String parentAreaCode) {
		if (StringUtils.isBlank(parentAreaCode)) {
			return null;
		}
		List<AreaInfo> list = null;
		try {
			list = dao.getAll(parentAreaCode);
		} catch (Exception e) {
			list = new ArrayList<AreaInfo>(0);
			this.getResult().setOk(false);
			this.getResult().setCodeNo(FunctionResult.TIP);
			this.getResult().setMessage(e.getMessage());
		}
		return list;
	}

	/**
	 * @return the dao
	 */
	public AreaInfoDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(AreaInfoDao dao) {
		this.dao = dao;
	}
}
