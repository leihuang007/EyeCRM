/**
 * 
 */
package cn.live.shinobi_hl.common.utils.bo.impl;

import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.utils.bo.AbsBaseBusinessObject;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.bo.intf.DownloadBo;
import cn.live.shinobi_hl.common.utils.bo.intf.PageInfoBo;
import cn.live.shinobi_hl.common.utils.filetools.impl.ExcelFileGenerator;
import cn.live.shinobi_hl.common.utils.filetools.intf.FileGenerator;
import cn.live.shinobi_hl.common.utils.po.DownloadInfo;
import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.officers.po.Officer;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public class DownloadBoImpl extends AbsBaseBusinessObject implements DownloadBo {

	private PageInfoBo pageInfoBo;

	/**
	 * @return the pageInfoBo
	 */
	public PageInfoBo getPageInfoBo() {
		return pageInfoBo;
	}

	/**
	 * @param pageInfoBo
	 *            the pageInfoBo to set
	 */
	public void setPageInfoBo(PageInfoBo pageInfoBo) {
		this.pageInfoBo = pageInfoBo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.utils.bo.intf.DownloadBo#preDownload(com
	 * .foxmail.deanhuang.common.utils.po.DownloadInfo)
	 */
	@Override
	public void preDownload(DownloadInfo info) {
		if (this.preDownloadValid(info)) {

			String searchName = "";
			if ("PATIENT_DOWNLOAD".equals(info.getDownLoadType())) {
				PageInfo<Patient> pageInfo = new PageInfo<Patient>();
				pageInfo.setConditions(info.getConditions());
				searchName = "PATIENT_SEARCH";
				pageInfo.setSortname("areaNo,p.checkDate ");
				pageInfo.setSortorder("asc");
				pageInfo.setRp(-1);
				pageInfoBo.getPage(pageInfo, searchName);
				FileGenerator<Patient> fg = new ExcelFileGenerator<Patient>();
				String fileName = "";
				try {
					fileName = fg.generateFile(FileGenerator.PATIENT_LIST,
							pageInfo.getResultList());
				} catch (Exception e) {
					this.getResult().setOk(false);
					this.getResult().setCodeNo(FunctionResult.TIP);
					this.getResult().setMessage(e.getMessage());
					return;
				}
				info.setFileName(fileName);
			} else if ("OFFICER_DOWNLOAD".equals(info.getDownLoadType())) {
				PageInfo<Officer> pageInfo = new PageInfo<Officer>();
				pageInfo.setConditions(info.getConditions());
				searchName = "OFFICER_SEARCH";
				pageInfo.setSortname("areaNo ");
				pageInfo.setSortorder("asc");
				pageInfo.setRp(-1);
				pageInfoBo.getPage(pageInfo, searchName);
				FileGenerator<Officer> fg = new ExcelFileGenerator<Officer>();
				String fileName = "";
				try {
					fileName = fg.generateFile(FileGenerator.OFFICER_LIST,
							pageInfo.getResultList());
				} catch (Exception e) {
					this.getResult().setOk(false);
					this.getResult().setCodeNo(FunctionResult.TIP);
					this.getResult().setMessage(e.getMessage());
					return;
				}
				info.setFileName(fileName);
			}
		}
	}

	private boolean preDownloadValid(DownloadInfo info) {
		this.getResult().setOk(false);
		this.getResult().setCodeNo(FunctionResult.TIP);
		if (null == info) {
			this.getResult().setMessage("下载信息异常。");
			return false;
		}
		if (StringUtils.isBlank(info.getDownLoadType())) {
			this.getResult().setMessage("没有设置下载类别。");
			return false;
		}
		this.getResult().setMessage("下载信息校验通过。");
		this.getResult().setOk(true);
		return true;
	}

}
