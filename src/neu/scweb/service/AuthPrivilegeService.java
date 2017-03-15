package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Module;
import neu.scweb.po.Section;

public interface AuthPrivilegeService {
	public List<Module> queryModByRoleId(int roleId);
	public List<Section> querySectByRoleId(int roleId);
}
