/**
 * 
 */
package cn.live.shinobi_hl.officers.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.live.shinobi_hl.common.utils.dao.AbsBaseHibernateDao;
import cn.live.shinobi_hl.common.utils.po.PageInfo;
import cn.live.shinobi_hl.officers.dao.intf.OfficersDao;
import cn.live.shinobi_hl.officers.po.Officer;

/**
 * @author Huanglei
 * 
 */
public class OfficersDaoImpl extends AbsBaseHibernateDao implements OfficersDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.officers.dao.intf.OfficersDao#save(com.foxmail.
	 * deanhuang.officers.po.Officer)
	 */
	@Override
	public void save(Officer officer) {
		Session session = getSession();
		session.save(officer);
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.officers.dao.intf.OfficersDao#getPage(com.foxmail
	 * .deanhuang.common.utils.po.PageInfo)
	 */
	@Override
	public void getPage(PageInfo<Officer> pageInfo) {
		/**
		 * 拼接where子句。
		 */
		StringBuilder hqlWhere = new StringBuilder(200);
		hqlWhere.append(" where 1=1 and o.status=0 ");
		Map<String, String> conditions = pageInfo.getConditions();
		if (null != conditions) {
			hqlWhere.append(" and (");
			String areaCode = conditions.get("areaNo");
			conditions.remove("areaNo");
			String[] areaCodes = areaCode.split(",");
			if (null != areaCodes && areaCodes.length > 0) {
				hqlWhere.append(" o.areaNo like '");
				hqlWhere.append(areaCodes[0]);
				hqlWhere.append("%' ");
				for (int i = 1; i < areaCodes.length; i++) {
					hqlWhere.append(" or o.areaNo like '");
					hqlWhere.append(areaCodes[i]);
					hqlWhere.append("%' ");
				}
			}
			hqlWhere.append(") ");
			Set<Entry<String, String>> conSet = conditions.entrySet();
			Iterator<Entry<String, String>> iter = conSet.iterator();
			Entry<String, String> entry = null;
			while (iter.hasNext()) {
				entry = iter.next();
				hqlWhere.append(" and o.");
				hqlWhere.append(entry.getKey());
				hqlWhere.append(" like '%");
				hqlWhere.append(entry.getValue());
				hqlWhere.append("%' ");
			}
		}
		/**
		 * 拼接排序语句。
		 */
		StringBuilder hqlOrder = new StringBuilder(200);
		String sortname = pageInfo.getSortname();
		String sortorder = pageInfo.getSortorder();
		hqlOrder.append(" order by o.").append(sortname).append(" ")
				.append(sortorder);
		/**
		 * 拼接查询语句。
		 */
		StringBuilder hqlSearch = new StringBuilder(200);
		hqlSearch.append(" from Officer o ").append(hqlWhere).append(hqlOrder);
		/**
		 * 拼接查询总数语句。
		 */
		StringBuilder hqlTotal = new StringBuilder(200);
		hqlTotal.append(" select count(*) from Officer o ").append(hqlWhere);
		/**
		 * 计算起始、结束位置。
		 */
		int page = pageInfo.getPage();
		int rp = pageInfo.getRp();
		int startPos = (page - 1) * rp;
		/**
		 * 为pageInfo赋值
		 */
		pageInfo.setStartPos(startPos);
		pageInfo.setHqlSearch(hqlSearch.toString());
		pageInfo.setHqlTotal(hqlTotal.toString());
		/**
		 * 查询记录。
		 */
		System.out.println("hqlSearch : " + hqlSearch.toString());
		System.out.println("hqlTotal : " + hqlTotal.toString());
		Session session = getSession();
		Query q = session.createQuery(hqlSearch.toString());
		if (rp != -1) {// 分页查询
			q.setFirstResult(pageInfo.getStartPos());
			q.setMaxResults(pageInfo.getRp());
		}
		@SuppressWarnings("unchecked")
		List<Officer> resultList = q.list();
		pageInfo.setResultList(resultList);
		/**
		 * 查询总量。
		 */
		q = session.createQuery(hqlTotal.toString());
		long total = (Long) q.uniqueResult();
		pageInfo.setTotal(total);
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.officers.dao.intf.OfficersDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		String hql = "update Officer o set o.status = 1 where o.id=" + id;
		Session session = getSession();
		Query q = session.createQuery(hql);
		q.executeUpdate();
		session.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.officers.dao.intf.OfficersDao#getById(int)
	 */
	@Override
	public Officer getById(int id) {
		String hql = "from Officer o where o.status=0 and o.id=" + id;
		Session session = getSession();
		Query q = session.createQuery(hql);
		Officer o = (Officer) q.uniqueResult();
		session.close();
		return o;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.officers.dao.intf.OfficersDao#update(com.foxmail
	 * .deanhuang.officers.po.Officer)
	 */
	@Override
	public void update(Officer o) {
		Session session = getSession();
		session.update(o);
		session.flush();
		session.close();
	}

}
