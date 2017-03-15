package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.Organization;

public interface OrganizationDao {
	public List<Organization> queryAllOrgs();
	public boolean saveOrUpdateOrg(Organization org);
	public boolean deleteOrg(Organization org);
	public boolean updateOrg(Organization org);
	public Organization queryOrgById(int orgId);
	public Organization queryOrgByName(String orgName);
	public List<Organization> queryAllOrgsByPage(int start, int limit);
	public int queryOrgAmount();
	public List querySubOrg();
	public List<Organization> queryAllTchOrgs();
}
