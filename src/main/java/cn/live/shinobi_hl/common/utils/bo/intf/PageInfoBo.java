package cn.live.shinobi_hl.common.utils.bo.intf;

import cn.live.shinobi_hl.common.utils.po.PageInfo;

public interface PageInfoBo<T extends Object> {

	/**
	 * 根据pageInfo中的条件，组成分页对象。
	 * 
	 * @param pageInfo
	 */
	void getPage(PageInfo<T> pageInfo, String searchName);
}
