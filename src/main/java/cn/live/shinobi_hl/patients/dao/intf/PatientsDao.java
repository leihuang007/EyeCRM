/**
 * 
 */
package cn.live.shinobi_hl.patients.dao.intf;

import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public interface PatientsDao {

	/**
	 * 保存Patient对象。
	 * 
	 * @param patient
	 */
	void save(Patient patient);

	/**
	 * 获取分页结果。
	 * 
	 * @param pageInfo
	 */
	void getPage(PageInfo<Patient> pageInfo);

	/**
	 * 根据病人的id删除病人。<br>
	 * 并非真正删除，而是将病人信息的status字段设置为1.
	 * 
	 * @param id
	 */
	void delete(int id);

	/**
	 * 通过 编号获取病人信息。
	 * 
	 * @param id
	 * @return
	 */
	Patient getById(int id);

	/**
	 * 更新病人信息
	 * 
	 * @param p
	 */
	void update(Patient p);
}
