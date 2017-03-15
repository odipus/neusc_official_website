package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.SectionDao;
import neu.scweb.po.Section;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;


@Component(value="sectionDao")
public class SectionDaoImpl implements SectionDao {

	private BaseDao baseDao;

	public boolean saveOrUpdateSections(Section section) {
		boolean state = false;
		try {
			baseDao.saveOrUpdate(section);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@SuppressWarnings("unchecked")
	public List<Section> queryAllSections() {
		return this.baseDao.listAll("Section");
	}
	

	public List<Section> querySectionsNotUpper() {
		return baseDao.query("from Section where isUpperSection=0" );
	}


	public boolean deleteSection(Section section) {
		boolean state=false;
		try {
			baseDao.delete(section);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Section querySection(Section section) {
		return (Section) baseDao.loadObject("from Section where sectionName='" + section.getSectionName() + "' and sectionCode='" + section.getSectionCode() + "'" );
	}

	public boolean updateSection(Section section) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(section);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Section querySectionByName(String sectionName) {
		System.out.println("调用sectionDao  querysectionByName  参数是"+sectionName);
		return (Section) baseDao.loadObject("from Section where sectionName='" + sectionName + "'" );
	}

	public Section querySectionBySectId(int sectionId) {
		
		return (Section) baseDao.loadObject("from Section where sectionId=" + sectionId);

	}



	public List<Section> querySectionsByPlace(String place) {

		return baseDao.query("from Section where sectionPlace='"+ place+"' order by sectionOrder desc" );
	
		
	}

	public List<Section> queryAllSectionsByPage(int start, int limit) {
		return baseDao.queryPage("from Section", start, limit);
	}

	public int querySectionAmount() {
		return baseDao.listAll("Section").size();
	}

	public Section querySectionByCode(String sectionCode) {
		return (Section) baseDao.loadObject("from Section where sectionCode='" + sectionCode + "'");
	}

	public List querySectionByRole(int roleId) {
		return baseDao.query("select section from Role r join r.sections section where r.roleId=" + roleId);
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}



}
