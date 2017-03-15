package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Module;

public interface ModuleService {
	public Module queryModByCode(String moduleCode);
	public Module queryModByName(String moduleName);
	public List<Module> queryAllModules();
}
