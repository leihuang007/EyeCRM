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
	 * ��ȡִ�н����Ϣ
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * Ԥ���أ����������ļ�
	 * 
	 * @param info
	 */
	void preDownload(DownloadInfo info);
}
