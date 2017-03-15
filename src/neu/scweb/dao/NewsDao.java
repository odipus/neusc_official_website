package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.News;
import neu.scweb.po.Section;

public interface NewsDao {
	public List<News> queryAllNews();
	public boolean saveOrUpdateNews(News news);
	public News queryNews(News news);
	public News queryNewsById(int newsId);
	public boolean deleteNews(News news);
	public List<News> queryAuthNews(List<Section> authSect);
	public List<News> queryAuthNewsByPage(List<Section> authSect, int start, int limit);
	public List<News> queryNewsByPage(int start, int limit);
	public int queryNewsAmount(List<Integer> authSectId);

	public List<News> queryNewsBySectionId(int sectionId,int page, int size);
	public List<News> queryNotice(int page, int size);
	public int queryNewsAmountBySectionId(int sectionId);
	public int queryNoticeAmount();
	public List<News> queryPicturenews(int page, int size);
	public List queryNoticeBySectionId(int sectionId, int page, int size);
	public List queryAttachedNews(int page, int size);
	public List queryPicturenewsBySectionId(int sectionId, int page, int size);
	public int queryAttachedNewsAmount();
	public List<News> queryAttachedNewsBySectionId(int page, int size,int sectionId);
	
	public List<News> searchNewsTitle(String search);
	public List<News> searchNewsContent(String search);

}
