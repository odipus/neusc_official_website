package neu.scweb.action;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import neu.scweb.po.EngNews;
import neu.scweb.po.EngSection;
import neu.scweb.po.News;
import neu.scweb.po.Section;
import neu.scweb.service.EngNewsService;
import neu.scweb.service.EngSectionService;
import neu.scweb.service.SectionService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllNews", type="json", params={"excludeProperties","roleId"}),
	//@Result(name="queryAllNewsByPage", type="json", params={"excludeProperties","roleId"}),
	@Result(name="queryAllNewsByPage", type="json", params={"excludeProperties","newsAttachPath,newsPicPath,newsSection,engNews,newsArray,newsId,sectionId,newsAmount,size,page"}),
	@Result(name="queryNews", type="json", params={"excludeProperties","roleId"}),
	@Result(name="queryNoticeAmount", type="json", params={"includeProperties","success,newsAmount"}),
	@Result(name="queryNotice", type="json", params={"excludeProperties","engNews,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,engNews,newsSection,newsArray,newsId"}),
	@Result(name="transNews", type="json", params={"excludeProperties","roleId"}),
	@Result(name="checkNews", type="json", params={"excludeProperties","roleId"}),
	@Result(name="queryPicturenews", type="json", params={"excludeProperties","engNews,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId"}),
	@Result(name="addNews", type="json", params={"excludeProperties","roleId"}),
	@Result(name="updateNews", type="json", params={"excludeProperties","roleId"}),
	@Result(name="deleteNews", type="json", params={"excludeProperties","roleId"}),
	@Result(name="queryNewsBySectionId", type="json", params={"excludeProperties","engNews,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,newsSection,newsArray,newsId"}),
	@Result(name="queryNewsAmountBySectionId", type="json", params={"includeProperties","success,newsAmount"}),
    @Result(name="queryPicturenewsBySectionId", type="json", params={"excludeProperties","newsId"}),
    @Result(name="queryNewsUndetermined", type="json", params={"excludeProperties","newsId"}),
    @Result(name="queryNewsByPage", type="json", params={"excludeProperties","newsId"}),
    @Result(name="queryNewsUnderTrans", type="json", params={"excludeProperties","newsId"}),
    @Result(name="queryNewsTrans", type="json", params={"excludeProperties","newsId"}),
    @Result(name="queryPoint", type="json", params={"excludeProperties","newsId"})
})
public class EngNewsAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private EngNewsService engNewsService;
	private EngSectionService engSectionService;

	private List<EngNews> engNewsList;
	private String success;
	private String newsSection;
	private EngNews engNews;
	private String newsArray;
	private String newsPicPath;
	private String newsAttachPath;
	private int newsId;
	private int sectionId;
	private int roleId;

	//以下参数用于前台分页，page表示当前需要第几页的内容，size表示每一页的容量,newsAmount表示新闻总数
	private int page;
	private int size;
	private int newsAmount;
	//以下数据用于后台分页
	private int limit;
	private int start;
	private int totalProperty;

	@Action(value="engNewsAction")
	public String queryNews(){
		this.getNewsId();
		engNews = engNewsService.queryNewsById(newsId);
		this.success = SUCCESS;
		return "queryNews";
	}
	
	public String queryAllNews() {
		//查询所有的新闻
		this.getRoleId();
		engNewsList = engNewsService.queryAllNews();
		System.out.println("大小事发反反复复："+engNewsList.size());
		this.success = SUCCESS;
		return "queryAllNews";
	}
	
	public String queryAllNewsByPage(){
		//分页查询所有的新闻
		this.getLimit();
		this.getStart();
		engNewsList = engNewsService.queryNewsByPage(start, 10000);
		this.success = SUCCESS;
		return "queryAllNewsByPage";
	}
	
	public String transNews(){
		engNews.getNewsId();
		engNews.getNewsTitle();
		this.getNewsSection();
		engNews.getIsNotice();
		engNews.getNewsContent();
		engNews.getNewsAuthor();
		
		engNews.getIsAttach();
		if(engNews.getIsAttach() == 1){
			engNews.getAttachPath();
		}
		engNews.getIsPicNews();
		if(engNews.getIsPicNews() == 1){
			engNews.getPicPath();
		}
		engNews.getIsNotice();
		engNews.getNewsAuthor();
		engNews.getChnNews();

		EngSection sect = engSectionService.querySectionByName(this.getNewsSection());	
		engNews.setEngSection(sect);
		engNews.setNewsStatus("1");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		engNews.setNewsDate(curDate);	
		System.out.println(engNews.getNewsContent());
		engNewsService.buildJsp();
		engNewsService.saveOrUpdateNews(engNews);
		this.success = SUCCESS;
		return "transNews";
	}
	
	public String checkNews(){
		engNews.getNewsTitle();
		engNews.getNewsId();
		this.getNewsSection();
		engNews.getNewsContent();

		EngSection sect = engSectionService.querySectionByName(this.getNewsSection());
	
		EngNews une = engNewsService.queryNewsById(engNews.getNewsId());

		if(une.getOrigNewsId()!=0)
		{
			EngNews ne = engNewsService.queryNewsById(une.getOrigNewsId());
					
				ne.setNewsTitle(engNews.getNewsTitle());
				ne.setEngSection(sect);
				ne.setNewsContent(engNews.getNewsContent());
				ne.setIsNotice(une.getIsNotice());
				ne.setIsPicNews(une.getIsPicNews());
				ne.setIsAttach(une.getIsAttach());
				engNewsService.deleteNews(une);
				engNewsService.saveOrUpdateNews(ne);
				this.success = SUCCESS;
				return "checkNews";	
			
		}
		
		else
		{
			une.setNewsTitle(engNews.getNewsTitle());
			une.setEngSection(sect);
			une.setNewsContent(engNews.getNewsContent());
			une.setIsNotice(une.getIsNotice());
			une.setIsPicNews(une.getIsPicNews());
			une.setIsAttach(une.getIsAttach());
			une.setNewsStatus("2");
			engNewsService.saveOrUpdateNews(une);
			engNewsService.buildJsp();
			this.success = SUCCESS;
			return "checkNews";
		}
	}
	
	public String queryNewsTrans(){
		//查询所有待翻译和翻译过的新闻
		this.getLimit();
		this.getStart();
		this.totalProperty = engNewsService.queryNewsTransAmount();
		engNewsList = engNewsService.queryNewsTrans(start, limit);
		return "queryNewsTrans";
	}
	
	public String queryNewsUndetermined(){
		//查询待审核的新闻
		this.getLimit();
		this.getStart();
		engNewsList = engNewsService.queryNewsUndetermined(start,limit);
		this.totalProperty =engNewsList.size();
		return "queryNewsUndetermined";
	}

	
	public String queryNewsByPage() {
		//查询已发布的新闻
		this.getLimit();
		this.getStart();
		this.totalProperty = engNewsService.queryNewsAmount();
		engNewsList = engNewsService.queryNewsByPage(start, limit);
		this.success = SUCCESS;
		return "queryNewsByPage";
	}

	public String queryNewsUnderTrans(){
		//查询待翻译新闻
		this.getLimit();
		this.getStart();
		this.totalProperty = engNewsService.queryNewsAmount();
		engNewsList = engNewsService.queryNewsUnderTrans(start, limit);
		return "queryNewsUnderTrans";
	}

	public String addNews() {
		engNews.getNewsTitle();
		this.getNewsSection();
		engNews.getNewsAuthor();
		engNews.getIsNotice();
		engNews.getIsPicNews();
		engNews.getIsAttach();
		engNews.getNewsContent();
		this.getNewsAttachPath();
		this.getNewsPicPath();
		if (engNews.getIsPicNews() == 1) {
			engNews.setPicPath(newsPicPath);
			System.out.println(engNews.getPicPath());
		}
		System.out.println("是否公告+"+engNews.getIsNotice());
		if (engNews.getIsNotice() == 1) {
			engNews.setIsNotice(1);
			
		}
		if (engNews.getIsAttach() == 1) {
			engNews.setAttachPath(newsAttachPath);
			System.out.println(engNews.getAttachPath());
		}
		EngSection sect = engSectionService.querySectionByName(this.getNewsSection());
		engNews.setEngSection(sect);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间
		engNews.setNewsDate(curDate);
		engNews.setNewsStatus("1");
		engNewsService.saveOrUpdateNews(engNews);
		engNewsService.buildJsp();
		this.success = SUCCESS;
		
		return "addNews";
	}

	public String deleteNews() {
		String stmp = this.getNewsArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		EngNews engNews = engNewsService.queryNews((EngNews) jsonObject.toBean(jsonObject, EngNews.class));
		System.out.println("delete news"+engNews.getNewsId());
		if(engNewsService.deleteNews(engNews)) {
			engNewsService.buildJsp();
			this.success = SUCCESS;
		}
		return "deleteNews";
	}


	public String updateNews() {

		engNews.getNewsTitle();
		engNews.getNewsId();
		this.getNewsSection();
		engNews.getIsNotice();
		System.out.println("是否公告修改时："+engNews.getIsNotice());
		engNews.getNewsContent();

		EngSection sect = engSectionService.querySectionByName(this.getNewsSection());
		EngNews ne = engNewsService.queryNewsById(engNews.getNewsId());
	
		if(ne.getNewsStatus().equals("2"))
		{
			//如果已发布的修改后，则一直用最新的替换。
			List<EngNews> allEngNews=engNewsService.queryAllNews();
			for(int i= 0 ; i<allEngNews.size(); i++ )
			{ 
				
				 if(ne.getNewsId()==allEngNews.get(i).getOrigNewsId())
				 {
					    EngNews uneOrig =engNewsService.queryNewsByOrigId(ne.getNewsId());
					    uneOrig.setNewsTitle(engNews.getNewsTitle());
						uneOrig.setEngSection(sect);
						uneOrig.setNewsContent(engNews.getNewsContent());
						uneOrig.setIsNotice(engNews.getIsNotice());
						engNewsService.saveOrUpdateNews(uneOrig);
						this.success = SUCCESS;
						return "updateNews";
				 }
			}
			
			
			EngNews une = new EngNews();
		    une.setOrigNewsId(ne.getNewsId());
		    une.setAttachPath(ne.getAttachPath());
		    une.setChnNews(ne.getChnNews());
		    une.setEngSection(sect);
		    une.setIsAttach(ne.getIsAttach());
		    une.setIsNotice(engNews.getIsNotice());
		    une.setIsPicNews(ne.getIsPicNews());
		    une.setNewsAuthor(ne.getNewsAuthor());
		    une.setNewsClick(ne.getNewsClick());
		    une.setNewsContent(engNews.getNewsContent());
			une.setNewsDate(ne.getNewsDate());
			une.setNewsStatus("1");
			une.setNewsTitle(engNews.getNewsTitle());
			une.setPicPath(ne.getPicPath());
			engNewsService.saveOrUpdateNews(une);	
			this.success = SUCCESS;
			return "updateNews";
		    
		}
		else
		{
			ne.setNewsTitle(engNews.getNewsTitle());
			ne.setEngSection(sect);
			ne.setNewsContent(engNews.getNewsContent());
			ne.setIsNotice(engNews.getIsNotice());
			engNewsService.saveOrUpdateNews(ne);
			this.success = SUCCESS;
			return "updateNews";
		}
			
		
		}

	public String publishNews() {

		return "publishNews";
	}

	public String queryNewsBySectionId(){
		sectionId = this.getSectionId();
		page = this.getPage();
		size = this.getSize();
		engNewsList = engNewsService.queryNewsBySectionId(sectionId,page,size);
		System.out.println("答答大的法法师打发打发"+engNewsList.size());
		return "queryNewsBySectionId";
	}

	public String queryNewsAmountBySectionId(){
		sectionId = this.getSectionId();
		setNewsAmount(engNewsService.queryNewsAmountBySectionId(sectionId));
		return "queryNewsAmountBySectionId";
	}
	
	public String queryPicturenews(){
		page = this.getPage();
		size = this.getSize();
		engNewsList = engNewsService.queryPicturenews(page, size);
		return "queryPicturenews";
	}

	public String queryPicturenewsBySectionId(){
		this.getSectionId();
		this.getPage();
		this.getSize();
		engNewsList = engNewsService.queryPicturenewsBySectionId(sectionId, page, size);
		return "queryPicturenewsBySectionId";
	}
	
	public String queryPoint(){
		//查询头条新闻
		engNews =  engNewsService.queryPoint();
		System.out.println(engNews.getNewsTitle());
		return "queryPoint";
	}

	public String queryNotice(){
		page = this.getPage();
		size = this.getSize();
		engNewsList = engNewsService.queryNotice(page, size);
		return "queryNotice";
	}
	
	public String queryNoticeAmount(){
		setNewsAmount(engNewsService.queryNoticeAmount());
		System.out.println("方法反反复复反反复复反反复复反反复复:"+ newsAmount);
		
		
		return "queryNoticeAmount";
	}
	
	public String queryAttachedNews(){
		this.getPage();
		this.getSize();
		engNewsList = engNewsService.queryAttachedNews(page,size);
		return "queryAttachedNews";
	}
	public String queryAttachedNewsBySectionId(){
		this.getPage();
		this.getSize();
		this.getSectionId();
		engNewsList = engNewsService.queryAttachedNewsBySectionId(page,size,sectionId);
		return "queryAttachedNewsBySectionId";
	}
	public String queryNoticeBySectionId(){
		this.getSectionId();
		this.getPage();
		this.getSize();
		engNewsList = engNewsService.queryNoticeBySectionId(sectionId,page, size);
		return "queryNotice";
	}
	
	public String getNewsPicPath() {
		return newsPicPath;
	}

	public void setNewsPicPath(String newsPicPath) {
		this.newsPicPath = newsPicPath;
	}

	public String getNewsAttachPath() {
		return newsAttachPath;
	}

	public void setNewsAttachPath(String newsAttachPath) {
		this.newsAttachPath = newsAttachPath;
	}

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public EngNews getEngNews() {
		return engNews;
	}
	public void setEngNews(EngNews engNews) {
		this.engNews = engNews;
	}
	public List getEngNewsList() {
		return engNewsList;
	}

	public void seEngtNewsList(List<EngNews> engNewsList) {
		this.engNewsList = engNewsList;
	}

	public String getNewsSection() {
		return newsSection;
	}

	public void setNewsSection(String newsSection) {
		this.newsSection = newsSection;
	}

	public String getNewsArray() {
		return newsArray;
	}
	public void setNewsArray(String newsArray) {
		this.newsArray = newsArray;
	}

	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}


	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	public void setNewsAmount(int newsAmount) {
		this.newsAmount = newsAmount;
	}
	public int getNewsAmount() {
		return newsAmount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	

	@Resource(name="engNewsService")
	public void setEngNewsService(EngNewsService engNewsService) {
		this.engNewsService = engNewsService;
	}

	@Resource(name="engSectionService")
	public void setEngSectionService(EngSectionService engSectionService) {
		this.engSectionService = engSectionService;
	}




}

