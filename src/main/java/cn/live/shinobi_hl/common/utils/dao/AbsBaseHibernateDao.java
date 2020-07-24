/**
 * 
 */
package cn.live.shinobi_hl.common.utils.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Huanglei
 * 
 */
public abstract class AbsBaseHibernateDao {

	protected SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}
}
