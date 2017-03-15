package neu.scweb.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import neu.scweb.dao.RoleDao;
import neu.scweb.po.Role;
import neu.scweb.po.SubSite;
import neu.scweb.service.RoleService;

@Component(value="roleService")
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;

	public List<Role> queryAllRoles() {
		return roleDao.queryAllRoles();
	}

	public List<Role> queryComboRoles() {
		return roleDao.queryComboRoles();
	}

	public Role queryRoleByName(String roleName) {
		return roleDao.queryRoleByName(roleName);
	}

	public boolean saveOrUpdateRole(Role role) {
		return roleDao.saveOrUpdateRole(role);
	}

	public boolean deleteRole(Role role) {
		return roleDao.deleteRole(role);
	}

	public Role queryRoleById(int roleId) {
		return (Role)roleDao.queryRoleById(roleId);
	}

	public List<SubSite> querySubByRole(int roleId) {
		return roleDao.querySubByRole(roleId);
	}

	public boolean mergeRole(Role role) {
		return roleDao.mergeRole(role);
	}

	public List<Role> queryAllRolesByPage(int start, int limit) {
		return roleDao.queryAllRolesByPage(start, limit);
	}

	public int queryRoleAmount() {
		return roleDao.queryRoleAmount();
	}
	
	public boolean addRoleByMod(int roleId, Set ms) {
		return roleDao.addRoleByMod(roleId, ms);
	}

	public boolean addRoleBySect(int roleId, Set sects) {
		return roleDao.addRoleBySect(roleId, sects);
	}

	public boolean addRoleBySub(int roleId, Set subSites) {
		return roleDao.addRoleBySub(roleId, subSites);
	}
	
	@Resource(name="roleDao")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	
}
