package neu.scweb.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.scweb.po.Admin;
import neu.scweb.service.AdminService;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value = "json-default")
@Results({
		@Result(name = "login", type = "json", params = { "includeProperties",
				"success,adminPrivilege" }),
		@Result(name = "update", type = "json", params = { "includeProperties",
				"success" }),
		@Result(name = "queryAllAdmins", type = "json", params = {
				"excludeProperties", "success,admin,adminPrivilege" }), })
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Admin admin;
	private String success;
	private int adminPrivilege;
	private List adminList;
	private AdminService adminService;
	private String newAdminPsw;

	@Action(value = "adminAction")
	public void login() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			
			String password = request.getParameter("userPsw");
			String username = request.getParameter("userName");
			
			Admin admin = new Admin();
			admin.setAdminName(username);
			admin.setAdminPsw(password);
			adminService.queryAdmin(admin);
			
			request.getSession().setAttribute("ADMIN", admin);
			response.sendRedirect("sc_auth.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String updatePsw() {
		admin.getAdminName();
		admin.getAdminPsw();
		this.getNewAdminPsw();
		if (adminService.queryAdmin(admin) != null) {
			admin.setAdminPsw(newAdminPsw);
			this.success = SUCCESS;
			adminService.adminUpdate(admin);
		} else {
			this.success = ERROR;
		}
		return "update";
	}

	public String queryAllAdmins() {
		this.adminList = adminService.queryAllAdmins();
		return "queryAllAdmins";
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getAdminPrivilege() {
		return adminPrivilege;
	}

	public void setAdminPrivilege(int adminPrivilege) {
		this.adminPrivilege = adminPrivilege;
	}

	public List getAdminList() {
		return adminList;
	}

	public void setAdminList(List adminList) {
		this.adminList = adminList;
	}

	public String getNewAdminPsw() {
		return newAdminPsw;
	}

	public void setNewAdminPsw(String newAdminPsw) {
		this.newAdminPsw = newAdminPsw;
	}

	@Resource(name = "adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
