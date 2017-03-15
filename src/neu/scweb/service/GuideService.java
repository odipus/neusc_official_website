package neu.scweb.service;


import java.util.List;

import neu.scweb.po.Guide;

public interface GuideService {
	public List<Guide> queryGuidesByLevel(int guideLevel);
	public List<Guide> queryLowerGuides(int guideId);   //通过该目录的Id寻找其下级菜单
	public Guide queryGuideById(int guideId);
	public Guide queryGuideByTitle(String guideTitle);
	public List<Guide> queryAllGuides();
}
