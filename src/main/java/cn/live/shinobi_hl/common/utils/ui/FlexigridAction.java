/**
 * 
 */
package cn.live.shinobi_hl.common.utils.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import cn.live.shinobi_hl.common.po.Operator;
import cn.live.shinobi_hl.common.utils.CommonUtils;
import cn.live.shinobi_hl.common.utils.bo.intf.PageInfoBo;
import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.common.utils.po.PageRow;

/**
 * @author Huanglei
 * 
 */
public class FlexigridAction extends AbsBaseAction<FlexigridActionForm> {

	private final FlexigridActionForm model = new FlexigridActionForm();
	private PageInfoBo pageInfoBo;

	/**
	 * @return the pageInfoBo
	 */
	public PageInfoBo getPageInfoBo() {
		return pageInfoBo;
	}

	/**
	 * @param pageInfoBo
	 *            the pageInfoBo to set
	 */
	public void setPageInfoBo(PageInfoBo pageInfoBo) {
		this.pageInfoBo = pageInfoBo;
	}

	@Override
	public FlexigridActionForm getModel() {
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.utils.ui.AbsBaseAction#execute()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String execute() throws Exception {
		PageInfo pageInfo = new PageInfo();
		BeanUtils.copyProperties(pageInfo, model);
		/**
		 * ²éÑ¯Ìõ¼þ
		 */
		Map<String, String> conditions = CommonUtils.urlToMap(model.getQuery());
		Operator admin = getAdminObject();
		if (null == admin) {
			return SUCCESS;
		} else {
			String adminArea = admin.getAreaNo();
			String areaCode = conditions.get("areaNo");
			if (StringUtils.isBlank(areaCode)) {
				areaCode = adminArea;
			} else {
				if (adminArea.length() <= 3) {
					if (!areaCode.startsWith(adminArea)) {
						areaCode = adminArea;
					}
				} else {
					if (adminArea.indexOf(areaCode) == -1) {
						areaCode = adminArea;
					}
				}
			}
			conditions.put("areaNo", areaCode);
		}
		pageInfo.setConditions(conditions);
		pageInfoBo.getPage(pageInfo, model.getQueryName());
		model.setTotal(pageInfo.getTotal());
		List results = pageInfo.getResultList();
		if (null != results) {
			PageRow row = null;
			String temp = null;
			String[] temps = null;
			List<PageRow> rows = new ArrayList<PageRow>(results.size());
			for (Object o : results) {
				row = new PageRow();
				temp = o.toString();
				temps = temp.split("\\|&\\|");
				row.setCell(temps);
				row.setId(temps[0]);
				rows.add(row);
			}
			model.setRows(rows);
		}
		return SUCCESS;
	}

}
