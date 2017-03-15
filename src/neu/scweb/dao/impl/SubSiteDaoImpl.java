package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.SubSiteDao;
import neu.scweb.po.SubSite;
import neu.scweb.util.BaseDao;

@Component(value="subSiteDao")
public class SubSiteDaoImpl implements SubSiteDao {

	private BaseDao baseDao;

	public boolean saveOrUpdateSubSite(SubSite subSite) {
		boolean state = false;
		try {
			baseDao.saveOrUpdate(subSite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public SubSite querySubSiteByName(String subSiteName) {
		return (SubSite) baseDao.loadObject("from SubSite where subSiteName='"+ subSiteName +"'");
	}

	public List<SubSite> querySubSiteByRole(int roleId) {
		return baseDao.query("select subSite from Role r join r.subSites subSite where r.roleId=" + roleId);
	}

	public boolean deleteSubSite(SubSite subSite) {
		boolean state = false;
		try {
			baseDao.delete(subSite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public SubSite querySubSite(int roleId, String subSiteName, String subSiteCode) {
		return (SubSite) baseDao.loadObject("from SubSite where subSiteName='"+ subSiteName +"' and subSiteCode='"+ subSiteCode +"' and subSite_roleId="+roleId);
	}


	public boolean updateSubSite(SubSite subSite) {
		boolean state = false;
		try {
			baseDao.update(subSite);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public SubSite querySubSiteByCode(String subSiteCode) {
		return (SubSite) baseDao.loadObject("from SubSite where subSiteCode='"+ subSiteCode +"'");
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


}
