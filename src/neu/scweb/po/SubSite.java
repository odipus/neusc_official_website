package neu.scweb.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="subsite")
public class SubSite {
	private int subSiteId;
	private String subSiteName;
	private String subSiteCode;
	//private String subSitePath;
	//private Role role;

	@Id
	@GeneratedValue
	public int getSubSiteId() {
		return subSiteId;
	}
	public void setSubSiteId(int subSiteId) {
		this.subSiteId = subSiteId;
	}
	public String getSubSiteName() {
		return subSiteName;
	}
	public void setSubSiteName(String subSiteName) {
		this.subSiteName = subSiteName;
	}
	/*
	public String getSubSitePath() {
		return subSitePath;
	}
	public void setSubSitePath(String subSitePath) {
		this.subSitePath = subSitePath;
	}
	*/
	public String getSubSiteCode() {
		return subSiteCode;
	}
	public void setSubSiteCode(String subSiteCode) {
		this.subSiteCode = subSiteCode;
	}
	/*
	@ManyToOne
	@JoinColumn(name="subSite_roleId")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	*/


}
