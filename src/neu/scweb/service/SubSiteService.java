package neu.scweb.service;

import java.util.List;

import neu.scweb.po.SubNews;
import neu.scweb.po.SubSite;

public interface SubSiteService {
	public boolean saveOrUpdateSubSite(SubSite subSite);
	public SubSite querySubSiteByName(String subSiteName);
	public List<SubSite> querySubSiteByRole(int roleId);
	public boolean deleteSubSite(SubSite subSite);
	public SubSite querySubSite(int roleId, String subSiteName, String subSiteCode);
	public boolean updateSubSite(SubSite subSite);
	public SubSite querySubSiteByCode(String subSiteCode);

}
