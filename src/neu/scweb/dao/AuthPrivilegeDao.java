package neu.scweb.dao;

import java.util.List;

public interface AuthPrivilegeDao {
	public List queryModByRoleId(int roleId);
	public List querySectByRoleId(int roleId);
	public List querySectIdByRole(int roleId);
}
