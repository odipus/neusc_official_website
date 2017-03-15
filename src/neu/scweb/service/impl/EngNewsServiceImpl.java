package neu.scweb.service.impl;

import java.util.List;



import javax.annotation.Resource;

import neu.scweb.dao.AuthPrivilegeDao;
import neu.scweb.dao.EngNewsDao;
import neu.scweb.dao.EngSectionDao;
import neu.scweb.dao.SectionDao;
import neu.scweb.dao.UserDao;
import neu.scweb.po.EngNews;
import neu.scweb.po.News;
import neu.scweb.po.Section;
import neu.scweb.service.EngNewsService;
import neu.scweb.service.EngSectionService;
import neu.scweb.util.BuildEngJsp;
import neu.scweb.util.BuildJsp;

import org.springframework.stereotype.Component;

@Component(value="engNewsService")
public class EngNewsServiceImpl implements EngNewsService {
	private SectionDao sectionDao;
	private EngNewsDao engNewsDao;
	private UserDao userDao;
	EngSectionDao engSecDao;
	
	
	public List<EngNews> queryAllNews() {
		return engNewsDao.queryAllNews();
	}
	

	public List<EngNews> queryAllNewsByPage(int start, int limit) {
		
		return engNewsDao.queryAllNewsByPage(start, limit);
	}

	public List<EngNews> queryNewsUndetermined(int start, int limit) {
		
		return engNewsDao.queryNewsUndetermined(start,limit);
	}

	public List<EngNews> queryNewsByPage(int start, int limit) {

		return engNewsDao.queryNewsByPage(start,limit);
	}
	
	public List<EngNews> queryNewsUnderTrans(int start, int limit) {
	
		return engNewsDao.queryNewsUnderTrans(start,limit);
	}

	public int queryNewsAmount() {

		return engNewsDao.queryNewsAmount();
	}

	public boolean saveOrUpdateNews(EngNews engNews) {
		
		return engNewsDao.saveOrUpdateNews(engNews);
	}

	public EngNews queryNews(EngNews engNews) {
	
		return engNewsDao.queryNews(engNews);
	}
	
	public EngNews queryNewsById(int newsId) {
		
		return engNewsDao.queryNewsById(newsId);
	}
	
	public EngNews queryNewsByOrigId(int origNewsId)
	{
		return engNewsDao.queryNewsByOrigId(origNewsId);
	}

	public boolean deleteNews(EngNews engNews) {

		return engNewsDao.deleteNews(engNews);
	}

	public List<EngNews> queryNewsTrans(int start, int limit) {
	
		return engNewsDao.queryNewsTrans(start, limit);
	}

	public int queryNewsTransAmount() {
	
		return engNewsDao.queryNewsTransAmount();
	}

	public List<EngNews> queryNewsBySectionId(int sectionId, int page, int size) {
		return engNewsDao.queryNewsBySectionId(sectionId, page, size);
	}

	public int queryNewsAmountBySectionId(int sectionId) {
		return engNewsDao.queryNewsAmountBySectionId(sectionId);
	}

	public int queryNoticeAmount() {
		return engNewsDao.queryNoticeAmount();
	}


	public List<EngNews> queryPicturenews(int page, int size) {
		return engNewsDao.queryPicturenews(page, size);
		
	}

	public List<EngNews> queryPicturenewsBySectionId(int sectionId, int page,
			int size) {
		// TODO Auto-generated method stub
		return null;
	}

	public EngNews queryPoint() {

		return engNewsDao.queryPoint();
	}

	public List<EngNews> queryNotice(int page, int size) {
		
		return engNewsDao.queryNotice(page, size);
	}


	public List<EngNews> queryAttachedNews(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<EngNews> queryAttachedNewsBySectionId(int page, int size,
			int sectionId) {
		
		return engNewsDao.queryNewsBySectionId(sectionId,page,size);
	}

	public List<EngNews> queryNoticeBySectionId(int sectionId, int page,
			int size) {
		
		return engNewsDao.queryNoticeBySectionId(sectionId,page,size);
	}
	
	public boolean convertNews(News news) {

		System.out.println(news.getNewsTitle());
		EngNews eng = new EngNews();
		eng.setNewsTitle(news.getNewsTitle());
		eng.setChnNews(news.getNewsId());
		eng.setEngSection(engSecDao.querySectionByName("newsAndEvents"));
		//默认翻译过来的新闻设为这个板块
		
		eng.setNewsAuthor(userDao.transUser(news.getNewsAuthor()));
		eng.setNewsContent(news.getNewsContent());
		eng.setNewsDate(news.getNewsDate());
		eng.setAttachPath(news.getAttachPath());
		eng.setPicPath(news.getPicPath());
		eng.setNewsStatus("0");
		
		return engNewsDao.saveOrUpdateNews(eng);
		
	}
	
	public void buildJsp() {
		//生成静态jsp页面的方法	
		List<EngNews> listPic = engNewsDao.queryPicturenews(1, 4);
		System.out.println("listPic"+listPic.size());
		BuildEngJsp buildp = new BuildEngJsp(listPic);
		buildp.buildEngPic();
		
	}
	
	
	@Resource(name="engSectionDao")
	public void setEngSecDao(EngSectionDao engSecDao) {
		this.engSecDao = engSecDao;
	}
	
	@Resource(name="engNewsDao")
	public void setEngNewsDao(EngNewsDao engNewsDao) {
		this.engNewsDao = engNewsDao;
	}
	
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
	
	
	













}
