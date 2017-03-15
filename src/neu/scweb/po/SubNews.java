package neu.scweb.po;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subnews")
public class SubNews {
	private int subNewsId;
	private String subNewsTitle;
	private String newsContent;
	private int isPicNews;
	private int isAttach;
	private Date newsDate;
	private String subNewsAuthor;
	private int newsClick;
	private int isNotice;
	private Date noticeValid;
	private String newsHtmlPath;
	private int newsStatus;
	private String picPath;
	private String attachPath;
	private SubSite subSite;

	@Id
	@GeneratedValue
	public int getSubNewsId() {
		return subNewsId;
	}
	public void setSubNewsId(int subNewsId) {
		this.subNewsId = subNewsId;
	}

	public String getSubNewsTitle() {
		return subNewsTitle;
	}
	public void setSubNewsTitle(String subNewsTitle) {
		this.subNewsTitle = subNewsTitle;
	}

	public String getSubNewsAuthor() {
		return subNewsAuthor;
	}
	public void setSubNewsAuthor(String subNewsAuthor) {
		this.subNewsAuthor = subNewsAuthor;
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

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="subNews_subSiteId")
	public SubSite getSubSite() {
		return subSite;
	}
	public void setSubSite(SubSite subSite) {
		this.subSite = subSite;
	}
}
