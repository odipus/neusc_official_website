package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.OrganizationDao;
import neu.scweb.po.Organization;
import neu.scweb.util.BaseDao;

@Component(value="orgDao")
public class OrganizationDaoImpl implements OrganizationDao {

	private BaseDao baseDao;

	public List<Organization> queryAllOrgs() {
		return baseDao.listAll("Organization");
	}


	public List<Organization> queryAllTchOrgs() {
		return baseDao.query("from Organization where subSite=1");
	}
	
	public List<Organization> queryAllOrgsByPage(int start, int limit) {
		return baseDao.queryPage("from Organization", start, limit);
	}

	public int queryOrgAmount() {
		return baseDao.listAll("Organization").size();
	}

	public Organization queryOrgById(int orgId){
		return (Organization) baseDao.loadObject("from Organization where orgId=" + orgId);
	}

	public boolean saveOrUpdateOrg(Organization org) {
		boolean state = false;
		try {
			baseDao.saveOrUpdate(org);
			state = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean deleteOrg(Organization org) {
		boolean state=false;
		try {
			baseDao.delete(org);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public boolean updateOrg(Organization org) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(org);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	public Organization queryOrgByName(String orgName) {
		return (Organization) baseDao.loadObject("from Organization where orgName='" + orgName +"'");
	}

	public List querySubOrg() {
		return baseDao.query("from Organization where subSite=1");
	}

	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}



}
