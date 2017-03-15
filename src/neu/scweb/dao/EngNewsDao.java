package neu.scweb.dao;

import java.util.List;


import neu.scweb.po.EngNews;


public interface EngNewsDao {

	public List<EngNews> queryAllNews();

	public List<EngNews> queryNewsByPage(int start, int limit);

	public int queryNewsAmount();

	public boolean saveOrUpdateNews(EngNews engNews);

	public EngNews queryNews(EngNews engNews);

	public boolean deleteNews(EngNews engNews);

	public List<EngNews> queryNewsUndetermined(int start, int limit);

	public List<EngNews> queryNewsUnderTrans(int start, int limit);

	public EngNews queryNewsById(int newsId);
	
	public EngNews queryNewsByOrigId(int origNewsId);

	public List<EngNews> queryAllNewsByPage(int start, int limit);

	public List<EngNews> queryNewsTrans(int start, int limit);

	public int queryNewsTransAmount();

	public List<EngNews> queryNotice(int page, int size);
	
	public List queryNoticeBySectionId(int sectionId, int page, int size);

	public EngNews queryPoint();
	
	public List<EngNews> queryPicturenews(int page, int size);

	public List<EngNews> queryNewsBySectionId(int sectionId, int page, int size);

	public int queryNewsAmountBySectionId(int sectionId);
	
	public int queryNoticeAmount();

}
