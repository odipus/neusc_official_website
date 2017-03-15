package neu.scweb.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	private int teacherId;
	private int tchNumber;     //教师号
	private String tchName;      //教师名字
	private String tchPinyin;        //教师名字的英文显示
	private String tchGender;    //教师性别
	private Date tchBirthDate;   //教师生日
	private String tchTitle;     //教师职称
	private String tchOrgDuty; //机构职务
	private String tchDuty;   //教师学院职务
	private String tchDegree;  //教师学历
	private String tchHomepage;   //个人主页地址
	private String tchInfo;    //老师的个人介绍
	private String tchEngInfo;  //教师个人介绍的英文版
	private String tchImage;   //老师照片的地址
	private String tchAbbr;     //老师名字的缩写
	private Organization org;
	private int postAmount=0;        //兼职的数量（同时在几个研究所当教师）
	//private Set<Organization> orgs = new HashSet<Organization>();  //所属的机构

	@Id
	@GeneratedValue
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getTchNumber() {
		return tchNumber;
	}
	public void setTchNumber(int tchNumber) {
		this.tchNumber = tchNumber;
	}

	public String getTchName() {
		return tchName;
	}
	public void setTchName(String tchName) {
		this.tchName = tchName;
	}

	public String getTchGender() {
		return tchGender;
	}
	public void setTchGender(String tchGender) {
		this.tchGender = tchGender;
	}

	public Date getTchBirthDate() {
		return tchBirthDate;
	}
	public void setTchBirthDate(Date tchBirthDate) {
		this.tchBirthDate = tchBirthDate;
	}

	public String getTchTitle() {
		return tchTitle;
	}
	public void setTchTitle(String tchTitle) {
		this.tchTitle = tchTitle;
	}

	public String getTchOrgDuty() {
		return tchOrgDuty;
	}
	public void setTchOrgDuty(String tchOrgDuty) {
		this.tchOrgDuty = tchOrgDuty;
	}

	public String getTchDuty() {
		return tchDuty;
	}
	public void setTchDuty(String tchDuty) {
		this.tchDuty = tchDuty;
	}

	public String getTchDegree() {
		return tchDegree;
	}
	public void setTchDegree(String tchDegree) {
		this.tchDegree = tchDegree;
	}

	public String getTchHomepage() {
		return tchHomepage;
	}
	public void setTchHomepage(String tchHomepage) {
		this.tchHomepage = tchHomepage;
	}

	public String getTchInfo() {
		return tchInfo;
	}
	public void setTchInfo(String tchInfo) {
		this.tchInfo = tchInfo;
	}

	public int getPostAmount() {
		return postAmount;
	}
	public void setPostAmount(int postAmount) {
		this.postAmount = postAmount;
	}
	public String getTchAbbr() {
		return tchAbbr;
	}
	public void setTchAbbr(String tchAbbr) {
		this.tchAbbr = tchAbbr;
	}
	/**
	 * @return the tchPinyin
	 */
	public String getTchPinyin() {
		return tchPinyin;
	}
	/**
	 * @param tchPinyin the tchPinyin to set
	 */
	public void setTchPinyin(String tchPinyin) {
		this.tchPinyin = tchPinyin;
	}
	public String getTchImage() {
		return tchImage;
	}
	public void setTchImage(String tchImage) {
		this.tchImage = tchImage;
	}

	/**
	 * @return the tchEngInfo
	 */
	public String getTchEngInfo() {
		return tchEngInfo;
	}
	/**
	 * @param tchEngInfo the tchEngInfo to set
	 */
	public void setTchEngInfo(String tchEngInfo) {
		this.tchEngInfo = tchEngInfo;
	}
	@ManyToOne
	@JoinColumn(name="tch_orgId")
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", tchNumber=" + tchNumber + ", tchName=" + tchName + ", tchPinyin="
				+ tchPinyin + ", tchGender=" + tchGender + ", tchBirthDate=" + tchBirthDate + ", tchTitle=" + tchTitle
				+ ", tchOrgDuty=" + tchOrgDuty + ", tchDuty=" + tchDuty + ", tchDegree=" + tchDegree + ", tchHomepage="
				+ tchHomepage + ", tchInfo=" + tchInfo + ", tchEngInfo=" + tchEngInfo + ", tchImage=" + tchImage
				+ ", tchAbbr=" + tchAbbr + ", org=" + org + ", postAmount=" + postAmount + "]";
	}

	
}
