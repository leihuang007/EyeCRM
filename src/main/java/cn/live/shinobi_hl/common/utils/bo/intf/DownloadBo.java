/**
 * 
 */
package cn.live.shinobi_hl.common.utils.bo.intf;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.po.DownloadInfo;

/**
 * @author Huanglei
 * 
 */
public interface DownloadBo {
	/**
	 * 获取执行结果信息
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * 预下载，用于生成文件
	 * 
	 * @param info
	 */
	void preDownload(DownloadInfo info);
}
