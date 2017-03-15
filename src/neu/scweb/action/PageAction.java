package neu.scweb.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import neu.scweb.po.Page;
import neu.scweb.service.PageService;



import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllList", type="json", params={"excludeProperties","success"}),
	@Result(name="queryPagesByUpperPage", type="json", params={"excludeProperties","success"}),
	@Result(name="queryPageById", type="json", params={"excludeProperties","success"}),
	@Result(name="addPage", type="json", params={"includeProperties","success"}),
	@Result(name="deletePage", type="json", params={"includeProperties","success"}),
	@Result(name="updatePage", type="json", params={"includeProperties","success"})
	
	
})
public class PageAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Page page;
	private int pageId;
	private int upperPage;
	private int isList;
	private List<Page> pageList;
	private String success;
	

	private PageService pageService;


	@Action(value="pageAction")
	public String queryPageById(){
	
		this.getPageId();
		System.out.println("pageId="+pageId);
		page = pageService.queryPageById(pageId);
		return "queryPageById";
	}
	
	public String  queryAllList(){
		pageList = pageService.queryAllList();
		return "queryAllList";
		
	}
	public String addPage(){
		page.getPageTitle();
		page.getPageContent();
		page.getUpperPage();
		pageService.saveOrUpdatePage(page);
		this.success = SUCCESS;
		return "addPage";
	}
	public String deletePage(){
		this.getPageId();
		pageService.deletePage(pageId);
		this.success = SUCCESS;
		return "deletePage";
	}
	public String updatePage(){
		page.getPageTitle();
		page.getPageContent();
		page.getUpperPage();
		page.getPageId();
		pageService.saveOrUpdatePage(page);
		this.success = SUCCESS;
		return "updatePage";
	}
	
	public String queryPagesByUpperPage(){
		this.getUpperPage();
		pageList = pageService.queryPagesByUpperPage(upperPage);
		return "queryPagesByUpperPage";	
	}
	

	

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public int getUpperPage() {
		return upperPage;
	}
	public void setUpperPage(int upperPage) {
		this.upperPage = upperPage;
	}
	public int getIsList() {
		return isList;
	}
	public void setIsList(int isList) {
		this.isList = isList;
	}
	public List<Page> getPageList() {
		return pageList;
	}

	public void setPageList(List<Page> pageList) {
		this.pageList = pageList;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Resource(name="pageService")
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}



}
