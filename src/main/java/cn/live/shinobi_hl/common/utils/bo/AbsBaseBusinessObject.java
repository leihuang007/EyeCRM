/**
 * 
 */
package cn.live.shinobi_hl.common.utils.bo;

/**
 * @author Huanglei
 * 
 */
public abstract class AbsBaseBusinessObject {

	protected FunctionResult result;

	/**
	 * @return the result
	 */
	public FunctionResult getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(FunctionResult result) {
		this.result = result;
	}
}
