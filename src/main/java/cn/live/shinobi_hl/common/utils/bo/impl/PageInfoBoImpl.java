/**
 * 
 */
package cn.live.shinobi_hl.common.utils.bo.impl;

import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.intf.PageInfoBo;
import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.officers.dao.intf.OfficersDao;
import cn.live.shinobi_hl.patients.dao.intf.PatientsDao;

/**
 * @author Huanglei
 * 
 */
public class PageInfoBoImpl extends AbsBaseBusinessObject implements PageInfoBo {

	private PatientsDao patientDao;
	private OfficersDao officerDao;

	/**
	 * @return the patientDao
	 */
	public PatientsDao getPatientDao() {
		return patientDao;
	}

	/**
	 * @param patientDao
	 *            the patientDao to set
	 */
	public void setPatientDao(PatientsDao patientDao) {
		this.patientDao = patientDao;
	}

	/**
	 * @return the officerDao
	 */
	public OfficersDao getOfficerDao() {
		return officerDao;
	}

	/**
	 * @param officerDao
	 *            the officerDao to set
	 */
	public void setOfficerDao(OfficersDao officerDao) {
		this.officerDao = officerDao;
	}

	@Override
	public void getPage(PageInfo pageInfo, String searchName) {
		if (this.validPageInfo(pageInfo)) {
			try {
				chooseSearchEngine(pageInfo, searchName);
				this.getResult().setOk(true);
				this.getResult().setMessage("页面生成结束。");
			} catch (Exception e) {
				this.getResult().setOk(false);
				this.getResult().setMessage("分页逻辑单元出错！");
			}
		}
	}

	/**
	 * 校验pageInfo的内容是否合法。
	 * 
	 * @param pageInfo
	 * @return
	 */
	private boolean validPageInfo(PageInfo pageInfo) {
		String sortname = pageInfo.getSortname();
		String sortorder = pageInfo.getSortorder();
		if (StringUtils.isBlank(sortorder) || StringUtils.isBlank(sortname)) {
			this.getResult().setOk(false);
			this.getResult().setMessage("排序条件异常。");
			return false;
		}
		this.getResult().setOk(true);
		this.getResult().setMessage("分页条件检查通过。");
		return true;
	}

	/**
	 * 根据searchName选取相应的DAO。
	 * 
	 * @param pageInfo
	 * @param searchName
	 */
	private void chooseSearchEngine(PageInfo pageInfo, String searchName) {
		if (null == pageInfo || StringUtils.isBlank(searchName)) {
			this.getResult().setOk(false);
			this.getResult().setMessage("无法根据searchName选取DAO");
		} else {
			if ("PATIENT_SEARCH".equals(searchName)) {
				patientDao.getPage(pageInfo);
			} else if ("OFFICER_SEARCH".equals(searchName)) {
				officerDao.getPage(pageInfo);
			}
		}
	}
}
