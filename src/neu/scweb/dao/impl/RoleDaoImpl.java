package neu.scweb.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import neu.scweb.dao.RoleDao;
import neu.scweb.po.Role;
import neu.scweb.po.SubSite;
import neu.scweb.util.BaseDao;

@Component(value="roleDao")
public class RoleDaoImpl implements RoleDao {

	private BaseDao baseDao;

	public List<Role> queryAllRoles() {
		return baseDao.listAll("Role");
	}

	public List<Role> queryComboRoles() {
		return baseDao.query("select new Role(role.roleId,role.roleName) from Role as role");
	}

	public Role queryRoleByName(String roleName) {
		return (Role) baseDao.loadObject("from Role where roleName='" + roleName + "'");
	}

	public boolean saveOrUpdateRole(Role role) {
		boolean state = false;
		try {
			System.out.println("添加角色信息" +role.getRoleName());
			baseDao.saveOrUpdate(role);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean deleteRole(Role role) {
		boolean state = false;
		try {
			baseDao.delete(role);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Role queryRoleById(int roleId) {
		return (Role)baseDao.loadObject("from Role where roleId=" + roleId);
	}

	public List<SubSite> querySubByRole(int roleId) {
		return baseDao.query("select subSite.subSiteCode from Role r join r.subSites subSite where r.roleId=" + roleId);
	}

	public boolean mergeRole(Role role) {
		boolean state = false;
		try {
			baseDao.update(role);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<Role> queryAllRolesByPage(int start, int limit) {
		return baseDao.queryPage("from Role", start, limit);
	}

	public int queryRoleAmount() {
		return baseDao.listAll("Role").size();
	}

	public boolean addRoleByMod(int roleId, Set ms) {
		boolean state = false;
		try {
			Iterator iterator = ms.iterator();
			while(iterator.hasNext()) {
				baseDao.createQuery("insert into role_module (roleId, moduleId) value("+ roleId +","+ Integer.parseInt((String)iterator.next()) +")");
			}
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean addRoleBySect(int roleId, Set sects) {
		boolean state = false;
		try {
			Iterator iterator = sects.iterator();
			while(iterator.hasNext()) {
				baseDao.createQuery("insert into role_section (roleId, sectionId) value("+ roleId +","+ Integer.parseInt((String)iterator.next()) +")");
			}
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean addRoleBySub(int roleId, Set subSites) {
		boolean state = false;
		try {
			Iterator iterator = subSites.iterator();
			while(iterator.hasNext()) {
				baseDao.createQuery("insert into role_subsite (roleId, subSiteId) value("+ roleId +","+ (Integer)iterator.next() +")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}
