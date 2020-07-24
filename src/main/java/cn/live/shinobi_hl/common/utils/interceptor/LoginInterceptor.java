/**
 * 
 */
package cn.live.shinobi_hl.common.utils.interceptor;

import java.util.Map;

import cn.live.shinobi_hl.common.utils.bo.FunctionResult;
import cn.live.shinobi_hl.common.utils.ui.AbsBaseAction;
import cn.live.shinobi_hl.common.utils.ui.AbsBaseActionForm;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author Huanglei
 * 
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272634218456553758L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		// 没有登录的情况。
		if (null == session.get("admin")) {
			AbsBaseAction<Object> action = (AbsBaseAction<Object>) invocation
					.getAction();
			AbsBaseActionForm form = action == null ? null
					: (AbsBaseActionForm) action.getModel();
			FunctionResult result = new FunctionResult();
			form.setFuncResult(result);
			if (null != result) {
				result.setCodeNo(FunctionResult.REDIRECT);
				result.setMessage("/index.jsp");
				result.setOk(false);
			}
			return Action.SUCCESS;
		} else {
			return invocation.invoke();
		}
	}
}
