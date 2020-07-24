/**
 * 
 */
package cn.live.shinobi_hl.common.utils.ui;

import java.util.Map;

import cn.live.shinobi_hl.common.po.Operator;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Huanglei
 * 
 */
public abstract class AbsBaseAction<T> implements Action, ModelDriven<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.Action#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	protected Operator getAdminObject() {
		// …Ë÷√session
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		// session.put("admin", admin);
		Operator admin = (Operator) session.get("admin");
		return admin;
	}

}
