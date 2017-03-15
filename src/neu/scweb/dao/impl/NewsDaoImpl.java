package neu.scweb.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.NewsDao;
import neu.scweb.po.News;
import neu.scweb.po.Section;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;

@Component(value="newsDao")
public class NewsDaoImpl implements NewsDao{

	private BaseDao baseDao;
	private Section sect;
	private String sectIdList;
	private int sectId;

	public List<News> queryAllNews() {
		return baseDao.listAll("News");
		//return baseDao.query("from News order by newsDate desc");
	}

	public boolean saveOrUpdateNews(News news) {
		boolean state = false;
		try {
			System.out.println("dao 发布新闻"  +news.getNewsTitle());
			baseDao.saveOrUpdate(news);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<News> queryAuthNews(List<Section> authSect) {
		Iterator<Section> its = authSect.iterator();
		sectIdList = "";
		for(int i = 0; i < authSect.size(); i++) {
			sect = its.next();
			sectIdList += sect.getSectionId() + ",";
		}
		return baseDao.query("from News where news_sectionId in(" + sectIdList.substring(0, sectIdList.length() - 1) + ")");
	}

	public List<News> queryAuthNewsByPage(List<Section> authSect, int start, int limit) {
		Iterator<Section> its = authSect.iterator();
		sectIdList = "";
		for(int i = 0; i < authSect.size(); i++) {
			sect = its.next();
			sectIdList += sect.getSectionId() + ",";
		}
		return baseDao.queryPage("from News where news_sectionId in(" + sectIdList.substring(0, sectIdList.length() - 1) + ") order by newsDate desc", start, limit);
	}

	public List<News> queryNewsByPage(int start, int limit) {
		return baseDao.queryPage("from News order by newsDate desc", start, limit);
	}

	public News queryNewsById(int newsId) {
		return (News) baseDao.loadObject("from News where newsId=" + newsId);
	}

	public News queryNews(News news) {
		//return (News) baseDao.loadObject("from Section where newsId='" + news.getNewsId() + "' and newsTitle='" + news.getNewsTitle() + "' and newsAuthor='" + news.getNewsAuthor() + "'" );
		return (News) baseDao.loadObject("from News where newsId=" + news.getNewsId());
	}

	public boolean deleteNews(News news) {
		boolean state=false;
		try {
			baseDao.delete(news);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}
	public int queryNewsAmount(List<Integer> authSectId) {
		Iterator<Integer> its = authSectId.iterator();
		sectIdList = "";
		for(int i = 0; i < authSectId.size(); i++) {
			sectId = its.next();
			sectIdList += sectId + ",";
		}
		return baseDao.query("from News where news_sectionId in(" + sectIdList.substring(0, sectIdList.length() - 1) + ")").size();
	}

	public List<News> queryNotice(int page, int size) {
		
		final int start = size*(page-1);
		final int sum = size;
	
		return baseDao.queryPage("from News where isNotice = 1 order by newsDate desc", start, sum);
	}
	public int queryNoticeAmount(){
		List<News> list = new ArrayList<News>();

		try{
			list = baseDao.query("from News where isNotice = 1 order by newsDate desc");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.size();
	}

	public List<News> queryPicturenews(int page, int size){

		final int start = size*(page-1);
		final int sum = size;

		return baseDao.queryPage("from News where isPicNews = 1 order by newsDate desc", start, sum);
	}

	public List queryAttachedNews(int page, int size) {
		final int start = size*(page-1);
		final int sum = size;
		return baseDao.queryPage("from News news where isAttach = 1 order by news.newsDate desc", start, sum);
		
	}

	public List<News> queryAttachedNewsBySectionId(int page, int size,int sectionId) {
		final int start = size*(page-1);
		final int sum = size;
		return baseDao.queryPage("from News where isAttach = 1 and news_sectionId = "+sectionId+" order by newsDate", start, sum);
		
	}
	public int queryAttachedNewsAmount() {
		List<News> list = new ArrayList<News>();
		list = baseDao.query("from News where isAttach = 1");
		return list.size();
	}
	
	public List<News> queryNewsBySectionId(int sectionId,int page, int size) {
		final int start = size*(page-1);
		final int sum = size;
		Section section;
		section = (Section) baseDao.loadObject("from Section where sectionId="+sectionId);
		if(section.getIsUpperSection()==0) {
			return baseDao.queryPage("from News where news_sectionId="+ sectionId+" order by newsDate desc", start, sum);
		}	
		else {
			return baseDao.queryPage("from News where news_sectionId in(from Section where upperSectionId="+sectionId+") order by newsDate desc", start, sum);
		}	
			
	}
	
	public int queryNewsAmountBySectionId(int sectionId) {
		List<News> list = new ArrayList<News>();
		Section section;
		section = (Section) baseDao.loadObject("from Section where sectionId="+sectionId);
		if(section.getIsUpperSection()==0)
			list = baseDao.query("from News where news_sectionId="+ sectionId);
		else
			list = baseDao.query("from News where news_sectionId in(from Section where upperSectionId="+sectionId+")");

		return list.size();

	}

	public List queryNoticeBySectionId(int sectionId, int page, int size) {
		final int start = size*(page-1);
		final int sum = size;
		Section section;
		section = (Section) baseDao.loadObject("from Section where sectionId="+sectionId);
		if(section.getIsUpperSection()==0)
			return baseDao.queryPage("from News where isNotice = 1 and news_sectionId="+sectionId+" order by newsDate desc", start, sum);
		else
			return baseDao.queryPage("from News where isNotice = 1 and news_sectionId in(from Section where upperSectionId="+sectionId+") order by newsDate desc", start, sum);
	}

	public List queryPicturenewsBySectionId(int sectionId, int page, int size) {
		final int start = size*(page-1);
		final int sum = size;
		Section section;
		section = (Section) baseDao.loadObject("from Section where sectionId="+sectionId);
		if(section.getIsUpperSection()==0)
			return baseDao.queryPage("from News where isPicNews = 1 and news_sectionId="+sectionId+" order by newsDate desc", start, sum);
		else
			return baseDao.queryPage("from News where isPicNews = 1 and news_sectionId in(from Section where upperSectionId="+sectionId+") order by newsDate desc", start, sum);
	}
	
	
	public List<News> searchNewsTitle(String search) {
		System.out.println("  "+search);
		return null;
	}

	public List<News> searchNewsContent(String search) {
		System.out.println("  "+search);
		return null;
	}

	public Section getSect() {
		return sect;
	}

	public void setSect(Section sect) {
		this.sect = sect;
	}

	public String getSectIdList() {
		return sectIdList;
	}

	public void setSectIdList(String sectIdList) {
		this.sectIdList = sectIdList;
	}

	public int getSectId() {
		return sectId;
	}

	public void setSectId(int sectId) {
		this.sectId = sectId;
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}
