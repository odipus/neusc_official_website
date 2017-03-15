package neu.scweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.GuideDao;
import neu.scweb.po.Guide;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;

@Component(value="guideDao")
public class GuideDaoImpl implements GuideDao {
	private BaseDao baseDao;


	public List<Guide> queryAllGuides() {
		return baseDao.listAll("Guide");
	}

	public List<Guide> queryGuidesByLevel(int guideLevel) {
		return baseDao.query("from Guide where guideLevel="+guideLevel);
	}


	public List<Guide> queryLowerGuides(int guideId) {
		return baseDao.query("from Guide where upperLevel="+guideId);	
	}


	public Guide queryGuideById(int guideId) {
		return (Guide) baseDao.loadObject("from Guide where guideId="+guideId);
	}

	public Guide queryGuidesByTitle(String guideTitle) {
		return (Guide) baseDao.loadObject("from Guide where guideTitle='"+guideTitle+"'");
	}




	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}



}
