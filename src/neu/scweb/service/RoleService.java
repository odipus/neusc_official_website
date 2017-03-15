package neu.scweb.service;

import java.util.List;
import java.util.Set;

import neu.scweb.po.Role;
import neu.scweb.po.SubSite;


public interface RoleService {
	public List<Role> queryAllRoles();
	public List<Role> queryComboRoles();
	public List<Role> queryAllRolesByPage(int start, int limit);
	public int queryRoleAmount();
	public Role queryRoleByName(String roleName);
	public boolean saveOrUpdateRole(Role role);
	public boolean deleteRole(Role role);
	public Role queryRoleById(int roleId);
	public List<SubSite> querySubByRole(int roleId);
	public boolean mergeRole(Role role);
	public boolean addRoleByMod(int roleId, Set ms);
	public boolean addRoleBySect(int roleId, Set sects);
	public boolean addRoleBySub(int roleId, Set subSites);
}
