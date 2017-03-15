package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.Admin;

public interface AdminDao {
	public boolean adminLogin(Admin admin);
	public Admin queryAdmin(Admin admin);
	public boolean adminUpdate(Admin admin);
	public List<Admin> queryAllAdmins();
}
