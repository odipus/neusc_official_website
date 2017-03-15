package neu.scweb.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_security")
public class User_security {
	private int user_securityId;
	private int userId;
	private String userName;
	private String showName;
	private String engName;
	private String userPsw;
	private Date last_change_psw_time;
	private Date last_login_time;
	private int is_del;    //账号是否有效  	1为有效	 0为无效
	private String login_random_string;

	@Id
	@GeneratedValue
	public int getUser_securityId() {
		return user_securityId;
	}

	public void setUser_securityId(int user_securityId) {
		this.user_securityId = user_securityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "userName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "showName")
	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	@Column(name = "userPsw")
	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}

	public Date getLast_change_psw_time() {
		return last_change_psw_time;
	}

	public void setLast_change_psw_time(Date last_change_psw_time) {
		this.last_change_psw_time = last_change_psw_time;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public int getIs_del() {
		return is_del;
	}

	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
	
	

	public String getLogin_random_string() {
		return login_random_string;
	}

	public void setLogin_random_string(String login_random_string) {
		this.login_random_string = login_random_string;
	}

	public void setUser(User oldUser){
		this.setUserId(oldUser.getUserId());
		this.setUserName(oldUser.getUserName());
		this.setUserPsw(oldUser.getUserPsw());
		this.setShowName(oldUser.getShowName());
		this.setEngName(oldUser.getEngName());
	}

	@Override
	public String toString() {
		return "User_security [user_securityId=" + user_securityId
				+ ", userId=" + userId + ", userName=" + userName
				+ ", showName=" + showName + ", engName=" + engName
				+ ", userPsw=" + userPsw + ", last_change_psw_time="
				+ last_change_psw_time + ", last_login_time=" + last_login_time
				+ ", is_del=" + is_del + ", login_random_string="
				+ login_random_string + "]";
	}


	

	
	
	
	
}
