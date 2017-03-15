package neu.scweb.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import neu.scweb.dao.FeatureDao;
import neu.scweb.po.Feature;
import neu.scweb.service.FeatureService;

@Component(value="featureService")
public class FeatureServiceImpl implements FeatureService {

	private FeatureDao featureDao;

	public List<Feature> queryNewsFea() {
		return featureDao.queryNewsFea();
	}

	public List<Feature> querySectionFea() {
		return featureDao.querySectionFea();
	}

	public List<Feature> querySysFea() {
		return featureDao.querySysFea();
	}

	public List<Feature> queryAllFeas() {
		return featureDao.queryAllFeas();
	}

	public List<Feature> queryFeaByModId(int modId) {
		return featureDao.queryFeaByModId(modId);
	}

	@Resource(name="featureDao")
	public void setFeatureDao(FeatureDao featureDao) {
		this.featureDao = featureDao;
	}









}
