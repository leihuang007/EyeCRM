/**
 * 
 */
package cn.live.shinobi_hl.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.live.shinobi_hl.common.dao.intf.DiseaseTypeDao;
import cn.live.shinobi_hl.common.po.DiseaseType;
import cn.live.shinobi_hl.common.utils.dao.AbsBaseHibernateDao;

/**
 * @author Huanglei
 * 
 */
public class DiseaseTypeDaoImpl extends AbsBaseHibernateDao implements
		DiseaseTypeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.dao.intf.DiseaseTypeDao#getAll()
	 */
	@Override
	public List<DiseaseType> getAll() {
		String hql = "from DiseaseType dt where dt.status=0 order by id ";
		Session session = getSession();
		Query q = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<DiseaseType> list = q.list();
		session.close();
		return list;
	}

}
