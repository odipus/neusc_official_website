package neu.scweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import neu.scweb.dao.SubNewsDao;
import neu.scweb.po.SubNews;
import neu.scweb.po.SubSite;
import neu.scweb.util.BaseDao;

import org.springframework.stereotype.Component;

@Component(value="subNewsDao")
public class SubNewsDaoImpl implements SubNewsDao{

	private BaseDao baseDao;

	public List querySubNewsBySite(String subSiteCode) {
		return baseDao.query("from SubNews where subNews_subSiteId=(select subSiteId from SubSite where subSiteCode='"+ subSiteCode +"')");
	}

	public List queryAllSubNews() {
		return baseDao.listAll("SubNews");
	}

	public boolean saveSubNews(SubNews subNews) {
		boolean state = false;
		try {
			System.out.println(subNews.getNewsContent());
			baseDao.saveOrUpdate(subNews);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public SubNews querySubNews(SubNews subNews) {
		return (SubNews) baseDao.loadObject("from SubNews where subNewsId=" + subNews.getSubNewsId());
	}

	public SubNews querySubNewsById(int subNewsId) {
		return (SubNews) baseDao.loadObject("from SubNews where subNewsId=" + subNewsId);
	}

	public boolean deleteSubNews(SubNews subNews) {
		boolean state=false;
		try {
			baseDao.delete(subNews);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<SubNews> queryNewsBySubSiteId(int subSiteId,int page,int size) {
		final int start = size*(page-1);
		final int sum = size;
	
		return baseDao.queryPage("from SubNews where subNews_subSiteId="+ subSiteId+"", start, sum);

		
	}


	public int queryNewsAmountBySubSiteId(int subSiteId) {
		List<SubNews> list = new ArrayList<SubNews>();
		try{
			list = baseDao.query("from SubNews where subNews_subSiteId="+ subSiteId);
		}catch(Exception e){
			e.printStackTrace();
		}

		return list.size();
	}


	public List<SubNews> queryNotice(int page, int size) {
	
		final int start = size*(page-1);
		final int sum = size;

		return baseDao.queryPage("from SubNews where isNotice = 1 order by newsDate desc", start, sum);

		
	}


	public int queryNoticeAmount() {
		List<SubNews> list = new ArrayList<SubNews>();
		try{
			list = baseDao.query("from SubNews where isNotice=1");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list.size();
	}

	public List<SubNews> queryPicturenews(int page, int size) {

		final int start = size*(page-1);
		final int sum = size;
	
		return baseDao.queryPage("from SubNews where isPicNews=1", start, sum);
	
		
	}


	public boolean saveOrUpdateNews(SubNews subNews) {
		boolean state = false;
		try {
			baseDao.saveOrUpdate(subNews);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public List<SubNews> querySubNewsBySitePage(String subSiteCode, int start, int limit) {
		return baseDao.queryPage("from SubNews where subNews_subSiteId=(select subSiteId from SubSite where subSiteCode='"+ subSiteCode +"')", start, limit);
	}

	public List<SubNews> queryNotice(int subSiteId, int page, int size) {

		final int start = size*(page-1);
		final int sum = size;
		return baseDao.queryPage("from SubNews where subNews_subSiteId="+subSiteId+" and isNotice = 1 order by newsDate desc", start, sum);
	
	}


	public int queryNoticeAmount(int subSiteId) {
		List<SubNews> list = new ArrayList<SubNews>();

		try{
			list = baseDao.query("from SubNews where subNews_subSiteId="+subSiteId+" and isNotice=1");

		}catch(Exception e){
			e.printStackTrace();
		}

		return list.size();
	}

	public List<SubNews> queryPicturenews(int subSiteId, int page, int size) {

		final int start = size*(page-1);
		final int sum = size;

		return baseDao.queryPage("from SubNews where subNews_subSiteId="+subSiteId+" and isPicNews=1", start, sum);


	
	}


	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}