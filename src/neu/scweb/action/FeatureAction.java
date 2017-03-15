package neu.scweb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import net.sf.json.JSONArray;
import neu.scweb.po.Feature;
import neu.scweb.po.TreeNode;
import neu.scweb.service.FeatureService;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage(value="json-default")
@Results({
	@Result(name="queryNewsFea",type="json",params={"includeProperties","menuString"}),
	@Result(name="querySectionFea",type="json",params={"excludeProperties","success"}),
	@Result(name="querySysFea",type="json",params={"excludeProperties","success"})
})
public class FeatureAction extends ActionSupport{
	
	private FeatureService feaService;
	private String success;
	private TreeNode tNode;
	private List<Feature> featureList;
	private Feature feature;
	private List<TreeNode> menuList;
	private String menuString;
	
	@Action(value="featureAction")
	
	public String queryNewsFea() {
		this.featureList = feaService.queryNewsFea();
		Iterator<Feature> it = featureList.iterator();
		menuList = new ArrayList<TreeNode>(); 
		List<TreeNode> childList = new ArrayList<TreeNode>();
		tNode = new TreeNode();
		tNode.setLeaf(false);
		tNode.setCls("folder");
		tNode.setText("root");
		tNode.setId(0);
		menuList.add(tNode);
		//tNode.setChildren(childList);
		while(it.hasNext()) {
			feature = (Feature) it.next();
			tNode = new TreeNode();
			tNode.setId(feature.getFeatureId());
			tNode.setLeaf(true);
			tNode.setCls("file");
			tNode.setText(feature.getFeatureName());
			childList.add(tNode);
		}
		JSONArray jsonObject = JSONArray.fromObject(menuList);
		try {
			menuString = jsonObject.toString();
		} catch (Exception e) {
			menuString = "error";
		}
		return "queryNewsFea";
	}

	public String querySectionFea() {
		this.featureList = feaService.querySectionFea();
		return "querySectionFea";
	}

	public String querySysFea() {
		this.featureList = feaService.querySysFea();
		return "querySysFea";
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
