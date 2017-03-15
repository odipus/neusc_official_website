package neu.scweb.action;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.scweb.po.Feature;
import neu.scweb.po.Module;
import neu.scweb.po.Organization;
import neu.scweb.po.Section;
import neu.scweb.po.SubSite;
import neu.scweb.po.User;
import neu.scweb.service.AuthPrivilegeService;
import neu.scweb.service.FeatureService;
import neu.scweb.service.ModuleService;
import neu.scweb.service.OrganizationService;
import neu.scweb.service.SectionService;
import neu.scweb.service.SubSiteService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class AuthPrivilegeAction extends ActionSupport{

	private AuthPrivilegeService apService;
	private FeatureService feaService;
	private ModuleService modService;
	private SectionService sectionService;
	private OrganizationService orgService;
	private SubSiteService subSiteService;
	private String moduleName;
	private String moduleCode;
	private String moduleTab;
	private Module mod;
	private Feature fea;
	private Section sect;
	private Organization org;
	private SubSite subSite;
	private String feaTab;
	private String roleName;
	private int roleId;

	@Action(value="authPrivilegeAction")

	public void authCtrl() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			User user=(User)request.getSession().getAttribute("USER");
			if(user!=null) {
				List list = apService.queryModByRoleId(user.getRole().getRoleId());
				Iterator it = list.iterator();
				moduleName = "";
				moduleCode = "";
				moduleTab = "";
				feaTab = "";
				while(it.hasNext()) {
					mod = (Module) it.next();
					moduleName += mod.getModuleName() + ",";
					moduleCode += mod.getModuleCode() + ",";
					moduleTab += mod.getModuleTab() + ",";
					List feaList = feaService.queryFeaByModId(mod.getModuleId());
					Iterator itf = feaList.iterator();
					while(itf.hasNext()) {
						fea = (Feature) itf.next();
						String s = fea.getFeatureTab();
						if(s != null) {
							feaTab += s + ",";
						}
					}
					if(feaTab == "") {
						feaTab += ",";
					}
				}

				response.getWriter().write("{\"success\":'true',\"moduleName\":'" + moduleName.substring(0,moduleName.length()-1) + "',\"moduleTab\":'" + moduleTab.substring(0,moduleTab.length()-1) + "',\"moduleCode\":'" + moduleCode.substring(0,moduleCode.length()-1) + "',\"feaTab\":'" + feaTab.substring(0,feaTab.length()-1) + "'}");
						
			}
			else{
				response.getWriter().write(
			 			"{\"success\":'false'}");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tabCtrl() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			User user=(User)request.getSession().getAttribute("USER");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void authTree() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			List<Module> modList =  modService.queryAllModules();
			List<Section> sectList = sectionService.querySectionsNotUpper();
			List<Organization> orgList = orgService.querySubOrg();
			Iterator<Module> itm = modList.iterator();
			String treeN = "";
			String childNode = "";
			for(int i = 0; i < modList.size(); i++) {
				mod =  modList.get(i);

				if(mod.getModuleName().equals("新闻管理")){
					childNode = "";
					for(int j = 0; j < sectList.size(); j++) {
						sect = sectList.get(j);
						childNode += "{text:'"+ sect.getSectionName() +"',leaf:true,checked:false,id:'"+ sect.getSectionId() +"Gon'},";
					}
					childNode = childNode.substring(0,childNode.length() - 1);
					treeN += "{text:'"+ mod.getModuleName() +"',leaf:false,checked:false,id:'"+ mod.getModuleId() +"Son',children:["+ childNode +"]},";
				}
				else if(mod.getModuleName().equals("子网站管理")) {
					childNode = "";
					for(int k = 0; k < orgList.size(); k++) {
						org = orgList.get(k);
						childNode += "{text:'" + org.getOrgName() +"',leaf:true,checked:false,id:'" + org.getOrgCode() + "Oon'},";
					}
					childNode = childNode.substring(0,childNode.length() - 1);
					treeN += "{text:'"+ mod.getModuleName() +"',leaf:false,checked:false,id:'"+ mod.getModuleId() +"Son',children:["+ childNode +"]},";
				}
				else{
					treeN += "{text:'"+ mod.getModuleName() +"',leaf:true,checked:false,id:'"+ mod.getModuleId() +"Son'},";
				}
			}
			treeN = treeN.substring(0, treeN.length() - 1);
			response.getWriter().write("["+ treeN +"]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void feaSubTree() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			String treeNode = "";
			String childNode = "";
			List<SubSite> ssList = subSiteService.querySubSiteByRole(this.getRoleId());
			if(!ssList.isEmpty()) {
				for(int i = 0; i < ssList.size(); i++) {
					subSite = ssList.get(i);
					childNode += "{text:'"+ subSite.getSubSiteName() +"',leaf:true,id:'"+ subSite.getSubSiteCode() +"Fea'},";
				}
				treeNode = childNode.substring(0, childNode.length()-1);
			}
			response.getWriter().write("["+ treeNode +"]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void authTreeUp() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			List<Module> modList =  modService.queryAllModules();
			List<Section> sectList = sectionService.querySectionsNotUpper();
			List<Organization> orgList = orgService.querySubOrg();
			Iterator<Module> itm = modList.iterator();
			String treeN = "";
			String childNode = "";
			for(int i = 0; i < modList.size(); i++) {
				mod =  modList.get(i);

				if(mod.getModuleName().equals("新闻管理")){
					childNode = "";
					for(int j = 0; j < sectList.size(); j++) {
						sect = sectList.get(j);
						childNode += "{text:'"+ sect.getSectionName() +"',leaf:true,checked:false,id:'"+ sect.getSectionCode() +"GonUp'},";
					}
					childNode = childNode.substring(0,childNode.length() - 1);
					treeN += "{text:'"+ mod.getModuleName() +"',leaf:false,expanded:true,checked:false,id:'"+ mod.getModuleCode() +"SonUp',children:["+ childNode +"]},";
				}
				else if(mod.getModuleName().equals("子网站管理")) {
					childNode = "";
					for(int k = 0; k < orgList.size(); k++) {
						org = orgList.get(k);
						childNode += "{text:'" + org.getOrgName() +"',leaf:true,checked:false,id:'" + org.getOrgCode() + "OonUp'},";
					}
					childNode = childNode.substring(0,childNode.length() - 1);
					treeN += "{text:'"+ mod.getModuleName() +"',leaf:false,expanded:true,checked:false,id:'"+ mod.getModuleCode() +"SonUp',children:["+ childNode +"]},";
				}
				else{
					treeN += "{text:'"+ mod.getModuleName() +"',leaf:true,checked:false,id:'"+ mod.getModuleCode() +"SonUp'},";
				}
			}
			treeN = treeN.substring(0, treeN.length() - 1);
			response.getWriter().write("["+ treeN +"]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}


	public String getFeaTab() {
		return feaTab;
	}

	public void setFeaTab(String feaTab) {
		this.feaTab = feaTab;
	}

	public Section getSect() {
		return sect;
	}

	public void setSect(Section sect) {
		this.sect = sect;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public Module getMod() {
		return mod;
	}

	public void setMod(Module mod) {
		this.mod = mod;
	}

	public Feature getFea() {
		return fea;
	}

	public void setFea(Feature fea) {
		this.fea = fea;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getModuleTab() {
		return moduleTab;
	}

	public void setModuleTab(String moduleTab) {
		this.moduleTab = moduleTab;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public SubSite getSubSite() {
		return subSite;
	}

	public void setSubSite(SubSite subSite) {
		this.subSite = subSite;
	}

	@Resource(name="featureService")
	public void setFeaService(FeatureService feaService) {
		this.feaService = feaService;
	}

	@Resource(name="authPrivilegeService")
	public void setApService(AuthPrivilegeService apService) {
		this.apService = apService;
	}

	@Resource(name="moduleService")
	public void setModService(ModuleService modService) {
		this.modService = modService;
	}

	@Resource(name="sectionService")
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	@Resource(name="orgService")
	public void setOrgService(OrganizationService orgService) {
		this.orgService = orgService;
	}

	@Resource(name="subSiteService")
	public void setSubSiteService(SubSiteService subSiteService) {
		this.subSiteService = subSiteService;
	}





}
