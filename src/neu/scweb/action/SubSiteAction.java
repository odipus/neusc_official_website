package neu.scweb.action;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import neu.scweb.po.SubSite;
import neu.scweb.service.SubSiteService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@ParentPackage(value="json-default")
@Results({
	@Result(name="querySubSiteByCode",type="json",params={"excludeProperties","success"})
})
public class SubSiteAction extends ActionSupport{

	private String subSiteName;
	//private int subSite;
	private String success;
	private SubSite subSite;
	private String subSiteCode;
	private SubSiteService subSiteService;


	@Action(value="subSiteAction")

	public String querySubSiteByCode(){
		this.getSubSiteCode();
		if (subSiteCode.length() >10) {
			return "";
		}
		this.subSite= subSiteService.querySubSiteByCode(subSiteCode);
		this.setSuccess(SUCCESS);
		return "querySubSiteByCode";
	}

	public void duplicateSub() {

		/*
		 *服务器部署时使用
		 *
		String rePath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\template";
		String reNameS = ServletActionContext.getServletContext().getRealPath("") + "\\lab" + this.getSubSiteName();
		*/

		String rePath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\template";
		String reNameS = ServletActionContext.getServletContext().getRealPath("") + "\\lab" + this.getSubSiteName();
		/*
		 * 测试时 使用
		 
		 
		String rePath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\template";
		String reNameS = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\" + this.getSubSiteName();
		 */
		File reName = new File(reNameS);
		File reDir = new File(rePath);
		copy();
		reDir.renameTo(reName);
	}

	private static void copy() {
		/*
		 * 测试时 使用
		 
		String srcPath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\template";
		String destPath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab";
		 */

		String srcPath = ServletActionContext.getServletContext().getRealPath("") + "\\template";
		String destPath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\template";
		/*
		 * 服务器部署时使用
		String srcPath = ServletActionContext.getServletContext().getRealPath("") + "\\template";
		String destPath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\template";
		System.out.println(srcPath);
		System.out.println(destPath);
		*/

		File srcDir = new File(srcPath);
		File destDir = new File(destPath);
		try {
			FileUtils.copyDirectoryToDirectory(srcDir, destDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getSubSiteName() {
		return subSiteName;
	}

	public void setSubSiteName(String subSiteName) {
		this.subSiteName = subSiteName;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public SubSite getSubSite() {
		return subSite;
	}

	public void setSubSite(SubSite subSite) {
		this.subSite = subSite;
	}

	public String getSubSiteCode() {
		return subSiteCode;
	}

	public void setSubSiteCode(String subSiteCode) {
		this.subSiteCode = subSiteCode;
	}

	@Resource(name="subSiteService")
	public void setSubSiteService(SubSiteService subSiteService) {
		this.subSiteService = subSiteService;
	}



}
