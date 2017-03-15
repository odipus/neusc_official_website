package neu.scweb.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import neu.scweb.po.SubNews;
import neu.scweb.po.SubSite;
import neu.scweb.service.SubNewsService;
import neu.scweb.service.SubSiteService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllSubNews", type="json", params={"excludeProperties","subNews,subSite"}),
	@Result(name="addSubNews", type="json", params={"includeProperties","success"}),
	@Result(name="updateSubNews", type="json", params={"includeProperties","success"}),
	@Result(name="deleteSubNews", type="json", params={"includeProperties","success"}),
	@Result(name="publishSubNews", type="json", params={"includeProperties","success"}),
	@Result(name="querySubNewsBySite", type="json", params={"excludeProperties","newsAmount,size,page,subNews,subSite"}),
	@Result(name="querySubNewsBySitePage", type="json", params={"excludeProperties","limit,start,newsAmount,size,page,subNews,subSite"}),
	@Result(name="querySubNewsById", type="json", params={"excludeProperties","subNewsList,subSite,subSiteCode,subPicPath,subAttachPath,subNewsArray,subNewsId"}),
	@Result(name="querySubNewsBySubSiteId", type="json", params={"excludeProperties","totalProperty,limit,start,newsAmount,size,page,subNewsId,subNewsArray,subAttachPath,subPicPath,subSiteCode,subSite,subSiteId,subNews,success"}),
	@Result(name="querySubNewsAmountBySubSiteId", type="json", params={"includeProperties","newsAmount"}),
	@Result(name="queryNotice", type="json", params={"excludeProperties","success"}),
	@Result(name="queryNoticeAmount", type="json", params={"includeProperties","newsAmount"}),
	@Result(name="queryPicturenews", type="json", params={"excludeProperties","totalProperty,limit,start,newsAmount,size,page,subNewsId,subNewsArray,subAttachPath,subPicPath,subSiteCode,subSite,subSiteId,subNews,success"})

})

public class SubNewsAction extends ActionSupport{
	private SubNews subNews;
	private String subNewsTitle;
	private List<SubNews> subNewsList;
	private int subSiteId;
	private SubSite subSite;
	private String success;
	private String subSiteCode;
	private String subPicPath;
	private String subAttachPath;
	private String subNewsArray;
	private int subNewsId;
	private SubNewsService subNewsService;
	private SubSiteService subSiteService;
	//以下参数用于前台分页，page表示当前需要第几页的内容，size表示每一页的容量,newsAmount表示新闻总数
	private int page;
	private int size;
	private int newsAmount;
	//以下参数用于后台分页
	private int start;
	private int limit;
	private int totalProperty;

	@Action(value="subNewsAction")
	public String queryAllSubNews() {
		subNewsList = subNewsService.queryAllSubNews();
		this.success = SUCCESS;
		return "queryAllSubNews";
	}

	public String querySubNewsBySite() {
		subSite.getSubSiteCode();
		subNewsList = subNewsService.querySubNewsBySite(subSite.getSubSiteCode());
		this.success = SUCCESS;
		return "querySubNewsBySite";
	}

	public String querySubNewsBySitePage() {
		this.getStart();
		this.getLimit();
		subSite.getSubSiteCode();
		subNewsList = subNewsService.querySubNewsBySitePage(subSite.getSubSiteCode(), start, limit);
		this.success = SUCCESS;
		return "querySubNewsBySitePage";
	}

	public String querySubNewsById() {
		this.getSubNewsId();
		System.out.println("subnewsId="+subNewsId);
		subNews = subNewsService.querySubNewsById(subNewsId);
		subNews.setNewsClick(subNews.getNewsClick()+1);
		subNewsService.saveOrUpdateNews(subNews);
		this.success = SUCCESS;
		return "querySubNewsById";
	}

