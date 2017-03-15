package neu.scweb.service;

import java.util.List;

import neu.scweb.po.EngSection;

public interface EngSectionService {

	public EngSection querySectionByName(String newsSection);
	public List<EngSection> queryAllSections();

}
