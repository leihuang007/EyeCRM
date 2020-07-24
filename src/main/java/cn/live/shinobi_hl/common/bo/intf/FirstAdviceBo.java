/**
 * 
 */
package cn.live.shinobi_hl.common.bo.intf;

import java.util.List;

import cn.live.shinobi_hl.common.po.FirstAdvice;

/**
 * @author Huanglei
 * 
 */
public interface FirstAdviceBo {

	/**
	 * 获取所有的初步诊疗建议
	 * 
	 * @return
	 */
	List<FirstAdvice> getAll();

}
