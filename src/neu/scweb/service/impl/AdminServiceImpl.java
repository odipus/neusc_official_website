package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.AdminDao;
import neu.scweb.po.Admin;
import neu.scweb.service.AdminService;

@Component(value="adminService")
public class AdminServiceImpl implements AdminService{

	private AdminDao adminDao;

	public boolean adminLogin(Admin admin) {
		return adminDao.adminLogin(admin);
	}

	public Admin queryAdmin(Admin admin) {
		return adminDao.queryAdmin(admin);
	}
	public boolean adminUpdate(Admin admin) {
		return adminDao.adminUpdate(admin);
	}

	public List<Admin> queryAllAdmins() {
		return adminDao.queryAllAdmins();
	}


	@Resource(name="adminDao")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
