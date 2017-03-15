package neu.scweb.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import neu.scweb.po.Organization;
import neu.scweb.po.Teacher;
import neu.scweb.service.OrganizationService;
import neu.scweb.service.TeacherService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryAllTches",type="json",params={"excludeProperties","success,tch,tchArray,tchOrg"}),
	@Result(name="queryFullTches",type="json",params={"excludeProperties","success,tch,tchArray,tchOrg"}),
	@Result(name="queryTchesByAbbr",type="json",params={"excludeProperties","success,tch,tchArray,tchOrg"}),
	@Result(name="queryAllTchesByPage",type="json",params={"excludeProperties","limit,start,orgId,orgTitle,tch,tchArray,tchOrg"}),
	@Result(name="queryTchesByOrgId",type="json",params={"excludeProperties","success,tch,tchArray,tchOrg"}),
	@Result(name="addTch",type="json",params={"includeProperties","success"}),
	@Result(name="deleteTch",type="json",params={"includeProperties","success"}),
	@Result(name="updateTch",type="json",params={"includeProperties","success"}),
	@Result(name="updateTchInfo",type="json",params={"includeProperties","success"}),
	@Result(name="queryTchById",type="json",params={"excludeProperties","success"}),
	@Result(name="queryTchesByOrgTitle",type="json",params={"excludeProperties","success"})
})
public class TeacherAction extends ActionSupport{

	private TeacherService tchService;
	private OrganizationService orgService;
	private String success;
	private Teacher tch;
	private String orgTitle;
	private int orgId;
	private int tchId;
	private String tchArray;
	private String tchOrg;
	private List tchesList;
	private String tchAbbr;
	private String tchImage;
	private String tchInfo;
	private String tchName;
	private String tchGender;
	private String tchDegree;
	private String tchTitle;
	private String tchEngInfo;



	@Action(value="tchAction")

	public String queryAllTches() {
		//查找所有的老师
		tchesList = tchService.queryAllTches();
		success = SUCCESS;
		return "queryAllTches";
	}
	
	public String queryFullTches(){
		//查找所有的教学老师
		tchesList = tchService.queryFullTches();
		success = SUCCESS;
		return "queryFullTches";
		
	}
	 public String queryTchesByAbbr(){
		 this.getTchAbbr();
		 tchesList = tchService.queryTchesByAbbr(tchAbbr);
		 return "queryTchesByAbbr";
	 }

	public String queryAllTchesByPage() {
		//this.getStart();
		//this.getLimit();
		//this.setTotalProperty(tchService.queryTchAmount());
		//this.tchesList = tchService.queryAllTchesByPage(start, limit);
		this.tchesList = tchService.queryAllTches();
		this.success = SUCCESS;
		return "queryAllTchesByPage";
	}

	public String queryTchById(){
		this.getTchId();
		tch = tchService.queryTchById(tchId);
		this.success = SUCCESS;
		System.out.println("queryTchById   id="+tchId);
		return "queryTchById";
	}

	public String queryTchesByOrgId(){
		this.getOrgId();
		tchesList = tchService.queryTchesByOrgId(orgId);
		this.success =SUCCESS;
		return "queryTchesByOrgId";
	}

	public String queryTchesByOrgTitle(){
		orgId = this.getOrgId();
		tchesList = tchService.queryTchesByOrgId(orgId);
		this.success = SUCCESS;
		return "queryTchesByOrgTitle";
	}

	public String addTch() {
		tch.getTchName();
		tch.getTchNumber();
		tch.getTchTitle();
		tch.getTchDegree();
		tch.getTchDuty();
		tch.getTchGender();
		tch.getTchOrgDuty();
		tch.setTchHomepage("#");
		tch.getTchAbbr();
		
		this.getTchOrg();
		System.out.println(this.getTchOrg());
		Organization orgT = orgService.queryOrgByName(this.getTchOrg());
		//tch.getOrg().add(orgT);
		tch.setOrg(orgT);
		System.out.println("newTch "+tch.toString());
		//修补 tchEngInfo sql 插入不得为空的 BUG
		tch.setTchEngInfo(tch.getTchEngInfo()==null?"":tch.getTchEngInfo());
		if(tchService.saveOrUpdateTch(tch)) {
			tchesList = tchService.queryTchesByAbbr(tch.getTchAbbr());
			if(tchesList.size()>1){
				System.out.println("教师列表有多大"+tchesList.size());
				int i =0;
				for(i=0;i<tchesList.size();i++){					
					Teacher it = (Teacher) tchesList.get(i);
					it.setPostAmount(tchesList.size()-1);
					tchService.saveOrUpdateTch(it);
					}
			}
			this.success = SUCCESS;
		}
		return "addTch";
	}

	public String deleteTch() {
		String stmp = this.getTchArray();
		stmp = stmp.substring(1,stmp.length()-1);
		JSONObject jsonObject = JSONObject.fromObject(stmp);
		Teacher tch = tchService.queryTch((Teacher) jsonObject.toBean(jsonObject, Teacher.class));
		if(tchService.deleteTch(tch)) {
			tchesList = tchService.queryTchesByAbbr(tch.getTchAbbr());
			if(tchesList.size()>0){
				System.out.println("教师列表有多大"+tchesList.size());
				int i =0;
				for(i=0;i<tchesList.size();i++){					
					Teacher it = (Teacher) tchesList.get(i);
					it.setPostAmount(tchesList.size()-1);
					tchService.saveOrUpdateTch(it);
					}
			}
			this.success = SUCCESS;
		}
		return "deleteTch";
	}

