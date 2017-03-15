package neu.scweb.action;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.po.Guide;
import neu.scweb.service.GuideService;
import neu.scweb.service.SectionService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryGuidesByLevel",type="json",params={"excludeProperties","guideId,guideLevel,guide,guideTitle,sectionId,success"}),
	@Result(name="queryLowerGuides",type="json",params={"excludeProperties","success"}),
	@Result(name="queryGuideById",type="json",params={"includeProperties","guide"}),
	@Result(name="queryGuideByTitle",type="json",params={"includeProperties","guide"}),
	@Result(name="queryAllGuides",type="json",params={"excludeProperties","guideId,guideLevel,guide,guideTitle,sectionId,success"})
	
})

public class GuideAction extends ActionSupport{
	private int guideId;
	private int guideLevel;
	private List<Guide> guideList;
	private Guide guide;
	private GuideService guideService;
	private String guideTitle;
	private SectionService sectionService;
	private int sectionId;

	@Action(value="guideAction")
	public String queryGuidesByLevel(){
		guideLevel = this.getGuideLevel();
		guideList = guideService.queryGuidesByLevel(guideLevel);
		return "queryGuidesByLevel";
	}
	public String queryAllGuides(){

		guideList = guideService.queryAllGuides();
		return "queryAllGuides";
	}

	public String queryLowerGuides(){
		guideId = this.getGuideId();
		guideList = guideService.queryLowerGuides(guideId);
		return "queryLowerGuides";
	}

	public String queryGuideById(){
		guideId = this.getGuideId();
		guide = guideService.queryGuideById(guideId);
		return "queryGuideById";
	}

	public String queryGuideByTitle(){
		this.getSectionId();
		guideTitle = sectionService.querySectionBySectId(sectionId).getSectionName();
		guide = guideService.queryGuideByTitle(guideTitle);
		return "queryGuideByTitle";

	}

	public void setGuideId(int guideId) {
		this.guideId = guideId;
	}
	public int getGuideId() {
		return guideId;
	}
	public void setGuideLevel(int guideLevel) {
		this.guideLevel = guideLevel;
	}
	public int getGuideLevel() {
		return guideLevel;
	}

	public void setGuideList(List<Guide> guideList) {
		this.guideList = guideList;
	}

	public List<Guide> getGuideList() {
		return guideList;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public Guide getGuide() {
		return guide;
	}

	public String getGuideTitle() {
		return guideTitle;
	}

	public void setGuideTitle(String guideTitle) {
		this.guideTitle = guideTitle;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	@Resource(name="guideService")
	public void setGuideService(GuideService guideService){
		this.guideService = guideService;
	}

	@Resource(name="sectionService")
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

}
