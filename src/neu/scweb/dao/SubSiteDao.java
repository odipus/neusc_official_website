package neu.scweb.dao;

import java.util.List;

import neu.scweb.po.SubSite;

public interface SubSiteDao {
	public boolean saveOrUpdateSubSite(SubSite subSite);

	public boolean deleteSubSite(SubSite subSite);
	//public boolean deleteRelSubSite(SubSite subSite);

	public List<SubSite> querySubSiteByRole(int roleId);
	public boolean updateSubSite(SubSite subSite);
	public SubSite querySubSite(int roleId, String subSiteName, String subSiteCode);
	public SubSite querySubSiteByCode(String subSiteCode);
	public SubSite querySubSiteByName(String subSiteName);
}
