package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.FeatureDao;
import neu.scweb.dao.ModuleDao;
import neu.scweb.po.Feature;
import neu.scweb.po.Module;
import neu.scweb.util.BaseDao;

@Component(value="featureDao")
public class FeatureDaoImpl implements FeatureDao {

	private BaseDao baseDao;
	private ModuleDao moduleDao;

	public List<Feature> queryNewsFea() {
		Module m = moduleDao.queryModByCode("newsCtrl");
		return baseDao.query("from Feature where moduleId=" + m.getModuleId());
	}

	public List<Feature> querySectionFea() {
		Module m = moduleDao.queryModByCode("sectionCtrl");
		return baseDao.query("from Feature where moduleId=" + m.getModuleId());
	}

	public List<Feature> querySysFea() {
		Module m = moduleDao.queryModByCode("sysCtrl");
		return baseDao.query("from Feature where moduleId=" + m.getModuleId());
	}

	public List<Feature> queryAllFeas() {
		return baseDao.listAll("Feature");
	}

	public List<Feature> queryFeaByModId(int modId) {
		return baseDao.query("from Feature where moduleId=" + modId);
	}
	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Resource(name="moduleDao")
	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}


}