	public String updateTch() {
		String stmp = this.getTchArray();
		System.out.println("updateTch "+stmp);
		stmp = stmp.substring(1,stmp.length()-1);
		System.out.println("updateTch "+stmp);
		String[] sp = stmp.split("},");
		System.out.println("sp "+sp);
		
	
		for(int i = 0; i < sp.length; i++) {
			String ss = sp[i];
			System.out.println("ss    "+ss);
			if(ss.endsWith("}")){
				JSONObject jsonObject = JSONObject.fromObject(ss);
				
				Teacher tch =(Teacher) JSONObject.toBean(jsonObject, Teacher.class);
				
				Teacher t = tchService.queryTchById(tch.getTeacherId());
				t.setTchName(tch.getTchName());
				t.setTchNumber(tch.getTchNumber());
				t.setTchGender(tch.getTchGender());
				t.setTchDegree(tch.getTchDegree());
				t.setTchDuty(tch.getTchDuty());
				t.setTchTitle(tch.getTchTitle());
				t.setTchOrgDuty(tch.getTchOrgDuty());
				t.setOrg(orgService.queryOrgByName((String) jsonObject.get("tchOrg")));
				System.out.println("看看这个怎么办"+t.getOrg());
	
				tchService.saveOrUpdateTch(t);
			}
			else {
				ss = ss + "}";
				JSONObject jsonObject = JSONObject.fromObject(ss);
				Teacher tch = tchService.queryTch((Teacher) JSONObject.toBean(jsonObject, Teacher.class));
				System.out.println(tch);
				Teacher t = tchService.queryTchById(tch.getTeacherId());
				t.setTchName(tch.getTchName());
				t.setTchNumber(tch.getTchNumber());
				t.setTchGender(tch.getTchGender());
				t.setTchDegree(tch.getTchDegree());
				t.setTchDuty(tch.getTchDuty());
				t.setTchTitle(tch.getTchTitle());
				t.setTchOrgDuty(tch.getTchOrgDuty());
		
				t.setOrg(orgService.queryOrgByName((String) jsonObject.get("tchOrg")));
				tchService.saveOrUpdateTch(t);
			}
		}
		this.success = SUCCESS;
		return "updateTch";
	}
	
	public String updateTchInfo() {
		this.getTchId();
		System.out.println("更新 教师Id"+tchId);
		this.getTchImage();
		this.getTchInfo();
		this.getTchEngInfo();
		this.getTchGender();
		this.getTchName();
		this.getTchDegree();
		this.getTchTitle();


		Teacher t = tchService.queryTchById(tchId);

		tchesList = tchService.queryTchesByAbbr(t.getTchAbbr());
		int i=0;
		for(i=0;i<=t.getPostAmount();i++){
	
			Teacher it = (Teacher) tchesList.get(i);
			System.out.println("更新"+it.getTeacherId()+"号教师");
			it.setTchImage(tchImage);
			it.setTchInfo(tchInfo);
			it.setTchName(tchName);
			it.setTchGender(tchGender);
			it.setTchDegree(tchDegree);
			it.setTchTitle(tchTitle);
			it.setTchEngInfo(tchEngInfo);
			tchService.saveOrUpdateTch(it);
		}


		this.success = SUCCESS;
		return "updateTchInfo";
		
	}

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List getTchesList() {
		return tchesList;
	}
	public void setTchesList(List tchesList) {
		this.tchesList = tchesList;
	}

	public Teacher getTch() {
		return tch;
	}

	public void setTch(Teacher tch) {
		this.tch = tch;
	}

	public String getTchArray() {
		return tchArray;
	}

	public void setTchArray(String tchArray) {
		this.tchArray = tchArray;
	}
	public String getTchOrg() {
		return tchOrg;
	}

	public void setTchOrg(String tchOrg) {
		this.tchOrg = tchOrg;
	}

	public void setOrgTitle(String orgTitle) {
		this.orgTitle = orgTitle;
	}

	public String getOrgTitle() {
		return orgTitle;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getOrgId() {
		return orgId;
	}
	public String getTchAbbr() {
		return tchAbbr;
	}

	public void setTchAbbr(String tchAbbr) {
		this.tchAbbr = tchAbbr;
	}

	public int getTchId() {
		return tchId;
	}

	public void setTchId(int tchId) {
		this.tchId = tchId;
	}

	public String getTchImage() {
		return tchImage;
	}

	public void setTchImage(String tchImage) {
		this.tchImage = tchImage;
	}

	public String getTchInfo() {
		return tchInfo;
	}

	public void setTchInfo(String tchInfo) {
		this.tchInfo = tchInfo;
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

	public String getTchDegree() {
		return tchDegree;
	}

	public void setTchDegree(String tchDegree) {
		this.tchDegree = tchDegree;
	}

	public String getTchTitle() {
		return tchTitle;
	}

	public void setTchTitle(String tchTitle) {
		this.tchTitle = tchTitle;
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

	@Resource(name="tchService")
	public void setTchService(TeacherService tchService) {
		this.tchService = tchService;
	}
	@Resource(name="orgService")
	public void setOrgService(OrganizationService orgService) {
		this.orgService = orgService;
	}

}
