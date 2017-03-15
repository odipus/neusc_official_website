package neu.scweb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module")
public class Module {
	private int moduleId;
	private String moduleName;
	private String modulePath;
	private String moduleCode;
	private String moduleTab;

	@Id
	@GeneratedValue
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	@Column(name="moduleName")
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Column(name="modulePath")
	public String getModulePath() {
		return modulePath;
	}
	public void setModulePath(String modulePath) {
		this.modulePath = modulePath;
	}

	@Column(name="moduleCode")
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	@Column(name="moduleTab")
	public String getModuleTab() {
		return moduleTab;
	}
	public void setModuleTab(String moduleTab) {
		this.moduleTab = moduleTab;
	}
}
