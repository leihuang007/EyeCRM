/**
 * 
 */
package cn.live.shinobi_hl.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.live.shinobi_hl.common.dao.intf.AreaInfoDao;
import cn.live.shinobi_hl.common.po.AreaInfo;
import cn.live.shinobi_hl.common.utils.dao.AbsBaseHibernateDao;

/**
 * @author Huanglei
 * 
 */
public class AreaInfoDaoImpl extends AbsBaseHibernateDao implements AreaInfoDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.dao.intf.AreaInfoDao#getAll()
	 */
	@Override
	public List<AreaInfo> getAll() {
		String hql = "from AreaInfo ai where ai.status=0 order by areaCode ";
		Session session = getSession();
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<AreaInfo> list = q.list();
		session.close();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.dao.intf.AreaInfoDao#getAll(java.lang.String
	 * )
	 */
	@Override
	public List<AreaInfo> getAll(String parentAreaCode) {
		String hql = "from AreaInfo ai where ai.status=0 and (ai.areaCode='"
				+ parentAreaCode + "' or ai.parentAreaCode ='" + parentAreaCode
				+ "')  order by areaCode ";
		Session session = getSession();
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<AreaInfo> list = q.list();
		session.close();
		return list;
	}

}
