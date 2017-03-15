package neu.scweb.dao;
import java.util.List;

import neu.scweb.po.SubNews;
import neu.scweb.po.SubSite;
public interface SubNewsDao {
	public boolean saveSubNews(SubNews subNews);

	public boolean deleteSubNews(SubNews subNews);

	public boolean saveOrUpdateNews(SubNews subNews);

	public SubNews querySubNews(SubNews subNews);
	public SubNews querySubNewsById(int subNewsId);
	public int queryNewsAmountBySubSiteId(int subSiteId);
	public int queryNoticeAmount();
	public List<SubNews> queryAllSubNews();
	public List<SubNews> querySubNewsBySite(String subSiteCode);
	public List<SubNews> queryNewsBySubSiteId(int subSiteId,int page,int size);
	public List<SubNews> queryNotice(int page, int size);
	public List<SubNews> queryPicturenews(int page, int size);
	public List<SubNews> querySubNewsBySitePage(String subSiteCode, int start, int limit);
	public List queryNotice(int subSiteId, int page, int size);
	public int queryNoticeAmount(int subSiteId);
	public List queryPicturenews(int subSiteId, int page, int size);

}
