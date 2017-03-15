package neu.scweb.po;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guide")
public class Guide {
	private int guideId;        //id决定了该目录在导航中的顺序，id越小，越靠前
	private int guideLevel;
	private String guideTitle;
	private int upperLevel;     //上级菜单的Id，如果没有，则为0，有则为上级菜单的Id
	private int lowerLevel;     //下级菜单的Id，如果没有，则为0，有则为1
	private String guidePath;
	private int isSection;	//是否与主页的section相对应
	private int guideOrder;

	@Id
	@GeneratedValue
	public int getGuideId() {
		return guideId;
	}
	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}

	@Column(name="guideLevel")
	public int getGuideLevel() {
		return guideLevel;
	}
	public void setGuideLevel(int guideLevel) {
		this.guideLevel = guideLevel;
	}

	@Column(name="guideTitle")
	public String getGuideTitle() {
		return guideTitle;
	}
	public void setGuideTitle(String guideTitle) {
		this.guideTitle = guideTitle;
	}

	@Column(name="upperLevel")
	public int getUpperLevel() {
		return upperLevel;
	}
	public void setUpperLevel(int upperLevel) {
		this.upperLevel = upperLevel;
	}

	@Column(name="lowerLevel")
	public int getLowerLevel() {
		return lowerLevel;
	}
	public void setLowerLevel(int lowerLevel) {
		this.lowerLevel = lowerLevel;
	}

	@Column(name="guidePath")
	public String getGuidePath() {
		return guidePath;
	}
	public void setGuidePath(String guidePath) {
		this.guidePath = guidePath;
	}

	@Column(name="isSection")
	public int getIsSection() {
		return isSection;
	}
	public void setIsSection(int isSection) {
		this.isSection = isSection;
	}

	@Column(name="guideOrder")
	public int getGuideOrder() {
		return guideOrder;
	}
	public void setGuideOrder(int guideOrder) {
		this.guideOrder = guideOrder;
	}

}
