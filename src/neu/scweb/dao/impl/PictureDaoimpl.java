package neu.scweb.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.PictureDao;
import neu.scweb.po.Picture;
import neu.scweb.util.BaseDao;


@Component(value="pictureDao")
public class PictureDaoimpl implements PictureDao {

	private BaseDao baseDao;
	
	@Override
	public List<Picture> queryAllPictures() {
		return  baseDao.listAll("Picture");
	}

	@Override
	public List<Picture> queryAllPicturesByPage(int start, int limit) {
		return baseDao.queryPage("from Picture", start, limit);
	}

	@Override
	public List<Picture> queryAllPicturesByNewsID(int newsId) {
		return (List<Picture>) baseDao.loadObject("from Picture where newsId=" +newsId + " and is_del = 1");	
	}

	@Override
	public int queryPictureAmount() {
		return baseDao.listAll("Picture").size();
	}


	@Override
	public Picture queryIndexPictureByName(Picture picture) {
		return (Picture) baseDao.loadObject("from Picture where newsId=" + picture.getNewsId() + " and isIndexPic =1  and isContentPic =" + picture.getIsContentPic() + " and isDel = 1");
		
//		return null;
	}
	@Override
	public Picture queryPicture(Picture picture) {
		return (Picture) baseDao.loadObject("from Picture where newsId=" + picture.getNewsId() 
		+ " and isIndexPic =" + picture.getIsIndexPic() +  " and isContentPic =" + picture.getIsContentPic() + " and picPath ='" + picture.getPicPath() + "' and isDel = 1");
		
	}

	@Override
	public Picture queryPictureByName(String picName) {
		return (Picture) baseDao.loadObject("from Picture where picName='"+ picName +"'");
	}

	@Override
	public boolean updatePicture(Picture picture) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(picture);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean addPicture(Picture picture) {
		boolean state=false;
		try {
			baseDao.saveOrUpdate(picture);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean deletePicture(Picture picture) {
		boolean state=false;
		try {
			picture.setIsDel(0);
			baseDao.saveOrUpdate(picture);
			state=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}



	@Resource(name="baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}
