package neu.scweb.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import neu.scweb.po.Section;
import neu.scweb.service.SectionService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllSections",type="json",params={"excludeProperties","success,section,sectionArray"}),
	@Result(name="querySectionsNotUpper",type="json",params={"excludeProperties","success,section,sectionArray"}),
	@Result(name="querySectionsByPlace",type="json",params={"excludeProperties","sectionId,sectionOrder,success,section,sectionArray,place"}),
	@Result(name="saveSectionPlace",type="json",params={"includeProperties","success"}),
	@Result(name="querySectionById",type="json",params={"excludeProperties","success,sectionArray,sectionId"}),
	@Result(name="addSection",type="json",params={"includeProperties","success"}),
	@Result(name="deleteSection",type="json",params={"includeProperties","success"}),
	@Result(name="updateSection",type="json",params={"includeProperties","success"}),
	@Result(name="querySectByRole",type="json",params={"excludeProperties","section,sectionArray,roleId"}),
	@Result(name="queryAllSectionsByPage",type="json",params={"excludeProperties","section,sectionId,sectionArray,place,start,limit"})
})
public class SectionAction extends ActionSupport{

	private List sectionsList;
	private Section section;
	private int sectionId;
	private SectionService sectionService;
	private String success;
	private int roleId;
	private String sectionArray;
	private String place;
	private int sectionOrder;
	private int start;
	private int limit;
	private int totalProperty;


	@Action(value="sectionAction")
	public String queryAllSections() {
		sectionsList = sectionService.queryAllSections();
		this.success = SUCCESS;
		return "queryAllSections";
	}
	
	public String querySectionsNotUpper(){
		sectionsList = sectionService.querySectionsNotUpper();
		this.success = SUCCESS;
		return "querySectionsNotUpper";
	}

	public String queryAllSectionsByPage() {
		this.getStart();
		this.getLimit();
		this.setTotalProperty(sectionService.querySectionAmount());
		this.sectionsList = sectionService.queryAllSectionsByPage(start, limit);
		this.success = SUCCESS;
		return "queryAllSectionsByPage";
	}

	public String saveSectionPlace(){
		sectionId = this.getSectionId();
		System.out.println(sectionId);
		place = this.getPlace();
		sectionOrder = this.getSectionOrder();
		section = sectionService.querySectionBySectId(sectionId);
		//System.out.println(section.getSectionId());
		section.setSectionPlace(place);
		section.setSectionOrder(sectionOrder);
		sectionService.updateSection(section);
		this.success = SUCCESS;
		return "saveSectionPlace";
	}

	public String querySectionsByPlace(){

		place = this.getPlace();
		System.out.println("the place is "+this.place);
		sectionsList = sectionService.querySectionsByPlace(place);
		System.out.println("the list is "+this.sectionsList);
		this.success = SUCCESS;
		return "querySectionsByPlace";
	}

	public String querySectionById(){
		sectionId = this.getSectionId();
		section = sectionService.querySectionBySectId(sectionId);
		return "querySectionById";
	}

	public String addSection() {
		section.getSectionName();
		section.getSectionCode();
		sectionService.saveOrUpdateSections(section);
		this.success=SUCCESS;
		return "addSection";
	}

	public String updateSection() {
		String stmp = this.getSectionArray();
		stmp = stmp.substring(1,stmp.length()-1);
		String[] sp = stmp.split("},");
		for(int i = 0; i < sp.length; i++) {
			String ss = sp[i];
			if(ss.endsWith("}")){
				JSONObject jsonObject = JSONObject.fromObject(ss);
				Section sect = (Section) jsonObject.toBean(jsonObject, Section.class);
				sectionService.updateSection(sect);
			}
			else{
				ss = ss + "}";
				JSONObject jsonObject = JSONObject.fromObject(ss);
				Section sect = (Section) jsonObject.toBean(jsonObject, Section.class);
				sectionService.updateSection(sect);
			}
		}
		this.success = SUCCESS;
		return "updateSection";
	}

	public String deleteSection() {
		String stmp = this.getSectionArray();
		stmp = stmp.substring(1,stmp.length()-1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		Section section = sectionService.querySection((Section) jsonObject.toBean(jsonObject, Section.class));
		if(sectionService.deleteSection(section)) {
			this.success = SUCCESS;
		}
		return "deleteSection";
	}

	public String querySectByRole() {
		this.getRoleId();
		this.sectionsList = sectionService.querySectionByRole(roleId);
		this.success = SUCCESS;
		return "querySectByRole";
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List getSectionsList() {
		return sectionsList;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setSectionsList(List sectionsList) {
		this.sectionsList = sectionsList;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getSectionArray() {
		return sectionArray;
	}

	public void setSectionArray(String sectionArray) {
		this.sectionArray = sectionArray;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionOrder(int sectionOrder) {
		this.sectionOrder = sectionOrder;
	}
	public int getSectionOrder() {
		return sectionOrder;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	@Resource(name="sectionService")
	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

}
