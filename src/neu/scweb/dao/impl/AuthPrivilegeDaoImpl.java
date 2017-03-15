package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.AuthPrivilegeDao;
import neu.scweb.po.Module;
import neu.scweb.util.BaseDao;

@Component(value="authPrivilegeDao")
public class AuthPrivilegeDaoImpl implements AuthPrivilegeDao{

	private BaseDao baseDao;

	public List queryModByRoleId(int roleId) {
		return baseDao.query("select module from Role r join r.modules module where r.roleId=" + roleId);
	}

	public List querySectByRoleId(int roleId) {
		return baseDao.query("select section from Role r join r.sections section where r.roleId=" + roleId);
	}

	public List querySectIdByRole(int roleId) {
		return baseDao.query("select section.sectionId from Role r join r.sections section where r.roleId=" + roleId);
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}
