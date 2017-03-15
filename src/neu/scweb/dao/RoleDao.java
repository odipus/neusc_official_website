package neu.scweb.dao;

import java.util.List;
import java.util.Set;

import neu.scweb.po.Role;
import neu.scweb.po.SubSite;

public interface RoleDao {
	public List<Role> queryAllRoles();
	public List<Role> queryAllRolesByPage(int start, int limit);
	public int queryRoleAmount();
	public List<Role> queryComboRoles();
	public Role queryRoleByName(String roleName);
	public boolean saveOrUpdateRole(Role role);
	public boolean deleteRole(Role role);
	public boolean mergeRole(Role role);
	public Role queryRoleById(int roleId);
	public List<SubSite> querySubByRole(int roleId);
	public boolean addRoleByMod(int roleId, Set ms);
	public boolean addRoleBySect(int roleId, Set sects);
	public boolean addRoleBySub(int roleId, Set subSites);
}
