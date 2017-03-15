package neu.scweb.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feature")
public class Feature {
	private int featureId;
	private String featureName;
	private String featureCode;
	private String featureTab;
	private Module module;

	@Id
	@GeneratedValue
	public int getFeatureId() {
		return featureId;
	}
	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}

	@Column(name="featureName")
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	@Column(name="featureCode")
	public String getFeatureCode() {
		return featureCode;
	}
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	@Column(name="featureTab")
	public String getFeatureTab() {
		return featureTab;
	}
	public void setFeatureTab(String featureTab) {
		this.featureTab = featureTab;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="moduleId")
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}


}
