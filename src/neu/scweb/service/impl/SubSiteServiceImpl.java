package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.SubSiteDao;
import neu.scweb.po.SubNews;
import neu.scweb.po.SubSite;
import neu.scweb.service.SubSiteService;

@Component(value="subSiteService")
public class SubSiteServiceImpl implements SubSiteService {

	private SubSiteDao subSiteDao;

	public boolean saveOrUpdateSubSite(SubSite subSite) {
		return subSiteDao.saveOrUpdateSubSite(subSite);
	}

	public SubSite querySubSiteByName(String subSiteName) {
		return subSiteDao.querySubSiteByName(subSiteName);
	}

	public List<SubSite> querySubSiteByRole(int roleId) {
		return subSiteDao.querySubSiteByRole(roleId);
	}

	public boolean deleteSubSite(SubSite subSite) {
		return subSiteDao.deleteSubSite(subSite);
	}

	public SubSite querySubSite(int roleId, String subSiteName, String subSiteCode) {
		return subSiteDao.querySubSite(roleId, subSiteName, subSiteCode);
	}

	public boolean updateSubSite(SubSite subSite) {
		return subSiteDao.updateSubSite(subSite);
	}

	public SubSite querySubSiteByCode(String subSiteCode) {
		return subSiteDao.querySubSiteByCode(subSiteCode);
	}

	@Resource(name="subSiteDao")
	public void setSubSiteDao(SubSiteDao subSiteDao) {
		this.subSiteDao = subSiteDao;
	}



}
