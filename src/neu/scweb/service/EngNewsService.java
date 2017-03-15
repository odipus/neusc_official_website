package neu.scweb.service;

import java.util.List;

import neu.scweb.po.EngNews;
import neu.scweb.po.News;
import neu.scweb.po.Section;

public interface EngNewsService {

	public List<EngNews> queryAllNews();

	public int queryNewsAmount();

	public List<EngNews> queryNewsByPage(int start, int limit);

	public boolean saveOrUpdateNews(EngNews engNews);

	public boolean deleteNews(EngNews engNews);

	public EngNews queryNewsById(int newsId);
	
	public EngNews queryNewsByOrigId(int origNewsId);

	public List<EngNews> queryNewsBySectionId(int sectionId, int page, int size);

	public int queryNewsAmountBySectionId(int sectionId);

	public int queryNoticeAmount();

	public List<EngNews> queryPicturenews(int page, int size);

	public List<EngNews> queryPicturenewsBySectionId(int sectionId, int page,int size);

	public List<EngNews> queryNotice(int page, int size);

	public List<EngNews> queryAttachedNews(int page, int size);

	public List<EngNews> queryAttachedNewsBySectionId(int page, int size,int sectionId);

	public List<EngNews> queryNoticeBySectionId(int sectionId, int page,int size);

	public List<EngNews> queryNewsUndetermined(int start, int limit);

	public List<EngNews> queryNewsUnderTrans(int start, int limit);

	public EngNews queryNews(EngNews engNews);

	public boolean convertNews(News news);

	public List<EngNews> queryAllNewsByPage(int start, int limit);
	

	public List<EngNews> queryNewsTrans(int start, int limit);

	public int queryNewsTransAmount();
	
	public void buildJsp();

	public EngNews queryPoint();
	
	

}
