package neu.scweb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {
	public int orgId;
	private String orgName;
	private String orgCode;
	private String orgDuty;
	private int subSite;

	@Id
	@GeneratedValue
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	@Column(name="orgName")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name="orgDuty")
	public String getOrgDuty() {
		return orgDuty;
	}
	public void setOrgDuty(String orgDuty) {
		this.orgDuty = orgDuty;
	}

	@Column(name="orgCode")
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name="subSite")
	public int getSubSite() {
		return subSite;
	}
	public void setSubSite(int subSite) {
		this.subSite = subSite;
	}
}
