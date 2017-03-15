package neu.scweb.service;

import java.util.List;

import neu.scweb.po.User;

public interface UserService {
	public List<User> queryAllUsers();
	public List<User> queryAllUsersByPage(int start, int limit);
	public int queryUserAmount();
	public User queryUser(User user);
	public boolean updateUser(User user);
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public User queryUserByName(String userName);
	
}
