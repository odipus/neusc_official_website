package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.User_securityDao;
import neu.scweb.po.User_security;
import neu.scweb.util.BaseDao;

@Component(value="user_securityDao")
public class User_securityDaoImpl implements User_securityDao {
	
	private BaseDao baseDao;

	@Override
	public List<User_security> queryAllUser_securitys() {
		return  baseDao.listAll("User_security");
	}

	@Override
	public List<User_security> queryAllUser_securitysByPage(int start, int limit) {
		return baseDao.queryPage("from User_security", start, limit);
	}

	@Override
	public int queryUser_securityAmount() {
		return baseDao.listAll("User_security").size();
	}

	@Override
	public User_security queryUser_security(User_security user) {
		return (User_security) baseDao.loadObject("from User_security where userName='" + user.getUserName() + "' and userPsw='" + user.getUserPsw() + "' and is_del = 1");
	}

	@Override
	public User_security queryUser_securityByName(String userName) {
		return (User_security) baseDao.loadObject("from User_security where userName='"+ userName +"'and is_del = 1");
	}

	@Override
	public boolean updateUser_security(User_security user) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean addUser_security(User_security user) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean deleteUser_security(User_security user) {
		boolean state=false;
		try {
			user.setIs_del(0);
			baseDao.saveOrUpdate(user);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
