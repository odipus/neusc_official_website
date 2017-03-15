package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.OrganizationDao;
import neu.scweb.po.Organization;
import neu.scweb.service.OrganizationService;

@Component(value="orgService")
public class OrganizationServiceImpl implements OrganizationService{

	private OrganizationDao orgDao;

	public List<Organization> queryAllOrgs() {
		return orgDao.queryAllOrgs();
	}

	public List<Organization> queryAllTchOrgs() {
		return orgDao.queryAllTchOrgs();
	}
	
	public boolean saveOrUpdateOrg(Organization org) {
		return orgDao.saveOrUpdateOrg(org);
	}

	public boolean deleteOrg(Organization org) {
		return orgDao.deleteOrg(org);
	}

	public boolean updateOrg(Organization org) {
		return orgDao.updateOrg(org);
	}

	public Organization queryOrgByName(String orgName) {
		return orgDao.queryOrgByName(orgName);
	}

	public Organization queryOrgById(int orgId) {

		return orgDao.queryOrgById(orgId);
	}

	public List<Organization> queryAllOrgsByPage(int start, int limit) {
		return orgDao.queryAllOrgsByPage(start, limit);
	}

	public int queryOrgAmount() {
		return orgDao.queryOrgAmount();
	}

	public List querySubOrg() {
		return orgDao.querySubOrg();
	}

	@Resource(name="orgDao")
	public void setOrgDao(OrganizationDao orgDao) {
		this.orgDao = orgDao;
	}




}
