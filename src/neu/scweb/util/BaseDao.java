package neu.scweb.util;

import java.sql.Connection;
import java.util.List;

public interface BaseDao {
	public List query(String hql);
	public List listAll(String clazz);
	public List queryPage(String hql, final int start, final int sum);
	public Object loadObject(String hql);
	public void saveOrUpdate(Object obj);
	public void update(Object obj);
	public void delete(Object obj);
	public Connection getConnection();
	public void createQuery(String hql);
}
