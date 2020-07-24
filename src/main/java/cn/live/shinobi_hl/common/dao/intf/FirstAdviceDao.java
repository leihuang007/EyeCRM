/**
 * 
 */
package cn.live.shinobi_hl.common.dao.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.FirstAdvice;

/**
 * @author Huanglei
 * 
 */
public interface FirstAdviceDao {
	/**
	 * 获取所有的初步诊疗建议
	 * 
	 * @return
	 */
	List<FirstAdvice> getAll();
}