	public String addSubNews() {
		subNews.getSubNewsTitle();
		System.out.println(subNews.getSubNewsTitle());
		subNews.getNewsContent();
		System.out.println(subNews.getNewsContent());
		subNews.getSubNewsAuthor();
		System.out.println(subNews.getSubNewsAuthor());
		subNews.getIsNotice();
		System.out.println(subNews.getIsNotice());
		subNews.getIsPicNews();
		System.out.println(subNews.getIsPicNews());
		subNews.getIsAttach();
		System.out.println(subNews.getIsAttach());
		this.getSubSiteCode();
		this.getSubAttachPath();
		this.getSubPicPath();
		System.out.println(this.subSiteCode);
		if (subNews.getIsNotice() == 1) {
			subNews.getNoticeValid();
			System.out.println(subNews.getNoticeValid());
		}
		if (subNews.getIsPicNews() == 1) {
			this.getSubPicPath();
			subNews.setPicPath(subPicPath);
			System.out.println(subNews.getPicPath());
		}
		if (subNews.getIsAttach() == 1) {
			this.getSubAttachPath();
			//subNews.setAttachPath(subAttachPath);
			subNews.setAttachPath(subAttachPath);
			System.out.println(subNews.getAttachPath());
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		subNews.setNewsDate(curDate);
		subSite = subSiteService.querySubSiteByCode(subSiteCode);
		System.out.println(subSite.getSubSiteId());
		subNews.setSubSite(subSite);
		System.out.println(subNews.getSubNewsId());
		subNewsService.saveSubNews(subNews);
		this.success = SUCCESS;
		return "addSubNews";
	}

	public String deleteSubNews() {
		String stmp = this.getSubNewsArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		SubNews subNews = subNewsService.querySubNews((SubNews) jsonObject.toBean(jsonObject, SubNews.class));
		System.out.println(subNews.getSubNewsId());
		if(subNewsService.deleteSubNews(subNews)) {
			this.success = SUCCESS;
		}
		return "deleteSubNews";
	}

	public String updateSubNews() {
		subNews.getSubNewsId();
		subNews.getSubNewsTitle();
		//System.out.println(subNews.getSubNewsTitle());
		subNews.getNewsContent();
		//System.out.println(subNews.getNewsContent());
		subNews.getSubNewsAuthor();
		//System.out.println(subNews.getSubNewsAuthor());
		subNews.getIsNotice();
		//System.out.println(subNews.getIsNotice());
		subNews.getIsPicNews();
		//System.out.println(subNews.getIsPicNews());
		subNews.getIsAttach();
		//System.out.println(subNews.getIsAttach());
		this.getSubSiteCode();
		this.getSubAttachPath();
		this.getSubPicPath();
		if (subNews.getIsNotice() == 1) {
			subNews.getNoticeValid();
			System.out.println(subNews.getNoticeValid());
		}
		if (subNews.getIsPicNews() == 1) {
			this.getSubPicPath();
			subNews.setPicPath(subPicPath);
			System.out.println(subNews.getPicPath());
		}
		if (subNews.getIsAttach() == 1) {
			this.getSubAttachPath();
			//subNews.setAttachPath(subAttachPath);
			subNews.setAttachPath(subAttachPath);
			System.out.println(subNews.getAttachPath());
		}
		SubNews su = subNewsService.querySubNewsById(subNews.getSubNewsId());
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
*/		subNews.setNewsDate(su.getNewsDate());
		subSite = subSiteService.querySubSiteByCode(subSiteCode);
		//System.out.println(subSite.getSubSiteId());
		subNews.setSubSite(subSite);
		subNewsService.saveSubNews(subNews);
		this.success = SUCCESS;
		return "updateSubNews";
	}

	public String publishSubNews() {
		String stmp = this.getSubNewsArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		subNews = subNewsService.querySubNews((SubNews) jsonObject.toBean(jsonObject, SubNews.class));
		System.out.println(subNews.getSubNewsId());
		subNews.setNewsStatus(1);
		if(subNewsService.saveSubNews(subNews)) {
			this.success = SUCCESS;
		}
		return "publishSubNews";
	}

	public String querySubNewsBySubSiteId(){
		this.getSubSiteId();
		this.getPage();
		this.getSize();
		subNewsList=subNewsService.queryNewsBySubSiteId(subSiteId, page, size);
		this.success = SUCCESS;
		return "querySubNewsBySubSiteId";
	}

	public String querySubNewsAmountBySubSiteId(){
		this.getSubSiteId();
		newsAmount = subNewsService.queryNewsAmountBySubSiteId(subSiteId);
		this.success = SUCCESS;
		return "querySubNewsAmountBySubSiteId";
	}

	public String queryNotice(){
		this.getSubSiteId();
		page = this.getPage();
		size = this.getSize();
		subNewsList = subNewsService.queryNotice(subSiteId, page, size);
		this.success = SUCCESS;
		return "queryNotice";
	}

	public String queryNoticeAmount(){
		this.getSubSiteId();
		newsAmount = subNewsService.queryNoticeAmount(subSiteId);
		this.success = SUCCESS;
		return "queryNoticeAmount";
	}

	public String queryPicturenews(){
		this.getSubSiteId();
		page = this.getPage();
		size = this.getSize();
		subNewsList = subNewsService.queryPicturenews(subSiteId, page, size);
		this.success = SUCCESS;
		return "queryPicturenews";
	}

	public SubNews getSubNews() {
		return subNews;
	}

	public void setSubNews(SubNews subNews) {
		this.subNews = subNews;
	}

	public List<SubNews> getSubNewsList() {
		return subNewsList;
	}

	public void setSubNewsList(List<SubNews> subNewsList) {
		this.subNewsList = subNewsList;
	}

	public int getSubSiteId() {
		return subSiteId;
	}

	public void setSubSiteId(int subSiteId) {
		this.subSiteId = subSiteId;
	}

	public SubSite getSubSite() {
		return subSite;
	}

	public void setSubSite(SubSite subSite) {
		this.subSite = subSite;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getSubSiteCode() {
		return subSiteCode;
	}

	public void setSubSiteCode(String subSiteCode) {
		this.subSiteCode = subSiteCode;
	}

	public String getSubPicPath() {
		return subPicPath;
	}

	public void setSubPicPath(String subPicPath) {
		this.subPicPath = subPicPath;
	}

	public String getSubAttachPath() {
		return subAttachPath;
	}

	public void setSubAttachPath(String subAttachPath) {
		this.subAttachPath = subAttachPath;
	}

	public String getSubNewsArray() {
		return subNewsArray;
	}

	public void setSubNewsArray(String subNewsArray) {
		this.subNewsArray = subNewsArray;
	}

	public int getSubNewsId() {
		return subNewsId;
	}

	public void setSubNewsId(int subNewsId) {
		this.subNewsId = subNewsId;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNewsAmount() {
		return newsAmount;
	}

	public void setNewsAmount(int newsAmount) {
		this.newsAmount = newsAmount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public String getSubNewsTitle() {
		return subNewsTitle;
	}

	public void setSubNewsTitle(String subNewsTitle) {
		this.subNewsTitle = subNewsTitle;
	}

	@Resource(name="subNewsService")
	public void setSubNewsService(SubNewsService subNewsService) {
		this.subNewsService = subNewsService;
	}

	@Resource(name="subSiteService")
	public void setSubSiteService(SubSiteService subSiteService) {
		this.subSiteService = subSiteService;
	}


}
