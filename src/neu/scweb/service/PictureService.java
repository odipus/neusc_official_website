package neu.scweb.service;

import java.util.List;

import neu.scweb.po.Picture;

public interface PictureService {
	public List<Picture> queryAllPictures();

	public List<Picture> queryAllPicturesByPage(int start, int limit);

	public List<Picture> queryAllPicturesByNewsID(int newsId);

	public int queryPictureAmount();

	public Picture queryPicture(Picture picture);

	public Picture queryPictureByName(String picName);

	public Picture queryIndexPictureByName(Picture picture);

	public boolean updatePicture(Picture picture);

	public boolean addPicture(Picture picture);

	public boolean deletePicture(Picture picture);

}
