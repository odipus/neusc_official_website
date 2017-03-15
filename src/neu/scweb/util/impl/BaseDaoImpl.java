package neu.scweb.util.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Component;

import neu.scweb.util.BaseDao;
import neu.scweb.util.MyHibernateDaoSupport;

@Component(value = "baseDao")
public class BaseDaoImpl extends MyHibernateDaoSupport implements BaseDao {

	public List query(String hql) {
		final String hqlf = hql;
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hqlf);
				return query.list();
			}
		});
	}

	public void createQuery(String hql) {
		final String hqlf = hql;
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createSQLQuery(hqlf);
				return query.executeUpdate();
			}
		});
	}

	public Connection getConnection() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession()
				.connection();
	}

	public void saveOrUpdate(Object obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	public void update(Object obj) {
		getHibernateTemplate().merge(obj);
	}

	public List queryPage(String hql, final int start, final int sum) {
		final String hqlf = hql;
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hqlf);
				query.setFirstResult(start);
				query.setMaxResults(sum);
				return query.list();
			}
		});
	}

	public int update(String hql) {
		final String hqlf = hql;
		return ((Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hqlf);
						return query.executeUpdate();
					}
				})).intValue();
	}

	public List listAll(String clazz) {
		return getHibernateTemplate().find(
				"from " + clazz + " as a order by a.id");
	}

	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	public Object loadObject(String hql) {
		final String hql1 = hql;
		Object obj = null;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});
		if (list.size() > 0) {
			obj = list.get(0);
		}
		return obj;
	}
}
