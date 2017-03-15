package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Admin;

public interface AdminService {
	public boolean adminLogin(Admin admin);
	public Admin queryAdmin(Admin admin);
	public boolean adminUpdate(Admin admin);
	public List<Admin> queryAllAdmins();
}
