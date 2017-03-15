package neu.scweb.action;

import java.util.List;

import javax.annotation.Resource;

import neu.scweb.po.EngSection;
import neu.scweb.service.EngSectionService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllSections",type="json",params={"excludeProperties","success,section,sectionArray"}),
	@Result(name="querySectionsNotUpper",type="json",params={"excludeProperties","success,section,sectionArray"}),
	@Result(name="querySectionById",type="json",params={"excludeProperties","success,sectionArray,sectionId"}),
	@Result(name="addSection",type="json",params={"includeProperties","success"}),
	@Result(name="deleteSection",type="json",params={"includeProperties","success"}),
	@Result(name="updateSection",type="json",params={"includeProperties","success"})
	
})
public class EngSectionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EngSection> sectionsList;
	private EngSection engSection;
	private int sectionId;
	private EngSectionService engSectionService;
	private String success;
	
	@Action(value="engSectionAction")
	public String queryAllSections() {
		sectionsList = engSectionService.queryAllSections();
		this.setSuccess(SUCCESS);
		return "queryAllSections";
	}

	public List<EngSection> getSectionsList() {
		return sectionsList;
	}

	public void setSectionsList(List<EngSection> sectionsList) {
		this.sectionsList = sectionsList;
	}

	public EngSection getEngSection() {
		return engSection;
	}

	public void setEngSection(EngSection engSection) {
		this.engSection = engSection;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}


	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	@Resource(name="engSectionService")
	public void setEngSectionService(EngSectionService engSectionService) {
		this.engSectionService = engSectionService;
	}
}
