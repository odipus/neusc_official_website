package neu.scweb.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import net.sf.json.JSONObject;
import neu.scweb.po.Module;
import neu.scweb.po.Role;
import neu.scweb.po.Section;
import neu.scweb.po.SubSite;
import neu.scweb.service.AuthPrivilegeService;
import neu.scweb.service.ModuleService;
import neu.scweb.service.RoleService;
import neu.scweb.service.SectionService;
import neu.scweb.service.SubSiteService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllRoles",type="json",params={"excludeProperties","success"}),
	@Result(name="queryAllRolesByPage",type="json",params={"excludeProperties","limit,start,roleId,subSite,roleArray,role"}),
	@Result(name="queryComboRoles",type="json",params={"excludeProperties","success"}),
	@Result(name="addRole",type="json",params={"includeProperties","success"}),
	@Result(name="queryRole",type="json",params={"excludeProperties","roleArray,roleList,roleId"}),
	@Result(name="querySubByRole",type="json",params={"excludeProperties","roleArray,roleList,roleId,subSite,role"}),
	@Result(name="updateRole",type="json",params={"includeProperties","success"})
	//@Result(name="queryAllAdmins",type="json",params={"excludeProperties","success,admin,adminPrivilege"}),
})
public class RoleAction extends ActionSupport{

	private RoleService roleService;
	private ModuleService moduleService;
	private AuthPrivilegeService apService;
	private SectionService sectionService;
	private SubSiteService subSiteService;
	private List roleList;
	private List subSiteList;
	private Role role;
	private String success;
	private String roleArray;
	private SubSite subSite;
	private int roleId;
	private int start;
	private int limit;
	private int totalProperty;

	@Action(value="roleAction")

	public String queryAllRoles() {
		this.roleList = roleService.queryAllRoles();
		return "queryAllRoles";
	}

	public String queryAllRolesByPage() {
		this.getStart();
		this.getLimit();
		this.totalProperty = roleService.queryRoleAmount();
		this.roleList = roleService.queryAllRolesByPage(start, limit);
		this.success = SUCCESS;
		return "queryAllRoles";
	}

	public String queryComboRoles() {
		roleList = roleService.queryComboRoles();
		return "queryComboRoles";
	}

	public String addRole() {
		this.success = SUCCESS;
		String st = role.getRoleName();
		boolean state1 = false;
		boolean state2 = false;
		roleList = roleService.queryAllRoles();
		Iterator it = roleList.iterator();
		while(it.hasNext()) {
			Role r = (Role) it.next();
			if(st.equals(r.getRoleName())) {
				this.success = ERROR;
			}
		}
		if(this.success.equals(SUCCESS)) {
			roleService.saveOrUpdateRole(role);
			roleId = role.getRoleId();
			String stmp = this.getRoleArray();
			stmp = stmp.substring(0, stmp.length() - 1);
			String ss = "";
			String[] sp = stmp.split(",");
			Set<String> ms = new HashSet<String>();
			Set<String> sects = new HashSet<String>();
			Set<Integer> subSites = new HashSet<Integer>();
			for(int i = 0; i < sp.length; i++) {
				ss = sp[i];
				if(ss.endsWith("Son")) {
					ss = ss.substring(0, ss.length() - 3);
					if(ss.equals("1")) {
						state1 = true;
					}
					if(ss.equals("6")) {
						state2 = true;
					}
					ms.add(ss);
					//ms.add(moduleService.queryModByCode(ss));
				}
				else if(ss.endsWith("Gon")) {
					ss = ss.substring(0, ss.length() - 3);
					sects.add(ss);
					//sects.add(sectionService.querySectionByCode(ss));
				}
				else if(ss.endsWith("Oon")){
					ss = ss.substring(0, ss.length() - 3);
					subSites.add(subSiteService.querySubSiteByCode(ss).getSubSiteId());
					//subSite = subSiteService.querySubSiteByName(ss);
				}
			}
			roleService.addRoleByMod(roleId, ms);
			if(state1) {
				//role.setSections(sects);
				roleService.addRoleBySect(roleId, sects);
			}
			//roleService.saveOrUpdateRole(role);
			if(state2) {
				//role.setSubSites(subSites);
				roleService.addRoleBySub(roleId, subSites);
			}
			//roleService.saveOrUpdateRole(role);
		}
		return "addRole";
	}

	public String deleteRole() {
		String stmp = this.getRoleArray();
		stmp = stmp.substring(1,stmp.length()-1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		if(roleService.deleteRole((Role)jsonObject.toBean(jsonObject, Role.class))) {
			this.success = SUCCESS;
		}
		return "deleteRole";
	}

	public String queryRole() {
		this.getRoleId();
		this.role = roleService.queryRoleById(this.roleId);
		this.success = SUCCESS;
		return "queryRole";
	}

	public String updateRole() {
		role.getRoleId();
		boolean state1 = false;
		boolean state2 = false;
		String st = role.getRoleName();
		String stmp = this.getRoleArray();
		stmp = stmp.substring(0, stmp.length() - 1);
		String[] sp = stmp.split(",");
		Set<Module> ms = new HashSet<Module>();
		Set<Section> sects = new HashSet<Section>();
		Set<SubSite> subSites = new HashSet<SubSite>();
		for(int i = 0; i < sp.length; i++) {
			String ss = sp[i];
			if(ss.endsWith("SonUp")) {
				ss = ss.substring(0, ss.length() - 5);
				if(ss.equals("newsCtrl")) {
					state1 = true;
				}
				if(ss.equals("subCtrl")) {
					state2 = true;
				}
				ms.add(moduleService.queryModByCode(ss));
			}
			else if(ss.endsWith("GonUp")) {
				ss = ss.substring(0, ss.length() - 5);
				sects.add(sectionService.querySectionByCode(ss));
			}
			else if(ss.endsWith("OonUp")){
				ss = ss.substring(0, ss.length() - 5);
				subSites.add(subSiteService.querySubSiteByCode(ss));
				//subSite = subSiteService.querySubSiteByName(ss);
			}

		}
		role.setModules(ms);
		if(state1) {
			role.setSections(sects);
		}
		//roleService.saveOrUpdateRole(role);

		if(state2) {
			role.setSubSites(subSites);
		}
		roleService.saveOrUpdateRole(role);
		this.success = SUCCESS;
		return "updateRole";
	}

	public String querySubByRole() {
		this.getRoleId();
		subSiteList = roleService.querySubByRole(roleId);
		System.out.println(subSiteList.size());
		this.success = SUCCESS;
		return "querySubByRole";
	}

	public List getRoleList() {
		return roleList;
	}

	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getRoleArray() {
		return roleArray;
	}

	public void setRoleArray(String roleArray) {
		this.roleArray = roleArray;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
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

	public List getSubSiteList() {
		return subSiteList;
	}

	public void setSubSiteList(List subSiteList) {
		this.subSiteList = subSiteList;
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

	@Resource(name="roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Resource(name="moduleService")
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@Resource(name="authPrivilegeService")
	public void setApService(AuthPrivilegeService apService) {
		this.apService = apService;
	}
	@Resource(name="sectionService")
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}
	@Resource(name="subSiteService")
	public void setSubSiteService(SubSiteService subSiteService) {
		this.subSiteService = subSiteService;
	}

}
