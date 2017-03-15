package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.User;

public interface UserDao {
	public List<User> queryAllUsers();
	public List<User> queryAllUsersByPage(int start, int limit);
	public int queryUserAmount();
	public User queryUser(User user);
	public User queryUserByName(String userName);
	public boolean updateUser(User user);
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public String transUser(String chnName);
}
