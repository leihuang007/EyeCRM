/**
 * 
 */
package cn.live.shinobi_hl.officers.dao.intf;

import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.officers.po.Officer;

/**
 * @author Huanglei
 * 
 */
public interface OfficersDao {

	/**
	 * 保存Officer对象。
	 * 
	 * @param patient
	 */
	void save(Officer officer);

	/**
	 * 获取分页结果。
	 * 
	 * @param pageInfo
	 */
	void getPage(PageInfo<Officer> pageInfo);

	/**
	 * 根据联系人的id删除联系人。<br>
	 * 并非真正删除，而是将联系人信息的status字段设置为1.
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * 通过 编号获取联系人信息。
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
