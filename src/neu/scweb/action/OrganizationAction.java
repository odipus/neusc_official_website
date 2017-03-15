package neu.scweb.action;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import net.sf.json.JSONObject;
import neu.scweb.po.Organization;
import neu.scweb.po.Role;
import neu.scweb.po.SubSite;
import neu.scweb.service.OrganizationService;
import neu.scweb.service.RoleService;
import neu.scweb.service.SubSiteService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllOrgs",type="json",params={"excludeProperties","success,org,orgArray"}),
	@Result(name="queryAllTchOrgs",type="json",params={"excludeProperties","success,org,orgArray"}),
	@Result(name="queryAllOrgsByPage",type="json",params={"excludeProperties","limit,start,roleId,orgArray,org"}),
	@Result(name="queryOrgById",type="json",params={"excludeProperties","role,orgList,totalProperty,limit,start,roleId,orgArray"}),
	//@Result(name="queryOrgById",type="json",params={"includeProperties","org"}),
	@Result(name="addOrg",type="json",params={"includeProperties","success"}),
	@Result(name="deleteOrg",type="json",params={"includeProperties","success"}),
	@Result(name="updateOrg",type="json",params={"includeProperties","success"})
})
public class OrganizationAction extends ActionSupport{
	private OrganizationService orgService;
	private SubSiteService subSiteService;
	private RoleService roleService;
	private Organization org;
	private String orgArray;
	private String success;
	private SubSite subSite;
	private Role role;
	private List<Organization> orgList;
	private int orgId;
	private int roleId;
	private int start;
	private int limit;
	private int totalProperty;

	@Action(value="orgAction")
	public String queryAllOrgs() {
		orgList = orgService.queryAllOrgs();
		this.success = SUCCESS;
		return "queryAllOrgs";
	}
	
	public String queryAllTchOrgs(){
		//遍历所有的研究所
		orgList = orgService.queryAllTchOrgs();
		this.success = SUCCESS;
		return "queryAllTchOrgs";
	}

	public String queryAllOrgsByPage() {
		this.getStart();
		this.getLimit();
		this.totalProperty = orgService.queryOrgAmount();
		orgList = orgService.queryAllOrgsByPage(start, limit);
		this.success = SUCCESS;
		return "queryAllOrgsByPage";
	}

	public String queryOrgById(){
		orgId = this.getOrgId();
		org = orgService.queryOrgById(orgId);
		this.success = SUCCESS;
		return "queryOrgById";
	}

	public String addOrg() {
		this.getRoleId();
		org.getOrgName();
		org.getOrgDuty();
		org.getOrgCode();
		org.getSubSite();
		orgService.saveOrUpdateOrg(org);
		role = roleService.queryRoleById(roleId);
		subSite = new SubSite();
		subSite.setSubSiteName(org.getOrgName());
		subSite.setSubSiteCode(org.getOrgCode());
		//String subSitePath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\" + org.getOrgCode();
		//subSite.setSubSitePath(subSitePath);
		//subSite.setRole(roleService.queryRoleById(roleId));
		/*
		 *
		 * 服务器部署时使用
		 *
		 * String subSitePath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\" + org.getOrgCode();
		 *
		 */

		if(org.getSubSite() == 1) {
			subSiteService.updateSubSite(subSite);
			role.getSubSites().add(subSite);
			try {
				roleService.saveOrUpdateRole(role);
			} catch (Exception e) {
				roleService.mergeRole(role);
			}
		}
		this.success = SUCCESS;
		return "addOrg";
	}

	public String deleteOrg() {
		String stmp = this.getOrgArray();
		this.getRoleId();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		Organization org = (Organization) jsonObject.toBean(jsonObject, Organization.class);
		if(orgService.deleteOrg(org)) {
			if(org.getSubSite() == 1) {
				//deleteDir(org.getOrgCode());
				//subSite = subSiteService.querySubSite(roleId, org.getOrgName(), org.getOrgCode());
				subSite = subSiteService.querySubSiteByCode(org.getOrgCode());
				if(subSite != null) {
					subSiteService.deleteSubSite(subSite);
				}
			}
			this.success = SUCCESS;
		}
		return "deleteOrg";
	}

