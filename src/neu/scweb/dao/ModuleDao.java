package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.Module;

public interface ModuleDao {
	public Module queryModByCode(String moduleCode);
	public Module queryModByName(String moduleName);
	public List<Module> queryAllModules();
}
