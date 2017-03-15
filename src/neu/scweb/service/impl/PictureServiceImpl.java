package neu.scweb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import neu.scweb.dao.PictureDao;
import neu.scweb.po.Picture;
import neu.scweb.service.PictureService;

@Component(value = "pictureService")
public class PictureServiceImpl implements PictureService {
	
	private PictureDao pictureDao;

	@Override
	public List<Picture> queryAllPictures() {
		return pictureDao.queryAllPictures();
	}

	@Override
	public List<Picture> queryAllPicturesByPage(int start, int limit) {
		return pictureDao.queryAllPicturesByPage(start, limit);
	}

	@Override
	public List<Picture> queryAllPicturesByNewsID(int newsId) {
		return pictureDao.queryAllPicturesByNewsID(newsId);
	}

	@Override
	public int queryPictureAmount() {
		return pictureDao.queryPictureAmount();
	}

	@Override
	public Picture queryPicture(Picture picture) {
		return pictureDao.queryPicture(picture);
	}

	@Override
	public Picture queryPictureByName(String picName) {
		return pictureDao.queryPictureByName(picName);
	}

	@Override
	public Picture queryIndexPictureByName(Picture picture) {
		return pictureDao.queryIndexPictureByName(picture);
	}

	@Override
	public boolean updatePicture(Picture picture) {
		return pictureDao.updatePicture(picture);
	}

	@Override
	public boolean addPicture(Picture picture) {
		picture.setIsDel(1);
		return pictureDao.addPicture(picture);
	}

	@Override
	public boolean deletePicture(Picture picture) {
		return pictureDao.deletePicture(picture);
	}

	@Resource(name = "pictureDao")
	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	
	
}