	public String updateOrg() {
		String stmp = this.getOrgArray();
		this.getRoleId();
		stmp = stmp.substring(1,stmp.length()-1);
		String[] sp = stmp.split("},");
		role = roleService.queryRoleById(roleId);
		for(int i = 0; i < sp.length; i++) {
			String ss = sp[i];
			if(ss.endsWith("}")) {
				JSONObject jsonObject = JSONObject.fromObject(ss);
				Organization org = (Organization) jsonObject.toBean(jsonObject, Organization.class);
				orgService.saveOrUpdateOrg(org);
				//String dir = org.getOrgCode();
				if(org.getSubSite() == 1) {
					SubSite ss1 = subSiteService.querySubSiteByName(org.getOrgName());
					if(ss1 == null) {
						subSite = new SubSite();
						subSite.setSubSiteName(org.getOrgName());
						subSite.setSubSiteCode(org.getOrgCode());
						subSiteService.saveOrUpdateSubSite(subSite);
						role.getSubSites().add(subSite);
					}
				}
				else {
					SubSite ss2 = subSiteService.querySubSiteByName(org.getOrgName());
					if(ss2 != null) {
						subSiteService.deleteSubSite(ss2);
					}
					//subSiteService.deleteSubSite(subSiteService.querySubSite(roleId, org.getOrgName(), org.getOrgCode()));
				}
			}
			else {
				ss = ss + "}";
				JSONObject jsonObject = JSONObject.fromObject(ss);
				Organization org = (Organization) jsonObject.toBean(jsonObject, Organization.class);
				orgService.saveOrUpdateOrg(org);
				//String dir = org.getOrgCode();
				if(org.getSubSite() == 1) {
					SubSite ss1 = subSiteService.querySubSiteByName(org.getOrgName());
					if(ss1 == null) {
						subSite = new SubSite();
						subSite.setSubSiteName(org.getOrgName());
						subSite.setSubSiteCode(org.getOrgCode());
						role.getSubSites().add(subSite);
					}
				}
				else {
					SubSite ss2 = subSiteService.querySubSiteByName(org.getOrgName());
					if(ss2 != null) {
						subSiteService.deleteSubSite(ss2);
					}
					//subSiteService.deleteSubSite(subSiteService.querySubSite(roleId, org.getOrgName(), org.getOrgCode()));
				}
			}
		}
		roleService.mergeRole(role);
		this.success = SUCCESS;
		return "updateOrg";
	}

	private static boolean existDir(String dir) {
		String existPath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\" + dir;
		/*
		 * 服务器部署使用
		 *
		 * String existPath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\" + dir;
		 *
		 */
		File f = new File(existPath);
		boolean state = false;
		if(f.exists()) {
			System.out.println("文件夹已存在");
			state = true;
		}
		return state;
	}

	private static void deleteDir(String dir) {
		String deletePath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\" + dir;

		/*
		 * 服务器部署时使用
		String deletePath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\" + dir;
		System.out.println(deletePath);
		*/

		File deleteDir = new File(deletePath);
		try {
			FileUtils.deleteDirectory(deleteDir);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static void copyDir(String dir) {
		String srcPath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\template";
		String destPath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab";
		String rePath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\" + dir;
		String oriPath = "C:\\Strive\\eclipse-jee\\workspace\\ScWeb\\WebContent\\lab\\template";
		/*
		 * 服务器部署时使用
		String srcPath = ServletActionContext.getServletContext().getRealPath("") + "\\template";
		String destPath = ServletActionContext.getServletContext().getRealPath("") + "\\lab";
		String rePath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\" + dir;
		String oriPath = ServletActionContext.getServletContext().getRealPath("") + "\\lab\\template";
		System.out.println(srcPath);
		System.out.println(destPath);
		System.out.println(rePath);
		System.out.println(oriPath);
		*/

		File srcDir = new File(srcPath);
		File destDir = new File(destPath);
		File oriDir = new File(oriPath);
		File reDir = new File(rePath);
		try {
			FileUtils.copyDirectoryToDirectory(srcDir, destDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		oriDir.renameTo(reDir);
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List<Organization> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<Organization> orgList) {
		this.orgList = orgList;
	}


	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public String getOrgArray() {
		return orgArray;
	}

	public void setOrgArray(String orgArray) {
		this.orgArray = orgArray;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Resource(name="orgService")
	public void setOrgService(OrganizationService orgService) {
		this.orgService = orgService;
	}

	@Resource(name="subSiteService")
	public void setSubSiteService(SubSiteService subSiteService) {
		this.subSiteService = subSiteService;
	}

	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


}
