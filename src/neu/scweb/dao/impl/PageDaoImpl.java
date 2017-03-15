package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.PageDao;
import neu.scweb.po.Page;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;

@Component(value="pageDao")
public class PageDaoImpl implements PageDao{

	private BaseDao baseDao;
	
	public boolean saveOrUpdatePage(Page p) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(p);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	

	public boolean deletePage(int pageId) {
		boolean state=false;
		Page pa=(Page) baseDao.loadObject("from Page where pageId=" + pageId);
		try {
			baseDao.delete(pa);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public Page queryPageById(int pageId) {
	
		return (Page) baseDao.loadObject("from Page where pageId=" + pageId);
	}


	public List<Page> queryAllList() {
	
		return baseDao.query("from Page where isList = 1");
	}


	public List<Page> queryPagesByUpperPage(int upperPage) {
		
		return baseDao.query("from Page where isList=0 and upperPage =" + upperPage);
	}


	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}




}
