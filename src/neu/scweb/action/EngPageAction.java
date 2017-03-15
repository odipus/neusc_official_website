package neu.scweb.action;
import java.util.List;

import javax.annotation.Resource;

import neu.scweb.po.EngPage;
import neu.scweb.service.EngPageService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

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
public class EngPageAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private EngPage engPage;
	private int pageId;
	private int upperPage;
	private int isList;
	private List<EngPage> pageList;
	private String success;
	private EngPageService engPageService;

	@Action(value="engPageAction")
	public String queryPageById(){
		this.getPageId();
		System.out.println("pageId="+pageId);
		engPage = engPageService.queryPageById(pageId);
		return "queryPageById";
	}
	public String  queryAllList(){
		pageList = engPageService.queryAllList();
		return "queryAllList";
		
	}
	public String addPage(){
		engPage.getPageTitle();
		engPage.getPageContent();
		engPage.getUpperPage();
		engPageService.saveOrUpdatePage(engPage);
		this.success = SUCCESS;
		return "addPage";
	}
	public String deletePage(){
		this.getPageId();
		engPageService.deletePage(pageId);
		this.success = SUCCESS;
		return "deletePage";
	}
	public String updatePage(){
		engPage.getPageTitle();
		engPage.getPageContent();
		engPage.getUpperPage();
		engPage.getPageId();
		engPageService.saveOrUpdatePage(engPage);
		this.success = SUCCESS;
		return "updatePage";
	}
	
	public String queryPagesByUpperPage(){
		this.getUpperPage();
		pageList = engPageService.queryPagesByUpperPage(upperPage);
		return "queryPagesByUpperPage";	
	}
	public EngPage getEngPage() {
		return engPage;
	}
	public void setEngPage(EngPage engPage) {
		this.engPage = engPage;
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
	public List<EngPage> getPageList() {
		return pageList;
	}
	public void setPageList(List<EngPage> pageList) {
		this.pageList = pageList;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
	@Resource(name="engPageService")
	public void setEngPageService(EngPageService engPageService) {
		this.engPageService = engPageService;
	}
}
