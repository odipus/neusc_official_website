package neu.scweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.AuthPrivilegeDao;
import neu.scweb.dao.NewsDao;
import neu.scweb.dao.PictureDao;
import neu.scweb.dao.SectionDao;
import neu.scweb.po.ExpandNews;
import neu.scweb.po.News;
import neu.scweb.po.Picture;
import neu.scweb.po.Section;
import neu.scweb.service.NewsService;
import neu.scweb.util.BuildJsp;

@Component(value="newsService")
public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;
	private SectionDao sectionDao;
	private AuthPrivilegeDao apDao;
	private PictureDao pictureDao;

	public List<News> queryAllNews() {
		return newsDao.queryAllNews();
	}

	public boolean saveOrUpdateNews(News news) {
		return newsDao.saveOrUpdateNews(news);
	}

	public News queryNews(News news) {
		return newsDao.queryNews(news);
	}

	public News queryNewsById(int newsId) {
		return newsDao.queryNewsById(newsId);
	}

	public boolean deleteNews(News news) {
		return newsDao.deleteNews(news);
	}

	public List<News> queryNewsBySectionId(int sectionId,int page, int size) {
		return newsDao.queryNewsBySectionId(sectionId,page,size);
	}

	public int queryNewsAmountBySectionId(int sectionId){
		return newsDao.queryNewsAmountBySectionId(sectionId);
	}

	public List<News> queryNotice(int page, int size) {
		return newsDao.queryNotice(page, size);
	}

	public List<News> queryPicturenews(int page, int size){
		return newsDao.queryPicturenews(page, size);
	}

	public int queryNoticeAmount() {
		return newsDao.queryNoticeAmount();
	}

	public int queryNewsAmount(int roleId) {
		return newsDao.queryNewsAmount(apDao.querySectIdByRole(roleId));
	}

	public List<News> queryNewsByPage(int start, int limit) {
		return newsDao.queryNewsByPage(start, limit);
	}

	public List<News> queryAuthNews(List<Section> authSect) {
		return newsDao.queryAuthNews(authSect);
	}

	public List<News> queryAuthNewsByPage(List<Section> authSect, int start, int limit) {
		return newsDao.queryAuthNewsByPage(authSect, start, limit);
	}

	public List queryNoticeBySectionId(int sectionId, int page, int size){
		return newsDao.queryNoticeBySectionId(sectionId,page,size);
	}

	public List queryAttachedNews(int page, int size) {
		return newsDao.queryAttachedNews(page,size);
	}

	public List<News> queryAttachedNewsBySectionId(int page, int size,int sectionId) {
		return newsDao.queryAttachedNewsBySectionId(page, size, sectionId);
	}

	public List queryPicturenewsBySectionId(int sectionId, int page, int size) {
		return newsDao.queryPicturenewsBySectionId(sectionId,page,size);
	}

	public int queryAttachedNewsAmount() {
		return newsDao.queryAttachedNewsAmount();
	}
	
	public List<News> searchNewsTitle(String search) {
		return newsDao.searchNewsTitle(search);
	}

	public List<News> searchNewsContent(String search) {
		return newsDao.searchNewsContent(search);
	}

	public void buildJsp(Section section) {
		//生成静态jsp页面的方法
		int id = section.getUpperSectionId();
		if(id!=0){		
			section = sectionDao.querySectionBySectId(id);
		}
		System.out.println("build jsp    "+id);
		if(section.getSectionPlace()=="noshow"){}
		else if (section.getSectionPlace().equalsIgnoreCase("left")){
			List<News> list = newsDao.queryNewsBySectionId(section.getSectionId(), 1,5);
			String name = section.getSectionId()+".jsp";
			BuildJsp build = new BuildJsp(name,list);
			build.buildLeft();
			
		}
		else if(section.getSectionPlace().equalsIgnoreCase("right")){
			List<News> list = newsDao.queryNewsBySectionId(section.getSectionId(), 1,5);
			String name = section.getSectionId()+".jsp";
			BuildJsp build = new BuildJsp(name,list);
			build.buildRight();
		}
		else{
			List<News> list = newsDao.queryNewsBySectionId(section.getSectionId(), 1,4);
			String name = section.getSectionId()+".jsp";
			BuildJsp build = new BuildJsp(name,list);
			build.buildCenter();
		}
		
		List<News> listSlide = newsDao.queryNotice(1, 6);
		BuildJsp builds = new BuildJsp(listSlide);
		builds.buildSlide();
		/**
		 * 获取前四条新闻
		 */
		List<News> listPic = newsDao.queryPicturenews(1, 4);
		Picture picture = new Picture();
		ExpandNews expandNews = new ExpandNews();
		List<ExpandNews> listPic_expand = new ArrayList<ExpandNews>();
		for (News news : listPic) {
			picture.setNews(news);
			picture = pictureDao.queryPicture(picture);
			expandNews.setNews(news);
			expandNews.setPicture(picture);
			listPic_expand.add(expandNews);
			picture = new Picture();
			expandNews = new ExpandNews();
		}
		BuildJsp buildp = new BuildJsp(listPic_expand,1);
		buildp.buildPic();
	}
	

	@Resource(name="pictureDao")
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	@Resource(name="newsDao")
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	@Resource(name="sectionDao")
	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}

	@Resource(name="authPrivilegeDao")
	public void setApDao(AuthPrivilegeDao apDao) {
		this.apDao = apDao;
	}

}
