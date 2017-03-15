package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.PageDao;
import neu.scweb.po.Page;
import neu.scweb.service.PageService;

@Component(value="pageService")
public class PageServiceImpl implements PageService {

	private PageDao pageDao;
	

	public boolean saveOrUpdatePage(Page page) {
		
		return pageDao.saveOrUpdatePage(page);	
	}


	public boolean deletePage(int pageId) {
		
		return pageDao.deletePage(pageId);
		
	}

	public Page queryPageById(int pageId) {
	
		return pageDao.queryPageById(pageId);
	}

	public List<Page> queryAllList() {
		
		return pageDao.queryAllList();
	}

	public List<Page> queryPagesByUpperPage(int upperPage) {

		return pageDao.queryPagesByUpperPage(upperPage);
	}

	@Resource(name="pageDao")
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}



}
