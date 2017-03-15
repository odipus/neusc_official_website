package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.ModuleDao;
import neu.scweb.po.Module;
import neu.scweb.util.BaseDao;

@Component(value="moduleDao")
public class ModuleDaoImpl implements ModuleDao {

	private BaseDao baseDao;
	
	public Module queryModByCode(String moduleCode) {
		return (Module) baseDao.loadObject("from Module where moduleCode='" + moduleCode + "'");
	}

	public Module queryModByName(String moduleName) {
		return (Module) baseDao.loadObject("from Module where moduleName='" + moduleName + "'");
	}

	public List<Module> queryAllModules() {
		return baseDao.listAll("Module");
	}
	
	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	
}
