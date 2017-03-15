package neu.scweb.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import neu.scweb.po.User;
import neu.scweb.po.User_security;
import neu.scweb.service.RoleService;
import neu.scweb.service.UserService;
import neu.scweb.service.User_securityService;
import neu.scweb.util.MD5;
import neu.scweb.util.ScAES;
import neu.scweb.util.ScRandomString;

@ParentPackage(value = "json-default")
@Results({
		@Result(name = "queryAllUsers", type = "json", params = {
				"excludeProperties", "success,user" }),
		@Result(name = "queryAllUsersByPage", type = "json", params = {
				"excludeProperties", "limit,start,userRole,success,user" }),
		@Result(name = "updateUser", type = "json", params = {
				"includeProperties", "success" }),
		@Result(name = "addUser", type = "json", params = {
				"includeProperties", "success" }),
		@Result(name = "deleteUser", type = "json", params = {
				"includeProperties", "success" }),
		@Result(name = "updatePsw", type = "json", params = {
				"includeProperties", "success" }),
		@Result(name = "queryCode", type = "json", params = {
				"includeProperties", "checkUsernameExitString,success" }),
		})
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UserService userService;
	private RoleService roleService;
	private User_securityService user_securityService;
	private String success;
	private String checkUsernameExitString;
	private String userRole;
	private List<User> userList;
	private User user;
	private User_security user_security;
	private String userArray;
	private String newUserPsw;
	private int start;
	private int limit;
	private int totalProperty;
	

	
	
	@Action(value = "userAction")
	public void login() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			String userPsw = request.getParameter("new_password");
			String checkUsernameExitString = request.getParameter("textcode");
			String userName = request.getParameter("new_username");
			userPsw = ScAES.Decrypt(userPsw, checkUsernameExitString);
			if (checkUsernameExitString == null ||checkUsernameExitString.equals("")) {
				System.out.println("Key长度不是16位java.lang.NullPointerException");
				return;
			}
			MD5 userP = new MD5(userPsw);
			userPsw = userP.compute(); // md5加密
			userName = ScAES.Decrypt(userName, checkUsernameExitString);
			
			String[] t = { "select ", "update ", "add ", " and", " delete ",
					"from ", ";", "insert ", "mid ", "set ", "=", "'" };

			for (int i = 0; i < t.length; i++) {
				if (userName.indexOf(t[i]) != -1) {
					userName = "false";
					break;
				}
			}

			User tUser = new User();
			tUser.setUserName(userName);
			tUser.setUserPsw(userPsw);
			this.user = userService.queryUser(tUser);
			System.out.println("this.user:::::"+this.user);
			System.out.println("user:::::"+user);
			if (user == null) {
				System.out.println("no user");
				return;
			}
			user_security = new User_security();
			user_security.setUser(user);
			this.user_security = user_securityService.queryUser_security(user_security);       //queryUser_security  Done
			Date lastchangPwdTime = new Date();
			if (null == user_security) {
				user_security = new User_security();
				user_security.setUser(user);
				user_security.setLast_login_time(new Date());
				user_security.setLast_change_psw_time(new Date());
				user_securityService.addUser_security(user_security);
				lastchangPwdTime = user_security.getLast_change_psw_time();
			}else {
				user_security.setLast_login_time(new Date());
				user_security.setLogin_random_string(ScRandomString.GenerateRandomString16());
				user_securityService.updateUser_security(user_security);					//updateUser_security Done
				lastchangPwdTime = user_security.getLast_change_psw_time();
			}
			long time = new Date().getTime() - lastchangPwdTime.getTime();
			String dateString="";
			if( time>30*1000 * 60 *60 *24 ){
				int day = (int) (time/(1000 * 60 *60 *24));
				dateString= ""+day;
				user.setMsg(dateString);
				System.out.println("user::!!!!!!!!!!!:::"+user);
			}
			request.getSession().setAttribute("USER", user);
			System.out.println("user:::::"+user);
			response.sendRedirect("sc_auth.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	通过账号验证 是否存在 回传 随机验证盐
	@Action(value = "codetest",results = {@Result(name="success",type="json",params={"excludeProperties", "user,limit,start,userRole,success,newUserPsw,totalProperty,userArray,userList"})})
	public String checkUsernameExit(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		
			HttpServletRequest request = ServletActionContext.getRequest();
			String userName = request.getParameter("userName");
			User tUser = new User();
			tUser.setUserName(userName);
			this.user = userService.queryUserByName(userName);
			this.user_security =user_securityService.queryUser_securityByName(userName);
			if (user != null) {
				if (user_security ==null) {
					this.user_security = new User_security();
					user_security.setUser(user);
					user_security.setLast_change_psw_time(new Date());
					user_securityService.addUser_security(user_security);
				}
				user_security.setLogin_random_string(ScRandomString.GenerateRandomString16());
				user_securityService.updateUser_security(user_security);
				request.getSession().setAttribute("checkUsernameExitString",user_security.getLogin_random_string());
				this.checkUsernameExitString=user_security.getLogin_random_string();
				System.out.println(userName);
				System.out.println(user_security.getLogin_random_string());
				return SUCCESS;
			}else {
				return null;
			}
	}
	
	public String queryCode() {
		this.totalProperty = userService.queryUserAmount();
		this.success = SUCCESS;
		this.checkUsernameExitString=user_security.getLogin_random_string();
		return "queryCode";
	}

	
	public void configIndex() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			String userName = request.getParameter("userName");
			this.user = userService.queryUserByName(userName);
			request.getSession().setAttribute("USER", user);
			// RequestDispatcher requestdispatch =
			// ServletActionContext.getServletContext().getRequestDispatcher("/index.jsp");
			// response.sendRedirect("index.jsp");
			// requestdispatch.forward(request,response);
			// .getRequestDispatcher("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void returnIndex() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			request.getSession().removeAttribute("USER");
			// RequestDispatcher requestdispatch =
			// ServletActionContext.getServletContext().getRequestDispatcher("/index.jsp");
			// response.sendRedirect("index.jsp");
			// requestdispatch.forward(request,response);
			// .getRequestDispatcher("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String queryAllUsers() {
		this.userList = userService.queryAllUsers();
		return "queryAllUsers";
	}

	public String queryAllUsersByPage() {		
		
		this.getStart();
		this.getLimit();
		this.totalProperty = userService.queryUserAmount();
		this.userList = userService.queryAllUsersByPage(start, limit);	
		
		this.success = SUCCESS;
		return "queryAllUsersByPage";
	}

	public String updateUser() {
		String stmp = this.getUserArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		String[] sp = stmp.split("},");
		for (int i = 0; i < sp.length; i++) {
			if (sp[i].endsWith("}")) {
				String ss = sp[i];
				String spp = ss.substring(0, ss.indexOf("roleName") - 2) + "}";
				String sRN = ss.substring(ss.indexOf("roleName") + 11,
						ss.length() - 2);
				JSONObject jsonObject = JSONObject.fromObject(ss);
				User user = (User) jsonObject.toBean(jsonObject, User.class);
				user.setRole(roleService.queryRoleByName(sRN));
				if (user.getUserPsw().length() != 32) {
					MD5 p = new MD5(user.getUserPsw());
					user.setUserPsw(p.compute()); // 如果更新的密码不是32位，则用MD5加密
				}
				userService.updateUser(user);
			} else {
				String ss = sp[i] + "}";
				String spp = ss.substring(0, ss.indexOf("roleName") - 2) + "}";
				String sRN = ss.substring(ss.indexOf("roleName") + 11,
						ss.length() - 2);
				JSONObject jsonObject = JSONObject.fromObject(ss);
				User user = (User) jsonObject.toBean(jsonObject, User.class);
				user.setRole(roleService.queryRoleByName(sRN));
				if (user.getUserPsw().length() != 32) {
					MD5 p = new MD5(user.getUserPsw());
					user.setUserPsw(p.compute()); // 如果更新的密码不是32位，则用MD5加密
				}
				userService.updateUser(user);
			}
		}
		return "updateUser";
	}

	public String addUser() {
		user.getUserName();
		user.getUserPsw();
		user.getEngName();
		MD5 up = new MD5(user.getUserPsw());
		user.setUserPsw(up.compute()); // 新用户的密码用MD5加密
		this.getUserRole();
		user.setRole(roleService.queryRoleByName(this.getUserRole()));
		if (userService.addUser(user)) {
			this.success = SUCCESS;
		}
		return "addUser";
	}

	public String deleteUser() {
		String stmp = this.getUserArray();
		stmp = stmp.substring(1, stmp.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		User user = userService.queryUser((User) jsonObject.toBean(jsonObject,
				User.class));

		user_security = new User_security();
		user_security.setUser(user);
		this.user_security = user_securityService.queryUser_security(user_security);       //queryUser_security  Done
		if (userService.deleteUser(user)) {
			if (user_security != null ) {
				user_securityService.deleteUser_security(user_security);
			}
			this.success = SUCCESS;
		}
		return "deleteUser";
	}

	public String updatePsw() {
		System.out.println("!!!!!!!!"+user);
		user.getUserName();
		user.getEngName();
		user.getUserPsw();
		System.out.println("!!!!!!!!"+user);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String userName = request.getParameter("userName");

		request.getSession().setAttribute("USER", user);
		User Suser = (User) request.getSession().getAttribute("USER");
		System.out.println("Suser:"+Suser);
		System.out.println("username:::"+userName);
		MD5 up1 = new MD5(user.getUserPsw());
		user.setUserPsw(up1.compute());

		this.getNewUserPsw();
		System.out.println("!!!!!!!!"+user);
		User utmp = userService.queryUser(user);
		user_security = new User_security();
		user_security.setUser(utmp);
		System.out.println(user_security);
		user_security = user_securityService.queryUser_security(user_security); 
		if (user_security != null) {
			user_securityService.deleteUser_security(user_security);
		}
		
		
		if (utmp != null) {
			MD5 up = new MD5(newUserPsw); // 新输入的密码用MD5加密后保存
			utmp.setUserPsw(up.compute());
			userService.updateUser(utmp);
			
			user_security = new User_security();
			user_security.setUser(utmp);
			user_security.setLast_change_psw_time(new Date());
			user_securityService.addUser_security(user_security);
			this.success = SUCCESS;
		} else {
			this.success = ERROR;
		}
		return "updatePsw";
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User_security getUser_security() {
		return user_security;
	}

	public void setUser_security(User_security user_security) {
		this.user_security = user_security;
	}

	public String getUserArray() {
		return userArray;
	}

	public void setUserArray(String userArray) {
		this.userArray = userArray;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getNewUserPsw() {
		return newUserPsw;
	}

	public void setNewUserPsw(String newUserPsw) {
		this.newUserPsw = newUserPsw;
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

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource(name = "user_securityService")
	public void setUser_securityService(
			User_securityService user_securityService) {
		this.user_securityService = user_securityService;
	}

	public User_securityService getUser_securityService() {
		return user_securityService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
