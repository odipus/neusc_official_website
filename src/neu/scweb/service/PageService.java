package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Page;

public interface PageService {
	public Page queryPageById(int pageId);
	public List<Page> queryAllList();
	public List<Page> queryPagesByUpperPage(int upperPage);
	public boolean saveOrUpdatePage(Page page);
	public boolean deletePage(int pageId);

}
