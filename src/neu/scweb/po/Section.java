package neu.scweb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="section")
public class Section {
	private int sectionId;
	private String sectionName;
	private String sectionCode;
	private String sectionPlace;
	private int sectionOrder;
	private int isUpperSection;
	private int upperSectionId;


	@Id
	@GeneratedValue
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	@Column(name="sectionName")
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	@Column(name="sectionCode")
	public String getSectionCode() {
		return sectionCode;
	}
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	@Column(name="sectionPlace")
	public void setSectionPlace(String sectionPlace) {
		this.sectionPlace = sectionPlace;
	}
	public String getSectionPlace() {
		return sectionPlace;
	}

	@Column(name="sectionOrder")
	public void setSectionOrder(int sectionOrder) {
		this.sectionOrder = sectionOrder;
	}
	public int getSectionOrder() {
		return sectionOrder;
	}
	
	@Column(name="isUpperSection")
	public int getIsUpperSection() {
		return isUpperSection;
	}
	public void setIsUpperSection(int isUpperSection) {
		this.isUpperSection = isUpperSection;
	}
	
	@Column(name="upperSectionId")
	public int getUpperSectionId() {
		return upperSectionId;
	}
	public void setUpperSectionId(int upperSectionId) {
		this.upperSectionId = upperSectionId;
	}


}
