package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.ModuleDao;
import neu.scweb.po.Module;
import neu.scweb.service.ModuleService;

@Component(value="moduleService")
public class ModuleServiceImpl implements ModuleService {

	private ModuleDao moduleDao;

	public Module queryModByCode(String moduleCode) {
		return moduleDao.queryModByCode(moduleCode);
	}

	public Module queryModByName(String moduleName) {
		return moduleDao.queryModByName(moduleName);
	}

	public List<Module> queryAllModules() {
		return moduleDao.queryAllModules();
	}

	
	@Resource(name="moduleDao")
	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}


}
