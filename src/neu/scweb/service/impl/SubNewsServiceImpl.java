package neu.scweb.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import neu.scweb.dao.SubNewsDao;
import neu.scweb.po.SubNews;
import neu.scweb.service.SubNewsService;

@Component(value="subNewsService")
public class SubNewsServiceImpl implements SubNewsService {

	private SubNewsDao subNewsDao;

	public List queryAllSubNews() {
		return subNewsDao.queryAllSubNews();
	}

	public List querySubNewsBySite(String subSiteCode) {
		return subNewsDao.querySubNewsBySite(subSiteCode);
	}

	public boolean saveSubNews(SubNews subNews) {
		return subNewsDao.saveSubNews(subNews);
	}

	public SubNews querySubNews(SubNews subNews) {
		return subNewsDao.querySubNews(subNews);
	}

	public boolean deleteSubNews(SubNews subNews) {
		return subNewsDao.deleteSubNews(subNews);
	}

	public SubNews querySubNewsById(int subNewsId) {
		return subNewsDao.querySubNewsById(subNewsId);
	}

	public List<SubNews> queryNewsBySubSiteId(int subSiteId, int page, int size) {
		return subNewsDao.queryNewsBySubSiteId(subSiteId, page, size);
	}


	public int queryNewsAmountBySubSiteId(int subSiteId) {
		return subNewsDao.queryNewsAmountBySubSiteId(subSiteId);
	}


	public List<SubNews> queryNotice(int page, int size) {
		return subNewsDao.queryNotice(page,size);
	}


	public int queryNoticeAmount() {
		return subNewsDao.queryNoticeAmount();
	}


	public List<SubNews> queryPicturenews(int page, int size) {
		return subNewsDao.queryPicturenews(page, size);
	}


	public boolean saveOrUpdateNews(SubNews subNews) {
		return subNewsDao.saveOrUpdateNews(subNews);
	}

	public List<SubNews> querySubNewsBySitePage(String subSiteCode, int start, int limit) {
		return subNewsDao.querySubNewsBySitePage(subSiteCode, start, limit);
	}

	public List queryNotice(int subSiteId, int page, int size) {
		return subNewsDao.queryNotice(subSiteId,page,size);
	}

	public int queryNoticeAmount(int subSiteId) {
		return subNewsDao.queryNoticeAmount(subSiteId);
	}

	public List queryPicturenews(int subSiteId, int page, int size) {
		return subNewsDao.queryPicturenews(subSiteId, page, size);
	}

	@Resource(name="subNewsDao")
	public void setNewsDao(SubNewsDao subNewsDao) {
		this.subNewsDao = subNewsDao;
	}




}
