package neu.scweb.po;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {
	private int newsId;
	private String newsTitle;     //新闻标题
	private String newsContent;   // 新闻内容
	private int isPicNews;        // 是否图片新闻
	private int isAttach;         //是否存在附件
	private Date newsDate;       //发布日期
	private String newsAuthor;    //发布人
	private int newsClick;         //点击量
	private int isNotice;          //是否公告
	private Date noticeValid;      //公告有效期
	private String newsHtmlPath;	//新闻页链接
	private int newsStatus;			//新闻发布状态
	private String picPath;			//图片新闻的图片链接
	private String attachPath;      //附件连接
	private String attachName;
	private Section section;		//新闻所属的板块
	
	
	@Id
	@GeneratedValue
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public int getIsPicNews() {
		return isPicNews;
	}
	public void setIsPicNews(int isPicNews) {
		this.isPicNews = isPicNews;
	}

	public int getIsAttach() {
		return isAttach;
	}
	public void setIsAttach(int isAttach) {
		this.isAttach = isAttach;
	}

	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}
	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public int getNewsClick() {
		return newsClick;
	}
	public void setNewsClick(int newsClick) {
		this.newsClick = newsClick;
	}

	public int getIsNotice() {
		return isNotice;
	}
	public void setIsNotice(int isNotice) {
		this.isNotice = isNotice;
	}

	public Date getNoticeValid() {
		return noticeValid;
	}
	public void setNoticeValid(Date noticeValid) {
		this.noticeValid = noticeValid;
	}

	public String getNewsHtmlPath() {
		return newsHtmlPath;
	}
	public void setNewsHtmlPath(String newsHtmlPath) {
		this.newsHtmlPath = newsHtmlPath;
	}

	public int getNewsStatus() {
		return newsStatus;
	}
	public void setNewsStatus(int newsStatus) {
		this.newsStatus = newsStatus;
	}

	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	
	
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle
				+ ", newsContent=" + newsContent + ", isPicNews=" + isPicNews
				+ ", isAttach=" + isAttach + ", newsDate=" + newsDate
				+ ", newsAuthor=" + newsAuthor + ", newsClick=" + newsClick
				+ ", isNotice=" + isNotice + ", noticeValid=" + noticeValid
				+ ", newsHtmlPath=" + newsHtmlPath + ", newsStatus="
				+ newsStatus + ", picPath=" + picPath + ", attachPath="
				+ attachPath + ", attachName=" + attachName + ", section="
				+ section +"]";
	}
	@ManyToOne
	@JoinColumn(name="news_sectionId")
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}

}
