package neu.scweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.EngNewsDao;
import neu.scweb.po.EngNews;
import neu.scweb.po.EngSection;

import neu.scweb.po.Section;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;

@Component(value="engNewsDao")
public class EngNewsDaoImpl implements EngNewsDao {

	private BaseDao baseDao;
	
	public EngNews queryNewsByOrigId(int origNewsId)
	{
		return (EngNews) baseDao.loadObject("from EngNews where origNewsId=" + origNewsId);
	}
	
	
	public List<EngNews> queryAllNews() {

		return baseDao.listAll("EngNews");
	}
	
	public List<EngNews> queryAllNewsByPage(int start, int limit) {

		return baseDao.queryPage("from EngNews ", start, limit);
	}


	public List<EngNews> queryNewsTrans(int start, int limit) {

		return baseDao.queryPage("from EngNews where chnNews<>0 order by newsDate desc", start, limit);
	}


	public int queryNewsTransAmount() {
	
		List<EngNews> list = new ArrayList<EngNews>();
		list = baseDao.query("from EngNews where chnNews<>0 order by newsDate desc");
		return list.size();
	}
	

	public int queryNewsAmountBySectionId(int sectionId) {
		List<EngNews> list = new ArrayList<EngNews>();
		list = baseDao.query("from EngNews where newsStatus =2 and news_sectionId ="+sectionId+" order by newsDate desc");
		return list.size();
	}
	
	public List<EngNews> queryNewsUndetermined(int start, int limit) {
		
		return baseDao.queryPage("from EngNews where newsStatus =1 order by newsDate desc", start, limit);
	}
	
	public List<EngNews> queryNewsUnderTrans(int start, int limit) {
		
		return baseDao.queryPage("from EngNews where newsStatus =0 order by newsDate desc", start, limit);
	}

	public List<EngNews> queryNewsByPage(int start, int limit) {
		
		return baseDao.queryPage("from EngNews order by newsDate desc", start, limit);
	}

	public int queryNewsAmount() {
		List<EngNews> list = new ArrayList<EngNews>();

		try{
			list = baseDao.query("from EngNews");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.size();
	}


	public boolean saveOrUpdateNews(EngNews engNews) {
		boolean state = false;
		try {
			baseDao.saveOrUpdate(engNews);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}


	public EngNews queryNews(EngNews engNews) {
		
		return (EngNews) baseDao.loadObject("from EngNews where newsId=" + engNews.getNewsId());
	}
	
	public EngNews queryNewsById(int newsId) {
		
		return (EngNews) baseDao.loadObject("from EngNews where newsId=" + newsId);
	}

	public boolean deleteNews(EngNews engNews) {
		boolean state=false;
		try {
			baseDao.delete(engNews);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<EngNews> queryNewsBySectionId(int sectionId, int page, int size) {
		int start = size*(page-1);
		int sum = size;
		
		return baseDao.queryPage("from EngNews where newsStatus =2 and news_sectionId ="+sectionId+" order by newsDate desc", start, sum);
	}
	
	public List<EngNews> queryNotice(int page, int size) {
	
		int start = size*(page-1);
		int sum = size;
		
		return baseDao.queryPage("from EngNews where newsStatus =2 and isNotice =1 order by newsDate desc", start, sum);
	}

	
	public int queryNoticeAmount(){
		List<EngNews> list = new ArrayList<EngNews>();

		try{
			list = baseDao.query("from EngNews where isNotice = 1 and newsStatus =2 order by newsDate desc");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.size();
	}
	
	public EngNews queryPoint() {
		int start = 0;
		int sum =1;		
		List<EngNews> engList = baseDao.queryPage("from EngNews where newsStatus =2 and isNotice =1 order by newsDate desc", start, sum);
		return engList.get(0);

	}
	
	private void alert(String newsTitle) {
		// TODO Auto-generated method stub	
	}
	
	public List queryNoticeBySectionId(int sectionId, int page, int size) {
		final int start = size*(page-1);
		final int sum = size;
		EngSection engSection;
		engSection = (EngSection) baseDao.loadObject("from engSection where sectionId="+sectionId);
		return baseDao.queryPage("from engNews where isNotice = 1 and news_sectionId="+sectionId+" order by newsDate desc", start, sum);
		
	}


	@Override
	public List<EngNews> queryPicturenews(int page, int size) {
		final int start = size*(page-1);
		final int sum = size;
		return baseDao.queryPage("from EngNews where isPicNews = 1 and newsStatus =2  order by newsDate desc", start, sum);
	}
	
	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
