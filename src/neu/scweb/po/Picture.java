package neu.scweb.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// 图片转存数据库 类
@Entity
@Table(name = "picture")
public class Picture {
	private int picId;
	private String picPath;    		//图片原路径
	private byte[]  picContent; //图片内容 直接用blob 存储到数据库中
								//图片转存后的二进制代码
	private String picName;			//图片给的名称 与新闻名称 相关联
	private String picAuthor;		//图片的作者
	private Date picSubmitTime;		//图片的提交时间按
	private int isDel; 				//是都 有效   1代表有效 0代表已经被删除
	private int isIndexPic;			// 是否为主页新闻， 1 代表 是 	0代表否
	private int isContentPic;		// 是否为内容新闻，1代表 是	0代表否
	private int newsId;				//所属 新闻的ID
	

	@Id
	@GeneratedValue
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
	
	public void setNews(News news){
//		String picNameString =;
		this.setPicName(news.getIsPicNews() == 1?"新闻内图片-"+news.getNewsTitle():"图片新闻");
		this.setPicAuthor(news.getNewsAuthor());
		this.setNewsId(news.getNewsId());
		this.setPicPath(news.getPicPath());
		this.setPicSubmitTime(news.getNewsDate());
		this.setIsIndexPic(news.getIsPicNews());
		
	}
	@Override
	public String toString() {
		return "Picture [picId=" + picId + ", picPath=" + picPath
				+ ", picContent=" + picContent + ", picName=" + picName
				+ ", picAuthor=" + picAuthor + ", picSubmitTime="
				+ picSubmitTime + ", isDel=" + isDel + ", isIndexPic="
				+ isIndexPic + ", isContentPic=" + isContentPic + ", newsId="
				+ newsId + "]";
	}
	
	
	
	
}
