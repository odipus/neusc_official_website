package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.AuthPrivilegeDao;
import neu.scweb.po.Module;
import neu.scweb.service.AuthPrivilegeService;

@Component(value="authPrivilegeService")
public class AuthPrivilegeServiceImpl implements AuthPrivilegeService {

	private AuthPrivilegeDao apDao;

	public List<Module> queryModByRoleId(int roleId) {
		return apDao.queryModByRoleId(roleId);
	}

	public List querySectByRoleId(int roleId) {
		return apDao.querySectByRoleId(roleId);
	}

	@Resource(name="authPrivilegeDao")
	public void setApDao(AuthPrivilegeDao apDao) {
		this.apDao = apDao;
	}


}
