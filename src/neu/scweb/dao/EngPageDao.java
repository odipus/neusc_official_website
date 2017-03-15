package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.EngPage;
import neu.scweb.po.Page;

public interface EngPageDao {
	public EngPage queryPageById(int pageId);
	public List<EngPage> queryAllList();
	public List<EngPage> queryPagesByUpperPage(int upperPage);
	public boolean saveOrUpdatePage(EngPage engPage);
	public boolean deletePage(int pageId);
}
