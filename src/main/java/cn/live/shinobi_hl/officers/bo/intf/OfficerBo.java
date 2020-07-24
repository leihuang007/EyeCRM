package cn.live.shinobi_hl.officers.bo.intf;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.officers.po.Officer;

public interface OfficerBo {

	/**
	 * 获取执行结果信息
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * 保存Officer对象
	 * 
	 * @param officer
	 */
	void save(Officer officer);

	/**
	 * 批量删除病人信息
	 * 
	 * @param ids
	 */
	void batchDelete(String[] ids);

	/**
	 * 根据联系人编号获取联系人信息
	 * 
	 * @param id
	 * @return
	 */
	Officer getById(int id);

	/**
	 * 更新联系人信息
	 * 
	 * @param p
	 */
	void update(Officer o);
}
