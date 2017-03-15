package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.EngPageDao;
import neu.scweb.po.EngPage;
import neu.scweb.service.EngPageService;

import org.springframework.stereotype.Component;


@Component(value="engPageService")
public class EngPageServiceImpl implements EngPageService {

	private EngPageDao engPageDao;

	public boolean saveOrUpdatePage(EngPage page) {
		
		return engPageDao.saveOrUpdatePage(page);	
	}


	public boolean deletePage(int pageId) {
		
		return engPageDao.deletePage(pageId);
		
	}

	public EngPage queryPageById(int pageId) {
	
		return engPageDao.queryPageById(pageId);
	}

	public List<EngPage> queryAllList() {
		
		return engPageDao.queryAllList();
	}

	public List<EngPage> queryPagesByUpperPage(int upperPage) {

		return engPageDao.queryPagesByUpperPage(upperPage);
	}


	@Resource(name="engPageDao")
	public void setEngPageDao(EngPageDao engPageDao) {
		this.engPageDao = engPageDao;
	}
}
