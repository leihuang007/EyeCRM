/**
 * 
 */
package cn.live.shinobi_hl.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.live.shinobi_hl.common.dao.intf.FirstAdviceDao;
import cn.live.shinobi_hl.common.po.FirstAdvice;
import cn.live.shinobi_hl.common.utils.dao.AbsBaseHibernateDao;

/**
 * @author Huanglei
 * 
 */
public class FirstAdviceDaoImpl extends AbsBaseHibernateDao implements
		FirstAdviceDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.dao.intf.FirstAdviceDao#getAll()
	 */
	@Override
	public List<FirstAdvice> getAll() {
		String hql = "from FirstAdvice fa where fa.status=0 order by id ";
		Session session = getSession();
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<FirstAdvice> list = q.list();
		session.close();
		return list;
	}

}
