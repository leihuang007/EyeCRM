/**
 * 
 */
package cn.live.shinobi_hl.common.utils.ui;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;

/**
 * @author Huanglei
 * 
 */
public abstract class AbsBaseActionForm {

	private FunctionResult funcResult;

	/**
	 * @return the funcResult
	 */
	public FunctionResult getFuncResult() {
		return funcResult;
	}

	/**
	 * @param funcResult
	 *            the funcResult to set
	 */
	public void setFuncResult(FunctionResult funcResult) {
		this.funcResult = funcResult;
	}

}
