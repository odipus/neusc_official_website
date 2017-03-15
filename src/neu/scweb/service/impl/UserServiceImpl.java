package neu.scweb.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import neu.scweb.dao.UserDao;
import neu.scweb.po.User;
import neu.scweb.service.UserService;

@Component(value="userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public List<User> queryAllUsers() {
		return userDao.queryAllUsers();
	}

	public User queryUser(User user) {
		return userDao.queryUser(user);
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	public boolean deleteUser(User user) {
		return userDao.deleteUser(user);
	}

	public List<User> queryAllUsersByPage(int start, int limit) {
		return userDao.queryAllUsersByPage(start, limit);
	}

	public int queryUserAmount() {
		return userDao.queryUserAmount();
	}

	public User queryUserByName(String userName) {
		return userDao.queryUserByName(userName);
	}


	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
