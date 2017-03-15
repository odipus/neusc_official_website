package neu.scweb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.scweb.po.User;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	
	private static final long serialVersionUID = -157149381824568574L;

	@Action(value="loginAction")

	public void loginPublic() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setCharacterEncoding("utf-8");
			User user =(User)request.getSession().getAttribute("USER");
			System.out.println(user.toString());
//			int day =(Integer) request.getSession().getAttribute("Day");
//			System.out.println("#############################"+day);
			if(user!=null)
			{
				response.getWriter().write(
			 			"{\"success\":'true',\"userName\":'" + user.getUserName() + "',\"roleName\":'"+user.getRole().getRoleName()+"',\"engName\":'"+user.getEngName()+"',\"roleId\":'"+ user.getRole().getRoleId() +"',\"showName\":'" + user.getShowName() +"',\"msg\":'" + user.getMsg() +"',\"showPwd\":'"+user.getUserPsw()+ "'}");
			}
			else
			{
				response.getWriter().write(
			 			"{\"success\":'false'" + ",\"userName\":' '}");
			}
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
