/**
 * 
 */
package cn.live.shinobi_hl.common.utils.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.live.shinobi_hl.common.utils.CommonUtils;
import cn.live.shinobi_hl.common.utils.SysconfigUtils;
import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.bo.intf.DownloadBo;
import cn.live.shinobi_hl.common.utils.po.DownloadInfo;

/**
 * @author Huanglei
 * 
 */
public class FileDownloadAction extends AbsBaseAction<FileDownloadForm> {
	private final FileDownloadForm model = new FileDownloadForm();

	private InputStream targetFile;

	private DownloadBo downloadBo;

	/**
	 * @return the downloadBo
	 */
	public DownloadBo getDownloadBo() {
		return downloadBo;
	}

	/**
	 * @param downloadBo
	 *            the downloadBo to set
	 */
	public void setDownloadBo(DownloadBo downloadBo) {
		this.downloadBo = downloadBo;
	}

	@Override
	public FileDownloadForm getModel() {
		return model;
	}

	public String preDownload() {

		DownloadInfo info = new DownloadInfo();
		try {
			BeanUtils.copyProperties(info, model);
			Map<String, String> temp = CommonUtils.urlToMap(model
					.getQueryInfo());
			info.setConditions(temp);
		} catch (Exception e) {
			FunctionResult fr = new FunctionResult();
			fr.setMessage("下载文件控制模块异常，请联系管理员。");
			fr.setOk(false);
			fr.setCodeNo(FunctionResult.TIP);
			model.setFuncResult(fr);
			return SUCCESS;
		}

		downloadBo.preDownload(info);
		FunctionResult fr = downloadBo.getResult();
		if (fr.isOk()) {
			if ("PATIENT_DOWNLOAD".equals(model.getDownLoadType())) {
				fr.setMessage("/patients/download.action?fileName="
						+ info.getFileName());
			} else if ("OFFICER_DOWNLOAD".equals(info.getDownLoadType())) {
				fr.setMessage("/officers/download.action?fileName="
						+ info.getFileName());
			}
			fr.setOk(true);
			fr.setCodeNo(FunctionResult.REDIRECT);
			model.setFuncResult(fr);
		} else {
			model.setFuncResult(downloadBo.getResult());
		}
		return SUCCESS;
	}

	public InputStream getTargetFile() {
		String path = SysconfigUtils.getTempDirLocation() + model.getFileName();
		try {
			targetFile = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return targetFile;
	}
}
