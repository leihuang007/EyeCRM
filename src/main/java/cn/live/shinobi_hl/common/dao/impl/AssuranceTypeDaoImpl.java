/**
 * 
 */
package cn.live.shinobi_hl.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.live.shinobi_hl.common.dao.intf.AssuranceTypeDao;
import cn.live.shinobi_hl.common.po.AssuranceType;
import cn.live.shinobi_hl.common.utils.dao.AbsBaseHibernateDao;

/**
 * @author Huanglei
 * 
 */
public class AssuranceTypeDaoImpl extends AbsBaseHibernateDao implements
		AssuranceTypeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.dao.intf.AssuranceTypeDao#getAll()
	 */
	@Override
	public List<AssuranceType> getAll() {
		String hql = "from AssuranceType at where at.status=0 order by id ";
		Session session = getSession();
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<AssuranceType> list = q.list();
		session.close();
		return list;
	}

}
