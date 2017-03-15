package neu.scweb.po;

import java.util.Date;

public class ExpandNews  extends News{
	

	//	private int newsId;
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
//	private String picPath;			//图片新闻的图片链接
	private String attachPath;      //附件连接
	private String attachName;
	private Section section;		//新闻所属的板块

	private int picId;
	private String picPath;    		//图片原路径
	private byte[] picContent; 		//图片转存后的二进制代码
	private String picName;			//图片给的名称 与新闻名称 相关联
	private String picAuthor;		//图片的作者
	private Date picSubmitTime;		//图片的提交时间按
	private int isDel; 				//是都 有效   1代表有效 0代表已经被删除
	private int isIndexPic;			// 是否为主页新闻， 1 代表 是 	0代表否
	private int isContentPic;		// 是否为内容新闻，1代表 是	0代表否
	private int newsId;				//所属 新闻的ID
	
	
	public void setNews(News oldNews ){
		setNewsTitle(oldNews.getNewsTitle()== null ? null :oldNews.getNewsTitle() );
		setNewsContent(oldNews.getNewsContent()== null ? null :oldNews.getNewsContent() );
		setIsPicNews(oldNews.getIsPicNews());
		setIsAttach(oldNews.getIsAttach() );
		setNewsDate(oldNews.getNewsDate()== null ? null :oldNews.getNewsDate() );
		setNewsAuthor(oldNews.getNewsAuthor()== null ? null :oldNews.getNewsAuthor() );
		setNewsClick(oldNews.getNewsClick());
		setIsNotice(oldNews.getIsNotice());
		setNoticeValid(oldNews.getNoticeValid()== null ? null : oldNews.getNoticeValid());
		setNewsHtmlPath(oldNews.getNewsHtmlPath()== null ? null : oldNews.getNewsHtmlPath());
		setNewsStatus(oldNews.getNewsStatus());
		setAttachName(oldNews.getAttachName()== null ? null : oldNews.getAttachName());
		setAttachPath(oldNews.getAttachPath()== null ? null : oldNews.getAttachPath());
		setSection(oldNews.getSection()== null ? null : oldNews.getSection());
	}
	
	public void setPicture(Picture oldPicture) {
		setPicId(oldPicture.getPicId());
		setPicPath(oldPicture.getPicPath()==null?null:oldPicture.getPicPath());
		setPicContent(oldPicture.getPicContent());
		setPicName(oldPicture.getPicName()==null?null:oldPicture.getPicName());
		setPicAuthor(oldPicture.getPicAuthor()==null?null:oldPicture.getPicAuthor());
		setPicSubmitTime(oldPicture.getPicSubmitTime());
		setIsDel(oldPicture.getIsDel());
		setIsContentPic(oldPicture.getIsContentPic());
		setNewsId(oldPicture.getNewsId());
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
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public byte[] getPicContent() {
		return picContent;
	}
	public void setPicContent(byte[] picContent) {
		this.picContent = picContent;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getPicAuthor() {
		return picAuthor;
	}
	public void setPicAuthor(String picAuthor) {
		this.picAuthor = picAuthor;
	}
	public Date getPicSubmitTime() {
		return picSubmitTime;
	}
	public void setPicSubmitTime(Date picSubmitTime) {
		this.picSubmitTime = picSubmitTime;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsIndexPic() {
		return isIndexPic;
	}
	public void setIsIndexPic(int isIndexPic) {
		this.isIndexPic = isIndexPic;
	}
	public int getIsContentPic() {
		return isContentPic;
	}
	public void setIsContentPic(int isContentPic) {
		this.isContentPic = isContentPic;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	@Override
	public String toString() {
		return "ExpandNews [newsTitle=" + newsTitle + ", newsContent="
				+ newsContent + ", isPicNews=" + isPicNews + ", isAttach="
				+ isAttach + ", newsDate=" + newsDate + ", newsAuthor="
				+ newsAuthor + ", newsClick=" + newsClick + ", isNotice="
				+ isNotice + ", noticeValid=" + noticeValid + ", newsHtmlPath="
				+ newsHtmlPath + ", newsStatus=" + newsStatus + ", attachPath="
				+ attachPath + ", attachName=" + attachName + ", section="
				+ section + ", picId=" + picId + ", picPath=" + picPath
				+ ", picContent=" + picContent + ", picName=" + picName
				+ ", picAuthor=" + picAuthor + ", picSubmitTime="
				+ picSubmitTime + ", isDel=" + isDel + ", isIndexPic="
				+ isIndexPic + ", isContentPic=" + isContentPic + ", newsId="
				+ newsId + "]";
	}
	
	
}
