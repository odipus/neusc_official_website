package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.GuideDao;
import neu.scweb.po.Guide;
import neu.scweb.service.GuideService;

@Component(value="guideService")
public class GuideServiceImpl implements GuideService {
	private GuideDao guideDao;


	public List<Guide> queryGuidesByLevel(int guideLevel) {
		return guideDao.queryGuidesByLevel(guideLevel);
	}


	public List<Guide> queryLowerGuides(int guideId) {

		return guideDao.queryLowerGuides(guideId);
	}

	public Guide queryGuideById(int guideId) {

		return guideDao.queryGuideById(guideId);
	}

	public Guide queryGuideByTitle(String guideTitle) {

		return guideDao.queryGuidesByTitle(guideTitle);
	}

	public List<Guide> queryAllGuides() {
		return guideDao.queryAllGuides();
	}

	@Resource(name="guideDao")
	public void setNewsDao(GuideDao guideDao) {
		this.guideDao = guideDao;
	}



}
