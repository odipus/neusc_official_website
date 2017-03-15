package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.EngSectionDao;
import neu.scweb.po.EngSection;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;


@Component(value="engSectionDao")
public class EngSectionDaoImpl implements EngSectionDao {

	private BaseDao baseDao;
	
	public EngSection querySectionByName(String newsSection) {

		return (EngSection) baseDao.loadObject("from EngSection where sectionName='" + newsSection + "'" );
	}

	
	@SuppressWarnings("unchecked")
	public List<EngSection> queryAllSections() {
	
		return this.baseDao.listAll("EngSection");
	}
	
	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
