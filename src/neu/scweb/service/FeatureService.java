package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Feature;

public interface FeatureService {
	public List<Feature> queryNewsFea();
	public List<Feature> querySectionFea();
	public List<Feature> querySysFea();
	public List<Feature> queryAllFeas();
	public List<Feature> queryFeaByModId(int modId);
}
