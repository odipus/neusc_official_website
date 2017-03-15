package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.SectionDao;
import neu.scweb.po.Section;
import neu.scweb.service.SectionService;

@Component(value="sectionService")
public class SectionServiceImpl implements SectionService{

	private SectionDao sectionDao;

	public boolean saveOrUpdateSections(Section section) {
		return sectionDao.saveOrUpdateSections(section);
	}
	

	@Override
	public List querySectionsNotUpper() {
		return sectionDao.querySectionsNotUpper();
	}

	public List<Section> queryAllSections() {
		return this.sectionDao.queryAllSections();
	}

	public boolean deleteSection(Section section) {
		return sectionDao.deleteSection(section);
	}

	public Section querySection(Section section) {
		return sectionDao.querySection(section);
	}

	public boolean updateSection(Section section) {
		return sectionDao.updateSection(section);
	}

	public Section querySectionByName(String sectionName) {
		return sectionDao.querySectionByName(sectionName);
	}

	public List<Section> querySectionsByPlace(String place) {
		return this.sectionDao.querySectionsByPlace(place);
	}


	public Section querySectionBySectId(int sectionId) {
		return sectionDao.querySectionBySectId(sectionId);
	}

	public List<Section> queryAllSectionsByPage(int start, int limit) {
		return sectionDao.queryAllSectionsByPage(start, limit);
	}

	public int querySectionAmount() {
		return sectionDao.querySectionAmount();
	}

	public Section querySectionByCode(String sectionCode) {
		return sectionDao.querySectionByCode(sectionCode);
	}

	public List querySectionByRole(int roleId) {
		return sectionDao.querySectionByRole(roleId);
	}

	@Resource(name="sectionDao")
	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}



}
