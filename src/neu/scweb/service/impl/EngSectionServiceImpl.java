package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.EngSectionDao;
import neu.scweb.po.EngSection;
import neu.scweb.service.EngSectionService;

@Component(value="engSectionService")
public class EngSectionServiceImpl implements EngSectionService {

	private EngSectionDao engSectionDao;

	public EngSection querySectionByName(String newsSection) {

		return engSectionDao.querySectionByName(newsSection);
	}

	public List<EngSection> queryAllSections() {

		return engSectionDao.queryAllSections();
	}
	
	@Resource(name="engSectionDao")
	public void setEngSectionDao(EngSectionDao engSectionDao) {
		this.engSectionDao = engSectionDao;
	}

}
