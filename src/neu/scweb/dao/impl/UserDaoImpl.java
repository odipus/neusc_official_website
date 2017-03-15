package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.UserDao;
import neu.scweb.po.User;
import neu.scweb.util.BaseDao;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {

	private BaseDao baseDao;

	public List<User> queryAllUsers() {
		return baseDao.listAll("User");
	}

	public User queryUser(User user) {
		return (User) baseDao.loadObject("from User where userName='" + user.getUserName() + "' and userPsw='" + user.getUserPsw() + "'");
	}

	public boolean updateUser(User user) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean addUser(User user) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean deleteUser(User user) {
		boolean state=false;
		try {
			baseDao.delete(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<User> queryAllUsersByPage(int start, int limit) {
		return baseDao.queryPage("from User", start, limit);
	}

	public int queryUserAmount() {
		return baseDao.listAll("User").size();
	}

	public User queryUserByName(String userName) {
		return (User) baseDao.loadObject("from User where userName='"+ userName +"'");
	}
	
	
	public String transUser(String chnName) {
		User u = (User) baseDao.loadObject("from User where showName='"+ chnName +"'");
		return u.getUserName();
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}





}
