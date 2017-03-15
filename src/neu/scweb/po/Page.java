package neu.scweb.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="page")
public class Page {
	private int pageId;
	private String pageTitle;         //页面名称
	private String pageContent;       //页面内容
	private int isList;    			  //如果是1，则是二级页面，0是三级页面
	private int upperPage;         //每一个三级页，必然对应一个二级页面
	
	
	@Id
	@GeneratedValue
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageContent() {
		return pageContent;
	}
	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}
	public int getIsList() {
		return isList;
	}
	public void setIsList(int isList) {
		this.isList = isList;
	}
	public int getUpperPage() {
		return upperPage;
	}
	public void setUpperPage(int upperPage) {
		this.upperPage = upperPage;
	}
	
	
	
	
	
	
}
