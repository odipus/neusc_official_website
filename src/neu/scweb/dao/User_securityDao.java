package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.User_security;

public interface User_securityDao {
	public List<User_security> queryAllUser_securitys();

	public List<User_security> queryAllUser_securitysByPage(int start, int limit);

	public int queryUser_securityAmount();

	public User_security queryUser_security(User_security user);

	public User_security queryUser_securityByName(String userName);

	public boolean updateUser_security(User_security user);

	public boolean addUser_security(User_security user);

	public boolean deleteUser_security(User_security user);

}
