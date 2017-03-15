package neu.scweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import neu.scweb.po.Feature;
import neu.scweb.po.TreeNode;
import neu.scweb.service.FeatureService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value="struts-default")
@Results({
	@Result(location="jsp/menu.jsp")
	//@Result(name="querySectionFea",type="json",params={"excludeProperties","success"}),
	//@Result(name="querySysFea",type="json",params={"excludeProperties","success"})
})
public class FeaTreeAction extends ActionSupport{
	private FeatureService feaService;
	private String success;
	private TreeNode tNode;
	private List<Feature> featureList;
	private Feature feature;
	private List<TreeNode> menuList;
	private String menuString;

	@Action(value="feaTreeAction")

	public String queryNewsFea() {
		this.featureList = feaService.queryNewsFea();
		Iterator<Feature> it = featureList.iterator();
		menuList = new ArrayList<TreeNode>();
		//List<TreeNode> childList = new ArrayList<TreeNode>();
		//tNode = new TreeNode();
		//tNode.setLeaf(false);
		//tNode.setCls("folder");
		//tNode.setText("root");
		//tNode.setId(0);
		//menuList.add(tNode);
		//tNode.setChildren(childList);
		while(it.hasNext()) {
			feature = (Feature) it.next();
			tNode = new TreeNode();
			tNode.setId(feature.getFeatureId());
			tNode.setLeaf(true);
			tNode.setCls("file");
			tNode.setText(feature.getFeatureName());
			menuList.add(tNode);
		}
		JSONArray jsonObject = JSONArray.fromObject(menuList);
		try {
			menuString = jsonObject.toString();
		} catch (Exception e) {
			menuString = "error";
		}
		return "success";
	}

	public String querySectionFea() {
		this.featureList = feaService.querySectionFea();
		Iterator<Feature> it = featureList.iterator();
		menuList = new ArrayList<TreeNode>();
		//List<TreeNode> childList = new ArrayList<TreeNode>();
		//tNode = new TreeNode();
		//tNode.setLeaf(false);
		//tNode.setCls("folder");
		//tNode.setText("root");
		//tNode.setId(0);
		//menuList.add(tNode);
		//tNode.setChildren(childList);
		while(it.hasNext()) {
			feature = (Feature) it.next();
			tNode = new TreeNode();
			tNode.setId(feature.getFeatureId());
			tNode.setLeaf(true);
			tNode.setCls("file");
			tNode.setText(feature.getFeatureName());
			menuList.add(tNode);
		}
		JSONArray jsonObject = JSONArray.fromObject(menuList);
		try {
			menuString = jsonObject.toString();
		} catch (Exception e) {
			menuString = "error";
		}
		return "success";
	}

	public String querySysFea() {
		this.featureList = feaService.querySysFea();
		Iterator<Feature> it = featureList.iterator();
		menuList = new ArrayList<TreeNode>();
		//List<TreeNode> childList = new ArrayList<TreeNode>();
		//tNode = new TreeNode();
		//tNode.setLeaf(false);
		//tNode.setCls("folder");
		//tNode.setText("root");
		//tNode.setId(0);
		//menuList.add(tNode);
		//tNode.setChildren(childList);
		while(it.hasNext()) {
			feature = (Feature) it.next();
			tNode = new TreeNode();
			tNode.setId(feature.getFeatureId());
			tNode.setLeaf(true);
			tNode.setCls("file");
			tNode.setText(feature.getFeatureName());
			menuList.add(tNode);
		}
		JSONArray jsonObject = JSONArray.fromObject(menuList);
		try {
			menuString = jsonObject.toString();
		} catch (Exception e) {
			menuString = "error";
		}
		return "success";
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List getFeatureList() {
		return featureList;
	}

	public void setFeatureList(List featureList) {
		this.featureList = featureList;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public String getMenuString() {
		return menuString;
	}

	public void setMenuString(String menuString) {
		this.menuString = menuString;
	}

	@Resource(name="featureService")
	public void setFeaService(FeatureService feaService) {
		this.feaService = feaService;
	}
}
