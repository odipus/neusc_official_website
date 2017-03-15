package neu.scweb.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import neu.scweb.po.EngNews;
import neu.scweb.po.News;
import neu.scweb.po.Picture;
import neu.scweb.po.Section;
import neu.scweb.service.AuthPrivilegeService;
import neu.scweb.service.EngNewsService;
import neu.scweb.service.NewsService;
import neu.scweb.service.PictureService;
import neu.scweb.service.RoleService;
import neu.scweb.service.SectionService;
import neu.scweb.util.ScImgUtil;

@ParentPackage(value = "json-default")
@Results({
		@Result(name = "queryAllNews", type = "json", params = { "excludeProperties",
				"roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryNewsBySectionId", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryNewsAmountBySectionId", type = "json", params = { "includeProperties",
				"success,newsAmount" }),
		@Result(name = "queryNoticeAmount", type = "json", params = { "includeProperties", "success,newsAmount" }),
		@Result(name = "queryNotice", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryPicturenews", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "addNews", type = "json", params = { "includeProperties", "success" }),
		@Result(name = "updateNews", type = "json", params = { "includeProperties", "success" }),
		@Result(name = "deleteNews", type = "json", params = { "includeProperties", "success" }),
		@Result(name = "publishNews", type = "json", params = { "includeProperties", "success" }),
		@Result(name = "queryAllNewsByPage", type = "json", params = { "excludeProperties",
				"roleId,newsAttachPath,newsPicPath,newsSection,news,newsArray,newsId,sectionId,newsAmount,size,page" }),
		@Result(name = "queryNews", type = "json", params = { "excludeProperties",
				"roleId,newsList,newsSection,newsArray,newsId" }),
		@Result(name = "queryAuthNews", type = "json", params = { "excludeProperties",
				"roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryNoticeBySectionId", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryAttachedNews", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryAttachedNewsAmount", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryAttachedNewsBySectionId", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "queryPicturenewsBySectionId", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "searchNewsTitle", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }),
		@Result(name = "searchNewsContent", type = "json", params = { "excludeProperties",
				"news,newsArray,newsAttachPath,newsPicPath,limit,start,totalProperty,page,size,newsAmount,roleId,news,newsSection,newsArray,newsId" }) })
public class NewsAction extends ActionSupport {

	private PictureService pictureService;
	private NewsService newsService;
	private EngNewsService engNewsService;
	private SectionService sectionService;
	private RoleService roleService;
	private AuthPrivilegeService apService;
	private List<News> newsList;
	private String success;
	private String newsSection;
	private Picture picture;
	private News news;
	private EngNews engNews;
	private String newsArray;
	private String newsPicPath;
	private String newsAttachPath;
	private int newsId;
	private int sectionId;
	private int roleId;
	private int isEng;

	// 以下参数用于前台分页，page表示当前需要第几页的内容，size表示每一页的容量,newsAmount表示新闻总数
	private int page;
	private int size;
	private int newsAmount;
	// 以下数据用于后台分页
	private int limit;
	private int start;
	private int totalProperty;
	// int num=0;
	// 检索词
	private String search;

	@Action(value = "newsAction")
	public String queryAllNews() {
		this.getRoleId();
		// System.out.println(this.getAuthNews());
		newsList = newsService.queryAuthNews(apService.querySectByRoleId(roleId));
//		System.out.println("\n\n\n			queryAllNews" + newsList.size() + "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		this.success = SUCCESS;
		return "queryAllNews";
	}

	public String searchNewsTitle() {
		this.getSearch();
		newsList = newsService.searchNewsTitle(search);
		return "searchNewsTitle";
	}

	public String searchNewsContent() {
		this.getSearch();
		newsList = newsService.searchNewsContent(search);
		return "searchNewsContent";
	}

	public String queryAllNewsByPage() {
		this.getLimit();
		this.getStart();
		this.getRoleId();
		this.totalProperty = newsService.queryNewsAmount(roleId);
		newsList = newsService.queryAuthNewsByPage(apService.querySectByRoleId(roleId), start, limit);

		// HttpServletRequest request = ServletActionContext.getRequest();
		// String basePath = request.getServletContext().getRealPath("/");
		// //已经更新完所有的图片
		// System.out.println("作死开始 转换所有可以找到的新闻图片！");
		// newsList = newsService.queryAllNews();
		// System.out.println("新闻总数目："+newsList.size());
		// for (News news : newsList) {
		// if (news.getNewsId()<1900) {
		// continue;
		// }
		// System.out.println(news.getNewsTitle()+":::::"+news.getNewsId()+"||||||||||||"+news.getIsPicNews());
		// if (news.getIsPicNews() ==1) {
		// picture = new Picture();
		// picture.setNews(news);
		// Blob picContent = ScPutAndGetImg.readFromImg(basePath
		// + picture.getPicPath());
		// if (picContent == null) {
		// continue;
		// }else if (pictureService.queryPicture(picture) != null) {
		// continue;
		// }else {
		// picture.setPicContent(picContent);
		// pictureService.addPicture(picture);
		// System.out.println("set success \n\n"+ num++ +"\n\n\n");
		// continue;
		// }
		// }
		// }
		// newsList = newsService.queryAllNews();
		this.success = SUCCESS;
		return "queryAllNewsByPage";
	}

	public String queryAttachedNewsAmount() {
		newsAmount = newsService.queryAttachedNewsAmount();
		this.success = SUCCESS;
		return "queryAttachedNewsAmount";
	}

	public String addNews() {
		news.getNewsTitle();
		this.getNewsSection();
		news.getNewsAuthor();
		news.getIsNotice();
		news.getIsPicNews();
		news.getIsAttach();
		news.getNewsContent();
		news.getAttachName();
		this.getNewsAttachPath();
		this.getNewsPicPath();
		this.getIsEng();
		if (news.getIsNotice() == 1) {
			news.getNoticeValid();
			System.out.println(news.getNoticeValid());
		}
		if (news.getIsPicNews() == 1) {
			news.setPicPath(newsPicPath);
			System.out.println(news.getPicPath());
		}
		if (news.getIsAttach() == 1) {
			news.setAttachPath(newsAttachPath);
			System.out.println(news.getAttachPath());
		}
		System.out.println("所属section" + newsSection);
		Section sect = new Section();
		System.out.println();
		sect = sectionService.querySectionByName(this.getNewsSection());

		news.setSection(sect);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		news.setNewsDate(curDate);
		System.out.println("发布新闻：" + news.getNewsTitle());
		newsService.saveOrUpdateNews(news);

		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath = request.getServletContext().getRealPath("/");
		News heheNews = newsService.queryNewsById(news.getNewsId()); // hehe 仅表达
																		// 此时此刻软件工程答辩安排的
																		// 心情
																		// System.out.println("\n\n\n"
																		// +
																		// heheNews.toString()
		// + "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		if (ScImgUtil.GetImgPic(heheNews.getNewsContent())!= null) {
			ArrayList<String> imgPicPathList = ScImgUtil.GetImgPic(heheNews.getNewsContent());
			for (String string : imgPicPathList) {
				picture = new Picture();
				picture.setNews(heheNews);
				picture.setPicPath(string);
//				picture.setIsIndexPic(0);
				picture.setIsContentPic(1);
				byte[] picContent = ScImgUtil.readFromImg(basePath + string);
				picture.setPicContent(picContent);
				pictureService.addPicture(picture);
			}
		}
		
		if (news.getIsPicNews() == 1 ) {
			picture = new Picture();
			picture.setNews(heheNews);
			byte[] picContent = ScImgUtil.readFromImg(basePath + picture.getPicPath());
			picture.setPicContent(picContent);
//			picture.setIsIndexPic(1);
			picture.setIsContentPic(0);
			pictureService.addPicture(picture);
		}
		if (isEng == 1) {
			engNewsService.convertNews(news);
		}
		newsService.buildJsp(news.getSection());
		this.success = SUCCESS;
		return "addNews";
	}

	public String deleteNews() {
		String stmp = this.getNewsArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		News news = newsService.queryNews((News) jsonObject.toBean(jsonObject, News.class));
		System.out.println("delete news" + news.getNewsId());
		Section sec = news.getSection();

		Picture picture = new Picture();
		picture.setNews(news);
		picture.setIsContentPic(0);
		picture = pictureService.queryPicture(picture);
		
		if (newsService.deleteNews(news)) {
			newsService.buildJsp(sec);
			if (picture != null) {
				pictureService.deletePicture(picture);
			}
			if (ScImgUtil.GetImgPic(news.getNewsContent())!= null) {
				ArrayList<String> imgPicPathList = ScImgUtil.GetImgPic(news.getNewsContent());
				for (String string : imgPicPathList) {
					picture = new Picture();
					picture.setNews(news);
					picture.setPicPath(string);
					picture.setIsContentPic(1);
					pictureService.deletePicture(picture);
				}
			}
			this.success = SUCCESS;
		}
		return "deleteNews";
	}

	
	public String queryNews() {
		this.getNewsId();
		this.news = newsService.queryNewsById(newsId);
		news.setNewsClick(news.getNewsClick() + 1);
		newsService.saveOrUpdateNews(news);
//		System.out.println("更新成功");
		if (ScImgUtil.GetImgPic(news.getNewsContent())!= null) {
			String newsContent= news.getNewsContent();
//			System.out.println("获取新闻内容"+newsContent);
			ArrayList<String> imgPicPathList = ScImgUtil.GetImgPic(news.getNewsContent());
//			System.out.println("获取  相应路径信息："+imgPicPathList);
			for (String string : imgPicPathList) {
//				System.out.println("遍历图片路径："+string);
				picture = new Picture();
				picture.setNews(news);
//				System.out.println("picture.setNews(news);："+string);
				picture.setPicPath(string);
				picture.setIsContentPic(1);
//				System.out.println("picture.setIsContentPic(1);;："+string);
				
				picture = pictureService.queryPicture(picture);
				if (picture != null) {
//					System.out.println("	picture = pictureService.queryPicture(picture);;;："+string);
					String picbase = Base64.getEncoder().encodeToString(picture.getPicContent());
//					newsContent = newsContent.replace("/ScWeb"+string, "data:image/png;base64,"+picbase);
					newsContent = newsContent.replace("/ScWeb", "");
					newsContent = newsContent.replace(string, "data:image/png;base64,"+picbase);
//					System.out.println(picbase);
//					System.out.println("替换"+string+"成功@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
				}
			}
//			System.out.println(newsContent);
			news.setNewsContent(newsContent);
		}
		if (1 == news.getIsPicNews()) {

			picture = new Picture();
			picture.setNews(news);
			picture = pictureService.queryPicture(picture) ;
			if (picture!= null && picture.getPicContent()!= null ) {
				String picbase = Base64.getEncoder().encodeToString(picture.getPicContent());
				news.setNewsHtmlPath(picbase);
			}
		}
		this.success = SUCCESS;
		return "queryNews";
	}

	public String updateNews() {

		news.getNewsTitle();
		news.getNewsId();
		this.getNewsSection();
		news.getIsNotice();
		news.getNewsContent();
		news.getNewsAuthor();
		news.getNewsDate();
		news.getNoticeValid();

		if (news.getIsNotice() == 1) {
			news.getNoticeValid();
			System.out.println(news.getNoticeValid());
		}
		Section sect = sectionService.querySectionByName(this.getNewsSection());

		News ne = newsService.queryNewsById(news.getNewsId());
		ne.setNewsTitle(news.getNewsTitle());
		ne.setSection(sect);
		ne.setNewsContent(news.getNewsContent());
		ne.setIsNotice(news.getIsNotice());
		if (ne.getIsNotice() == 1) {
			ne.setNoticeValid(news.getNoticeValid());
		}

		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath = request.getServletContext().getRealPath("/");
		if (ScImgUtil.GetImgPic(ne.getNewsContent())!= null) {
			ArrayList<String> imgPicPathList = ScImgUtil.GetImgPic(ne.getNewsContent());
			for (String string : imgPicPathList) {
				picture = new Picture();
				picture.setNews(ne);
				picture.setPicPath(string);
				picture.setIsIndexPic(ne.getIsPicNews());
				picture.setIsContentPic(1);
				if (pictureService.queryPicture(picture) == null) {
					byte[] picContent = ScImgUtil.readFromImg(basePath + string);
					picture.setPicContent(picContent);
					pictureService.addPicture(picture);
				}
			}
		}
		if (1 == ne.getIsPicNews()) {
			Picture new_picture = new Picture();
			new_picture.setNews(ne);
			System.out.println(new_picture.toString());
			new_picture = pictureService.queryPicture(new_picture);
			new_picture.setNews(ne);
			pictureService.updatePicture(new_picture);
		}

		newsService.saveOrUpdateNews(ne);
		newsService.buildJsp(ne.getSection());
		this.success = SUCCESS;
		return "updateNews";
	}

	public String publishNews() {
		String stmp = this.getNewsArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		News news = newsService.queryNews((News) jsonObject.toBean(jsonObject, News.class));
		System.out.println(news.getNewsId());
		news.setNewsStatus(1);
		if (newsService.saveOrUpdateNews(news)) {
			newsService.buildJsp(news.getSection());
			this.success = SUCCESS;
		}
		return "publishNews";
	}

	public String queryNewsBySectionId() {
		sectionId = this.getSectionId();
		page = this.getPage();
		size = this.getSize();
		newsList = newsService.queryNewsBySectionId(sectionId, page, size);
		return "queryNewsBySectionId";
	}

	public String queryNewsAmountBySectionId() {
		sectionId = this.getSectionId();
		setNewsAmount(newsService.queryNewsAmountBySectionId(sectionId));
		return "queryNewsAmountBySectionId";
	}

	public String queryNoticeAmount() {
		setNewsAmount(newsService.queryNoticeAmount());
		return "queryNoticeAmount";
	}

	public String queryPicturenews() {
		page = this.getPage();
		size = this.getSize();
		newsList = newsService.queryPicturenews(page, size);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!图片新闻：" + newsList.size());
		return "queryPicturenews";
	}

	public String queryPicturenewsBySectionId() {
		this.getSectionId();
		this.getPage();
		this.getSize();
		
		newsList = newsService.queryPicturenewsBySectionId(sectionId, page, size);
		for (News news : newsList) {
			if (1 == news.getIsPicNews()) {

				picture = new Picture();
				picture.setNews(news);
				picture = pictureService.queryPicture(picture) ;
			    String picbase = Base64.getEncoder().encodeToString(picture.getPicContent());
				news.setNewsHtmlPath(picbase);
			}
		}
		return "queryPicturenewsBySectionId";
	}

	public String queryNotice() {
		page = this.getPage();
		size = this.getSize();
		newsList = newsService.queryNotice(page, size);
		return "queryNotice";
	}

	public String queryAttachedNews() {
		this.getPage();
		this.getSize();
		newsList = newsService.queryAttachedNews(page, size);
		System.out.println("附件新闻" + newsList.size());
		return "queryAttachedNews";
	}

	public String queryAttachedNewsBySectionId() {
		this.getPage();
		this.getSize();
		this.getSectionId();
		newsList = newsService.queryAttachedNewsBySectionId(page, size, sectionId);
		System.out.println("附件新闻section" + sectionId + "大小" + newsList.size());
		return "queryAttachedNewsBySectionId";
	}

	public String queryNoticeBySectionId() {
		this.getSectionId();
		this.getPage();
		this.getSize();
		newsList = newsService.queryNoticeBySectionId(sectionId, page, size);
		return "queryNotice";
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String queryAuthNews() {

		return "queryAuthNews";
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

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List getNewsList() {
		return newsList;
	}

	public void setNewsList(List newsList) {
		this.newsList = newsList;
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

	public int getIsEng() {
		return isEng;
	}

	public void setIsEng(int isEng) {
		this.isEng = isEng;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public EngNews getEngNews() {
		return engNews;
	}

	public void setEngNews(EngNews engNews) {
		this.engNews = engNews;
	}

	@Resource(name = "newsService")
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@Resource(name = "engNewsService")
	public void setEngNewsService(EngNewsService engNewsService) {
		this.engNewsService = engNewsService;
	}

	@Resource(name = "sectionService")
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Resource(name = "authPrivilegeService")
	public void setApService(AuthPrivilegeService apService) {
		this.apService = apService;
	}

	@Resource(name = "pictureService")
	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}
}
