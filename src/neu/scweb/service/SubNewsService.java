package neu.scweb.service;

import java.util.List;

import neu.scweb.po.SubNews;

public interface SubNewsService {
	public List<SubNews> queryAllSubNews();
	public List<SubNews> querySubNewsBySite(String subSiteCode);
	public boolean saveSubNews(SubNews subNews);
	public SubNews querySubNews(SubNews subNews);
	public boolean deleteSubNews(SubNews subNews);
	public SubNews querySubNewsById(int subNewsId);
	public List<SubNews> queryNewsBySubSiteId(int subSiteId,int page,int size);
	public int queryNewsAmountBySubSiteId(int subSiteId);
	public List<SubNews> queryNotice(int page, int size);
	public int queryNoticeAmount();
	public List<SubNews> queryPicturenews(int page, int size);
	public boolean saveOrUpdateNews(SubNews subNews);
	public List<SubNews> querySubNewsBySitePage(String subSiteCode, int start, int limit);
	public List<SubNews> queryPicturenews(int subSiteId, int page, int size);
	public List<SubNews> queryNotice(int subSiteId, int page, int size);
	public int queryNoticeAmount(int subSiteId);
}
