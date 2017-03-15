package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.User_securityDao;
import neu.scweb.po.User_security;
import neu.scweb.service.User_securityService;

@Component(value = "user_securityService")
public class User_securityServiceImpl implements User_securityService {

	private User_securityDao user_securityDao;

	@Override
	public List<User_security> queryAllUser_securitys() {
		return user_securityDao.queryAllUser_securitys();
	}

	@Override
	public List<User_security> queryAllUser_securitysByPage(int start, int limit) {
		return user_securityDao.queryAllUser_securitysByPage(start, limit);
	}

	@Override
	public int queryUser_securityAmount() {
		return user_securityDao.queryUser_securityAmount();
	}

	@Override
	public User_security queryUser_security(User_security user) {
		return user_securityDao.queryUser_security(user);
	}

	@Override
	public User_security queryUser_securityByName(String userName) {
		return user_securityDao.queryUser_securityByName(userName);
	}

	@Override
	public boolean updateUser_security(User_security user) {
		return user_securityDao.updateUser_security(user);
	}

	@Override
	public boolean addUser_security(User_security user) {
		user.setIs_del(1);
		return user_securityDao.addUser_security(user);
	}

	@Override
	public boolean deleteUser_security(User_security user) {
		return user_securityDao.deleteUser_security(user);
	}

	@Resource(name = "user_securityDao")
	public void setUser_securityDao(User_securityDao user_securityDao) {
		this.user_securityDao = user_securityDao;
	}

}
