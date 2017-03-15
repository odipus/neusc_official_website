package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.EngPageDao;
import neu.scweb.po.EngPage;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;


@Component(value="engPageDao")
public class EngPageDaoImpl implements EngPageDao {

	private BaseDao baseDao;
	
	public boolean saveOrUpdatePage(EngPage p) {
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
		EngPage pa=(EngPage) baseDao.loadObject("from EngPage where pageId=" + pageId);
		try {
			baseDao.delete(pa);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	
	public EngPage queryPageById(int pageId) {
	
		return (EngPage) baseDao.loadObject("from EngPage where pageId=" + pageId);
	}


	@SuppressWarnings("unchecked")
	public List<EngPage> queryAllList() {
	
		return baseDao.query("from EngPage where isList = 1");
	}


	@SuppressWarnings("unchecked")
	public List<EngPage> queryPagesByUpperPage(int upperPage) {
		
		return baseDao.query("from EngPage where isList=0 and upperPage =" + upperPage);
	}



	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}







}
