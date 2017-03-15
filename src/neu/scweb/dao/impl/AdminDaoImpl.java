package neu.scweb.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import neu.scweb.dao.AdminDao;
import neu.scweb.po.Admin;
import neu.scweb.util.BaseDao;

@Component(value="adminDao")
public class AdminDaoImpl implements AdminDao{

	private BaseDao baseDao;

	public boolean adminLogin(Admin admin) {
		if(baseDao.query("from Admin where adminName='" + admin.getAdminName() + "' and adminPsw='" + admin.getAdminPsw() + "'").isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
	/*
	public Admin queryAdmin(Admin admin) {
		 Admin adminTmp = null;
		 List list = this.baseDao.query("from Admin where adminName='" + admin.getAdminName() + "' and adminPsw='" + admin.getAdminPsw() + "'");
		 Iterator it = list.iterator();
		 while(it.hasNext()) {
			 adminTmp = (Admin) it.next();
		 }
		 return adminTmp;
	}
	*/

	public Admin queryAdmin(Admin admin) {
		 return (Admin)baseDao.loadObject("from Admin where adminName='" + admin.getAdminName() + "' and adminPsw='" + admin.getAdminPsw() + "'");
	}

	public boolean adminUpdate(Admin admin) {
		boolean state = false;
		try {
			this.baseDao.saveOrUpdate(admin);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> queryAllAdmins() {
		return baseDao.listAll("Admin");
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}




}
