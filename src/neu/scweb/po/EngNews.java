package neu.scweb.po;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "engNews")
public class EngNews {
	private int newsId;
	private int origNewsId; // 若为副本，则该字段为对应新闻的id，默认为0
	private String newsTitle; // 新闻标题
	private String newsContent; // 新闻内容
	private int isPicNews; // 是否图片新闻
	private int isAttach; // 是否存在附件
	private Date newsDate; // 发布日期
	private String newsAuthor; // 发布人
	private int newsClick; // 点击量
	private int isNotice; // 是否公告
	private String picPath; // 图片新闻的图片链接
	private String attachPath; // 附件连接
	private EngSection engSection; // 新闻所属的板块
	private int ChnNews; // 对应的中文新闻Id
	private String newsStatus; // 新闻的状态，待翻译 0，待审核 1，已发布 2

	@Id
	@GeneratedValue
	public int getNewsId() {
		return newsId;
	}

	public EngNews() {
		this.setNewsContent("");
		this.setNewsTitle("");
		this.setNewsAuthor("");

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

	public String getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}

	public int getChnNews() {
		return ChnNews;
	}

	public void setChnNews(int chnNews) {
		ChnNews = chnNews;
	}

	public int getOrigNewsId() {
		return origNewsId;
	}

	public void setOrigNewsId(int origNewsId) {
		this.origNewsId = origNewsId;
	}

	@ManyToOne
	@JoinColumn(name = "news_sectionId")
	public EngSection getEngSection() {
		return engSection;
	}

	public void setEngSection(EngSection engSection) {
		this.engSection = engSection;
	}

}
