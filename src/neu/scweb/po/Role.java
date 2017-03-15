package neu.scweb.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="role",
	   uniqueConstraints = {@UniqueConstraint(columnNames={"roleName"})})
public class Role {
	private int roleId;
	private String roleName;
	private Set<Module> modules = new HashSet<Module>();
	private Set<Section> sections = new HashSet<Section>();
	private Set<SubSite> subSites = new HashSet<SubSite>();

	public Role() {

	}
	public Role(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}
	@Id
	@GeneratedValue
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name="roleName")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(cascade=CascadeType.ALL,
				targetEntity=Module.class)
	@JoinTable(name="role_module",
			   joinColumns={@JoinColumn(name="roleId")},
			   inverseJoinColumns={@JoinColumn(name="moduleId")}
	)
	public Set<Module> getModules() {
		return modules;
	}
	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@ManyToMany(cascade=CascadeType.ALL,
				targetEntity=Section.class)
	@JoinTable(name="role_section",
			   joinColumns={@JoinColumn(name="roleId")},
			   inverseJoinColumns={@JoinColumn(name="sectionId")}
	)
	public Set<Section> getSections() {
		return sections;
	}
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}


	@ManyToMany(cascade=CascadeType.ALL,
			targetEntity=SubSite.class)
	@JoinTable(name="role_subsite",
		   joinColumns={@JoinColumn(name="roleId")},
		   inverseJoinColumns={@JoinColumn(name="subSiteId")}
	)
	public Set<SubSite> getSubSites() {
		return subSites;
	}
	public void setSubSites(Set<SubSite> subSites) {
		this.subSites = subSites;
	}


}
