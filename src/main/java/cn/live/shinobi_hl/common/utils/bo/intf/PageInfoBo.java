package cn.live.shinobi_hl.common.utils.bo.intf;

import cn.live.shinobi_hl.common.utils.po.PageInfo;

public interface PageInfoBo<T extends Object> {

	/**
	 * ����pageInfo�е���������ɷ�ҳ����
	 * 
	 * @param pageInfo
	 */
	void getPage(PageInfo<T> pageInfo, String searchName);
}
