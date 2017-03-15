package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Section;

public interface SectionService {
	public boolean saveOrUpdateSections(Section section);
	public List<Section> queryAllSections();
	public List<Section> queryAllSectionsByPage(int start, int limit);
	public int querySectionAmount();
	public boolean deleteSection(Section section);
	public Section querySection(Section section);
	public boolean updateSection(Section section);
	public Section querySectionByName(String sectionName);
	public List<Section> querySectionsByPlace(String place);
	public Section querySectionBySectId(int sectionId);
	public Section querySectionByCode(String sectionCode);
	public List<Section> querySectionByRole(int roleId);
	public List querySectionsNotUpper();
}
