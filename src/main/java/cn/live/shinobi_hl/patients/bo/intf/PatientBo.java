/**
 * 
 */
package cn.live.shinobi_hl.patients.bo.intf;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.patients.po.Patient;

/**
 * @author Huanglei
 * 
 */
public interface PatientBo {

	/**
	 * 获取执行结果信息
	 * 
	 * @return
	 */
	FunctionResult getResult();

	/**
	 * 保存Patient对象
	 * 
	 * @param patient
	 */
	void save(Patient patient);

	/**
	 * 批量删除病人信息
	 * 
	 * @param ids
	 */
	void batchDelete(String[] ids);

	/**
	 * 根据病人编号获取病人信息
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
