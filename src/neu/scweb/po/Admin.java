package neu.scweb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	private int adminId;
	private String adminName;
	private String adminPsw;
	private int adminRole;

	@Id
	@GeneratedValue
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Column(name="adminName")
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name="adminPsw")
	public String getAdminPsw() {
		return adminPsw;
	}
	public void setAdminPsw(String adminPsw) {
		this.adminPsw = adminPsw;
	}

	@Column(name="adminRole")
	public int getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(int adminRole) {
		this.adminRole = adminRole;
	}
}
