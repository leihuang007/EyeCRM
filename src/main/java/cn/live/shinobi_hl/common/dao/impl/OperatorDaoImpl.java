/**
 * 
 */
package cn.live.shinobi_hl.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.live.shinobi_hl.common.dao.intf.OperatorDao;
import cn.live.shinobi_hl.common.po.Operator;
import cn.live.shinobi_hl.common.utils.dao.AbsBaseHibernateDao;

/**
 * @author Huanglei
 * 
 */
public class OperatorDaoImpl extends AbsBaseHibernateDao implements OperatorDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.dao.intf.OperatorDao#save(cn.live.shinobi_hl
	 * .common.po.Operator)
	 */
	@Override
	public void save(Operator operator) {
		Session session = getSession();
		session.save(operator);
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.live.shinobi_hl.common.dao.intf.OperatorDao#getAll()
	 */
	@Override
	public List<Operator> getAll() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.live.shinobi_hl.common.dao.intf.OperatorDao#getOperatorByNameAndPass
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public Operator getOperatorByNameAndPass(String userName, String pass) {
		StringBuilder sb = new StringBuilder(30);
		sb.append(" from Operator op where op.userName='");
		sb.append(userName);
		sb.append("' and op.password='");
		sb.append(pass);
		sb.append("' ");
		Session session = getSession();
		Query query = session.createQuery(sb.toString());
		Operator op = (Operator) query.uniqueResult();
		session.close();
		return op;
	}

}
