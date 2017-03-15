package neu.scweb.service;

import java.util.List;

import neu.scweb.po.EngPage;

public interface EngPageService {
	public EngPage queryPageById(int pageId);
	public List<EngPage> queryAllList();
	public List<EngPage> queryPagesByUpperPage(int upperPage);
	public boolean saveOrUpdatePage(EngPage engPage);
	public boolean deletePage(int pageId);
}
