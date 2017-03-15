package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.EngSection;

public interface EngSectionDao {

	public EngSection querySectionByName(String newsSection);

	public List<EngSection> queryAllSections();

}
